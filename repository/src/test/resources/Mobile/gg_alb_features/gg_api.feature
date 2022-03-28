Feature: API validation cases

  #C68907
  @regression @start_scenario
  Scenario: As a User, I should be able to see static Deal card content (same as returned from API)
    When sign up to the application with popup handling and registering the user
    And get user token
    And get the store id for delivery
    And get all offers
    When sign in to the application
    Then verify home screen is displayed
    And go to Home tab
    When click on shopping mode down arrow
    And select the store for testing "API_DELIVERY" module
    And scroll down to Save On Our Brands Module
    And scroll down up to Save On Our Brands module deal card
    Then verify deal card details are same in API & App

  #C6517
  @regression
  Scenario: As a user, i should see that on changing the store, the deals corresponding to that store are fetched
    And scroll up to profile icon on home page
    And scroll down to Save On Our Brands Module
    And scroll down up to Save On Our Brands module deal card
    Then verify deal card details are same in API & App

    #C69941
  @regression
  Scenario: As a User, I should see Purchase ranking of deals is updated to ascending order in Home ->Weekly Ad coupons and Save on our brands (carousel and see all drawer on home)
    And scroll up to profile icon on home page
    And scroll down to Save On Our Brands Module
    When click on See All exclusive brands
    Then Verify exclusive brand deals details page displayed
    Then verify deals are ordered based on purchase ranking in Save on our brands section
    And click cross button on drawer
    And scroll down up to Save On Our Brands module deal card
    Then verify deals are ordered based on purchase ranking in Save on our brands section

  #C69945
  @regression
  Scenario: As a User, I should see Purchase ranking of deals is updated to ascending order in 'Deals->All deals-> sort by newest and then ascending purchase rank
    And go to Deals tab
    When go to 'All Deals' Tab
    Then verify deals are ordered based on purchase ranking in All Deals Section

  #C69944
  @regression
  Scenario: As a User, I should see Purchase ranking of deals is updated to ascending order in 'Deals-> Categories->,Categories Details Page(in both carousel and see all drawer)
    And go to Deals tab
    And go to 'Categories' Tab
    When click on categories tab
    And click on deal category item cell
    Then verify deals category details page is displayed
    Then verify deals are ordered based on purchase ranking in category details page

  #C69943
  @regression
  Scenario: As a User, I should see Purchase ranking of deals is updated to ascending order in 'Deals-> For You->Items you may buy ,Associate offers,  Items you may like (in both carousel and see all drawer)
    And go to Deals tab
    And go to 'For you' Tab

    When click see all link beside Associate offer module
    Then verify deals are ordered based on purchase ranking in Associate offer module
    And click on close button on deal listing page
    And scroll down to Associate offer module deal card
    Then verify deals are ordered based on purchase ranking in Associate offer module

    And click see all link beside item you may buy module
    Then verify deals are ordered based on purchase ranking in item you may buy module
    And click cross button on drawer
    When scroll down to item you may buy module deal card
    Then verify deals are ordered based on purchase ranking in item you may buy module

    And click see all link beside item you may like module
    Then verify deals are ordered based on purchase ranking in item you may like module
    And click cross button on drawer
    And scroll down to item you may like module deal card
    Then verify deals are ordered based on purchase ranking in item you may like module

  #C69942
  @regression
  Scenario: As a User, I should see Purchase ranking of deals is updated to ascending order in 'Deals-> Categories->Saving Events (in both carousel and see all drawer)
    And go to Deals tab
    And go to 'Categories' Tab
    Then verify saving event card are ordered based on purchase ranking in saving events section
    And Tap on saving event card
    Then verify deals are ordered based on purchase ranking in saving events module


  #C70625
  @regression
  Scenario: As a User, I should be able to navigate to deal details page with data from database on clicking a deal with type 'WS' (Weekly Special)
    When get user token
    And get the store id for delivery
    And get MyList items
    When go to MyList tab
    And go to List Tab
    And scroll down to expand "Beverages" category from the list
    And click on  a deal with of "WS" type
    Then verify Clipped label is displayed for the deal in deal details page
    And close deal details page

  #C70626
  @regression
  Scenario: As a User, I should be able to navigate to Rewards detail page on clicking a deal with type 'GR' (Grocery reward)
    When get user token
    And get the store id for delivery
    And get MyList items
    When go to MyList tab
    And go to List Tab
    And scroll down to expand "GR Type Category" category from the list
    And click on  a deal with of "GR" type
    Then verify user is able to see 'Need X Reward' text on CTA Button
    And tap on close button
#    Then verify "Rewards Detail" Page "is" displayed
#    And click on close button on deal listing page

  #C70627
  @regression
  Scenario: As a User, I should be able to navigate to deal details page with data from database on clicking a deal with no Offer ID
    When get user token
    And get the store id for delivery
    And get MyList items
    When go to MyList tab
    And go to List Tab
    And scroll down to expand "Beverages" category from the list
    And click on  a deal with of "No Offer ID" type
    Then verify Clipped label is displayed for the deal in deal details page
    And close deal details page

    #C70677
  @regression @end_scenario
  Scenario: As a User, I should be able to see 'Store Aisle' tab in list if feature flag 'sa' returns true in API response
    When get user token
    And trigger feature flag API
    When go to MyList tab
    And go to List Tab
    Then verify 'Store Aisle' tab when feature flag 'sa' returns true
