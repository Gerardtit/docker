Feature: Wallet


  Background:
#  Background steps moved to TCs as it was not matching for all the TCs.

  Scenario: As a user, I must see the navigation title and header of the Wallet section so that I know where I am in the app.
    When sign in to the application
    Then verify home screen is displayed
    And verify Wallet tab bar is displayed
    When go to Wallet tab
    Then Verify wallet header


  @regression
  Scenario:User selects Delivery option and navigate to BOGO Option
    When click on NewSignup for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks Deals on home page
#    And please take survey
    And user click Dismiss
    Then verify deals screen is displayed
    When user clicks All coupons in deals page
    Then user should see all the coupons
    When user tap on clip then user should see View Products
    Then verify Wallet tab bar is displayed
    When go to Wallet tab
    And user click Dismiss
    And user click Cancel in Feedback form
    Then verify wallet header
    When user click on clipped Deals
    Then verify Wallet View products


  @smokeBVT
  Scenario:User selects Delivery option and navigate to BOGO Option


    When click on NewSignup for OTP
    Then zipcode page is displayed
    When user enters "75214" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    When user clicks Deals on home page
#    And please take survey
    Then verify deals screen is displayed
    And verify that 'Fresh new coupons' is displayed
    And verify that Clip button is displayed
    When user tap on clip then user should see View Products
    Then verify Wallet tab bar is displayed
    When go to Wallet tab
    Then Verify wallet header
    When user click on clipped Deals
    Then verify Wallet View products

  #C5979
  @regression @functional @smoke
  Scenario: As a user, I must see the navigation title and header of the Wallet section so that I know where I am in the app
    When sign in to the application using account with existing rewards
    Then verify home screen is displayed
    And verify Wallet tab bar is displayed
    When go to Wallet tab
    Then verify wallet header

  #C46221
  @regression @functional
  Scenario: The navigation header must stay fixed at the top and should not scroll with the screen scroll.
    When sign in to the application using account with existing rewards
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    Then Scroll down on wallet screen
    And verify wallet header

  #C46292
  @regression @functional @smoke
  Scenario: As a User, I should see cart icon with count of total items added in the cart
    When sign in to the application using account with no rewards
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    And verify count on cart Button

  #C46293
  @regression @functional @smoke
  Scenario: As a User, I should see cart icon count gets updated without delay on adding/removing items
    When sign in to the application
    Then verify home screen is displayed
    And go to Wallet tab
    Then verify wallet header
    And click on My Cart Icon
    And clear cart items
    And close my cart page
    And get the count of cart item in wallet page
    Then verify zero count on cart Button
    And go to Home tab
    When search for product "beef" on home page
    And add a product on product details page
    Then go back to Home Page from product details page
    Then go to Wallet tab
    Then verify the cart count after adding product in wallet page

  #C46294
  @regression @functional @smoke
  Scenario: As a User, I should navigate to 'My Cart' on tapping on cart icon in wallets screen
    When sign in to the application using account with no rewards
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    When click on My Cart Icon
    And verify My Cart Screen Title is Displayed

  #C46299
  @regression @functional @smoke
  Scenario: As a User, I should see cart icon with 0 count if no items are added in cart
    When sign in to the application
    Then verify home screen is displayed
    And go to Wallet tab
    Then verify wallet header
    And click on My Cart Icon
    And clear cart items
    And close my cart page
    Then verify zero count on cart Button

  #C46230
  @regression @functional @smoke
  Scenario: As a user, on my Loyalty card, I should be able to see title of the card and the QR code
    When sign in to the application using account with existing rewards
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    And verify title of Loyalty card
    Then verify QR code of Loyalty card

  #C46232
  @regression @functional @smoke
  Scenario: As a user, I should be able to see a text informing me of my next step of action & respective banner icon
    When sign in to the application using account with existing rewards
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    And verify Loyalty card information text

  #C46231
  @regression @functional
  Scenario: As a user, I should be able to see the Loyalty card scroll with the screen
    When sign in to the application using account with existing rewards
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    And Scroll down on wallet screen
    Then verify Loyalty card information text

  #C46223
  @regression @functional @smoke
  Scenario: As a user, I want to see the setup contactless pay banner on the wallet screen if I have not setup contactless pay on my account
    When sign in to the application using account with contactless pay banner
    Then verify home screen is displayed
    When go to Home tab
    And select the store which has contact less pay banner
    When go to Wallet tab
    Then verify wallet header
    And verify 'Setup contactless pay' banner in Wallet screen

  #C46225
  @regression @functional @smoke
  Scenario: As a user, I should not see the setup contactless pay banner for a Store which does not support ZTP
    When sign in to the application using account with existing rewards
    Then verify home screen is displayed
    When go to Home tab
    And select store which does not have contact less pay banner
    When go to Wallet tab
    Then verify wallet header
    And verify 'Setup contactless pay' banner is not displayed


