@screen_chatbot_123   @regression
Feature: Screen and Chatbot feature

  Scenario: user click each screen and check icons

    When click on NewSignup Api for OTP
    When user enters "94566" in zipcode page of the application
    Then verify MFA home screen is displayed
    When user clicks menu button on home page
    Then menu page is displayed
    When user clicks orders on menu page
    Then "Orders" window is displayed
    When user clicks Need Help Chatbot on current page
    Then "Chat" window is displayed
    When navigate back to previous level
    Then "Orders" window is displayed
    When navigate back to previous level
    Then menu page is displayed
    When user clicks account on menu page
    Then "Account" window is displayed
    When user clicks Need Help Chatbot on account page
    Then "Chat" window is displayed
    When navigate back to previous level
    Then "Account" window is displayed
    When navigate back to previous level
    When navigate back to previous level
    Then menu page is displayed
    When user clicks Help FAQ on menu page
    Then help FAQ window is displayed
    When user clicks Need Help Chatbot on current page
    Then "Chat" window is displayed
    When navigate back to previous level
    Then help FAQ window is displayed
    When navigate back to previous level
    Then menu page is displayed
    When user clicks feedback on menu page
    Then "Feedback" window is displayed
    When user clicks Need Help Chatbot on current page
    Then "Chat" window is displayed
    When navigate back to previous level
    Then "Feedback" window is displayed
    When navigate back to previous level
    Then menu page is displayed
    When user clicks Contact Us on menu page
    Then "Contact Us" window is displayed
    When user clicks Chat on the contact us page
    Then "Chat" window is displayed
    When navigate back to previous level
    Then "Contact Us" window is displayed
    When user clicks Delivery & Pickup Questions
    Then "Message" window is displayed
    When navigate back to previous level
    Then "Contact Us" window is displayed
    When navigate back to previous level
    Then menu page is displayed
    When user clicks Terms and policy on menu page
    Then "Terms & Policies" window is displayed
    When navigate back to previous level
    Then menu page is displayed
    When user clicks "Third Party & Open Source" text on page
    Then "Third Party & Open Source" window is displayed
    When navigate back to previous level
    Then menu page is displayed
    When user clicks "Product Recalls" text on page
    Then "Product Recalls" window is displayed
    When navigate back to previous level
    Then menu page is displayed
    When user clicks Need Help Chatbot on current page
    Then "Chat" window is displayed
    When navigate back to previous level
    Then menu page is displayed
    And verify Version is displayed on menu page

