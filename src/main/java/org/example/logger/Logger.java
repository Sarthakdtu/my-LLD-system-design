package org.example.logger;

import org.example.logger.processor.LogLevel;
import org.example.logger.processor.LogProcessorFactory;
import org.example.logger.sink.SinkFactory;
import org.example.logger.sink.SinkType;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

public class Logger {

    private static Logger instance;

    private Logger(){}

    public static Logger getLogger() {
        if(instance == null) {
            instance = new Logger();
            initializeLoggerConfiguration();
        }
        return instance;
    }

    private static void initializeLoggerConfiguration() {
        System.out.println("Trying to load properties from somewhere else");
    }

    public void setLoggerConfiguration(LoggerConfiguration loggerConfiguration) {
        System.out.println("Resetting logger configuration");
        Map<LogLevel, Set<SinkType>> levelTosinkMapping = loggerConfiguration.getLevelToSinkMap();
        for(Map.Entry<LogLevel, Set<SinkType>> entry : levelTosinkMapping.entrySet()) {
            for (SinkType sinkType : entry.getValue()) {
                LogProcessorFactory.getInstance().getLogProcessorForLevel(entry.getKey()).addSink(
                        SinkFactory.getInstance().getSinkForSinkType(sinkType));

            }
        }
    }

    private String enrichMessage(String namespace, String message) {
        return LocalDateTime.now() + " : " + namespace + " - " + message;
    }

    public void info(String namespace, String message) {
        String enrichedMessage = enrichMessage(namespace, message);
        LogProcessorFactory.getInstance().getLogProcessorForLevel(LogLevel.INFO).log(enrichedMessage, LogLevel.INFO);
    }

    public void debug(String namespace, String message) {
        String enrichedMessage = enrichMessage(namespace, message);
        LogProcessorFactory.getInstance().getLogProcessorForLevel(LogLevel.DEBUG).log(enrichedMessage, LogLevel.DEBUG);
    }

    public void warn(String namespace, String message) {
        String enrichedMessage = enrichMessage(namespace, message);
        LogProcessorFactory.getInstance().getLogProcessorForLevel(LogLevel.WARN).log(enrichedMessage, LogLevel.WARN);
    }

    public void error(String namespace, String message) {
        String enrichedMessage = enrichMessage(namespace, message);
        LogProcessorFactory.getInstance().getLogProcessorForLevel(LogLevel.ERROR).log(enrichedMessage, LogLevel.ERROR);
    }

    public void fatal(String namespace, String message) {
        String enrichedMessage = enrichMessage(namespace, message);
        LogProcessorFactory.getInstance().getLogProcessorForLevel(LogLevel.FATAL).log(enrichedMessage, LogLevel.FATAL);
    }

}
