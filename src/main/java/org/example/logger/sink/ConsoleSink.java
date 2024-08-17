package org.example.logger.sink;

import java.util.Map;

public class ConsoleSink implements Sink{


    public ConsoleSink(){
    }

    @Override
    public void writeToSink(String message) {
        System.out.println("Console: " + message);
    }

    @Override
    public void setProperties(Map<String, String> properties) {

    }
}
