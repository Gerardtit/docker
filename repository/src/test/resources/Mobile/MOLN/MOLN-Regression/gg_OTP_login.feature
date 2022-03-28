Feature: OTP Screen Validation

  Background:
    When  Launch the MFA app


  @smoke @regression
  Scenario: As a  Registered user, I should land on home screen on signin with email
   # Then Verify the Welcome Title is visible
    When click on existing user signin for OTP
    Then verify MFA home screen is displayed

  @smoke @regression @bvt_regression
  Scenario: As a new user on Signup using email, I should land on Zip code screen and select delivery
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then Verify Start shopping button on Sign In page
    When user click delivery option
    And user click start shopping button on After Signup
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed

  @smoke
  Scenario: As a  Registered user, I should land on home screen on signin using Resend otp option
   # Then Verify the Welcome Title is visible
    When user login to the app using resend option after "30" sec
    Then verify MFA home screen is displayed


  @qaMFALoyalty @smoke @bvt_regression
  Scenario: As a new user on Signup using email, I should land on home screen when pickup is selected
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    And verify "pickup" option is selected as preference on home page

  @qaMFALoyalty @smoke
  Scenario: As a new user on Signup using email, I should land on home screen when instore is selected
   # Then Verify the Welcome Title is visible
    When click on NewSignup for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks instore on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    And verify "inStore" option is selected as preference on home page

  @smoke
  Scenario: As a existing user on Signin using email using Try diff email flow, I should land on home screen
   # Then Verify the Welcome Title is visible
    When User login with email using try diff email link
    Then verify MFA home screen is displayed


  @smoke @bvt_regression
  Scenario: As a new user on Signup using email with try different email option, I should land on home screen when instore is selected
    When User Signup with try diff email link
    Then zipcode page is displayed
    When user enters "instore" in zipcode page
    Then select order type page is displayed
    When user clicks instore on delivery select page
    Then store list is displayed
    Then user selects the In-store on the list
#    When user clicks 1st store on the list
    And user click start shopping button on Sign In page
    And user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    And verify "inStore" option is selected as preference on home page


  @smoke @bvt_regression
  Scenario: As a new user on Signup using resend code email, user should be able to select Delivery option to navigate home page
    When new user signup using resend code after "30" sec
    Then zipcode page is displayed
    When  user enters "zipcode" in zipcode page
    And user click delivery option
    And user click start shopping button on After Signup
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed


  @smoke
  Scenario: As a new user on Signup using resend code email, user should be able to select pickup option to navigate home page
   # Then Verify the Welcome Title is visible
    When new user signup using resend code after "30" sec
    Then zipcode page is displayed
    When  user enters "zipcode" in zipcode page
    And user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    And verify "pickup" option is selected as preference on home page

  @smoke
  Scenario: As a new user on Signup using resend code email, user should be able to select instore option to navigate home page
   # Then Verify the Welcome Title is visible
    When new user signup using resend code after "30" sec
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    And user clicks instore on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    And verify "inStore" option is selected as preference on home page


  @smoke @bvt_regression
  Scenario: As a Registered user should check email id in my account.
    When sign in to the application
    And user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When User click on user profile icon
    Then User verify Account option in list
    When User click on Account option
    Then user see My account page
    And user verify email id in email section
    And user not see password option

  @smoke
  Scenario: As a Registered user should not see password field in my Account
   # Then Verify the Welcome Title is visible
    When click on existing user signin for OTP
    Then verify MFA home screen is displayed
    When User click on user profile icon
    Then User verify Account option in list
    When User click on Account option
    Then user see My account page
    And user not see password option


  @smoke
  Scenario: As a SSO user should check email id in my account.
   # Then Verify the Welcome Title is visible
    When click on SSO user signin
    Then verify MFA home screen is displayed
    When User click on user profile icon
    Then User verify Account option in list
    When User click on Account option
    Then user see My account page
    And user verify SSO email in email section
    And user not see password option

  @smoke
  Scenario: As a Registered user should not see password field in my Account
   # Then Verify the Welcome Title is visible
    When click on existing user signin for OTP
    Then verify MFA home screen is displayed
    When User click on user profile icon
    Then User verify Account option in list
    When User click on Account option
    Then user see My account page
    And user not see password option


  @smoke1
  Scenario: When user go back using Start over in OTP screen, then user should be able to signin again
   # Then Verify the Welcome Title is visible
    When User Enter the Email Id For OTP
    When User click on Start over button
    When click on existing user signin for OTP
    Then verify MFA home screen is displayed

  @smoke
  Scenario: As a new user when launch app can see terms TOS text in let get started screen in email flow
    #When click on Email for OTP
    Then Verify Input Field For Email
    And Verify TOS in get started screen
    When User click on Privacy policy in get started screen
    Then Verify Privacy policy screen in browser
    And come back to to app verify let get started screen

  @smoke151
  Scenario: As a new user can see terms TOS text in OTP screen in email flow

    When User Enter the Email Id For OTP to SignUp
    When Click on Submit Button
    And Verify TOS in OTP Screen
    When user clicks on TOS in OTP screen
    Then Verify Privacy policy screen in browser
    #When user clicks on TOS in OTP screen
    #Then Verify TOS screen in browser
    And come back to app and verify OTP screen

  @smoke @bvt_regression
  Scenario: As a new user should be able to update email id in My account
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When User click on user profile icon
    Then User verify Account option in list
    When User click on Account option
    Then user see My account page
