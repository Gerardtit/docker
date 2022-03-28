Feature: validate chat at contact us screen


  @Shraddha_055
  Scenario: check chat topics and resolution from Contact Us screen

    When click on NewSignup Api for OTP
    When user enters "94566" in zipcode page of the application
    Then verify MFA home screen is displayed
    When user clicks menu button on home page
    When user clicks Need Help Chatbot on current page
    Then "Chat" window is displayed
    Then "I need help with Sign In" link is displayed
    When user click on "I need help with Sign In" link
    Then user sees chat Help for "I need help with Sign In"
    When navigate back to previous level
    And user clicks Need Help Chatbot on current page
    Then "Where is my order?" link is displayed
    When user click on "Where is my order?" link
    Then user sees chat Help for "Where is my order?"
    When navigate back to previous level
    And user clicks Need Help Chatbot on current page
    Then "Edit my order" link is displayed
    When user click on "Edit my order" link
    Then user sees chat Help for "Edit my order"
    When navigate back to previous level
    And user clicks Need Help Chatbot on current page
    Then "Loyalty Program Info" link is displayed
    When user click on "Loyalty Program Info" link
    Then user sees chat Help for "Loyalty Program Info"
    When navigate back to previous level
    And user clicks Need Help Chatbot on current page
    Then "I have a problem with my Order" link is displayed
    When user click on "I have a problem with my Order" link
    Then user sees chat Help for "I have a problem with my Order"
    When navigate back to previous level
    And user clicks Need Help Chatbot on current page
    Then "Pickup and Delivery Options" link is displayed
    When user click on "Pickup and Delivery Options" link
    Then user sees chat Help for "Pickup and Delivery Options"

  @Shraddha_066 @regression
  Scenario: check chat topics and resolution from Contact Us screen

    When click on NewSignup Api for OTP
    When user enters "94566" in zipcode page of the application
    Then verify MFA home screen is displayed
    When user clicks menu button on home page
    When user clicks Contact Us on menu page
    Then "Contact Us" window is displayed
    When user clicks Chat on the contact us page
    Then "Chat" window is displayed
    Then "I need help with Sign In" link is displayed
    When user click on "I need help with Sign In" link
    Then user sees chat Help for "I need help with Sign In"
    When navigate back to previous level
    And user clicks Chat on the contact us page
    Then "Where is my order?" link is displayed
    When user click on "Where is my order?" link
    Then user sees chat Help for "Where is my order?"
    When navigate back to previous level
    And user clicks Chat on the contact us page
    Then "Edit my order" link is displayed
    When user click on "Edit my order" link
    Then user sees chat Help for "Edit my order"
    When navigate back to previous level
    And user clicks Chat on the contact us page
    Then "Loyalty Program Info" link is displayed
    When user click on "Loyalty Program Info" link
    Then user sees chat Help for "Loyalty Program Info"
    When navigate back to previous level
    And user clicks Chat on the contact us page
    Then "I have a problem with my Order" link is displayed
    When user click on "I have a problem with my Order" link
    Then user sees chat Help for "I have a problem with my Order"
    When navigate back to previous level
    And user clicks Chat on the contact us page
    Then "Pickup and Delivery Options" link is displayed
    When user click on "Pickup and Delivery Options" link
    Then user sees chat Help for "Pickup and Delivery Options"





