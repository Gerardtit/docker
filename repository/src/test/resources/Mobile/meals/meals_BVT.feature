Feature: Meals Experience Verification

  @regression @module_meals @all_meals @start_scenario @meals_failed
  Scenario: Verify meals menu entry point from UMA Home page
    When sign in to the application
    When uma home page is displayed
    Then meal Plans option should be shown on carousel list
    Then meal plans button on halo nav carousel is clickable
    When user clicks on meal plans on halo nav carousel
    Then verify meals homepage or onboarding flow is displayed
    When User clicks on back button
    Then uma home page is displayed

#  @regression @module_meals @all_meals
#  Scenario: User can click meals menu banner on homepage
#    When uma home page is displayed
#    And scroll down the screen for meals menu banner
#    When User clicks on the homepage meals menu banner
#    Then verify meals homepage or onboarding flow is displayed
#    When User clicks on back button
#    Then uma home page is displayed

  @regression @module_meals @all_meals
  Scenario: Back button should exit meals menu and take back to uma homepage
    Given User is on meals homepage
    When User clicks on back button
    Then uma home page is displayed

  @regression @module_meals @all_meals
  Scenario: User skips onboarding
    When uma home page is displayed
    When user clicks on meal plans on halo nav carousel
    When onboarding flow is displayed
    When user clicks skip button
    Then meals experience homepage is displayed

  @regression @module_meals @all_meals
  Scenario: Verify meals experience homepage
    Given User is on meals homepage
    When User clicks on back button
    Then uma home page is displayed
    Given User is on meals homepage
    Then meals search is displayed
    Then Meals text is displayed
    Then cuisine type halo cards are displayed
    Then Edit preferences button is displayed
    Then Most popular recipe section is displayed
    Then top rated recipe section is displayed
    Then vegetarian recipe section is displayed


#  @meals_homepage @all_meals
#  Scenario: See all button recently created
#    Given User is on meals homepage
#    When user clicks on see all recently created button
#    Then recently created recipes list is shown
#    When User clicks on back button on recipe list page
#    Then meals experience homepage is displayed

  @regression @module_meals @all_meals
  Scenario: Add recipe to favorites
    Given User is on meals homepage
    When User clicks on second cuisine type
    Then recipes list page is displayed
    When User selects recipe
    Then recipe details page is displayed
    Then user marks recipe favorite
    Then recipe should appear on meals homepage favorite category

  @regression @module_meals @all_meals
  Scenario: Remove recipe from favorites
    Given User is on meals homepage
    When user clicks on favorite recipe item one
    Then user removes recipe from favorite
    Then recipe should disappear on meals homepage favorite category


  @regression @module_meals @all_meals @meals_failed
  Scenario: User shop ingredients Shop for delivery/pickup
    Given User is on meals homepage
    When User clicks most popular recipe item one tile
    Then recipe details page is displayed
    Then user adds to meal plan
    Then meals experience homepage is displayed
    When User clicks review plan
    Then Review your plan is displayed
    When user clicks on shop ingredients
    Then option for how to shop should be shown in prompt sheet
    When user clicks on close button on prompt sheet
    When user clicks on shop ingredients
    When user clicks on shop for delivery or pickup
    Then Shop ingredients page is displayed
    When user clicks on add products to cart
    Then products have been added to your cart confirmation is shown
    When user clicks on go to cart to checkout
    Then verify cart is Displayed

  @regression @module_meals @all_meals @meals_failed
  Scenario: User clicks view my meals button after adding products to cart
    Given User is on meals homepage
    When User clicks on first cuisine type
    Then recipes list page is displayed
    When User selects recipe using quick add button on second item
    When User clicks review plan
    Then Review your plan is displayed
    When user clicks on shop ingredients
    When user clicks on shop for delivery or pickup
    Then Shop ingredients page is displayed
    When user clicks on add products to cart
    Then products have been added to your cart confirmation is shown
    When user clicks view my meals
    Then meals experience homepage is displayed

  @regression @module_meals @all_meals
  Scenario: User clicks back to meals button after adding products to my list
    Given User is on meals homepage
    When User clicks on third cuisine type
    Then recipes list page is displayed
    When User selects recipe using quick add button on third item
    When User clicks review plan
    Then Review your plan is displayed
    When user clicks on shop ingredients
    Then option for how to shop should be shown in prompt sheet
    When user clicks on add ingredients to my list
    Then review ingredients page is displayed
    When user clicks on add items to list
    Then products have been added to your list confirmation is shown
    When user clicks back to meals
    Then meals experience homepage is displayed

  @regression @module_meals @all_meals
  Scenario: User shop ingredients add ingredients to my list
    Given User is on meals homepage
    When User clicks top rated recipe item one quick add button
    When User clicks review plan
    Given Review your plan is displayed
    When user clicks on shop ingredients
    Then option for how to shop should be shown in prompt sheet
    When user clicks on add ingredients to my list
    Then review ingredients page is displayed
    When user clicks on add items to list
    Then products have been added to your list confirmation is shown
    When user clicks on show my list
    Then verify my list page is displayed

  @regression @module_meals @all_meals
  Scenario: Click edit preferences button and back
    Given User is on meals homepage
    Then meals search is displayed
    Then Meals text is displayed
    Then cuisine type halo cards are displayed
    Then Edit preferences button is displayed
    When user clicks edit preferences button
    Then Diet preferences screen is displayed
    When User clicks on back button on edit preferences screen
    Then meals experience homepage is displayed

  @regression @module_meals @all_meals
  Scenario: search meals page categories
    Given User is on meals homepage
    Then meals search is displayed
    When user clicks on search button on meals homepage
    Then suggested category is shown
    Then dish types category is shown
    Then calories per serving category is shown
    Then cuisines category is shown
    Then user clicks back button on meals search page
    Then meals experience homepage is displayed

  @regression @module_meals @all_meals
  Scenario: start cooking complete cooking
    Given User is on meals homepage
    When user clicks on start cooking on meals homepage
    Then cooking mode step 1 is shown
    Then user clicks done button in cooking mode last step
    Then meals experience homepage is displayed

  @regression @module_meals @all_meals
  Scenario: show past meals cooked
    Given User is on meals homepage
    When user clicks see all my meals button or show past meals
    Then My meals page should be displayed
    Then user goes to cooked tab
    Then verify recipe is shown in cooked tab
    When user clicks back button on my meals page
    Then meals experience homepage is displayed

  @regression @module_meals @all_meals
  Scenario: onboarding flow happy path
    When uma home page is displayed
    When user clicks on meal plans on halo nav carousel
    When onboarding flow is displayed
    When user clicks on pick your diet
    Then pick your diet page is displayed
    When user clicks on next button
    Then onboarding allergies or restrictions page is displayed
    When user clicks on next button
    Then onboarding dislikes page is displayed
    When user clicks on next button
    Then servings page is displayed
    Then user clicks on done button
    Then meals experience homepage is displayed