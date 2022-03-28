Feature: Analytics Reward Page

  Background:
    When invoke Charles Proxy
    Then start Charles Proxy Recording
    Then sign in to the application using account with existing rewards


  Scenario: Verify Analytics tags on Deals Page
    Then click on home tab
    Then click on Reward
    Then download Charles Logs in File "homereward"
    Then stop Charles Proxy Recording
    Then verify Charles Proxy Logs for all attribute with tag "homereward"