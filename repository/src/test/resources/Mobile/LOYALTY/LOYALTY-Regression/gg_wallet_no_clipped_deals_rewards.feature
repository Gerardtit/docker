Feature: Wallet - No clipped deals and rewards

   #C46308
  @regression @module_wallet @functional @smoke @start_scenario
  Scenario: As a User, I should see 0 count in clipped deals if no deals are clipped
    When sign up to the application with popup handling
    And go to Home tab
    When go to Wallet in Member tab
    Then verify wallet header
    And verify See your clipped deals is displayed

  #C69831
  @regression @module_wallet @functional
  Scenario: As a User, I should see new UI for "Clipped deals" & "Clipped rewards"
    When go to Wallet in Member tab
    Then verify wallet header
    And verify See your clipped deals is displayed
    And verify See your rewards and points is displayed
    Then verify See all CTA is displayed in deals section
    Then verify See all CTA is displayed in rewards section

  #C69832
  @regression @module_wallet @functional
  Scenario: As a User, I should navigate to Respective screen on tapping anywhere on"Clipped deals" & "Clipped rewards" tile
    When go to Wallet in Member tab
    Then verify wallet header
    And verify See your clipped deals is displayed
    Then click on Clipped deals tile
    And go to Clipped Deals tab in MyList
    When click on explore deals
    And verify that 'For you' Tab is displayed
    When go to Wallet in Member tab
    And verify See your rewards and points is displayed
    Then click on Clipped rewards tile
    And verify that my rewards page is displayed

  #C70276
  @regression @module_wallet @smoke
  Scenario: As a user, I should see navigate to Deals screen by tapping Deals icon from Clipped deals
    When navigate to deals tab
    And scroll up till deals top nav bar is visible
    Then go to 'For you' Tab
    And click on "Clipped deals" link in carousel on For you page
    Then verify explore deals button
    And go to Deals tab
    Then verify deals screen is displayed

  #C69833
  @regression @module_wallet @functional
  Scenario: As a user i should see different text for different scenarios
    When go to Wallet in Member tab
    Then verify wallet header
    And verify See your clipped deals is displayed
    And verify See your rewards and points is displayed

  #C46237
  @regression @module_wallet @functional
  Scenario: Verify for a new User , Clipped Rewards section should display Start earning rewards today
    When go to Wallet in Member tab
    Then verify wallet header
    And verify See your rewards and points is displayed

   #C69817
  @regression @module_wallet @functional
  Scenario: Wallet| 0 Clipped Rewards
    When go to Wallet in Member tab
    Then verify wallet header
    And verify See your rewards and points is displayed
    Then click on Clipped rewards tile
    And verify that my rewards page is displayed

   #C69818
  @regression @module_wallet @functional
  Scenario: Wallet| 0 Clipped Deals
    When go to Wallet in Member tab
    Then verify wallet header
    And verify See your clipped deals is displayed
    Then click on Clipped deals tile
    And go to Clipped Deals tab in MyList
    When click on explore deals
    And verify that 'For you' Tab is displayed

    #C70154
  @regression @module_wallet
  Scenario: As a User, I should see empty state as per the design when there are no clipped deals
    When go to MyList tab
    And verify explore deals button

   #C70155
  @regression @module_wallet
  Scenario: As a user, when I should see explore deals CTA on clipped deals screen and navigation from this CTA  should work fine as well
    And verify explore deals button
    Then click on explore deals
    Then verify user lands on "All deals" tab in deals

  #C70281
  @regression @module_wallet
  Scenario: As a user, I should see navigate to Wallet screen by tapping Wallet icon from clipped deals / deals category screen
    When go to Wallet in Member tab
    Then verify wallet header
    And verify See your clipped deals is displayed
    Then click on Clipped deals tile
    And go to Clipped Deals tab in MyList
    And verify explore deals button
    Then go to Wallet in Member tab
    And verify wallet header

  #C70282
  @regression @module_wallet @end_scenario
  Scenario: As a user, I should see navigate to Wallet screen by tapping Wallet icon from Rewards screen
    When go to Wallet in Member tab
    Then verify wallet header
    And verify See your rewards and points is displayed
    Then click on Clipped rewards tile
    And verify that my rewards page is displayed
    Then go to Wallet in Member tab
    And verify wallet header

