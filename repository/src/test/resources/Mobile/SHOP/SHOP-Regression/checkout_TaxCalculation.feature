@checkoutTax
Feature: checkout features

  Background: setup user on SignIn Page
    Given startup page is displayed
    Then zipcode page is displayed
    When user clicks Sign in button on zipcode page
    Then sign in page is displayed
    When user enter "email" in username field on Sign In page
    And user enter "password" in password field on Sign In page
    And user clicks sign in on sign in page
    When user clicks continue for CacheText
    When user clicks Shopping mode option on home page
    And user enter zipcode and search in zipcode field
    Then select order type page is displayed
    When user clicks delivery option
    And user clicks start shopping button on Sign In page

    Then Home page is displayed
    When user click shopping cart button on home page
    Then shopping cart page displayed
    And user click checkout button on cart page
    Then Checkout page is displayed

  Scenario: Verify Tax Calculation on Checkout Page
    And verify Estimated Subtotal is displayed
    And verify Estimated Taxes and Fees is displayed
    And verify Estimated Total is displayed
    Then verify Estimated Total is the total of Estimated Subtotal and Taxes


