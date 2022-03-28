@gg_newcheckout_summary
Feature:Newcheckout Summary flow - Automation

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
    #And if Service Problem is displayed
    Then verify "Add address" window is displayed
    Then user verify numeric keyboard is displayed
    When user enters "address" details
    Then verify "Delivery" is displayed at header
    And verify Select date and time will be displayed
    And user clicks on Continue to payment CTA

  @regression
  Scenario:DUG
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
    Then verify "Pick up" is displayed at header
    And verify Select date and time will be displayed
    And user clicks on Continue to payment CTA

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
    Then verify reserve a time option is present
    When user clicks reserve a time option on hompage
    And verify Store card is displayed on reserve time screen
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
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "75019" as billing zip code
    Then payment CVV window is displayed
   #   Then user verify numeric keyboard is displayed
    And user enters "111" as cvv number
    Then user enters contact information
    Then verify "Pick up at" is displayed
    And verify Selected date and time will be displayed
    Then place order button is displayed