#  #C46323-----Move to optimized section------------
#  @regression @functional
#  Scenario: As a user, I should navigate back and forth from payless banner and next screen
#    When sign in to the application using account with contactless pay banner
#    Then verify home screen is displayed
#    When go to Home tab
#    And select the store which has contact less pay banner
#    Then go to Wallet tab
#    Then verify wallet header
#    When click on 'Setup contactless pay' banner in Wallet screen
#    And handle tutorial for contact less pay set up
#    And click on X button on Pay Screen
#    Then verify 'Setup contactless pay' banner in Wallet screen

  #C46243
  #TBD/API
  @regression @functional
  Scenario: As a user, I want to see all the deals clipped count on the wallet screen
    When sign in to the application using account with existing rewards
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    And verify clipped deals count

  #C46246
  #TBD/API
  @regression @functional @smoke
  Scenario: As a user, I should see total number of clipped deals in wallet screen
    When sign in to the application using account with existing rewards
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    And verify clipped deals count

  #C46247
  @regression @functional
  Scenario: As a user, On clicking clipped deals tile I should land on clipped deals screen
    When sign in to the application using account with existing rewards
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    And verify clipped deals count
    When click on Clipped deals tile
    Then verify Clipped deals screen is displayed
    And verify Clipped deals title

#  #C46248
#  @regression @functional
#  Scenario: As a user , I should see that count of clipped deals on wallet screen should be match with count on clipped deals screen
#    When sign in to the application using account with existing rewards
#    Then verify home screen is displayed
#    When go to Wallet tab
#    Then verify wallet header
#    Then verify count of deals on clipped And Wallet Screen are same

  #C46249
  @regression @functional
  Scenario: Verify the Deal Card in the Clipped Deals section
    When sign in to the application using account with existing rewards
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    And click on Clipped deals tile
    Then verify Clipped deals screen is displayed
    And click a category on clipped deals screen
    And verify deal title in clipped deals section
    Then verify deal description in clipped deals section
    And verify deal expiry date in clipped deal section
    Then verify Eligible products button is displayed in clipped deals screen
    And verify 'Eligible Products' text

  #C46250
  @regression @functional @smoke
  Scenario: As a user , On clicking back button on clipped deals screen I should be navigated to wallet screen
    When sign in to the application using account with existing rewards
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    And verify clipped deals count
    When click on Clipped deals tile
    Then verify Clipped deals screen is displayed
    When click back button on Clipped deals page
    Then verify wallet header
    Then verify clipped deals count

  #C46308
  @regression @functional @smoke
  Scenario: As a User, I should see 0 count in clipped deals if no deals are clipped
    When sign in to the application using account with no redeemed rewards and no deals clipped
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    And verify zero clipped deals





   #C46349
  @regression
  Scenario: As a User, I should see all my clipped deals organised by categories Alphabetically in Wallet->Clipped screen
    When sign in to the application
    Then verify home screen is displayed
    Then go to Wallet tab
    Then verify wallet header
    And click on Clipped deals tile
    Then verify clipped deals are sorted by categories

  #C46350
  @regression
  Scenario: As a User, I should see Special offers must be shown at the top if there are clipped deals underneath it.
    When sign in to the application
    Then verify home screen is displayed
    Then go to Wallet tab
    Then verify wallet header
    And click on Clipped deals tile
    Then verify deal category "Special Offers" shown at the top in 'Clipped Deals' categories

  #C46356
  @regression
  Scenario: As a User, I should see 'Deal Detail page' on tapping any clipped deal card
    When sign in to the application
    Then verify home screen is displayed
    And go to Wallet tab
    Then verify wallet header
    And click on Clipped deals tile
    And click a category on clipped deals screen
    And click on first deal card displayed in the category
    Then verify Deal Detail page is displayed

  #C46357
  @regression
  Scenario: As a User, I should be able to do  Pull to refresh the deals
    When sign in to the application
    Then verify home screen is displayed
    Then go to Wallet tab
    Then verify wallet header
    When click on Clipped deals tile
    Then refresh the page and verify progress spinner is displayed
    And verify progress spinner is not displayed after waiting for few seconds
    And verify Clipped deals screen is displayed
    And verify My Cart icon is displayed
    And verify clipped deals count is displayed on clipped deals screen
    And verify category name and count is displayed for category on clipped deals screen

  #C69655
  @regression
  Scenario: As a existing user, I should see the Clipped rewards and Clipped Deals section switched to the top of the screen
    When sign in to the application using account with existing rewards
    Then verify home screen is displayed
    Then go to Wallet tab
    Then verify wallet header
    And verify Clipped deals and Clipped rewards section is present at the top

  #C69656
  @regression @functional
  Scenario:As a existing user, I should see the Clipped deals screen on clicking See all CTA when Clipped deal count is more than 1
    When sign in to the application using account with existing rewards
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    And verify clipped deals count
    Then verify See all CTA is displayed in deals section
    When click See all button in deals section
    Then verify Clipped deals screen is displayed
    And verify Clipped deals title

  #C69657
  @regression @functional
  Scenario:As a existing user, I should see the Clipped rewards screen on clicking See all CTA when Clipped rewards count is more than 1
    When sign in to the application using account with existing rewards
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    And verify clipped rewards count
    Then verify See all CTA is displayed in rewards section
    When click See all button in rewards section
    Then verify Clipped rewards screen is displayed
    And verify Clipped rewards title

  #C69831
  @regression @functional
  Scenario: As a User, I should see new UI for "Clipped deals" & "Clipped rewards"
    When sign in to the application using account with no redeemed rewards and no deals clipped
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    And verify zero clipped deals
    Then verify Start earning rewards today is displayed
    Then verify See all CTA is displayed in deals section
    Then verify See all CTA is displayed in rewards section

  #C69832
  @regression @functional
  Scenario: As a User, I should navigate to Respective screen on tapping anywhere on"Clipped deals" & "Clipped rewards" tile
    When sign in to the application using account with no redeemed rewards and no deals clipped
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    And verify zero clipped deals
    Then click on Clipped deals tile
    And verify deals screen is displayed
    When go to Wallet tab
    And verify Start earning rewards today is displayed
    Then click on Clipped rewards tile
    And verify that my rewards page is displayed

   #C69833
  @regression @functional
  Scenario: As a user i should see different text for different scenarios
    When sign in to the application using account with no redeemed rewards and no deals clipped
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    And verify You clipped zero deals text is displayed
    And verify Start earning rewards today is displayed

  #C46236
  @regression @functional
  Scenario: As a user, if there are more than 0 active clipped redeemed rewards, user should see " # Clipped Rewards"
    When sign in to the application using account with existing rewards
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    And verify clipped rewards count

  #C46237
  @regression @functional
  Scenario: Verify for a new User , Clipped Rewards section should display Start earning rewards today
    When sign in to the application using account with no redeemed rewards and no deals clipped
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    And verify Start earning rewards today is displayed

  #C46262
  @regression @functional @smoke
  Scenario: As a user, On clicking Clipped rewards tile I should land on clipped rewards screen
    When sign in to the application using account with existing rewards
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    When click on Clipped rewards tile
    Then verify Clipped rewards screen is displayed
    And verify Clipped rewards title

  #C46263
  @regression @functional
  Scenario: As a user , I should see that the count of clipped rewards on wallet screen should be match with count on clipped rewards screen
    When sign in to the application using account with existing rewards
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    And verify count of rewards on clipped And Wallet Screen are same

  #C46264
  @regression @functional
  Scenario: As a user, I should see that clipped rewards should show Clipped button in the clipped rewards screen
    When sign in to the application using account with existing rewards
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    And verify clipped rewards count
    When click on Clipped rewards tile
    Then verify Clipped rewards screen is displayed
    And verify Clipped rewards title
    And verify Clipped button is displayed in clipped rewards screen

  #C46265
  @regression @functional
  Scenario: As a user, I should see Enjoy by <date> if the rewards is used and the clipped button is shown in solid box.
    When sign in to the application using account with existing rewards
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    And verify clipped rewards count
    When click on Clipped rewards tile
    Then verify Clipped rewards screen is displayed
    And verify Clipped rewards title
    Then verify Enjoy by Date is displayed in the clipped card

  #C46266
  @regression @functional @smoke
  Scenario: As a user , On clicking back button on clipped rewards screen I should be navigated to wallet screen
    When sign in to the application using account with existing rewards
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    And verify clipped rewards count
    When click on Clipped rewards tile
    Then verify Clipped rewards screen is displayed
    And click back button on Clipped rewards page
    Then verify clipped rewards count

  #C46340
  @regression @functional
  Scenario: As a user, On clicking clipped rewards I should be navigated to clipped rewards screen and clipped rewards count should be same
    When sign in to the application using account with existing rewards
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    And verify count of rewards on clipped And Wallet Screen are same

  #C69817
  @regression @functional
  Scenario: Wallet| 0 Clipped Rewards
    When sign in to the application using account with no redeemed rewards and no deals clipped
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    And verify Start earning rewards today is displayed
    Then click on Clipped rewards tile
    And verify that my rewards page is displayed

  #C69818
  @regression @functional
  Scenario: Wallet| 0 Clipped Deals
    When sign in to the application using account with no redeemed rewards and no deals clipped
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    And verify zero clipped deals
    Then click on Clipped deals tile
    And verify deals screen is displayed

  #C66405
  @regression
  Scenario: Verify that the Wallet Landing page is per Figma design
    When sign in to the application using account with existing rewards
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    And verify clipped deals count
    Then verify clipped rewards count
    And verify See all CTA is displayed in deals section
    Then verify See all CTA is displayed in rewards section
    And verify title of Loyalty card
    Then verify Loyalty card information text
    And verify QR code of Loyalty card

  #C67160
  @regression
  Scenario: Verify that the Wallet with the payment card  is per Figma design
    When sign in to the application using account with contactless pay banner
    Then verify home screen is displayed
    And go to Home tab
    And select the store which has contact less pay banner
    When go to Wallet tab
    Then verify wallet header
    And verify 'Setup contactless pay' banner in Wallet screen

  #C30077
  @regression
  Scenario: Check the spinner is getting displayed in "Wallet "page when the Data is being Loaded
    When sign in to the application using account with existing rewards
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    When refresh the page and verify progress spinner is displayed

  #C46298
  @regression @functional
  Scenario: Keeping the app in background and relaunching
    When sign in to the application using account with existing rewards
    Then verify home screen is displayed
    Then go to Wallet tab
    Then verify wallet header
    And get cart count Before keeping app in Background
    Then keep app in background and relaunching the same
    And get cart count after keeping app in foreground and verify if they are same in wallet page
    When click on Clipped deals tile
    Then verify Clipped deals screen is displayed
    And keep app in background and relaunching the same
    Then verify Clipped deals title
    When click back button on Clipped deals page
    And click on Clipped rewards tile
    Then verify Clipped rewards screen is displayed
    And keep app in background and relaunching the same
    Then verify Clipped rewards title
    # added by albertsons team
    And click on Clipped deals tile
    Then scroll down the screen
    Then verify clipped monopoly deal card is present in Clipped Deals screen
    And click on monopoly deal card with one time use
    Then verify offer terms and condition in deal card
    When keep app in background and relaunching the same in deal detail screen
    Then verify offer terms and condition in deal card

      #Marking this as manual, since paycard is session based and it will disappear once user log out