#    And user verify email id in email section
    And User update Email Id

  @smoke
  Scenario: As a new user should be able to update phone number id in My account
   # Then Verify the Welcome Title is visible
    When click on NewSignup for OTP
    Then zipcode page is displayed
    When user enters "76109" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    When User click on user profile icon
    Then User verify Account option in list
    When User click on Account option
    Then user see My account page
    And user click phone number section
    And User update phone number

  @smoke
  Scenario: As a new user should be able to update contact number id in My account
   # Then Verify the Welcome Title is visible
    When click on NewSignup for OTP
    Then zipcode page is displayed
    When user enters "76109" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    When User click on user profile icon
    Then User verify Account option in list
    When User click on Account option
    Then user see My account page
    And user click contact number section
    And User update contact number

  @regression @functional @start_scenario @pratik3
  Scenario: on the Check your email page a validation message should be displayed under disabled Resend code
    When signing in and landing on Check your email page
    Then verify OTP message is displayed under Resend code button
    And verify if Resend code button is disabled grey
    Then after thirty seconds verify OTP message is not displayed anymore
    And verify if resend code button is enabled and click on it and OTP message is displayed again


#Feature: OTP Screen Validation
#
#  Background:
#    When  Launch the MFA app
#
#  @qaIncomplete
#  Scenario: As a  Registered user, I should see welcome Back Message After providing OTP received on Mobile
##    Then Verify the Welcome Title is visible
#    When click on Mobile for OTP
#    Then Verify Input Field For Mobile Number
#    When User Enter the Mobile Number For OTP
#    Then Submit Button Become Enable
#    When Click on Submit Button
#    Then User Should See Text Box for Adding OTP
#    When User Fills OTP and Click Submit
#    Then Welcome back message come for Registered user
#
#  @qaIncomplete
#  Scenario: As a  Registered user, I should see welcome Back Message After providing OTP received on Email
##    Then Verify the Welcome Title is visible
#    When click on Email for OTP
#    Then Verify Input Field For Email
#    When User Enter the Email Id For OTP
#    Then Submit Button Become Enable
#    When Click on Submit Button
#    Then User Should See Text Box for Adding OTP
#    When User Fills OTP and Click Submit
#    Then Welcome back message come for Registered user
#
#
#  @qaIncomplete
#  Scenario: As a  New user, I should see welcome  Message After providing OTP received on Mobile
##    Then Verify the Welcome Title is visible
#    When click on Mobile for OTP
#    Then Verify Input Field For Mobile Number
#    When User Enter the Mobile Number For OTP
#    Then Submit Button Become Enable
#    When Click on Submit Button
#    Then User Should See Text Box for Adding OTP
#    When User Fills OTP and Click Submit
#    Then Welcome message come for New user
#
#  @qaIncomplete
#  Scenario: As a  New user, I should see welcome Message After providing OTP received on Email
##    Then Verify the Welcome Title is visible
#    When click on Email for OTP
#    Then Verify Input Field For Email
#    When User Enter the Email Id For OTP
#    Then Submit Button Become Enable
#    When Click on Submit Button
#    Then User Should See Text Box for Adding OTP
#    When User Fills OTP and Click Submit
#    Then Welcome message come for New user
#
#  @smoke @regression
#  Scenario: As a  Registered user, I should land on home screen on signin with email
#   # Then Verify the Welcome Title is visible
#    When click on existing user signin for OTP
#    Then verify MFA home screen is displayed
#
#  @smoke @regression
#  Scenario: As a new user on Signup using email, I should land on Zip code screen and select delivery
#   # Then Verify the Welcome Title is visible
#    When click on NewSignup for OTP
#    Then zipcode page is displayed
#    When user enters "zipcode" in zipcode page on MFA signup
#   # And user clicks next button after registration on zipcode page
#    Then Verify Start shopping button on Sign In page
#    When user click delivery option
#    And user click start shopping button on After Signup
#    Then verify MFA home screen is displayed
#
#  @qaMFALoyalty
#  Scenario: As a  Registered user, I should land on home screen on signin using Resend otp option
#   # Then Verify the Welcome Title is visible
#    When click on Email for OTP
#    Then Verify Input Field For Email
#    When User Enter the Email Id For OTP to Signin
#    Then Submit Button Become Enable
#    When Click on Submit Button
#    And user wait for "30" seconds to pass
#    Then User Should See Resend code link in OTP and click on that
#    When user copy otp from email
#    Then verify MFA home screen is displayed
#
#
#  @qaMFALoyalty
#  Scenario: As a new user on Signup using email, I should land on home screen when pickup is selected
#   # Then Verify the Welcome Title is visible
#    When click on Email for OTP
#    Then Verify Input Field For Email
#    When User Enter the Email Id For OTP to SignUp
#    Then Submit Button Become Enable
#    When Click on Submit Button
#    Then User Should See Text Box for Adding OTP
#    When new user copy otp from email
#    Then zipcode page is displayed
#    When user enters "zipcode" in zipcode page on MFA signup
#    Then select order type page is displayed
#    When user clicks pickup on delivery select page
#    Then store list is displayed
#    And user click start shopping button on Sign In page
#    Then verify MFA home screen is displayed
#    And verify "pickup" option is selected as preference on home page
#
#  @qaMFALoyalty
#  Scenario: As a new user on Signup using email, I should land on home screen when instore is selected
#   # Then Verify the Welcome Title is visible
#    When click on Email for OTP
#    Then Verify Input Field For Email
#    When User Enter the Email Id For OTP to SignUp
#    Then Submit Button Become Enable
#    When Click on Submit Button
#    Then User Should See Text Box for Adding OTP
#    When new user copy otp from email
#    Then zipcode page is displayed
#    When user enters "zipcode" in zipcode page on MFA signup
#    Then select order type page is displayed
#    When user clicks instore on delivery select page
#    Then store list is displayed
#    And user click start shopping button on Sign In page
#    Then verify MFA home screen is displayed
#    And verify "inStore" option is selected as preference on home page
#
#  @qaMFALoyalty
#  Scenario: As a existing user on Signin using email using Try diff email flow, I should land on home screen
#   # Then Verify the Welcome Title is visible
#    When click on Email for OTP
#    Then Verify Input Field For Email
#    When User Enter the Email Id For OTP
#    Then Submit Button Become Enable
#    When Click on Submit Button
#    Then User Should See Try different email link
#    When user click on try different email link
#    Then Verify Input Field For Email
#    When User Enter the Email Id For OTP to Signin
#    Then Submit Button Become Enable
#    When Click on Submit Button
#    Then User Should See Text Box for Adding OTP
#    When user copy otp from email
#    Then verify MFA home screen is displayed
#
#
#  @qaMFALoyalty
#  Scenario: As a new user on Signup using email with try different email option, I should land on home screen when instore is selected
#   # Then Verify the Welcome Title is visible
#    When click on Email for OTP
#    Then Verify Input Field For Email
#    When User Enter the Email Id For OTP
#    Then Submit Button Become Enable
#    When Click on Submit Button
#    Then User Should See Try different email link
#    When user click on try different email link
#    Then Verify Input Field For Email
#    When User Enter the Email Id For OTP to SignUp
#    Then Submit Button Become Enable
#    When Click on Submit Button
#    Then User Should See Text Box for Adding OTP
#    When new user copy otp from email
#    Then zipcode page is displayed
#    When user enters "zipcode" in zipcode page on MFA signup
#    Then select order type page is displayed
#    When user clicks instore on delivery select page
#    Then store list is displayed
#    And user click start shopping button on Sign In page
#    Then verify MFA home screen is displayed
#    And verify "inStore" option is selected as preference on home page
#
#
#  @qaMFALoyalty
#  Scenario: As a new user on Signup using resend code email, user should be able to select Delivery option to navigate home page
#   # Then Verify the Welcome Title is visible
#    When click on Email for OTP
#    Then Verify Input Field For Email
#    When User Enter the Email Id For OTP to SignUp
#    Then Submit Button Become Enable
#    When Click on Submit Button
#    Then User Should See Text Box for Adding OTP
#    And USer verify message for create Account Steps
#    And user wait for "30" seconds to pass
#    Then User Should See Resend code link in OTP and click on that
#    When new user copy otp from email
#    Then zipcode page is displayed
#    When user enters "zipcode" in zipcode page on MFA signup
##    Then user allow notification popup for iOS
##    And user clicks next button after registration on zipcode page
##    Then Verify Start shopping button on Sign In page
#    When user click delivery option
#    And user click start shopping button on After Signup
#    Then verify MFA home screen is displayed
#
#
#  @qaMFALoyalty
#  Scenario: As a new user on Signup using resend code email, user should be able to select pickup option to navigate home page
#   # Then Verify the Welcome Title is visible
#    When click on Email for OTP
#    Then Verify Input Field For Email
#    When User Enter the Email Id For OTP to SignUp
#    Then Submit Button Become Enable
#    When Click on Submit Button
#    Then User Should See Text Box for Adding OTP
#    And USer verify message for create Account Steps
#    And user wait for "30" seconds to pass
#    Then User Should See Resend code link in OTP and click on that
#    When new user copy otp from email
#    Then zipcode page is displayed
#    When user enters "zipcode" in zipcode page on MFA signup
##    Then user allow notification popup for iOS
##    And user clicks next button after registration on zipcode page
##    Then Verify Start shopping button on Sign In page
#    When user clicks pickup on delivery select page
#    Then store list is displayed
#    And user click start shopping button on Sign In page
#    Then verify MFA home screen is displayed
#    And verify "pickup" option is selected as preference on home page
#
#  @qaMFALoyalty
#  Scenario: As a new user on Signup using resend code email, user should be able to select instore option to navigate home page
#   # Then Verify the Welcome Title is visible
#    When click on Email for OTP
#    Then Verify Input Field For Email
#    When User Enter the Email Id For OTP to SignUp
#    Then Submit Button Become Enable
#    When Click on Submit Button
#    Then User Should See Text Box for Adding OTP
#    And USer verify message for create Account Steps
#    And user wait for "30" seconds to pass
#    Then User Should See Resend code link in OTP and click on that
#    When new user copy otp from email
#    Then zipcode page is displayed
#    When user enters "zipcode" in zipcode page on MFA signup
##    Then user allow notification popup for iOS
##    And user clicks next button after registration on zipcode page
##    Then Verify Start shopping button on Sign In page
#    When user clicks instore on delivery select page
#    Then store list is displayed
#    And user click start shopping button on Sign In page
#    Then verify MFA home screen is displayed
#    And verify "inStore" option is selected as preference on home page
#
#
#
#  @qaMFALoyalty
#  Scenario: As a Registered user should check email id in my account.
#   # Then Verify the Welcome Title is visible
#    When click on Email for OTP
#    Then Verify Input Field For Email
#    When User Enter the Email Id For OTP to Signin
#    Then Submit Button Become Enable
#    When Click on Submit Button
#    Then User Should See Text Box for Adding OTP
#    When user copy otp from email
#    Then zipcode page is displayed
#    When user enters "zipcode" in zipcode page on MFA signup
##    Then user allow notification popup for iOS
##    And user clicks next button after registration on zipcode page
##    Then Verify Start shopping button on Sign In page
#    When user clicks pickup on delivery select page
#    Then store list is displayed
#    And user click start shopping button on Sign In page
#    Then verify MFA home screen is displayed
#    And verify "pickup" option is selected as preference on home page
#    When User click on user profile icon
#    Then User verify Account option in list
#    When User click on Account option
#    Then user see My account page
#    And user verify email id in email section
#    And user not see password option
#
#  @qaMFALoyalty
#  Scenario: As a Registered user should not see password field in my Account
#   # Then Verify the Welcome Title is visible
#    When click on Email for OTP
#    Then Verify Input Field For Email
#    When User Enter the Email Id For OTP to Signin
#    Then Submit Button Become Enable
#    When Click on Submit Button
#    Then User Should See Text Box for Adding OTP
#    When user copy otp from email
#    Then zipcode page is displayed
#    When user enters "zipcode" in zipcode page on MFA signup
##    Then user allow notification popup for iOS
##    And user clicks next button after registration on zipcode page
##    Then Verify Start shopping button on Sign In page
#    When user clicks pickup on delivery select page
#    Then store list is displayed
#    And user click start shopping button on Sign In page
#    Then verify MFA home screen is displayed
#    And verify "pickup" option is selected as preference on home page
#    When User click on user profile icon
#    Then User verify Account option in list
#    When User click on Account option
#    Then user see My account page
#    And user not see password option
#
#
#  @qaMFALoyalty
#  Scenario: When user go back using Start over in OTP screen, then user should be able to signin
#   # Then Verify the Welcome Title is visible
#    When click on Email for OTP
#    Then Verify Input Field For Email
#    When User Enter the Email Id For OTP
#    Then Submit Button Become Enable
#    When Click on Submit Button
#    Then User Should See Text Box for Adding OTP
#    When User click on Start over button
#    Then Verify user navigated to let get started screen
#    When User Enter the Email Id For OTP to Signin
#    Then Submit Button Become Enable
#    When Click on Submit Button
#    Then User Should See signin text message for signin user
#    When user copy otp from email
#    Then verify MFA home screen is displayed
#
#  @qaMFALoyalty
#  Scenario: As a new user when launch app can see terms TOS text in let get started screen nd OTP screen in email flow
#    When click on Email for OTP
#    Then Verify Input Field For Email
#    And Verify TOS in get started screen
#    When User click on Privacy policy in get started screen
#    Then Verify Privacy policy screen in browser
#  #  When user clicks on TOS in OTP screen
#   # Then Verify TOS screen in browser
#    And come back to to app verify let get started screen
#    When User Enter the Email Id For OTP to SignUp
#    Then Submit Button Become Enable
#    When Click on Submit Button
#    Then User Should See Text Box for Adding OTP
#    And Verify TOS in OTP Screen
#    When user clicks on TOS in OTP screen
#    Then Verify Privacy policy screen in browser
#    #When user clicks on TOS in OTP screen
#    #Then Verify TOS screen in browser
#    And come back to app and verify OTP screen
#
#
#

