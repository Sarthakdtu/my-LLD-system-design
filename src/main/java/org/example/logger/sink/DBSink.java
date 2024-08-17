package org.example.logger.sink;

import java.util.Map;

public class DBSink implements Sink{

    private String dbUrl;
    private String port;
    private String DB_URL = "db_url";
    private String PORT = "port";

    public DBSink(){
    }

    private void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    private void setPort(String port) {
        this.port = port;
    }

    @Override
    public void writeToSink(String message) {
        connectToDB(dbUrl, port);
        System.out.println("DB: " + message);
    }

    @Override
    public void setProperties(Map<String, String> properties) {
        setDbUrl(properties.getOrDefault(DB_URL, null));
        setPort(properties.getOrDefault(PORT, null));
    }


    private void connectToDB(String dbUrl, String port) {
        //conenctToDB
    }
}
