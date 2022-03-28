Feature: Analytics Home Page

  Background:
    When invoke Charles Proxy
    Then start Charles Proxy Recording
    Then sign in to the application using account with no purchase history

  @analytics
  Scenario: Verify Analytics tags on Home Page Via Browse Page
    And go to browse tab
    And user click menu icon on home page
    And download Charles Logs in File "homePageViaBrowsePage"
    And stop Charles Proxy Recording
    Then verify Charles Proxy Logs for all attribute with tag "homePageViaBrowsePage"




