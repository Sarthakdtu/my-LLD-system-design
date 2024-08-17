package org.example.logger.sink;

import java.util.Map;

public class FileSink implements Sink{

    private String fileName;
    private String FILE_NAME = "FILE_NAME";

    public FileSink(){

    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void writeToSink(String message) {
        openFile(fileName);
        System.out.println("File: " + message);
    }

    @Override
    public void setProperties(Map<String, String> properties) {
        setFileName(properties.getOrDefault(FILE_NAME, null));
    }

    private void openFile(String fileName) {
        //open a file
    }
}
