Feature: Dashboard - Browse Category

   #C10701
  @regression @module_dashboard @start_scenario
  Scenario: As a user , I should be able to see 'see all' button in 'Browse categories' module
    When sign up to the application with popup handling
    And go to Home tab
    And scroll down upto browse category
    Then verify see all button is displayed

   #C10704
  @regression @module_dashboard
  Scenario: As a user, I should see 'Browse Categories' with category cards in carousel view with navigation
    When click on home tab
    And select the delivery store
    And scroll down upto browse category
    Then verify category cards movement from right to left
    Then verify category cards movement from left to right

    #C70208
  @regression @module_dashboard @functional
  Scenario: As a user, I should see alphabetically sorted deal categories / browse category cards in carousel while scrolling for all shopping mode.
    And click on home tab
    And select the pick-up store
    And scroll down upto browse category
    And verify alphabetical order of the cards while swiping left on Browse Categories Module
    And select the delivery store
    Then scroll down upto browse category
    And verify alphabetical order of the cards while swiping left on Browse Categories Module
    And select in-store run using zip code and store name
    Then scroll down to Browse deals
    And verify alphabetical order of the cards while swiping left on Browse Deals Module

    #C70206
  @regression @module_dashboard @functional
  Scenario: As a user, I should see Browse Categories carousel in pickup/ delivery / in Store shopping mode when the "customizeHome" flag is False for Delivery, Pick-up & in-store or True for Delivery & Pick-up
    And click on home tab
    And select the pick-up store
    Then scroll down upto browse category
    And verify see all button is displayed next to browse categories module
    And select the delivery store
    Then scroll down upto browse category
    And verify see all button is displayed next to browse categories module
    And select in-store run using zip code and store name
    Then scroll down to Browse deals
    And verify see all button is displayed next to browse deals module

  # C70207
  @regression @module_dashboard @functional
  Scenario: As a user, I should navigate 'Browse Page' on clicking on 'Browse categories' See all CTA when the "customizeHome" flag is False for Delivery, Pick-up & in-store or True for Delivery & Pick-up
    And click on home tab
    And select the pick-up store
    Then scroll down upto browse category
    And click see all in browse category
    And verify Browse page is displayed
    And click on home tab
    And select the delivery store
    Then scroll down upto browse category
    And click see all in browse category
    Then verify Browse page is displayed
    And click on home tab
    And select in-store run using zip code and store name
    Then scroll down to Browse deals
    And click see all in browse category
    Then verify Browse page is displayed

    #C70394
  @regression @module_dashboard @functional
  Scenario: As a user, I should navigated to Deals > Categories page on clicking 'Browse deals' See All CTA when the "customizeHome" flag is True
    And click on home tab
    And select in-store run using zip code and store name
    Then scroll down to Browse deals
    And click on see all next to browse deals
    And verify that saving events is displayed

    #C70403
  @regression @module_dashboard @functional
  Scenario: As a user, I should see the Browse Deals carousel in in-store shopping mode when the "customizeHome" flag is True
    And click on home tab
    And select in-store run using zip code and store name
    Then scroll down to Browse deals
    And verify see all button is displayed next to browse deals module

  #C70209
  @regression @module_dashboard @functional
  Scenario: As a user, I should navigate to an expanded category on Browse Page clicking on product card in Browse category.
    And click on home tab
    And select the pick-up store
    Then scroll down upto browse category
    And click on category card
    And verify Browse page is displayed
    And go to Home tab
    And select the delivery store
    Then scroll down upto browse category
    And click on category card
    And verify Browse page is displayed

  #C70404
  @regression @module_dashboard @functional @end_scenario
  Scenario: As a user, I should navigate to Deals > category detail page clicking on the deals card on Browse deals
    And click on home tab
    And select in-store run using zip code and store name
    Then scroll down to Browse deals
    And click on category card
    And verify deals category details page is displayed