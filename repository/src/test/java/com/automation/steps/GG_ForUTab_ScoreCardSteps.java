package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_SelectStorePage;
import io.appium.java_client.AppiumDriver;

public class GG_ForUTab_ScoreCardSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    //  public GG_ForU_ScoreCardPage scoreCardPage = new GG_ForU_ScoreCardPage(driver);
    public GG_SelectStorePage selectStorePage = new GG_SelectStorePage(driver);
    int cartValueBefore;


}
