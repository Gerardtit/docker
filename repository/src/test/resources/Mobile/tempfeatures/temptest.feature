@deals
Feature: Deals Feature

  Background: setup user on Home Page
    When navigate to home page
    Then home page is displayed
    When user clicks shopping cart button on home page
    Then shopping cart page is displayed
    When user empty shopping cart
    Then shopping cart empty page is displayed
    When user clicks navigate back to the previous page
    Then home page is displayed
    When user clicks deals on home page
    Then deals page is displayed

  @regression
  Scenario: Promo Code Deals - click coupon, add item, click cart, and come back click search
    When user clicks Promo Code Deals on deals page
    Then promo code deals window is displayed
    When user clicks "SAVE NOW" text on page
     #Then "Qualifying Products" text is displayed on the screen
     #When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    When user clicks navigate back to the previous page
    Then promo code deals window is displayed
    When user clicks search icon from deals page
    Then "Currently Trending" text is displayed on the screen

  @regression
  Scenario: Club Card Deals - Select from aisle, add item, change Qty to max, check PDP and related product
    When user clicks Club Card Deals on deals page
    Then club card deals window is displayed
    When scroll down the screen
    And user clicks "Deli" text on page
    Then verify item is found from aisle
    When user clicks "1" item add button on first item
    And user change quantity to "10" number of items
    And user clicks 1 product in the search list
    Then product detail page is displayed
    And related item is displayed on the product detail page
    When scroll down the screen
    When scroll down the screen
    And "Details" text is displayed on the screen
    And "Ingredients" text is displayed on the screen
    And "View All" text is displayed on the screen

  @regression
  Scenario: BOGO Deals - Select from aisle, add item, change Qty to max, check PDP and related product
    When user clicks Buy one get one free on deals page
    Then "Buy One, Get One Free" window is displayed
    When user clicks "Cookies, Snacks & Candy" text on page
    Then "Cookie, Snacks & Candy" window is displayed
    And buy one get on free text is displayed on the screen
    When user clicks "1" item add button on first item
    And user change quantity to "10" number of items
    And user clicks 1 product in the search list
    Then product detail page is displayed
    And related item is displayed on the product detail page
    When scroll down the screen
    And "Details" text is displayed on the screen
    And "Ingredients" text is displayed on the screen
    And "View All" text is displayed on the screen


  Scenario: Verify Aisles - L1/L2/L3 Product, and add products and max the quantity
    When user clicks item "Baby Care" on aisle list
    When user clicks item "Baby Bath & Skin Care" on aisle list
    When user clicks item "Baby Body Wash" on aisle list
    Then verify item is found from aisle
    When user clicks "1" item add button on first item
    And user change quantity to "10" number of items
    And user clicks shopping cart button on home page
    Then shopping cart shows 10 as total number

  #Deals feature
  #club card - strike through
  #shop cart feature
  #Verify Global substitution option is disabled for MFC stores
  #Unavailable Item and verify similar item

  #chat bot for specific banner ???
  #my account feature
  #Subscription - Valid only for subscribed user
  #add address - delta new register
  #add phone contact - delta
  #add phone use in store - delta
  #add store address - DUG address - delta
  #password more than 40 - edit text field only allow 40
  #Address - Off banner Update
  #DUG - Edit Store
  #Email Address - Off banner as well
  #Communication - Verify all toggles with  ON/OFF

  #order info feature:
  #Contact -  SMS opt in / Legal copy / Add first name and Last name
  #update address in Order Info - DUG / Unattended / Attended
  #new user w/o contact, address, credit card, ...
  #promo code - if not select delivery time, popup to edit time
  #Attended delivery - default 2hr
  #Delivery windows - 3PL and standard slots
  #Unattended - Restricted Item flow with Prebook, checkout and Edit Order

  #search page features:
  #Search with Voice over
  #Scan for valid and Invalid products- Add item
  #Add product with offer/Offer details page
  #Banner logo and Animation search box
  #Sponsor product - ex Bread, Water, Soda

  #home page features:
  # osso message - place order and verify
  # AEM content under fulfillment section if applicable.
  # Banner Ads
  # Add items from Home screen /Verify  from PDP as well - MAX qty also there
  # Verify Product pod with offers

  #Preference selection screen should not display after sign in - unless preference is changed from other platform
  #select DUG - off banner
  #Verify login use other banner credentials - off banner
  # Register with Off Banner
  # Scenario: Scan as guest - need to add scan code item
  #Scenario: J4U Coupon as guest - no option available
  #Scenario: Reserve time as guest - no option available