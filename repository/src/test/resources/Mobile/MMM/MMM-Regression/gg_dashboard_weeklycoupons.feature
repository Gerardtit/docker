Feature: Dashboard - Weekly Coupons

   #C68863
  @regression @module_dashboard @start_scenario
  Scenario: As a User, I should see Fresh new coupons module on dashboard with the deals mapped to 'Weekly Ad coupons'
    When sign up to the application with popup handling
    And go to Home tab
    And select the pick-up store
    And scroll down upto weekly coupons section
    Then verify deal cards under weekly ad coupon

   #C68910
  @regression @module_dashboard
  Scenario: As a User, I should be able to see 'See all' button in 'Fresh New coupons'  module.
    And scroll down upto weekly coupons section
    Then verify see all option in weekly coupon

   #C68883
  @regression @module_dashboard @end_scenario
  Scenario: As a User, I should be able to see that 'Fresh new Coupons' module as per theme and UX design
    And scroll down upto weekly coupons section
    Then verify weekly coupon section title
    Then verify deal cards under weekly ad coupon
    Then verify see all option in weekly coupon
    Then verify that default deal card is bigger than all deals in coupon carousel