Feature: Verify the rewards navigation from HaloNav with rewards

  Background: setup user on Home Page for Delivery Fulfillment type
    When click on NewSignup Api for OTP with rewards with user "testauto.rewards"
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed

  @rewardsnavigationHaloNav
  Scenario: Validate the rewards navigation functionality with and without rewards
    When user clicks on "Rewards"
    Then user gets landed on Rewards gallery