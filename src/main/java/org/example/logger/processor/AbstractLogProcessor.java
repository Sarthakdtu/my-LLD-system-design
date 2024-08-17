package org.example.logger.processor;

import org.example.logger.sink.Sink;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractLogProcessor {

    private AbstractLogProcessor nextLogProcessor;
    private List<Sink> sinkList;

    protected LogLevel level = null;

    AbstractLogProcessor(AbstractLogProcessor nextLogProcessor) {
       this.nextLogProcessor = nextLogProcessor;
       sinkList = new ArrayList<>();
    }

    public void addSink(Sink sink) {
        if(nextLogProcessor != null) {
            nextLogProcessor.addSink(sink);
        }
        this.sinkList.add(sink);
    }

    public void log(String message, LogLevel logLevel) {
        if(logLevel == level) {
            logMessageToSinks(message);
        }
        else if(nextLogProcessor != null) {
            nextLogProcessor.log(message,logLevel);
        }
    }

    protected void logMessageToSinks(String message) {
        for(Sink sink : sinkList) {
            sink.writeToSink(level.toString() + ": " + message);
        }
    }
}
