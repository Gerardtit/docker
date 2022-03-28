Feature: validate crash at Cart

  Background:

    When click on NewSignup Api for OTP
#    When sign in to the application for pickup orders
#    When click on search field
#    And user types "milk" on search bar and click search on home page and enter first milk
#    Then user add item to cart
#    Then pickup time slot is selected
#    When user enters "aaa" as name on credit card
#    And user enters "4242424242424242" as credit card number
#    And user enters "1226" as card expiration month year
#    And user enters "99999" as billing zip code
#    When user enters "111" as CVV and clicks continue
#    When place order button is clickable and click place order
#    When user clicks Continue Shopping
#    And click 'Yes' if 'Love the app' popup is displayed
#    And go to Home tab
    When user clicks on profile icon
    When user clicks orders on menu page
#    Then "Orders" window is displayed


#  @onama00

  Scenario:validate cart icon in edit flow


    Then user clicks Edit order at order page
    Then user clicks back button on edit order page
    Then verify orders page is displayed



#   @onama00
  Scenario:validate cart icon in edit flow

    Then user clicks Edit order at order page
    Then user click on contact info tile
    Then user close the contact info page
    Then user clicks back button on edit order page
    Then verify orders page is displayed

# @onama00

  Scenario:validate cart icon in edit flow

    Then user clicks Edit order at order page
    Then user click on Cart in Edit Order
    Then user clicks back button on edit cart page
    Then user clicks back button on edit order page
    Then user verify cancel changes popup is displayed
    When user clicks on Discard Changes in the popup
    Then verify orders page is displayed


#  @onama00
  Scenario:validate cart icon in edit flow

    Then user clicks Edit order at order page
    Then user click on contact info tile
    And user edits and enters "9486898766" as phone number
    Then user clicks back button on edit order page
    Then user verify cancel changes popup is displayed
    When user clicks on Discard Changes in the popup
    Then verify orders page is displayed


#  @onama00

  Scenario:validate cart icon in edit flow

    Then user clicks Edit order at order page
    Then user adds "LUVFRESH" promo code and apply
    Then user clicks back button on edit order page
    Then user verify cancel changes popup is displayed
    When user clicks on Discard Changes in the popup
    Then verify orders page is displayed

#  @onama00

  Scenario:validate cart icon in edit flow

    Then user clicks on view order details in your orders page
    Then user clicks Edit order in order details page
    Then user clicks Save changes button in Edit your order page
    Then user clicks Edit order in edit order confirmation page
    Then user clicks Save changes button in Edit your order page
    Then user clicks on Continue shopping in order confirmation page
    And user lands on home page