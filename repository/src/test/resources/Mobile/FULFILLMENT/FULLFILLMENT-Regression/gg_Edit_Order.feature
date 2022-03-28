Feature: OTP Screen Validation

  Background:
    When  Launch the MFA app

  @bvt_regression @miniRegression
  Scenario:User Edit Dug Order

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And verify 'Counter Pickup' text is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "20" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
    And user clicks on Continue to payment CTA
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
    When user click menu button on home page
    Then menu page is displayed
    When user clicks orders on menu page
    Then order page is displayed
    When user click on Edit Order
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    And scroll down the screen
    And user change date picker to enable save
    And user click save button on orderInfo window
    When user click on Cart in Edit Order
    Then user decrease the all item quantity on shopping cart page
    When user click back on cart page
    Then user see Edit Order page
    When user click on confirm change button
    Then order confirmation page is displayed
    And user close application and relaunch
    And user click on Delivery Next popup
    Then user is logged in to the app for Existing user
    And user click Cancel in Feedback form
    And user click on Delivery Next popup


  @bvt_regression @miniRegression
  Scenario:User Edit Delivery Order

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When click on search field
    And user types "baby oil" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user clicks on items count icon displaying plus minus
    And user changes the quantity to "20" for cart item
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user enters "address" details
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    When user select "attended" option
    And user change date picker to enable save
    And user click save button on orderInfo window
    When user clicks payment on checkout pagex
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94566" as billing zip code
    Then payment CVV window is displayed
    When user enters "111" as CVV and clicks next
    When user clicks contact on checkout page
    When user fills contact details
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    When user clicks Done button
    And click yes if you love Safeway app
    Then verify MFA home screen is displayed
    Then user is logged in to the app for Existing user
    When user click menu button on home page
    Then menu page is displayed
    When user clicks orders on menu page
    Then order page is displayed
    When user click on Edit Order
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    And scroll down the screen for Delivery order
    And user change date picker to enable save
    And user click save button on orderInfo window
    When user click on Cart in Edit Order
    Then user decrease the all item quantity on shopping cart page
    When user click back on cart page
    Then user see Edit Order page
    When user click on confirm change button
    Then order confirmation page is displayed
    And user close application and relaunch
    And user click on Delivery Next popup
    Then user is logged in to the app for Existing user
    And user click Cancel in Feedback form
    And user click on Delivery Next popup
    Then Home page is displayed

  @pickup @miniRegression
  Scenario:User clicks "Orders" Hyperlink on Confirmation Page

    When click on NewSignup for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    When user clicks search bar on home page
    And user types "Chicken" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "20" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    And user change date picker to enable save
    And user click save button on orderInfo window
    Then checkout page is displayed
    When user clicks payment on checkout pagex
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94566" as billing zip code
    Then payment CVV window is displayed
    When user enters "111" as CVV and clicks next
    Then checkout page is displayed
    And user click on Snap option for payment
    When user clicks contact on checkout page
    Then user fills contact details
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    When user clicks "Orders" hyperlink on order confirmation page
    And click yes if you love Safeway app
    Then user click Dismiss
    Then order page is displayed



