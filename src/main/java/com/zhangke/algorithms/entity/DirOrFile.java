package com.zhangke.algorithms.entity;

public class DirOrFile {

    private boolean isFile;
    private String name;

    public DirOrFile(String name) {
        this.isFile = false;
        this.name = name;
    }

    public DirOrFile(boolean isFile, String name) {
        this.isFile = isFile;
        this.name = name;
    }

    public boolean isFile() {
        return isFile;
    }

    public void setFile(boolean file) {
        isFile = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
