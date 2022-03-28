Feature: Settings-Regression

  #C20795
  @regression @start_scenario
  Scenario: Life time savings- With Rewards as wells
    When sign in to the application
    Then verify home screen is displayed
    And go to Home tab
    Then click on my profile icon
    And click on Account button
    Then verify account profile page is displayed
    And verify lifetime savings field is displayed
    Then navigate back to Settings screen

  #Marking this as manual since address field IDs were removed
  #C20796
#  @regression
#  Scenario: Address - Update as well/Off banner Update
#    And go to Home tab
#    And click on my profile icon
#    And click on Account button
#    Then verify account profile page is displayed
#    And user verify address window is displayed on account page
#    When user click edit address on account page
#    Then "Address Book" window is displayed
#    When user clicks "Edit" text on page
#    Then "Edit Delivery Address" window is displayed
#    When user edit new address on edit delivery address page
#    And user clicks back button on store phone edit window
#    When popup save confirm message
#    And user select "no" on save confirm window
#    Then "Address Book" window is displayed
#    When navigate back to previous level from address book page
#    Then my account page is displayed
#    And user verify address window is displayed on account page
#    And user verify original address is displayed
#
#    And user verify address window is displayed on account page
#    When user click edit address on account page
#    Then "Address Book" window is displayed
#    When user clicks "Edit" text on page
#    Then "Edit Delivery Address" window is displayed
#    When user edit new address on edit delivery address page
#    And user clicks back button on store phone edit window
#    When popup save confirm message
#    And user select "yes" on save confirm window
#    And user acknowledges Zip Code Change popup
#    Then "Address Book" window is displayed
#    When navigate back to previous level from address book page
#    Then my account page is displayed
#    And user verify address window is displayed on account page
#    #And user verify new address is displayed
#
#    And user verify address window is displayed on account page
#    When user click edit address on account page
#    Then "Address Book" window is displayed
#    When user clicks "Edit" text on page
#    Then "Edit Delivery Address" window is displayed
#    When user edit original address on edit delivery address page
#    And user click save button on account edit window
#    Then "Address Book" window is displayed
#    When navigate back to previous level from address book page
#    Then my account page is displayed
#    And user verify address window is displayed on account page
#    And user verify original address is displayed

    #Marking this as manual since address field IDs were removed
#  #C20797
#  @regression
#  Scenario: Adding Address for new register user
#    And go to Home tab
#    And click on my profile icon
#    And click on Account button
#    Then verify account profile page is displayed
#
#    And user verify address window is displayed on account page
#    When user click edit address on account page
#    Then "Address Book" window is displayed
#    When user clicks "Edit" text on page
#    Then "Edit Delivery Address" window is displayed
#    When user edit new address on edit delivery address page
#    And user clicks back button on store phone edit window
#    When popup save confirm message
#    And user select "yes" on save confirm window
#    Then "Address Book" window is displayed
#    When navigate back to previous level from address book page
#    Then my account page is displayed
#    And user verify address window is displayed on account page
#    And user verify new address is displayed
#    # Changing the address back for test data consistency
#    And user verify address window is displayed on account page
#    When user click edit address on account page
#    Then "Address Book" window is displayed
#    When user clicks "Edit" text on page
#    Then "Edit Delivery Address" window is displayed
#    When user edit original address on edit delivery address page
#    And user click save button on account edit window
#    Then "Address Book" window is displayed
#    When navigate back to previous level from address book page
#    Then my account page is displayed
#    And user verify address window is displayed on account page
#    And user verify original address is displayed

  #C20802
  @regression
  Scenario: Phone Number used in Store - Edit
    And go to Home tab
    Then click on my profile icon
    And click on Account button
    Then verify account profile page is displayed
    # Edit the phone no and don't save
    Given user verify phone number used in store is displayed
    And user views the phone number used in store
    When user click edit phone number on account page
    Then phone number edit window is displayed
    When user edit and confirm new phone number on account edit window
    And user clicks back button on store phone edit window
    When popup save confirm message
    And user select "no" on save confirm window
    Then my account page is displayed
    And user verify phone number used in store is displayed
    Then user verify original phone number is displayed
   # Edit the phone no and save
    Given user verify phone number used in store is displayed
    When user click edit phone number on account page
    Then phone number edit window is displayed
    When user edit and confirm new phone number on account edit window
    And user clicks back button on store phone edit window
    When popup save confirm message
    And user select "yes" on save confirm window
    Then my account page is displayed
    And user verify phone number used in store is displayed
    When user verify new phone number is displayed
    Then navigate back to Settings screen

  #C20801
  @regression
  Scenario: Phone Number - Edit Contacts
    And go to Home tab
    Then click on my profile icon
    And click on Account button
    Then verify account profile page is displayed
