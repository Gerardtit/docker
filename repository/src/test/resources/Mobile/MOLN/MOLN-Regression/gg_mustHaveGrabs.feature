Feature: HomePage->Must-Have Grabs

  Background:
    When Launch the MFA app
    And click on existing user signin for OTP
    Then verify MFA home screen is displayed

  @regression @miniRegression
  Scenario: Verify user able to add products from Must-Have Grabs section to the cart
    When user clicks shopping cart button on home page
    And user empty shopping cart
    And user click check mark on shopping cart page
    Then verify Must-Have grabs section is displayed on home page
    When user clicks on See all in Must have grabs
    Then verify title of screen is Must-have grabs
    Then capture name of product to be added in cart
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then verify Product is added in cart



