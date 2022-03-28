Feature: My Rewards - Gas Rewards

  #C66719
  @smoke @regression @start_scenario
  Scenario: As a user, I should be able to navigate to google map, on clicking the distance link (arrow) in the Gas station
    When sign in to the application using account with existing rewards
    Then verify home screen is displayed
    And click on deals tab
    And click on for you tab
    When click on "My rewards" link in carousel on For you page
    And go to gas rewards section
    And click Allow While Using App PopUp
    When click Navigation Arrow
    Then verify maps app is opened
    And close the map view
    When click on back button

  #C66711
  @regression
  Scenario: As a user, I should be able to see that the store card has the store name (with icon)
    And click on deals tab
    And click on for you tab
    When click on "My rewards" link in carousel on For you page
    And go to gas rewards section
    Then verify store name and logo is displayed on store card
    When click on back button

  #C66707
  @regression
  Scenario: As a user, I should be able to see the store card shows the distance (miles) of store from the users current location, if the user share the location
    And click on deals tab
    And click on for you tab
    When click on "My rewards" link in carousel on For you page
    And go to gas rewards section
    When user shares current location
    And Pull the drawer from bottom over the screen
    Then verify store distance is displayed on store card
    And collapse the drawer
    When click on back button

  #C66709
  @regression
  Scenario: As a user, I should be able to see the store card distance (miles) of store when he change and select different store by entering store name/zipcode in the search bar
    And click on deals tab
    And click on for you tab
    When click on "My rewards" link in carousel on For you page
    And go to gas rewards section
    And search for stores using other zipcode on gas rewards section
    And Pull the drawer from bottom over the screen
    Then verify store distance is displayed on store card
    And collapse the drawer
    When click on back button

  #C66718
  @regression
  Scenario: As a user, I should be able to see the store name and store card icon on selecting different store
    And click on deals tab
    And click on for you tab
    When click on "My rewards" link in carousel on For you page
    And go to gas rewards section
    Then pin a different store on map and verify the store name/address
    When click on back button


  #C66587
  @regression @functional
  Scenario: As a user, I should be able see error message for invalid city name entered in search
    And click on deals tab
    And click on for you tab
    When click on "My rewards" link in carousel on For you page
    And go to gas rewards section
    And search for stores using zipcode on gas store lists section
    And click on clear address icon
    Then verify search bar is empty
    And search for stores using invalid zipcode
    Then verify invalid state error message
    And search for stores using invalid address
    Then verify invalid state error message
    When click on back button

  #C66478
  @regression  @functional @miniRegression
  Scenario: As a user, I should able see search the gas stations and see the result accordingly
    And click on deals tab
    And click on for you tab
    When click on "My rewards" link in carousel on For you page
    And go to gas rewards section
    And search for stores using zipcode on gas store lists section
    And search for stores using other zipcode on gas rewards section
    And Pull the drawer from bottom over the screen
    Then verify updated gas stations list
    And collapse the drawer
    When click on back button

  #C66583
  @regression
  Scenario: As a user, I should be able to go back to rewards listing on clicking back button
    And click on deals tab
    And click on for you tab
    When click on "My rewards" link in carousel on For you page
    And go to gas rewards section
    And click on back button
    Then verify that my rewards page is displayed

  #C66584
  @regression
  Scenario: As a user, I should able to click map pin
    And click on deals tab
    And click on for you tab
    When click on "My rewards" link in carousel on For you page
    And go to gas rewards section
    Then pin a different store on map and verify the store name/address
    And collapse the drawer
    When click on back button

  #C66570
  @regression @functional
  Scenario:  As a user, I should be able to click on direction icon displayed on store card list under gas station search section.
    And click on deals tab
    And click on for you tab
    When click on "My rewards" link in carousel on For you page
    And go to gas rewards section
    When click Navigation Arrow
    Then verify maps app is opened
    And close the map view
    When click on back button

   #C66577
  @regression
  Scenario: As a user, I should see Gas card listing screen with Header as Go farther with gas rewards
    And click on deals tab
    And click on for you tab
    When click on "My rewards" link in carousel on For you page
    And go to gas rewards section
    Then verify current Balance is displayed
    Then verify Go further with Gas Reward Title
    When click on back button
  # Not applicable for Android.

  #C66586
  @regression @functional
  Scenario: As a user, on clicking on gas card, I should be navigated to gas station screen
    And click on deals tab
    And click on for you tab
    When click on "My rewards" link in carousel on For you page
    And go to gas rewards section
    Then verify navigation to gas station screen
    When click on back button

  #C66736
  @regression @functional
  Scenario: As a User, I should select the store card from the list based on location.
    And click on deals tab
    And click on for you tab
    When click on "My rewards" link in carousel on For you page
    And go to gas rewards section
    And search for stores using other zipcode on gas rewards section
    And get zip code from search field
    And Pull the drawer from bottom over the screen
    And get address of first store card
    And collapse the drawer
    When user shares current location
    And Pull the drawer from bottom over the screen
    Then verify stores updated after user shares location
    Then verify store distance is displayed on store card
    And collapse the drawer
    When click on back button

  #C66588
  @regression @functional
  Scenario: As a user , I should be locate myself by clicking map icon
    And click on deals tab
    And click on for you tab
    When click on "My rewards" link in carousel on For you page
    And go to gas rewards section
    And search for stores using other zipcode on gas rewards section
    And get zip code from search field
    And Pull the drawer from bottom over the screen
    And get address of first store card
    And collapse the drawer
    When user shares current location
    And Pull the drawer from bottom over the screen
    Then verify stores updated after user shares location
    Then verify store distance is displayed on store card
    And collapse the drawer
    When click on back button

   #C66548
  @regression @functional
  Scenario: As a user, I should see Refine screen on top of store listing scroll.
    And click on deals tab
    And click on for you tab
    When click on "My rewards" link in carousel on For you page
    And go to gas rewards section
    When click on refine Button
    Then verify refine screen is displayed
    And verify Fuel Station Option on Refine Screen
    And verify All Station Participating Option on Refine Screen
    And click on refine close Button
    When click on back button

  #C66549
  @regression @functional
  Scenario: As a user, I should be able to click cancel on Refine screen and land back on Store listing screen.
    And click on deals tab
    And click on for you tab
    When click on "My rewards" link in carousel on For you page
    And go to gas rewards section
    When click on refine Button
    Then verify refine screen is displayed
    And verify Fuel Station Option on Refine Screen
    And verify All Station Participating Option on Refine Screen
    Then click on refine close Button
    And verify store listing screen
    When click on back button

  #C66556
  @regression @functional
  Scenario: As a user, I should be able to click on 'reset' CTA on Refine screen, click of which falls back to default filter 'Albertsons fuel stations '.
    And click on deals tab
    And click on for you tab
    When click on "My rewards" link in carousel on For you page
    And go to gas rewards section
    When click on refine Button
    And select banner specific fuel station from refine filters
    And click on reset filter
    Then verify All participating stations option is selected
    And keep app in background and relaunching the same
    Then verify 'Show Result' Button
    And click on refine close Button
    When click on back button

  #C66465
  @regression
  Scenario: As a user, I should see search gas stations in gas listing screen as per UX
    And click on deals tab
    And click on for you tab
    When click on "My rewards" link in carousel on For you page
    And go to gas rewards section
    And search for stores using zipcode on gas store lists section
    And search for stores using other zipcode on gas rewards section
    And Pull the drawer from bottom over the screen
    Then verify updated gas stations list
    And collapse the drawer
    When click on back button

  #C66742
  @regression
  Scenario: As a User, I should be able to see UI font, style as per design and should see store listing drawer as per respective themes and banners
    And click on deals tab
    And click on for you tab
    When click on "My rewards" link in carousel on For you page
    And go to gas rewards section
    Then Pull the drawer from bottom over the screen
    And verify store card list
    And collapse the drawer
    When click on back button

  #C66479
  @regression @functional
  Scenario: As a user, I should able do search gas station accordingly after killing app and relaunching , background and foreground , network error
    And click on deals tab
    And click on for you tab
    When click on "My rewards" link in carousel on For you page
    And go to gas rewards section
    And search for stores using zipcode on gas store lists section
    And search for stores using other zipcode on gas rewards section
    And Pull the drawer from bottom over the screen
    Then verify updated gas stations list
    When keep app in background and relaunching the same
    Then verify updated gas stations list
    And collapse the drawer
    And click on back button
    And kill and relaunch the application without popup handling
    And handle zip code page if displayed
    And handle tutorial if displayed on home page
    Then verify home screen is displayed
    When navigate to deals tab
    And go to 'For you' Tab
    And click on "My rewards" link in carousel on For you page
    And go to gas rewards section
    And click Allow While Using App PopUp
    And search for stores using zipcode on gas store lists section
    And search for stores using other zipcode on gas rewards section
    And Pull the drawer from bottom over the screen
    Then verify updated gas stations list
    And collapse the drawer
    When click on back button

  #C66744
  @regression @functional
  Scenario: As a User, I should be able to see store listing drawer on keeping the app in background and relaunching the same and I should be able to land on land on dashboard screen when i kill the app and relaunch the app
    And click on deals tab
    And click on for you tab
    When click on "My rewards" link in carousel on For you page
    And go to gas rewards section
    Then Pull the drawer from bottom over the screen
    And verify store card list
    And keep app in background and relaunching the same
    And verify store card list
    And kill and relaunch the application without popup handling
    And handle zip code page if displayed
    And handle tutorial if displayed on home page
    Then verify home screen is displayed
    When navigate to deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    And go to gas rewards section
    And click Allow While Using App PopUp
    Then Pull the drawer from bottom over the screen
    And verify store card list
    And collapse the drawer
    When click on back button

  #C69879
  @regression
  Scenario: As a user, I should be able to see the design is as per the Figma and should match with respective banners
    And click on deals tab
    And click on for you tab
    When click on "My rewards" link in carousel on For you page
    And go to gas rewards section
    And Pull the drawer from bottom over the screen
    And search for stores using zipcode on gas store lists section
    And Pull the drawer from bottom over the screen
    When verify store listing screen
    Then verify store name and logo is displayed on store card
    And verify store card list
    Then verify store distance is displayed on store card
    And collapse the drawer
    And verify store location icons are displayed on map
    When click on back button

    # updated step as now home screen is displaying
  #C69880
  @regression @end_scenario
  Scenario: As a user, I should be able to kill and relaunch the app
    And click on deals tab
    And click on for you tab
    When click on "My rewards" link in carousel on For you page
    And go to gas rewards section
    And search for stores using zipcode on gas store lists section
    And kill and relaunch the application without popup handling
    And handle zip code page if displayed
    And handle tutorial if displayed
    Then verify home screen is displayed
    #Then verify user lands on "All deals" tab in deals