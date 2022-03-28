Feature:  Verify ApologyText At instore cart page


  Scenario: Apology text in store
    When sign in to the application using account with existing rewards
    Then user clicks continue Popups

    When user clicks shopping cart button on home page
    When user empty shopping cart
    Then shopping cart empty page is displayed
    When user clicks navigate back to the previous page

    When user clicks delivery option on home page
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    And user clicks next button on zipcode page
    When user selects Tomthumb Store
    And user click start shopping button on Sign In page
    Then fill list with four different items
    When user clicks ListIcon on home page
    Then Validate ApologyText on ListPage
    When user clicks delivery option on home page on return
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    And user clicks next button on zipcode page
    When user clicks pickup on delivery select page
    Then storelist is displayed
    And user click start shopping button on Sign In page
    When user clicks shopping cart button on home page
    Then Validate ApologyText not available


    When user clicks delivery option on home page
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    And user clicks next button on zipcode page
    When user click delivery option
    And user click start shopping button on Sign In page
    When user clicks shopping cart button on home page
    Then Validate ApologyText not available
