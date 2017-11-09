package com.tokopedia.pageobject;

import com.tokopedia.core.GenericPageObject;

public class NewAddressPage extends GenericPageObject {
    private String addressStreet = "//textarea[@id='address-street']";
    private String postalCode = "//input[@id='postal-code']";
    private String provinceID = "province-name";
    private String cityID = "city-name";
    private String districtID = "district-name";
    private String receiverName = "//input[@id='receiver-name']";
    private String receiverPhone = "//input[@id='receiver-phone']";
    private String addressName = "//input[@id='address-name']";
    private String saveAddress = "//button[@id='btn-save-address']";

    public NewAddressPage enterAddress(String street) {
        waitForElementText(addressStreet, street);
        return this;
    }

    public NewAddressPage enterPostalCode(String postalCodeBuyer) {
        waitForElementText(postalCode, postalCodeBuyer);
        return this;
    }

    public NewAddressPage enterProvince(String province){
        waitForElementTextByID(provinceID, province);
        return this;
    }

    public NewAddressPage enterCity(String city) {
        waitForElementTextByID(cityID, city);
        return this;
    }

    public NewAddressPage enterDistrict(String district) {
        waitForElementTextByID(districtID, district);
        return this;
    }

    public NewAddressPage enterReceiverName(String receiver) {
        waitForElementText(receiverName, receiver);
        return this;
    }

    public NewAddressPage enterReceiverPhone(String phone) {
        waitForElementText(receiverPhone, phone);
        return this;
    }

    public NewAddressPage enterAddressName(String nameOfAddress) {
        waitForElementText(addressName, nameOfAddress);
        return this;
    }

    public NewAddressPage clickSave() {
        waitForElementClick(saveAddress);
        return this;
    }


}
