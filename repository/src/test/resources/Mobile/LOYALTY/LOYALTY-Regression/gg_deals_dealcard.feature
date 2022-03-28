Feature: Deal Card

  #C69505
  @regression @module_deals @deals_dealcard @start_scenario
  Scenario: As a User , As a user , I should see the existing deal detail page which shows the list of qualifying products, on clicking on the Deal card tiles or anywhere in the deal card under Deals-> 'For You'
    When sign up to the application with popup handling
    And go to Home tab
    And navigate to deals tab
    And go to 'For you' Tab
    And scroll down to item you may like module
    And click see all link beside item you may like module
    And user clicks on a deal with eligible products in items you may like page
    Then verify eligible products are displayed in offer details page
    And close deal details page
    And click on close button on deal listing page

  #C69506
  @regression @module_deals @deals_dealcard
  Scenario: As a User , As a user , I should see the existing deal detail page which shows the list of qualifying products, on clicking on the Deal card tiles or anywhere in the deal card under Deals->'All Coupons'
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And go to 'All Deals' Tab
    And scroll up till top of the All Deals tab
    And click on deal card
    Then verify deal detail page is displayed
    And close deal details page

  #C69507
  @regression @module_deals @deals_dealcard
  Scenario: As a User , I should see the existing deal detail page which shows the list of qualifying products, on clicking on the Deal card tiles or anywhere in the deal card under Deals->'Promo'
    When navigate to deals tab
    When go to 'Promo' Tab
    And click on deal card on 'Promo deals'
    Then verify qualifying Products is displayed on 'Promo deals'
    And navigate back to previous page

  #C69508
  @regression @module_deals @deals_dealcard
  Scenario: As a User , I should see the existing deal detail page which shows the list of qualifying products, on clicking on the Deal card tiles or anywhere in the deal card under Deals->'BOGO'
    When navigate to deals tab
    And user navigate to 'BOGO' Tab
    And expand first available category on BOGO page
    And click on a BOGO product
    Then verify BOGO product details page displayed
    And navigate back to previous page

  #C69509
  @regression @module_deals @deals_dealcard
  Scenario: As a user , on clicking the ‘View Products’ of deal card under Deals->‘For you’ user should navigate to deal details page which lists Qualifying Products
    And navigate to deals tab
    And go to 'For you' Tab
    And scroll up till top of the ForYou tab
    And click Got it on welcome card on For you page
    And scroll down to Associate offer module deal card
    And clip a deal if not already clipped
    And click on eligible products CTA on deal card
    Then verify eligible products are displayed in offer details page
    And close deal details page

  #C69512
  @regression @module_deals @deals_dealcard
  Scenario: As a user , on clicking the ‘ of deal card under Deals-> ‘BOGO' user should navigate to deal details page which lists Related Products
    When kill and relaunch the application without popup handling
    And click Continue on cache pop up for "android" platform
    And handle tutorial if displayed
    And navigate to deals tab
    And user navigate to 'BOGO' Tab
    And expand first available category on BOGO page
    Then verify BOGO products displayed

  #C68897
  @regression @module_deals @deals_dealcard
  Scenario: As a User, I should be able to see mentioned details for deal card throughout the app
    When go to Home tab
    And scroll down upto weekly coupons section
    Then verify weekly coupon card components

  #C68893
  @regression @module_deals @deals_dealcard
  Scenario: As a User, I should be able to see Deals card component in Home screen and Deals screen
    And kill and relaunch the application without popup handling
    And click Continue on cache pop up for "android" platform
    And handle tutorial if displayed
    And click on home tab
    And scroll down upto weekly coupons section
    Then verify weekly coupon card components
    And navigate to deals tab
    And go to 'All Deals' Tab
    Then verify deal card components

  #C7694
  @regression @module_deals @deals_dealcard
  Scenario: Verify the Search Bar and Banner Logo is currently not shown in the Deals Screen
    When navigate to deals tab
    Then verify search bar "is not" displayed

  #C7513
  @regression @module_deals @deals_dealcard
  Scenario: As a user, I should see For you, All Coupons, Promo, Bogo section in deals
    When navigate to deals tab
    And scroll up till deals top nav bar is visible
    And go to 'All Deals' Tab
    And scroll up till top of the All Deals tab
    Then verify total deals count is displayed on all deals page
    When go to 'For you' Tab
    And scroll up till top of the ForYou tab
    Then verify "My rewards" link is displayed in carousel on For you page
    When go to 'Promo' Tab
    And verify Promo card CTA button
    When user navigate to 'BOGO' Tab
    Then verify BOGO categories are displayed

  #C69363
  @regression @module_deals @deals_dealcard
  Scenario: As a User, I should see app must scroll the top for all deals subsection and header should show up if the user starts scrolling up.
    When navigate to deals tab
    And scroll up till deals top nav bar is visible
    And go to 'For you' Tab
    And scroll up till top of the ForYou tab
    And scroll down on the page
    And scroll up on the page
    Then verify Deals navigation bar "is" displayed

  #C70435
  @regression @module_deals @deals_dealcard
  Scenario: As a User, I should be able to see deals header scrolls away when i start scrolling down
    When navigate to deals tab
    And scroll up till deals top nav bar is visible
    And go to 'For you' Tab
    And scroll up till top of the ForYou tab
    Then verify Deals displayed in header
    And scroll down the screen
    Then verify Deals displayed in header

  #C70436
  @regression @module_deals @deals_dealcard
  Scenario: As a User, I should be able to see deals Title , cart & search icons pinned to screen when i start scrolling down
    When navigate to deals tab
    And scroll down the screen
    Then verify Deals displayed in header
    And verify My Cart icon is displayed

  #C70437
  @regression @module_deals @deals_dealcard
  Scenario: As a User, I should be able to see deals search bar pinned to screen when i start scrolling down
    When navigate to deals tab
    And scroll down the screen
    Then verify search bar is displayed

  #C70438
  @regression @module_deals @deals_dealcard
  Scenario: As a User, I should be able to see deals header shows up when i start scrolling up
    When navigate to deals tab
    Then verify Deals displayed in header
    And scroll down the screen
    Then verify Deals displayed in header

  #C70439
  @regression @module_deals @deals_dealcard
  Scenario: As a user, I should be able to see Cancel button beside search bar on deals search
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And go to 'All Deals' Tab
    And scroll up till top of the All Deals tab
    And click on search bar displayed on deals page
    Then verify cancel button is displayed
    And click cancel button after deal search

  #C70440
  @regression @module_deals @deals_dealcard
  Scenario: As a User, i should be able to see the deals i searched for
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And go to 'All Deals' Tab
    And scroll up till top of the All Deals tab
    Then search for deals on "Milk" on deals page search bar
    And verify deals related to "Milk" are displayed
    And click cancel button after deal search

  #C70441
  @regression @module_deals @deals_dealcard
  Scenario: As a User, I should be able to see screen scrolling up to show filtered deal count & deals header on deal search
    When navigate to deals tab
    And scroll up till deals top nav bar is visible
    And go to 'For you' Tab
    And scroll up till top of the ForYou tab
    Then search for deals on "Milk" on deals page search bar
    And verify filtered deals count is displayed
    Then verify Deals displayed in header
    And click cancel button after deal search

  #C70442
  @regression @module_deals @deals_dealcard @functional @end_scenario
  Scenario: As a User, I should be able to retain the screen state on backgrounding and foregrounding the app
    When navigate to deals tab
    And scroll down the screen
    Then verify search bar is displayed
    When keep app in background and relaunching the same
    Then verify search bar is displayed

    ## Search icon is removed in deals
    #  #C69364
#  @regression @module_deals @deals_dealcard
#  Scenario: As a User, I should see all deals subsection, Refine and the number of items should hide/show when scroll down/up
#    Then verify Deals navigation bar "is" displayed
#    And scroll down on the page
#    Then verify Deals displayed in header
#    Then verify search icon is displayed
#    Then verify My Cart icon is displayed
#    Then verify Deals navigation bar "is not" displayed
#    And scroll up on the page
#    Then verify Deals navigation bar "is" displayed

  #  #C69510
#  @regression @module_deals @deals_dealcard
#  Scenario: As a user , on clicking the ‘View Products’ of deal card under Deals->‘All coupons' user should navigate to deal details page which lists Qualifying Products
#    And click 'Yes' if 'Love the app' popup is displayed
#    And navigate to deals tab
#    And scroll up till deals top nav bar is visible
#    And go to 'All Deals' Tab
#    And scroll up till top of the All Deals tab
#    And clip a deal if not already clipped
#    And click on eligible products CTA on deal card
#    Then verify eligible products are displayed in offer details page
#    And close deal details page