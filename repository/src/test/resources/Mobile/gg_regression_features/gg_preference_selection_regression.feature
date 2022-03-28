Feature: Preference Selection-Regression

  #C20786
  @regression @start_scenario
  Scenario: Select Delivery - Punt message
    When sign in to the application
    Then verify home screen is displayed
    And go to Home tab
    When click on shopping mode down arrow
    And user enters zipcode belonging to different banner
    And click on right arrow button on zipcode page
    Then verify FulfilledBy label is displayed on delivery option when user enters zipcode of different banner
    When select Delivery shopping mode
    And click on start Shopping Button
    Then verify Download/Open App button is displayed when user clicks Start Shopping button
    And click on cancel button on shopping mode screen

    #C16675
  @regression
  Scenario: Select DUG - Off Banner
    And go to Home tab
    When click on shopping mode down arrow
    And user enters zipcode belonging to different banner
    And click on right arrow button on zipcode page
    When select Pick UP shopping mode
    And click on start Shopping Button
    Then verify Download/Open App button is displayed when user clicks Start Shopping button
    And click on cancel button on shopping mode screen

    #C20791
  @regression @end_scenario
  Scenario: My Last Order/Popular items/Most viewed - View All links and sort or filters
    And go to Home tab
    When click see all button displayed next to must have grabs
    Then verify filter button is displayed
    When click search icon on product view all section
    And enter text "apple" in product view all section search field
    And select first item from search result
    Then verify products listing page displayed
    And verify filter button is displayed
    And click cancel button on product search page
    Then user clicks back button in must have grabs
    When navigate to deals tab
    And click on categories tab
    And user clicks category "Baby Care" under Categories in deals tab
    Then category card details page is displayed
    And verify filter button is not displayed