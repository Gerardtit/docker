@GuestModeHaloNav
Feature: Guest Mode Login and HaloNav interactions

  Scenario:Verify the HaloNav interactions through HaloNav
    Then user landed on onboarding screen
    Then user validates Guest mode CTA in Mobile workflow
    When user clicks on CTA continue as guest
    Then zipcode page is displayed
    When user relaunch the application
    Then user landed on onboarding screen
    When user clicks on Email workflow
    Then user validates Guest mode CTA in Email workflow
    When user clicks on CTA continue as guest
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks on "Rewards"
    Then user lands on sign in to continue screen
    When user clicks on "Deals"
    Then user lands on sign in to continue screen
    When user clicks on "FreshPass"
    Then user lands on sign in to continue screen

  @StaticBottomNav
  Scenario: Verify Static HaloNav and Bottom Nav interactions
    Then user landed on onboarding screen
    Then user validates Guest mode CTA in Mobile workflow
    When user clicks on CTA continue as guest
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    Then user validates "Rewards", "Pharmacy", "Weekly Ad", "Deals", and "FreshPass"
    When user clicks on Shop page and navigates to Past Purchases
    Then user lands on sign in to continue screen
    When user clicks on Deals bottom navigation
    Then user lands on sign in to continue screen
    When user clicks on My List bottom navigation
    Then user lands on sign in to continue screen
    When user clicks on Member tab bottom navigation
    Then user lands on sign in to continue screen

