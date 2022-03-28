@gg_storecard
Feature: [iOS] Store Picker - store card- Automation story

  @regression
  Scenario:Verify Drive & Go service will be accommodated at the bottom that will be configurable from the list of options that we currently get from APIs/
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
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
    Then checkout page is displayed
    Then user clicks on edit button on checkout page
    Then select pickup store is displayed on checkout page
    Then verify DriveUp & Go text is displayed on checkout page

  @regression
  Scenario:Verify Pharmacy service will be accommodated at the bottom that will be configurable from the list of options that we currently get from APIs/
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
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
    Then checkout page is displayed
    Then user clicks on edit button on checkout page
    Then select pickup store is displayed on checkout page
    Then verify Pharmacy text is displayed on checkout page

  @st
  Scenario:Verify WUG services will be accommodated at the bottom that will be configurable from the list of options that we currently get from APIs/
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
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
    Then checkout page is displayed
    Then user clicks on edit button on checkout page
    Then select pickup store is displayed on checkout page
    When user enters "94063" in the store list on checkout page
    Then verify Counter Pickup text is displayed on checkout page
    When user enters "90505" in the store list on checkout page
    Then verify Kiosk Pickup text is displayed on checkout page
    When user enters "60657" in the store list on checkout page
    Then verify Locker Pickup text is displayed on checkout page


