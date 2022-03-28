@mmm_shopScreen
Feature: Validate shop screen interaction and UI

  @SwathiTest2712  #MMM-2712 #UMA -Automation-Browse Featured section interactions
  Scenario: Verify Browse Featured section interactions
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user click aisles tab on home page
    Then scroll down for "Weekly Ad" featured section
    When user clicks on "Weekly Ad" featured section
    Then verify user is on the weekly ads page
    And user click on any first AD banner
    And user choose first item of banner
    When user has added this item to the list
    Then CTA on the card is changed to "Remove from list" from Add to List
    Then user click on close offer details screen
    When user click aisles tab on home page
    When user clicks on "Pharmacy" featured section
    Then verify user lands on "Pharmacy" featured section page
    Then click back button on Weekly Ads page
    When user clicks on "Past Purchases" featured section
    Then verify user lands on "My List" featured section page
    Then verify user navigates to Buy it Again page
    When user click aisles tab on home page