package com.tokopedia.core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericPageObject extends TokopediaConstants {
    private String iframe = "//iframe[contains(@id,'iframe')]";

    public void swithToIframe() {
        WebDriverWait wait = new WebDriverWait(driver, MEDIUM_TIMEOUT_SEC);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(iframe)));
        driver.switchTo().frame(element);
        /*wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));*/
    }

    public void switchToDefaultContent() {

        driver.switchTo().defaultContent();
    }

    public void waitForElementText(String locator, String textToBeEntered) {
        WebDriverWait wait = new WebDriverWait(driver, MEDIUM_TIMEOUT_SEC);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        element.sendKeys(textToBeEntered);
    }

    public void waitForElementTextByID(String ID, String textToBeEntered) {
        WebDriverWait wait = new WebDriverWait(driver, MEDIUM_TIMEOUT_SEC);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(ID)));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        String script = "document.getElementById('" + ID + "').setAttribute('value', '" + textToBeEntered + "')";
        executor.executeScript(script, element);
    }

    public  void waitForElementClick(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, MEDIUM_TIMEOUT_SEC);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        element.click();
    }

    public  void waitForElementDoubleClick(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, MEDIUM_TIMEOUT_SEC);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        element.click();
        element.click();
    }

    public void waitForElementClickJS(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, MEDIUM_TIMEOUT_SEC);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public String getText(String locator) {

        return driver.findElement(By.xpath(locator)).getText();
    }

}