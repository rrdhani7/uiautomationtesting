package com.tokopedia.pageobject;

import com.tokopedia.core.GenericPageObject;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage extends GenericPageObject {
    private String quantityID = "min-order";
    private String notes = "//textarea[@id='notes']";
    private String addAddress = "//div[@id='icon_add_addr']";
    private String firstAgency = "//ul[@id='shipping-agency']/li[1]/label";
    private String buyButton = "//button[@id='button_buy']";


    public AddToCartPage setQuantiy(int quantiy) {
        waitForElementTextByID(quantityID, String.valueOf(quantiy));
        return this;
    }

    public AddToCartPage enterNotes(String buyerNotes) {
        waitForElementText(notes, buyerNotes);
        return this;
    }

    public NewAddressPage clickAddAddress() {
        waitForElementClick(addAddress);
        return PageFactory.initElements(driver, NewAddressPage.class);
    }

    public AddToCartPage chooseFirstAgency() {
        waitForElementClick(firstAgency);
        return this;
    }

    public ProductDescriptionPage clickBuy() {
        waitForElementClick(buyButton);
        return PageFactory.initElements(driver, ProductDescriptionPage.class);
    }

}
