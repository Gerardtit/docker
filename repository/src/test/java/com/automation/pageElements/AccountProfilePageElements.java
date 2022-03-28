package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.CacheLookup;

public class AccountProfilePageElements {

    @iOSXCUITFindBy
    @AndroidFindBy(id = "tvTitle")
    MobileElement myAccountPageTitle;

    @iOSXCUITFindBy
    @AndroidFindBy(id = "account_firstname")
    @CacheLookup
    MobileElement firstNameText;

    @iOSXCUITFindBy
    @AndroidFindBy(id = "savings_summary")
    @CacheLookup
    MobileElement savingSummary;

    @iOSXCUITFindBy
    @AndroidFindBy(id = "current_year")
    @CacheLookup
    MobileElement yearInfo;

    @iOSXCUITFindBy
    @AndroidFindBy(id = "lifetime")
    @CacheLookup
    MobileElement lifetimeText;

    @iOSXCUITFindBy
    @AndroidFindBy(id = "current_year_amt")
    @CacheLookup
    MobileElement currentYearSaving;

    @iOSXCUITFindBy
    @AndroidFindBy(id = "lifetime_amt")
    @CacheLookup
    MobileElement lifetimeSaving;

    @iOSXCUITFindBy
    @AndroidFindBy(id = "delivery_address_content")
    @CacheLookup
    MobileElement userAddressText;

    @iOSXCUITFindBy
    @AndroidFindBy(id = "dug_address_content")
    @CacheLookup
    MobileElement storeAddressText;

    @iOSXCUITFindBy
    @AndroidFindBy(id = "store_phone_rl")
    @CacheLookup
    MobileElement phoneNumberUsedInStore;

    @iOSXCUITFindBy
    @AndroidFindBy(id = "email_content")
    @CacheLookup
    MobileElement userEmail;

    @iOSXCUITFindBy
    @AndroidFindBy(id = "comm_pref_rl")
    @CacheLookup
    MobileElement communicationPreference;

    @iOSXCUITFindBy
    @AndroidFindBy(id = "update_password_rl")
    @CacheLookup
    MobileElement passwordSecurity;

}
