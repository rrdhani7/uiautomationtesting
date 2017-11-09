package com.tokopedia.helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHelper {
    private InputStream propertiesInput = null;
    private Properties globalProperties = new Properties();
    private String propertiesFileLocation = "/home/nakama/cart/src/main/resources/configuration.properties";

    public PropertiesHelper() {
        try {
            this.propertiesInput = new FileInputStream(propertiesFileLocation);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        this.loadPropertiesFile();
    }

    private void loadPropertiesFile(){
        if(this.propertiesInput != null){
            try{
                this.globalProperties.load(this.propertiesInput);
            }catch(IOException ioex){
                ioex.printStackTrace();
            }
        }
    }

    public String getValue(String key){
        return this.globalProperties != null ? this.globalProperties.getProperty(key) : "";
    }
}
