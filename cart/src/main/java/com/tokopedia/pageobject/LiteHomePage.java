package com.tokopedia.pageobject;

import com.tokopedia.core.GenericPageObject;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class LiteHomePage extends GenericPageObject {
    private String osTabTitle = "//span[.='Official Store']";
    private String feedTab = "//div[p[.='Feed']]";
    private String menu = "//button[@aria-label='Menu']";
    private String login = "//a[contains(@data-click,'login')]";

    public LiteLoginPage clickLogin() {
        waitForElementClick(login);
        return PageFactory.initElements(driver, LiteLoginPage.class);

    }

    public LiteHomePage clickMenu() {
        waitForElementClick(menu);
        return PageFactory.initElements(driver, LiteHomePage.class);
    }

    public String getOSTabTitle() {
        return getText(osTabTitle);
    }

    public FeedPage clickFeedTab() {
        waitForElementClick(feedTab);
        return PageFactory.initElements(driver, FeedPage.class);
    }
}
