package org.example.filesystem;

import java.util.*;
import java.util.stream.Collectors;

public class Directory extends AbstractFileSystem{

    private List<AbstractFileSystem> fileSystems;

    private Map<String, AbstractFileSystem> directoryMap;

    public Directory(String name) {
        super(name);
        directoryMap = new HashMap<>();
        fileSystems = new ArrayList<>();
    }

    @Override
    public List<String> ls() {
        return (List<String>) fileSystems.stream().map(AbstractFileSystem::getName).collect(Collectors.toList()).stream().sorted();
    }

    @Override
    public void mkdir(String path) {
    }

    private FileSystem makeDir(List<String> directoryNames) {
        return null;
    }

    @Override
    public void touch(String fileName) {

    }

    @Override
    public String cat(String path) {
        System.out.println("Not a file");
        return "";
    }

    @Override
    public void echo(String content) {
        System.out.println("Not a file");
    }

    @Override
    public void rm(String path) {

    }
}
