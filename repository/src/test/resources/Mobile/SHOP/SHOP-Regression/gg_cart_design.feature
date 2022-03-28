Feature:  cart design

  Background:
    When Launch the MFA app


  @smoke @regression
  Scenario: As a user i navigate to cart page with a in store mode
    When user set up in store mode on home page
    And user types "milk" on search bar and click search on home page and enter first milk
    When user handle the toggle to access search page
    When user add first milk on search page
    When user click on shopping cart button on homepage
    When verify checkout is not enabled
    When user incremental first milk to be thirty dollar in cart page
    Then verify change shopping method is displayed
    Then verify pay in store is displayed
    When user tabs on change shopping method
    And user verify zip code is displayed
    When user click on zip code right arrow button
    When user click on start shopping button
    Then verify pay in store is displayed
    When user tabs on Pay in store
    Then Verify wallet tittle

  @smoke @regression
  Scenario: user verify checkout with both dug and delivery mode
    When user setup pick up  mode on home page
    And user types "milk" on search bar and click search on home page and enter first milk
    When user handle the toggle to access search page
    When user add first milk on search page
    When user click on shopping cart button on homepage
    When verify checkout is not enabled
    When user add first milk to be thirty dollar on cart page
    When user verify checkout button is enabled
    When user remove milk from cart page and back to home page
    When user click on cancel on search page
    When user setup delivery mode on homepage
    And user types "milk" on search bar and click search on home page and enter first milk
    When user add first milk on search page
    When user click on shopping cart button on homepage
    When verify checkout is not enabled
    When user add first milk to be thirty dollar on cart page
    When user verify checkout button is enabled


  @smoke @regression
  Scenario: take users to cart after changing shopping method verification
    When user set up in store mode on home page
    And user types "milk" on search bar and click search on home page and enter first milk
    When user handle the toggle to access search page
    When user add first milk on search page
    When user click on shopping cart button on homepage
    When user tabs on change shopping method
    When user click on zip code right arrow button
    When user click on pick up option
    When user click on start shopping button
    When user verify cart page is displayed

  @regression1
  Scenario: user verifies cart individual level substitution
    When click on NewSignup for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    When user setup pick up  mode on home page
    And user click aisles tab on home page
    When user clicks item "Bread & Bakery" on aisle list
    When user clicks item "Bagels & Muffins" on aisle list
    When user clicks item "Bagels" on aisle list
    Then verify item is found from aisle
    When user clicks "1" item add button on first item
    And user buffers "1" product name
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    When user clicks "1" item Item Preferences text on page
    And scroll down the screen
    Then note to personal shopper search box should be displayed
    When enter "Please get the product" text in search box
    Then verify "Please get the product" note is added in the Preferences search box
    And scroll down the screen
    Then verify "Same Brand, Different Size" radio button selected
    Then verify Save button is enabled
    And scroll down the screen
    Then verify Cancel button is enabled


  @regression2
  Scenario: user verifies empty cart UI InStore
    When  Launch the MFA app
    And click on existing user signin for OTP
    Then verify MFA home screen is displayed
    When user set up in store mode on home page
    When user clicks shopping cart button on home page
    And user empty shopping cart
    Then verify in-store Header on the shopping cart page
    Then verify Done button is displayed in cart page
    Then shopping cart empty page is displayed
    Then estimation total information icon is displayed
    Then verify Pay In-Store is disabled for Empty Shopping cart
    Then verify Delivery or PickUp is enabled for Empty Shopping cart


  @MEMM-150 #reference to MEMM-150 story
  Scenario: Verify Clipped Deals Banner is not showing on My Cart
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "instore" in zipcode page
    Then select order type page is displayed
    When user clicks instore on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When click on deals tab
    And click On Button clip
    Then click on My Cart Icon
    Then verify Clipped Deals Banner is not showing on My Cart

  @MEMM-312 #reference to MEMM-312 user story
  Scenario: Verify Store Selected in DUG Fulfillment
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "instore" in zipcode page
    Then select order type page is displayed
    When user clicks instore on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks search bar on home page
    And user types "brade" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then click on delivery/pickup button on mycart
    Then zipcode page is displayed
    When user enters "instore" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then Verify First store is selected and Start Shopping is enabled











