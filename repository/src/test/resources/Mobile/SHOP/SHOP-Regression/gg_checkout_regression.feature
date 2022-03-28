Feature: Checkout-Regression

  #C20785
  @regression @start_scenario
  Scenario: Select DUG
    When sign in to the application
    Then verify home screen is displayed
    And go to Home tab
    Then select the pick-up store
    And click on reserve a time
    And user change date picker to enable save
    And user click save button on orderInfo window
    Then verify home screen is displayed

  #C35767
  @regression
  Scenario: Select DUG - with Diff ZIP
    And go to Home tab
    When click on shopping mode down arrow
    And select the pick-up store
    And click on reserve a time
    And user change date picker to enable save
    And user click save button on orderInfo window
    Then verify home screen is displayed

  #C14799
  @regression
  Scenario: Verify Contact Details at Checkout Page
    And go to Home tab
    Then select the pick-up store
    When search a product on home page
    Then verify products listing page displayed
    And add products on product details page till cart value is equal to or more than 30 dollars
    And click on My Cart Icon
    Then checkout button should be enabled
    Then Click on checkout button
    Then Verify Labels at Checkout page
    Then enter more than 10 digits in phone number and verify only a maximum of 10 digits can be entered
    And click back button on order info page
    Then handle alert pop up
    And click On Back Button to navigate to My Cart Screen
    Then click on close button on my cart screen
    And click cancel button on product search page

  #C16557
  @regression @functional
  Scenario: Verify SNAP option is available for SNAP enable store
    And go to Home tab
    And user selects a pickup store that supports SNAP EBT payment
    When search a product on home page
    Then verify products listing page displayed
    And add products on product details page till cart value is equal to or more than 30 dollars
    When click on My Cart Icon
    Then checkout button should be enabled
    Then click on Checkout Button
    And verify SNAP EBT option is available
    And click back button on order info page
    Then handle alert pop up
    And click On Back Button to navigate to My Cart Screen
    Then click on close button on my cart screen
    And click cancel button on product search page

  #C16561
  @regression @functional
  Scenario:  User place transaction without selecting SNAP (Credit Card)
    And go to Home tab
    And user selects a pickup store that supports SNAP EBT payment
    When search a product on home page
    Then verify products listing page displayed
    And add products on product details page till cart value is equal to or more than 30 dollars
    When click on My Cart Icon
    Then checkout button should be enabled
    Then click on Checkout Button
    And verify SNAP EBT option is available
    When click On Choose And Confirm date
    And user change date picker to enable save
    And user click save button on orderInfo window
    And click On Confirm CVV
    When Enter CVV
    And click on Place Order Button to Place an Order


  #C16558
  @regression @functional
  Scenario: User place transaction with SNAP (SNAP only item in Cart)
    And go to Home tab
    And user selects a pickup store that supports SNAP EBT payment
#    When Click On Search Button
    And search for an SNAP Item
#    And select first item from the search list
    And add products on product details page till cart value is equal to or more than 30 dollars
    When click on My Cart Icon
    Then checkout button should be enabled
    Then click on Checkout Button
    And verify SNAP EBT option is available
    Then user selects "SNAP EBT" as payment method in checkout screen
    When click On Choose And Confirm date
    And user change date picker to enable save
    And user click save button on orderInfo window
    And click On Confirm CVV
    When Enter CVV
    And click on Place Order Button to Place an Order

  #C16560
  @regression @functional
  Scenario: User remove Non SNAP item by selecting view cart on cart page  and complete transaction
    And go to Home tab
    And user selects a pickup store that supports SNAP EBT payment
    When Click On Search Button
    And search for an SNAP Item
    And select first item from the search list
    And close toggle info popup
    And add products on product details page till cart value is equal to or more than 30 dollars
    And go back to Home Page
    And search for an Non SNAP Item
    And select first item from the search list
    And Add Item to Cart
    And click on My Cart Icon
    Then checkout button should be enabled
    Then click on Checkout Button
    And verify SNAP EBT option is available
    Then user selects "SNAP EBT" as payment method in checkout screen
    When user clicks view cart when SNAP EBT purchase issue popup is displayed in cart screen
    And Remove All Non SNAP Items
    When click On Choose And Confirm date
    And user change date picker to enable save
    And user click save button on orderInfo window
    And click On Confirm CVV
    When Enter CVV
    And click on Place Order Button to Place an Order

  #C16559
  @regression @functional
  Scenario: User place transaction with hybrid item in cart (SNAP and NON SNAP item), verify split on estimated total
    And go to Home tab
    And user selects a pickup store that supports SNAP EBT payment
    When Click On Search Button
    And search for an SNAP Item
    And select first item from the search list
