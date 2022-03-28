Feature: Dashboard - Personalised Deals

   #C67016
  @regression @module_dashboard @start_scenario
  Scenario: As a user, I Should see 'Must Have Grabs' module with most trending products as per API response
    When sign up to the application with popup handling
    When go to Home tab
    And select the pick-up store
    Then verify must have grabs label displayed
    And verify product cards in personalised section
    When click on a product card under Must-have grabs
    Then verify product details page is displayed
    And navigate back to previous page

   #C67021
  @regression @module_dashboard
  Scenario: As a User, I should be able to see 'See all' button with navigation in 'Must Have Grabs / Buy it Again'  module
    Then verify see all button displayed next to must have grabs
    When click see all button displayed next to must have grabs
    Then verify Must Have Grabs Screen page is displayed
    And user clicks back button in must have grabs

   #C67006
  @regression @module_dashboard @end_scenario
  Scenario: As a User, I should see 'Must Have Grabs / Buy it again' module as per theme and UX design
    Then verify must have grabs label displayed
    And verify see all button displayed next to must have grabs
    When click see all button displayed next to must have grabs
    Then verify Must Have Grabs Screen page is displayed
    When user clicks back button in must have grabs
    Then verify must have grabs label displayed
