Feature: Analytics Browse Page

  Background:
    When invoke Charles Proxy
    Then start Charles Proxy Recording
    Then sign in to the application using account with existing rewards


  Scenario: Verify Analytics tags on Browse Page
   # Then click on Next
    And  user click on Browse Tab
    Then download Charles Logs in File "Browse"
    Then stop Charles Proxy Recording
    Then verify Charles Proxy Logs for all attribute with tag "Browse"
