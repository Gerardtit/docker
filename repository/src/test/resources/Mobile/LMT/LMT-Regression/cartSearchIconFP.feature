Feature: Verify the cart and search icons on FreshPass page

  Background: setup user on Home Page for Delivery Fulfillment type
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then Verify Start shopping button on Sign In page
    When user click delivery option
    And user click start shopping button on After Signup
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed

  @cartsearchFP
  Scenario: Validate the search and cart icons on FreshPass page
    When user clicks on "FreshPass"
    Then user is landed on "FreshPass" page
    Then user validates the search icon on FP page
    Then user validates the cart icon on FP page