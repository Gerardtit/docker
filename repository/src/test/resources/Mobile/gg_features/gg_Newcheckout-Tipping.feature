Feature: validate tipping at checkout


  Scenario:validate tipping at checkout
    When sign in to the application for delivery orders
    When click on shopping mode down arrow
    And Enter the ZipCode
    When click on right arrow button on zipcode page
    And select the delivery store
    Then verify delivery shopping mode is selected
    When click on search field
    And user types "milk" on search bar and click search on home page and enter first milk
    And add products on product details page till cart value is equal to or more than 30 dollars
    And click on My Cart Icon
    And user clicks checkout button on cart page
    And user click cross sign checkout flow
    And user validates driver tipping text
    And user validates change at driver tipping
    And user validates the percentageof tipping
    And validates that user can select any tipping percentage
    And Custom tipping window is displayed
    Then Validate save tab is enabled
    Then user is able to save tipping

    #@onama00
  Scenario:validate tipping error message when entered more than 99.99 dollars

    When sign in to the application for delivery orders
#    When click on shopping mode down arrow
#    And Enter the ZipCode
#    When click on right arrow button on zipcode page
#    And select the delivery store
#    Then verify delivery shopping mode is selected
#    When click on search field
#    And user types "milk" on search bar and click search on home page and enter first milk
#    And add products on product details page till cart value is equal to or more than 30 dollars
#    And add products on product details page till cart value is equal to or more than 100 dollars
    And click on My Cart Icon
    And user clicks checkout button on cart page
    And user click cross sign checkout flow
#    And user select yes on alert window
#    And user validates driver tipping text
    And user validates change at driver tipping
    And user taps on custom tip and Enters more than 100 dollars


#@onama00
  Scenario:validate tipping is not available for pickup

#   When sign in to the application for pickup orders
#    When click on search field
#    And user types "milk" on search bar and click search on home page and enter first milk
#    Then user add item to cart
    When go to cart screen
    And user clicks checkout button on cart page
    And user click cross sign checkout flow
    Then user verify driver tipping option is not displayed