#  @regression @functional
#  Scenario: As a user, I want to see the pay card to be shown on the wallet after setting up my payment method
#    When sign in to the application using account with pay card
#    Then verify home screen is displayed
#    When go to Wallet tab
#    Then verify title of Pay card

    #Marking this as manual, since paycard is session based and it will disappear once user log out
#    #C6429 - Covered in this scenario.
#  @regression @functional
#  Scenario:  As a user, I should be able to flip the card to front by tapping on either card
#    When sign in to the application using account with pay card
#    Then click on shopping mode down arrow
#    And select the store which has Pay Card
#    Then go to Wallet tab
#    And flip to pay card
#    Then verify pay card is flipped
#    And flip to loyalty card
#    Then verify Loyalty card is flipped

  #Marking this as manual, since paycard is session based and it will disappear once user log out
#  @regression
#  Scenario: As a user, I want to see the pay card to be shown as banner specific
#    When sign in to the application using account with pay card
#    Then click on shopping mode down arrow
#    And select the store which has Pay Card
#    Then go to Wallet tab
#    And flip to pay card
#    Then verify pay card is flipped
#    And verify pay card info is displayed
#    Then verify pay card sub info is displayed
#    And verify pay card Lets do it CTA is displayed

      ## Moving this to manual since clipping a deal through automation everytime will reduce the reward points
    ## and there is no way to un-clip a deal after it is clipped
