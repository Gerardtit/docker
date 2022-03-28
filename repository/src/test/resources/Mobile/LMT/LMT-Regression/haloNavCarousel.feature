@HaloNav
Feature: HaloNav Carousel Interactions

  Background: setup user on Home Page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed


  @ScrollDownNoHaloNavCarousel
  Scenario: Scrolling down on the Home page, HaloNav carousel is not sticky or not displayed
    When user clicks on home page Tab
    Then HaloNav carousel section is displayed
    When scroll down to the weekly ads coupon section
    Then the Search bar and cart section remain sticky or displayed at the top of the screen
    And HaloNav Carousel section is not in view


  @OrderPlacedHaloNavIsDisplayed @pratik2



  @OrderPlacedHaloNavIsDisplayed

  Scenario: User places an order and verifies that the Carousel is being displayed
    When user clicks on home page Tab
    When user clicks search bar on home page
    And user types "baby lotion" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "20" number of items for all item in shopping cart
    #    Then shopping cart shows 10 as total number
    #    And checkout button is enabled on the shopping cart
    #    And estimation total information icon is displayed
    #    When scroll down the screen
    #    Then cart summary is displayed on the shopping cart page
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    And scroll down the screen
    And user change date picker to enable save
    And user click save button on orderInfo window
    Then checkout page is displayed
    When user clicks payment on checkout pagex
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94566" as billing zip code
    #    When user click continue on payment page
    Then payment CVV window is displayed
    When user enters "111" as CVV and clicks next
    Then checkout page is displayed
    When user clicks contact on checkout page
    Then user fills contact details
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    When user clicks Done button
    Then home page is displayed
    Then HaloNav carousel section is displayed

  @RewardsHaloNavSai
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



