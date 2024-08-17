package org.example.logger.processor;

public enum LogLevel {

    INFO(4), DEBUG(5), WARN(3), ERROR(2), FATAL(1);

    private int val;

    LogLevel(int val){
        this.val = val;
    }
}
