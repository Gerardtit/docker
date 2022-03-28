Feature: Verify Product CTA in Instore

  Background: setup user on SignIn Page

    When Launch the MFA app

  @bvt_regression
  Scenario: Verify Product CTA in Instore
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "instore" in zipcode page
    Then select order type page is displayed
    When user clicks instore on delivery select page
    Then store list is displayed
    Then user selects the In-store on the list
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When click on search field
    And user types "baby oil" on search bar and click search on home page
    Then user should see searched products
    When user click on Add to List
    Then verify products are adding to List
    When user clicks on List
    And user swipe left to remove all item in shopping cart
    And user close the new cart page
    And user clicks back button on search page
    Then Home page is displayed


  @bvt_regression
  Scenario: Verify Instore Cart
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "instore" in zipcode page
    Then select order type page is displayed
    When user clicks instore on delivery select page
    Then user selects the In-store on the list
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When click on search field
    And user types "baby oil" on search bar and click search on home page
    Then user should see searched products
    When user click on Add to List
    Then verify products are adding to List
    When user clicks on List
    Then verify My List page is displayed
    When user clicks Delivery or Pick Up in My List Page
    When user enters "instore" in zipcode page
    Then select order type page is displayed
    Then user selects the In-store on the list
    And user clicks start shopping button on Sign In page
    Then verify My List page is displayed
    When user clicks Pay In-Store in My List Page
    And user click Dismiss
    Then the "Wallet" page is displayed





