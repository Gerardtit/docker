Feature: Analytics Product Quantity

  Background:
    When invoke Charles Proxy
    Then start Charles Proxy Recording
    Then sign in to the application using account with existing rewards


##------------Add product quantity tags verify-------------
#  Scenario: When the Search Product screen is loaded tags are coming
#    Then click on home tab
#    And Search product
#    And Click on Product
#    And Click on Add to Cart
#    And Click on Add Quantity
#    Then download Charles Logs in File "addcartquantity"
#    Then stop Charles Proxy Recording
#    Then Remove item from cart
#    Then verify Charles Proxy Logs for all attribute with tag "addcartquantity"

#-----------------------------------------------------------------------
 # --------------------- Decrease Product quantity tage verify---------
#
#  Scenario:  Decrease Product quantity tage verify
#
#    Then click on home tab
#    And Search product
#     And Click on Product
#    And Click on Add to Cart
#    And Click on Add Quantity
#    And Click on Decrease Product quantity
#    Then download Charles Logs in File "decreasecartquantity"
#    Then stop Charles Proxy Recording
#    Then Remove item from cart
#    Then verify Charles Proxy Logs for all attribute with tag "decreasecartquantity"

#
#   #--------------------- remove Product from cart tage verify---------
  Scenario: When the Search Product screen ,and add item and remove item then loaded tags are coming

    Then click on home tab
    And Search product
    And Click on Product
    And Click on Add to Cart
    And Click on Add Quantity
    And Click on Decrease Product quantity
    Then Remove item from cart
    Then download Charles Logs in File "removeitem"
    Then stop Charles Proxy Recording
    Then verify Charles Proxy Logs for all attribute with tag "removeitem"

##------------------------------------------------------------------------------