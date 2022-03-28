@order_info
Feature: Order Info Feature

  Background: setup user on Home Page
    When navigate to home page
    Then home page is displayed
    When navigate to available checkout page from home page
    Then home page is displayed

  @regression
  Scenario: update contact phone number
    When user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks "Contact" text on page
    Then "Contact" window is displayed
    When user enters "2223334444" in phone number field on Contact window
    And user click save button on orderInfo window
    Then checkout page is displayed
    And "4444" text is displayed on the screen

  @regression
  Scenario: order info - DUG order store selection
    When user clicks delivery option on home page
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    And user clicks next button after registration on zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then home page is displayed
    And verify "pickup" option is selected as preference on home page
    When user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks "Order Info" text on page
    Then "Order Info" window is displayed
    When user clicks "Change Store" text on page
    Then "Store Selection" window is displayed

  @regression
  Scenario: order info - DUG order save a DUG order time
    When user clicks delivery option on home page
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    And user clicks next button after registration on zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then home page is displayed
    And verify "pickup" option is selected as preference on home page
    When user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks "Order Info" text on page
    Then "Order Info" window is displayed
    And user change date picker to enable save
    And user click save button on orderInfo window
    Then checkout page is displayed

  @regression
  Scenario: order info - Delivery order - unattended and attended - edit address
    When user clicks delivery option on home page
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    And user clicks next button after registration on zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then home page is displayed
    And verify "delivery" option is selected as preference on home page
    When user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks "Order Info" text on page
    Then "Order Info" window is displayed
    When user clicks "Edit" text on page
    Then "Address Book" window is displayed
    When user clicks "Edit" text on page
    Then "Edit Delivery Address" window is displayed

  @regression
  Scenario Outline: Order Info - Delivery/attended - time slot update
    When user clicks delivery option on home page
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    And user clicks next button after registration on zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then home page is displayed
    And verify "delivery" option is selected as preference on home page
    When user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks "Order Info" text on page
    Then "Order Info" window is displayed
    When user select "attended" option
    And user select <slot> hour option on delivery window
    And scroll down the screen
    And user change date picker to enable save
    And user click save button on orderInfo window
    Then checkout page is displayed
    When scroll down the screen
    And user clicks "Cart" text on page
    Then shopping cart page is displayed

    Examples:
      | slot |
      | 1    |
      | 2    |
      | 4    |

  @regression
  Scenario: order info - Delivery order - unattended time update
    When user clicks delivery option on home page
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    And user clicks next button after registration on zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then home page is displayed
    And verify "delivery" option is selected as preference on home page
    When user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks "Order Info" text on page
    Then "Order Info" window is displayed
    When user select "unattended" option
    And user change date picker to enable save
    And user click save button on orderInfo window
    Then checkout page is displayed
    And "Leave bags at my doorstep" text is displayed on the screen
    When scroll down the screen
    And user clicks "Cart" text on page
    Then shopping cart page is displayed

  @regression
  Scenario: payment info - add credit card info
    When user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks "Payment" text on page
    Then "Payment" window is displayed
    When user enters "aaa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code
    And user clicks "Continue" text on page
    Then "CVV" text is displayed on the screen
    When user enters "111" as CVV and clicks next
    Then checkout page is displayed

  @regression
  Scenario: add and remove promo code
    When user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    When user select "attended" option
    And user change date picker to enable save
    And user click save button on orderInfo window
    Then checkout page is displayed
    When user clear promo code from checkout page
    Then checkout page is displayed
    When user clicks promo code on checkout page
    Then promo code deals window is dislayed
    When user enters promo code "LUVFRESH" and click next
    Then Applied is displayed on page

  @regression
  Scenario: verify terms of use, privacy of policy
    When user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When scroll down the screen
    And "Terms of Use" text is displayed on the screen
    And "Privacy Policy" text is displayed on the screen
    And scroll down the screen
    And "P65Warning" text is displayed on the screen for California banner

  @regression
  Scenario: order info - verify Estimated Subtotal, Delivery fee, Promo code, Club card saving, Estimated total
    When user clicks shopping cart button on home page
    Then shopping cart page is displayed
    When user empty shopping cart
    Then shopping cart empty page is displayed
    When user clicks navigate back to the previous page
    Then home page is displayed
    When user clicks delivery option on home page
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    And user clicks next button after registration on zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then home page is displayed
    And verify "delivery" option is selected as preference on home page
    When user clicks search bar on home page
    And user types "baby cereal" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks deals toggle switch on the search page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user change quantity to "9" number of items
    And user goes back to home page from search page
    Then home page is displayed
    When user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    When user select "attended" option
    And user change date picker to enable save
    And user click save button on orderInfo window
    Then checkout page is displayed
    When user clear promo code from checkout page
    Then checkout page is displayed
    When user clicks promo code on checkout page
    Then promo code deals window is dislayed
    When user enters promo code "LUVFRESH" and click next
    Then Applied is displayed on page
    When user select back button to checkout page
    Then checkout page is displayed
    When user scroll down to total summary
    Then "Estimated Subtotal" text is displayed on the screen
    Then "LUVFRESH" text is displayed on the screen
    Then "Club Card Savings" text is displayed on the screen
    Then "Delivery Fee" text is displayed on the screen
    Then "Estimated Total" text is displayed on the screen


  @Newpin


  Scenario: checkout as pickup - Foe New Pin
    When user clicks delivery option on home page
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    And user clicks next button after registration on zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then home page is displayed
