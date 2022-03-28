@gg_HaloNav_Icon
Feature: Validate Halo Nav Icons on HomePage

  @MOLN-43332
  Scenario: User verifies  meals halo nav icon on home page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks on Meals Halo Nav
    Then meals experience homepage is displayed

  @MOLN-4453
  Scenario: User verifies  meals halo nav icon on home page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "95125" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user is scrolling to the right most in Halo nav Carousel
    Then Verify user should be able to see FreshPass icon
    When user is scrolling to the left most in Halo nav Carousel
    Then Verify user should be able to see Rewards icon