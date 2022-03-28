Feature: Dashboard - Weekly Ads

    #C67067
  @regression @module_dashboard @start_scenario
  Scenario: As a User, I should be able to see weekly ad banner module on the dashboard with navigation
    When sign up to the application with popup handling
    And go to Home tab
    And select the pick-up store
    Then scroll down upto weekly ads section
    And verify weekly ad banner module
    Then click on weekly ad banner
    Then verify weekly ad iFrame is displayed
    And tap back button

    #C67072
  @regression @module_dashboard
  Scenario: As a user , I should see weekly ad banner module as per the design and theme
    When scroll up to profile icon on home page
    And scroll down upto weekly ads section
    Then verify weekly ad banner module
    And verify weekly ad banner image

  #C70257
  @regression @module_dashboard
  Scenario: As a user, I should see skinny version of the "Weekly ad" banner on the home page when "customizeHome" is true
    When scroll up to profile icon on home page
    And scroll down upto weekly ads section
    And verify weekly ad banner module
    Then verify skinny version of weekly ad banner displayed

  #C70274
  @regression @module_dashboard @smoke @end_scenario
  Scenario: As a user, I should see navigate to home screen by tapping home icon from Weekly Ads screen
    When scroll up to profile icon on home page
    And scroll down upto weekly ads section
    Then verify weekly ad banner module
    And click on weekly ad banner
    Then verify weekly ad iFrame is displayed
    When go to Home tab
    Then verify search bar "is" displayed
