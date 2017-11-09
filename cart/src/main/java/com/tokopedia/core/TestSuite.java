package com.tokopedia.core;

import java.io.File;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestSuite extends TokopediaConstants{

    private static String DRIVER_PATH = "/home/nakama/App/firefox/firefox";

    @BeforeTest
    public void launchBrowser() throws Exception{
        String url = getValueProperty("tkpd.url");
        driver = getMyFirefoxDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterTest(alwaysRun = true)
    public void quitBrowser() {
        driver.quit();
    }

    public void switchToLite() throws Exception {
        String url = "https://m.tokopedia.com/";
        driver.get(url);
    }

    public static FirefoxDriver getMyFirefoxDriver(){
        File file = new File(DRIVER_PATH);
        FirefoxBinary ffBinary = new FirefoxBinary(file);
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        FirefoxDriver driver = new FirefoxDriver(ffBinary,firefoxProfile);
        return driver;
    }

}