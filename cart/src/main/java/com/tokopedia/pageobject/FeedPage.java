package com.tokopedia.pageobject;

import com.tokopedia.core.GenericPageObject;
import org.openqa.selenium.support.PageFactory;

public class FeedPage extends GenericPageObject {
    private String firstProductinTD = "//div[contains(@class,'slide__item')][1]//span[contains(@class,'list-name')]";
    private String oopsWarning = "//*[.='Oops, feed masih kosong']";
    private String masukSekarang = "//a[.='Masuk Sekarang']";

    public ProductDescriptionPage clickFirstProductinTD() {
        waitForElementClick(firstProductinTD);
        return PageFactory.initElements(driver, ProductDescriptionPage.class);
    }

    public  FeedPage loginNow() {
        if(isElementPresent(oopsWarning, 7)) {
            waitForElementClick(masukSekarang);
        }
        return PageFactory.initElements(driver, FeedPage.class);
    }
}
