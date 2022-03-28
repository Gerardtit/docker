Feature: verify chat session with edit

  @rewd @regression
  Scenario: 111-chat session with edit milk

    When sign in to the application
    Then user handle landing scenario
    And click continue option on pop up
    When user clicks on profile icon
    Then menu page is displayed
    When click on Contact us module
    And select chat option on contact us page
    Then verify chat screen is displayed
    Then "Chat" window is displayed
    Then "Edit my order" link is displayed
    When user click on "Edit my order" link
    Then user clicks on edit box
    And user types "DO YOU CARRY bread"
    And verify see Results text is displayed
    And user clicks See results
    Then verify products listing page displayed
    When user click back button or cancel button
    Then "Chat" window is displayed


  Scenario: 111-chat session with edit milk

    When sign in to the application
    Then user clicks notnow text
    Then user handle landing scenario
    And click continue option on pop up
    When user clicks on profile icon
    When click on Contact us module
    And select chat option on contact us page
    Then verify chat screen is displayed
    Then "Edit my order" link is displayed
    When user click on "Edit my order" link
    Then user clicks on edit box
    And user types "Do you carry Kaytee Forti-Diet Pet Food Canary & Finch Bag - 2 Lb."
    And verify specific text is displayed
    And user clicks View Product Details for specific product
    Then verify PDP screen is displayed
    When user click back button or cancel button
    Then "Chat" window is displayed


  Scenario: 111-chat session with edit milk

    When sign in to the application
    Then user clicks notnow text
    Then user handle landing scenario
    And click continue option on pop up
    When user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    And scroll down the screen
    And user change date picker to enable save
    And user click save button on orderInfo window
    Then checkout page is displayed
    When user clicks payment on checkout pagex
    When user enters "aaa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code
    Then payment CVV window is displayed
    When user enters "111" as CVV and clicks next
    Then checkout page is displayed
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    When user clicks Done button
    When user clicks on homeicon
    When user select yes on alert window
    And user click Dismiss
    When user clicks on profile icon
    When click on Contact us module
    And select chat option on contact us page
    Then verify chat screen is displayed
    Then "Chat" window is displayed
    Then "Edit my order" link is displayed
    When user click on "Edit my order" link
    Then user clicks on edittime
    Then OrderInfo window is displayed
    And scroll down the screen
    And user change date picker to enable save
    And user click save button on orderInfo window
    Then user clicks confirmchanges tab
    Then order confirmation page is displayed
    When user click back button or cancel button
    Then "Chat" window is displayed
