package org.example.logger.processor;


public class WarnLogProcessor extends AbstractLogProcessor {

    WarnLogProcessor(AbstractLogProcessor nextLogProcessor) {
        super(nextLogProcessor);
        this.level = LogLevel.WARN;
    }

    @Override
    public void log(String message, LogLevel logLevel) {
        super.log(message, logLevel);
    }
}
