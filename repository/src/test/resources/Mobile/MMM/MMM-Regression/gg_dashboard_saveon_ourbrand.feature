Feature: Dashboard - Save On Our Brands

   #C68912
  @regression @module_dashboard @start_scenario
  Scenario: As a User, I should see 'Save on our brands'  module on dashboard with the deals mapped to 'Exclusive Brands'
    When sign up to the application with popup handling
    And go to Home tab
    And select the store which has exclusive brands enabled
    And scroll down to Save On Our Brands Module
    Then Verify that User is be able to see a title on Exclusive Store Brands
    And scroll up to profile icon on home page
    And scroll down up to Save On Our Brands module deal card
    Then verify deal card components
    Then verify carousel view in Save On Our Brands section

   #C68916
  @regression @module_dashboard
  Scenario: As a User, I should be able to see 'See all' button in 'Save on our brands'  module
    And scroll up to profile icon on home page
    And scroll down to Save On Our Brands Module
    Then verify 'See all' is displayed next to save on our brands module
    When click on See All exclusive brands
    Then Verify exclusive brand deals details page displayed
    And click cross button on drawer
    And scroll up to profile icon on home page
    And scroll down up to Save On Our Brands module deal card
    Then Verify that User is be able to see a Image on Exclusive Store Brands

   #C68926
  @regression @module_dashboard @end_scenario
  Scenario: As a User, I should be able to see that 'Save on our brands' module as per theme and UX design
    And scroll up to profile icon on home page
    And scroll down to Save On Our Brands Module
    Then Verify that User is be able to see a title on Exclusive Store Brands
    Then Verify that User is be able to see a Image on Exclusive Store Brands
    And scroll up to profile icon on home page
    And scroll down up to Save On Our Brands module deal card
    Then verify deal card components
