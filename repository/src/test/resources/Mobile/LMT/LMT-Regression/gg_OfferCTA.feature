Feature: verify COA flow at checkout


  Scenario:validate clipdeals from deal page

    When sign in to the application
    And user clicks on deals tab
    When click on clip deal if present
    Then validate Added text is displayed on dealspage


  Scenario:validate clipdeals from homepage

    When sign in to the application
    And user clicks on weekly ad coupons at homepage
    When click on clip deal if present
    Then validate Added text is displayed on dealspage

  @123es
  Scenario:validate clipdeals text on deals page

    When sign in to the application
    And user clicks on deals tab
    When click on clip deal if present
    Then validate Added text is displayed


  Scenario: user should be able to easily search for a store for my pick-up order
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    #Then user selects the In-store on the list
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    Then user search product "MILK"
    Then user clicks Add button of first item
    And add quantity to selected item
    When user clicks shopping cart button on home page
    And user clicks checkout button on cart page
    When  clicks "Order Info" text on page
    Then Select and save open window
    When CVV number is refreshed with choose date
    When user enters "111" as CVV and clicks next
    Then placeorder is clicked
    Then At OrderConfirmationPage,OrderLink is displayed
    And User verify CTA on CVV screen will be active after user has entered 3 digits


  Scenario: Member Tab and Deals should have Update to "for U"
    When user clicks on home page Tab
    And user clicks on Deals page
    And user is landed on Deals page
    And user clicks on for U page
    Then user is landed on for U page



