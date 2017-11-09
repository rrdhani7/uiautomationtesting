package com.tokopedia.pageobject;

import com.tokopedia.core.GenericPageObject;

public class TokopediaHomePage extends GenericPageObject {
    private String loginButton = "//button[.='Masuk']";
    private String emailField = "//input[@id='inputEmail']";
    private String passwordField = "//input[@id='inputPassword']";
    private String submitAccount = "//button[@id='global_login_btn']";

    public TokopediaHomePage clickLogin() {
        waitForElementClick(loginButton);
        return this;
    }

    public TokopediaHomePage enterEmail(String emailUser) {
        swithToIframe();
        waitForElementText(emailField, emailUser);
        switchToDefaultContent();
        return this;
    }

    public TokopediaHomePage enterPassword(String passwordUser) {
        swithToIframe();
        waitForElementText(passwordField, passwordUser);
        switchToDefaultContent();
        return this;
    }

    public TokopediaHomePage clickSubmitAccount() {
        swithToIframe();
        waitForElementClick(submitAccount);
        switchToDefaultContent();
        return this;
    }

    public TokopediaHomePage loginUser(String username, String password) {
        clickLogin();
        enterEmail(username);
        enterPassword(password);
        clickSubmitAccount();
        return this;
    }


}
