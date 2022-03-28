Feature: Analytics Product Wallet Page

  Background:
    When invoke Charles Proxy
    Then sign in to the application using account with existing rewards

  @analytics_wallet_page
  Scenario: Verify Analytics tags on Wallet page
    Then start Charles Proxy Recording
    And go to Wallet tab
    And download Charles Logs in File "walletPage"
    And stop Charles Proxy Recording
    And verify Charles Proxy Logs for all attribute with tag "walletPage"


