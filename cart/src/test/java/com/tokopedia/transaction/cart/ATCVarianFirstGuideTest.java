package com.tokopedia.transaction.cart;

import com.tokopedia.core.TestSuite;
import com.tokopedia.dataobject.LoginData;
import com.tokopedia.pageobject.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ATCVarianFirstGuideTest extends TestSuite {
    private String notes = "Tolong kirim hari ini ya biar sampenya besok. Mau dibuat hadiah ultah";

    @Test(priority=0, dataProvider = "buyer1", dataProviderClass = LoginData.class)
    public void loginUser(String emailUser, String passwordUser) throws Exception {
        LiteHomePage lite = PageFactory.initElements(driver, LiteHomePage.class);
        lite.clickLogin();
        LiteLoginPage loginLite = PageFactory.initElements(driver, LiteLoginPage.class);
        loginLite.loginUser(emailUser, passwordUser);
        switchToLite();
    }

    @Test(priority=1)
    public void chooseAndBuyProduct(){
        LiteHomePage home = PageFactory.initElements(driver, LiteHomePage.class);
        home.clickFeedTab();
        FeedPage feed = PageFactory.initElements(driver, FeedPage.class);
        feed.loginNow();
        feed.clickFirstProductinTD();
        ProductDescriptionPage pdp = PageFactory.initElements(driver, ProductDescriptionPage.class);
        pdp.clickBuy();
    }

    @Test(priority = 2)
    public void fillDetailProduct(){
        AddToCartPage atc = PageFactory.initElements(driver, AddToCartPage.class);
        atc.setQuantiy(1);
        atc.enterNotes(notes);
        atc.chooseFirstAgency();
        atc.clickBuy();
    }

    @Test(priority = 3)
    public void checkOutProduct() {
        ProductDescriptionPage pdp = PageFactory.initElements(driver, ProductDescriptionPage.class);
        pdp.clickCheckOut();
    }
}
