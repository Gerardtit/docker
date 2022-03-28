@checkout
Feature: Checkout Feature

  Background: setup user on SignIn Page
    When navigate to home page
    Then home page is displayed
    When navigate to available checkout page from home page
    Then home page is displayed

  @regression
  Scenario Outline: checkout as Delivery - unattended and attended order
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
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    When user select "<delivery type>" option
    And scroll down the screen
    And user change date picker to enable save
    And user click save button on orderInfo window
    Then checkout page is displayed
    When user clicks "Payment" text on page

    Then payment CVV window is displayed
    When user enters "111" as CVV and clicks next
    Then checkout page is displayed

    When user clear promo code from checkout page
    Then checkout page is displayed

    And place order button is clickable and click place order
    Then order confirmation page is displayed
    When user clicks Done button
    Then home page is displayed
    When user click menu button on home page
    Then menu page is displayed
    When user clicks orders on menu page
    Then order page is displayed
    When user click cancel order on order page
    And user wait for cancel order pop up window
    And user click cancel order button from pop up
    Then past orders list is displayed on the order page

    Examples:
      | delivery type |
      | unattended    |
      | attended      |

  @regression
  Scenario: checkout as pickup
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
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    And scroll down the screen
    And user change date picker to enable save
    And user click save button on orderInfo window
    Then checkout page is displayed
    When user clicks "Payment" text on page
    Then payment CVV window is displayed
    When user enters "111" as CVV and clicks next
    Then checkout page is displayed

    When user clear promo code from checkout page
    Then checkout page is displayed

    And place order button is clickable and click place order
    Then order confirmation page is displayed
    When user clicks Done button
    Then home page is displayed
    When user click menu button on home page
    Then menu page is displayed
    When user clicks orders on menu page
    Then order page is displayed
    When user click cancel order on order page
    And user wait for cancel order pop up window
    And user click cancel order button from pop up
    Then order page is displayed
    Then past orders list is displayed on the order page


  @regression
  Scenario Outline: checkout as Delivery with promo code - unattended and attended order
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
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    When user select "<delivery type>" option
    And scroll down the screen
    And user change date picker to enable save
    And user click save button on orderInfo window
    Then checkout page is displayed
    When user clicks "Payment" text on page
    Then payment CVV window is displayed
    When user enters "111" as CVV and clicks next
    Then checkout page is displayed

    When user clear promo code from checkout page
    Then checkout page is displayed

    When user clicks promo code on checkout page
    Then promo code deals window is dislayed
    When user enters promo code "LUVFRESH" and click next
    Then Applied is displayed on page
    When user select back button to checkout page
    Then checkout page is displayed

    And place order button is clickable and click place order
    Then order confirmation page is displayed
    When user clicks Done button
    Then home page is displayed
    When user click menu button on home page
    Then menu page is displayed
    When user clicks orders on menu page
    Then order page is displayed
    When user click cancel order on order page
    And user wait for cancel order pop up window
    And user click cancel order button from pop up
    Then past orders list is displayed on the order page


    Examples:
      | delivery type |
      | unattended    |
      | attended      |

  @regression
  Scenario: checkout as pickup - with promo code
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
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    And user change date picker to enable save
    And scroll down the screen
    And user click save button on orderInfo window
    Then checkout page is displayed
    When user clicks "Payment" text on page
    Then payment CVV window is displayed
    When user enters "111" as CVV and clicks next
    Then checkout page is displayed

    When user clear promo code from checkout page
    Then checkout page is displayed

    When user clicks promo code on checkout page
    Then promo code deals window is dislayed
    When user enters promo code "LUVFRESH" and click next
    Then Applied is displayed on page
    When user select back button to checkout page
    Then checkout page is displayed

    And place order button is clickable and click place order
    Then order confirmation page is displayed
    When user clicks Done button
    Then home page is displayed
    When user click menu button on home page
    Then menu page is displayed
    When user clicks orders on menu page
    Then order page is displayed
    When user click cancel order on order page
    And user wait for cancel order pop up window
    And user click cancel order button from pop up
    Then order page is displayed
    Then past orders list is displayed on the order page


  @checkoutframe
  Scenario: checkout frame  as pickup
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
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
