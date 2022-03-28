Feature: Deals - For You

  #C70276
  @regression @module_deals @deals_foryou @smoke @start_scenario
  Scenario: As a user, I should see navigate to Deals screen by tapping Deals icon from Clipped deals
    When sign up to the application with popup handling
    And go to Home tab
    And go to MyList tab
    And go to Clipped Deals tab in MyList
    Then verify Clipped deals screen is displayed
    Then verify explore deals button
    And go to Deals tab
    Then verify deals screen is displayed

  #C69741
  @regression @module_deals @deals_foryou
  Scenario: As a User, I should be able to see all the functionalities of  weekly ad banner module under  For you section
    And navigate to deals tab
    And go to 'For you' Tab
    And click Got it on welcome card on For you page
    And scroll Down to weekly ad banner section in deals
    Then verify that weekly ad banner is displayed
    And click on weekly ad banner in deals
    Then verify weekly ad iFrame is displayed
    And click cross button on drawer of weekly Add app iframe
    Then verify that weekly ad banner is displayed

  #C70118
  @regression @module_deals @deals_foryou @smoke
  Scenario: As a user i should see the count of clipped deals and should not see any crash upon screen navigations form deals screen
    When navigate to deals tab
    And scroll up till deals top nav bar is visible
    And go to 'For you' Tab
    And scroll up till top of the ForYou tab
    And clip a deal on For you page if clipped deals count is zero
    And go to MyList tab
    And go to Clipped Deals tab in MyList
    And get and store deals count from clipped deals page
    When navigate to deals tab
    When clip 1 deals from items you may like
    And go to Wallet in Member tab
    Then verify wallet header
    When click See all button in deals section
    And go to Clipped Deals tab in MyList
    Then verify clipped deals count on clipped deals page is increased by 1 after clipping deals

   #C70133
  @regression @module_deals @deals_foryou @smoke
  Scenario: As a user, I should able to clip 2 deals  at same time
    When navigate to deals tab
    And click 'Yes' if 'Love the app' popup is displayed
    And scroll up till deals top nav bar is visible
    And go to 'For you' Tab
    And scroll up till top of the ForYou tab
    And clip a deal on For you page if clipped deals count is zero
    And go to MyList tab
    And go to Clipped Deals tab in MyList
    And get and store deals count from clipped deals page
    When navigate to deals tab
    And clip 2 deals from items you may like
    And go to MyList tab
    And go to Clipped Deals tab in MyList
    Then verify clipped deals count on clipped deals page is increased by 2 after clipping deals

   #C70275
  @regression @module_deals @deals_foryou @smoke
  Scenario: As a user, I should see navigate to Deals screen by tapping Deals icon from My Rewards screen
    And click on home tab
    And click "My rewards" link in shortcuts tray on home page
    Then verify that my rewards page is displayed
    And go to Deals tab
    Then verify deals screen is displayed

   #C70277
  @regression @module_deals @deals_foryou @smoke
  Scenario: As a user, I should see navigate to Deals screen by tapping Deals icon from Weekly Ads screen
    And click on home tab
    And click "Weekly Ad" link in shortcuts tray on home page
    Then verify weekly ad iFrame is displayed
    And go to Deals tab
    Then verify deals screen is displayed

  #C70278
  @regression @module_deals @deals_foryou @smoke
  Scenario: As a user, I should see navigate to Deals screen by tapping Deals icon from Weekly Ads screen
    When navigate to deals tab
    And scroll up till deals top nav bar is visible
    And go to 'For you' Tab
    And scroll up till top of the ForYou tab
    And scroll Down to weekly ad banner section in deals
    Then verify that weekly ad banner is displayed
    And click on weekly ad banner in deals
    Then verify weekly ad iFrame is displayed
    And go to Deals tab
    Then verify deals screen is displayed

  #C10966
  @regression @module_deals @deals_foryou @functional
  Scenario: As a user, I want to see app behaviour on kill and relaunch, and keeping the app in background and bring to forefront
    Given get and store app version from settings page
    When navigate to deals tab
    And scroll up till deals top nav bar is visible
    And go to 'For you' Tab
    And scroll up till top of the ForYou tab
    When keep app in background and relaunching the same
    Then verify that 'For you' Tab is displayed
    When kill the application
    And relaunch the application
    And handle tutorial if displayed
    Then verify landing page based on defaultLandingToHome flag value from evalattrs api

  #C69864
  @regression @module_deals @deals_foryou
  Scenario: As a user, I should able to see Deals screen from running app in background and launching the app
    Given get and store app version from settings page
    When navigate to deals tab
    And scroll up till deals top nav bar is visible
    And go to 'For you' Tab
    And scroll up till top of the ForYou tab
    When keep app in background and relaunching the same
    Then verify that 'For you' Tab is displayed

   #C7521
  @regression @module_deals @deals_foryou
  Scenario: As a user ,I should see deals screen customise for different banner as per banner themes and UX design
    When navigate to deals tab
    And scroll up till deals top nav bar is visible
    And go to 'For you' Tab
    And scroll up till top of the ForYou tab
    Then scroll down to item you may like module
    And verify see all link beside item You May Like is displayed
    When scroll Down to weekly ad banner section in deals
    Then verify weekly ad banner module
    And verify Deals By Category Navigation card is Displayed
    And verify All Deals Navigation card is Displayed

   #C7693
  @regression @module_deals @deals_foryou @functional
  Scenario: Verify deals navigation bar is not visible when user scrolls down(swipe up) the screen but is visible when user starts scrolling up(swipe down)
    When navigate to deals tab
    And scroll up till deals top nav bar is visible
    And go to 'For you' Tab
    And scroll up till top of the ForYou tab
    When scroll down the screen
    And scroll down the screen
    And scroll down the screen
    Then verify Deals navigation bar "is not" displayed
    When scroll up the screen
    Then verify Deals navigation bar "is" displayed

  #C69670
  @regression @module_deals @deals_foryou
  Scenario: As a User, I should see new navigation card below the weekly ads
    When navigate to deals tab
    And scroll up till deals top nav bar is visible
    And go to 'For you' Tab
    And scroll up till top of the ForYou tab
    Then verify Deals By Category Navigation card is Displayed
    And verify All Deals Navigation card is Displayed

  #C69671
  @regression @module_deals @deals_foryou @functional
  Scenario:  As a User, I should navigate to respective landing screen On clicking on the added modules
    When navigate to deals tab
    And scroll up till deals top nav bar is visible
    And go to 'For you' Tab
    And scroll up till top of the ForYou tab
    Then verify Deals By Category Navigation card is Displayed
    When click on Deals By Category navigation Card
    And verify Your Categories is displayed in category tab
    Then go to 'For you' Tab
    And verify All Deals Navigation card is Displayed
    When click on All Deals navigation Card
    And verify deal cards are displayed in All deals screen

  #C69654
  @regression @module_deals @deals_foryou @functional
  Scenario: As a user, I should see the CTA of "See all" in the End of carousel on the personalized deals section
    When navigate to deals tab
    And scroll up till deals top nav bar is visible
    And go to 'For you' Tab
    And scroll up till top of the ForYou tab
    And scroll down to item you may like module
    When swipe left on deal cards in Items You May Like Module until 'See all' CTA is displayed in the End of carousel
    Then verify 'See all' CTA is displayed in the End of carousel

  #C69859
  @regression @module_deals @deals_foryou @functional
  Scenario: As a user, I should be able to see deals listing screen
    When navigate to deals tab
    And scroll up till deals top nav bar is visible
    And go to 'For you' Tab
    And scroll up till top of the ForYou tab
    When scroll down to item you may like module
    And scroll through the carousel view and click on see all if deal card count is more than 10
    Then verify Deal Listing Page is displayed
    When click on close button on deal listing page
    And verify see all link beside item You May Like is displayed

  #C69766
  @regression @module_deals @deals_foryou
  Scenario: Move app in Background and bring it to foreground: Deals tab->For you-> Associate offers, Items you buy & Items you may like, Weekly ads Banner, Deals By Category, All Deals
    When navigate to deals tab
    And scroll up till deals top nav bar is visible
    And go to 'For you' Tab
    And scroll up till top of the ForYou tab
    When scroll down to item you may like module
    And click see all link beside item you may like module
    Then keep app in background and relaunching the same
    Then verify Deal Listing Page is displayed
    When click on close button on deal listing page
    And verify see all link beside item You May Like is displayed
    Then verify that weekly ad banner is displayed
    And click on weekly ad banner in deals
    Then verify weekly ad iFrame is displayed
    Then keep app in background and relaunching the same
    And click cross button on drawer of weekly Add app iframe
    Then verify that weekly ad banner is displayed
    Then verify Deals By Category Navigation card is Displayed
    When click on Deals By Category navigation Card
    Then keep app in background and relaunching the same
    And verify Your Categories is displayed in category tab
    Then go to 'For you' Tab
    And verify All Deals Navigation card is Displayed
    When click on All Deals navigation Card
    Then keep app in background and relaunching the same
    And verify deal cards are displayed in All deals screen

  #C69740
  @regression @module_deals @deals_foryou @functional
  Scenario: Kill and Relaunch: Deals tab->For you-> Associate Offers, Items you may like, Weekly Ad Banner
    When navigate to deals tab
    And scroll up till deals top nav bar is visible
    And go to 'For you' Tab
    And scroll up till top of the ForYou tab
    And scroll Down to weekly ad banner section in deals
    Then verify that weekly ad banner is displayed
    And click on weekly ad banner in deals
    Then verify weekly ad iFrame is displayed
    When kill and relaunch the application without popup handling
    And click Continue on cache pop up for "android" platform
    And handle tutorial if displayed
    Then verify home screen is displayed
    And navigate to deals tab
    And go to 'For you' Tab
    And scroll Down to weekly ad banner section in deals
    Then verify that weekly ad banner is displayed

  #C69863
  @regression @module_deals @deals_foryou @functional
  Scenario: As a user, I should able to land on Dashboard screen from killing the app and relaunching the app
    Given get and store app version from settings page
    When navigate to deals tab
    And scroll up till deals top nav bar is visible
    And go to 'For you' Tab
    And scroll up till top of the ForYou tab
    And scroll down to item you may like module
    When kill and relaunch the application without popup handling
    And click Continue on cache pop up for "android" platform
    And handle tutorial if displayed
    Then verify landing page based on defaultLandingToHome flag value from evalattrs api

   #C70123
  @regression @module_deals @deals_foryou @functional
  Scenario: As a user i should be pointed to the same deal card in the 'Items you may like' carousel
    When navigate to deals tab
    And scroll up till deals top nav bar is visible
    And go to 'For you' Tab
    And scroll up till top of the ForYou tab
    And scroll down to item you may like module
    And swipe left on deal cards in Items You May Like Module until 'See all' CTA is displayed in the End of carousel
    Then verify 'See all' CTA is displayed in the End of carousel
    When click on deal card
    And close deal details page
    Then verify 'See all' CTA is displayed in the End of carousel

   #C70131
  @regression @module_deals @deals_foryou @functional
  Scenario: As a User, I should able to see Deals clipped count should same after killing and relaunching the app.
    And go to MyList tab
    And go to Clipped Deals tab in MyList
    And get and store deals count from clipped deals page
    And kill and relaunch the application without popup handling
    And click Continue on cache pop up for "android" platform
    And handle tutorial if displayed
    And go to MyList tab
    And go to Clipped Deals tab in MyList
    Then verify clipped deals count on clipped deals page is the same
    And go to Wallet in Member tab
    Then verify count of deals on clipped And Wallet Screen are same

   #C69604
  @regression @module_deals @deals_foryou @functional
  Scenario: My cart behaviour-> on kill and relaunch, and running the app in the background and bring to foreground
    Given get and store app version from settings page
    When go to Home tab
    And search a product on home page
    And add a product on product details page
    And click back button on product details page
    And click cancel button on product search page
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And go to 'For you' Tab
    And scroll down to item you may like module
    Then verify 'Items you may like' module is displayed
    When get count of products from cart on deals page
    And keep app in background and relaunching the same
    Then verify 'Items you may like' module is displayed
    When kill and relaunch the application without popup handling
    And click Continue on cache pop up for "android" platform
    And handle tutorial if displayed
    Then verify landing page based on defaultLandingToHome flag value from evalattrs api
    And navigate to deals tab
    And get cart count after keeping app in foreground and verify if they are same in deal page

  #C69573
  @regression @module_deals @deals_foryou @functional  @end_scenario
  Scenario: As a user, Deals-> Search Bar, I want to see app  behaviour, when i kill and relaunch and run in the background and bring forefront
    Given get and store app version from settings page
    When go to Home tab
    And search a product on home page
    Then verify products listing page displayed
    When keep app in background and relaunching the same
    Then verify products listing page displayed
    When kill and relaunch the application without popup handling
    And click Continue on cache pop up for "android" platform
    And handle tutorial if displayed
    Then verify landing page based on defaultLandingToHome flag value from evalattrs api

     # carousel with links is remved from deals
#  #C70122
#  @regression @module_deals @deals_foryou @smoke
#  Scenario: As a user i should see the 'DEAL' screen when I tap on the 'DEALS' from bottom navigation
#    When navigate to deals tab
#    And scroll up till deals top nav bar is visible
#    And go to 'For you' Tab
#    And scroll up till top of the ForYou tab
#    When click on "My rewards" link in carousel on For you page
#    Then verify reward info button is displayed
#    When navigate to deals tab
#    Then verify deals title is displayed
#    When click on "Clipped deals" link in carousel on For you page
#    Then verify Clipped deals screen is displayed
#    When navigate to deals tab
#    Then verify deals title is displayed
#    And scroll up till top of the ForYou tab
#    When click on "Weekly ad" link in carousel on For you page
#    Then verify weekly ad iFrame is displayed
#    When navigate to deals tab
#    Then verify deals title is displayed