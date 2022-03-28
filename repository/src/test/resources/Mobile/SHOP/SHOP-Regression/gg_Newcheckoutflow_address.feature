Feature: verify newcheckout address


  Scenario:validate new checoutflow address

    When sign in to the application
    When click on search field
    And user types "milk" on search bar and click search on home page and enter first milk
    And add products on product details page till cart value is equal to or more than 30 dollars
    And click on My Cart Icon
    And user clicks checkout button on cart page
    Then validate cursor is at street address
    Then City and state are pre-filled
    And State is not editable
    And apt number is optional
    Then user enters delivery address
