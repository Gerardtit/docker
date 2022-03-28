Feature: Deals - BOGO

  #C69661
  @regression @module_deals @deals_bogo @functional @start_scenario
  Scenario: As a user, I should be able to pull the screen and refresh the page in For You, Categories, PROMO, BOGO, All Coupons  screen
    When sign up to the application with popup handling
    And go to Home tab
    And go to Deals tab
    And click on for you tab
    And refresh the page and verify progress spinner is displayed
    Then click on categories tab
    And refresh the page and verify progress spinner is displayed
    Then go to 'All Deals' Tab
    And refresh the page and verify progress spinner is displayed
    Then go to 'Promo' Tab
    And refresh the page and verify progress spinner is displayed
    Then user navigate to 'BOGO' Tab
    And refresh the page and verify progress spinner is displayed

   #C69182
  @regression @module_deals @deals_bogo @functional
  Scenario: As a user, I should be able to see BOGO categories along with products associated with it in carousel view
    When kill and relaunch the application without popup handling
    And click Continue on cache pop up for "android" platform
    And handle tutorial if displayed
    And click Continue on cache pop up
    When navigate to deals tab
    And user navigate to 'BOGO' Tab
    Then verify BOGO categories are displayed
    And expand the product category with deals "more" than 5
    Then verify BOGO products are in carousel view
    When kill and relaunch the application without popup handling
    And handle tutorial if displayed
    And navigate to deals tab
    And user navigate to 'BOGO' Tab
    And expand first available category on BOGO page
    And click on a BOGO product
    Then verify BOGO product details page displayed
    When click view all related products link on BOGO product details page
    Then verify BOGO related products page displayed

   #C70124
  @regression @module_deals @deals_bogo @functional
  Scenario: As a User, I should be able to Add multiple products (Make cart count 50  or more)  to cart from BOGO with no crash
    When kill and relaunch the application without popup handling
    And click Continue on cache pop up for "android" platform
    And handle tutorial if displayed
    And click Continue on cache pop up
    When navigate to deals tab
    And user navigate to 'BOGO' Tab
    And expand first available category on BOGO page
    Then verify user is able to more than 50 counts of BOGO products successfully

  #C69186
  @regression @module_deals @deals_bogo
  Scenario: As a user, I should see a spinner loading if the product card loading takes  long time
    When kill and relaunch the application without popup handling
    And click Continue on cache pop up for "android" platform
    And handle tutorial if displayed
    And click Continue on cache pop up
    When navigate to deals tab
    And user navigate to 'BOGO' Tab
    And expand first available category on BOGO page
    Then verify spinner is displayed on BOGO page until products load

   #C69187
  @regression @module_deals @deals_bogo
  Scenario: As a user , I should able to "See All card " for category with products more than page size and on clicking See all user should be navigated to existing Bogo CategoryDetailsPage
    When kill and relaunch the application without popup handling
    And click Continue on cache pop up for "android" platform
    And handle tutorial if displayed
    And click Continue on cache pop up
    When navigate to deals tab
    When user navigate to 'BOGO' Tab
    And expand the product category with deals "more" than 20
    And swipe left on deal cards until 'See all' is displayed on BOGO page
    And click on 'See all' button under BOGO category
    Then verify category detail page is displayed

   #C69624
  @regression @module_deals @deals_bogo @functional
  Scenario: Kill and relaunch - deals(Bogo)
    When kill and relaunch the application without popup handling
    And click Continue on cache pop up for "android" platform
    And handle tutorial if displayed
    And click Continue on cache pop up
    When navigate to deals tab
    And user navigate to 'BOGO' Tab
    Then verify BOGO categories are displayed
    When kill and relaunch the application without popup handling
    And handle tutorial if displayed
    When navigate to deals tab
    When user navigate to 'BOGO' Tab
    Then verify BOGO categories are displayed

  #C16435
  @regression @module_deals @deals_bogo @functional
  Scenario: BOGO - Verify Aisles
    When kill and relaunch the application without popup handling
    And click Continue on cache pop up for "android" platform
    And handle tutorial if displayed
    And click Continue on cache pop up
    When navigate to deals tab
    When user navigate to 'BOGO' Tab
    Then expand category verify BOGO products displayed

  #C16437
  @regression @module_deals @deals_bogo @functional
  Scenario: BOGO- ADD/Remove/Update Qty/ Max QTY
    When kill and relaunch the application without popup handling
    And click Continue on cache pop up for "android" platform
    And handle tutorial if displayed
    And click Continue on cache pop up
    And go to Home tab
    When click on My Cart Icon
    And clear cart items
    And click on close button on my cart screen
    And navigate to deals tab
    When user navigate to 'BOGO' Tab
    Then expand category verify BOGO products displayed
    When add 1 number of BOGO products on product details page and verify count on cart is increased
    Then decrement the product count from product details page and verify count on cart is decreased
    Then add more than 20 counts of the same product on BOGO product details page and verify that only 20 counts can be added

  #C16440
  @regression @module_deals @deals_bogo @functional
  Scenario: BOGO product details - related products and view all/ Deals / Sort filters
    When kill and relaunch the application without popup handling
    And click Continue on cache pop up for "android" platform
    And handle tutorial if displayed
    And click Continue on cache pop up
    When navigate to deals tab
    When user navigate to 'BOGO' Tab
    Then expand category verify BOGO products displayed
    When click on a BOGO product
    Then verify BOGO product details page displayed
    When click view all related products link on BOGO product details page
    Then verify BOGO related products page displayed
    And navigate back to previous page
    And navigate back to previous page

  #C16436
  @regression @module_deals @deals_bogo
  Scenario: Add product with offer/Offer details page
    When kill and relaunch the application without popup handling
    And click Continue on cache pop up for "android" platform
    And handle tutorial if displayed
    And click Continue on cache pop up
    When navigate to deals tab
    When user navigate to 'BOGO' Tab
    Then expand category verify BOGO products displayed
    And click BOGO offer link on product card
    Then verify offer details page displayed
    And close deal details page

  #C20818
  @regression @module_deals @deals_bogo @end_scenario
  Scenario: Verify coupon after clipped with link and navigates to offer details
    When kill and relaunch the application without popup handling
    And click Continue on cache pop up for "android" platform
    And handle tutorial if displayed
    And click Continue on cache pop up
    And go to Home tab
    When click on My Cart Icon
    And clear cart items
    And click on close button on my cart screen
    And navigate to deals tab
    When user navigate to 'BOGO' Tab
    Then expand category verify BOGO products displayed
    And add 2 number of BOGO products on product details page and verify count on cart is increased
    And click on My Cart Icon
    And click offer details on my cart page
    Then verify offer details page displayed
    And close deal details page
    Then click on close button on my cart screen
