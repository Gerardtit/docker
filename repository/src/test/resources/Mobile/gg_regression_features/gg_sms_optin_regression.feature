Feature: SMS Opt-in-Regression

  #C16379
  @regression @functional @start_scenario
  Scenario: Enable/Disable SMS opt-in for order
    When sign in to the application
    Then verify home screen is displayed
    And go to Home tab
    And select the pick-up store
    When search a product on home page
    Then verify products listing page displayed
    And add products on product details page till cart value is equal to or more than 30 dollars
    And click on My Cart Icon
    Then checkout button should be enabled
    When click on Checkout Button
    Then checkout page is displayed
    And verify status of SMS Opt-in is OFF
    Then change SMS-Opt-in status to ON
    And verify SMS Opt-in status to ON
    When change SMS-Opt-in status to OFF
    Then verify status of SMS Opt-in is OFF
    When user clicks "Order Info" text on page
    Then "Order Info" window is displayed
    And scroll down the screen
    And user change date picker to enable save
    And user click save button on orderInfo window
    Then checkout page is displayed
    And click On Confirm CVV
    Then payment CVV window is displayed
    When user enters "123" as CVV and clicks next
    Then checkout page is displayed
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    And user clicks Done button
    When go to Home tab
    Then scroll up to profile icon on home page
    And click on settings icon
    Then click on Order button
    And cancel latest order
    Then navigate back to Settings screen
    And navigate to dashboard

  #C16380
  @regression @functional @end_scenario
  Scenario: Updating contact phone number should not affect SMS status
    And go to Home tab
    And select the pick-up store
    When search a product on home page
    Then verify products listing page displayed
    And add products on product details page till cart value is equal to or more than 30 dollars
    And click on My Cart Icon
    Then checkout button should be enabled
    When click on Checkout Button
    Then checkout page is displayed
    And verify status of SMS Opt-in is OFF
    And change SMS-Opt-in status to ON
    Then click on Contact to change Phone Number
    And Update Contact Number in checkout page
    When click on Save And Review Button
    Then verify SMS Opt-in status to ON
    When change SMS-Opt-in status to OFF
    Then verify status of SMS Opt-in is OFF

    #Invalid - TC related to default SMS opt-in status should be ON as it is no more applicable.
#  #C16378
#  @regression @functional @start_scenario
#  Scenario: Default SMS opt-in status should be ON
#    When sign in to the application
#    Then verify home screen is displayed
#    And go to Home tab
#    When click on shopping mode down arrow
#    And select the pick-up store
#    When search for product "beer" on home page
#    Then verify products listing page displayed
#    And add products on product details page till cart value is equal to or more than 30 dollars
#    And click on My Cart Icon
#    Then checkout button should be enabled
#    When click on Checkout Button
#    Then checkout page is displayed
#    And verify SMS Opt-in status to ON
#    When click back button in checkout page
#    And click On Done Button
#    Then user goes back to home page from search page

  #Invalid - TC related to default SMS opt-in status should be ON as it is no more applicable.
#  #C16381
#  @regression @functional @end_scenario
#  Scenario: Once disabled, it should be enabled for next order
#    And go to Home tab
#    When click on shopping mode down arrow
#    And select the pick-up store
#    When search for product "beer" on home page
#    Then verify products listing page displayed
#    And add products on product details page till cart value is equal to or more than 30 dollars
#    And click on My Cart Icon
#    Then checkout button should be enabled
#    When click on Checkout Button
#    Then checkout page is displayed
#    When change SMS-Opt-in status to OFF
#    Then verify status of SMS Opt-in is OFF
#    When user clicks "Order Info" text on page
#    Then "Order Info" window is displayed
#    And scroll down the screen
#    And user change date picker to enable save
#    And user click save button on orderInfo window
#    Then checkout page is displayed
#    And click On Confirm CVV
#    Then payment CVV window is displayed
#    When user enters "123" as CVV and clicks next
#    Then checkout page is displayed
#    And place order button is clickable and click place order
#    Then order confirmation page is displayed
#    When user clicks Done button
#    When go to Home tab
#    Then verify Home tab is selected
#    # Place a new order and check if the button is default enabled
#    When search for product "beer" on home page
#    Then verify products listing page displayed
#    And add products on product details page till cart value is equal to or more than 30 dollars
#    And click on My Cart Icon
#    Then checkout button should be enabled
#    When click on Checkout Button
#    And checkout page is displayed
#    Then verify SMS Opt-in status in ON by Default
#    #Steps to cancel order placed above
#    When click back button in checkout page
#    When click On Done Button
#    Then user goes back to home page from search page
#    And navigate to deals tab
#    When go to Home tab
#    ##remove all the cart item
#    And click on My Cart Icon
#    And clear cart items
#    And click on close button on my cart screen
#    #Then verify MFA home screen is displayed
#    Then verify home screen is displayed
#    And click on my profile icon
#    And click on Order button
#    And cancel latest order
