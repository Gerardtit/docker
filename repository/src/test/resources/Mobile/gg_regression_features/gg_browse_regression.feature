Feature: Browse-Regression

  #C16644
  @regression @functional @start_scenario
  Scenario:  Verify Ailes - L1/L2/L3 Product
    When sign in to the application
    Then verify home screen is displayed
    And go to Home tab
    And select the pick-up store
    When search a product on home page
    Then verify products listing page displayed

  #C16646
  @regression @functional @end_scenario
  Scenario:  PDP pages - Add/Remove/ Max QTY
    Then go back to Home Page
    When click on My Cart Icon
    And clear cart items
    And click on close button on my cart screen
    When search a product on home page
    And verify products listing page displayed
    Then add more than 20 counts of the same item on product details page and verify that only 20 counts can be added

    #Marking this as manual, since Increment/Decrement IDs were removed in product listing page
#  #C16645
#  @regression @functional
#  Scenario:  Add products/Update Products/ Max QTY
#    Then go back to Home Page
#    When click on My Cart Icon
#    And clear cart items
#    And click on close button on my cart screen
#    When search a product on home page
#    Then verify products listing page displayed
#    And add more than 20 counts of the same item on products listing page and verify that only 20 counts can be added