# Edit the phone no and don't save
    Given user verify contact phone number is displayed
    And user views the contact phone number
    When user click edit contact phone number on account page
    And contact phone number edit window is displayed
    When user edit new contact phone number on account edit window
    And user clicks back button on store phone edit window
    Then popup save confirm message
    And user select "no" on save confirm window
    Then my account page is displayed
    And user verify contact phone number is displayed
    Then user verify original contact phone number is displayed
# Edit the phone no and save
    Given user verify contact phone number is displayed
    When user click edit contact phone number on account page
    And contact phone number edit window is displayed
    Then user edit new contact phone number on account edit window
    And user clicks back button on store phone edit window
    Then popup save confirm message
    And user select "yes" on save confirm window
    Then my account page is displayed
    When user verify contact phone number is displayed
    Then user verify new contact phone number is displayed
    And navigate back to Settings screen

  #C20803
  @regression
  Scenario: Add phone number - Newly register users
    And go to Home tab
    Then click on my profile icon
    And click on Account button
    Then verify account profile page is displayed
    Given user verify phone number used in store is displayed
    When user click edit phone number on account page
    Then phone number edit window is displayed
    When user edit and confirm new phone number on account edit window
    And user clicks back button on store phone edit window
    When popup save confirm message
    And user select "yes" on save confirm window
    Then my account page is displayed
    When user verify phone number used in store is displayed
    And user verify new phone number is displayed
    Then navigate back to Settings screen

  #C20799
  @regression
  Scenario: Pick up Stores Addresses - Edit Store
    And go to Home tab
    Then click on my profile icon
    And click on Account button
    Then verify account profile page is displayed
    When view the pickup store address
    And click pick up store section on account page
    When change the pick up store
    And click save button on pick up store selection
    Then click back option on pop up
    And click cancel button pick up store selection
    Then verify pick up store address not updated
    When click pick up store section on account page
    And change the pick up store
    Then click save button on pick up store selection
    And click continue option on pop up
    Then verify pick up store address is updated
  ##changing to original pickup store address
    When click pick up store section on account page
    And change the pick up store
    When click save button on pick up store selection
    And click continue option on pop up
    Then navigate back to Settings screen

  #C20800
  @regression
  Scenario: Pick up Store Addresses select store - Newly register user
    And go to Home tab
    Then click on my profile icon
    And click on Account button
    Then verify account profile page is displayed
    When view the pickup store address
    And click pick up store section on account page
    Then change the pick up store
    And click save button on pick up store selection
    When click back option on pop up
    And click cancel button pick up store selection
    Then verify pick up store address not updated
    When click pick up store section on account page
    And change the pick up store
    Then click save button on pick up store selection
    And click continue option on pop up
    Then verify pick up store address is updated
  ##changing the pickup store address with default address
    When click pick up store section on account page
    And change the pick up store
    Then click save button on pick up store selection
    And click continue option on pop up
    Then navigate back to Settings screen

  #C20805
  @regression
  Scenario: Communication - Verify all toggles with  ON/OFF
    And go to Home tab
    Then click on my profile icon
    And click on Account button
    Then verify account profile page is displayed
    When user clicks communication preferences section on account page
    Then communication preferences page is displayed
    And verify communication preferences are in ON state
    Then click back button on communication preferences page
    When user clicks communication preferences section on account page
    And set communication preferences are in OFF state
    Then click back button on communication preferences page
    And user clicks communication preferences section on account page
    Then verify communication preferences are in OFF state
    And set communication preferences are in ON state
    Then verify communication preferences are in ON state
    And click back button on My Account page
    Then navigate back to Settings screen

  #C16619
  @regression
  Scenario: Chatbot for all banners except Carrs
    When go to Home tab
    And verify settings icon is displayed
    Then click on settings icon
    And verify chat bot module is displayed
    When click on chat bot module
    Then verify chat screen is displayed
    And navigate back to Settings screen

  #C20794
  @regression @end_scenario
  Scenario: past orders
    And go to Home tab
    Then click on my profile icon
    And click on Account button
    Then verify account profile page is displayed
    Then navigate back to Settings screen
    And go to Home tab
    Then click on my profile icon
    When user clicks order section
    Then old orders are displayed