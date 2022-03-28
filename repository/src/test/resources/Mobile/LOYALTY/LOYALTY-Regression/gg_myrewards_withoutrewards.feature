Feature: My Rewards - User with no reward balance

  #C66693
  @regression @smoke @start_scenario
  Scenario: As a user, I should see zero balance on reward balance and expiring date section of My reward modules if am not having any reward history
    When sign in to the application using account with no rewards
    Then verify home screen is displayed
    And go to Deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    Then verify rewards balance when user has zero rewards
    Then verify expiring date

  #C66518
  @regression
  Scenario: As a user, i should see "Points become, Rewards" section under rewards earn module, If the user do not have any previously earned rewards
    And click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    Then verify program details description

  #C66436
  @smoke @regression
  Scenario: As a user, I should be able to see ' Program detail screen', on click of 'scorecard' for First time user
    And click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    #Then verify reward info button is displayed
    And click on new rewards bar if displayed
    #When go to rewards info section
    #And click on new rewards bar if displayed
    Then verify program details title

    #C66638
  @regression @miniRegression
  Scenario: As a User, I should be able to see CTA name "Clip 1 Reward" in the Rewards details screen is replaced by 'Needs 1 Reward' button
    And click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    Then scroll down to See All Reward Button
    When click on 'See All Reward' Button
    And click on reward card
    Then verify user is able to see 'Need X Reward' text on CTA Button
    And tap on close button

    #C66522
  @regression
  Scenario: As a user i should be able to see that the "Points become, Rewards" section and Program Details screen as per the UX design
    And click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    Then verify program details description
    When go to rewards info section
    And click on new rewards bar if displayed
    Then verify program details title

    #C66525
  @regression @functional
  Scenario: As a user, i should see that 'Points become Reward' and 'Program Details' screen when APP is background and Foreground, Kill and relaunched , Locked and Unlocked.
    And click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    Then verify program details description
    When go to rewards info section
    And click on new rewards bar if displayed
    Then verify program details title
    When move app to background and then bring it to foreground
    And click on cancel button if feedback form is displayed
    And click on new rewards bar if displayed
    Then verify program details title
    Then kill and relaunch the application without popup handling
    And handle zip code page if displayed
    And handle tutorial if displayed
    And click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    Then verify program details description
    When go to rewards info section
    And click on new rewards bar if displayed
    Then verify program details title

    #C69896
  @regression @functional @miniRegression
  Scenario: As a new user, I must be able to see Zero in rewards and the text should be Start earning rewards when user sign in for the first time
    And go to Home tab
    When click "My rewards" link in shortcuts tray on home page
    Then verify rewards balance when user has zero rewards
    And click on deals tab
    And click on for you tab
    Then click on "My rewards" link in carousel on For you page
    And verify rewards balance when user has zero rewards
    When go to Wallet tab
    And verify See your rewards and points is displayed
    Then click on Clipped rewards tile
    Then verify rewards balance when user has zero rewards

  #C69899
  @regression @functional
  Scenario: As a New/Existing user, I must be able to see rewards page when user navigates from (home screen - reward , Shortcut rewards and wallet-reward) from background and foreground the app
    And click on home tab
    When click "My rewards" link in shortcuts tray on home page
    Then verify reward page title
    And click on deals tab
    And click on for you tab
    Then click on "My rewards" link in carousel on For you page
    Then verify reward page title
    When go to Wallet tab
    Then click on Clipped rewards tile
    Then verify reward page title

  #C70273
  @regression @smoke
  Scenario: As a user, I should see navigate to home screen by tapping home icon from rewards screen [Without Rewards]
    And click on home tab
    And click "My rewards" link in shortcuts tray on home page
    Then verify rewards balance when user has zero rewards
    Then click on home tab
    And verify home screen is displayed

    #C66421
  @regression
  Scenario: As a user, I should be able to see 'Rewards earn count as zero' , 'updated time', 'reward earn points' and relaunching the app for First time user
    And click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    Then verify rewards balance when user has zero rewards
    Then verify expiring date
    Then verify updated time and date

    #C69902
  @regression @functional @end_scenario
  Scenario: As a New/Existing user, I must be able to see updated date and time when API was called
    And click on home tab
    And click "My rewards" link in shortcuts tray on home page
    Then verify updated time and date
    And click on deals tab
    And click on for you tab
    Then click on "My rewards" link in carousel on For you page
    Then verify updated time and date
    When go to Wallet tab
    Then verify wallet header
    Then click on Clipped rewards tile
    Then verify updated time and date