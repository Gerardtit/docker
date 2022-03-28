@gg_SearchWithFilter_HomePage
Feature: Validate Search with Filter in Home Page

  @unittest   #MMM-3995
  Scenario: Verify mediumBanner content with HTML tags in Home page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When scroll down for "waterfrontBISTRO" carousel
    Then verify "waterfrontBISTRO®" title is displayed
    Then verify "Raised, caught for thriving ocean ecosystems1" sub title is displayed


  @unittest   #MMM-4048
  Scenario: Verify mediumBanner content with HTML tags in Landing page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When scroll down for "Hooked on Freshness" carousel
    And user clicks on "Hooked on Freshness" button
    And scroll down for "waterfrontBISTRO" carousel
    Then verify "waterfrontBISTRO®" title is displayed
    Then verify "Raised, caught for thriving ocean ecosystems1" sub title is displayed

  @unittest  #MMM-3842  #test data is present in Shaws banner(zipcode-03885)
  Scenario: Verify Medium banner CTA search deals with keyword in home page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When scroll down for "Search with Deals" carousel
    And user clicks on "Search with Deals" button
    And user clips products
    When click on search field
    And user types "baby oil" on search bar and click search on home page
    Then verify result is displayed on the page
    When click on Products toggle in search page
    Then verify refine button is present
    When click on Deals toggle in search page
    Then verify refine button is not present
    And click on Cancel in Search page
    Then verify user is able to see "Search with Deals"


  @unittest #unfinished  #MMM-4020  #test data is present in Shaws banner(zipcode-03885)
  Scenario: Verify Medium banner CTA search deals with keyword in home page - landing page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When scroll down for "Hooked on Freshness" carousel
    And user clicks on "Hooked on Freshness" button
    And scroll down for "Search with Deals" carousel
    And user clicks on "Search with Deals" button
    And user clips products
    When click on search field
    And user types "baby oil" on search bar and click search on home page
    Then verify result is displayed on the page
    When click on Products toggle in search page
    Then verify refine button is present
    When click on Deals toggle in search page
    Then verify refine button is not present
    And click on Cancel in Search page
    Then verify user is able to see "Search with Deals"

  @SwathiTestHome3844 #MMM-3844 #test data is present in shaws banner(Zipcode- 03885)
  Scenario: Verify Medium banner CTA search deals with keyword in home page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When scroll down for "Aisles" carousel
    And user clicks on "Aisles" button
    When user clicks "1" item add button on first item
    And click on the first product to go to pdp
    And user clicks increase button for 1 times on cart page
    And user clicks shopping cart button on home page
    Then shopping cart shows 2 as total number
    And user clicks back button to close the cart
    And user navigates back to landing page
    When click on Deals toggle in search page
    Then verify Deals toggle setting is ON state
    When click on Deals toggle in search page
    Then verify Deals toggle setting is OFF state
    When user click sort or filters from item list window
    Then user select "Alphabetical" from Sort & Filter By window
    When user clicks search icon on Aisles page
    When click on search Products Or Deals field
    And user types "milk" on search bar
    Then user click on cancel button in search bar
    And user navigates back to landing page

  @SwathiTestHome4022 #MMM-4022 #test data is present in shaws banner(Zipcode- 03885)
  Scenario: Verify Medium banner CTA search deals with keyword in home page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When scroll down for "Hooked on Freshness" carousel
    And user clicks on "Hooked on Freshness" button
    When scroll down for "Aisles" carousel
    And user clicks on "Aisles" button
    When user clicks "1" item add button on first item
    And click on the first product to go to pdp
    And user clicks increase button for 1 times on cart page
    And user clicks shopping cart button on home page
    Then shopping cart shows 2 as total number
    And user clicks back button to close the cart
    And user navigates back to landing page
    When click on Deals toggle in search page
    Then verify Deals toggle setting is ON state
    When click on Deals toggle in search page
    Then verify Deals toggle setting is OFF state
    When user click sort or filters from item list window
    Then user select "Alphabetical" from Sort & Filter By window
    When user clicks search icon on Aisles page
    When click on search Products Or Deals field
    And user types "milk" on search bar
    Then user click on cancel button in search bar
    And user navigates back to landing page

  @SwathiTestHome4023 #MMM-4023 #test data is present in shaws banner(Zipcode- 03885)
  Scenario: Verify Medium banner CTA search deals with keyword in home page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When scroll down for "Hooked on Freshness" carousel
    And user clicks on "Hooked on Freshness" button
    When scroll down for "Aisles with Filters" carousel
    And user clicks on "Aisles with Filters" button
    When user clicks "1" item add button on first item
    And click on the first product to go to pdp
    And user clicks increase button for 1 times on cart page
    And user clicks shopping cart button on home page
    Then shopping cart shows 2 as total number
    And user clicks back button to close the cart
    And user navigates back to landing page
    When click on Deals toggle in search page
    Then verify Deals toggle setting is ON state
    When click on Deals toggle in search page
    Then verify Deals toggle setting is OFF state
    When user click sort or filters from item list window
    Then user select "Alphabetical" from Sort & Filter By window
    When user clicks search icon on Aisles page
    When click on search Products Or Deals field
    And user types "cookies" on search bar
    Then user click on cancel button in search bar
    And user navigates back to landing page


  @unittest   #MMM-3843 #test data is present in shaws banner(Zipcode- 03885)
  Scenario: Verify Medium banner CTA search deals with keyword in home page - landing page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    And scroll down for "Search with Filters" carousel
    And user clicks on "Search with Filters" button
    When user clicks "1" item add button on first item
    When user adds the item to cart using the '+' icon on product details page
    And user clicks shopping cart button on home page
    Then shopping cart shows 2 as total number
    And user clicks back button to close the cart