# Added below step as pop up is coming
    And close toggle info popup
    And Add Item to Cart
    And search for an Non SNAP Item
    And select first item from the search list
# The above step will ensure cart has 1 snap and 1 non snap item before checkout
    And Add Item to Cart
    And search for an Non SNAP Item
    And select first item from the search list
    And add products on product details page till cart value is equal to or more than 30 dollars
    And click on My Cart Icon
    Then checkout button should be enabled
    Then click on Checkout Button
    When click On Choose And Confirm date
    And user change date picker to enable save
    And user click save button on orderInfo window
    And click On Confirm CVV
    When Enter CVV
    And verify SNAP EBT option is available
    Then user selects "SNAP EBT" as payment method in checkout screen
    When user clicks view cart when SNAP EBT purchase issue popup is displayed in cart screen
    And click back button to go back to checkout page
    Then verify snap eligible sub total list
    And verify non eligible sub total list
    And click on Place Order Button to Place an Order

  #C16562
  @regression @functional
  Scenario: Verify view cart (Global substitution, stepper qty, estimated total, promo codes) not be there
    And go to Home tab
    And user selects a pickup store that supports SNAP EBT payment
    When Click On Search Button
    And search for an SNAP Item
    And select first item from the search list
    And Add Item to Cart
    And search for an Non SNAP Item
    And select first item from the search list
    Then Add Item to Cart
    And search for an Non SNAP Item
    And select first item from the search list
    And add products on product details page till cart value is equal to or more than 30 dollars
    And click on My Cart Icon
    Then checkout button should be enabled
    Then click on Checkout Button
    And verify SNAP EBT option is available
    Then user selects "SNAP EBT" as payment method in checkout screen
    When user clicks view cart when SNAP EBT purchase issue popup is displayed in cart screen
    And verify Estimated total is not displayed
    And verify Promo Codes is not displayed
    And verify Global Substitution is not displayed
    And verify steppers is not displayed
    Then verify cart and search icon are not displayed

  #C14810
  @regression
  Scenario: UMA Verify Payment - CVV validation at Checkout Page
    And go to Home tab
    When search a product on home page
    And add products on product details page till cart value is equal to or more than 30 dollars
    And click on My Cart Icon
    Then checkout button should be enabled
    When click on Checkout Button
    Then verify CVV validation displayed on checkout page

  #C16521
  @regression @functional
  Scenario:  Place Order - DUG/Attended/Unattended
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
    And go to Home tab
    Then verify home screen is displayed

  #C16522
  @regression @functional
  Scenario:  Edit Cart - DUG/Attended/Unattended
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
    And go to Home tab
    Then verify home screen is displayed
    And click On View Details Button
    And  click On Edit Cart link
    When search To Add an Item in Edit Cart
    And close toggle info popup
    And Add Item to Cart
    When click On Cancel Button
    When click on Checkout Button In Edit Cart
    And click On Confirm Changes button
    Then order confirmation page is displayed
    When click On Back button to go back to Home Page
    When sign in to the application
    Then verify home screen is displayed
    When click on shopping mode down arrow
    And change to delivery shopping mode
    Then verify delivery shopping mode is selected
    When search a product on home page
    Then verify products listing page displayed
    And add products on product details page till cart value is equal to or more than 30 dollars
    And click on My Cart Icon
    Then checkout button should be enabled
    When click on Checkout Button
    Then checkout page is displayed
    When user clicks "Order Info" text on page
    Then "Order Info" window is displayed
#    And Add address details in order info
#    And user click save button on orderInfo window
    And select your delivery window
