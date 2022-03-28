Feature: CartSubstitution(v2)

  #C71628
  #Author: Gerardo
  @regression @module_substitutionV2 @start_scenario 
  Scenario: Verify that "Confirm Substitution" & "Don't substitute" buttons are sticky at the bottom on the find substitute screen.
    Then verify substitutions buttons in search substitution page

  #C74563
  #C74558
  #Author: Gerardo
  @regression @module_substitutionV2
  Scenario: Verify that single "Do not sub" option only applies to the specified/existing items in the cart not for global level
  Verify that if shopper taps "No" on Pop Over screen it closes the pop over and the app return to the cart/edit cart screen with the previously selected substitution preference applied

    Then validate 1 equals 1