Feature: Verify New welcome back screen for unverified phone numbers

  Background:
    When  Launch the MFA app

  @MOLN-46491
  Scenario: Validate navigations from Hamburger menu
    When user enter mobile number "5165440359" on Let's get started screen
    Then verify Welcome back screen is displayed
    And verify Welcome back page components

  @MOLN-46492
  Scenario: Validate navigations from Hamburger menu
    When user enter mobile number "5165440359" on Let's get started screen
    Then verify Welcome back screen is displayed
    When User click on Start over button
    Then verify let get started screen is displayed
    And verify "Mobile" is toggled and enabled

  @MOLN-46493
  Scenario: Validate navigations from Hamburger menu
    When user enter mobile number "5165440359" on Let's get started screen
    Then verify Welcome back screen is displayed
    When User click send code via Email CTA
    Then verify thanks for signing back in screen is displayed

  @MOLN-46494
  Scenario: Validate navigations from Hamburger menu
    When user enter mobile number "5165440359" on Let's get started screen
    Then verify Welcome back screen is displayed
    When user click on try different email link
    Then verify let get started screen is displayed
    And verify "Email" is toggled and enabled

  @MOLN-46501
  Scenario: Validate navigations from Hamburger menu
    When user enter mobile number "5165440359" on Let's get started screen
    Then verify Welcome back screen is displayed
    When User click send code via Email CTA
    Then verify thanks for signing back in screen is displayed
    And verify thanks for signing back in screen components

  @MOLN-46502
  Scenario: Validate navigations from Hamburger menu
    When user enter mobile number "5165440359" on Let's get started screen
    Then verify Welcome back screen is displayed
    When User click send code via Email CTA
    Then verify thanks for signing back in screen is displayed
    When User click on Start over button
    Then verify let get started screen is displayed
    And verify "Mobile" is toggled and enabled

  @MOLN-46503
  Scenario: Validate navigations from Hamburger menu
    When user enter mobile number "5165440359" on Let's get started screen
    Then verify Welcome back screen is displayed
    When User click send code via Email CTA
    Then verify thanks for signing back in screen is displayed
    When user click on try different email address link
    Then verify let get started screen is displayed
    And verify "Email" is toggled and enabled