package com.gmail.seliverstova.hanna;

import java.io.File;
import java.io.FileFilter;

public class CustomFileFilter implements FileFilter {
    private String[] extArray;

    public CustomFileFilter(String... extArray) {
        super();
        this.extArray = extArray;
    }

    public CustomFileFilter() {
        super();
    }

    public String[] getExtArray() {
        return extArray;
    }

    public void setExtArray(String[] extArray) {
        this.extArray = extArray;
    }

    private boolean check(String ext) {
        for (String elem : extArray) {
            if (elem.equals(ext)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean accept(File pathname) {
        int index = pathname.getName().lastIndexOf(".");
        if (index == -1) {
            return false;
        }
        String ext = pathname.getName().substring(index + 1);
        return check(ext);
    }
}
