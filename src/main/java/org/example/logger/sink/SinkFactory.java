package org.example.logger.sink;

import org.example.logger.*;

public class SinkFactory {
    private static SinkFactory instance;
    private static FileSink fileSink;
    private static DBSink dbSink;
    private static ConsoleSink consoleSink;


    public static SinkFactory getInstance() {
        if(instance == null) {
            instance = new SinkFactory();
            initialize();
        }
        return instance;
    }

    private static void initialize() {
        fileSink = new FileSink();
        dbSink = new DBSink();
        consoleSink = new ConsoleSink();
    }

    private SinkFactory() {}

    public Sink getSinkForSinkType(SinkType sink) {
        switch (sink) {
            case FILE:{
                return fileSink;
            }
            case DB:{
                return dbSink;
            }
            case CONSOLE:{
                return consoleSink;
            }
        }
        return null;
    }
}
