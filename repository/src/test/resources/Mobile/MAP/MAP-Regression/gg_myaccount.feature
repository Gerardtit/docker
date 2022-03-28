@my_account
Feature: Feature to Verify "My Account" details in My Acount Page

 # Background: setup user on Home Page
  #  Given startup page is displayed
   # Then zipcode page is displayed
   # When user clicks Sign in button on zipcode page
   # Then sign in page is displayed

  @smoke @regression
  Scenario: As a user i should be able to see the 'My Account' details in the My Account Page.
    When sign in to the application using account with existing credentials
    And allow push notification permission at home page
    Then verify home screen is displayed
    When user click menu button on home page
    Then menu page is displayed
    When user clicks account on menu page
    Then my account page is displayed
    When user verify savings summery is displayed on account page
    And user verify address window is displayed on account page
    And user verify Dug store info is displayed on account page
    And user verify UDC info is displayed on account page
    And user verify phone number used in store is displayed
    And user verify email address is displayed on account page
    And user verify communication preference is displayed on account page


     #AJ #YRM-123
  @AJ
  Scenario: Validate navigations from Hamburger menu
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94566" in zipcode page
    Then select order type page is displayed
    When user click on pick up option
    Then click on radio to select 7499 dublin store
    And  user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    Then click on Hamburger menu and select developer settings
    And  switch on My Account Feature Enabled
    And kill the application
    And relaunch the application
    Then verify MFA home screen is displayed
    When user clicks on hamburger menu
    Then click on Account and Validate the header

  @smoke @regression
  Scenario: As a user i should be able to see the 'My Account' details in the My Account Page.
    When sign in to the application using account with existing credentials
    And allow push notification permission at home page
    Then verify home screen is displayed
    When user click menu button on home page
    Then menu page is displayed
    When user clicks account on menu page
    Then my account page is displayed
    When user verify savings summery is displayed on account page
    And user verify address window is displayed on account page
    And user verify Dug store info is displayed on account page
    And user verify UDC info is displayed on account page
    And user verify phone number used in store is displayed
    And user verify email address is displayed on account page
    And user verify communication preference is displayed on account page


    # YRM-202| Myaccount feature flag should be true to run this scenario
  @yrm202
  Scenario: Validate user is able to add new pickup store
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94566" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on After Signup
    Then verify MFA home screen is displayed
    When user clicks on member tab
    Then click on Account button
    Then click on Address on Account tab
    Then click on Add pickup hyperlink
