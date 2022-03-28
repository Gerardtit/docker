package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class GG_FreshPassMemberTab_Elements {
    @iOSXCUITFindBy(xpath = "//*[@label=\"MEMBER\"]")
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"MEMBER\"]/android.widget.ImageView")
    public MobileElement membertabatHomepage;


    @iOSXCUITFindBy(xpath = "//*[@label=\"FreshPass Tab, 2 of 3\" or @label=\"FreshPass Tab, 2 of 4\"]")
    @AndroidFindBy(xpath = "//*[@text=\"FreshPass\"]")
    public MobileElement freshpassAtMemberpage;

    // @iOSXCUITFindBy(xpath="//*[@label=\"Annual Subscriber\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeButton[1]")
    @AndroidFindBy(xpath = "//*[@resource-id=\"chip\" or @text=\"Annual Subscriber\"]")
// @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.Button[1]")
    public MobileElement userstatus;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Enjoy free delivery & perks* with FreshPass™\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Enjoy free delivery & perks* with FreshPass™\"]")
    public MobileElement EnjoyMesaage;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Only $99 / yr. or $12.99 / mo. plus applicable taxes\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Only $99 / yr. or $12.99 / mo. plus applicable taxes\"]")
    public MobileElement yrplanMember;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Free delivery\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Free delivery\"]")
    public MobileElement freedelivery;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Subscribers enjoy free unlimited deliveries for all their orders (where available).\"]")
    @AndroidFindBy(xpath = "//*[starts-with(@text,\"Subscribers enjoy\")]")
    public MobileElement subcribeerTxt;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Exclusive deals\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Exclusive deals\"]")
    public MobileElement ExclusiveText;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Save 5% on O Organics® and Open Nature®.\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Save 5% on O Organics® and Open Nature®.\"]")
    public MobileElement organictext;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Exclusive monthly Starbucks perks\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Exclusive monthly Starbucks perks\"]")
    public MobileElement starbuckstext;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Get your favorite handcrafted beverage on us.\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Get your favorite handcrafted beverage on us.\"]")
    public MobileElement handicraftText;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Rewards don't expire\"]")
    @AndroidFindBy(xpath = "//*[starts-with(@text,\"Rewards don't expire\")]")
    public MobileElement dontexpireText;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Rest easy, they'll always be there.\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Rest easy, they'll always be there.\"]")
    public MobileElement restEasyText;

    @iOSXCUITFindBy(xpath = "//*[@label=\"* Restrictions apply. Full program Terms & Conditions here.\"]")
    @AndroidFindBy(xpath = "//*[@text=\"* Restrictions apply. Full program Terms & Conditions here.\"]")
    public MobileElement TNCatMember;

    @iOSXCUITFindBy(xpath = "//*[starts-with(@label,\"** $5 \")]")
    @AndroidFindBy(xpath = "//*[starts-with(@text,\"** $5 \")]")
    public MobileElement promotext;

    @iOSXCUITFindBy(xpath = "//*[@label=\"VIP customer service line, 1 of 6\"]")
    @AndroidFindBy(xpath = "//*[@text=\"VIP customer service line\"]")
    public MobileElement VIPcustomer;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Want to talk to a real, live person?\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Want to talk to a real, live person?\"]")
    public MobileElement VIPcustomersubText;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Grocery & wine experiences, 2 of 6\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Grocery & wine experiences\"]")
    public MobileElement groceryText;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Impress your friends and family.\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Impress your friends and family.\"]")
    public MobileElement grocerysubText;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Exclusive deals, 3 of 6\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Exclusive deals\"]")
    public MobileElement exclusivetext;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Save 5% on O Organics™ and Open Nature™.\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Save 5% on O Organics™ and Open Nature™.\"]")
    public MobileElement exclusivesubtext;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Monthly Starbucks perk, 4 of 6\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Monthly Starbucks perk\"]")
    public MobileElement monthlystarbuck;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Get your favorite handcrafted beverage on us.\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Get your favorite handcrafted beverage on us.\"]")
    public MobileElement emonthlystarbuckSubText;

    @iOSXCUITFindBy(xpath = "//*[@label=\"The gift that keeps on giving.\"]")
    @AndroidFindBy(xpath = "//*[@text=\"The gift that keeps on giving.\"]")
    public MobileElement starbuckSubTexttab;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Rewards don’t expire, 5 of 6\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Rewards don’t expire\"]")
    public MobileElement rewardNoexpire;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Rest easy, they’ll always be there.\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Rest easy, they’ll always be there.\"]")
    public MobileElement rewardNoexpiresubtext;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Unlimited free delivery, 6 of 6\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Unlimited free delivery\"]")
    public MobileElement deliverytext;

    @iOSXCUITFindBy(xpath = "//*[@label=\"No fees on all orders over $30.\"]")
    @AndroidFindBy(xpath = "//*[@text=\"No fees on all orders over $30.\"]")
    public MobileElement deliverysubtext;

    @iOSXCUITFindBy(xpath = "///*[starts-with(@label,\"Unsubscribed\")]")
    @AndroidFindBy(xpath = "//*[starts-with(@text,\"Unsubscribed\")]")
    public MobileElement NewUser;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Annual Subscriber\"]")
    @AndroidFindBy(id = "fp_subscriptionStatus")
    public MobileElement annualFPUser;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Monthly Subscriber\"]")
    @AndroidFindBy(xpath = "//*[starts-with(@text,\"Monthly Subscriber\")]")
    public MobileElement monthlyUser;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Annual Subscription\")]")
    @AndroidFindBy(id = "fp_subscriptionStatus")
    public MobileElement freeTrailAnnualFPUser;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Monthly Subscription\")]")
    @AndroidFindBy(xpath = "//*[contains(@text,\"Monthly Subscription\")]")
    public MobileElement freeTrailMonthlyFPUser;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Start my 30-day free trial\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Start my 30-day free trial\"]")
    public MobileElement subscribebutton;

    @AndroidFindBy(xpath = "//*[@text=\"Save big on delivery fees\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Save big on delivery fees\"]")
    public MobileElement Savetitle;

    @AndroidFindBy(xpath = "//*[@text=\"Subscribe for a monthly or annual plan.\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Subscribe for a monthly or annual plan.\"]")
    public MobileElement Savesubtitle;

    //    @AndroidFindBy(xpath  = "//*[@text=\"You’re eligible for $20 off your first online order of $75 or more\"]")
    @AndroidFindBy(xpath = " //*[starts-with(@text,\"You’re eligible\") and @index=\"1\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"You’re eligible for $20 off your first online order of $75 or more\"]")
    public MobileElement eligiblitytext;

    @AndroidFindBy(xpath = "//*[@text=\"Annual plan\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Annual plan\"]")
    public MobileElement annualtext;

    @AndroidFindBy(xpath = "//*[@text=\"$99.00 / year\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"$99.00 / year + tax\"]")
    public MobileElement yrplantext;

    @AndroidFindBy(xpath = "//*[@content-desc=\"Select Annual Plan button\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[3]/XCUIElementTypeButton[1]/XCUIElementTypeStaticText[1]")
    public MobileElement selecttext1;

    //   @AndroidFindBy(xpath  = "//*[@text=\"Which is equal to just $8.25 / mo! Automatically renews\"]")
    @AndroidFindBy(xpath = "//*[starts-with(@text,\"Which is equal\") and @index=\"5\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Which is equal to just $8.25 / mo!\"]")
    public MobileElement yrplansubtext1;

    @AndroidFindBy(xpath = "//*[starts-with(@text,\"Which is equal\") and @index=\"5\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[3]/XCUIElementTypeStaticText[3]")
    public MobileElement yrplansubtext2;

    @AndroidFindBy(xpath = "//*[@text=\"Save 35%\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Save 35%\"]")
    public MobileElement savetext;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[3]/XCUIElementTypeStaticText[5]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.TextView[1]")
    public MobileElement freetrial1;

    @AndroidFindBy(xpath = "//*[@text=\"Monthly plan\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Monthly plan\"]")
    public MobileElement monthlytext;

    @AndroidFindBy(xpath = "//*[@text=\"$12.99 / month\"")
    @iOSXCUITFindBy(xpath = "//*[@label=\"$12.99 / month + tax\"]")
    public MobileElement monthlyplantext;

    @AndroidFindBy(xpath = "//*[@text=\"$12.99 / month billed monthly Automatically renews\"and @index=\"4\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"$12.99 / month billed monthly\"]")
    public MobileElement monthlyplantext1;

    @AndroidFindBy(xpath = "//*[@text=\"$12.99 / month billed monthly Automatically renews\"and @index=\"4\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[4]/XCUIElementTypeStaticText[3]")
    public MobileElement monthlyplantext2;

    @AndroidFindBy(xpath = "//*[@content-desc=\"Select Monthly Plan button\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[4]/XCUIElementTypeButton[1]/XCUIElementTypeStaticText[1]")
    public MobileElement select2;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[4]/XCUIElementTypeStaticText[5]")
    public MobileElement renewtext2;

    @AndroidFindBy(xpath = "//*[@text=\"Need help?\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Need help?\"]")
    public MobileElement needhelp;

    @AndroidFindBy(xpath = "//*[@text='Any Starbucks Cafe Handcrafted Grande Beverage']")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Any Starbucks Cafe Handcrafted Grande Beverage'")
    public MobileElement monthlyOffer;

    @AndroidFindBy(xpath = "//*[@text='Any O Organics or Open Nature']")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Any O Organics or Open Nature'")
    public MobileElement creditOffer;

    @AndroidFindBy(xpath = "//*[@text='Your FreshPass benefits']")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Your FreshPass benefits'")
    public MobileElement freshPassBenifitHeading;

    @AndroidFindBy(xpath = "//*[@text='VIP customer service line']")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'VIP customer service line'")
    public MobileElement freshPassBenifitCarousel;

    @AndroidFindBy(xpath = "//*[contains(@text, 'Add offers to your loyalty account prior to')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Add offers to your loyalty account prior'")
    public MobileElement disclaimer;

    @AndroidFindBy(xpath = "//*[@text='FreshPass Perks']")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'FreshPass Perks'")
    public MobileElement FreshPassPerks;

    // 5% off carousel elements for FP subscribed user
    @AndroidFindBy(xpath = "//*[@text='5% off' ]//..//*[@text='O Organics® Products']")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,'5% off O Organics® Products')]")
    public MobileElement OrganicProductWidget;

    @AndroidFindBy(xpath = "//*[@text='5% off' ]//..//*[@text='O Organics® Products']")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,'5% off Open Nature™ Products')]")
    public MobileElement OpenNatureProductWidget;

    @AndroidFindBy(xpath = "//*[@text=\"How much you could save\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"How much you could save\"]")
    public MobileElement howMuchYouCouldSave;

    @AndroidFindBy(xpath = "//*[contains(@text,'FreshPass annual subscribers could save up to')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"You could save up to $425 a year with exclusive deals and free delivery.\"]")
    public MobileElement saveUpToDollarAYear;

    @AndroidFindBy(xpath = "//*[@text=\"Estimated Savings\"]")
    @iOSXCUITFindBy(xpath = "//*[@value=\"Estimated Savings\"]")
    public MobileElement estimatedSavings;

    @AndroidFindBy(id = "bottom_sheet_close")
    @iOSXCUITFindBy(accessibility = "btnClose")
    public MobileElement closesheet;

    @AndroidFindBy(xpath = "//*[contains(@text,'Based on average delivery orders for existing FreshPass subscribers from')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,'Based on average delivery orders for existing FreshPass subscribers from')]")
    public MobileElement estimatedSavingsText;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"search\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"search\"]")
    public MobileElement searchIconFP;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Cart 0 items\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Cart\"]")
    public MobileElement cartIconFP;

    @AndroidFindBy(xpath = "//*[contains(@text,'VIP Customer Service Phone Line (855) 767–2545')]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"VIP Customer Service Phone Line (855) 767-2545\"]")
    public MobileElement vipPhoneLineFP;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Thanks for signing up!')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@label,'Thanks for signing up!')][@visible='true']")
    public MobileElement emptyStateFP;


}
