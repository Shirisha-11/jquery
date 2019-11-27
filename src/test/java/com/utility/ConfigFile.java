package com.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFile
{
    File src;
    FileInputStream fis;
    Properties prop;

    public void loadPropertyFile() throws Exception
    {
        src = new File("./config.properties");
        fis = new FileInputStream(src);
        prop = new Properties();
        prop.load(fis);
    }

    public String getProperty(String propKey)
    {
        return prop.getProperty(propKey);
    }
}
