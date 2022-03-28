Feature: validate crash at Cart

  @123
  Scenario:validate crash at Cart


    When sign in to the application for pickup orders
    When click on search field
    And user types "milk" on search bar and click search on home page and enter first milk
    Then user add item to cart
    Then user clicks on edit at slotpage
    And selects different store
    And user clicks back arrow on cart page
    Then pickup time slot is selected
    And user enter credit card details
    When user enters "aaa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code
    When user enters "111" as CVV and clicks continue
    When place order button is clickable and click place order
    When user clicks Continue Shopping
    When keep app in background and relaunching the same
    And click 'Yes' if 'Love the app' popup is displayed
    And go to Home tab
    And click on My Cart Icon
    Then shopping cart page is displayed


  Scenario:validate cart icon in edit flow

    When sign in to the application for pickup orders
    When click on search field
    And user types "milk" on search bar and click search on home page and enter first milk
    Then user add item to cart
    Then pickup time slot is selected
    When user enters "aaa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code
    When user enters "111" as CVV and clicks continue
    When place order button is clickable and click place order
    When user clicks Continue Shopping
    And click 'Yes' if 'Love the app' popup is displayed
    And go to Home tab
    When user clicks on profile icon
    When user clicks orders on menu page
    Then "Orders" window is displayed
    Then user clicks Edit order at order page
    Then user selects the items
    When user selects the first item
    Then verify PDP screen is displayed
    And click on My Cart Icon
    Then user lands on the Edit cart page


  @sjain1000
  Scenario:Verify the default slot selection behaviour in Edit order screen

    When sign in to the application for pickup orders
    When click on search field
    And user types "milk" on search bar and click search on home page and enter first milk
    Then user add item to cart
    Then pickup time slot is selected and slot details are stored for verification
    When user enters "aaa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code
    When user enters "111" as CVV and clicks continue
    Then user enters contact information on conatct details screen
    When place order button is clickable and click place order
    When user clicks Continue Shopping
    And click 'Yes' if 'Love the app' popup is displayed
    And go to Home tab
    When user clicks on profile icon
    When user clicks orders on menu page
    Then "Orders" window is displayed
    Then user clicks Edit order at order page
    And click on Edit pickup time
    Then pickup time slot is selected
    Then user clicks on Edit button on CVV screen
    When user enters "aaa" as name on credit card
    And user enters "4111111111111111" as credit card number
    And user enters "1230" as card expiration month year
    And user enters "99999" as billing zip code and stores the card
    When user enters "111" as CVV and clicks continue
    And user clicks back button
    And user clicks checkout button on cart page
    When user enters "111" as CVV and clicks continue
    Then user validates Visa and card number in review order page

#  @MRR-618 @Omprakash

  Scenario:validate cart icon in edit flow

    When sign in to the application for pickup orders
    When click on search field
    And user types "milk" on search bar and click search on home page and enter first milk
    Then user add item to cart
    Then pickup time slot is selected
    Then user clicks on Edit button on CVV screen
    When user enters "aaa" as name on credit card
    And user enters "4111111111111111" as credit card number
    And user enters "1230" as card expiration month year
    And user enters "99999" as billing zip code and stores the card
    When user enters "111" as CVV and clicks continue
    And user clicks back button
    And user clicks checkout button on cart page
    When user enters "111" as CVV and clicks continue
    Then user validates Visa and card number in review order page



#  @MRR-619 @Omprakash
  @om12
  Scenario:validate scrolling function
    When sign in to the application for pickup orders
    When click on search field
    And user types "bread" on search bar and click search on home page
    And user scroll down to order history



