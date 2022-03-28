Feature: Verify Wallet Section

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

  @smoke @bvt_regression
  Scenario: As a new user should be able to update email id in My account
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When User click on user profile icon
    Then User verify Account option in list
    When User click on Account option
    Then user see My account page
#    And user verify email id in email section
    And User update Email Id

  @smoke @bvt_regression
  Scenario: As a new user on Signup using email with try different email option, I should land on home screen when instore is selected
    When User Signup with try diff email link
    Then zipcode page is displayed
    When user enters "instore" in zipcode page
    Then select order type page is displayed
    When user clicks instore on delivery select page
    Then store list is displayed
    Then user selects the In-store on the list
#    When user clicks 1st store on the list
    And user click start shopping button on Sign In page
    And user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    And verify "inStore" option is selected as preference on home page

  @smoke @bvt_regression
  Scenario: As a Registered user should check email id in my account.
    When sign in to the application
    And user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When User click on user profile icon
    Then User verify Account option in list
    When User click on Account option
    Then user see My account page
    And user verify email id in email section
    And user not see password option

  @smoke @bvt_regression
  Scenario: As a new user on Signup using resend code email, user should be able to select Delivery option to navigate home page
    When new user signup using resend code after "30" sec
    Then zipcode page is displayed
    When  user enters "zipcode" in zipcode page
    And user click delivery option
    And user click start shopping button on After Signup
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed

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

  @bvt_regression
  Scenario: To verify Wallet Section

    When sign in to the application
    And user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks wallet on HomePage
    Then the "Wallet" page is displayed
    When click on wallet sub tab
    Then verify Loyalty card, clipped rewards and clipped deals are displayed