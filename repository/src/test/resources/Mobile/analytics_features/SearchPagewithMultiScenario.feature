Feature: Analytics Search Page with Multiple Search Secanrio

  Background:
    When invoke Charles Proxy
    Then start Charles Proxy Recording
    Then sign in to the application using account with existing rewards

#  Scenario: Verify Analytics tags on Search Page with Search
#    Then click on home tab
#    And Search product
#    Then download Charles Logs in File "searchitem"
#    Then stop Charles Proxy Recording
#    Then verify Charles Proxy Logs for all attribute with tag "searchitem"

#
#  Scenario: Verify Analytics tags on Search Page with Current trending
#    Then click on home tab
#    And  Click on Search
#    And  Select current trending product
#    Then download Charles Logs in File "currenttrending"
#    Then stop Charles Proxy Recording
#    Then verify Charles Proxy Logs for all attribute with tag "currenttrending"

#  Scenario: Verify Analytics tags on Search Page with Recently Searched Product
#    Then click on home tab
#    And Search product
#    And Click on cancel or back
#    And  Click on Search
#    And  Select Recently Searched product
#    Then download Charles Logs in File "recentlysearchitem"
#    Then stop Charles Proxy Recording
#    Then verify Charles Proxy Logs for all attribute with tag "recentlysearchitem"
####
  Scenario: Verify Analytics tags on Search Page with Search with Half name
    Then click on home tab
    And Search product half Name
    Then download Charles Logs in File "halfsearchitem"
    Then stop Charles Proxy Recording
    Then verify Charles Proxy Logs for all attribute with tag "halfsearchitem"