#  @regression @functional @smoke
#  Scenario: As a User, I should see clipped deals count in wallet screen gets updated everytime upon clipping the product/deal card
#    When sign in to the application using account with no rewards
#    Then verify home screen is displayed
#    When go to Wallet tab
#    When verify clipped deals count
#    And verify Clipped deals count gets updated upon clipping product/deal card


      ## Moving this to manual since clipping a deal through automation everytime will reduce the reward points
    ## and there is no way to un-clip a deal after it is clipped
#  @regression @functional
#  Scenario: As a user, I should be able to clip reward
#    When sign in to the application using account with existing rewards
#    Then verify home screen is displayed
#    When click on reward link
#    And click on reward card
#    And click on clip button on reward details page
#    Then verify reward is clipped on reward details page
#    Then click on close button on reward details page

  ## Moving this to manual since clipping a deal through automation everytime will reduce the reward points
    ## and there is no way to un-clip a deal after it is clipped
#  @Pending
#  Scenario: As a user, I should see count of clip rewards updated dynamically
#    When sign in to the application using account with existing rewards
#    Then verify home screen is displayed
#    When click on reward link
#    And click on reward card
#    And click on clip button on reward details page
#    Then verify reward is clipped on reward details page
#    Then click on close button on reward details page
#    When go to Wallet tab
#    When verify clipped deals count
#    And verify Clipped deals count gets updated upon clipping product/deal card

      # C6430 - This test case covers the below scenario.
