package org.example.filesystem;

import java.util.List;
import java.util.Map;

public abstract class AbstractFileSystem implements FileSystem{

    private String name;

    public AbstractFileSystem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public List<String> ls() {
        return null;
    }

    @Override
    public void mkdir(String path) {

    }

    @Override
    public void touch(String fileName) {

    }

    @Override
    public String cat(String path) {
        return null;
    }

    @Override
    public void echo(String content) {

    }

    @Override
    public void rm(String path) {

    }
}
