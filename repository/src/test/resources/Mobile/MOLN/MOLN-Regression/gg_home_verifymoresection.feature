Feature: Verify More Section

  @miniRegression
  Scenario: Verify More Section in Hemberger
    When Launch the MFA app
    And click on existing user signin for OTP
    Then verify MFA home screen is displayed
    When user click on Heamberger
    Then verify that terms & policies is displayed
    And click on terms & policies
    Then verify that respective page is opening without any error





  #Click Third party & open source and verify respective page is opening without any error
 # Click Product Recalls and verify respective page is opening without any error
