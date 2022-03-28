Feature: Dashboard Module Feature

  #C69397
  @regression @module_dashboard @start_scenario
  Scenario: As a User, I should see Top AEM banner in Dashboard screen with navigation
    When sign up to the application with popup handling
    And go to Home tab
    Then verify top AEM banner
    And keep app in background and relaunching the same
    Then verify top AEM banner
    And click on top AEM banner
    Then verify application is not crashed after clicking on AEM banner by checking for back button
    And navigate back to previous page

  #C69398
  @regression @module_dashboard
  Scenario: As a User, I should see  'Top AEM banner' is as per theme and UX design
    When go to Home tab
    Then verify top AEM banner

  #C67045
  @regression @module_dashboard
  Scenario: As a User, I should see Search bar as per theme and UX design
    When go to Home tab
    Then verify search bar "is" displayed

    #C10449
  @regression @module_dashboard
  Scenario: As a user I Should see cart works as expected
    When go to Home tab
    And select the pick-up store
    Then verify cart icon present next to search bar
    And click on My Cart Icon
    And clear cartV2 items
    And close cart screen
    Then verify zero count on cart Button
    And search a product on home page
    And add and remove an item on product details page and verify count of items after adding a product and removing item
    And click cancel button on product search page

   #C69434
  @regression @module_dashboard
  Scenario: As a User, I should navigate to existing more screen on shop app on tapping on 'My Profile' icon in dashboard
    When go to Home tab
    And click on my profile icon
    Then verify menu page is displayed
    And close menu page

    #C69436
  @regression @module_dashboard
  Scenario: As a User, i should see 'My Profile' icon and colour as per the design and respective banners
    When go to Home tab
    Then verify my profile icon

  #C68950
  @regression @module_dashboard
  Scenario: Order and  navigation flows of tab bar
    Then verify bottom tab bar order

  #C69165
  @regression @module_dashboard @functional
  Scenario: As a User, i should see that the bottom navigation/tab bars are updated as per the design for selected / unselected screen
    When go to Home tab
    Then verify Home tab is selected
    When go to Browse tab
    Then verify Browse tab is selected
    And navigate to deals tab
    Then verify Deals tab is selected
    And Click on my list tab
    Then verify My Items tab is selected
    And go to Wallet in Member tab
    Then verify wallet header
    Then verify wallet tab is selected

  #C68952
  @regression @module_dashboard
  Scenario: As a user , I should not see bottom navigation bar in existing screen of ecommerce app
    When go to Home tab
    And select the store which has exclusive brands enabled
    Then verify bottom navigation bar
    And scroll down to Save On Our Brands Module
    And click deal from Save on our brands module
    Then verify deal detail page is displayed
    And bottom navigation bar is not displayed
    And close deal details page

   #C69739
  @regression @module_dashboard
  Scenario: Kill  and Relaunch  - Dashboard "Must Have Grab',Weekly Ad Banner,Fresh New coupons,We can help and save on our brands.
    When go to Home tab
    And select the pick-up store
    Then verify must have grabs label displayed
    And click see all button displayed next to must have grabs
    Then verify Must Have Grabs Screen page is displayed
    And kill the application
    And relaunch the application
    And handle zip code page if displayed
    And handle tutorial if displayed on home page
    And go to Home tab
    Then verify must have grabs label displayed
    And scroll down upto weekly ads section
    And kill the application
    And relaunch the application
    And handle tutorial if displayed on home page
    And go to Home tab
    And scroll down upto weekly ads section
    Then verify weekly ad banner module
    And scroll down upto weekly coupons section
    And kill the application
    And relaunch the application
    And handle tutorial if displayed on home page
    And go to Home tab
    And scroll down upto weekly coupons section
    Then verify weekly coupon section title
    When scroll up to profile icon on home page
    And select the store which supports pharmacy service
    Then verify more services module is displayed
    And kill the application
    And relaunch the application
    And handle tutorial if displayed on home page
    And go to Home tab
    And scroll down upto more services
    Then verify more services module is displayed
    And select the store which has exclusive brands enabled
    Then verify 'Save On Our Brands' module is displayed
    And kill the application
    And relaunch the application
    And handle tutorial if displayed on home page
    And go to Home tab
    When scroll up to profile icon on home page
    Then verify more services module is displayed
    And scroll down to Save On Our Brands Module
    Then verify 'Save On Our Brands' module is displayed

  #C69438
  @regression @module_dashboard
  Scenario: Kill  and Relaunch  - User profile and cart icon
    When go to Home tab
    And select the pick-up store
    And scroll up to profile icon on home page
    And keep app in background and relaunching the same
    Then verify my profile icon
    Then verify My Cart is Displayed
    And kill the application
    And relaunch the application
    And handle zip code page if displayed
    And handle tutorial if displayed on home page
    Then verify home screen is displayed
    And go to Home tab
    Then verify my profile icon
    Then verify My Cart is Displayed

  #C69465
  @regression @module_dashboard
  Scenario:  As a User, i should be able to see all the modules in the dashboard screen as per the design and respective banner
    When go to Home tab
    And select the pick-up store
    Then verify must have grabs label displayed
    And click see all button displayed next to must have grabs
    Then verify Must Have Grabs Screen page is displayed
    And user clicks back button in must have grabs
    And scroll down upto weekly ads section
    Then verify weekly ad banner module
    Then verify weekly coupon section title
    And scroll down upto more services
    Then verify more services module is displayed
    And scroll down to Save On Our Brands Module
    Then verify 'Save On Our Brands' module is displayed

  #C7605
  @regression @module_dashboard
  Scenario: As a user, i should see that  whenever i kill the app and re launch it, i should land on dashboard screen
    When kill the application
    And relaunch the application
    And handle zip code page if displayed
    And handle tutorial if displayed on home page
    Then verify home screen is displayed

  #C70388
  # Clip your favorites and see all deals banners are merged and are changed to clip your deals in instore-mode only
  @regression @module_dashboard @functional
  Scenario: As a user, I shoud navigate to All Deals by tapping any where in the banner
    When go to Home tab
    And select in-store run using zip code and store name
    And user clicks see all link of clip your deals module in home screen
    Then verify All deals tab is displayed
    And verify total deals count is displayed on all deals page

  #C70260
