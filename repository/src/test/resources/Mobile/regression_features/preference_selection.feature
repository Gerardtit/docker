@preference_selection
Feature: Preference selection

  Background: setup user on SignIn Page
    When navigate to home page
    Then home page is displayed

  @regression
  Scenario: Select Delivery
    When user clicks delivery option on home page
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    And user clicks next button after registration on zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then home page is displayed
    And verify "delivery" option is selected as preference on home page

  @regression
  Scenario: Select DUG
    When user clicks delivery option on home page
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    And user clicks next button after registration on zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then home page is displayed
    And verify "pickup" option is selected as preference on home page

  @regression
  Scenario: Select DUG - with different zipcode
    When user clicks delivery option on home page
    Then zipcode page is displayed
    When user enters "zipcode_diff" in zipcode page
    And user clicks next button after registration on zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then home page is displayed
    And verify "pickup" option is selected as preference on home page
