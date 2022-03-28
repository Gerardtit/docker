Feature: My Rewards - User with reward balance

  #Out of scope in new rewards UI
#  #C66533
#  @regression @start_scenario
#  Scenario: As a User, I should see section with title 'More points, please' in My Rewards dashboard
#    When sign in to the application using account with existing rewards
#    Then verify home screen is displayed
#    And click on deals tab
#    And click on for you tab
#    And click on "My rewards" link in carousel on For you page
#    Then verify FAQ Description is not displayed
#    When scroll down to FAQ
#    Then verify FAQ Description

  #C66537
  @regression @start_scenario
  Scenario: As a User, I should be able to navigate to FAQ screen on tapping on 'Go to FAQ' button
    When sign in to the application using account with existing rewards
    Then verify home screen is displayed
    When click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    Then verify Rewards carousel header and sub header on For U
    When click on new rewards bar if displayed
    And scroll down to FAQ
    And click on FAQ button
    Then verify FAQ page is displayed
    And click back button from how for u

  #C66519
  @regression
  Scenario: As a user, i should see 'Point become Rewards' section at bottom of the My rewards dashboard if i have earned the rewards
    And click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    Then verify program details description

  #Out of scope in new rewards UI
#    #C66440
#  @smoke @regression
#  Scenario: As a user, I should be able to see ' Program detail screen', on click of 'info(i) button for Recurring/existing user
#    And click on deals tab
#    And click on for you tab
#    And click on "My rewards" link in carousel on For you page
#    Then verify reward info button is displayed
#    And go to rewards info section
#    Then verify program details title

  #C66437
  @smoke @regression
  Scenario: As a user, I should able to see the existing 'Program detail screen' has integrated from the rewards app
    And click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    And go to rewards info section
    And click on new rewards bar if displayed
    Then verify program details title

  #C66663
  @regression
  Scenario: As a User, I should see maximum of 15 rewards to be displayed in 'You've earned it' module in My Rewards Dashboard
    And click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    Then verify rewards count in carousel

  #C66683
  @regression
  Scenario: As a User, I should see 'Clip' CTA when reward card needs '10 rewards' to redeem and reward balance is more than/equal to required rewards to redeem
    And click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    Then verify 'Clip' CTA displayed when available balance is greater than required balance

  #C66563
  @regression
  Scenario: As a user, I Should see gas reward card with static text on my rewards dashboard section
    And click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    Then verify the static text on Reward Gas Card

  #C66751
  @regression
  Scenario: As a user, I want to see Reward card CTA text 'Redeem' should change to 'Clip' in Rewards landing page, rewards listing screen and on wallet
    And click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    Then verify clip CTA is displayed
    And scroll down to See All Reward Button
    When click on 'See All Reward' Button
    Then verify clip CTA is displayed
    When go to Wallet tab
    Then verify wallet header
    And click on Clipped rewards tile
    And verify Clipped button is displayed in clipped rewards screen

    #Out of scope in new Home Page UI
