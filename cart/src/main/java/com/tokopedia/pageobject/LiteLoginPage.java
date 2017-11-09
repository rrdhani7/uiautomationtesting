package com.tokopedia.pageobject;

import com.tokopedia.core.GenericPageObject;
import org.openqa.selenium.support.PageFactory;

public class LiteLoginPage extends GenericPageObject {
    private String emailField = "//input[@id='email']";
    private String passwordField = "//input[@id='password']";
    private String loginButton = "//button[@id='email_btn']";
    private String welcomingWord = "//*[.='Masuk ke Tokopedia']";

    public LiteLoginPage enterEmailUser(String emailUser) {
        waitForElementText(emailField, emailUser);
        return this;
    }

    public LiteLoginPage enterPasswordUser(String passwordUser) {
        waitForElementText(passwordField, passwordUser);
        return this;
    }

    public LiteLoginPage clickLogin() {
        waitForElementClick(loginButton);
        return this;
    }

    public LiteHomePage loginUser(String emailUser, String passwordUser) {
        if(isElementPresent(welcomingWord, SHORT_TIMEOUT_INTERVAL)) {
            enterEmailUser(emailUser);
            enterPasswordUser(passwordUser);
            clickLogin();
        }
        isEqual("Login failed", isElementNotPresent(welcomingWord), true);
        return PageFactory.initElements(driver, LiteHomePage.class);
    }

}