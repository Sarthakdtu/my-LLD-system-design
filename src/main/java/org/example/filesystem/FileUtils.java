package org.example.filesystem;

import java.util.Arrays;
import java.util.List;

public class FileUtils {

    public static List<String> parsePathForDirectory(String path) {
        List<String> listDirs = Arrays.asList(path.split("/"));
        if(listDirs.size() != 0 && listDirs.get(listDirs.size()-1).contains(".")){
            listDirs.remove(listDirs.get(listDirs.size()-1));
        }
        return listDirs;
    }

    public static String parseFileNameFromPath(String path) {
        List<String> listDirs = Arrays.asList(path.split("/"));
        if(listDirs.size() != 0 && !listDirs.get(listDirs.size()-1).contains(".")){
            return null;
        }
        return listDirs.get(listDirs.size() - 1);
    }
}
