package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class FeedbackPageElements {

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Feedback' AND visible == 1")
    @AndroidFindBy(id = "tvTitle")
    public MobileElement feedbackTitle;

    @iOSXCUITFindBy(accessibility = "Chat")
    //@AndroidFindBy
    public MobileElement chatButton;

    @iOSXCUITFindBy(accessibility = "Expand Chevron")
    @AndroidFindBy(id = "android:id/text1")
    public MobileElement selectTopicDropDown;

    @iOSXCUITFindBy(className = "XCUIElementTypePickerWheel")
    //@AndroidFindBy
    public MobileElement iosTopicPickerWheel;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextView' AND name BEGINSWITH[c] 'Enter Comments' AND visible == 1")
    @AndroidFindBy(id = "edit_text")
    public MobileElement enterCommentsEditText;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Submit' AND visible == 1")
    @AndroidFindBy(id = "btn_submit")
    public MobileElement submitButton;

    //Done button on pickerWheel ios only
    @iOSXCUITFindBy(accessibility = "Done")
    public MobileElement iosDoneButton;

    @AndroidFindBy(id = "android:id/text1")
    public List<MobileElement> topicDropdownList;

    @AndroidFindBy(xpath = "//android.widget.Toast[1]")
    @iOSXCUITFindBy(accessibility = "Thank you for your feedback.")
    public MobileElement sucessfullySentMsg;

}
