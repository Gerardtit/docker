Feature: verify COA flow at checkout


  Scenario:validate COA account flow at checkout

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
    Then validate promo on account is displayed and get cost
    When promo code is clicked and text box is displayed
    When user enters invalid promocode, error messageis displayed
    When textbox is empty,Apply CTA is inactive
    Then user enters promo code and click Apply CTA
    When  user clicks on cross sign of promocode
    Then user can add any number of promocodes
    When user enters invalid promocode, error messageis displayed



