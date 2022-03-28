Feature: Rewards regression


  Scenario: user clicks on deals page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94566" in zipcode page
    Then select order type page is displayed
    And select the delivery store
    And user click start shopping button on Sign In page
    Then complete tutorial flow
    And user click on member tab from Home page
    Then verify reward page title
    And user sees the "Grocery Rewards"
    When click on explore deals
    And navigate back to previous page
    When Click or tap on How do rewards work button
    Then Verify it lands on a page where it shows about your rewards and Earning Points
    And navigate back to previous page
    And user clicks on birthday card
    And validate the text on birthday card page
    Then user enters invalid dates
    Then user enters valid dates
    Then birthday card is closed
    And go to gas rewards