#  @regression @functional
#  Scenario: As a user, I should be able to flip between Loyalty and Pay card
#    When sign in to the application using account with pay card
#    Then click on shopping mode down arrow
#    And select the pick-up store which has Pay Card
#    Then go to Wallet tab
#    And flip to pay card
#    Then flip to loyalty card

      #C13942  - This test case covers the below scenario.
#  @regression @functional @smoke
#  Scenario: As a User, I should see cart icon in wallet screen
#    When sign in to the application using account with no rewards
#    Then verify home screen is displayed
#    When go to Wallet tab
#    Then verify My Cart is Displayed

  #C6422 -- this id covers below scenario
  #@regression @functional @smoke
  #Scenario: As a user, I should be able to see a text informing me of my next step of action & respective banner icon
    #When sign in to the application using account with existing rewards
    #Then verify home screen is displayed
    #And verify Wallet tab bar is displayed
    #When go to Wallet tab
    #Then verify wallet header
    #And verify Loyalty card information text


  #C11671 -- this id covers below scenario
  #@regression @functional @smoke
  #Scenario: As a user, I should see that clipped rewards should show Clipped button in the clipped rewards screen
    #When sign in to the application using account with existing rewards
    #Then verify home screen is displayed
    #And verify Wallet tab bar is displayed
    #When go to Wallet tab
    #Then verify wallet header
    #And verify clipped rewards count
    #When click on Clipped rewards tile
    #Then verify Clipped rewards screen is displayed
    #And verify Clipped button is displayed in clipped rewards screen

  ##C11671 -- this id covers below scenario
  #@regression @functional @smoke
  #Scenario: As a user, I should see Enjoy by <date> if the rewards is used and the clipped button is shown in solid box.
    #When sign in to the application using account with existing rewards
    #Then verify home screen is displayed
    #And verify Wallet tab bar is displayed
    #When go to Wallet tab
    #Then verify wallet header
    #And verify clipped rewards count
    #When click on Clipped rewards tile
    #Then verify Clipped rewards screen is displayed
    #And verify Clipped button is displayed in clipped rewards screen
    #Then verify Enjoy by Date is displayed in the clipped card


  # C11651---- this id covers below scenario
  #@regression @functional @smoke
  #Scenario: As a user, I should see total number of clipped deals in wallet screen
    #When sign in to the application using account with existing rewards
    #Then verify home screen is displayed
    #And verify Wallet tab bar is displayed
    #When go to Wallet tab
    #Then verify wallet header
    #And verify clipped deals count

  ##Marking this as manual, since paycard is session based and it will disappear once user log out
  #@regression @functional
  #Scenario: As a user, I want to see the pay card to be shown on the wallet after setting up my payment method
    #When sign in to the application using account with pay card
    #Then verify home screen is displayed
    #When go to Wallet tab
    #Then verify title of Pay card

  ##Marking this as manual, since paycard is session based and it will disappear once user log out
  #@regression
  #Scenario: As a user, I want to see the pay card to be shown as banner specific
    #When sign in to the application using account with pay card
    #Then click on shopping mode down arrow
    #And select the store which has Pay Card
    #Then go to Wallet tab
    #And flip to pay card
    #Then verify pay card is flipped
    #And verify pay card info is displayed
    #Then verify pay card sub info is displayed
    #And verify pay card Lets do it CTA is displayed

      #Moving this to manual since setting up contactless pay involves inputting otp
