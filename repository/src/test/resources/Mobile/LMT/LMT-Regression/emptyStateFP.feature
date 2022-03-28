Feature: Verify the empty state on FP subscribed page

  @EmptyStateFPnoPerks
  Scenario: check the empty state for FP subscribed users without Perks
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then Verify Start shopping button on Sign In page
    When user click delivery option
    And user click start shopping button on After Signup
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks on "FreshPass"
    Then user is landed on "FreshPass" page
    When Trial button is selected
    When Freshpass page is displayed
    When user clicks on selecttab of monthly plan
    When user clicks add new card on page
    When user enters "aaa" as name on FP credit card page
    And user enters "341134113411347" as FP credit card number
    And user enters "1226" as FP card expiration month year
    And user enters "99999" as billing zip code on FP credit card page
    Then "CVV" text is displayed on the FP payment screen
    When user enters "111" as CVV and clicks next
    And Iagree box is selected
    And Startsubscription tab is clicked
    Then user sees the empty state message for FP subscribed users

  @EmptyStateFPPerks
  Scenario: check the empty state for FP subscribed users with Perks
    When click on NewSignup Api for OTP with rewards with user "testauto.fpoffers"
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks on "FreshPass"
    Then user is landed on "FreshPass" page
    Then user cannot see the empty state message for FP subscribed users