@browse_guest_homepage
Feature: Browse As Guest Feature

  Background: setup user on home Page
    When navigate to sign in page
    Then sign in page is displayed
    When user close application and relaunch
    Then choose account page is displayed
    When user clicks continue as guest button from choose account page
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    And user clicks next button on zipcode page
    Then home page is displayed

  @regression
  Scenario: add item from aisles as guest
    When user click aisles tab on home page
    Then aisles department list is displayed on home page
    When user clicks item "Baby Care" on aisle list
    When user clicks item "Baby Bath & Skin Care" on aisle list
    When user clicks item "Baby Body Wash" on aisle list
    Then verify item is found from aisle
    When user clicks "1" item add button on first item
    Then sign in page is displayed

  @regression
  Scenario: browse my purchase as guest
    When user click my purchase tab on home page
    Then sign in page is displayed

  @regression
  Scenario:  navigate on home page as guest
    Then verify popular items is displayed on home page
    And verify most viewed is displayed on home page

  @regression
  Scenario:  navigate on deals as guest
    Then user clicks deals on home page
    And deals page is displayed

  @regression
  Scenario:  navigate on more/menu as guest
    Then user click menu button on home page
    And menu page is displayed

  @regression
  Scenario:  navigate on cart as guest
    Then user clicks shopping cart button on home page
    And sign in page is displayed

  @regression
  Scenario: search as guest
    When user clicks search bar on home page
    And user types "black pepper" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    Then sign in page is displayed

  @regression @screen_chatbot
  Scenario: Guest chatbot verification
    When user click menu button on home page
    Then menu page is displayed
    When user clicks Need Help Chatbot on current page
    Then "Chat" window is displayed
    When navigate back to previous level
    Then menu page is displayed

    When user clicks Help FAQ on menu page
    Then help FAQ window is displayed
    When user clicks Need Help Chatbot on current page
    Then "Chat" window is displayed
    When navigate back to previous level
    Then help FAQ window is displayed
    When navigate back to previous level
    Then menu page is displayed

    When user clicks feedback on menu page
    Then "Feedback" window is displayed
    When user clicks Need Help Chatbot on current page
    Then "Chat" window is displayed
    When navigate back to previous level
    Then "Feedback" window is displayed
    When navigate back to previous level
    Then menu page is displayed

    When user clicks Contact Us on menu page
    Then "Contact Us" window is displayed
    When user clicks Chat on the contact us page
    Then "Chat" window is displayed
    When navigate back to previous level
    Then "Contact Us" window is displayed
    When navigate back to previous level
    Then menu page is displayed

  #Scenario: Scan as guest - need to add scan code item
  #Scenario: J4U Coupon as guest - no option available
  #Scenario: Reserve time as guest - no option available

