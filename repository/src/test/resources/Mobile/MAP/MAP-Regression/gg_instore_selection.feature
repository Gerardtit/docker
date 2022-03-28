Feature: Instore selection Run Shopping Mode

  Background: setup user on SignIn Page
    When user click maybe later version option
    Then sign in to the application
    #Then sign in to the application using account with existing rewards




#  @regression @miniRegression
#  Scenario: As a user,I should be able to select Instore Run Shopping Mode from Welcome Screen
#     And allow push notification permission
#     When user clicks delivery option on home page
#     Then zipcode page is displayed
#     When user enters "zipcode" in store zipcode page
    # And user clicks next button after registration on zipcode page
#     Then select order type page is displayed
#     When user click instore option
    # Then start shopping button is active
     #And user click start shopping button on Sign In page
     #Then home page is displayed
#     Then verify "In-store" option is selected as preference on home page



  @regression
  Scenario: Select Instore Preference should be removed and Global Substituion should be removed
    And allow push notification permission
    When user clicks delivery option on home page
    Then zipcode page is displayed
    When user enters "zipcode" in store zipcode page
    And user clicks next button after registration on zipcode page
    #Then select order type page is displayed
    When user click instore option
    #And user click start shopping button on Sign In page
    #Then home page is displayed
    Then verify "In-store" option is selected as preference on home page
    When user clicks shopping cart button on home page
  #  Then shopping cart page is displayed
    And No Substitution text is displayed on the screen
  #  And "Substitution Preference" text is not displayed on the screen
    Then verify substitutionPreference text is removed


#  @smoke @regression @miniRegression
#  Scenario: Instore Seletion Mode displays In-store cart header as "My List (X)" (x=number of items in Cart)
#    And allow push notification permission
#    When user clicks delivery option on home page
#    Then zipcode page is displayed
#    When user enters "zipcode" in store zipcode page
#    And user clicks next button after registration on zipcode page
#    Then select order type page is displayed
#    When user click instore option
#    Then home page is displayed
#    Then verify "In-store" option is selected as preference on home page
#    And user clicks shopping cart button on home page
#    Then verify in-store Header on the shopping cart page
