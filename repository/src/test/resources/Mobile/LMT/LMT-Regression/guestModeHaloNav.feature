@GuestModeHaloNav
Feature: Guest Mode Login and HaloNav interactions

  Scenario:Verify the HaloNav interactions through HaloNav
    Then user landed on onboarding screen
    Then user validates Guest mode CTA in Mobile workflow
    When user clicks on CTA continue as guest
    Then zipcode page is displayed
    When user relaunch the application
    Then user landed on onboarding screen
    When user clicks on Email workflow
    Then user validates Guest mode CTA in Email workflow
    When user clicks on CTA continue as guest
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks on "Rewards"
    Then user lands on sign in to continue screen
    When user clicks on "Deals"
    Then user lands on sign in to continue screen
    When user clicks on "FreshPass"
    Then user lands on sign in to continue screen

  @StaticBottomNav
  Scenario: Verify Static HaloNav and Bottom Nav interactions
    Then user landed on onboarding screen
    Then user validates Guest mode CTA in Mobile workflow
    When user clicks on CTA continue as guest
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    Then user validates "Rewards", "Pharmacy", "Weekly Ad", "Deals", and "FreshPass"
    When user clicks on Shop page and navigates to Past Purchases
    Then user lands on sign in to continue screen
    When user clicks on Deals bottom navigation
    Then user lands on sign in to continue screen
    When user clicks on My List bottom navigation
    Then user lands on sign in to continue screen
    When user clicks on Member tab bottom navigation
    Then user lands on sign in to continue screen

      #YRM-443
  @AjTR
  Scenario: Verify when in Guest Mode, prompt to Sign In when actions relating to Clip Coupons are taken
    Then user landed on onboarding screen
    Then user validates Guest mode CTA in Mobile workflow
    When user clicks on CTA continue as guest
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks search bar on home page
    And user types "milk" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    Then user lands on sign in to continue screen
    When user clicks on the product and clicks add to cart

  @YRM-442 @YRM-459 @Signinonclickingcart @Validatesigninpageandloginpageforguestmode
  Scenario: Verify user is prompted to signin on clicking then cart icon from the Contact us in hamburger menu.
    Then user landed on onboarding screen
    When user clicks on CTA continue as guest
    When user enters "zipcode" in zipcode page
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks on hamburger menu
    When user clicks Contact Us on menu page
    When click on My Cart Icon
    Then user lands on sign in to continue screen
    And  "Add to cart" text is displayed on the screen
    And "Plan an in-store trip or schedule your order for delivery or pickup." text is displayed on the screen
    And  "View and clip deals" text is displayed on the screen
    And "Create a list and clip coupons all in one place." text is displayed on the screen
    And  "Redeem rewards" text is displayed on the screen
    And "Redeem your rewards for discounts on groceries and gas... and more" text is displayed on the screen
    And user clicks sign in on sign in page
    Then user landed on onboarding screen

   #@Validatesigninpageandloginpageforguestmode
     #  Scenario: Validate signin, CLip deals and rewards and navigation to login page on sigin for guest mode
      # Then user landed on onboarding screen
     #  When user clicks on CTA continue as guest
     #  When user enters "zipcode" in zipcode page
      # When user click delivery option
     #  And user click start shopping button on Sign In page
      # Then user is logged in to the app for Existing user
       #Then verify MFA home screen is displayed
      # When click on My Cart Icon
      # Then user lands on sign in to continue screen
       #And  "Add to cart" text is displayed on the screen
      # And "Plan an in-store trip or schedule your order for delivery or pickup." text is displayed on the screen
      # And  "View and clip deals" text is displayed on the screen
      # And "Create a list and clip coupons all in one place." text is displayed on the screen
      # And  "Redeem rewards" text is displayed on the screen
      # And "Redeem your rewards for discounts on groceries and gas... and more" text is displayed on the screen
      # And user clicks sign in on sign in page
      # Then user landed on onboarding screen



  @StaticBottomNav
  Scenario: Verify the interaction of reserve a time in Delivery fulfillment type
    Then user landed on onboarding screen
    Then user validates Guest mode CTA in Mobile workflow
    When user clicks on CTA continue as guest
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then Verify Start shopping button on Sign In page
    When user click delivery option
    And user click start shopping button on After Signup
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks on Reserve a time on Home page
    Then user lands on sign in to continue screen

  @SignInHamburgerMenu
  Scenario: Verify the sign in button on the Hamburger menu
    Then user landed on onboarding screen
    Then user validates Guest mode CTA in Mobile workflow
    When user clicks on CTA continue as guest
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks on Hamburger menu on Home page
    When user clicks on Sign in button in Hamburger menu
    Then user landed on onboarding screen


  @StaticBottomNav
  Scenario: Verify Static HaloNav and Bottom Nav interactions
    Then user landed on onboarding screen
    Then user validates Guest mode CTA in Mobile workflow
    When user clicks on CTA continue as guest
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    Then user validates "Rewards", "Pharmacy", "Weekly Ad", "Deals", and "FreshPass"
    When user clicks on Shop page and navigates to Past Purchases
    Then user lands on sign in to continue screen
    When user clicks on Deals bottom navigation
    Then user lands on sign in to continue screen
    When user clicks on My List bottom navigation
    Then user lands on sign in to continue screen
    When user clicks on Member tab bottom navigation
    Then user lands on sign in to continue screen

  @MRR-1265
  Scenario:verify the sign prompt when user interacts with cart
    Then user landed on onboarding screen
    Then user validates Guest mode CTA in Mobile workflow
    When user clicks on CTA continue as guest
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    When user click on shopping cart button on homepage
    Then verify sign in page
    Then user close sign in page
    When user clicks on Shop page
    Then user click on shopping cart button on homepage
    Then verify sign in page
    Then user close sign in page