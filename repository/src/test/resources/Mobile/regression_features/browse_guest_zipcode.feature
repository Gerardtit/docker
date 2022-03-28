@browse_guest_zipcode
Feature: Browse as Guest zip code Feature

  Background: navigate to zipcode page
    When navigate to sign in page
    Then sign in page is displayed
    When user clicks cancel from signin page
    Then zipcode page is displayed

  @regression
  Scenario: Zip code input page - use current location
    When user clicks use current location on zipcode page
    And user clicks next button on zipcode page
    Then home page is displayed

  @regression
  Scenario: Zip code input page - type in zip code
    When user enters "zipcode" in zipcode page
    And user clicks next button on zipcode page
    Then home page is displayed

  @regression
  Scenario: Zip code input page - type in non-serviced location, verify email screen
    When user enters "75005" in zipcode page
    And user clicks next button on zipcode page
    Then non-service zip code page is displayed
    When user enter "vonsaaa@example.com" and click next to register on non-service zipcode page
    And user click next button on non-service zipcode page
    Then service email confirmation is displayed on zipcode page