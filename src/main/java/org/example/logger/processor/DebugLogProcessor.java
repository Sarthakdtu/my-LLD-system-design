package org.example.logger.processor;


public class DebugLogProcessor extends AbstractLogProcessor {

    DebugLogProcessor(AbstractLogProcessor nextLogProcessor) {
        super(nextLogProcessor);
        this.level = LogLevel.DEBUG;
    }

    @Override
    public void log(String message, LogLevel logLevel) {

        super.log(message, logLevel);
    }
}
