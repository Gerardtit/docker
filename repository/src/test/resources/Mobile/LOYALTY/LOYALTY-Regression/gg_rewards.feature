Feature: Verify My Rewards Page


  Background:
    When  Launch the MFA app
    When sign in to the application
    Then verify home screen is displayed

  @smoke
  Scenario:User selects Delivery option and Verify Rewards Balance & Expiring Date in My Rewards Page
    When go to member tab
    And scroll down on the page
    When Click or tap on How do rewards work button
    Then Verify it lands on a page where it shows about your rewards and Earning Points
    And verify reward balance as zero
    And verify expiring date

  @fresh1
  Scenario:User selects Delivery option and Verify Rewards Balance & Expiring Date in My Rewards Page
    When go to member tab
    And scroll down on the page
    And scroll down on the page
    When Click or tap on How do rewards work button
    Then Verify it lands on a page where it shows about your rewards and Earning Points

  @rewardsBanner
  Scenario:User selects Delivery option and Verify Rewards Balance & Expiring Date in My Rewards Page
    When go to member tab
    And scroll down on the page
    And scroll down on the page
    When Click or tap on How do rewards work button
    Then Verify it lands on a page where it shows about your rewards and Earning Points
    Then click back button
    When user clicks on birthday card
    And birthday card is displayed





