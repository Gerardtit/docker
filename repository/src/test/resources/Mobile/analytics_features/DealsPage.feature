Feature: Analytics Deals Page

  Background:
    When invoke Charles Proxy
    Then start Charles Proxy Recording
    Then sign in to the application using account with existing rewards



#  Scenario: Verify Analytics tags on Deals Page_For You
##    Then user click on Deals Tab
#    And user Click on For You tab
#    Then download Charles Logs in File "foryou"
#    Then stop Charles Proxy Recording
#    Then verify Charles Proxy Logs for all attribute with tag "foryou"

#-------------------------

#   Scenario: Verify Analytics tags on Deals Page_All Deals
##  #  Then user clicks continue Popups
##    Then user click on Deals Tab
##    Then Click on All Deals page
#    Then download Charles Logs in File "alldeals"
#    Then stop Charles Proxy Recording
#    Then verify Charles Proxy Logs for all attribute with tag "alldeals"

##
#  Scenario: Verify Analytics tags on Deals Page_Promo
#   # Then user click on Deals Tab
#    Then go to BOGO tab
#    Then Click on Promo page
#    Then download Charles Logs in File "promo"
#    Then stop Charles Proxy Recording
#    Then verify Charles Proxy Logs for all attribute with tag "promo"




#  Scenario: Verify Analytics tags on Deals Page_Promo qualifying product
#    #Then user click on Deals Tab
#    Then go to BOGO tab
#    Then Click on Promo page
#    Then Click on qualifying product
#    Then download Charles Logs in File "promoqualifyingproduct"
#    Then stop Charles Proxy Recording
#    Then verify Charles Proxy Logs for all attribute with tag "promoqualifyingproduct"
####
#
#  Scenario: Verify Analytics tags on Deals Page_BOGO
# #   Then user click on Deals Tab
#    Then go to BOGO tab
#    Then Click on Promo page
#    Then Click on BOGO page
#    Then download Charles Logs in File "Bogo"
#    Then stop Charles Proxy Recording
#    Then verify Charles Proxy Logs for all attribute with tag "Bogo"


#  #in Android tag is not coming
#  Scenario: Verify Analytics tags on Deals Page_Expiring Soon
#   # Then user click on Deals Tab
#    Then Click on Expiring Soon page
#    Then download Charles Logs in File "expiringsoon"
#    Then stop Charles Proxy Recording
#    Then verify Charles Proxy Logs for all attribute with tag "expiringsoon"
