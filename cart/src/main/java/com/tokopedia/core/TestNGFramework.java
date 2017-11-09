package com.tokopedia.core;

import com.tokopedia.helpers.PropertiesHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static org.testng.Assert.fail;

public class TestNGFramework{
    public static TestNGFramework customVerify = new TestNGFramework();
    public static WebDriver driver;

    public String getValueProperty(String key) {
        PropertiesHelper prop = new PropertiesHelper();
        return prop.getValue(key);
    }

    public void isEqual(String errorMessage, String actualResult, String expectedResult) {
        try {
            Assert.assertEquals(actualResult, expectedResult, errorMessage);
        } catch (AssertionError e) {
            fail(errorMessage + ". Expected Reult: " + expectedResult + ". Actual Result: " + actualResult);
        }
    }

    public void isEqual(String errorMessage, boolean actualResult, boolean expectedResult) {
        try {
            Assert.assertEquals(actualResult, expectedResult, errorMessage);
        } catch (AssertionError e) {
            fail(errorMessage + ". Expected Reult: " + expectedResult + ". Actual Result: " + actualResult);
        }
    }

    public boolean isElementPresent(String locator, int timeOutInSecond) {
        boolean found = false;
        long initialTime = System.currentTimeMillis();
        do {
            found = driver.findElements(By.xpath(locator)).size() != 0;
            if(System.currentTimeMillis() - initialTime > (timeOutInSecond*1000))
                break;
        } while (!found);
        return found;
    }

    public boolean isElementNotPresent(String locator) {
        boolean notFound = true;
        long initialTime = System.currentTimeMillis();
        do {
            notFound = !(driver.findElements(By.xpath(locator)).size() != 0);
            if(System.currentTimeMillis() - initialTime > 10000) {
                notFound = false;
                break;
            }
        } while (!notFound);
        return notFound;
    }

    public void isFatal(String errorMessage) {

    }

    public void isTrue(String errorMessage, boolean actualResult) {

    }


}
