Feature: Analytics Product Quantity

  Background:
    When invoke Charles Proxy
    Then start Charles Proxy Recording
    Then sign in to the application using account with existing rewards

  Scenario: OrderConfirmation Page verify tags

    Then click on home tab
    #Then user clicks continue Popups
    And Search product with "lysol multi"
    And Click on Search Product
    And Click on Add to Cart
    And Click on Add Quantity for Search Product
    And Click on cart
    And Click on checkout button
    And click On OrderInfoLink
    And click Delivery window hours
    And click on save button
    And click On Confirm CVV
    And user enters "123" as CVV and clicks next
    And user clicks promo code on checkout page
    And promo code deals window is dislayed
    #,NATUREVALLEY
    And user enters promo code "LYSOL" and click next
    #And user select back button to checkout page
    And user clicks navigate back to the previous page

    And click on Place Order Button to Place an Order
    Then download Charles Logs in File "orderconfirmation"
    Then stop Charles Proxy Recording
    Then verify Charles Proxy Logs for all attribute with tag "orderconfirmation"