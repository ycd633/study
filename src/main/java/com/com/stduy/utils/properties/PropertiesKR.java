package com.com.stduy.utils.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesKR {

    private final Properties properties = new Properties();
    private static PropertiesKR _instance = new PropertiesKR();

    public static PropertiesKR getInstance(){
        return _instance;
    }

    public String getValue(String key) throws IOException {
        InputStream is = new FileInputStream("D:/devP/java_study/target/classes/test.properties");
        this.properties.load(is);
        return this.properties.getProperty(key);
    }
}
