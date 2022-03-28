@gg_promocodeflow
Feature:Promocode Validations - Automation

  @regression
  Scenario:Delivery
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks on search field
    And user types "chicken" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then verify "Add address" window is displayed
    When user enters "address" details
    And user clicks on Continue to payment CTA
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94566" as billing zip code
    And user clicks on Continue CTA
    Then payment CVV window is displayed
  #  Then user verify numeric keyboard is displayed
    And user enters "111" as cvv number
    Then user enters contact information
  #  Then place order button is displayed
    And scroll down the screen
    And verify Add Promo code is displayed
   # When user clicks Add promo code on checkout page
    And user Add promo code on checkout page
   # Then user enters promocode "FREEDELIVERY" and click next on checkout page
  #  Then user enters promo code "LUVFRESH" and click next
 #   Then Applied is displayed on page
  #  When user clicks promo code on checkout page
 #   Then promo code deals window is dislayed
 #   When user enters promo code "LUVFRESH" and click next
   # Then Applied is displayed on page
    Then place order button is displayed

  @regression
  Scenario:Dug
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "76109" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks on search field
    And user types "chicken" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
     #And user close the contact info page
    And user close the contact info page for promocode
    And scroll down the screen
    And verify Add Promo code is displayed
    And user clicks on Add promo code on checkout page
   #  And user Add promo code on checkout page
    Then verify Reserve Time popup window is displayed
    And user clicks on Continue CTA
    # And user clicks on Save CTA
  #   And user clicks on Continue to payment CTA
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94566" as billing zip code
    Then payment CVV window is displayed
  ##   Then user verify numeric keyboard is displayed
    And user enters "111" as cvv number
    Then user enters contact information
    Then place order button is displayed

  @regression
  Scenario:Dug for Android
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "76109" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks on search field
    And user types "chicken" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "5" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    #And user close the contact info page
    And user close the contact info page for promocode
    And scroll down the screen
    And verify Add Promo code is displayed
    And user clicks on Add promo code on checkout page
   #  And user Add promo code on checkout page
    Then verify Reserve Time popup window is displayed
  #  And user clicks on Continue CTA
    And user clicks on Save CTA
 # #   And user clicks on Continue to payment CTA
  #  Then user enters "visa" as name on credit card
   # And user enters "4242424242424242" as credit card number
  #  And user enters "09/22" as card expiration month year
  #  And user enters "94566" as billing zip code
  #  Then payment CVV window is displayed
  ##   Then user verify numeric keyboard is displayed
  #  And user enters "111" as cvv number
  #  Then user enters contact information
    Then place order button is displayed

  @regression
  Scenario:Dug Prebook
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "76109" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    Then verify reserve a time option is present
    When user clicks reserve a time option on hompage
    And verify Save button is displayed on reserve time screen
    Then user clicks on the save CTA on reserve time screen
    When user clicks on search field
    And user types "chicken" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "20" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "75019" as billing zip code
   #   And user clicks on Continue CTA
    Then payment CVV window is displayed
   #   Then user verify numeric keyboard is displayed
    And user enters "111" as cvv number
    Then user enters contact information
    And scroll down the screen
    And verify Add Promo code is displayed
    And user Add promo code on checkout page
    Then place order button is displayed





