Feature: Verify FreshPass Reformat Header name and Wallet Header first name appear correctly

  @regression @walletReformatHeader @mahmud1
  Scenario: Validate Wallet header replace with welcome if no first name
    When click on NewSignup Api for OTP with the long user name "testauto.withoutfirstnamelastname"
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    And user click on member tab from Home page
    When user click on wallet at member tab
    Then user should see welcome if no first name

  @regression @walletReformatHeader @mahmud1
  Scenario: Validate Wallet header with first name if first name last name is available
    When click on NewSignup Api for OTP with the long user name "testauto.withfirstname"
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    And user click on member tab from Home page
    When user click on wallet at member tab
    Then user should see first name appear if first name last name is available

  @regression @walletReformatHeader @mahmud1
  Scenario: Validate Wallet header appear long first name with three dot when Too many characters to fit in text label
    When click on NewSignup Api for OTP with the long user name "testauto.longfirstname"
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    And user click on member tab from Home page
    When user click on wallet at member tab
    Then user should see long first name appear with three dot if too many characters to fit in text label

  @regression @freshPassReformatHeader @mahmud1
  Scenario: Validate FreshPass header replace with welcome if no first name
    When click on NewSignup Api for OTP with the long user name "testauto.withoutfirstnamelastname"
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    And user click on member tab from Home page
    When user click on freshPass at member tab
    Then user should see welcome if no first name

  @regression @freshPassReformatHeader @mahmud1
  Scenario: Validate FreshPass header with first name if first name last name is available
    When click on NewSignup Api for OTP with the long user name "testauto.withfirstname"
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    And user click on member tab from Home page
    When user click on freshPass at member tab
    Then user should see first name appear if first name last name is available

  @regression @freshPassReformatHeader @mahmud1
  Scenario: Validate FreshPass header appear long first name with ... when Too many characters to fit in text label
    When click on NewSignup Api for OTP with the long user name "testauto.longfirstname"
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    And user click on member tab from Home page
    When user click on freshPass at member tab
    Then user should see long first name appear with three dot if too many characters to fit in text label
