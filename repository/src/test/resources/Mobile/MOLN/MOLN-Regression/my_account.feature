@account
Feature: My Account Feature

#  Background: setup user on Home Page
#    When navigate to home page
#    Then home page is displayed
#    When user click menu button on home page
#    Then menu page is displayed
#    When user clicks account on menu page
#    Then my account page is displayed

  Background: setup user on SignIn Page
    When click on NewSignup for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    And user click delivery option
    And user click start shopping button on After Signup
    Then verify MFA home screen is displayed
    When user click menu button on home page
    Then menu page is displayed
    When user clicks account on menu page
    Then my account page is displayed


  @regression
  Scenario: check and verify items displayed on account page
    When user verify savings summery is displayed on account page
    And user verify address window is displayed on account page
    And user verify Dug store info is displayed on account page
    And user verify phone number used in store is displayed
    And user verify email address is displayed on account page
    And user verify communication preference is displayed on account page
    And user verify password security is displayed on account page

  @regression
  Scenario: change phone number in store but not save - click no
    Given user verify phone number used in store is displayed
    When user click edit phone number on account page
    Then phone number edit window is displayed
    When user edit and confirm new phone number on account edit window
    And user clicks back button on store phone edit window
    When popup save confirm message
    And user select "no" on save confirm window
    Then my account page is displayed
    And user verify phone number used in store is displayed
    And user verify original phone number is displayed

  @regression
  Scenario: save new store phone number - click yes
    Given user verify phone number used in store is displayed
    When user click edit phone number on account page
    Then phone number edit window is displayed
    When user edit and confirm new phone number on account edit window
    And user clicks back button on store phone edit window
    When popup save confirm message
    And user select "yes" on save confirm window
    Then my account page is displayed
    And user verify phone number used in store is displayed
    And user verify new phone number is displayed

  @regression
  Scenario: update the store phone number to original using save button
    Given user verify phone number used in store is displayed
    When user click edit phone number on account page
    Then phone number edit window is displayed
    When user edit and confirm saved phone number on account edit window
    And user click save button on account edit window
    Then my account page is displayed
    And user verify phone number used in store is displayed
    And user verify original phone number is displayed

  @regression
  Scenario: change contact phone number but not save - click no
    Given user verify contact phone number is displayed
    When user click edit contact phone number on account page
    Then contact phone number edit window is displayed
    When user edit new contact phone number on account edit window
    And user clicks back button on store phone edit window
    When popup save confirm message
    And user select "no" on save confirm window
    Then my account page is displayed
    Given user verify contact phone number is displayed
    And user verify original contact phone number is displayed

  @regression
  Scenario: save new contact phone number - click yes
    Given user verify contact phone number is displayed
    When user click edit contact phone number on account page
    Then contact phone number edit window is displayed
    When user edit new contact phone number on account edit window
    And user clicks back button on store phone edit window
    When popup save confirm message
    And user select "yes" on save confirm window
    Then my account page is displayed
    Given user verify contact phone number is displayed
    And user verify new contact phone number is displayed

  @account
  Scenario: New contact phone number saved in my Account page should matches the contact phone number on checkout page
    Given user verify contact phone number is displayed
    When user click edit contact phone number on account page
    Then contact phone number edit window is displayed
    When user edit new contact phone number on account edit window
    And user clicks back button on store phone edit window
    When popup save confirm message
    And user select "yes" on save confirm window
    Then my account page is displayed
    And user press back button
    And user press back button
    When user clicks search bar on home page
    And user types "Chicken" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "20" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks contact on checkout page
    Then checkout contact phone number should be same as the My Account phone number


  @regression
  Scenario: update the contact phone number to original - use save button
    Given user verify contact phone number is displayed
    When user click edit contact phone number on account page
    Then contact phone number edit window is displayed
    When user edit original contact phone number on account edit window
    And user click save button on account edit window
    Then my account page is displayed
    Given user verify contact phone number is displayed
    And user verify original contact phone number is displayed


  @regression
  Scenario: change address but not save - click no
    And user verify address window is displayed on account page
    When user click edit address on account page
    Then "Address Book" window is displayed
    When user clicks "Edit" text on page
    Then "Edit Delivery Address" window is displayed
    When user edit new address on edit delivery address page
    And user clicks back button on store phone edit window
    When popup save confirm message
    And user select "no" on save confirm window
    Then "Address Book" window is displayed
    When navigate back to previous level from address book page
    Then my account page is displayed
    And user verify address window is displayed on account page
    And user verify original address is displayed

  @regression
  Scenario: save new address on account - click yes
    And user verify address window is displayed on account page
    When user click edit address on account page
    Then "Address Book" window is displayed
    When user clicks "Edit" text on page
    Then "Edit Delivery Address" window is displayed
    When user edit new address on edit delivery address page
    And user clicks back button on store phone edit window
    When popup save confirm message
    And user select "yes" on save confirm window
    Then "Address Book" window is displayed
    When navigate back to previous level from address book page
    Then my account page is displayed
    And user verify address window is displayed on account page
    And user verify new address is displayed

  @regression
  Scenario: update the address to original - click save
    And user verify address window is displayed on account page
    When user click edit address on account page
    Then "Address Book" window is displayed
    When user clicks "Edit" text on page
    Then "Edit Delivery Address" window is displayed
    When user edit original address on edit delivery address page
    And user click save button on account edit window
    Then "Address Book" window is displayed
    When navigate back to previous level from address book page
    Then my account page is displayed
    And user verify address window is displayed on account page
    And user verify original address is displayed

  @regression
  Scenario: update email address not save - click no
    Given user verify email address is displayed on account page
    When user clicks "Email Address" text on page
    Then "Email Address" window is displayed
    When user edit new email on account edit window
    And user clicks back button on store phone edit window
    When popup save confirm message
    And user select "no" on save confirm window
    Then my account page is displayed
    And user verify email address is displayed on account page
    And user verify original email is displayed on account page

  @regression
  Scenario: update email address - click yes and save
    Given user verify email address is displayed on account page
    When user clicks "Email Address" text on page
    Then "Email Address" window is displayed
    When user edit new email on account edit window
    And user clicks back button on store phone edit window
    When popup save confirm message
    And user select "yes" on save confirm window
    Then my account page is displayed
    And user verify email address is displayed on account page
    And user verify new email is displayed on account page
    # click save
    When user clicks "Email Address" text on page
    Then "Email Address" window is displayed
    When user edit original email on account edit window
    And user click save button on account edit window
    Then my account page is displayed
    And user verify email address is displayed on account page
    And user verify original email is displayed on account page

  @regression
  Scenario: change password but not save
    Given user verify password security is displayed on account page
    When user click edit password on account page
    Then password edit window is displayed
    When user edit new password on account edit window
    And user clicks back button on store phone edit window
    When popup save confirm message
    And user select "no" on save confirm window
    Then my account page is displayed

  @regression
  Scenario: change password with less than 8
    Given user verify password security is displayed on account page
    When user click edit password on account page
    Then password edit window is displayed
    When user edit new password "pa1234" on account edit window
    And user click save button on account edit window
    Then password error is displayed on account edit page

  @regression
  Scenario: change password - click yes and save button
    Given user verify password security is displayed on account page
    When user click edit password on account page
    Then password edit window is displayed
    When user edit new password on account edit window
    And user clicks back button on store phone edit window
    When popup save confirm message
    And user select "yes" on save confirm window
    Then my account page is displayed
    And user verify password security is displayed on account page
    When user click edit password on account page
    Then password edit window is displayed
    When user edit original password on account edit window
    And user click save button on account edit window
    Then my account page is displayed

  @regression
  Scenario: communication preference
    Given user verify communication preference is displayed on account page
    When user clicks "Communication Preferences" text on page
    Then "Communication Preferennces" window is displayed
    And "Push Notifications" toggle switch is displayed
    And "Weekly Specials" toggle switch is displayed
    And "just for U" toggle switch is displayed
    And "Grocery Delivery" toggle switch is displayed
    And "just for U Product Recalls" toggle switch is displayed

  @regression
  Scenario: chat bot from my account page
    When user clicks Need Help Chatbot on current page
    Then "Chat" window is displayed