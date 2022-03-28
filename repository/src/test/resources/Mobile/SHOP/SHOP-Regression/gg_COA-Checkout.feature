Feature: verify COA flow at checkout


  Scenario:validate COA account flow at checkout

    When sign in to the application using coa account
    When click on search field
    And user types "milk" on search bar and click search on home page and enter first milk
    And add products on product details page till cart value is equal to or more than 30 dollars
    And click on My Cart Icon
    And user clicks checkout button on cart page
    And user click cross sign checkout flow
    Then validate applycredit on account is displayed
    When applied credit is clicked and text box is displayed
    Then user apply a value to be credited
    Then Creditedapplied is displayed
    When Creditapplied is closed
    Then user is able to see same apply credit text



