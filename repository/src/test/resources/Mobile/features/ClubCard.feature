@clubcard
Feature: Verify club card details

  Background: setup user on SignIn Page
    Given startup page is displayed
    Then Zipcode page is displayed
    When user clicks Sign in button on zipcode page
    Then sign in page is displayed
    When user enter "email" in username field on Sign In page
    And user enter "password" in password field on Sign In page
    And user clicks sign in on sign in page
    When user clicks continue for CacheText
    Then Home page is displayed
#    When Launch the MFA app
#    And click on existing user signin for OTP
#    Then verify MFA home screen is displayed
#    Then verify search bar is displayed


  Scenario: verify club card deals section
    Then verify search bar appears in home page
    When user tap on search and perform product search as "butter"
    Then user should see searched products
    When user tap on filter
    Then verify Sort & Filter window is displayed
    When user clicks Best Match
    Then verify Sort By window is displayed
    Then user select Club Card Specials from Sort By window
    And user clicks back button on Sort By window
    And user tap on save in Sort & Filter window
    When user click on the first product
    Then check by increasing and decreasing the quantity
    When user clicks on List
    Then verify My List page is displayed
    Then verify products are added in cartpage
    And user close the "My List" page
