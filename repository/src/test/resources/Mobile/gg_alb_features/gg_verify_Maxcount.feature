Feature: Verify Max Count

  @bvt_regression
  Scenario: Verify Max Count in PDP
    When Launch the MFA app
    And sign in to the application
    And user is logged in to the app for Existing user
    When user clicks shopping cart button on home page
    And user swipe left to remove all item in shopping cart
    And user close the new cart page
    When click on search field
    And user types "baby oil" on search bar and click search on home page
    Then user navigate to pdp of first product
    Then user verify max quantity in PDP
    When user clicks shopping cart button on home page
    Then user verify max quantity in cart