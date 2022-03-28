Feature: sign in handle cacheText

  Scenario: Verify user sign in to the application

    When user clicks Maybe Later
    When user enter "email" in username field on Sign In page
    And user enter "password" in password field on Sign In page
    When user clicks continue for CacheText
    When user clicks Shopping mode option on home page
    And user enter zipcode and search in zipcode field
    When user enters "zipcode" in zipcode page
    And user clicks start shopping button on Sign In page
    Then Home page is displayed