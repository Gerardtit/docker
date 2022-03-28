Feature: Orders-Regression

  #C16497
  @regression @functional @start_scenario
  Scenario:  Cart Summary - Estimation total Information icon
    When sign in to the application
    Then verify home screen is displayed
    And go to Home tab
    And select the pick-up store
    When search a product on home page
    Then verify products listing page displayed
    When add a product on product details page
    And click on My Cart Icon
    And click on Estimated Total info button
    Then verify Estimated Total screen text
    And click on close button on estimated sub total screen
    Then click on close button on my cart screen
    And navigate back to previous page
    And click cancel button on product search page

  #C16504
  @regression @functional
  Scenario:  Checkout enabled/disabled
    And go to Home tab
    And select the pick-up store
    When click on My Cart Icon
    And clear cart items
    And click on close button on my cart screen
    When search a product on home page
    Then verify products listing page displayed
    When add a product on product details page
    And click on My Cart Icon
    Then checkout button should be disabled
    When add products on product details page till cart value is equal to or more than 30 dollars
    Then checkout button should be enabled
    Then click on close button on my cart screen
    And navigate back to previous page
    And click cancel button on product search page

  #C16505
  @regression @functional
  Scenario:  Done button
    And go to Home tab
    When search a product on home page
    And add a product on product details page
    Then verify product details page is displayed
    And click on My Cart Icon
    And click on close button on my cart screen
    And navigate back to previous page
    And click cancel button on product search page

##### Invalid: TC related to old design MyItems. Ref: PGG-7203,7211.
#    #C20793,C16595
#  @regression @functional
#  Scenario: Home/My Purchases/Aisles/Deals are clickable/Cart/Search
#    And click on my items tab
#    Then verify my items screen is displayed
#    When click on all past purchases tab
#    Then verify all past purchases are displayed
#    When click on my last order tab
#    Then verify my last orders are displayed
#    Then verify aisles categories in my items
#    Then verify products displayed

##### Invalid: TC related to old design MyItems. Ref: PGG-7203,7211.
#  #C16597
#  @regression @functional
#  Scenario: To verify the last order for registered user
#    And click on my items tab
#    When click on my last order tab
#    Then verify deals toggle is displayed
#    Then verify filter button is displayed
#    Then verify products displayed
#    When click on deals toggle
#    Then verify deals displayed if not check for no deals message

    #C16616
  @regression
  Scenario: Verify Pending Orders
    And go to Home tab
    And select the pick-up store
    When search a product on home page
    Then verify products listing page displayed
    And add products on product details page till cart value is equal to or more than 30 dollars
    And click on My Cart Icon
    Then checkout button should be enabled
    When click on Checkout Button
    Then checkout page is displayed
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
    When user clicks Done button
#    Then verify home screen is displayed
    When go to Home tab
    Then verify Home tab is selected
    When click on settings icon
    Then verify settings page is displayed
    When click on Order button
    Then order page is displayed
    Then verify pending orders displayed
    Then cancel all pending orders
    Then user don't have pending orders
    And user click back button on order page
    And click 'Yes' if 'Love the app' popup is displayed
    And click close button on setting page

  #C20789
  @regression
  Scenario: osso message - place order and verify
    And go to Home tab
    And select the pick-up store
    When search a product on home page
    Then verify products listing page displayed
    And add products on product details page till cart value is equal to or more than 30 dollars
    And click on My Cart Icon
    Then checkout button should be enabled
    When click on Checkout Button
    Then checkout page is displayed
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
    When user clicks Done button
    When go to Home tab
    Then verify Home tab is selected
    Then verify pickup order status is displayed
    When click on settings icon
    Then verify settings page is displayed
    When click on Order button
    Then order page is displayed
    Then verify pending orders displayed
    Then cancel all pending orders
    Then user don't have pending orders
    And user click back button on order page
    And click 'Yes' if 'Love the app' popup is displayed
    And click close button on setting page

   #C20794
  @regression @end_scenario
  Scenario: past orders
    And go to Home tab
    Then click on my profile icon
    And click on Account button
    Then verify account profile page is displayed
    Then navigate back to Settings screen
    And go to Home tab
    Then click on my profile icon
    When user clicks order section
    Then old orders are displayed