Feature: Wallet regression


  Scenario: user at wallet page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94566" in zipcode page
    Then select order type page is displayed
    And user click start shopping button on Sign In page
    Then complete tutorial flow
    And user click on member tab from Home page

    When go to Wallet tab
    Then verify wallet header
    And Scroll down on wallet screen
    Then verify Loyalty card information text
    And verify See your clipped deals is displayed
    And verify See your rewards and points is displayed
    Then verify QR code of Loyalty card
    And verify Loyalty card information text
    And verify 'Setup contactless pay' banner is not displayed
    And click on My Cart Icon
    Then shopping cart empty page is displayed
    And click on close button on my cart screen
    And go to Home tab
    And user types "baby health" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And click on My Cart Icon
    And click on close button on my cart screen
    Then click cancel button on product search page
    And user clicks on deals tab
    When click on clip deal if present
    When user clicks on member tab
    When go to Wallet tab
    When click See all button in deals section
    Then verify Clipped deals screen is displayed
    And keep app in background and relaunching the same

    And verify Clipped deals title
    When go to Wallet tab
    Then verify wallet header
    Then verify the cart count after adding product in wallet page
    And user click on clipped Deals
    Then verify Wallet View products
    Then verify that 'My List' Page is displayed
    And click a category on clipped deals screen
    And click on first deal card displayed in the category
    Then verify Deal Detail page is displayed
    And close deal details page
    And user click on member tab from Home page
    When go to Wallet tab



      #C46248
  @regression @functional
  Scenario: As a user , I should see that count of clipped deals on wallet screen should be match with count on clipped deals screen
    When sign in to the application using account with existing rewards
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    Then verify count of deals on clipped And Wallet Screen are same

      #C46308
  @regression @functional @smoke
  Scenario: As a User, I should see 0 count in clipped deals if no deals are clipped
    When sign in to the application using account with no redeemed rewards and no deals clipped
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    And verify zero clipped deals

#-----------------------data based--------------------------#C46341
  @regression
  Scenario: As a user, I should  see monopoly deals under the clipped deals screen in the app
    When sign in to the application using account with Monopoly
    Then verify home screen is displayed
    Then go to Wallet tab
    Then verify wallet header
    And click on Clipped deals tile
    And click on "Special Offers" category in deals
    Then verify monopoly deal is present under a category in clipped deals page


    #C46323
  @regression @functional
  Scenario: As a user, I should navigate back and forth from payless banner and next screen
    When sign in to the application using account with contactless pay banner
    Then verify home screen is displayed
    When go to Home tab
    And select the store which has contact less pay banner
    Then go to Wallet tab
    Then verify wallet header
    When click on 'Setup contactless pay' banner in Wallet screen
    And handle tutorial for contact less pay set up
    And click on X button on Pay Screen
    Then verify 'Setup contactless pay' banner in Wallet screen
      #C46342
  @regression @functional
  Scenario: As a user, I should be navigated to deal detail page on clicking on view products button for a clipped monopoly deal
    When sign in to the application using account with Monopoly
    Then verify home screen is displayed
    Then go to Wallet tab
    Then verify wallet header
    And click on Clipped deals tile
    And click on "Special Offers" category in deals
    Then verify clipped monopoly deal card is present in Clipped Deals screen
    When click on Eligible product button on Clipped Deals screen
    And verify deal detail page is displayed
    And close deal details page