package com.gmail.seliverstova.hanna;

import java.io.*;

public class FileOperation {
    public static void fileCopy(File source, File receiver) throws IOException {
        byte[] buffer = new byte[1024*1024]; //магабайт
        int readByte = 0;
        try (FileInputStream fis = new FileInputStream(source); FileOutputStream fos = new FileOutputStream(receiver)) {
            for (;(readByte = fis.read(buffer)) > 0;) {
                fos.write(buffer, 0, readByte);
            }
        } catch (IOException e) {
            throw e;
        }
    }

    public static void folderCopy(FileFilter ff, File source, File receiver) throws IOException, IllegalArgumentException {
        if ((ff == null) || (source == null) || (receiver == null)) {
            throw new IllegalArgumentException("At least one of the arguments is null");
        }
        File[] fileList = source.listFiles(ff);
        for (File file: fileList) {
            fileCopy(file, new File(receiver, file.getName()));
        }
    }

    public static long calculateFolderSize(File folder) {
        if (folder.isFile()) {
            return folder.length();
        }
        long size = 0;
        File[] fileList = folder.listFiles();
        for (int i = 0; i < fileList.length; i++) {
            size += calculateFolderSize(fileList[i]);
        }
        return size;
    }
}
