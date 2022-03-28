Feature: Validate Add to List on Weekly Ad

  Background: setup user on Home Page for WeeklyAd
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then Verify Start shopping button on Sign In page
    When user click delivery option
    And user click start shopping button on After Signup
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed

  @regression @weeklyAd
  Scenario: Verify Add to List on Weekly Ad
    When user clicks on home page Tab
    When user clicks on "Weekly Ad"
    Then user is landed on "Weekly Ad" page
    And user is on the weekly ad card via PDF
    And user click on any AD
    When user has added this ad to the list
    Then CTA on the card is changed to "Remove from List" from Add to List

  @regression @weeklyAd
  Scenario: Verify Add to List on Weekly Ad
    When user clicks on home page Tab
    When user clicks on "Weekly Ad"
    Then user is landed on "Weekly Ad" page
    And user is on the weekly ad card via PDF
    And user click on any AD
    When user has added this ad to the list
    Then CTA on the card is changed to "Remove from List" from Add to List
    Then verify ad is added to List under My List page


  @weeklyAd
  Scenario: Verify validity date present on the 3rd row in added my list item
    When user clicks on home page Tab
    When user clicks on "Weekly Ad"
    Then user is landed on "Weekly Ad" page
    And user is on the weekly ad card via PDF
    And user click on any AD
    When user has added this ad to the list
    Then CTA on the card is changed to "Remove from List" from Add to List
    Then verify validity date present on the third row in added my list item

