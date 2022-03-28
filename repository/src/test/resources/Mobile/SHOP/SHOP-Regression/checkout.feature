@Checkout
Feature: checkout features

  Background: setup user on SignIn Page
    Given navigate to home page
    Then home page is displayed
    When user clicks shopping cart button on home page
    Then shopping cart page is displayed
    When user empty shopping cart
    Then shopping cart empty page is displayed
    When user click check mark on shopping cart page
    Then home page is displayed
    When user clicks delivery option on home page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then home page is displayed

  @smoke
  Scenario: delivery unattended checkout and cancel order
    When user clicks search bar on home page
    And user types "baby health" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    When user increase the 1st item quantity by 10 on search page
    And user goes back to home page from search page
    Then home page is displayed
    When user clicks shopping cart button on home page
    Then shopping cart page is displayed
    When user increase the 1st item quantity by 10 on shopping cart page
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    When user select "unattended" option
    And user click save button on orderInfo window
    Then checkout page is displayed
    When user clicks payment on checkout page
    Then payment CVV window is displayed
    When user enters "111" as CVV and clicks next
    Then checkout page is displayed
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    When user clicks Done button
    Then popup feedback alert window
    When user select yes on alert window
    Then popup rating window
    When user select not now button
    Then home page is displayed
    When user click menu button on home page
    Then menu page is displayed
    When user clicks orders on menu page
    Then order page is displayed
    When user click cancel order on order page
    And user wait for cancel order pop up window
    And user click cancel order button from pop up

  @smoke
  Scenario: delivery attended checkout and cancel order
    When user clicks search bar on home page
    And user types "baby health" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    When user increase the 1st item quantity by 10 on search page
    And user goes back to home page from search page
    Then home page is displayed
    When user clicks shopping cart button on home page
    Then shopping cart page is displayed
    When user increase the 1st item quantity by 10 on shopping cart page
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    When user select "attended" option
    And user click save button on orderInfo window
    Then checkout page is displayed
    When user clicks payment on checkout page
    Then payment CVV window is displayed
    When user enters "111" as CVV and clicks next
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

  @smoke
  Scenario: dug order checkout and cancel order
    When user clicks delivery option on home page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then search zipcode bar is displayed on delivery select page
    When user enters zipcode and search in zipcode field
    Then store list is displayed
    When user clicks 1st store on the list
    And user click start shopping button on Sign In page
    Then home page is displayed
    When user clicks search bar on home page
    And user types "baby health" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    When user increase the 1st item quantity by 10 on search page
    And user goes back to home page from search page
    Then home page is displayed
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    When user increase the 1st item quantity by 10 on shopping cart page
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    And user click save button on orderInfo window
    Then checkout page is displayed
    When user clicks payment on checkout page
    Then payment CVV window is displayed
    When user enters "111" as CVV and clicks next
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

  @smoke
  Scenario Outline: delivery unattended or attended checkout with promo code and cancel order
    When user clicks search bar on home page
    And user types "baby health" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    When user increase the 1st item quantity by 10 on search page
    And user goes back to home page from search page
    Then home page is displayed
    When user clicks shopping cart button on home page
    Then shopping cart page is displayed
    When user increase the 1st item quantity by 10 on shopping cart page
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    When user select "<delivery type>" option
    And user click save button on orderInfo window
    Then checkout page is displayed
    When user clicks payment on checkout page
    Then payment CVV window is displayed
    When user enters "111" as CVV and clicks next
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

    Examples:
      | delivery type |
      | unattended    |
      | attended      |

  @smoke
  Scenario: delivery attended checkout with promo code and cancel order
    When user clicks search bar on home page
    And user types "baby health" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    When user increase the 1st item quantity by 10 on search page
    And user goes back to home page from search page
    Then home page is displayed
    When user clicks shopping cart button on home page
    Then shopping cart page is displayed
    When user increase the 1st item quantity by 10 on shopping cart page
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    When user select "attended" option
    And user click save button on orderInfo window
    Then checkout page is displayed
    When user clicks payment on checkout page
    Then payment CVV window is displayed
    When user enters "111" as CVV and clicks next
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

  @smoke
  Scenario: dug order checkout with promo code and cancel order
    When user clicks delivery option on home page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then search zipcode bar is displayed on delivery select page
    When user enters zipcode and search in zipcode field
    Then store list is displayed
    When user clicks 1st store on the list
    And user click start shopping button on Sign In page
    Then home page is displayed
    When user clicks search bar on home page
    And user types "baby health" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    When user increase the 1st item quantity by 10 on search page
    And user goes back to home page from search page
    Then home page is displayed
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    When user increase the 1st item quantity by 10 on shopping cart page
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    And user click save button on orderInfo window
    Then checkout page is displayed
    When user clicks payment on checkout page
    Then payment CVV window is displayed
    When user enters "111" as CVV and clicks next
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

