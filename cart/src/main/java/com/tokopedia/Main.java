package com.tokopedia;

import com.tokopedia.helpers.PropertiesHelper;

public class Main {
    public Main(){
        ClassLoader classLoader = getClass().getClassLoader();
        PropertiesHelper helper = new PropertiesHelper();
        String tkpdUrl = helper.getValue("tkpd.url");
        System.out.println(tkpdUrl);
    }

    public static void main(String[] args){
        new Main();
    }
}
