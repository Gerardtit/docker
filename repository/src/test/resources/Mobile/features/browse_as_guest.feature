@browseAsGuest
Feature: Browse As Guest Feature

  Background: setup user on SignIn Page
    Given startup page is displayed
    When user clicks continue button on startup page
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    And user clicks next button on zipcode page
    Then home page is displayed

  @smoke
  Scenario: add item from aisles as guest
    When user click aisles tab on home page
    Then aisles department list is displayed on home page
    When user clicks on "1" item on department list
    Then sub list is displayed under aisle list
    When user clicks on "1" item on sub list
    Then category list is displayed under sub list
    When user clicks on "2" item on category list
    Then verify item is found from aisle
    When user clicks "1" item add button on first item
    Then sign in page is displayed

  @smoke
  Scenario: browse my purchase as guest
    When user click my purchase tab on home page
    Then sign in page is displayed

  @smoke
  Scenario:  navigate on home page as guest
    Then verify popular items is displayed on home page
    And verify most viewed is displayed on home page

  @smoke
  Scenario:  navigate on reserve time as guest
    Then verify popular items is displayed on home page
    And verify most viewed is displayed on home page

  @smoke
  Scenario: search as guest
    When user clicks search bar on home page
    And user types "baby health" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    Then sign in page is displayed

  #Scenario: Reserve time as guest
  #legacy scenario no longer valid
