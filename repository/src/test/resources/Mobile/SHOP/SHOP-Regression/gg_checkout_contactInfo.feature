Feature: verify contact-info at checkout


  Scenario:validate new user at contact-info

    When sign in to the application
    When click on search field
    And user types "milk" on search bar and click search on home page and enter first milk
    And add products on product details page till cart value is equal to or more than 30 dollars
    And click on My Cart Icon
    And user clicks checkout button on cart page
    Then pickup time slot is selected
    Then user enters contact details
    And user enter credit card details
    When user enters "aaa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code
    Then payment CVV window is displayed
    When user enters "111" as CVV and clicks continue
    Then user enters contact details


  Scenario:validate new user at contact-info

    When sign in to the application
    When click on search field
    And user types "milk" on search bar and click search on home page and enter first milk
    And add products on product details page till cart value is equal to or more than 30 dollars
    And click on My Cart Icon
    And user clicks checkout button on cart page
    And user click cross sign checkout flow
    Then validate Enter name and enter mobile number text is displayed


  Scenario:validate existing user at contact-info

    When sign in to the application
    When click on search field
    And user types "milk" on search bar and click search on home page and enter first milk
    And add products on product details page till cart value is equal to or more than 30 dollars
    And click on My Cart Icon
    And user clicks checkout button on cart page
    And user click cross sign checkout flow
    Then validate only name and phone number is displayed
    Then validate warning message

  Scenario:validate contactinfo
    When sign in to the application
    When click on search field
    And user types "milk" on search bar and click search on home page and enter first milk
    And add products on product details page till cart value is equal to or more than 30 dollars
    And click on My Cart Icon
    And user clicks checkout button on cart page
    Then pickup time slot is selected
    Then user enters contact details
    And user enter credit card details
    When user enters "aaa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code
    Then payment CVV window is displayed
    When user enters "111" as CVV and clicks continue
    Then user enters contact details
    When Contact CTA is clicked,phone number is editable
    When toggle for sms is clicked



