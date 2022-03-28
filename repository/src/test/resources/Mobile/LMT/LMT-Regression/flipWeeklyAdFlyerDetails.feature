@FlipWeeklyAdFlyer
Feature: Flip Weekly Ad Flyer

  Background: setup user on Home Page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed

  @RunFlipDiscl
  Scenario: Verify the Flip Weekly Ad Flyer Details
    When user clicks on home page Tab
    When user clicks on "Weekly Ad"
    Then user is landed on "Weekly Ad" page
    Then Flyer preview should be displayed
    When user click on Flyer detail view
    Then user validates weekly ad header and date
    When user clicks on any offer
    Then offer details should be displayed
    Then user validates offer details and disclaimer section

  @regression
  Scenario: Verify that correct Weekly Ads are displayed when Store ID changes
    When user clicks on home page Tab
    When user clicks on "Weekly Ad"
    Then user is landed on "Weekly Ad" page
    When user click on first flyer
    And user validates weekly ad header date
#    When user clicks on scroll view
#    Then user clicks on Meat and Seafood from Menu
    When user clicks on an offer
    Then individual weekly offer details should be displayed
    Then user click on close offer details screen
    When user clicks back button on flyer detail page
    When click on shopping mode down arrow
    When user enters "94566" in zipcode page
    Then select order type page is displayed
    When user select pickup on delivery select page
    Then user selects pickup store
    And  user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    When user clicks on "Weekly Ad"
    Then user is landed on "Weekly Ad" page
    When user click on first flyer
    And user validates weekly ad header date
    When user clicks on an offer
    Then individual weekly offer details should be displayed
    Then user click on close offer details screen
    When user clicks back button on flyer detail page