#  @regression @functional
#  Scenario: As a user, I should not see the set contactless pay banner on the wallet screen if I have set up contactless pay on my account
#    When sign in to the application using account with existing rewards
#    Then verify home screen is displayed
#    And select the store which has contact less pay banner
#    When go to Wallet tab
#    Then verify wallet header
#    And verify 'Setup contactless pay' banner is not displayed

  #C69885
  @regression
  Scenario: As a User, I should see all the clipped deals and count for the category when navigating from clipped deals to the deals category detail page on tapping the deal tile
    When sign in to the application
    Then verify home screen is displayed
    And go to Wallet tab
    Then verify wallet header
    And click on Clipped deals tile
    And click a category on clipped deals screen
    Then verify deal card in clipped deals categories detail page
    Then verify deal count in clipped deals categories detail page
    Then verify deal category title in clipped deals categories detail page

   #C69886
  @regression
  Scenario: As a User, I should The user must be able to navigate back by clicking on the back button
    When sign in to the application
    Then verify home screen is displayed
    And go to Wallet tab
    Then verify wallet header
    And click on Clipped deals tile
    And click a category on clipped deals screen
    And click back button on clipped deals categories detail page
    Then verify Clipped deals title

  #C28116
  @regression
  Scenario: Killing and relaunching the app. Wallet.
    When sign in to the application using account with existing rewards
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    And verify count on cart Button
    And verify clipped deals count
    Then verify clipped rewards count
    And kill the application
    And relaunch the application
    And click continue option on pop up
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    And verify count on cart Button
    And verify clipped deals count
    Then verify clipped rewards count

  #C30091
  @regression
  Scenario: Killing and relaunching the app. Pay card.
    When sign in to the application using account with contactless pay banner
    Then verify home screen is displayed
    When go to Home tab
    And select the store which has contact less pay banner
    When go to Wallet tab
    Then verify wallet header
    And verify 'Setup contactless pay' banner in Wallet screen
    And click on 'Setup contactless pay' banner in Wallet screen
    And handle tutorial for contact less pay set up
    And user closes pay screen
    Then verify 'Setup contactless pay' banner in Wallet screen
    And kill the application
    And relaunch the application
    And click continue option on pop up
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    And click on 'Setup contactless pay' banner in Wallet screen
    And user closes pay screen
    And verify 'Setup contactless pay' banner in Wallet screen

 #C66404
  @regression
  Scenario: Killing and relaunching the app. Shopping cart.
    When sign in to the application using account with existing rewards
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    And click on My Cart Icon
    And clear cart items
    And close my cart page
    And get the count of cart item in wallet page
    And go to browse tab
    When user expands category "Beverages" on category list
    When user clicks item "Coffee" on aisle list
    When user clicks item "Coffee - Whole Bean" on aisle list
    And add a product on product details page
    When navigate to deals tab
    Then go to Wallet tab
    And get cart count before killing app
    Then kill the application
    And relaunch the application
    And click continue option on pop up
    Then verify home screen is displayed
    And go to Wallet tab
    And get cart count after killing app relaunching and verify if they are same in wallet page

    #C69983
  @regression
  Scenario:  As a User, I should navigate to "Clipped deals" category screen upon tapping "see wallet" CTA from My item page and Sellection should be "All Past Purchase"
    When sign in to the application using account with existing rewards
    Then verify home screen is displayed
    When go to MyItems tab
    And verify my items screen is displayed
    Then click on all past purchases tab
    And verify all past purchases tab selected on My Items page
    Then click on see in wallet
    Then verify Clipped deals screen is displayed

    #C69984
  @regression
  Scenario:  As a User, I should navigate to "Clipped deals" category screen upon tapping "see wallet" CTA from My item page and Sellection should be "My Last Order"
    When sign in to the application using account with existing rewards
    Then verify home screen is displayed
    When go to MyItems tab
    And verify my items screen is displayed
    Then click on my last order tab
    And verify my last orders are displayed
    Then click on see in wallet
    Then verify Clipped deals screen is displayed

    #C69985
  @regression
  Scenario:  As a User, I should navigate to "Clipped deals" category screen upon tapping "see wallet" CTA from My item page and Sellection should be "My List" in in-store mode
    When sign in to the application using account with existing rewards
    Then verify home screen is displayed
    When go to Home tab
    When click on shopping mode down arrow
    And Enter the ZipCode
    When click on right arrow button on zipcode page
    Then select In-Store shopping mode
    Then click on start Shopping Button
    And verify instore shopping mode is selected
    When go to MyItems tab
    And verify my items screen is displayed
    Then Click on my list icon
    And verify my list page is displayed
    Then click on see in wallet
    Then verify Clipped deals screen is displayed


