@search
Feature: Search feature

  Background: setup user on SignIn Page
    When navigate to home page
    Then home page is displayed

  @regression
  Scenario: Search for Valid item and cancel
    When user clicks search bar on home page
    And user types "baby cereal" on search bar and click search on home page
    Then verify result is displayed on the page
    When user goes back to home page from search page
    Then home page is displayed

  @regression
  Scenario: Search for Invalid Item
    When user clicks search bar on home page
    And user types "bookshelf" on search bar and click search on home page
    Then verify no result is displayed on the page

  @regression
  Scenario: Search for item and add item to cart
    When user clicks shopping cart button on home page
    Then shopping cart page is displayed
    When user empty shopping cart
    Then shopping cart empty page is displayed
    When user clicks navigate back to the previous page
    Then home page is displayed
    When user clicks search bar on home page
    And user types "baby cereal" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart shows 1 as total number

  @regression
  Scenario: Search from Currently Trending
    When user clicks search bar on home page
    And user clicks 1 item on auto suggest list
    Then verify result is displayed on the page

  @regression
  Scenario: Search item and add item from product page
    When user clicks shopping cart button on home page
    Then shopping cart page is displayed
    When user empty shopping cart
    Then shopping cart empty page is displayed
    When user clicks navigate back to the previous page
    Then home page is displayed
    When user clicks search bar on home page
    And user types "baby cereal" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks 1 product in the search list
    Then product detail page is displayed
    And related item is displayed on the product detail page
    When user clicks add button on the product detail page
    And user clicks shopping cart button on home page
    Then shopping cart shows 1 as total number

  @regression
  Scenario: Most Recently Search
    When user clicks search bar on home page
    And user types "baby cereal" on search bar and click search on home page
    Then verify result is displayed on the page
    When user goes back to home page from search page
    Then home page is displayed
    When user clicks search bar on home page
    Then verify recent searched item is displayed
    And verify "baby cereal" is displayed in recent search

  @regression
  Scenario: Search - Deals Toggle
    When user clicks search bar on home page
    And user types "baby cereal" on search bar and click search on home page
    Then verify result is displayed on the page
    And Deals toggle switch is displayed on the page
    When user clicks deals toggle switch on the search page
    Then deals switch is displayed as "on" on the search page
    And "Club Card Price" deal is displayed on the page
    When user clicks deals toggle switch on the search page
    Then deals switch is displayed as "off" on the search page

  @regression
  Scenario: Search - sort and Filters - Best Match, Club Card Special , Most Popular, Price low to high
    When user clicks search bar on home page
    And user types "baby cereal" on search bar and click search on home page
    Then verify result is displayed on the page
    When user click sort or filters from item list window
    Then sort and filter search value page is displayed
    When user clicks Sort By option in Sort & Filter page
    Then Sort & Filter By option window is displayed
    When user select Best Match from Sort & Filter By window
    And Android Navigate Back arrow
    Then "Best Match" text is selected as Sort By option
    When user clicks Sort By option in Sort & Filter page
    Then Sort & Filter By option window is displayed
    When user select Club Card Specials from Sort & Filter By window
    And Android Navigate Back arrow
    Then "Club Card Specials" text is selected as Sort By option
    When user clicks Sort By option in Sort & Filter page
    Then Sort & Filter By option window is displayed
    When user select Most Popular from Sort & Filter By window
    And Android Navigate Back arrow
    Then "Most Popular" text is selected as Sort By option
    When user clicks Sort By option in Sort & Filter page
    Then Sort & Filter By option window is displayed
    When user select Price Low to High from Sort & Filter By window
    And Android Navigate Back arrow
    Then "Low to High" text is selected as Sort By option
    When user saves or click done from Sort & Filter page

  @verifySearchFunctionality
  Scenario: verify Search Functionality
    When user clicks search bar on home page
    And user types "butter" on search bar and click search on home page
    Then verify result is displayed on the page
    When user goes back to home page from search page
    Then Home page is displayed
    When user clicks on Hemberger on home Page
    When user types "butter" on search bar and click search on menu page
    And user clicks cancel button
    When user clicks Browse on home page
    When user types "butter" on search bar and click search on browse page
    Then verify result is displayed on the page
    And user click cancel button
    When user clicks Deals on home page
    And user click Dismiss
    When user types "butter" on search bar and click search on deals page
    Then verify result is displayed on the page
    And user click cancel button
    When user click my items button on home screen
    When user types "butter" on search bar and click search on My Items page
    Then verify result is displayed on the page
    And user click cancel button
    And user press back button
    And user press back button
    And user press back button
    When user click menu button on home page
    And user click sign out button on menu page
    Then confirm sign out page is displayed
    And user click ok button to confirm sign out






