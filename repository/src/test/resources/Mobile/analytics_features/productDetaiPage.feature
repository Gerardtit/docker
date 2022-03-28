Feature: Analytics Product Detail Page

  Background:
    When invoke Charles Proxy
    Then sign in to the application using account with no purchase history

  @analytics_pdp_page
  Scenario: Verify Analytics tags on Product detail page
    And go to browse tab
    And click on search field
    And search using keyword
    And close toggle info popup
    And start Charles Proxy Recording
    And add a product to product details page
    And download Charles Logs in File "productDetailPage"
    And stop Charles Proxy Recording
    And verify Charles Proxy Logs for all attribute with tag "productDetailPage"

