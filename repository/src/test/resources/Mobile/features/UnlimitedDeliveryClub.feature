Feature: Verify user land on UDC Annual Plan and Monthly plan page with CTA of Payment, I agree checkbox, FAQ and Terms & Conditions

  Background: setup user on SignIn Page
    Given startup page is displayed
    Then zipcode page is displayed
    When user clicks Sign in button on zipcode page
    Then sign in page is displayed
    When user enters "email" in username field on Sign In page
    And user enters "password" in password field on Sign In page
    And user clicks sign in on sign in page
    When user clicks continue for CacheText

  @udcLandingPage
  Scenario: Verify user land on Unlimited delivery club landing page with CTA
    When user clicks menu button on home page
    When user clicks Unlimited Delivery Club on menu page
    Then "Unlimited Delivery Club" page is displayed
    When user clicks Annual Plan on UDC window
    Then "Annual Plan" page is displayed
    And user press back button
    When user clicks Monthly Plan on UDC window
    Then "Monthly Plan" page is displayed
    And user press back button
    When user clicks FAQ on UDC page
    Then "FAQ" page is displayed
    And user press back button
    When user clicks Terms and Conditions on UDC page
    Then "Terms and Conditions" page is displayed
    And user press back button

  @udcAnnualPlan
  Scenario: click action on Annual Plan
    When user clicks menu button on home page
    When user clicks Unlimited Delivery Club on menu page
    Then "Unlimited Delivery Club" page is displayed
    When user clicks Annual Plan on UDC window
    Then "Annual Plan" page is displayed
    When user clicks Payment on "Annual Plan" page
    Then "Payment" page is displayed
    And user enters name as "Name" appears on card
    And user enters card number as "Card Number" appears on card
    And user enters month and year as "Expiration month and year" appears on card
    And user enters "zipcode" as Billing Zipcode
    Then "CVV" text is displayed on the screen
    When user enters "111" as CVV and clicks next
    Then "Annual Plan" page is displayed
    When user clicks agree checkbox

    And user clicks FAQ on UDC page
    Then "FAQ" page is displayed
    And user press back button
    When user clicks Terms and Conditions on UDC page
    Then "Terms and Conditions" page is displayed
    And user press back button

  @udcMonthlyPlan
  Scenario: click action on Monthly Plan
    When user clicks menu button on home page
    When user clicks Unlimited Delivery Club on menu page
    Then "Unlimited Delivery Club" page is displayed
    When user clicks Monthly Plan on UDC window
    Then "Monthly Plan" page is displayed
    When user clicks Payment on "Monthly Plan" page
    Then "Payment" page is displayed
    And user enters name as "Name" appears on card
    And user enters card number as "Card Number" appears on card
    And user enters month and year as "Expiration month and year" appears on card
    And user enters "zipcode" as Billing Zipcode
    Then "CVV" text is displayed on the screen
    When user enters "111" as CVV and clicks next
    Then "Monthly Plan" page is displayed
    When user clicks agree checkbox

    And user clicks FAQ on UDC page
    Then "FAQ" page is displayed
    And user press back button
    When user clicks Terms and Conditions on UDC page
    Then "Terms and Conditions" page is displayed
    And user press back button
    And user press back button
    And user press back button
    When user click sign out button on menu page
    Then confirm sign out page is displayed
    When user click ok button to confirm sign out


  @udcAnnualPlanSubscription
  Scenario: click action on Annual Plan
    When user clicks menu button on home page
    When user clicks Unlimited Delivery Club on menu page
    Then "Unlimited Delivery Club" page is displayed
    When user clicks Annual Plan on UDC window
    Then "Annual Plan" page is displayed
    When user clicks Payment on "Annual Plan" page
    Then "Payment" page is displayed
    And user enters name as "Name" appears on card
    And user enters card number as "Card Number" appears on card
    And user enters month and year as "Expiration month and year" appears on card
    And user enters "zipcode" as Billing Zipcode
    Then "CVV" text is displayed on the screen
    When user enters "111" as CVV and clicks next
    Then "Annual Plan" page is displayed
    When user clicks agree checkbox
    And user clicks FAQ on UDC page
    Then "FAQ" page is displayed
    And user press back button
    When user clicks Terms and Conditions on UDC page
    Then "Terms and Conditions" page is displayed
    And user press back button
    When user clicks Start Subscription button
    Then Confirmation page displayed with All Set message
    Then verify Current Subscription Plan and Current Payment Method is displayed
    When user clicks Change button on Current Subscription Plan
    Then "Monthly Plan" page is displayed
    Then verify Switch to Monthly Plan is displayed on the page
    And user press back button
    When user clicks update button on Current Payment Method
    Then "Annual Plan" page is displayed
    Then verify Update Payment is displayed on the page
    And user press back button
    When user clicks on Cancel Subscription
    Then "Cancel Plan" page is displayed
    And user click on the first option
    When user clicks confirm cancellation
    Then Subscription Plan Details window is displayed
    And user press back button
    And user press back button
    When user click sign out button on menu page
    Then confirm sign out page is displayed
    When user click ok button to confirm sign out

  @udcMonthlyPlanSubscription
  Scenario: click action on Monthly Plan
    When user clicks menu button on home page
    When user clicks Unlimited Delivery Club on menu page
    Then "Unlimited Delivery Club" page is displayed
    When user clicks Monthly Plan on UDC window
    Then "Monthly Plan" page is displayed
    When user clicks Payment on "Monthly Plan" page
    Then "Payment" page is displayed
    And user enters name as "Name" appears on card
    And user enters card number as "Card Number" appears on card
    And user enters month and year as "Expiration month and year" appears on card
    And user enters "zipcode" as Billing Zipcode
    Then "CVV" text is displayed on the screen
    When user enters "111" as CVV and clicks next
    Then "Monthly Plan" page is displayed
    When user clicks agree checkbox

    And user clicks FAQ on UDC page
    Then "FAQ" page is displayed
    And user press back button
    When user clicks Terms and Conditions on UDC page
    Then "Terms and Conditions" page is displayed
    And user press back button
    When user clicks Start Subscription button
    Then Confirmation page displayed with All Set message
    Then verify Current Subscription Plan and Current Payment Method is displayed
    When user clicks Change button on Current Subscription Plan
    Then "Annual Plan" page is displayed
    Then verify Switch to Annual Plan is displayed on the page
    And user press back button
    When user clicks update button on Current Payment Method
    Then "Monthly Plan" page is displayed
    Then verify Update Payment is displayed on the page
    And user press back button
    When user clicks on Cancel Subscription
    Then "Cancel Plan" page is displayed
    And user click on the first option
    When user clicks confirm cancellation
    Then Subscription Plan Details window is displayed
    And user press back button
    And user press back button
    And user press back button
    Then menu page is displayed
    When user click sign out button on menu page
    Then confirm sign out page is displayed
    When user click ok button to confirm sign out









