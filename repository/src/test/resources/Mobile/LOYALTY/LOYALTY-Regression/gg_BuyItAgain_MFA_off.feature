@gg_BuyItAgain
Feature: Buy it again

#  Background:
#  Scenario: Buy it again Refine Page Validation
#    When sign in to the application using account with purchase history
#    Then verify home screen is displayed
#    When go to Mylist tab
#    When user click on Buy it again tab in My List page
#    Then verify user navigates to Buy it Again page

  Background: setup user on SignIn Page

  @regression
  Scenario: Buy it again Refine Page Validation
    Given startup page is displayed
    When user clicks continue button on startup page
    Then zipcode page is displayed
    When user clicks Sign in button on zipcode page
    Then sign in page is displayed
    When user enters "email" in username field on Sign In page
    And user enters "password" in password field on Sign In page
    And user clicks sign in on sign in page

  @regression
  Scenario: As a user with past purchases, I should be able to click Refine and choose Sort By and Filter By options
    When user click on refine button in Buy it again page
    Then verify refine window is displayed
    When user click 'Frequently Purchased' option from Sort By category
    Then verify 'Frequently Purchased' option has been selected
    When user click on 'Purchased Date' option from Sort By category
    Then verify 'Purchased Date' option has been selected
    When user click 'In-Store' option from Filter By category
    Then verify 'In-Store' option has been selected
    When user click 'Online' option from Filter By category
    Then verify 'Online' option has been selected
    Then user scroll down through the past months of the page
    When user click all the past month purchases and verify it is selected
    When user clicks on Apply button
    Then verify Buy it again Products displayed

  @regression
  Scenario: As a user with past purchases, I should be able to select purchase date option and validate that InStore is not tappable if Last order is selected and tappable if past months are selected
    When user click on refine button in Buy it again page
    Then verify refine window is displayed
    When user click on 'Purchased Date' option from Sort By category
    Then verify 'Purchased Date' option has been selected
    When user click 'In-Store' option from Filter By category
    Then verify 'In-Store' option has been selected
    When user click on 'Last Order' option from Purchase Date
    Then verify 'Last Order' option has been selected
    Then verify 'In-Store' option has not been selected
    When user click 'Online' option from Filter By category
    Then verify 'Online' option has been selected
    Then user scroll down through the past months of the page
    When user click all the past month purchases and verify it is selected
    When user click 'In-Store' option from Filter By category
    Then verify 'In-Store' option has been selected
    Then user scroll down through the past months of the page
    When user click all the past month purchases and verify it is selected
    When user clicks on Apply button

  @regression
  Scenario: s a user with past purchases, I should be able to validate product availability by navigating through all the pills with Sort by Frequently Purchased and choose different Filter By options
    When user click on refine button in Buy it again page
    Then verify refine window is displayed
    When user click on 'Purchased Date' option from Sort By category
    Then verify 'Purchased Date' option has been selected
    When user click 'In-Store' option from Filter By category
    Then verify 'In-Store' option has been selected
    Then user scroll down through the past months of the page
    When user click all the past month purchases and verify it is selected
    When user clicks on Apply button
    Then verify Buy it again Products displayed

    When user click on Dairy, Eggs & Cheese pill
    When user click on refine button in Buy it again page
    Then verify refine window is displayed
    When user click on 'Purchased Date' option from Sort By category
    Then verify 'Purchased Date' option has been selected
    When user click 'In-Store' option from Filter By category
    Then verify 'In-Store' option has been selected
    Then user scroll down through the past months of the page
    When user click all the past month purchases and verify it is selected
    When user clicks on Apply button
    Then verify Buy it again Products displayed
    When user click on refine button in Buy it again page
    Then verify refine window is displayed
    When user click 'Frequently Purchased' option from Sort By category
    Then verify 'Frequently Purchased' option has been selected
    When user click 'Online' option from Filter By category
    Then verify 'Online' option has been selected
    When user click on 'Last Order' option from Purchase Date
    Then verify 'Last Order' option has been selected
    Then user scroll down through the past months of the page
    When user click all the past month purchases and verify it is selected
    When user clicks on Apply button
    Then verify Buy it again Products displayed

    When user click on Beverages pill
    When user click on refine button in Buy it again page
    Then verify refine window is displayed
    When user click 'Frequently Purchased' option from Sort By category
    Then verify 'Frequently Purchased' option has been selected
    When user click 'In-Store' option from Filter By category
    Then verify 'In-Store' option has been selected
    Then user scroll down through the past months of the page
    When user click all the past month purchases and verify it is selected
    When user clicks on Apply button
    Then verify Buy it again Products displayed
    When user click on refine button in Buy it again page
    Then verify refine window is displayed
    When user click 'Frequently Purchased' option from Sort By category
    Then verify 'Frequently Purchased' option has been selected
    When user click 'Online' option from Filter By category
    Then verify 'Online' option has been selected
    When user click on 'Last Order' option from Purchase Date
    Then verify 'Last Order' option has been selected
    Then user scroll down through the past months of the page
    When user click all the past month purchases and verify it is selected
    When user clicks on Apply button
    Then verify Buy it again Products displayed
    And user scroll horizontally through pills in BIA Page

    When user click on Wine, Bear & Spirits pill
    When user click on refine button in Buy it again page
    Then verify refine window is displayed
    When user click 'Frequently Purchased' option from Sort By category
    Then verify 'Frequently Purchased' option has been selected
    When user click 'In-Store' option from Filter By category
    Then verify 'In-Store' option has been selected
    Then user scroll down through the past months of the page
    When user click all the past month purchases and verify it is selected
    When user clicks on Apply button
    Then verify Buy it again Products displayed
    When user click on refine button in Buy it again page
    Then verify refine window is displayed
    When user click 'Frequently Purchased' option from Sort By category
    Then verify 'Frequently Purchased' option has been selected
    When user click 'Online' option from Filter By category
    Then verify 'Online' option has been selected
    When user click on 'Last Order' option from Purchase Date
    Then verify 'Last Order' option has been selected
    Then user scroll down through the past months of the page
    When user click all the past month purchases and verify it is selected
    When user clicks on Apply button
    Then verify Buy it again Products displayed

    When user click on Cookies, Snacks & Candy pill
    When user click on refine button in Buy it again page
    Then verify refine window is displayed
    When user click 'Frequently Purchased' option from Sort By category
    Then verify 'Frequently Purchased' option has been selected
    When user click 'In-Store' option from Filter By category
    Then verify 'In-Store' option has been selected
    Then user scroll down through the past months of the page
    When user click all the past month purchases and verify it is selected
    When user clicks on Apply button
    Then verify Buy it again Products displayed
    When user click on refine button in Buy it again page
    Then verify refine window is displayed
    When user click 'Frequently Purchased' option from Sort By category
    Then verify 'Frequently Purchased' option has been selected
    When user click 'Online' option from Filter By category
    Then verify 'Online' option has been selected
    When user click on 'Last Order' option from Purchase Date
    Then verify 'Last Order' option has been selected
    Then user scroll down through the past months of the page
    When user click all the past month purchases and verify it is selected
    When user clicks on Apply button

    When user click on Fruits & Vegetables pill
    When user click on refine button in Buy it again page
    Then verify refine window is displayed
    When user click 'Frequently Purchased' option from Sort By category
    Then verify 'Frequently Purchased' option has been selected
    When user click 'In-Store' option from Filter By category
    Then verify 'In-Store' option has been selected
    Then user scroll down through the past months of the page
    When user click all the past month purchases and verify it is selected
    When user clicks on Apply button
    Then verify Buy it again Products displayed
    When user click on refine button in Buy it again page
    Then verify refine window is displayed
    When user click 'Frequently Purchased' option from Sort By category
    Then verify 'Frequently Purchased' option has been selected
    When user click 'Online' option from Filter By category
    Then verify 'Online' option has been selected
    When user click on 'Last Order' option from Purchase Date
    Then verify 'Last Order' option has been selected
    Then user scroll down through the past months of the page
    When user click all the past month purchases and verify it is selected
    When user clicks on Apply button
    Then verify Buy it again Products displayed

    When user click on Frozen Foods pill
    When user click on refine button in Buy it again page
    Then verify refine window is displayed
    When user click 'Frequently Purchased' option from Sort By category
    Then verify 'Frequently Purchased' option has been selected
    When user click 'In-Store' option from Filter By category
    Then verify 'In-Store' option has been selected
    Then user scroll down through the past months of the page
    When user click all the past month purchases and verify it is selected
    When user clicks on Apply button
    Then verify Buy it again Products displayed
    When user click on refine button in Buy it again page
    Then verify refine window is displayed
    When user click 'Frequently Purchased' option from Sort By category
    Then verify 'Frequently Purchased' option has been selected
    When user click 'Online' option from Filter By category
    Then verify 'Online' option has been selected
    When user click on 'Last Order' option from Purchase Date
    Then verify 'Last Order' option has been selected
    Then user scroll down through the past months of the page
    When user click all the past month purchases and verify it is selected
    When user clicks on Apply button
    Then verify Buy it again Products displayed

  @regression
  Scenario: s a user with past purchases, I should be able to validate product availability by navigate through all the pills with Sort by Purchase Date and choose different Filter By options
    When user click on refine button in Buy it again page
    Then verify refine window is displayed
    When user click on 'Purchased Date' option from Sort By category
    Then verify 'Purchased Date' option has been selected
    When user click 'In-Store' option from Filter By category
    Then verify 'In-Store' option has been selected
    Then user scroll down through the past months of the page
    When user click all the past month purchases and verify it is selected
    When user clicks on Apply button
    Then verify Buy it again Products displayed

    When user click on Dairy, Eggs & Cheese pill
    When user click on refine button in Buy it again page
    Then verify refine window is displayed
    When user click on 'Purchased Date' option from Sort By category
    Then verify 'Purchased Date' option has been selected
    When user click 'In-Store' option from Filter By category
    Then verify 'In-Store' option has been selected
    Then user scroll down through the past months of the page
    When user click all the past month purchases and verify it is selected
    When user clicks on Apply button
    Then verify Buy it again Products displayed
    When user click on refine button in Buy it again page
    Then verify refine window is displayed
    When user click on 'Purchased Date' option from Sort By category
    Then verify 'Purchased Date' option has been selected
    When user click 'Online' option from Filter By category
    Then verify 'Online' option has been selected
    When user click on 'Last Order' option from Purchase Date
    Then verify 'Last Order' option has been selected
    Then user scroll down through the past months of the page
    When user click all the past month purchases and verify it is selected
    When user clicks on Apply button
    Then verify Buy it again Products displayed

    When user click on Beverages pill
    When user click on refine button in Buy it again page
    Then verify refine window is displayed
    When user click on 'Purchased Date' option from Sort By category
    Then verify 'Purchased Date' option has been selected
    When user click 'In-Store' option from Filter By category
    Then verify 'In-Store' option has been selected
    Then user scroll down through the past months of the page
    When user click all the past month purchases and verify it is selected
    When user clicks on Apply button
    Then verify Buy it again Products displayed
    When user click on refine button in Buy it again page
    Then verify refine window is displayed
    When user click on 'Purchased Date' option from Sort By category
    Then verify 'Purchased Date' option has been selected
    When user click 'Online' option from Filter By category
    Then verify 'Online' option has been selected
    When user click on 'Last Order' option from Purchase Date
    Then verify 'Last Order' option has been selected
    Then user scroll down through the past months of the page
    When user click all the past month purchases and verify it is selected
    When user clicks on Apply button
    Then verify Buy it again Products displayed
    And user scroll horizontally through pills in BIA Page

    When user click on Wine, Bear & Spirits pill
    When user click on refine button in Buy it again page
    Then verify refine window is displayed
    When user click on 'Purchased Date' option from Sort By category
    Then verify 'Purchased Date' option has been selected
    When user click 'In-Store' option from Filter By category
    Then verify 'In-Store' option has been selected
    Then user scroll down through the past months of the page
    When user click all the past month purchases and verify it is selected
    When user clicks on Apply button
    Then verify Buy it again Products displayed
    When user click on refine button in Buy it again page
    Then verify refine window is displayed
    When user click on 'Purchased Date' option from Sort By category
    Then verify 'Purchased Date' option has been selected
    When user click 'Online' option from Filter By category
    Then verify 'Online' option has been selected
    When user click on 'Last Order' option from Purchase Date
    Then verify 'Last Order' option has been selected
    Then user scroll down through the past months of the page
    When user click all the past month purchases and verify it is selected
    When user clicks on Apply button
    Then verify Buy it again Products displayed

    When user click on Cookies, Snacks & Candy pill
    When user click on refine button in Buy it again page
    Then verify refine window is displayed
    When user click on 'Purchased Date' option from Sort By category
    Then verify 'Purchased Date' option has been selected
    When user click 'In-Store' option from Filter By category
    Then verify 'In-Store' option has been selected
    Then user scroll down through the past months of the page
    When user click all the past month purchases and verify it is selected
    When user clicks on Apply button
    Then verify Buy it again Products displayed
    When user click on refine button in Buy it again page
    Then verify refine window is displayed
    When user click on 'Purchased Date' option from Sort By category
    Then verify 'Purchased Date' option has been selected
    When user click 'Online' option from Filter By category
    Then verify 'Online' option has been selected
    When user click on 'Last Order' option from Purchase Date
    Then verify 'Last Order' option has been selected
    Then user scroll down through the past months of the page
    When user click all the past month purchases and verify it is selected
    When user clicks on Apply button

    When user click on Fruits & Vegetables pill
    When user click on refine button in Buy it again page
    Then verify refine window is displayed
    When user click on 'Purchased Date' option from Sort By category
    Then verify 'Purchased Date' option has been selected
    When user click 'In-Store' option from Filter By category
    Then verify 'In-Store' option has been selected
    Then user scroll down through the past months of the page
    When user click all the past month purchases and verify it is selected
    When user clicks on Apply button
    Then verify Buy it again Products displayed
    When user click on refine button in Buy it again page
    Then verify refine window is displayed
    When user click on 'Purchased Date' option from Sort By category
    Then verify 'Purchased Date' option has been selected
    When user click 'Online' option from Filter By category
    Then verify 'Online' option has been selected
    When user click on 'Last Order' option from Purchase Date
    Then verify 'Last Order' option has been selected
    Then user scroll down through the past months of the page
    When user click all the past month purchases and verify it is selected
    When user clicks on Apply button
    Then verify Buy it again Products displayed

    When user click on Frozen Foods pill
    When user click on refine button in Buy it again page
    Then verify refine window is displayed
    When user click on 'Purchased Date' option from Sort By category
    Then verify 'Purchased Date' option has been selected
    When user click 'In-Store' option from Filter By category
    Then verify 'In-Store' option has been selected
    Then user scroll down through the past months of the page
    When user click all the past month purchases and verify it is selected
    When user clicks on Apply button
    Then verify Buy it again Products displayed
    When user click on refine button in Buy it again page
    Then verify refine window is displayed
    When user click on 'Purchased Date' option from Sort By category
    Then verify 'Purchased Date' option has been selected
    When user click 'Online' option from Filter By category
    Then verify 'Online' option has been selected
    When user click on 'Last Order' option from Purchase Date
    Then verify 'Last Order' option has been selected
    Then user scroll down through the past months of the page
    When user click all the past month purchases and verify it is selected
    When user clicks on Apply button
    Then verify Buy it again Products displayed