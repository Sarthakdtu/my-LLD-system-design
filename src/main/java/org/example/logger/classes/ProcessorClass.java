package org.example.logger.classes;

import org.example.logger.Logger;

public abstract class ProcessorClass {
    private static Logger logger = Logger.getLogger();
    public void process() {
        logger.debug(this.getClass().getName(), "I am running");
        logger.info(this.getClass().getName(), "I am running");
        logger.warn(this.getClass().getName(), "I am running");
        logger.error(this.getClass().getName(), "Oh nooooo");
        logger.fatal(this.getClass().getName(), "I am running");
    }
}
