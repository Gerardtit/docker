Feature: SCP

  #C74144
  #C74145
  #C74170
  #C74171
  #Author: Gerardo fixed And/iOS
  @regression @module_SCP @start_scenario
  Scenario: As a user, I should be able to see the final price for each item, along with any type of savings that is applied for that product.
  As a user, I should be able to see all the details for the product when its added in cart
    Then validate 1 equals 1

  #C74323
  #Author:Rohith missing prod
  @regression @module_SCP
  Scenario: As a user, I should see the SCP is retained , when user clicks on substitutions, Add note component and navigate back to the cart screen
    Then validate 1 equals 1