#  #C66661
#  @regression @smoke
#  Scenario: As a User, I should see the module 'You've earned it' in My Rewards Dashboard
#    And click on deals tab
#    And click on for you tab
#    And click on "My rewards" link in carousel on For you page
#    Then verify user is able to see 'You've earned it'
#    Then verify user is able to see Discount Title on Reward card
#    Then verify user is able to see Description on Reward card
#    Then verify user is able to see Expiry Date on Reward card
#    Then verify user is able to see Subject Line on Reward card

  #C66481
  @regression
  Scenario: As a user, I should view see all rewards CTA at the bottom of You've earned it module
    And click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    And scroll down to See All Reward Button
    Then verify See All Reward button is displayed

  #C66487
  @regression
  Scenario: As a User, on click of 'See all Rewards' button in 'My Rewards' module , I should be able to see 'Reward Listing Screen' accordingly
    And click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    Then scroll down to See All Reward Button
    When click on 'See All Reward' Button
    Then verify user is in Reward Listing screen
    Then verify user is able to see Navigation Bar

  #C66623
  @regression @smoke
  Scenario: As a User, i should be able to navigate to rewards listing screen on clicking on See all rewards CTA in the rewards screen(User with rewards)
    And click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    Then scroll down to See All Reward Button
    And click on 'See All Reward' Button
    Then verify user is in Reward Listing screen

  #C66438
  @regression
  Scenario: As a User, I should be able to see 'info(i)' button is as same as UX and match with all banners
    And click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    Then verify reward info button is displayed

  #C66452
  @regression
  Scenario: As a user, I should see the UI of reward navigation bar and reward card as per UX design and match with respective banner
    And click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    Then scroll down to See All Reward Button
    And click on 'See All Reward' Button
    Then verify user is in Reward Listing screen
    Then verify reward category list
    Then verify user is able to see Discount Title on Reward card
    Then verify user is able to see Description on Reward card
    Then verify user is able to see Expiry Date on Reward card
    Then verify user is able to see Subject Line on Reward card

  #C66753
  @regression
  Scenario: As a user, I want to see my Rewards screen and rewards listing screen as per the UX design and as per the benner theme
    And click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    Then verify rewards balance when user has one or more rewards
    Then verify expiring date
    Then verify user is able to see Discount Title on Reward card
    Then verify user is able to see Description on Reward card
    Then verify user is able to see Expiry Date on Reward card
    Then verify user is able to see Subject Line on Reward card
    And scroll down to See All Reward Button
    Then verify See All Reward button is displayed
    And click on 'See All Reward' Button
    Then verify user is in Reward Listing screen
    Then verify reward category list
    Then verify user is able to see Discount Title on Reward card
    Then verify user is able to see Description on Reward card
    Then verify user is able to see Expiry Date on Reward card
    Then verify user is able to see Subject Line on Reward card

  #C66723
  @regression
  Scenario: As a user, i should see that the rewards screen is as per the respective banner theme and as per UX design
    And click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    Then verify rewards balance when user has one or more rewards
    Then verify expiring date
    Then verify rewards progress bar
    Then verify user is able to see Discount Title on Reward card
    Then verify user is able to see Description on Reward card
    Then verify user is able to see Expiry Date on Reward card
    Then verify user is able to see Subject Line on Reward card
    And scroll down to See All Reward Button
    Then verify See All Reward button is displayed

  #C66457
  @regression @functional
  Scenario: As a user, I should see all reward categories on reward navigation bar on killing and relaunching and also keeping app in the background to foreground
    And click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    Then scroll down to See All Reward Button
    And click on 'See All Reward' Button
    Then verify user is in Reward Listing screen
    Then verify reward category list
    When keep app in background and relaunching the same
    Then verify reward category list
    And kill and relaunch the application without popup handling
    And handle zip code page if displayed
    And handle tutorial if displayed
    Then click on cancel button if feedback form is displayed
    And click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    Then scroll down to See All Reward Button
    And click on 'See All Reward' Button
    Then verify user is in Reward Listing screen
    Then verify reward category list

  #C66485
  @regression @functional
  Scenario: As a user, I should see UI of see all rewards CTA at the bottom of You've earned it module on killing and relaunching the app , background and foreground the app, after network error
    And click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    And scroll down to See All Reward Button
    Then verify See All Reward button is displayed
    When keep app in background and relaunching the same
    Then verify See All Reward button is displayed
    And kill and relaunch the application without popup handling
    And handle zip code page if displayed
    And handle tutorial if displayed
    And click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    And scroll down to See All Reward Button
    Then verify See All Reward button is displayed

  #C66505
  @regression @functional
  Scenario: As a User, I should be able to see 'Reward Listing ' screen accordingly after kill and relaunch app, Background and Foreground the APP
    And click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    And scroll down to See All Reward Button
    And click on 'See All Reward' Button
    Then verify user is in Reward Listing screen
    When move app to background and then bring it to foreground
    Then verify user is in Reward Listing screen
    Then verify reward category list
    Then verify user is able to see Discount Title on Reward card
    Then verify user is able to see Description on Reward card
    Then verify user is able to see Expiry Date on Reward card
    Then verify user is able to see Subject Line on Reward card
    Then kill and relaunch the application without popup handling
    And handle zip code page if displayed
    And handle tutorial if displayed
    And click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    And scroll down to See All Reward Button
    And click on 'See All Reward' Button
    Then verify user is in Reward Listing screen
    Then verify reward category list
    Then verify user is able to see Discount Title on Reward card
    Then verify user is able to see Description on Reward card
    Then verify user is able to see Expiry Date on Reward card
    Then verify user is able to see Subject Line on Reward card

  #C66502
  @regression
  Scenario: As a User, I should be able to see 'Reward Listing' Screen according to selected banner theme
    And click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    And scroll down to See All Reward Button
    And click on 'See All Reward' Button
    Then verify user is in Reward Listing screen
    Then verify reward category list
    Then verify user is able to see Discount Title on Reward card
    Then verify user is able to see Description on Reward card
    Then verify user is able to see Expiry Date on Reward card
    Then verify user is able to see Subject Line on Reward card

  #C66734
  @regression @functional
  Scenario: As a user, i should be able to retain the clipped state after keep the app in the background and getting it to the forefront, i should be able to kill and relaunch the app
    And click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    And scroll down to See All Reward Button
    And click on 'See All Reward' Button
    Then verify user is in Reward Listing screen
    And go to Wallet tab
    Then click on Clipped rewards tile
    Then verify clipped button on reward card
    And keep app in background and relaunching the same
    Then verify clipped button on reward card
    When kill and relaunch the application without popup handling
    And handle zip code page if displayed
    And handle tutorial if displayed
    And click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    And scroll down to See All Reward Button
    And click on 'See All Reward' Button
    Then verify user is in Reward Listing screen
    And go to Wallet tab
    Then click on Clipped rewards tile
    Then verify clipped button on reward card

  #C70005
  @regression
  Scenario: As a user, I should able to see updated UI for Rewards as per the design and respective banner
    And click on deals tab
    And click on for you tab
    When click on "My rewards" link in carousel on For you page
    Then verify reward info button is displayed
    Then verify reward page title
    Then verify rewards balance when user has one or more rewards
    Then verify expiring date
    Then verify rewards progress bar
    Then verify user is able to see Discount Title on Reward card
    Then verify user is able to see Description on Reward card
    Then verify user is able to see Expiry Date on Reward card
    Then verify user is able to see Subject Line on Reward card
    And scroll down to See All Reward Button
    Then verify See All Reward button is displayed

    # back step is added as on tappping rewards from home user navigting to the clip rewards screen not on Rewards screen
  #C70216
  @regression @smoke
  Scenario: As a user, I should see navigate to home screen by tapping home icon from rewards screen [With Rewards]
    And go to Home tab
    When click "My rewards" link in shortcuts tray on home page
    And click back button from my rewards
    Then verify rewards balance when user has one or more rewards
    Then click on home tab
    And verify dashboard page is displayed

    #Below Test case is not applicable as now rewards count will not display in home
    #C70296
  @regression
  Scenario: As a user, I should able to see clipped rewards count on dynamic drawer with rewards CTA
    Then click on home tab
    Then verify my reward count in the drawer is displayed

    #C66422
  @regression
  Scenario: As a user, I should be able to see 'Rewards earn count', Rewards History, Reward Balance and relaunching the app for 'Recurring/Existing user'
    And click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    Then verify rewards balance when user has one or more rewards
    Then verify expiring date
    Then verify rewards progress bar
    Then verify updated time and date

  #C66695
  @regression
  Scenario: As a user, I should be able to see updated time and date on My rewards module indicating last time when was the rewards module got updated
    And click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    Then verify updated time and date

    #C66729
  @regression @smoke
  Scenario: As a user, i should see Clip, Clipped and CTA on the reward cards if the reward based on the clip/clipped state, and Need ** Rewards CTA based on the reward balance
    And click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    And scroll down to See All Reward Button
    When click on 'See All Reward' Button
    Then verify clip CTA is displayed
   # Then tap on close button
    When click back button on Redeem Reward Page
    When click on home tab
    When forced sign out from the application
    When sign in to the application using account with no rewards
    Then verify home screen is displayed
    And click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    And scroll down to See All Reward Button
    When click on 'See All Reward' Button
    Then verify user is able to see 'Need X Reward' text on CTA Button

   #C70107
  @regression @functional @miniRegression
  Scenario: As a user I should navigate to My rewards screen from Home and deals screen
    When forced sign out from the application
    And sign in to the application using account with existing rewards
    And go to Home tab
    Then click "My rewards" link in shortcuts tray on home page
    Then verify Clip rewards screen
    Then click on deals tab
    Then go to 'For you' Tab
    And click on "My rewards" link in carousel on For you page
    And verify reward page title

    #C70104
  @regression @functional @miniRegression
  Scenario: As a user, I should be able clip rewards from rewards detail screen
    When forced sign out from the application
    And sign in to the application using account with existing rewards
    And go to Home tab
    Then click "My rewards" link in shortcuts tray on home page
    Then click back button from my rewards
    Then verify rewards balance is decreased after clipping a reward in rewards detail screen
    Then click on deals tab
    Then click on for you tab
    Then click on "My rewards" link in carousel on For you page
    Then verify rewards balance is decreased after clipping a reward in rewards detail screen
    And verify clipped rewards count is increased in wallet Page after clipping a reward in rewards detail screen

     #C70105
  @regression @functional @miniRegression
  Scenario: As a user, I should be able clip rewards from rewards caresoul screen
    And click on deals tab
    And click on for you tab
    And click on "My rewards" link in carousel on For you page
    Then verify reward page title
    Then verify rewards balance is decreased after clipping a reward in carousel screen
    Then click on deals tab
    Then go to 'All Deals' Tab
    And click on "My rewards" link in carousel on For you page
    Then verify rewards balance is decreased after clipping a reward in carousel screen
    And verify clipped rewards count is increased in wallet Page after clipping a reward in carousel screen

     #C70106
  @regression @functional @miniRegression
  Scenario: As a user, I should be able clip rewards from rewards navigation bar

    And go to Home tab
    Then click on reward link
    #Then verify reward page title
    Then verify rewards balance is decreased after clipping a reward from rewards navigation bar
    Then click on deals tab
    Then go to 'All Deals' Tab
    And click on "My rewards" link in carousel on For you page
    Then verify rewards balance is decreased after clipping a reward from rewards navigation bar
    And verify clipped rewards count is increased in wallet Page after clipping a reward from rewards navigation bar

     #C70110
  @regression @functional @smoke12
  Scenario: As a User, I should able to clip rewards in "you've earned it', navigating from deals screen
    And click on deals tab
    Then go to 'All Deals' Tab
    And click on "My rewards" link in carousel on For you page
    Then verify rewards balance is decreased after clipping a reward in carousel screen
    And verify clipped rewards count is increased in wallet Page after clipping a reward in carousel screen

     #C70111
  @regression @functional
  Scenario: As a User, I should able to scroll till end for all rewards tab in "Clip rewards" screen
    And click on home tab
    Then click on deals tab
    Then go to 'All Deals' Tab
    And click on "My rewards" link in carousel on For you page
    Then scroll down to See All Reward Button
    Then click on 'See All Reward' Button
    Then verify Clip rewards screen
    Then scroll till end for all rewards tab in Clip Rewards screen

    #C70112
  @regression @functional
  Scenario: As a User, I should able to clip rewards in "Clip rewards screen", navigating from deals screen.
    And click on home tab
    Then click on deals tab
    Then go to 'All Deals' Tab
    Then click on "My rewards" link in carousel on For you page
    Then verify rewards balance is decreased after clipping a reward in clip rewards screen
    And verify clipped rewards count is increased in wallet Page after clipping a reward in clip rewards screen

    #C70113
  @regression @functional
  Scenario: As a User, I should able to navigate to 'my rewards' screen from all possible places
    When click on home tab
    And click "My rewards" link in shortcuts tray on home page
    And click back button from my rewards
    Then verify reward page title
    When click on deals tab
    And go to 'All Deals' Tab
    And click on "My rewards" link in carousel on For you page
    Then verify reward page title
    When click on deals tab
    And go to 'For you' Tab
    And click on "My rewards" link in carousel on For you page
    Then verify reward page title

     #C70114
  @regression @functional
  Scenario: As a User, I should able to send the app background abd bring it to foregroung and see reward count should same.
    And click on home tab
    Then click on deals tab
    Then go to 'All Deals' Tab
    And click on "My rewards" link in carousel on For you page
    Then scroll down to See All Reward Button
    Then click on 'See All Reward' Button
    Then click on Clip CTA in Clip Rewards Screen
    Then verify rewards balance in my rewards screen is the same after sending the app to the background and coming back to the my rewards screen

  #C70115
  @regression @functional
  Scenario: As a User, I should able to see reward count should same after killing the app.
    And click on home tab
    Then click on deals tab
    Then go to 'All Deals' Tab
    Then click on "My rewards" link in carousel on For you page
    Then scroll down to See All Reward Button
    Then click on 'See All Reward' Button
    Then click on Clip CTA in Clip Rewards Screen
    Then verify rewards balance in my rewards screen is the same after killing the app and coming back to the my rewards screen

    #C70117
  @regression @functional
  Scenario: As a User, I should able to see clip both of the rewards at same time
    And go to Home tab
    Then click on deals tab
    Then go to 'All Deals' Tab
    Then click on "My rewards" link in carousel on For you page
    Then verify rewards balance is decreased after clipping several rewards in clip rewards screen

    #C70119
  @regression @functional @end_scenario
  Scenario: As a user i should see the count of clipped rewards and should not see any crash upon screen navigations form deals scre
    And click on home tab
    Then click on deals tab
    Then go to 'All Deals' Tab
    Then click on "My rewards" link in carousel on For you page
    Then verify reward page title
    Then verify rewards balance is decreased after clipping a reward in rewards detail screen
    Then click on deals tab
    Then go to 'All Deals' Tab
    Then click on "My rewards" link in carousel on For you page
    Then verify rewards balance is decreased after clipping a reward in carousel screen
    Then go to Wallet tab
    And verify clipped rewards count is increased in wallet Page after clipping a reward in rewards detail screen
    Then go to Wallet tab
    And verify clipped rewards count is increased in wallet Page after clipping a reward in carousel screen

  @regression4 @functional
  Scenario: As a user, I should be able clip rewards after tapping cancel in rewards popup
    #And verify home screen is displayed
    #And forced sign out from the application
    And sign in to the application using account with existing rewards
    And verify home screen is displayed
    Then click "My rewards" link in shortcuts tray on home page
    Then click back button from my rewards
    Then Verify user is able to clip rewards after tapping cancel in popup
