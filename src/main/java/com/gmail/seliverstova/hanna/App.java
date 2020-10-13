package com.gmail.seliverstova.hanna;

import java.io.File;
import java.io.IOException;

public class App {
    public static void main( String[] args ) {
        CustomFileFilter ff = new CustomFileFilter("docx");
        File source = new File("from");
        File receiver = new File("to");

        try {
            FileOperation.folderCopy(ff, source, receiver);
        } catch (IllegalArgumentException | IOException e) {
            e.printStackTrace();
        }
    }
}
