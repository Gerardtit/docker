Feature: Tutorials

  #C70022
  @regression @functional @start_scenario
  Scenario: As a user I Should see the tutorial screen when I background and foreground the APP on HOME tab.
    When install the application
    And launch the application
    And sign in to the application to verify tutorials
    When click Continue on cache pop up
    Then click dismiss button if popup is displayed
    When click next button on welcome tutorial on deals tab
    And click on next button on tool tip screen
    And go to Home tab to verify tutorials
    When keep app in background and relaunching the same
    Then verify select shopping method stage is displayed
    And click on next button on tool tip screen

  #C70020
  #
  @regression @functional
  Scenario: As a user I Should see the 'DEALS' Screen after the tutorials screen on 'Deals' tab
    When forced sign out from the application
    And sign in to the application
    And get and store app version from settings page
    And install the application
    And launch the application
    And sign in to the application to verify tutorials
    Then verify tutorials and landing page based on defaultLandingToHome flag value from evalattrs api
#    Then verify that 'For you' Tab is displayed

  #C70021
  @regression @functional
  Scenario: As a user I Should see the 'DEALS' screen when I click on anywhere during the onboard journey on the 'Deals' tab
    When install the application
    And launch the application
    And sign in to the application to verify tutorials
    When click Continue on cache pop up
    Then click dismiss button if popup is displayed
    Then verify tutorial tool tip description on deal Tab
    And click anywhere on screen when tutorials is displayed on deals tab
