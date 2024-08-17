package org.example.logger.sink;

import java.util.Map;

public interface Sink {
    void writeToSink(String message);
    void setProperties(Map<String, String> properties);
}
