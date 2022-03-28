Feature: Shopping mode & Reserve Time

  #C69420
  @regression @functional @smoke @start_scenario
  Scenario: As a user, I should able to change the selected shopping mode on the dashboard
    When sign up to the application with popup handling
    Then verify home screen is displayed
    And go to Home tab
    And select the pick-up store
    Then verify pickup shopping mode is selected
    When click on shopping mode down arrow
    And Enter the ZipCode
    When click on right arrow button on zipcode page
    And select the delivery store
    Then verify delivery shopping mode is selected
    When click on shopping mode down arrow
    And Enter the ZipCode
    When click on right arrow button on zipcode page
    And select in-store run using zip code and store name
    Then verify instore shopping mode is selected

  #C16690
  @regression
  Scenario: As a existing Loyalty app user with shopping history on either shop app or web, I should see 'Shopping method' which is selected and saved will be shown as selected by default
    When click on shopping mode down arrow
    And Enter the ZipCode
    When click on right arrow button on zipcode page
    Then verify user is in shopping mode screen
    And verify shopping mode is selected by default if shopping mode preference is already set
    And click On Back Button of Shopping Mode Page
    When click on right arrow button on zipcode page
    And select the delivery store


  @regression
  Scenario: As a user, I should see 'In- store run' is selected by default, If only the 'In-Store' is available

    When click on shopping mode down arrow
    And Enter the ZipCode
    When click on right arrow button on zipcode page
    And  Enter the ZipCode
#    When click on right arrow button on zipcode page
#    And select in-store with store-address
    Then verify user is in shopping mode screen
    Then verify In Store Shopping Mode is Selected
    And click On Back Button of Shopping Mode Page
    When click on right arrow button on zipcode page
    And select the delivery store

   #C69366
  @regression
  Scenario: As a user i should be navigated to shopping mode screen on entering the zip code or sharing location
    When click on shopping mode down arrow
    And Enter the ZipCode
    When click on right arrow button on zipcode page
    Then verify user is in shopping mode screen
    And click On Back Button of Shopping Mode Page
    When click on right arrow button on zipcode page
    And select the delivery store

   #C69371
  @regression
  Scenario: As a user i should see that shopping method selection works as expected when shopping mode is delivery
    When click on shopping mode down arrow
    And Enter the ZipCode
    When click on right arrow button on zipcode page
    And change to delivery shopping mode
    Then verify delivery shopping mode is selected

   #C69374
  @regression
  Scenario: As a user i should see that shopping method selection works as expected when shopping mode is pickup and in-store
    And select the pick-up store
    Then verify pickup shopping mode is selected
    When click on shopping mode down arrow
    And Enter the ZipCode
    When click on right arrow button on zipcode page
    And select in-store run using zip code and store name
    Then verify instore shopping mode is selected

   #C69388
  @regression
  Scenario: As a User, i should be able to cancel the shopping mode screen and navigate to the dashboard with the default selection
    When click on shopping mode down arrow
    And Enter the ZipCode
    When click on right arrow button on zipcode page
    Then verify user is in shopping mode screen
    And select Delivery shopping mode
    When click on cancel button on shopping mode screen
    Then verify dashboard page is displayed

   #C69412
  @regression
  Scenario: As a user, I should able to see the selected mode of shopping on dashboard
    When click on shopping mode down arrow
    And Enter the ZipCode
    When click on right arrow button on zipcode page
    Then verify user is in shopping mode screen
    And click On Back Button of Shopping Mode Page
    When click on right arrow button on zipcode page
    And select the delivery store

   #C69367
  @regression
  Scenario: As a User, i should see that the shopping mode screen must be as per the design and respective banner
    When click on shopping mode down arrow
    And Enter the ZipCode
    When click on right arrow button on zipcode page
    Then verify user is in shopping mode screen
    And scroll up the screen
    And verify 'How do you want your groceries' is Displayed
    And verify Delivery Shopping Mode Option is Displayed
    Then verify Pick Up Shopping Mode Option is Displayed
    And verify In-store Shopping Mode Option is Displayed
    Then verify Start Shopping Button is Displayed
    When keep app in background and relaunching the same in shopping page
    Then verify Start Shopping Button is Displayed
    And click on start Shopping Button

#   C10938
  @regression
  Scenario:  As a User, I should see the CTA of a 'Reserve Time' is as per respective banner and design
    Then select the pick-up store
    Then verify pickup shopping mode is selected
    When click on reserve a time
    Then verify reserve a time page is displayed
#    And verify Please Note Message is Displayed
    Then verify Choose Date And Time label is displayed
    And verify store address is displayed on reserve time screen
    Then verify Earliest Available Pickup Times label is displayed
    And verify order date picker is displayed
    Then verify order time picker is displayed
    And verify Save button is displayed on reserve time screen
    And click back button on reserve a time page

   #C10370
  @regression
  Scenario: As a User, I should reserve a time CTA works as expected for both pickup and delivery
    And go to Home tab
    Then select the pick-up store
    Then verify pickup shopping mode is selected
    Then verify reserve a time option is present
    When click on shopping mode down arrow
    And change to delivery shopping mode
    Then verify delivery shopping mode is selected
    Then verify reserve a time option is present

   #C30079
  @regression
  Scenario: Kill And Relaunch -Shopping method Selection(Pick up/In- store/Delivery)
    And go to Home tab
    When click on shopping mode down arrow
    And Enter the ZipCode
    When click on right arrow button on zipcode page
    And select the pick-up store
    And kill the application
    And relaunch the application
    And handle zip code page if displayed
    And handle tutorial if displayed on home page
    Then verify home screen is displayed
    And handle tutorial if displayed on home page
    And go to Home tab
    And verify pickup shopping mode is selected
    When click on shopping mode down arrow
    And Enter the ZipCode
    When click on right arrow button on zipcode page
    And select the delivery store
    And kill the application
    And relaunch the application
    And Enter the ZipCode
    When click on right arrow button on zipcode page
    And select the delivery store
    Then verify home screen is displayed
    And go to Home tab
    And verify delivery shopping mode is selected
    When click on shopping mode down arrow
    And Enter the ZipCode
    When click on right arrow button on zipcode page
    And select in-store run using zip code and store name
    And kill the application
    And relaunch the application
    And Enter the ZipCode
    When click on right arrow button on zipcode page
    And select in-store run using zip code and store name
    Then verify home screen is displayed
    And go to Home tab
    And verify instore shopping mode is selected


#   C16688
  @regression @end_scenario
  Scenario: As a brand new user, I should see no shopping method will be selected by default
    And forced sign out from the application
    When sign up to the application
    When click on NewSignup for OTP
    And click on existing user signin for OTP
    And Enter the ZipCode
    When click on right arrow button on zipcode page
    Then verify no shopping method is selected
    And handle zip code page if displayed
    And handle tutorial if displayed
    And select in-store run using zip code and store name
    Then verify instore shopping mode is selected
