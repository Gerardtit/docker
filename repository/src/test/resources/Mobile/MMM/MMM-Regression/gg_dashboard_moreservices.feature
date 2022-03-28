Feature: Dashboard - More Services

   #C10422
  @regression @module_dashboard @start_scenario
  Scenario: As a User, I should see 'We can help' section in the dashboard with 'gas' and 'fuel' pods if the store supports both fuel and pharmacy services
    When sign up to the application with popup handling
    And go to Home tab
    And select the store which supports both fuel and pharmacy services
    And scroll down upto more services
    Then verify both fuel and pharmacy pods are displayed
    
    #C10445
  @regression @module_dashboard
  Scenario: As a User, I should see UI(font style, text, images) of cards and 'We can help' section as per respective theme and design
    And scroll up to profile icon on home page
    And select the store which supports pharmacy service
    And scroll down upto more services
    Then verify we can help section is present

  #C68861
  @regression @module_dashboard @end_scenario
  Scenario: As a User, I should see 'We can help' section in the dashboard with 'gas' or 'fuel' pods respectively if the store supports either fuel/pharmacy services
    And scroll up to profile icon on home page
    And select the store which supports pharmacy service
    And scroll down upto more services
    Then verify Pharmacy pod is displayed
