@MyAccount
Feature: My Account Feature

#  Background: setup user on SignIn Page
#    When navigate to home page
#    Then home page is displayed
#    When user click menu button on home page
#    Then menu page is displayed
#    When user clicks account on menu page
#    Then my account page is displayed

  Background: setup user on SignIn Page
    When  Launch the MFA app
    And click on existing user signin for OTP
    Then verify MFA home screen is displayed

  @edit_address
  Scenario: Updated Address saved in my Account page should matches the address on checkout page
    When user clicks Shopping mode option on home page
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    And user click delivery option
    And user click start shopping button on After Signup
    Then verify MFA home screen is displayed
    When user click menu button on home page
    Then menu page is displayed
    When user clicks account on menu page
    Then my account page is displayed
    And user verify address window is displayed on account page
    When user click edit address on account page
    When user clicks "Edit" text on page
    When user edit address on edit delivery address page
    And user clicks back button on store phone edit window
    When popup save confirm message
    And user select "yes" on save confirm window
    And user press back button
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
    When user clicks "Order Info" text on page
    Then "Order Info" window is displayed
    When user clicks "Edit" text on page
    Then "Address Book" window is displayed
    When user clicks "Edit" text on page
    Then verify updated Address saved in Account page matches the address on checkout page
    And user press back button
    And user press back button

   #account information is verified displayed
  @smoke
  Scenario: check and verify items displayed on account page
    And user clicks on member tab
    Then user navigates to personal info screen
    When user verify savings summery is displayed on account page
    And user verify address window is displayed on account page
    And user verify Dug store info is displayed on account page
    And user verify phone number used in store is displayed
    And user verify email address is displayed on account page
    And user verify communication preference is displayed on account page
    And user verify password security is displayed on account page


    #update phone number click no
  @smoke
  Scenario: change phone number in store but not save
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


    #update phone number click yes
  @smoke
  Scenario: save new store phone number
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


    #restore phone number
  @smoke
  Scenario: update the store phone number to original
    Given user verify phone number used in store is displayed
    When user click edit phone number on account page
    Then phone number edit window is displayed
    When user edit and confirm saved phone number on account edit window
    And user click save button on account edit window
    Then my account page is displayed
    And user verify phone number used in store is displayed
    And user verify original phone number is displayed


 #update contact phone number click no
  @smoke
  Scenario: change contact phone number but not save
    Given user verify contact phone number is displayed
    When user click edit contact phone number on account page
    Then contact phone number edit window is displayed
    When user edit new contact phone number on account edit window
    And user clicks back button on store phone edit window
    When popup save confirm message
    And user select "no" on save confirm window
    #And user click save button on account edit window
    Then my account page is displayed
    Given user verify contact phone number is displayed
    And user verify original contact phone number is displayed


    #update contact phone number click yes
  @smoke
  Scenario: save new contact phone number
    Given user verify contact phone number is displayed
    When user click edit contact phone number on account page
    Then contact phone number edit window is displayed
    When user edit new contact phone number on account edit window
    And user clicks back button on store phone edit window
    When popup save confirm message
    And user select "yes" on save confirm window
    Then my account page is displayed
    Given user verify contact phone number is displayed
    And user verify new contact phone number window is displayed


    #restore contact phone number
  @smoke
  Scenario: update the contact phone number to original
    Given user verify contact phone number is displayed
    When user click edit contact phone number on account page
    Then contact phone number edit window is displayed
    When user edit original contact phone number on account edit window
    And user click save button on account edit window
    Then my account page is displayed
    Given user verify contact phone number is displayed
    And user verify original contact phone number is displayed


 #update address click no
  @smoke
  Scenario: change address but not save
    And user verify address window is displayed on account page
    When user click edit address on account page
    Then address edit window is displayed
    When user edit new address on account edit window
    And user clicks back button on store phone edit window
    When popup save confirm message
    And user select "no" on save confirm window
    Then my account page is displayed
    And user verify address window is displayed on account page
    And user verify original address is displayed


    #update address click yes
  @smoke
  Scenario: save new address on account
    And user verify address window is displayed on account page
    When user click edit address on account page
    Then address edit window is displayed
    When user edit new address on account edit window
    And user clicks back button on store phone edit window
    When popup save confirm message
    And user select "yes" on save confirm window
    Then verify user is redirect back from address edit window
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then home page is displayed


    #restore address
  @smoke
  Scenario: update the address to original
    And user verify address window is displayed on account page
    When user click edit address on account page
    Then address edit window is displayed
    When user edit original address on account edit window
    And user click save button on account edit window
    Then verify user is redirect back from address edit window
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then home page is displayed


 #update password click no
  @smoke
  Scenario: change password but not save
    Given user verify password security is displayed on account page
    When user click edit password on account page
    Then password edit window is displayed
    When user edit new password on account edit window
    And user clicks back button on store phone edit window
    When popup save confirm message
    And user select "no" on save confirm window
    Then my account page is displayed


  Scenario: update the password to original
    Given user verify password security is displayed on account page
    When user click edit password on account page
    Then password edit window is displayed
    When user edit original password on account edit window
    And user click save button on account edit window
    Then my account page is displayed