#  CustomizeHome is set by true as a default always
  @regression @module_dashboard
  Scenario: As a user, I shoud see dynamic drawer with rewards, clipped deals & weekly ad on the home page when "customizeHome" is true
    When go to Home tab
    And click "Rewards" link in shortcuts tray on home page
    Then verify that rewards page for u page title is displayed
    And click on home tab
    And click "Pharmacy" link in shortcuts tray on home page
    Then verify pharmacy services page is displayed
    And click back button in pharmacy services page
    And click "FreshPass" link in shortcuts tray on home page
    Then verify freshpass page is displayed
    And click on home tab
    And click "Deals" link in shortcuts tray on home page
    Then verify All deals tab is displayed
    And click on home tab
    And click "Weekly Ad" link in shortcuts tray on home page
    Then verify weekly ad iFrame is displayed
    And click on home tab

  #C70274
  @regression @module_dashboard @smoke
  Scenario: As a user, I should see navigate to home screen by tapping home icon from Weekly Ads screen
    When go to Home tab
    And scroll down upto weekly ads section
    Then verify weekly ad banner module
    And click on weekly ad banner
    Then verify weekly ad iFrame is displayed
    And click on home tab

#  #C70345
  @regression @module_dashboard @smoke
  Scenario: As a User, I should be able to see 'Must Have Grabs' section in Home when no customizeHome flag is set (default state) and no user purchaseHistory on all shopping modes
    When go to Home tab
    And select the delivery store
    And verify home screen is displayed
    Then verify must have grabs label displayed
    And select the pick-up store
    Then verify must have grabs label displayed

  #C70348
  #Clip your favorites and see all deals banners are merged and are changed to clip your deals in instore-mode only
  @regression @module_dashboard @smoke
  Scenario: As a User, I should be able to see 'Clip your deals' section in carousel view in Home when customizeHome flag is set to true on In-Store shopping mode
    When go to Home tab
    And select in-store run using zip code and store name
    Then verify home screen is displayed
    Then verify Clip your deals section is displayed

  #C70352
  # Clip your favorites and see all deals banners are merged and are changed to clip your deals in instore-mode only
  @regression @module_dashboard
  Scenario: As a User, I should see 'See all' CTA and on tapping it, Clip your deals' drawer should come up with deal count and all deal cards
    When go to Home tab
    And select in-store run using zip code and store name
    Then verify Clip your deals section is displayed
    Then verify see all link displayed in clip your deals module
    And user clicks see all link of clip your deals module in home screen
    Then verify total deals count is displayed on all deals page
    Then verify deal card components

  #C70353
  # Clip your favorites and see all deals banners are merged and are changed to clip your deals in instore-mode only
  @regression @module_dashboard
  Scenario: As a User, I should see max of 15 deal cards in carousel view under 'Clip your deals' section
    When go to Home tab
    And select in-store run using zip code and store name
    Then verify Clip your deals section is displayed
    Then verify maximum 15 deal cards is Displayed in clip your deals module

  #C70354
  # Clip your favorites and see all deals banners are merged and are changed to clip your deals in instore-mode only
  @regression @module_dashboard
  Scenario: As a User, I should see a card 'See all' CTA at the end of carousel and 'Clip your deals' drawer should come up with deal count and all deal cards on tapping 'See all'
    When go to Home tab
    And select in-store run using zip code and store name
    And slide the deal card and click on see all button on deal card of clip your deals module
    Then verify total deals count is displayed on all deals page
    Then verify deal card components

  #C70357
  # Clip your favorites and see all deals banners are merged and are changed to clip your deals in instore-mode only
  @regression @module_dashboard
  Scenario: As a User, I should navigate to deal detail screen on tapping on any deal under 'Clip your deals' section
    When go to Home tab
    And select in-store run using zip code and store name
    Then verify Clip your deals section is displayed
    And user clicks see all link of clip your deals module in home screen
    And click on deal card
    Then verify deal detail page is displayed
    And close deal details page
    And click cross button on drawer

  #C70358
  # Clip your favorites and see all deals banners are merged and are changed to clip your deals in instore-mode only
  @regression @module_dashboard
  Scenario: As a User, I should be able to see screen retain its state on backgrounding and foregrounding the app
    When go to Home tab
    And select in-store run using zip code and store name
    And verify Clip your deals section is displayed
    And keep app in background and relaunching the same
    Then verify Clip your deals section is displayed

  #C70359
  # Clip your favorites and see all deals banners are merged and are changed to clip your deals in instore-mode only
  @regression @module_dashboard
  Scenario: As a User, I should be able to see  'Clip your deals' UI and theme as per figma
    When go to Home tab
    And select in-store run using zip code and store name
    Then verify Clip your deals section is displayed
    And verify see all link displayed in clip your deals module
    Then verify deal card components
    And click cross button on drawer

  #C70350
  # Clip your favorites and see all deals banners are merged and are changed to clip your deals in instore-mode only
  @regression @module_dashboard
  Scenario: As a User, I should be able to see 'Clip your deals' section has all the deal cards and its content under 'items you like' in deals screen if there are no deals under 'items you buy'
    When go to Home tab
    And select in-store run using zip code and store name
    Then verify Clip your deals section is displayed
    And get the deal name under clip your deals module
    And go to Deals tab
    And go to 'For you' Tab
    Then verify 'Items you may like' module is displayed
    Then verify 'Clip your deals' section has all the deal cards and its content under 'items you like' in deals screen
    Then verify Item You Buy Module is not displayed

  #C70349
  # Clip your favorites and see all deals banners are merged and are changed to clip your deals in instore-mode only
  @regression @module_dashboard
  Scenario: As a User, I should be able to see 'Clip your deals' section has all the deal cards and its content under 'items you buy' in deals screen
    When forced sign out from the application
    And sign in to the application using account with items you buy
    And verify home screen is displayed
    Then select in-store run using zip code and store name
    Then verify home screen is displayed
    Then verify Clip your deals section is displayed
    And get the deal name under clip your deals module
    And go to Deals tab
    And go to 'For you' Tab
    And verify 'Clip your deals' section has all the deal cards and its content under 'items you like' in deals screen

  #C70389
  # Clip your favorites and see all deals banners are merged and are changed to clip your deals in instore-mode only
  @regression @module_dashboard @end_scenario
  Scenario: As a user, I should see deals count got updated upon successfull API is called. else its should show "See all deals"
    When go to Home tab
    Then select in-store run using zip code and store name
    Then verify home screen is displayed
    Then verify count on see all deals banner displayed


  ##Commenting below test since AEM carousel is no more visible
#    #C69134
#  @regression @module_dashboard @end_scenario
#  Scenario: As a user, i should see dynamic AEM carousel  (Simple, easy salads / Top picks for Cooking made easier) as per theme and UX design
#    When go to Home tab
##    And select the store which has AEM products enabled
#    And scroll down upto aem campaign
#    Then verify deal card on AEM campaign
#    Then verify title of AEM campaign
#    Then verify carousel view
