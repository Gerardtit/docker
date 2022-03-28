Feature: Landing Screen Validation

  Background:
    When Launch the MFA app

  @regression
  Scenario: Verify Email/Mobile Text box On Landing Screen Without Scrolling
    And verify let get started screen is displayed
  #  Then Verify Lets get started Text is visible without Scrolling
    Then verify Mobile Text box is displayed without Scrolling
    Then verify Email Text box is displayed without Scrolling
    Then Verify Terms of Use text is visible without Scrolling
    Then Verify Privacy Policy text is visible without Scrolling

  @MEMM-313 @miniRegression  #UMA Automation  - Verify No App Crash in Browse Tab when Store Change
  Scenario:  verify app crash by tapping See All on Browse Category
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94611" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    And scroll down upto browse category
    And click see all in browse category
    Then verify Browse page is displayed
    And click on home tab
    And Scroll Up To Shopping Mode Arrow

  @MEMM-313  @miniRegression #UMA Automation  - Verify No App Crash in Browse Tab when Store Change
  Scenario:  verify app crash by selecting different ZIP Address
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94611" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    And scroll down upto browse category
    And click see all in browse category
    Then verify Browse page is displayed
    And click on home tab
    And Scroll Up To Shopping Mode Arrow
    When click on shopping mode down arrow
    When user enters "94566" in zipcode page
    And change the pickup store
    And user click start shopping button on Sign In page
    And scroll down upto browse category
    And click see all in browse category
    And click on home tab
    And Scroll Up To Shopping Mode Arrow

  @MOLN-4139
  Scenario: Verify Food lot banner visible on home page for targeted stores
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "95125" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    And verify food lot banner is displayed

  @MOLN-4177
  Scenario: Verify Food lot drawer screen for customer
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "95125" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    And verify food lot banner is displayed
    When user clicks on food lot banner
    Then verify customer details drawer screen appears
    And verify food lot logo on customer details drawer screen
    And verify food lot header on customer details drawer screen
    And verify first and last name fields appears and enter its values
    And verify Email field is auto-filled and non editable
    And verify Confirm CTA button is enabled
    When user clicks on Confirm CTA button on customer detail drawer screen
    Then Then Friday food truck landing page appears
    And verify store address with zipcode "95125" is displayed on food lot landing page

  @MOLN-4178
  Scenario: Verify Food lot drawer screen for customer
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "95125" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    And verify food lot banner is displayed
    When user clicks on food lot banner
    Then verify customer details drawer screen appears
    And verify food lot logo on customer details drawer screen
    And verify food lot header on customer details drawer screen
    And verify first and last name fields appears and enter its values
    And verify Email field is auto-filled and non editable
    And verify Confirm CTA button is enabled
    When user clicks on Confirm CTA button on customer detail drawer screen
    Then Then Friday food truck landing page appears
    And verify user can see subscribe cta link
    When user clicks on Subscribe CTA link
    Then verify user should be subscribed to receive vendor menus
    And verify add to cart cta and product description appears


  @MOLN-4312
  Scenario: Verify Food Lot E2E
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "95125" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    And verify food lot banner is displayed
    When user clicks on food lot banner
    Then verify customer details drawer screen appears
    And verify food lot logo on customer details drawer screen
    And verify food lot header on customer details drawer screen
    And verify first and last name fields appears and enter its values
    And verify Email field is auto-filled and non editable
    And verify Confirm CTA button is enabled
    When user clicks on Confirm CTA button on customer detail drawer screen
    Then Then Friday food truck landing page appears
    And verify add to cart cta and product description appears
    When user clicks add to cart CTA on foodlot landing page
    Then verify predrawer screen appears
    And verify quantity stepper, special instruction note and preorder add to cart CTA
    When user clicks preorder add to cart CTA link
    Then verify order now drawer screen appears
    When user clicks order now CTA link
    Then Review Order page appears

  @MOLN-4332
  Scenario: Verify Food Lot E2E
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "95125" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    And verify food lot banner is displayed
    When user clicks on food lot banner
    Then verify customer details drawer screen appears
    And verify food lot logo on customer details drawer screen
    And verify food lot header on customer details drawer screen
    And verify first and last name fields appears and enter its values
    And verify Email field is auto-filled and non editable
    And verify Confirm CTA button is enabled
    When user clicks on Confirm CTA button on customer detail drawer screen
    Then Then Friday food truck landing page appears
    And verify add to cart cta and product description appears
    When user clicks add to cart CTA on foodlot landing page
    Then verify predrawer screen appears
    And verify quantity stepper, special instruction note and preorder add to cart CTA
    When user clicks preorder add to cart CTA link
    Then verify order now drawer screen appears
    When user clicks order now CTA link
    Then Review Order page appears
    And verify quantity stepper, Tip section, Add section, Pickup Time, Subtotal, all fees, order total, add a coupon, another item cta and Checkout cta
    And verify once tip and pickup time is selected only user can checkout
    Then verify customer info screen appears
    And verify all fields are working as expected on customer info screen
    When user provide customer phone number and clicks on checkout
    Then verify user lands on payment screen
    And user enters "4242424242424242" as credit card number in foodlot
    And user enters "09/23" as card expiration month year in foodlot
    And user enters "visa" as name on credit card in foodlot
    And user enters CVC as "123" appears on card
    And user enters "94566" as billing zip code in foodlot
    When user clicks pay button
    #Then verify order no, order details section, store location is appearing in food lot confirmation screen

  @MOLN-4452
  Scenario: Verify Food Lot E2E
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "95125" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    And verify food lot banner is displayed
    When user clicks on food lot banner
    Then verify customer details drawer screen appears
    And verify food lot logo on customer details drawer screen
    And verify food lot header on customer details drawer screen
    And verify first and last name fields appears and enter its values
    And verify Email field is auto-filled and non editable
    And verify Confirm CTA button is enabled
    When user clicks on Confirm CTA button on customer detail drawer screen
    Then Then Friday food truck landing page appears
    And verify add to cart cta and product description appears
    When user clicks add to cart CTA on foodlot landing page
    Then verify predrawer screen appears
    And verify quantity stepper, special instruction note and preorder add to cart CTA
    When user clicks preorder add to cart CTA link
    Then verify order now drawer screen appears
    When user clicks order now CTA link
    Then Review Order page appears
    And verify quantity stepper, Tip section, Add section, Pickup Time, Subtotal, all fees, order total, add a coupon, another item cta and Checkout cta
    And verify once tip and pickup time is selected only user can checkout
    Then verify customer info screen appears
    And verify all fields are working as expected on customer info screen
    When user provide customer phone number and clicks on checkout
    Then verify user lands on payment screen
    And user enters "4242424242424242" as credit card number in foodlot
    And user enters "09/23" as card expiration month year in foodlot
    And user enters "visa" as name on credit card in foodlot
    And user enters CVC as "123" appears on card
    And user enters "94566" as billing zip code in foodlot
    When user clicks pay button
    Then verify order confirmation screen appears
    When user clicks back button on order confirmation page
    Then verify food lot banner is displayed

  @MOLN-4451
  Scenario: Verify Title of Account Page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "95125" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user click hamburger
    Then User verify Account option in list
    When User click on Account option
    Then Verify header title of the page is "Account"