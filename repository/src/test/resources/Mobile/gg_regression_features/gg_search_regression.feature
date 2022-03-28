Feature: Search-Regression

  @regression @start_scenario
  Scenario: Search for Valid item and cancel
    When sign in to the application
    Then verify home screen is displayed
    And go to Home tab
    And select the pick-up store
    When search a product on home page
    Then verify products listing page displayed
    When user goes back to home page from search page
    Then verify dashboard page is displayed

   #C16623
  @regression
  Scenario: Search for Invalid Item
    And go to Home tab
    And search for invalid product "qqqqqq" on home page
    Then verify no result is displayed on the page
    And user goes back to home page from search page

     #C16632
  @regression
  Scenario: Add item from Search Results
    And go to Home tab
    When search a product on home page
    And close toggle info popup
    Then verify products listing page displayed
    And add a product on product details page
    And go back to Home Page from product details page

     #C16628
  @regression
  Scenario: Currently Trending
    And go to Home tab
    When click on search field
    And verify Currently Trending products displayed
    Then hide keyboard if opened
    And user goes back to home page from search page

     #C16630
  @regression
  Scenario: Search - sort and Filters - Best Match, Club Card Special , Most Popular, Price low to high
    And go to Home tab
    When search a product on home page
    Then verify products listing page displayed
    When user click sort or filters from item list window
    Then sort and filter search value page is displayed
    When user clicks Sort By option in Sort & Filter page
    Then Sort & Filter By option window is displayed
    When user select Best Match from Sort & Filter By window
    And Android Navigate Back arrow
    Then "Best Match" text is selected as Sort By option
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
    And user goes back to home page from search page

     #C16629
  @regression
  Scenario: Most Recently Search
    And go to Home tab
    When search a product on home page
    And close toggle info popup
    And click cancel button on product search page
    When click on search field
    Then verify Recently Searched products displayed
    And user goes back to home page from search page

     #C16631
  @regression @end_scenario
  Scenario: Search - Deals Toggle
    And go to Home tab
    When search a product on home page
    Then verify result is displayed on the page
    And Deals toggle switch is displayed on the page
    When user clicks deals toggle switch on the search page
    Then deals switch is displayed as "on" on the search page
    When user clicks deals toggle switch on the search page
    Then deals switch is displayed as "off" on the search page
