@gg_Punting456  @regression
Feature: Store Picker - Punting- Automation story


  Scenario:Verify pop-up message will close when user clicks Not Right Now CTA
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
 #   Then select order type page is displayed
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When click on search field
    And user types "baby oil" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
   # Then checkout page is displayed
    Then user clicks on edit button on checkout page
    Then select pickup store is displayed on checkout page
    And user enters "94566" in the store list on checkout page
    And click on first item in the store list
    Then verify pop-up window will appear on the screen
    Then verify Download CTA is displayed
    Then verify Not Right Now CTA is displayed
    When user clicks on Not Right Now CTA
    Then verify pop-up window will get closed


  Scenario:Verify the corresponding app is already installed on user's device will open up
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
 #   Then select order type page is displayed
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When click on search field
    And user types "baby oil" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
 #   Then checkout page is displayed
    Then user clicks on edit button on checkout page
    Then select pickup store is displayed on checkout page
  #  When user enters "zipcode" in zipcode page
    When user enters "94566" in the store list on checkout page
    And click on first item in the store list
    Then verify pop-up window will appear on the screen
    Then verify Open CTA is displayed
    Then verify Not Right Now CTA is displayed
    And user clicks on Open CTA
    Then verify the corresponding app is already installed on user's device will open up


  Scenario:Verify user will be taken to the Apple App Store when selects download CTA
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
 #   Then select order type page is displayed
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When click on search field
    And user types "baby oil" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    #Then checkout page is displayed
    Then user clicks on edit button on checkout page
    Then select pickup store is displayed on checkout page
  #  When user enters "zipcode" in zipcode page
    When user enters "90069" in the store list on checkout page
    And click on first item in the store list
    Then verify pop-up window will appear on the screen
    Then verify Download CTA is displayed
    Then verify Not Right Now CTA is displayed
    When user clicks on Download CTA
    Then verify user will be taken to the Apple App Store