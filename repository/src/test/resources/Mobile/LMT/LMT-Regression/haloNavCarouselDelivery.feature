@HaloNavDelivery
Feature: HaloNav Carousel in Delivery Fulfillment

  Background: setup user on Home Page for Delivery Fulfillment type
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then Verify Start shopping button on Sign In page
    When user click delivery option
    And user click start shopping button on After Signup
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed

  @RewardsHaloNavDelivery
  Scenario: check the HaloNav carousel Rewards interactions on all banners
    When user clicks on "Rewards"
    Then user is landed on "Rewards" page
    And user sees the "Grocery Rewards"

    When user clicks on home page Tab
    When user clicks on "Pharmacy"
    Then user is landed on "Pharmacy" page
    When user clicks on Pharmacy back button

    When user clicks on home page Tab
    When user clicks on "Weekly Ad"
    Then user is landed on "Weekly Ad" page

    When user clicks on home page Tab
    When user clicks on "Deals"
    Then user is landed on "Deals" page

    When user clicks on home page Tab
    When user clicks on "FreshPass"
    Then user is landed on "FreshPass" page