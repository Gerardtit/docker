@gg_PushNotif
Feature: Push Notification

  @unittest2    #Unit Test pending in iOS
  Scenario: Push Notification validation
    When sign in to the application
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    Then verify search bar "is" displayed
#    When user clicks shopping cart button on home page
#    And user empty shopping cart
#    And user click check mark on shopping cart page
    When go to Deals tab
    And user click Dismiss
    Then verify deals screen is displayed
    When go to 'BOGO' Tab
#    And user clicks Bogo item on deals page
#    And user scroll down for Buy One Get One Free offer
#    And adds the first BOGO offer
    When user closes the app
#    When user closes the app for ios
    And relaunch the application

    #to be deleted below lines. written just to test PN in iOS
    When click on home tab
    And click on search field
    And user types "baby oil" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item


    And user minimise the app
    And user closes the app for ios
    And updated the json file for "Rewards"
    And user drag down notification bar to check for incoming notification
    And user wait for "10" seconds to pass
    Then the "Rewards" page is displayed