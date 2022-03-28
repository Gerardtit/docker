@gg_progressiveflow
Feature:Progressive flow - Automation

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
    And user types "bread" on search bar and click search on home page
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
  #  And user clicks on Continue CTA
    Then payment CVV window is displayed
    And user enters "111" as cvv number
    Then user enters contact information
    Then place order button is displayed

  @regression
  Scenario:Dug
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
  #   And user clicks on Continue to payment CTA at the slot selection
    And user clicks on Continue to payment CTA
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94566" as billing zip code
    Then payment CVV window is displayed
  #   Then user verify numeric keyboard is displayed
    And user enters "111" as cvv number
    Then user enters contact information
    Then place order button is displayed

  @regression
  Scenario:Dug Prebook
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed

     # And click on settings icon
     # And scroll down and click on developer settings
     # When turn "ON" newCheckout feature
    Then verify reserve a time option is present
    When user clicks reserve a time option on hompage
    And verify Save button is displayed on reserve time screen
    Then user clicks on the save CTA on reserve time screen
    When user clicks on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page

  #    Then verify "Add address" window is displayed
  #    When user enters "address" details
   #   And user clicks on Continue to payment CTA
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "75019" as billing zip code
   #   And user clicks on Continue CTA
    Then payment CVV window is displayed

   #   Then user verify numeric keyboard is displayed
    And user enters "111" as cvv number
    Then user enters contact information
    Then place order button is displayed

  @MOLN-3638
  Scenario:As a return customer, when user come to the Checkout screen, user should see payment method already filled with only needing to confirm CVV.
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94611" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
  #   And user clicks on Continue to payment CTA at the slot selection
    And user clicks on Continue to payment CTA
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94611" billing zip code
    And user click save card details checkbox and continue
    Then payment CVV window is displayed
  #   Then user verify numeric keyboard is displayed
    And user enters "111" as cvv number
    Then user enters contact information
    Then place order button is displayed
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    When user clicks Done button
    Then verify MFA home page is displayed
    And user types "milk" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    And user clicks on Continue to CVV
    Then payment CVV window is displayed
    And user enters "111" as CVV
    And user click save or continue button on payment page
    And user verify card logo and last 4 digits displays as "4242"
    When user clicks payment tile on summary page
    Then payment CVV window is displayed
    And user enters "111" as CVV
    And user click save or continue button on payment page
    Then place order button is displayed


  @MRR1
  Scenario: Contact info Checkout Summary Page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
   # And click on settings icon
   # And scroll down and click on developer settings
   # When turn "ON" newCheckout feature
    #When click on search field
    When user clicks on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then verify "Add address" window is displayed
    When user enters "address" details
    And user clicks on Continue to payment CTA
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94566" as billing zip code
  #  And user clicks on Continue CTA
    Then payment CVV window is displayed
    And user enters "111" as cvv number
    When user enters contact information
    Then user see message Text me my order status on screen
    When user update toggle for SMS in contact info
    Then user see warning message Turn on order status text messages

  @MRR1
  Scenario:User select delivery slot at checkout page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
#    Then shopping cart page is displayed
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then verify "Add address" window is displayed
  #  And user verify upon landing on CVV screen, cursor will be active in CVV entry field
    And verify the cursor is already on the street field
    Then user verify numeric keyboard is displayed
    Then user verify Zip code ,City, and State are pre-filled
    And verify State field will not be editable
    And verify 2nd line for street is optional
    When user enters "address" details
    And user clicks on Continue to payment CTA


  @regression
  Scenario:User pre book delivery slot and see same in checkout page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    Then verify reserve a time option is present
    When user clicks reserve a time option on hompage
    And verify Save button is displayed on reserve time screen
    Then user clicks on the save CTA on reserve time screen
    When user clicks on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
#    Then shopping cart page is displayed
    And user change quantity to "10" number of items for all item in shopping cart
    When user clicks checkout button on cart page
    When user enters "address" details
    And user clicks on Continue to payment CTA


  @MRR620
  Scenario:Verify Change Credit card working fine In checkout page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94611" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
  #   And user clicks on Continue to payment CTA at the slot selection
    And user clicks on Continue to payment CTA
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94611" billing zip code
    And user click save card details checkbox and continue
    Then payment CVV window is displayed
    When user click Edit Payment Button
  #   Then user verify numeric keyboard is displayed
    Then user enters "visa" as name on credit card
    And user enters "5457210001000035" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94611" billing zip code
    And user click save card details checkbox and continue
    Then payment CVV window is displayed
    And user enters "111" as CVV
    And user click save or continue button on payment page
    When user enters contact information
    And user verify card logo and last 4 digits displays as "0035"
    When user clicks payment tile on summary page
    Then payment CVV window is displayed
    And user enters "111" as CVV
    And user click save or continue button on payment page
    Then place order button is displayed

