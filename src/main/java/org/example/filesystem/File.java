package org.example.filesystem;

import java.util.Collections;
import java.util.List;

public class File extends AbstractFileSystem{

    String extension;
    String content;

    public File(String fileName) {
        super(fileName);
        this.extension = fileName.split("\\.")[1];
        content = "";
    }


    @Override
    public List<String> ls() {
        System.out.println("Not a directory");
        return Collections.emptyList();
    }

    @Override
    public void mkdir(String path) {
        System.out.println("Not a directory");
    }

    @Override
    public void touch(String fileName) {
        System.out.println("Not a directory");
    }

    @Override
    public String cat(String path) {
        return content;
    }

    @Override
    public void echo(String content) {
        this.content += content;
    }

    @Override
    public void rm(String path) {
        System.out.println("Not a directory");
    }
}
