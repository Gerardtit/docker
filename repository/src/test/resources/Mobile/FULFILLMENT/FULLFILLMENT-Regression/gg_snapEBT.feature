@snapEBT @regression
Feature: User verify SNAP and Non SNAP items

  Background:
    When Launch the MFA app


  Scenario: [iOS][Android] Cart CTA for SNAP 2 - Automation
    And click on SNAP2 Signup Api for OTP
    Then user handle landing scenario
    Then verify MFA home screen is displayed
    When user clicks delivery option on home page
    Then zipcode page is displayed
    When user enters "94566" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    When user clicks second store on the list
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    And click on settings icon
    And scroll down and click on developer settings
    When turn "ON" snapV2 feature
    When user clicks search bar on home page
    And user types "milk" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then verify Checkout with EBT card text is displayed on the screen


  Scenario: [iOS][Android] logic for known SNAP users - Automation
    And click on SNAP Signup Api for OTP
    Then user handle landing scenario
    Then verify MFA home screen is displayed
    When user clicks delivery option on home page
    Then zipcode page is displayed
    When user enters "94566" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    When user clicks second store on the list
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    And click on settings icon
    And scroll down and click on developer settings
    When turn "ON" snapV2 feature
    And user clicks shopping cart button on home page
    Then verify Checkout with EBT card text is displayed on the screen

  @diff   @regression
  Scenario: [iOS][Android] Sheet for SNAP webview - Automation
    And click on SNAP Signup Api for OTP
    Then user handle landing scenario
    Then verify MFA home screen is displayed
    When user clicks delivery option on home page
    Then zipcode page is displayed
    When user enters "94566" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    When user clicks second store on the list
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    And click on settings icon
    And scroll down and click on developer settings
    When turn "ON" snapV2 feature
    When user clicks search bar on home page
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then verify Checkout with EBT card text is displayed on the screen
    And user taps on the Checkout with EBT link
    Then verify a sheet opens up and close the sheet
  #  When user clicks on the close CTA
    Then shopping cart page is displayed

  @regression
  Scenario: User remove Non SNAP item by selecting view cart on cart page and complete transaction
    When click on NewSignup for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    And user click aisles tab on home page
    When user clicks item "Bread & Bakery" on aisle list
    When user clicks item "Bagels & Muffins" on aisle list
    When user clicks item "Bagels" on aisle list
    Then verify item is found from aisle
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "10" number of items for all item in shopping cart
    And user click check mark on shopping cart page
    And user clicks back button
    And user clicks item "Bagels & Muffins" on aisle list
    And scroll down to see "Wine, Beer & Spirits"
    And user clicks item "Beer & Spiked Seltzers" on aisle list
    And user clicks item "Craft & Microbrewery Beer" on aisle list
    Then verify item is found from aisle
    And user captures name of product adding in cart
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    And scroll down the screen
    And user change date picker to enable save
    And user click save button on orderInfo window
    Then checkout page is displayed
    When User see Snap option for payment
    And user click on Snap option for payment
    Then user should be able to see popup to remove non snap items
    When user clicks on View Cart in the popup
    Then verify Non-SNAP items screen is opened
    When user remove items from cart
    When user clicks contact on checkout page
    Then user fills contact details
    And place order button is clickable and click place order
    Then order confirmation page is displayed

  @regression
  Scenario: User is able to see split on estimated total when placed transaction with SNAP and Non Snap items.
    When click on NewSignup for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    And user click aisles tab on home page
    When user clicks item "Bread & Bakery" on aisle list
    When user clicks item "Bagels & Muffins" on aisle list
    When user clicks item "Bagels" on aisle list
    Then verify item is found from aisle
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "10" number of items for all item in shopping cart
    And user click check mark on shopping cart page
    And user clicks back button
    And user clicks item "Bagels & Muffins" on aisle list
    And scroll down to see "Wine, Beer & Spirits"
    And user clicks item "Beer & Spiked Seltzers" on aisle list
    And user clicks item "Craft & Microbrewery Beer" on aisle list
    Then verify item is found from aisle
    And user captures name of product adding in cart
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    And scroll down the screen
    And user change date picker to enable save
    And user click save button on orderInfo window
    Then checkout page is displayed
    When user clicks payment on checkout pagex
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94566" as billing zip code
    Then payment CVV window is displayed
    When user enters "111" as CVV and clicks next
    Then checkout page is displayed
    When user clicks contact on checkout page
    Then user fills contact details
    And user see salesTax tool tip
    And user see Estimated total tool tip
    And place order button is clickable and click place order
    Then user see salesTax tool tip
    Then user see Estimated total tool tip
    When user close application and relaunch
    And click yes if you love Safeway app





