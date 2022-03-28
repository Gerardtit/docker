Feature: Verify the screen tittle for Order History screen displayed as "Your Orders"

  @MPLAT-3838
  Scenario:Verify the screen tittle for Order History screen displayed as "Your Orders"
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item

    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    #And checkout button is disabled on shopping cart
    And user clicks on items count icon displaying plus minus
    And user changes the quantity to "20" for cart item
    And user clicks checkout button on cart page

    Then verify "Add address" window is displayed
    When user enters "address" details
    And user clicks on Continue to payment CTA
    #And user clicks on continue to payment method button
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94566" as billing zip code
    Then payment CVV window is displayed
    And user enters "111" as cvv number
    Then user enters contact information
    Then place order button is displayed
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    And user note the order number
    Then user clicks on Continue shopping in order confirmation page
    Then verify MFA home screen is displayed
    And user clicks on hamburger menu
    Then user clicks on orders button
    Then user lands on order history page
    And user verify the order number



