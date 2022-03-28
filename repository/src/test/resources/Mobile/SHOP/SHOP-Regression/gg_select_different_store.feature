@gg_select_different_store
Feature: [Andriod] Selecting different store

  @YRM-31
  Scenario:Verify user is on store selection screen and gets a pop-up informing them about the impact of changing the store/Pickup slot
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
    #And click on settings icon
   # And scroll down and click on developer settings
   # When turn "ON" defaultLandingToHome feature
    #When turn "OFF" newcart feature
    When click on search field
    And user types "body lotion" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "5" number of items for all item in shopping cart
    And user clicks shopping cart button on home page
    And user clicks checkout button on cart page
   # Then checkout page is displayed
    Then user clicks on edit button on checkout page
    Then select pickup store is displayed on checkout page
    And user enters "94063" in the store list on checkout page
    And click on first item in the store list
    Then verify pop-up appears informing about the impact of changing the store
    Then verify Continue CTA is displayed
    Then verify Go Back CTA is displayed
    When user clicks on Continue CTA
    Then shopping cart page is displayed
    And user clicks back button to close the cart and land on checkout
    And user clicks on close button
    Then verify pop-up appears informing about changes
    When user clicks on slotselction screen
    And user clicks on the shipping option for the following day without payment selection
    And user clicks on close button
    Then verify pop-up appears informing about changes


  #  Then verify pop-up window will appear on the screen
  #  Then verify Download CTA is displayed
  #  Then verify Not Right Now CTA is displayed
  #  When user clicks on Not Right Now CTA
  #  Then verify pop-up window will get closed


  @regression
  Scenario:Verify user is on store selection screen and close the pop-up informing them about the impact of changing the store
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
    And click on settings icon
    And scroll down and click on developer settings
   # When turn "ON" defaultLandingToHome feature
    When turn "OFF" newcart feature
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
    And user enters "76109" in the store list on checkout page
    And click on first item in the store list
    Then verify pop-up appears informing about the impact of changing the store
    Then verify Continue CTA is displayed
    Then verify Go Back CTA is displayed
    When user clicks on Continue CTA
    Then shopping cart page is displayed
    And user clicks back button on cart page
  #  And user clicks checkout button on cart page
    Then verify user is taken to slot selection screen

  @regression
  Scenario:Verify user is on store selection screen and close the pop-up informing them about the impact of changing the store
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
    And click on settings icon
    And scroll down and click on developer settings
    When turn "ON" defaultLandingToHome feature
    When turn "OFF" newcart feature
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
    And user enters "76109" in the store list on checkout page
    And click on first item in the store list
    Then verify pop-up appears informing about the impact of changing the store
    Then verify Continue CTA is displayed
    Then verify Go Back CTA is displayed
    When user clicks on Go Back CTA
  #  Then shopping cart page is displayed
 #   And user clicks back button on cart page
  #  And user clicks checkout button on cart page
    Then verify user is taken to slot selection screen

