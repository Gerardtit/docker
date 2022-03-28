Feature: Optimize tappable zone on Deals Card

  Background:
    When Launch the MFA app

  @miniRegression
  Scenario:Verify Optimize tappable zone on deal cards
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then verify that 'For you' Tab is displayed
    And click on deal card
    Then verify eligible products are displayed in offer details page
    And click on close button
    When click on clip cta button on deals page
    Then verify Eligible products button is displayed on deals page
    When user click on Eligible products button is displayed on deals page
    Then verify eligible products are displayed in offer details page
    Then verify clipped label is displayed
    And click on close button
  
