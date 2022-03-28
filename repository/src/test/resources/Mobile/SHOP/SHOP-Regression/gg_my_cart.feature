@my_cart
Feature: Verify My Cart Page

  Background:
#    When Launch the MFA app

  @miniRegression
  Scenario:User selects Delivery option and Verify Info Icon of Estimated Total in Cart

    When click on NewSignup for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    When user clicks shopping cart button on home page
    Then shopping cart page is displayed
    When user empty shopping cart
    Then shopping cart empty page is displayed
    When user clicks on cross sign of cart page
    And scroll down the screen
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
#    And estimation total information icon is displayed
#    And user clicks on estimation total information icon
#    Then "Estimated Total" text is displayed


  @smoke @miniRegression
  Scenario:User selects Delivery option and Verify Info Icon of Savings in Cart

    When click on NewSignup for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    When user clicks shopping cart button on home page
    Then shopping cart page is displayed
    When user empty shopping cart
    Then shopping cart empty page is displayed
    When user clicks on cross sign of cart page
    And scroll down the screen
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
   #  And user scroll down to cart summary
#    Then "Estimated Reward Card Savings" text is displayed
#    And user clicks on estimated rewards card savings information icon
#    Then "Estimated Club Card Savings" text is displayed
#    #When user clicks navigate back to the previous page
#    When user clicks navigate back to the cart page
#    Then shopping cart page is displayed


  @smoke @miniRegression #Story: MMM-2136
  Scenario:User verifies Cart screen title for InStore shopping mode

    When click on NewSignup for OTP
    Then zipcode page is displayed
    When user enters "instore" in zipcode page
    Then select order type page is displayed
    When user clicks instore on delivery select page
    Then store list is displayed
    When user clicks 1st store on the list
    And user click start shopping button on Sign In page
#    And user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks shopping cart button on home page
    Then verify title of screen is "Cart"
    Then verify quantity counter is present in Cart

  @smoke   @miniRegression    #Story MMM-2137
  Scenario:User verifies change cart icon and Product cart CTA

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "instore" in zipcode page
    Then select order type page is displayed
    When user clicks instore on delivery select page
    Then store list is displayed
    When user clicks 1st store on the list
    And user click start shopping button on Sign In page
    And user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When click on search field
    And user types "butter" on search bar and click search on home page
    Then user navigate to pdp of first product
    Then user is able to see Add to Cart in PDP
    When user clicks shopping cart button on home page
    Then shopping cart page is displayed
    When user click check mark on shopping cart page
    Then related item is displayed on the product detail page
    When click on View All in PDP
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
#    When user navigate back from Related Poducts
    And user navigate back from Related Poducts
#    And click on close button
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
#    When user navigate back from Related Poducts
    And user navigate back from Related Poducts
    And user goes back to home page from search page
    And go to Deals tab
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    When user navigate back from Related Poducts
    And go to 'BOGO' Tab
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    When user navigate back from Related Poducts

