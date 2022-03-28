@my_items
Feature: Verify My Items Page

  Background:
    When Launch the MFA app

  @miniRegression
  Scenario:User selects Delivery option and Verify Update "My Items" page UI - add CTA button Part 2 ( redirect to Wallet page not Clipped deals page)

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    #When go to Deals tab
  #  And user click Dismiss
    #Then verify deals screen is displayed
    And user clicks on clip coupon on deals page
    And user click on member tab
    When go to Wallet tab
    And user click Dismiss
    Then the "Wallet" page is displayed
    And "You clipped Deal" text is displayed
    When user click on clipped Deals
    Then verify MyList page is displayed
    When click on Clipped deals tile
    Then Clipped Deals page is displayed
    #When go to MyList tab
    #Then verify my list page is displayed
    #Then "You clipped Deal" text is displayed
    #When user click on clipped Deals
    #And "Clipped Deals" page is displayed
    When navigate back to previous screen
    Then the "Wallet" page is displayed


  @smoke @miniRegression
  Scenario:User selects Delivery option and Verify Update "My Items" page UI - add CTA button Part 2 (should redirect to Wallet page not My Rewards page)

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    #When go to Deals tab
  #  And user click Dismiss
    #Then verify deals screen is displayed
    And user clicks on clip coupon on deals page
    And user click on member tab
    When go to Wallet tab
    And user click Dismiss
    Then the "Wallet" page is displayed
    And "You clipped Deal" text is displayed
    When user click on clipped Deals
    Then verify MyList page is displayed
    When click on Clipped deals tile
    Then Clipped Deals page is displayed
    #When go to MyList tab
    #Then verify my list page is displayed
    #Then "You clipped Deal" text is displayed
    #When user click on clipped Deals
    #And "Clipped Deals" page is displayed
    When navigate back to previous screen
    Then the "Wallet" page is displayed

  @smoke @miniRegression
  Scenario:Verify No APP Crash on Clicking Any Deal in Clipped Deals

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    And user clicks on clip coupon on deals page
    And go to MyList tab
    When click on Clipped deals tile
    Then Clipped Deals page is displayed
    And click on clipped deal
    And click on offer details link
    And verify Clipped label is displayed for the deal in deal details page

  @smoke @miniRegression
  Scenario:Verify My items page open when Button on Clipped Deals from Deals

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    #When go to Deals tab
  #  And user click Dismiss
    #Then verify deals screen is displayed
    And user clicks on clip coupon on deals page
    When go to MyList tab
    And click on Clipped deals tile
    Then Clipped Deals page is displayed


  @smoke
  Scenario:Verify My items page open when Button on Clipped Deals from Wallet

    When click on NewSignup for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page

    And user clicks on clip coupon on deals page
    When go to Wallet tab
    And user click Dismiss
    And user click Cancel in Feedback form
    Then verify wallet header
    When user click on clipped Deals
    Then verify my items screen is displayed
