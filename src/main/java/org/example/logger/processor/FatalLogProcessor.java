package org.example.logger.processor;


public class FatalLogProcessor extends AbstractLogProcessor {

    FatalLogProcessor(AbstractLogProcessor nextLogProcessor) {
        super(nextLogProcessor);
        this.level = LogLevel.FATAL;
    }

    @Override
    public void log(String message, LogLevel logLevel) {
        super.log(message, logLevel);
    }
}
