package org.example.logger.processor;

public class LogProcessorFactory {
    private static LogProcessorFactory instance;
    private static FatalLogProcessor fatalLogProcessor;
    private static ErrorLogProcessor errorLogProcessor;
    private static WarnLogProcessor warnLogProcessor;
    private static InfoLogProcessor infoLogProcessor;
    private static DebugLogProcessor debugLogProcessor;


    public static LogProcessorFactory getInstance() {
        if(instance == null) {
            instance = new LogProcessorFactory();
            initialize();
        }
        return instance;
    }

    private static void initialize() {
        fatalLogProcessor = new FatalLogProcessor(null);
        errorLogProcessor = new ErrorLogProcessor(fatalLogProcessor);
        warnLogProcessor = new WarnLogProcessor(errorLogProcessor);
        infoLogProcessor = new InfoLogProcessor(warnLogProcessor);
        debugLogProcessor = new DebugLogProcessor(infoLogProcessor);
    }

    private LogProcessorFactory() {}

    public AbstractLogProcessor getLogProcessorForLevel(LogLevel level) {
        switch (level) {
            case DEBUG:{
                return debugLogProcessor;
            }

            case INFO:{
                return infoLogProcessor;
            }

            case WARN:{
                return warnLogProcessor;
            }

            case ERROR:{
                return errorLogProcessor;
            }

            case FATAL:{
                return fatalLogProcessor;
            }
        }
        return null;
    }
}