#    Then item should be added to the cart
#    And get count of items from cart
    When user removes the item to cart using the '-' icon on product details page
    And user clicks shopping cart button on home page
    Then shopping cart shows 1 as total number
    And user clicks back button to close the cart
#    Then item should be removed from the cart
    And click on the first product to go to pdp
    And user navigates back from External link to landing page
    When click on search field
    And user types "baby oil" on search bar and click search on home page
    Then verify result is displayed on the page
    When click on Deals toggle in search page
    Then verify refine button is not present
    When click on Products toggle in search page
    Then verify refine button is present
    And click on Cancel in Search page
    Then verify user is able to see "Search with Deals"


  @unittest   #MMM-3843 #test data is present in shaws banner(Zipcode- 03885)
  Scenario: Verify Medium banner CTA search with Filter with keyword in home page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    And scroll down for "Search with Filters" carousel
    And user clicks on "Search with Filters" button
    When user clicks "1" item add button on first item
    When user adds the item to cart using the '+' icon on product details page
    And user clicks shopping cart button on home page
    Then shopping cart shows 2 as total number
    And user clicks back button to close the cart
#    Then item should be added to the cart
#    And get count of items from cart
    When user removes the item to cart using the '-' icon on product details page
    And user clicks shopping cart button on home page
    Then shopping cart shows 1 as total number
    And user clicks back button to close the cart
#    Then item should be removed from the cart
    And click on the first product to go to pdp
    And user navigates back from External link to landing page
    When click on search field
    And user types "baby oil" on search bar and click search on home page
    Then verify result is displayed on the page
    When click on Deals toggle in search page
    Then verify refine button is not present
    When click on Products toggle in search page
    Then verify refine button is present
    And click on Cancel in Search page
    Then verify user is able to see "Search with Deals"


  @unittest   #MMM-4021 #test data is present in shaws banner(Zipcode- 03885)
  Scenario: Verify Medium banner CTA search deals with keyword in home page - landing page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When scroll down for "Hooked on Freshness" carousel
    And user clicks on "Hooked on Freshness" button
    And scroll down for "Search with Filters" carousel
    And user clicks on "Search with Filters" button
    When user clicks "1" item add button on first item
    When user adds the item to cart using the '+' icon on product details page
    And user clicks shopping cart button on home page
    Then shopping cart shows 2 as total number
    And user clicks back button to close the cart
#    Then item should be added to the cart
#    And get count of items from cart
    When user removes the item to cart using the '-' icon on product details page
    And user clicks shopping cart button on home page
    Then shopping cart shows 1 as total number
    And user clicks back button to close the cart
#    Then item should be removed from the cart
    And click on the first product to go to pdp
    And user navigates back from External link to landing page
    When click on search field
    And user types "baby oil" on search bar and click search on home page
    Then verify result is displayed on the page
    When click on Deals toggle in search page
    Then verify refine button is not present
    When click on Products toggle in search page
    Then verify refine button is present
    And click on Cancel in Search page
    Then verify user is able to see "Search with Deals"


  @SwathiTestHome3845 #MMM-3845 #test data is present in shaws banner(Zipcode- 03885)
  Scenario: Verify Medium banner CTA search deals with keyword in home page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When scroll down for "Aisles with Filters" carousel
    And user clicks on "Aisles with Filters" button
    When user clicks "1" item add button on first item
    And click on the first product to go to pdp
    And user clicks increase button for 1 times on cart page
    And user clicks shopping cart button on home page
    Then shopping cart shows 2 as total number
    And user clicks back button to close the cart
    And user navigates back to landing page
    When click on Deals toggle in search page
    Then verify Deals toggle setting is ON state
    When click on Deals toggle in search page
    Then verify Deals toggle setting is OFF state
    When user click sort or filters from item list window
    Then user select "Alphabetical" from Sort & Filter By window
    When user clicks search icon on Aisles page
    When click on search Products Or Deals field
    And user types "cookies" on search bar
    Then user click on cancel button in search bar
    And user navigates to landing page for ios