Feature: chevron function at view order at order history page


  @order
  Scenario:validate the chevron functionality at orderhistory page

    When Signin to the application with existing Order placed
    When user clicks on profile icon
    Then user clicks on orders button
    Then user lands on order history page
    Then user validates chevron next to order date
    Then The order details are displayed
    Then validate view Details to track details
    Then chevron is selected


  Scenario:validate the chevron functionality at orderhistory page

    When click on NewSignup Api for OTP
    When user enters "94566" in zipcode page
    When user click delivery option
    And user click start shopping button on Sign In page
    Then complete tutorial flow
    When click on search field
    Then user add item to cart and click checkout
    Then user enters delivery address
    Then delivery time slot is selected oflaterdays
    When user enters "aaa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code
    When user enters "111" as CVV and clicks continue
    Then user enters contact details
    When place order button is clickable and click place order
    When user clicks Continue Shopping
    Then Verify and store OrderNumber,Fullfillment type ,Date,Time is displayed
    When User click on Continue Shopping
    When user clicks menu button on home page
    Then user clicks on orders button
    Then validate view Details to track details
    Then view detail is clicked
    Then user validates  orderdate is displayed
    Then user validates ordernumber is displayed
#    Then user validates order total is displayed

