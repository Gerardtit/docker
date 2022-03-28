Feature: Analytics My Items Category Page

  Background:
    When invoke Charles Proxy
    Then sign in to the application using account with purchase history

  @myItem_category_page
  Scenario: Verify Analytics tags on All Purchase Page
    Then start Charles Proxy Recording
    When click on my items tab
    And download Charles Logs in File "allPastPurchasePage"
    And stop Charles Proxy Recording
    Then verify Charles Proxy Logs for all attribute with tag "allPastPurchasePage"

  @myItem_category_page
  Scenario: Verify Analytics tags on my last order page
    When click on my items tab
    And  start Charles Proxy Recording
    Then click on my last order tab
    And download Charles Logs in File "myLastOrder"
    And stop Charles Proxy Recording
    Then verify Charles Proxy Logs for all attribute with tag "myLastOrder"

