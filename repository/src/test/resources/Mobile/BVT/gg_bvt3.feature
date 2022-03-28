Feature: Verify Wallet Section

  @bvt_regression
  Scenario: verify deals coupon section
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    And user click delivery option
    And user click start shopping button on After Signup
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
#    When user clicks shopping cart button on home page
#    And user empty shopping cart
#    And user click check mark on shopping cart page
    When user clicks Deals on home page
    And user click Dismiss
    When user clicks All coupons in deals page
    Then user should see all the coupons
    When user tap on clip then user should see View Products
    When user clicks wallet on HomePage
    And user click Dismiss
    Then the "Wallet" page is displayed
    When click on wallet sub tab
    Then user should see all the coupons clipped from deals page

#      When user clicks back button on wallet page
#      Then Home page is displayed
#      When user click menu button on home page
#      Then menu page is displayed
#      When user click sign out button on menu page
#      Then confirm sign out page is displayed
#      When user click ok button to confirm sign out
#      Then sign in page is displayed

  @bvt_regression
  Scenario: verify products added from aisles appear in checkout
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    And user click delivery option
    And user click start shopping button on After Signup
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user click aisles tab on home page
    Then aisles department list is displayed on home page
    And scroll down for "Baby Care" category
    When user clicks item "Baby Care" on aisle list
    When user clicks item "Baby Bath & Skin Care" on aisle list
    When user clicks item "Baby Lotion & Oil" on aisle list
    Then verify item is found from aisle
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And shopping cart shows 1 as total number

  @bvt_regression @miniRegression
  Scenario:User selects Delivery option and place order , then cancel order
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
    And user change quantity to "20" number of items for all item in shopping cart
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
    Then user clicks on Continue shopping in order confirmation page
    Then verify MFA home screen is displayed
    And user clicks on hamburger menu
    Then user clicks on orders button
    Then user lands on order history page



#    //to be updated
    When user click cancel order on order page
    And user click cancel order button from pop up
    Then user is logged in to the app for Existing user