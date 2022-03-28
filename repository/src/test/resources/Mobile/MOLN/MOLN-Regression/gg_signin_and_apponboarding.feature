Feature: Sign In / Sign Up

  #C66915
  @regression @start_scenario
  Scenario: As a user, I should be able to manually scroll the four images of the welcome screen post splash screen.
    When close app update pop up if present
    When click on close button in app to app sign in
    Then Verify First Image is Displayed
    And Verify Second Image is Displayed
    And Verify Third Image is Displayed
    And Verify Fourth Image is Displayed

  #C66929
  @regression
  Scenario: As a User, I should be able to see Welcome Screen on keeping the app in background / killing and relaunching the same
    When close app update pop up if present
    When welcome page message is displayed
    And keep app in background and relaunching the same
    Then welcome page message is displayed
    And kill the application
    And relaunch the application
    Then welcome page message is displayed

  #C66914
  @regression
  Scenario: As a user,I should be able to see Welcome "Let's get started" only when the app is updated
    When close app update pop up if present
    Then welcome page message is displayed

  #C66920
  @regression
  Scenario: As a user, I should be able to navigate to the next screen by clicking the "Let's get started" CTA.
    When close app update pop up if present
    Then welcome page message is displayed

  #C66946
  @regression
  Scenario: As a user, i should see that the Shopping method selection screen is updated with new visuals - color, font
    When sign in to the application
    Then verify home screen is displayed
    And go to Home tab
    When click on shopping mode down arrow
    And Enter the ZipCode
    When click on right arrow button on zipcode page
    Then verify user is in shopping mode screen
    Then verify Delivery Shopping Mode Option is Displayed
    And verify In Store Option is Displayed
    And select Pick UP shopping mode
    Then verify "Pickup" mode is selected in shopping mode select screen
    And click on start Shopping Button

  #C66948
  @regression
  Scenario: As a user, I should retain scan Shopping method selection screen should persist if we run the app in background
    And go to Home tab
    When click on shopping mode down arrow
    And Enter the ZipCode
    When click on right arrow button on zipcode page
    Then verify user is in shopping mode screen
    Then verify Delivery Shopping Mode Option is Displayed
    And verify In Store Option is Displayed
    And select Pick UP shopping mode
    Then verify "Pickup" mode is selected in shopping mode select screen
    When keep app in background and relaunching the same in shopping mode screen
    Then verify "Pickup" mode is selected in shopping mode select screen
    And click on start Shopping Button

  #C66949
  @regression
  Scenario: As a user , I should see that the Shopping method selection screen is displayed as per UX
    And go to Home tab
    When click on shopping mode down arrow
    And Enter the ZipCode
    When click on right arrow button on zipcode page
    And select Pick UP shopping mode
    Then verify "Pickup" mode is selected in shopping mode select screen
    And click on start Shopping Button

  #70422
  @regression
  Scenario: As a user, I should be able to land on the Home screen when the new flag is set to true
    And go to Home tab
    And click on settings icon
    And scroll down and click on developer settings
    When turn "ON" defaultLandingToHome feature
    And kill the application
    And relaunch the application
    And handle tutorial if displayed
    Then verify user lands on "Home" page when defaultLandingToHome flag is set to "true"
    And forced sign out from the application
    And sign in to the application
    And handle tutorial if displayed
    Then verify user lands on "Home" page when defaultLandingToHome flag is set to "true"

  #C70423
  @regression
  Scenario: As a user, I should be able to land on the Deals screen when the new flag is set to false
    When install the application
    And launch the application
    And sign in to the application
    And go to Home tab
    And click on settings icon
    And scroll down and click on developer settings
    When turn "OFF" defaultLandingToHome feature
    And kill the application
    And relaunch the application
    Then verify user lands on "Deals" page when defaultLandingToHome flag is set to "false"
    And forced sign out from the application
    And sign in to the application
    Then verify user lands on "Deals" page when defaultLandingToHome flag is set to "false"

  #C70425
  @regression
  Scenario: As a user, I should be able to land on the Home screen when API fails/ not receiving the data from server
    When install the application
    And launch the application
    And sign in to the application
    And get and store app version from settings page
    Then verify user lands on deals by default when defaultLandingToHome flag is not present in evalattrs api

  #C70426
  @regression
  Scenario: As a new user, I should be land on the respective screen along with the tutorials
    When forced sign out from the application
    And sign in to the application
    And get and store app version from settings page
    And un-install the application
    And install the application
    And launch the application
    And sign up to the application using ahem email client
    And handle zip code page if displayed
    Then verify tutorials and landing page based on defaultLandingToHome flag value from evalattrs api

  #C69387
  @regression
  Scenario: As a User, i should not see the cancel option in shopping mode screen if the user is logging in for the first time
    When forced sign out from the application
    And sign up to the application using ahem email client
    Then verify cancel button "is not" displayed on zip code page
    And handle zip code page if displayed
    And click Continue on cache pop up for "android" platform
    And handle tutorial if displayed
    And click Continue on cache pop up for "ios" platform

  #C16756
  @regression
  Scenario: As a user, I should see all the functionality working as expected when MFA flow is enabled
    When go to Home tab
    Then verify Home tab is selected
    When go to Browse tab
    Then verify Browse tab is selected
    When navigate to deals tab
    Then verify Deals tab is selected
    When go to MyItems tab
    Then verify My Items tab is selected
    When go to Wallet tab
    Then verify wallet header
    And verify wallet tab is selected
    And forced sign out from the application
    And sign in to the application
    Then verify home screen is displayed

  #C69889
  @regression
  Scenario: As a User, i should see the push notification screen if the feature flag is set to true
    When install the application
    And launch the application
    And sign in to the application to verify notifications
    Then verify Allow notification button is displayed
    And verify Not right now cta is displayed

  #C69890
  @regression @functional
  Scenario: As a User, i should see that the push notification functions as expected when you allow push notification permission
    When install the application
    And launch the application
    And sign in to the application to verify notifications
    Then verify Allow notification button is displayed
    And click on allow notification button
    Then click allow on push notification permission popup
    And verify home screen is displayed
    Then verify Allow notification button is not displayed

  #C69891
  @regression @functional
  Scenario: As a User, i shoud see that he push notifiction functions as expected when you deny push notification permission
    When install the application
    And launch the application
    And sign in to the application to verify notifications
    Then verify Allow notification button is displayed
    And click on allow notification button
    And click Dont Allow on push notification permission popup
    Then verify home screen is displayed

  #C69892
  @regression
  Scenario: As auser i used be able to skip the push notification permission by clicking on Not right now CTA
    When install the application
    And launch the application
    And sign in to the application to verify notifications
    And verify Not right now cta is displayed
    And click on Not right now cta
    And verify home screen is displayed

  #C69893
  @regression @functional
  Scenario: As a User, i should see that when the OS setting permission is up, if i kill the app/keep it in the back ground and get it to the forefront, the permission request is denied by default and pus notification screen shouldn't appear again on relaunch
    When install the application
    And launch the application
    And sign in to the application to verify notifications
    Then verify Allow notification button is displayed
    And click on allow notification button
    When keep app in background and relaunching the same
    And verify permission pop up is displayed
    And kill the application
    And relaunch the application
    And handle zip code page if displayed
    And handle tutorial if displayed on home page
    Then verify home screen is displayed

  #C69894
  @regression
  Scenario: As a user i should see that the push notification screen is as per the design
    When install the application
    And launch the application
    And sign in to the application to verify notifications
    Then verify Allow notification button is displayed
    And verify Not right now cta is displayed

  #C69908
  @regression @functional
  Scenario: As a User, i should see that when the i am in push notification screen, if i kill the app and relaunch it / keep the app in background and ge tit to the forefront, i should land back on the push notification screen
    When install the application
    And launch the application
    And sign in to the application to verify notifications
    Then verify Allow notification button is displayed
    And verify Not right now cta is displayed
    And keep app in background and relaunching the same
    Then verify Allow notification button is displayed
    And verify Not right now cta is displayed
    And kill the application
    And relaunch the application
    And handle zip code page if displayed
    And handle tutorial if displayed on home page
    Then verify Allow notification button is displayed
    And verify Not right now cta is displayed

  #C69888
  @regression @end_scenario
  Scenario: As a User, i should not see the push notification screen if the local feature flag is set to false
    When install the application
    And launch the application
    When sign in to the application to verify notifications
    Then verify Allow notification button is not displayed
    And verify home screen is displayed
