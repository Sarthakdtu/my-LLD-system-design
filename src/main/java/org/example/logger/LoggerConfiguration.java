package org.example.logger;

import org.example.logger.processor.LogLevel;
import org.example.logger.sink.SinkFactory;
import org.example.logger.sink.SinkType;

import java.util.*;

public class LoggerConfiguration {
    private Map<LogLevel, Set<SinkType>> levelToSinkMap;

    public LoggerConfiguration() {
        levelToSinkMap = new HashMap<>();
    }

    public void addLogLevelsForSink(SinkType sink, LogLevel level, Map<String, String> properties) {
        SinkFactory.getInstance().getSinkForSinkType(sink).setProperties(properties);
        addSinkForLogLevel(sink, level);
    }

    private void addSinkForLogLevel(SinkType sink, LogLevel logLevel) {
        if(!levelToSinkMap.containsKey(logLevel)){
            levelToSinkMap.put(logLevel, new HashSet<>());
        }
        levelToSinkMap.get(logLevel).add(sink);
    }

    public Map<LogLevel, Set<SinkType>> getLevelToSinkMap() {
        return levelToSinkMap;
    }
}