#    Examples:
#      | delivery type |
#      | unattended    |
#      | attended      |



  @regression
  Scenario:User Edit Instore Order

    When click on NewSignup for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks instore on delivery select page
    Then store list is displayed
    When user clicks 1st store on the list
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    When user clicks search bar on home page
    And user types "baby lotion" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "20" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    And user change date picker to enable save
    And user click save button on orderInfo window
    Then checkout page is displayed
    When user clicks payment on checkout pagex
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94566" as billing zip code
    Then payment CVV window is displayed
    When user enters "111" as CVV and clicks next
    Then checkout page is displayed
    When user clicks contact on checkout page
    Then user fills contact details
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    When user clicks Done button
    And click yes if you love Safeway app
    Then home page is displayed
    When user click menu button on home page
    Then menu page is displayed
    When user clicks orders on menu page
    Then order page is displayed
    When user click on Edit Order
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    And scroll down the screen
    And user change date picker to enable save
    And user click save button on orderInfo window
    When user click on Cart in Edit Order
    Then user decrease the all item quantity on shopping cart page
    When user click back on cart page
    Then user see Edit Order page
    When user click on confirm change button
    Then order confirmation page is displayed
    When user clicks Done button
    And user close application and relaunch
    And user click on Delivery Next popup
    And user click Cancel in Feedback form
    And user click on Delivery Next popup
    Then Home page is displayed


  @regression @miniRegression
  Scenario:Validate App crash on Offer Complete Link

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    Then user selects the In-store on the list
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When go to Deals tab
    And user click Dismiss
    Then verify deals screen is displayed
    When go to 'BOGO' Tab
    And user clicks Bogo item on deals page
    And user scroll down for Buy One Get One Free offer
    And adds the first BOGO offer
    And user clicks shopping cart button on home page
    Then verify BOGO offer is added in cart
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "20" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    And user change date picker to enable save
    And user click save button on orderInfo window
    Then checkout page is displayed
    When user clicks payment on checkout pagex
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94566" as billing zip code
    Then payment CVV window is displayed
    When user enters "111" as CVV and clicks next
    Then checkout page is displayed
    When user clicks contact on checkout page
    Then user fills contact details
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    When user clicks Done button
    And click yes if you love Safeway app
    Then user is logged in to the app for Existing user
    When user click menu button on home page
    Then menu page is displayed
    When user clicks orders on menu page
    Then order page is displayed
    When user click on Edit Order
    And user click on Cart in Edit Order
    And user click offer complete text
    Then user see Offer Completed Text

  @MOLN-4274
  Scenario:Verify Driver Tipping should not be Displayed for PICKUP orders in Edit Order Flow.
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "60559" in zipcode page
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
    And user change quantity to "20" number of items for all item in shopping cart
    And user clicks checkout button on cart page
#   And user clicks on Continue to payment CTA at the slot selection
    And user clicks on Continue to payment CTA
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94523" billing zip code
    And user click save card details checkbox and continue
    Then payment CVV window is displayed
#   Then user verify numeric keyboard is displayed
    And user enters "111" as cvv number
    Then user enters contact information
    Then place order button is displayed
    And user verify driver tipping option is not displayed
    And place order button is clickable and click place order
    And order confirmation page is displayed
    When user click on Edit Order
    Then edit order screen is displayed
    And user verify driver tipping option is not displayed

    #Created By -Shraddha Jain                                Date -Dec15 2021
  @DeliveryTip
  Scenario: UMA - Automation - Verify user should displayed an error message if user enter tip more than Cart Total amount
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94566" in zipcode page
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When click on search field
    And user types "Milk" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And change quantity to "10" number of items for all item in cart
    And Verify Cart Total is greater than "50.00" dollar
    And user clicks checkout button on cart page
    Then click on Close button Add Address window
    Then Verify Driver Tip Section is displayed on Checkout Landing page
    And User Click on Change Link near to Driver Tip Section
    Then Verify Add a Custom Tip Window is present
    When User Clicks on Custom Tip Radio Button
    Then Verify Custom Tip Field will be present to enter Tip Amount
    When User enter "80.00$" more than cart total amount in custom tip field
    Then Verify User gets the error Message "Tip cannot exceed $99.99 or the order total"

  #CreatedBy -Shraddha Jain               Date -15 Dec 2021
  @CustomTip
  Scenario: UMA - Automation - Verify user should displayed an toast message for few seconds if user enter tip amount 20% of cart total

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94566" in zipcode page
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user click on search field
    And user types "Water" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And change quantity to "18" number of items for all item in cart
    And Verify Cart Total is greater than "100" dollar
    And user clicks checkout button on cart page
    Then click on Close button Add Address window
    Then Verify Driver Tip Section is displayed on Checkout Landing page
    And User Click on Change Link near to Driver Tip Section
    Then Verify Add a Custom Tip Window is present
    When User Clicks on Custom Tip Radio Button
    Then Verify Custom Tip Field will be present to enter Tip Amount
    When User enter "75.00$" more than cart total amount in custom tip field
    Then Verify User gets the toast Message "NOTE: Your entered gratuity is more than 20% of your total."





