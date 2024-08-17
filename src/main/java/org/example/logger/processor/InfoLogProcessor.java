package org.example.logger.processor;


public class InfoLogProcessor extends AbstractLogProcessor {

    InfoLogProcessor(AbstractLogProcessor nextLogProcessor) {
        super(nextLogProcessor);
        this.level = LogLevel.INFO;
    }

    @Override
    public void log(String message, LogLevel logLevel) {
        super.log(message, logLevel);
    }
}
