package org.example.logger.processor;


public class ErrorLogProcessor extends AbstractLogProcessor {

    ErrorLogProcessor(AbstractLogProcessor nextLogProcessor) {
        super(nextLogProcessor);
        this.level = LogLevel.ERROR;
    }

    @Override
    public void log(String message, LogLevel logLevel) {
        super.log(message, logLevel);
    }
}
