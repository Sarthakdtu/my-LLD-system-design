package org.example.filesystem;

import java.util.List;

public interface FileSystem {
    List<String> ls();
    void mkdir(String path);
    void touch(String fileName);
    String cat(String path);
    void echo(String content);
    void rm(String path);
}