#    And user click save button on orderInfo window
    Then checkout page is displayed
    When user clicks "Payment" text on page
    Then payment CVV window is displayed
    When user enters "123" as CVV and clicks next
    Then checkout page is displayed
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    When user clicks Done button
    And go to Home tab
    Then verify home screen is displayed
    And click On View Details Button
    And  click On Edit Cart link
    When search To Add an Item
    And Add Item to Cart
    When click On Cancel Button
    When click on Checkout Button
    And click On Confirm Changes button
    Then order confirmation page is displayed
    When click On Back button to go back to Home Page


  #C16524
  @regression @functional
  Scenario: Edit Time - DUG/Attended/Unattended
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
    And go to Home tab
    Then verify home screen is displayed

    And click On View Details Button
    Then click On OrderInfoLink
    When change to required Delivery time
    Then click On changeTime
    And click on Save And Review Button
    And click On Confirm Changes button
    Then order confirmation page is displayed
    When click On Back button to go back to Home Page

    When click on shopping mode down arrow
    And change to delivery shopping mode
    Then verify delivery shopping mode is selected
    When search a product on home page
    Then verify products listing page displayed
    And add products on product details page till cart value is equal to or more than 30 dollars
    And click on My Cart Icon
    Then checkout button should be enabled
    When click on Checkout Button
    Then checkout page is displayed
    When user clicks "Order Info" text on page
    Then "Order Info" window is displayed
#    And Add address details in order info
    And select your delivery window
    And user click save button on orderInfo window
    Then checkout page is displayed
    When user clicks Payment text on page
    Then payment CVV window is displayed
    When user enters "123" as CVV and clicks next
    Then checkout page is displayed
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    When user clicks Done button
    When go to Home tab
    Then verify Home tab is selected

    Then verify home screen is displayed
    And click On View Details Button
    Then click On OrderInfoLink
    When change to required Delivery time
    Then click On changeTime
    And click on Save And Review Button
    And click On Confirm Changes button
    Then order confirmation page is displayed
    When click On Back button to go back to Home Page


  #C16525
  @regression @functional
  Scenario:  Cancel Order - DUG/Attended/Unattended
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
    Then verify home screen is displayed
    When scroll down to other features carousel
    When click on orders module in product features carousel
    Then verify orders page is displayed
    Then cancel all pending orders
    Then user don't have pending orders


    When sign in to the application
    Then verify home screen is displayed
    When click on shopping mode down arrow
    And change to delivery shopping mode
    Then verify delivery shopping mode is selected
    When search a product on home page
    Then verify products listing page displayed
    And add products on product details page till cart value is equal to or more than 30 dollars
    And click on My Cart Icon
    Then checkout button should be enabled
    When click on Checkout Button
    Then checkout page is displayed
    When user clicks "Order Info" text on page
    Then "Order Info" window is displayed
#    And Add address details in order info
#    And user click save button on orderInfo window
    And select your delivery window
    And user click save button on orderInfo window
    Then checkout page is displayed
    When user clicks "Payment" text on page
    Then payment CVV window is displayed
    When user enters "123" as CVV and clicks next
    Then checkout page is displayed
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    When user clicks Done button
    And  go to Home tab
    Then verify home screen is displayed
    When scroll down to other features carousel
    When click on orders module in product features carousel
    Then verify orders page is displayed
    Then cancel all pending orders
    Then user don't have pending orders

    #C20817
  @regression @end_scenario
  Scenario: Verify Clip coupon on Edit Cart
    When kill and relaunch the application without popup handling
    And click Continue on cache pop up for "android" platform
    And handle tutorial if displayed
    And go to Home tab
    When click on My Cart Icon
    And clear cart items
    And click on close button on my cart screen
    And click on deals tab
    When go to 'BOGO' Tab
    Then expand category verify BOGO products displayed
    And add 2 number of BOGO products on product details page and verify count on cart is increased
    And go to Home tab
    When search a product on home page
    And add products on product details page till cart value is equal to or more than 30 dollars
    And click on My Cart Icon
    When click on Checkout Button
    Then verify check out page is displayed
    When user clicks "Order Info" text on page
    Then "Order Info" window is displayed
    And scroll down the screen
    And user change date picker to enable save
    And user click save button on orderInfo window
    Then verify check out page is displayed
    When user clicks "Payment" text on page
    Then payment CVV window is displayed
    When user enters "123" as CVV and clicks next
    Then checkout page is displayed
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    When user clicks Done button
    When go to Home tab
    Then verify Home tab is selected
    When click on settings icon
    Then verify settings page is displayed
    When click on Order button
    Then order page is displayed
    Then verify pending orders displayed
    And user click on Edit Order
    And  click On Edit Cart link
    Then click offer details on my cart page
    Then verify offer details page displayed
    And close deal details page
    And go back to edit order page
    And click On Confirm Changes button
    Then edit order confirmation page is displayed
    When user clicks Done button
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

  @MRR-612
  Scenario:  Place Order - DUG-Chase Store
    And go to Home tab
    When click on shopping mode down arrow
    And select the chase pick-up store
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
    And go to Home tab
    Then verify home screen is displayed