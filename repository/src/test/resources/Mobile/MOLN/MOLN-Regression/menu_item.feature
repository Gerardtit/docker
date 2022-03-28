@menu_item
Feature: Feature for other Menu items

  Background: setup user on Home Page
    When navigate to home page
    Then home page is displayed
    When user click menu button on home page
    Then menu page is displayed

  @regression
  Scenario: check feedback option on menu page
    When user clicks feedback on menu page
    Then feedback page is displayed
    When user select "General" as feedback topic
    And user enters "test user comments" in comment box
    And user click submit to submit comments
    Then comment successfully sent id displayed

  @regression
  Scenario: check dropdown options on feedback page
    When user clicks feedback on menu page
    Then feedback page is displayed
    When user click dropdown menu from feedback page
    Then user verify "General" as feedback topic
    And user verify "Delivery" as feedback topic
    And user verify "Driver" as feedback topic
    And user verify "My Order" as feedback topic
    And user verify "Club Card" as feedback topic
    And user verify "Compliment" as feedback topic