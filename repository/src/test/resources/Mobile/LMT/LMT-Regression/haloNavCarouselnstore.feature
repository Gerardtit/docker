@HaloNavInstore
Feature: HaloNav Carousel in In-store Fulfillment

  Background: setup user on Home Page for In-store Fulfillment type
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks instore on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed

  @RewardsHaloNavInstore
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