#    Then verify that 'For you' Tab is displayed

  #C68984
  @regression @functional
  Scenario: As a user I Should see the tutorial screen when I background and foreground the APP on DEALS tab.
    When install the application
    And launch the application
    And sign in to the application to verify tutorials
    When click Continue on cache pop up
    Then click dismiss button if popup is displayed
    Then verify tutorial tool tip description on deal Tab
    And keep app in background and relaunching the same
    Then verify tutorial tool tip description on deal Tab

  #C70019
  @regression
  Scenario: As a user, I Should see the onboarding tutorial on 'DEALS'  tab for the 'Welcome' and 'Browse' after installing or Update for the first time.
    When install the application
    And launch the application
    And sign in to the application to verify tutorials
    When click Continue on cache pop up
    Then click dismiss button if popup is displayed
    And verify tutorial for deal landing page


  #C68996
  @regression
  Scenario: As a User, I should see only the select shopping mode tutorial every time after logout and login also should able to dismiss the tutorial
    When forced sign out from the application
    And sign in to the application
    And get and store app version from settings page
    And install the application
    And launch the application
    And sign in to the application to verify tutorials
    When click Continue on cache pop up
    Then click dismiss button if popup is displayed
    And get and store app version from settings page
    Then verify tutorials and landing page based on defaultLandingToHome flag value from evalattrs api
    And go to Home tab
    Then verify dashboard page is displayed
    And forced sign out from the application
    When sign in to the application to verify tutorials
    Then verify "Shopping Mode" tutorial is displayed when navigating to home page
    And verify dashboard page is displayed

    #C68999
  @regression
  Scenario: As a User, I should still see only the select shopping mode tutorial, after killing/backgrounding and relaunch/open the app after logout and login
    When install the application
    And launch the application
    And sign in to the application
    And go to Home tab
    Then verify dashboard page is displayed
    And forced sign out from the application
    When sign in to the application to verify tutorials
    And keep app in background and relaunching the same to verify shopping mode tutorial
    Then verify "Shopping Mode" tutorial is displayed when navigating to home page
    Then verify dashboard page is displayed
    And kill the application
    And relaunch the application
    And handle zip code page if displayed
    Then verify "Shopping Mode" tutorial is displayed when landing on to home page

    #C69005
  @regression
  Scenario: As a user, i should see that the tutorial should be as per the respective theme and design
    When forced sign out from the application
    And sign in to the application
    And get and store app version from settings page
    And install the application
    And launch the application
    And sign in to the application to verify tutorials
    When click Continue on cache pop up
    Then verify tutorials and landing page based on defaultLandingToHome flag value from evalattrs api
    Then verify "Shopping Mode" tutorial is displayed when navigating to home page
    Then verify dashboard page is displayed

    #C68994
  @regression
  Scenario: As a User, i should be able to see all the 3 tutorials (shopping mode, deals and wallet) when user fresh installs the or update from loyalty app to UMA app
    When forced sign out from the application
    And sign in to the application
    And get and store app version from settings page
    And install the application
    And launch the application
    When sign in to the application to verify tutorials
    Then verify tutorials and landing page based on defaultLandingToHome flag value from evalattrs api
    Then verify "Shopping Mode" tutorial is displayed when navigating to home page


    #C68979
  @regression
  Scenario: As a user, I Should see the onboarding tutorial  on 'HOME' tab , for the 'Shopping method', 'Deals', and 'Wallet' after installing or Update for the first time.
    When forced sign out from the application
    And sign in to the application
    And get and store app version from settings page
    And install the application
    And launch the application
    When sign in to the application to verify tutorials
    Then verify tutorials and landing page based on defaultLandingToHome flag value from evalattrs api
    Then verify "Shopping Mode" tutorial is displayed when navigating to home page

  #C68982
  @regression
  Scenario: As a user I Should see the Dashboard after the tutorials screen on 'HOME' tab
    When forced sign out from the application
    And sign in to the application
    And get and store app version from settings page
    And install the application
    And launch the application
    And sign in to the application to verify tutorials
    Then verify tutorials and landing page based on defaultLandingToHome flag value from evalattrs api
    Then verify "Shopping Mode" tutorial is displayed when navigating to home page
    When click Continue on cache pop up
    Then verify dashboard page is displayed

  #C68983
  @regression
  Scenario: As a user I Should see the Dashboard when I click on anywhere during the onboard journey on the 'HOME' tab
    When install the application
    And launch the application
    And sign in to the application to verify tutorials
    And click Continue on cache pop up
    And click dismiss button if popup is displayed
    When click next button on welcome tutorial on deals tab
    And click on next button on tool tip screen
    And go to Home tab to verify tutorials
    Then click on cancel button if feedback form is displayed
    And click on next button on tool tip screen
    And click anywhere on screen when tutorials is displayed
    And click continue option on pop up
    Then verify dashboard page is displayed

  #C69007
  @regression
  Scenario: As a User, i should be able to see only the select shopping mode tutorial when i change the shopping mode and then kill the app and re launch it
    When forced sign out from the application
    And sign in to the application
    And get and store app version from settings page
    And install the application
    And launch the application
    When sign in to the application to verify tutorials
    And click Continue on cache pop up
    And click dismiss button if popup is displayed
    Then verify tutorials and landing page based on defaultLandingToHome flag value from evalattrs api
    Then verify "Shopping Mode" tutorial is displayed when navigating to home page
    And click on shopping mode down arrow
    And change to delivery shopping mode
    And kill the application
    And relaunch the application
    And handle zip code page if displayed
    Then verify "Shopping Mode" tutorial is displayed when landing on to home page
    And click on next button on tool tip screen
    Then verify dashboard page is displayed

   #C66947
  @regression
  Scenario: As a user , On killing and launching the app, I should land on dashboard screen
    And kill the application
    And relaunch the application
    And handle zip code page if displayed
    Then verify "Shopping Mode" tutorial is displayed when landing on to home page

    #C70038
  @regression
  Scenario: On Fresh app install->As a User, I should see tooltips in a sequence, when user lands on Home by default, on select of  'Delivery' in fulfilment page
    When forced sign out from the application
    When sign in to the application
    And go to Home tab to verify tutorials
    Then click on cancel button if feedback form is displayed
    And click on next button on tool tip screen
    And click continue option on pop up
    And verify home screen is displayed
    And click on shopping mode down arrow
    And select the delivery store
    When install the application
    And launch the application
    When sign in to the application

  #C70039
  @regression
  Scenario: On Fresh app installAs a User, I should see tooltips in a sequence, when user lands on Home by default, on select of  'Pickup' in fulfilment page  on Fresh app install
    When forced sign out from the application
    And sign in to the application
    And click on shopping mode down arrow
    And select the pick-up store
    And get and store app version from settings page
    And install the application
    And launch the application
    When sign in to the application to verify tutorials
    And click Continue on cache pop up
    And click dismiss button if popup is displayed
    Then verify tutorials and landing page based on defaultLandingToHome flag value from evalattrs api

   #C70040
  @regression
  Scenario: On Fresh app install->As a User, I should see tooltips in a sequence, when user lands on Home by default, on select of  'Instore'' in fulfilment page
    When forced sign out from the application
    And sign in to the application
    And click on shopping mode down arrow
    And select in-store run using zip code and store name
    And install the application
    And launch the application
    When sign in to the application to verify tutorials
    And click Continue on cache pop up
    And click dismiss button if popup is displayed
    Then verify tutorials and landing page based on defaultLandingToHome flag value from evalattrs api

  #C70041
  @regression
  Scenario: On Fresh app install->As a User, I should see tooltips in a sequence, when user lands on Home by default, on select of  any shopping mode in fulfilment page
    When forced sign out from the application
    And sign in to the application
    And click on shopping mode down arrow
    And select the pick-up store
    And select in-store run using zip code and store name
    And install the application
    And launch the application
    When sign in to the application to verify tutorials
    And click Continue on cache pop up
    And click dismiss button if popup is displayed
    Then verify tutorials and landing page based on defaultLandingToHome flag value from evalattrs api

  #C70229
  @regression
  Scenario: As a user, I shoud see the tooltips on shopping method selection, browse & wallet for the very first time when user select In-Storemethod
    When forced sign out from the application
    When sign in to the application to verify tutorials
    And go to Home tab
    And click on shopping mode down arrow
    And select in-store run using zip code and store name
    When install the application
    And launch the application
    When sign in to the application to verify tutorials
    And click Continue on cache pop up
    And click dismiss button if popup is displayed
    And verify tutorials and landing page based on defaultLandingToHome flag value from evalattrs api
    Then verify "Shopping Mode" tutorial is displayed when navigating to home page
    Then verify In-Store is selected in dashboard
