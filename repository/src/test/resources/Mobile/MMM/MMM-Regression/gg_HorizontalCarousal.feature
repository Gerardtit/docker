@gg_HorizontalCarousal
Feature:Store Picker - Horizontal Carousal ---- Automation story

  @regression
  Scenario:[iOS][Android] Store Picker - Horizontal Carousal ---- Automation story
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
    When user clicks search bar on home page
    And user types "baby oil" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user clicks on first cart item
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks shopping cart button on home page
    And user clicks checkout button on cart page
    Then user clicks on edit button on checkout page
    Then select pickup store is displayed on checkout page
    And scroll down the screen
    Then verify User can scroll left and right
    Then verify Horizontal scroll will always be there
