@WeeklyAds
Feature: WeeklyAds Feature

  Background:
    When  Launch the MFA app

  @MOLN-4607
  Scenario: Verify the Flyer view
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When scroll Down to weekly ad banner section in deals
    And click on weekly ad banner
    Then verify user is on weekly ad flyer page
    And user can scroll vertically on flyer page
    When user click on first flyer
    Then user can see full view of flyer
    And user can scroll vertically on full view page of flyer
    When user clicks back button on flyer detail page
    Then verify user is on weekly ad flyer page