Feature: Search


  Background:

  Scenario: Verify no search results are displayed for Invalid product search
    When sign out if user is logged in to app
    When Launch the MFA app
    And click on existing user signin for OTP
    And user is logged in to the app for Existing user
    Then verify MFA home screen is displayed


  @regression
  Scenario: Verify no search results are displayed for Invalid product search
    When user clicks search bar on home page
    And user types "grdiamfies" on search bar
    Then verify no search results are displayed
    Then user navigates back to Home Page

  @regression
  Scenario: Verify appropriate Search results are displayed for valid product search
    When click on search field
    And user types "Bread" on search bar and click search on home page
    Then user see option to select "Bread"
    Then user navigates back to Home Page


  @regression
  Scenario: Search for Valid item and cancel
    When click on search field
    And search using keyword
    Then verify products listing page displayed
    When user goes back to home page from search page
    Then verify home screen is displayed


  #C16623
  @regression
  Scenario: Search for Invalid Item
    When click on search field
    And search using keyword which has no result
    Then verify no result is displayed on the page


  #C16632
  @regression
  Scenario: Add item from Search Results
    When click on search field
    And search using keyword
    Then verify products listing page displayed
    And add a product on product details page


  #C16628
  @regression
  Scenario: Currently Trending
    When click on search field
    And verify Currently Trending products displayed


  #C16630
  @regression
  Scenario: Search - sort and Filters - Best Match, Club Card Special , Most Popular, Price low to high
    When click on search field
    And search using keyword
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
    When user select Reward Card Specials from Sort & Filter By window
    And Android Navigate Back arrow
    Then "Sale Prices" text is selected as Sort By option
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


  #C16629
  @regression
  Scenario: Most Recently Search
    When click on search field
    And search using keyword
    And close toggle info popup
    And click cancel button on product search page
    When click on search field
    Then verify Recently Searched products displayed


  #C16631
  @regression
  Scenario: Search - Deals Toggle
    When click on search field
    And search using keyword
    Then verify result is displayed on the page
    And Deals toggle switch is displayed on the page
    When user clicks deals toggle switch on the search page
    Then deals switch is displayed as "on" on the search page
    When user clicks deals toggle switch on the search page
    Then deals switch is displayed as "off" on the search page

  #C10356
  @regression @functional
  Scenario: As a User, I should be able to see keyboard opens up when clicked on search bar in dashboard
    When click on search field
    Then verify keyboard opened
    And click cancel button on product search page

  #C10357,C10421
  @regression @functional
  Scenario: As a User, I should be able to type in search bar and relavant items list should be displayed
    When click on search field
    And enter text in search field
    Then check relevant items displayed
    And click cancel button on product search page

  #C10358
  @regression @functional
  Scenario: As a User, I should see the recent search with cross'X' button is displayed when clicked on search bar if user has searched for any product in the past
    When click on search field
    And enter text in search field
    And select item from search result list
    And close toggle info popup
    And click cancel button on product search page
    When click on search field
    Then cross button is displayed
    And click cancel button on product search page

  #C10360
  @regression @functional @smoke
  Scenario: As a User, I should see products listing screen on selecting an item from list of search results
    When click on search field
    And enter text in search field
    And select keyword from search result
    And close toggle info popup
    Then verify products listing page displayed

  #C10359
  @regression @functional
  Scenario: As a User, I should delete the recent search in search results on clicking on 'X' button beside recent search result
    When click on search field
    And enter text in search field
    And select item from search result list
    And close toggle info popup
    When click search field
    And click text clear button on search field
    Then verify text cleared on search field
    And click cancel button on product search page

  #C10361
  @regression @functional
  Scenario: As a User, I should see "No results for 'searched text' text" when searched item doesn't have results
    When click on search field
    And search using keyword which has no result
    Then verify no result error message displayed

  #C10363



