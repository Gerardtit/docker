Feature: Wallet - Clipped deals and rewards

  #C46220
  @regression @module_wallet @functional @smoke @start_scenario
  Scenario: As a user, I must see the navigation title and header of the Wallet section so that I know where I am in the app
    When sign in to the application using account with existing rewards
    Then verify home screen is displayed
    And select the pick-up store
    And verify Wallet tab bar is displayed
    And go to Wallet in Member tab
    Then verify wallet header

  #C46221
  @regression @module_wallet @functional
  Scenario: The navigation header must stay fixed at the top and should not scroll with the screen scroll.
    When go to Wallet in Member tab
    Then verify wallet header
    Then Scroll down on wallet screen
    And verify wallet header

  #C46292
  @regression @module_wallet @functional @smoke
  Scenario: As a User, I should see cart icon with count of total items added in the cart
    When go to Wallet in Member tab
    Then verify wallet header
    And verify search icon is displayed
    And verify count on cart Button

  #C46293
  @regression @module_wallet @functional @smoke
  Scenario: As a User, I should see cart icon count gets updated without delay on adding/removing items
    And go to Wallet in Member tab
    Then verify wallet header
    And go to cart screen
    And clear cart items
    And close cart screen
    And get the count of cart item in wallet page
    Then verify zero count on cart Button
    And go to Home tab
    When search product "Chicken" on home page
    And add a product on product details page
    Then click back button on product details page
    And click cancel button on product search page
    Then go to Wallet in Member tab
    Then verify wallet header
    Then verify the cart count after adding product in wallet page

  #C46294
  @regression @module_wallet @functional @smoke
  Scenario: As a User, I should navigate to 'My Cart' on tapping on cart icon in wallets screen
    When go to Wallet in Member tab
    Then verify wallet header
    When go to cart screen
    And verify header on cart screen is "Cart"
    And close cart screen

  #C46299
  @regression @module_wallet @functional @smoke
  Scenario: As a User, I should see cart icon with 0 count if no items are added in cart
    And go to Wallet in Member tab
    Then verify wallet header
    And go to cart screen
    And clear cart items
    And close cart screen
    Then verify zero count on cart Button

  #C46230
  @regression @module_wallet @functional @smoke
  Scenario: As a user, on my Loyalty card, I should be able to see title of the card and the QR code
    When go to Wallet in Member tab
    Then verify wallet header
    And verify title of Member card
    Then verify QR code of Loyalty card

  #C46232
  @regression @module_wallet @functional @smoke
  Scenario: As a user, I should be able to see a text informing me of my next step of action & respective banner icon
    When go to Wallet in Member tab
    Then verify wallet header
    And verify Loyalty card information text

  #C46231
  @regression @module_wallet @functional
  Scenario: As a user, I should be able to see the Loyalty card scroll with the screen
    When go to Wallet in Member tab
    Then verify wallet header
    And Scroll down on wallet screen
    Then verify Loyalty card information text

  #C46225
  @regression @module_wallet @functional @smoke
  Scenario: As a user, I should not see the setup contactless pay banner for a Store which does not support ZTP
    When go to Home tab
    And select store which does not have contact less pay banner
    When go to Wallet in Member tab
    Then verify wallet header
    And verify 'Setup contactless pay' banner is not displayed
    And go to Home tab
    And select the pick-up store

  #C46243
  @regression @module_wallet @functional
  Scenario: As a user, I want to see all the deals clipped count on the wallet screen
    When go to Wallet in Member tab
    Then verify wallet header
    And verify clipped deals count

  #C46246
  @regression @module_wallet @functional @smoke
  Scenario: As a user, I should see total number of clipped deals in wallet screen
    When go to Wallet in Member tab
    Then verify wallet header
    And verify clipped deals count

  #C46247
  @regression @module_wallet @functional
  Scenario: As a user, On clicking clipped deals tile I should land on clipped deals screen
    When go to Wallet in Member tab
    Then verify wallet header
    And verify clipped deals count
    When click on Clipped deals tile
    Then verify Clipped deals screen is displayed
    And verify Clipped deals title

  #C46248
  @regression @module_wallet @functional
  Scenario: As a user , I should see that count of clipped deals on wallet screen should be match with count on clipped deals screen
    When go to Wallet in Member tab
    Then verify wallet header
    Then verify count of deals on clipped And Wallet Screen are same

  #C46249
  @regression @module_wallet @functional
  Scenario: Verify the Deal Card in the Clipped Deals section
    When go to Wallet in Member tab
    Then verify wallet header
    And click on Clipped deals tile
    And go to Clipped Deals tab in MyList
    Then verify Clipped deals screen is displayed
    And click a category on clipped deals screen
    And verify deal title in clipped deals section
    Then verify deal description in clipped deals section
    And verify deal expiry date in clipped deal section

  #C46250
  @regression @module_wallet @functional @smoke
  Scenario: As a user , On clicking back button on clipped deals screen I should be navigated to wallet screen
    When go to Wallet in Member tab
    Then verify wallet header
    And verify clipped deals count
    When click on Clipped deals tile
    Then verify Clipped deals screen is displayed
    When go to Wallet in Member tab
    Then verify wallet header
    Then verify clipped deals count

   #C46349
  @regression @module_wallet
  Scenario: As a User, I should see all my clipped deals organised by categories Alphabetically in Wallet->Clipped screen
    Then go to Wallet in Member tab
    Then verify wallet header
    And click on Clipped deals tile
    Then verify clipped deals are sorted by categories

  #C46350
  @regression @module_wallet
  Scenario: As a User, I should see Special offers must be shown at the top if there are clipped deals underneath it.
    Then go to Wallet in Member tab
    Then verify wallet header
    And click on Clipped deals tile
    And go to Clipped Deals tab in MyList
    Then verify deal category "Special Offers" shown at the top in 'Clipped Deals' categories

  #C46356
  @regression @module_wallet
  Scenario: As a User, I should see 'Deal Detail page' on tapping any clipped deal card
    And go to Wallet in Member tab
    Then verify wallet header
    And click on Clipped deals tile
    And go to Clipped Deals tab in MyList
    And click a category on clipped deals screen
    And click on first deal card displayed in the category
    Then verify deal detail page is displayed
    And close deal details page

  #C46357
  @regression @module_wallet
  Scenario: As a User, I should be able to do Pull to refresh the deals
    Then go to Wallet in Member tab
    Then verify wallet header
    When click on Clipped deals tile
    And go to Clipped Deals tab in MyList
    Then refresh the page and verify progress spinner is displayed
    And verify progress spinner is not displayed after waiting for few seconds
    And verify Clipped deals screen is displayed
    And verify My Cart icon is displayed
    And verify clipped deals count is displayed on clipped deals screen
    And verify category name and count is displayed for category on clipped deals screen

  #C69655
  @regression @module_wallet
  Scenario: As a existing user, I should see the Clipped rewards and Clipped Deals section switched to the top of the screen
    Then go to Wallet in Member tab
    Then verify wallet header
    And verify Clipped deals and Clipped rewards section is present at the top

  #C69656
  @regression @module_wallet @functional
  Scenario:As a existing user, I should see the Clipped deals screen on clicking See all CTA when Clipped deal count is more than 1
    When go to Wallet in Member tab
    Then verify wallet header
    And verify clipped deals count
    Then verify See all CTA is displayed in deals section
    When click See all button in deals section
    Then verify Clipped deals screen is displayed
    And verify Clipped deals title

  #C69657
  @regression @module_wallet @functional
  Scenario:As a existing user, I should see the Clipped rewards screen on clicking See all CTA when Clipped rewards count is more than 1
    When go to Wallet in Member tab
    Then verify wallet header
    And verify clipped rewards count
    Then verify See all CTA is displayed in rewards section
    When click See all button in rewards section
    Then verify Clipped rewards screen is displayed
    And verify Clipped rewards title

  #C69885
  @regression @module_wallet
  Scenario: As a User, I should see all the clipped deals and count for the category when navigating from clipped deals to the deals category detail page on tapping the deal tile
    And go to Wallet in Member tab
    Then verify wallet header
    And click on Clipped deals tile
    And go to Clipped Deals tab in MyList
    And click a category on clipped deals screen
    Then verify deal card in clipped deals categories detail page
    Then verify deal count in clipped deals categories detail page
    Then verify deal category title in clipped deals categories detail page

  #C69886
  @regression @module_wallet
  Scenario: As a User, I should The user must be able to navigate back by clicking on the back button
    And go to Wallet in Member tab
    Then verify wallet header
    And click on Clipped deals tile
    And go to Clipped Deals tab in MyList
    And click a category on clipped deals screen
    And click back button on clipped deals categories detail page
    Then verify Clipped deals title

  #C46236
  @regression @module_wallet @functional
  Scenario: As a user, if there are more than 0 active clipped redeemed rewards, user should see " # Clipped Rewards"
    When go to Wallet in Member tab
    Then verify wallet header
    And verify clipped rewards count

  #C46262
  @regression @module_wallet @functional @smoke
  Scenario: As a user, On clicking Clipped rewards tile I should land on clipped rewards screen
    When go to Wallet in Member tab
    Then verify wallet header
    When click on Clipped rewards tile
    Then verify Clipped rewards screen is displayed
    And verify Clipped rewards title

  #C46263
  @regression @module_wallet @functional
  Scenario: As a user , I should see that the count of clipped rewards on wallet screen should be match with count on clipped rewards screen
    When go to Wallet in Member tab
    Then verify wallet header
    And verify count of rewards on clipped And Wallet Screen are same

  #C46264
  @regression @module_wallet @functional
  Scenario: As a user, I should see that clipped rewards should show Clipped button in the clipped rewards screen
    When go to Wallet in Member tab
    Then verify wallet header
    And verify clipped rewards count
    When click on Clipped rewards tile
    Then verify Clipped rewards screen is displayed
    And verify Clipped rewards title
    And verify Clipped button is displayed in clipped rewards screen

  #C46265
  @regression @module_wallet @functional
  Scenario: As a user, I should see Enjoy by <date> if the rewards is used and the clipped button is shown in solid box.
    When go to Wallet in Member tab
    Then verify wallet header
    And verify clipped rewards count
    When click on Clipped rewards tile
    Then verify Clipped rewards screen is displayed
    And verify Clipped rewards title
    Then verify Enjoy by Date is displayed in the clipped card

  #C46266
  @regression @module_wallet @functional @smoke
  Scenario: As a user , On clicking back button on clipped rewards screen I should be navigated to wallet screen
    When go to Wallet in Member tab
    Then verify wallet header
    And verify clipped rewards count
    When click on Clipped rewards tile
    Then verify Clipped rewards screen is displayed
    And click back button on Clipped rewards page
    Then verify wallet header

  #C46340
  @regression @module_wallet @functional
  Scenario: As a user, On clicking clipped rewards I should be navigated to clipped rewards screen and clipped rewards count should be same
    When go to Wallet in Member tab
    Then verify wallet header
    And verify count of rewards on clipped And Wallet Screen are same

  #C66405
  @regression @module_wallet
  Scenario: Verify that the Wallet Landing page is per Figma design
    When go to Wallet in Member tab
    Then verify wallet header
    And verify clipped deals count
    Then verify clipped rewards count
    And verify See all CTA is displayed in deals section
    Then verify See all CTA is displayed in rewards section
    And verify title of Member card
    Then verify Loyalty card information text
    And verify QR code of Loyalty card

  #C30077
  @regression @module_wallet
  Scenario: Check the spinner is getting displayed in "Wallet "page when the Data is being Loaded
    When go to Wallet in Member tab
    Then verify wallet header
    When refresh the page and verify progress spinner is displayed

  #C28116
  @regression @module_wallet
  Scenario: Killing and relaunching the app. Wallet.
    When go to Wallet in Member tab
    Then verify wallet header
    And verify count on cart Button
    And verify clipped deals count
    Then verify clipped rewards count
    And kill and relaunch the application without popup handling
    And handle zip code page if displayed
    And click Continue on cache pop up
    And handle tutorial if displayed
    When go to Wallet in Member tab
    Then verify wallet header
    And verify count on cart Button
    And verify clipped deals count
    Then verify clipped rewards count

  #C66404
  @regression @module_wallet
  Scenario: Killing and relaunching the app. Shopping cart.
    When go to Wallet in Member tab
    Then verify wallet header
    And go to cart screen
    And clear cart items
    And close cart screen
    And get the count of cart item in wallet page
    And go to Home tab
    When search product "Chicken" on home page
    And add a product on product details page
    And click back button on product details page
    And click cancel button on product search page
    And go to Wallet in Member tab
    Then verify wallet header
    And get cart count before killing app
    And kill and relaunch the application without popup handling
    And click Continue on cache pop up
    And handle tutorial if displayed
    And go to Wallet in Member tab
    And get cart count after killing app relaunching and verify if they are same in wallet page

  #C46298
  @regression @module_wallet @functional @end_scenario
  Scenario: Keeping the app in background and relaunching
    Then go to Wallet in Member tab
    Then verify wallet header
    And get cart count Before keeping app in Background
    Then keep app in background and relaunching the same
    And get cart count after keeping app in foreground and verify if they are same in wallet page
    When click on Clipped deals tile
    Then verify Clipped deals screen is displayed
    And keep app in background and relaunching the same
    And verify Clipped deals title
    Then go to Wallet in Member tab
    And click on Clipped rewards tile
    Then verify Clipped rewards screen is displayed
    And keep app in background and relaunching the same
    Then verify Clipped rewards title