#    Then verify "Shopping Mode" tutorial is displayed
#    And click on next button on tool tip screen
#    And click continue option on pop up
#    And verify tutorials and landing page based on defaultLandingToHome flag value from evalattrs api

  #C70230
  @regression
  Scenario: As a user, I shoud see the tooltips on shopping method selection, browse & wallet for the very first time when user select Delivery & Pick up method
    When forced sign out from the application
    When sign in to the application to verify tutorials
    And go to Home tab
    And verify home screen is displayed
    And click on shopping mode down arrow
    And select the delivery store
    When install the application
    And launch the application
    When sign in to the application to verify tutorials
    And click Continue on cache pop up
    And click dismiss button if popup is displayed
    Then verify tutorials and landing page based on defaultLandingToHome flag value from evalattrs api
    Then verify "Shopping Mode" tutorial is displayed when navigating to home page
    Then verify delivery shopping mode is selected
    And click on shopping mode down arrow
    And select the pick-up store
    When install the application
    And launch the application
    When sign in to the application to verify tutorials
    And click Continue on cache pop up
    And click dismiss button if popup is displayed
    Then verify tutorials and landing page based on defaultLandingToHome flag value from evalattrs api
    Then verify "Shopping Mode" tutorial is displayed when navigating to home page
    And verify pickup shopping mode is selected

  #C70231
  @regression
  Scenario: As a user, I shoud see the tooltips on shopping method selection in every kill and launch of the app.
    When forced sign out from the application
    When sign in to the application
    And verify home screen is displayed
    And kill the application
    And relaunch the application
    And handle zip code page if displayed
    And click Continue on cache pop up
    And click dismiss button if popup is displayed
#    Then verify tutorials and landing page based on defaultLandingToHome flag value from evalattrs api
    Then verify "Shopping Mode" tutorial is displayed when navigating to home page

    #C70046
  @regression @end_scenario
  Scenario: As a User, I should not see tutorials on fresh login
    When forced sign out from the application
    When sign in to the application to verify tutorials
    And go to Home tab
    And verify home screen is displayed
    And forced sign out from the application
    When sign in to the application to verify tutorials
    Then verify tutorial is not displayed