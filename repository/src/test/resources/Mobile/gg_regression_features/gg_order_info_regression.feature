Feature: Order Info-Regression

  #C16538
  @regression @start_scenario
  Scenario: UMA_ Verify DUG address and time slots
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
    When user clicks "Order Info" text on page
    Then "Order Info" window is displayed
    And verify store address and time slot displayed
    And click back button on order info page
    Then handle alert pop up
    And click On Back Button to navigate to My Cart Screen
    Then click on close button on my cart screen
    And click cancel button on product search page

  #C16538
  @regression
  Scenario: UMA_ Verify Delivery address and time slots
    And go to Home tab
    And select the delivery store
    When search a product on home page
    Then verify products listing page displayed
    And add products on product details page till cart value is equal to or more than 30 dollars
    And click on My Cart Icon
    Then checkout button should be enabled
    When click on Checkout Button
    Then checkout page is displayed
    When user clicks "Order Info" text on page
    Then "Order Info" window is displayed
    And verify delivery address and time slot displayed
    And click back button on order info page
    Then handle alert pop up
    Then checkout page is displayed
    And click On Back Button to navigate to My Cart Screen
    Then click on close button on my cart screen
    And click cancel button on product search page

  #C16539
  @regression
  Scenario: UMA_ Verify Choose/update Time slots
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
    And scroll down the screen
    And user change date picker to enable save
    And user click save button on orderInfo window
    Then checkout page is displayed
    And click On Back Button to navigate to My Cart Screen
    Then click on close button on my cart screen
    And click cancel button on product search page

  #C16540
  @regression
  Scenario: UMA_ Verify Edit / Add address
    And go to Home tab
    And select the delivery store
    When search a product on home page
    Then verify products listing page displayed
    And add products on product details page till cart value is equal to or more than 30 dollars
    And click on My Cart Icon
    Then checkout button should be enabled
    When click on Checkout Button
    Then checkout page is displayed
    When user clicks "Order Info" text on page
    When user clicks "Edit" text on page
    Then "Address Book" window is displayed
    And click edit address on Address Book page
    Then "Edit Delivery Address" window is displayed
    And navigate back to previous page
    Then handle alert pop up
    And navigate back to previous page
    And click back button on order info page
    Then handle alert pop up
    Then checkout page is displayed
    And click On Back Button to navigate to My Cart Screen
    Then click on close button on my cart screen
    And click cancel button on product search page


  #C16543
  @regression
  Scenario: UMA_ Verify Slots - 1hr/2hr/4hr
    And go to Home tab
    And select the delivery store
    When search a product on home page
    Then verify products listing page displayed
    And add products on product details page till cart value is equal to or more than 30 dollars
    And click on My Cart Icon
    Then checkout button should be enabled
    When click on Checkout Button
    Then checkout page is displayed
    When user clicks "Order Info" text on page
    Then verify all delivery window options displayed
    And click back button on order info page
    Then handle alert pop up
    Then checkout page is displayed
    And click On Back Button to navigate to My Cart Screen
    Then click on close button on my cart screen
    And click cancel button on product search page

  #C16547
  @regression
  Scenario: UMA_ Verify Delivery window Info icon
    And go to Home tab
    And select the delivery store
    When search a product on home page
    Then verify products listing page displayed
    And add products on product details page till cart value is equal to or more than 30 dollars
    And click on My Cart Icon
    Then checkout button should be enabled
    When click on Checkout Button
    Then checkout page is displayed
    When user clicks "Order Info" text on page
    Then verify delivery window info icon displayed
    And click back button on order info page
    Then handle alert pop up
    Then checkout page is displayed
    And click On Back Button to navigate to My Cart Screen
    Then click on close button on my cart screen
    And click cancel button on product search page

  #C16548
  @regression
  Scenario: UMA_ Verify save button - enable and Disabled
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
    Then verify save button on order info page is disabled
    Then user change date picker to enable save
    Then verify save button on order info page is enabled
    And click back button on order info page
    Then handle alert pop up
    Then checkout page is displayed
    And click On Back Button to navigate to My Cart Screen
    Then click on close button on my cart screen
    And click cancel button on product search page

  #C16542
  @regression @end_scenario
  Scenario: UMA_ Verify customer should NOT be able to enter more than 11 digits in Delivery Instruction section for ADD and Update delivery address
    And go to Home tab
    And select the delivery store
    When search a product on home page
    Then verify products listing page displayed
    And add products on product details page till cart value is equal to or more than 30 dollars
    And click on My Cart Icon
    When click on Checkout Button
    Then checkout page is displayed
    When user clicks "Order Info" text on page
    Then verify Order Info page displayed
    When user clicks "Edit" text on page
    And click edit address on Address Book page
    And user enters address on order info page
    And user enters "12" number of digits in delivery instructions field
    Then verify Enter Valid Instructions warning displayed