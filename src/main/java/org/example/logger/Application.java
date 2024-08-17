package org.example.logger;

import org.example.logger.classes.AvengersProcessor;
import org.example.logger.classes.JLProcessor;
import org.example.logger.processor.LogLevel;
import org.example.logger.sink.SinkType;

import java.util.HashMap;
import java.util.Map;

public class Application {

    public static void main(String[] args) {

        LoggerConfiguration loggerConfiguration = new LoggerConfiguration();
        Map<String, String> fileProperties = new HashMap<>();
        fileProperties.put("file_name", "some.txt");
        Map<String, String> dbProperties = new HashMap<>();
        dbProperties.put("db_url", "postgress://aws.post");
        dbProperties.put("port", "8080");
        //https://leetcode.com/discuss/interview-question/object-oriented-design/395160/object-oriented-design-for-logger-library-flipkart-oa-2019

        loggerConfiguration.addLogLevelsForSink(SinkType.FILE, LogLevel.DEBUG, fileProperties);
        loggerConfiguration.addLogLevelsForSink(SinkType.DB, LogLevel.WARN, dbProperties);
        loggerConfiguration.addLogLevelsForSink(SinkType.CONSOLE, LogLevel.ERROR, null);
        Logger.getLogger().setLoggerConfiguration(loggerConfiguration);

        AvengersProcessor avengersProcessor = new AvengersProcessor();
        avengersProcessor.process();
//        avengersProcessor.process();
        JLProcessor jlProcessor = new JLProcessor();
//        jlProcessor.process();
//        jlProcessor.process();

    }
}
