Feature: Deals - Categories

    #C69729
  @regression @module_deals @deals_categories @start_scenario
  Scenario: As a brand new user/existing user, I should see 'Categories' tab under Deals  and  list of Deal Categories for a given store
    When sign up to the application with popup handling
    And go to Home tab
    And navigate to deals tab
    And go to 'All Deals' Tab
    And clip a deal and verify the deal is clipped
    And navigate to deals tab
    And click on categories tab
    Then verify Your Categories is displayed in category tab
    Then verify that list of deal categories alphabetically ascending along with the number of deals for each

   #C4425
  @regression @module_deals @deals_categories
  Scenario: As a User, I should be able to see  Saving Events module  font , color is customised as per theme banner and UX design
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And click on categories tab
    And scroll up till top of the categories tab
    Then verify that saving events is displayed
    Then verify that a saving event card is displayed
    And verify saving Event Label is displayed
    And verify that count of deals on a saving event card is displayed
    And verify that 'See all' button is displayed next to saving events

   #C68911
  @regression @module_deals @deals_categories
  Scenario: As a user, I should see deal card should be customised as per banner theme specific and UX design as well
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And click on categories tab
    And scroll up till top of the categories tab
    And click on deal category item cell
    Then verify deals category details page is displayed
    And verify deal card components
    And clip a deal and verify the deal is clipped

   #C69015
  @regression @module_deals @deals_categories
  Scenario: As a user i should be able to see that the Category deals details screen is as per the UX design and the respective banner
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And click on categories tab
    And scroll up till top of the categories tab
    When scroll down the screen
    And user clicks category "Breakfast & Cereal" from Your categories
    Then verify clip cta on deal card
    Then verify deals category details page is displayed
    And verify category card name in Category deals details page
    Then verify deal card components
    And clip a deal and verify the deal is clipped
    And click on eligible products CTA on deal card
    Then verify Clipped label is displayed for the deal in deal details page
    And close deal details page

   #C69666
  @regression @module_deals @deals_categories
  Scenario: As a user, I should see Pull To Refresh Screen as per figma and UX design
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And click on categories tab
    And scroll up till top of the categories tab
    When refresh the page
    And verify saving Event Label is displayed
    And verify that count of deals on a saving event card is displayed
    And verify that 'See all' button is displayed next to saving events
    Then verify Your Categories is displayed in category tab

    #C67143
  @regression @module_deals @deals_categories
  Scenario: As a user, I want to see Your Categories module under For You tab accordingly
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And click on categories tab
    And scroll up till top of the categories tab
    Then verify Your Categories is displayed in category tab

  #C67146
  @regression @module_deals @deals_categories @functional
  Scenario: As a user, I want the category tiles are actionable.
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And click on categories tab
    And scroll up till top of the categories tab
    And verify category list are scrollable

  #C69009
  @regression @module_deals @deals_categories @functional
  Scenario: As a User, i should be able to see click on 'Category cards' on 'Your categories' module of Deals screen and navigate to deals detail screen
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And click on categories tab
    And scroll up till top of the categories tab
    And click on deal category item cell
    Then verify deals category details page is displayed

  #C69010
  @regression @module_deals @deals_categories
  Scenario: As a User, i should be able to see Name of the Category on the Category deals details screen
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And click on categories tab
    And scroll up till top of the categories tab
    And click on deal category item cell
    Then verify deals category details page is displayed
    Then verify name of the category on the category deals details screen is displayed

  #C69011
  @regression @module_deals @deals_categories @functional
  Scenario: As a User, i should land on Deals screen after clicking back button on the Category deals details screen
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And click on categories tab
    And scroll up till top of the categories tab
    And click on deal category item cell
    Then verify deals category details page is displayed
    Then verify category card name in Category deals details page
    And click back button on Category deals details screen
    Then verify Your Categories is displayed in category tab

  #C69012
  @regression @module_deals @deals_categories
  Scenario: As a user, i should be able to see the The count of offers on the Category deals details screen
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And click on categories tab
    And scroll up till top of the categories tab
    And click on deal category item cell
    Then verify deals category details page is displayed
    Then verify category card name in Category deals details page
    Then verify count of offers on the Category deals details screen

  #C69784
  @regression @module_deals @deals_categories
  Scenario: As a user , I should see that deal category detail screen should be displayed as per figma
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And click on categories tab
    And scroll up till top of the categories tab
    And click on deal category item cell
    Then verify deals category details page is displayed
    Then verify category card name in Category deals details page
    Then verify count of offers on the Category deals details screen

  #C69783
  @regression @module_deals @deals_categories
  Scenario:  As a user, I should not see refine button in deals category detail screen
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And click on categories tab
    And scroll up till top of the categories tab
    And click on deal category item cell
    Then verify deals category details page is displayed
    Then verify refine button is not present

   #C69825
  @regression @module_deals @deals_categories
  Scenario: As a user ,I should be able to see Clipped label on deals card upon Clipping the Deal successful
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And click on categories tab
    And scroll up till top of the categories tab
    And user clicks category "Breakfast & Cereal" from Your categories
    And clip a deal if not already clipped
    And click on eligible products CTA on deal card
    Then verify Clipped label is displayed for the deal in deal details page
    And close deal details page

  #C69730
  @regression @module_deals @deals_categories
  Scenario: As a brand new user/existing user, I should see 'Your Categories' module
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And click on categories tab
    And scroll up till top of the categories tab
    And click on deal category item cell
    Then verify deals category details page is displayed

  #C69732
  @regression @module_deals @deals_categories
  Scenario: As a brand new user/existing user, I should see deal list is getting refreshed
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And click on categories tab
    And scroll up till top of the categories tab
    Then refresh the page
    And verify Your Categories is displayed in category tab
    Then verify that saving events is displayed

  #C4410
  @Smoke @regression @module_deals @deals_categories @functional
  Scenario: As a User, I should be able to see title as 'Saving events'  module under  Deals->'For you'  and 'categories' view
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And click on categories tab
    And scroll up till top of the categories tab
    And verify saving Event Label is displayed

    #C4414
  @Smoke @regression @module_deals @deals_categories @functional
  Scenario: As a User, I should be able to see Saving Events card name and count on card
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And click on categories tab
    And scroll up till top of the categories tab
    Then verify that saving events is displayed
    And verify that count of deals on a saving event card is displayed

  #C4422
  @Smoke @regression @module_deals @deals_categories @functional
  Scenario: As a user, I should be able to see  n number of  Saving Events deals in Savings Events module sorted alphabetically and status bar indicators are  highlighted based on their positions
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And click on categories tab
    And scroll up till top of the categories tab
    Then verify that saving events is displayed
    And verify maximum of 15 saving events are displayed and are in alphabetical order
    And status bar indication present in first position

  #C4412
  @regression @module_deals @deals_categories @functional
  Scenario: As a User, I should be able to slide the Saving Events deals card from right to left or left to right
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And click on categories tab
    And scroll up till top of the categories tab
    Then verify that saving events is displayed
    And slide the saving event card from right to left and verify its position
    And slide the saving event card from left to right and verify its position

  #C69033
  @regression @module_deals @deals_categories
  Scenario: As a User, i should be able to see the Saving Event Module as per the Banner theme(UI ,UX,Banner theme)
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And click on categories tab
    And scroll up till top of the categories tab
    Then verify that saving events is displayed
    Then verify that a saving event card is displayed
    And verify that count of deals on a saving event card is displayed
    And verify that 'See all' button is displayed next to saving events

  #C69032
  @regression @module_deals @deals_categories @functional
  Scenario: As a User, I should be able to see all the functionality under  'Saving events' module
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And click on categories tab
    And scroll up till top of the categories tab
    And verify saving Event Label is displayed
    And verify that count of deals on a saving event card is displayed
    And verify that 'See all' button is displayed next to saving events
    When click on see All link of saving event
    And verify saving Event Title is displayed
    Then verify cross button is displayed in special event screen
    Then verify close button is displayed special in event screen
    Then verify listing of saving event on small card
    Then verify total count is displayed special event screen
    Then click on saving event Category Title
    And verify saving Event Detail Page is displayed
    When click on Close button on Saving Event Detail Page
    And click close button on saving events drawer if displayed
    Then verify that saving events is displayed

  #C69733
  @regression @module_deals @deals_categories
  Scenario: As a brand new user/existing user, I should see Savings Events under Categories
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And click on categories tab
    And scroll up till top of the categories tab
    Then verify that saving events is displayed
    Then verify that a saving event card is displayed
    And verify that count of deals on a saving event card is displayed
    And verify that 'See all' button is displayed next to saving events

  #C69865
  @regression @module_deals @deals_categories
  Scenario: As a user, I should able to see Categories section as per the design and respective banner
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And click on categories tab
    And scroll up till top of the categories tab
    And verify saving Event Label is displayed
    And verify that count of deals on a saving event card is displayed
    And verify that 'See all' button is displayed next to saving events
    Then verify Your Categories is displayed in category tab
    Then verify that list of deal categories alphabetically ascending along with the number of deals for each

  #C4856
  @regression @module_deals @deals_categories @functional
  Scenario: As a user, I should see Saving Events to be updated after changing the store
    When navigate to deals tab
    And scroll up till deals top nav bar is visible
    And click on categories tab
    And scroll up till top of the categories tab
    And click on see All link of saving event
    And get saving events count
    And click close button on saving events drawer
    And go to Home tab
    And select different store using zip, shopping type and store
    And navigate to deals tab
    And click on categories tab
    And click on see All link of saving event
    Then get saving events count and verify if the count is updated
    And click close button on saving events drawer

  #C69013
  @regression @module_deals @deals_categories @functional
  Scenario: As a user i should be able to see that by changing the category selection the Category deals details screen must be updated based on the selection
    And click on home tab
    And select the pick-up store
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And click on categories tab
    And scroll up till top of the categories tab
    When user clicks category "Bread & Bakery" from Your categories
    Then verify deals category details page is displayed
    And get card name before categories is not changed
    And click back button on deal category listing page
    When user clicks category "Breakfast & Cereal" from Your categories
    Then verify deal card are updated after store is changed
    And click back button on deal category listing page

  #C4416
  @regression @module_deals @deals_categories @functional
  Scenario: As a user, I should be able to see below mentioned details in  Saving Events module
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And click on categories tab
    And scroll up till top of the categories tab
    Then verify that saving events is displayed
    Then verify that a saving event card is displayed
    And verify that count of deals on a saving event card is displayed
    And verify that 'See all' button is displayed next to saving events
    When slide the saving event card from right to left and verify its position

  #C69767
  @regression @module_deals @deals_categories
  Scenario: Move app in Background and bring it to foreground: Deals tab->Categories-> Saving Events, Your categories
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And click on categories tab
    And scroll up till top of the categories tab
    And verify saving Event Label is displayed
    Then verify that count of deals on a saving event card is displayed
    When click on see All link of saving event
    Then keep app in background and relaunching the same
    And verify saving Event Title is displayed
    Then click close button on saving events drawer
    And verify that 'See all' button is displayed next to saving events
    Then verify Your Categories is displayed in category tab
    And keep app in background and relaunching the same
    Then verify Your Categories is displayed in category tab

   #C70121
  @regression @module_deals @deals_categories
  Scenario: As a User, i should see the deal clipped in 'Categories' tab is updated immediately in 'All deals' tab
    When forced sign out from the application
    And sign up to the application with popup handling
    And go to Home tab
    And navigate to deals tab
    And click on categories tab
    Then clip a deal in Categories and verify if the deal is updated in All deals page

  #C70120
  @regression @module_deals @deals_categories
  Scenario: As a user, i should be able to clip a deal from saving events from Deals -> categories
    When forced sign out from the application
    And sign up to the application with popup handling
    And go to Home tab
    And navigate to deals tab
    And click on categories tab
    And click on see All link of saving event
    Then clip a deal from saving events and verify the deal is clipped

  #C69765
  @regression @module_deals @deals_categories @functional @end_scenario
  Scenario: Kill and Relaunch: Deals tab->Categories-> Saving Events, Your categories
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And click on categories tab
    And scroll up till top of the categories tab
    Then verify that saving events is displayed
    When click on see All link of saving event
    Then verify close button is displayed special in event screen
    When kill the application
    And relaunch the application
    And handle tutorial if displayed on home page
    Then verify home screen is displayed
    When navigate to deals tab
    And click on categories tab
    And scroll up till top of the categories tab
    Then verify that saving events is displayed
    And click on deal category item cell
    Then verify deals category details page is displayed
    When kill and relaunch the application without popup handling
    And click Continue on cache pop up for "android" platform
    And handle tutorial if displayed
    When navigate to deals tab
    And click on categories tab
    And scroll up till top of the categories tab
    Then verify Your Categories is displayed in category tab