#  #C69762
#  @regression @functional @start_scenario
#  Scenario:  As a user, I want to see Deals toggle in search result page of Deals screen, and able to switch the  'toggle deals'
#    When sign in to the application using account with no redeemed rewards and no deals clipped
#    Then verify home screen is displayed
#    And navigate to deals tab
#    When click search icon on deals page
#    And enter text in search field
#    And select item from search result list
#    And close toggle info popup
#    Then verify deals toggle is displayed in search result page
#    And click cancel button on product search page
#
#  #C69763
#  @regression @functional
#  Scenario: As a user, I should able to filter only the deals from the complete list
#    And navigate to deals tab
#    When click search icon on deals page
#    And enter text in search field
#    And select item from search result list
#    And close toggle info popup
#    Then switch to toggle Deal
#    Then verify deal cards are displayed
#    And click cancel button on product search page

  #C69756
  @regression
  Scenario: Verify User can see Deals Title , Search Icon , and My Cart Icon
    And navigate to deals tab
    Then verify search icon is displayed
    And verify deals title is displayed
    Then verify My Cart is Displayed

   #C69758
  @regression @functional
  Scenario: As a user, check if search icon, cart  and navigation bar remains fixed upon scrolling
    And navigate to deals tab
    Then verify search icon is displayed
    And verify My Cart is Displayed
    Then scroll down on the page

   #C67039
  @regression @functional @start_scenario
  Scenario: As a User, I should be able to search for the product from dashboard search bar
    When sign in to the application
    Then verify home screen is displayed
#    When go to Home tab
#    And select the pick-up store
#    And click on search field
#    And enter text "Apple" in search field
#    And select item from search result list
#    And close toggle info popup
#    Then verify products are displayed on clicking search results item
#    Then verify products listing page displayed
#    And click cancel button on search screen
#    Then verify dashboard page is displayed

   #C69460
  @regression @functional
  Scenario: As a user, I should be able to see the search bar with scan icon on dashboard screen and across all navigation bars on the app
    When go to Home tab
    Then verify that barcode scan option is displayed

  #C69759
  @regression @functional
  Scenario: As a User, i should see that count of items incrementated or decrementated  on "My cart" icon when some items are added to the cart
    When go to Home tab
    When search a product on home page
    Then add and remove an item on product details page and verify count of items after adding a product and removing item
    And click cancel button on search screen

  #C69760
  @regression @functional
  Scenario: As a user i should see "Full carts & happy hearts" displayed on you mycart screen when there are zero items on your cart
    When click on home tab
    Then click on My Cart Icon
    And clear cart items
    Then Verify Full Carts & happy hearts message is displayed
    And click done on Estimated Total screen

   #C69757
  @regression @end_scenario
  Scenario: As a User, current search bar and banner is removed from top in Deals section
    And navigate to deals tab
    And verify search bar is not displayed

   ## Search icon is removed from deals
    #  #C69762
#  @regression @functional @start_scenario
#  Scenario:  As a user, I want to see Deals toggle in search result page of Deals screen, and able to switch the  'toggle deals'
#    When sign in to the application
#    Then verify home screen is displayed
#    And navigate to deals tab
#    When click search icon on deals page
#    And enter text "Apple" in search field
#    And select item from search result list
#    And close toggle info popup
#    Then verify deals toggle is displayed in search result page
#    And click cancel button on product search page

   ## Search icon is removed from deals
#  #C69763
#  @regression @functional
#  Scenario: As a user, I should able to filter only the deals from the complete list
#    And navigate to deals tab
#    When click search icon on deals page
#    And enter text "Apple" in search field
#    And select item from search result list
#    And close toggle info popup
#    Then switch to toggle Deal
#    Then verify deal cards are displayed
#    And click cancel button on product search page

   ## Search icon is removed from deals
#  #C69756
#  @regression
#  Scenario: Verify User can see Deals Title , Search Icon , and My Cart Icon
#    And navigate to deals tab
#    Then verify search icon is displayed
#    And verify deals title is displayed
#    Then verify My Cart is Displayed

   ## Search icon is removed from deals
#   #C69758
#  @regression @functional
#  Scenario: As a user, check if search icon, cart  and navigation bar remains fixed upon scrolling
#    And navigate to deals tab
#    Then verify search icon is displayed
#    And verify My Cart is Displayed
#    Then scroll down on the page




  @regression
  Scenario: As a User, I should be able to search for the product from dashboard search bar
    When sign in to the application
    Then verify home screen is displayed
    When go to Home tab
    And click on shopping mode down arrow
    And select the pick-up store
    And click on search field
    And enter text "Milk" in search field
    And select item from search result list
    And close toggle info popup
    Then verify products are displayed on clicking search results item
    Then verify products listing page displayed
    And click cancel button on search screen
    Then verify dashboard page is displayed