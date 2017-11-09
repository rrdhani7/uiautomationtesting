package com.tokopedia.pageobject;

import com.tokopedia.core.GenericPageObject;
import org.openqa.selenium.support.PageFactory;

public class ProductDescriptionPage extends GenericPageObject {
    private String buyButton = "//button[.='Beli']";
    private String checkOut = "//a[contains(@class,'popup-btn-checkout')]";

    public AddToCartPage clickBuy() {
        waitForElementClick(buyButton);
        return PageFactory.initElements(driver, AddToCartPage.class);
    }

    public ProductDescriptionPage clickCheckOut() {
        waitForElementClick(checkOut);
        return this;
    }
}
