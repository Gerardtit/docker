Feature: Analytics Product Search Result Page

  Background:
    When invoke Charles Proxy
    Then sign in to the application using account with no purchase history

  @analytics_searchResult_page
  Scenario: Verify Analytics tags on Zero Search Result page
    And go to browse tab
    And click on search field
    And start Charles Proxy Recording
    And search using keyword which has no result
    And download Charles Logs in File "zeroSearchResultPage"
    And stop Charles Proxy Recording
    And verify Charles Proxy Logs for all attribute with tag "zeroSearchResultPage"


