Feature: Verify the rewards navigation from HaloNav with out rewards

  Background: setup user on Home Page for Delivery Fulfillment type
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then Verify Start shopping button on Sign In page
    When user click delivery option
    And user click start shopping button on After Signup
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed

  @haloNavNoRewardsUser
  Scenario: Verify the Rewards interaction of HaloNav for a user with no rewards
    When user clicks on "Rewards"
    Then user is landed on "Rewards" page
    And user sees the "Grocery Rewards"