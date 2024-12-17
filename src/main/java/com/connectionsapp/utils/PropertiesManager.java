package com.connectionsapp.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {
    public static Properties loadConfig(){
        Properties props = new Properties();
        try(FileInputStream fileInputStream = new FileInputStream("config/properties.config")) {
            props.load(fileInputStream);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return props;

    }
}
