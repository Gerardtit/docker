Feature: Analytics Clip Deals Page

  Background:
    When invoke Charles Proxy
    Then start Charles Proxy Recording
    Then sign in to the application using account with existing rewards


#  Scenario: Verify Analytics tags on Deals Page_All Deals
#
##    Then user click on Deals Tab
#
#    Then user clicks on clip coupon
#    Then download Charles Logs in File "clipalldeals"
#    Then stop Charles Proxy Recording
#    Then verify Charles Proxy Logs for all attribute with tag "clipalldeals"

#
#  Scenario: Verify Analytics tags on Deals Page_All Deals with doubleTap
#
##    Then user click on Deals Tab
#
#    Then user clicks on clip coupon with double tap
#    Then download Charles Logs in File "clipalldeals"
#    Then stop Charles Proxy Recording
#    Then verify Charles Proxy Logs for all attribute with tag "clipalldeals"


#  Scenario: Verify Analytics tags on Deals Page_All Deals with longPress
#
##    Then user click on Deals Tab
#
#    Then user clicks on clip coupon with longPress
#    Then download Charles Logs in File "clipalldeals"
#    Then stop Charles Proxy Recording
#    Then verify Charles Proxy Logs for all attribute with tag "clipalldeals"
##
#  Scenario: Verify Analytics tags on Deals Page_All Deals with fasttab
#
#    Then user clicks on clip coupon with fast tab
#    Then download Charles Logs in File "clipalldeals"
#    Then stop Charles Proxy Recording
#    Then verify Charles Proxy Logs for all attribute with tag "clipalldeals"

#------- Cliping in Expiring soon----  android tag is not coming for android
#
#  Scenario: Verify Analytics tags on Deals Page_expiring soon with cliping
#    Then Click on Expiring Soon page
#    Then user clicks on clip coupon
#    Then download Charles Logs in File "clipexpiringsoon"
#    Then stop Charles Proxy Recording
#    Then verify Charles Proxy Logs for all attribute with tag "clipexpiringsoon"

#
#
#  Scenario: Verify Analytics tags on Deals Page_expiring soon  with doubleTap
#
##    Then user click on Deals Tab
#    Then Click on Expiring Soon page
#    Then user clicks on clip coupon with double tap
#    Then download Charles Logs in File "clipexpiringsoon"
#    Then stop Charles Proxy Recording
#    Then verify Charles Proxy Logs for all attribute with tag "clipexpiringsoon"

#
#  Scenario: Verify Analytics tags on Deals Page_expiring soon  with longPress
#
#
#    Then Click on Expiring Soon page
#    Then user clicks on clip coupon with longPress
#    Then download Charles Logs in File "clipexpiringsoon"
#    Then stop Charles Proxy Recording
#    Then verify Charles Proxy Logs for all attribute with tag "clipexpiringsoon"

#
#
#  Scenario: Verify Analytics tags on Deals Page_expiring soon with fasttab
#
#    Then Click on Expiring Soon page
#    Then user clicks on clip coupon with fast tab
#    Then download Charles Logs in File "clipexpiringsoon"
#    Then stop Charles Proxy Recording
#    Then verify Charles Proxy Logs for all attribute with tag "clipexpiringsoon"



#-------------- Cliping in For you-----android pending-

#  Scenario: Verify Analytics tags on Deals Page_For you with cliping
#    Then user click on Deals Tab
#    And user Click on For You tab
# And user click on item you may like see all
#    Then user clicks on clip coupon
#    Then download Charles Logs in File "clipforyou"
#    Then stop Charles Proxy Recording
#    Then verify Charles Proxy Logs for all attribute with tag "clipforyou"

#  Scenario: Verify Analytics tags on Deals Page_For you  with doubleTap
#
##    Then user click on Deals Tab
#    And user Click on For You tab
#    And user click on item you may like see all
#    Then user clicks on clip coupon with double tap
#    Then download Charles Logs in File "clipforyou"
#    Then stop Charles Proxy Recording
#    Then verify Charles Proxy Logs for all attribute with tag "clipforyou"


#
#  Scenario: Verify Analytics tags on Deals Page_For you  with longPress
#
#
#    And user Click on For You tab
#    And user click on item you may like see all
#    Then user clicks on clip coupon with longPress
#    Then download Charles Logs in File "clipforyou"
#    Then stop Charles Proxy Recording
#    Then verify Charles Proxy Logs for all attribute with tag "clipforyou"

#
#   Scenario: Verify Analytics tags on Deals Page_expiring soon with fasttab
#
#     And user Click on For You tab
#     And user click on item you may like see all
#     Then user clicks on clip coupon with fast tab
#     Then download Charles Logs in File "clipforyou"
#     Then stop Charles Proxy Recording
#     Then verify Charles Proxy Logs for all attribute with tag "clipforyou"

#---------#-------------- Cliping in categories------
#  Scenario: Verify Analytics tags on Deals Page_categories with Clip
#    And click on categories tab
#    And Click on "Pet Care"
#    Then user clicks on clip coupon
#    Then download Charles Logs in File "clipCategories"
#    Then stop Charles Proxy Recording
#    Then verify Charles Proxy Logs for all attribute with tag "clipCategories"

#  Scenario: Verify Analytics tags on Deals Page_categories  with doubleTap
#
##    Then user click on Deals Tab
#    And click on categories tab
#   And Click on "Pet Care"
#    Then user clicks on clip coupon with double tap
#    Then download Charles Logs in File "clipCategories"
#    Then stop Charles Proxy Recording
#    Then verify Charles Proxy Logs for all attribute with tag "clipCategories"

#
#  Scenario: Verify Analytics tags on Deals Page_categories  with longPress
#
#
#    And click on categories tab
#    And Click on "Pet Care"
#    Then user clicks on clip coupon with longPress
#    Then download Charles Logs in File "clipCategories"
#    Then stop Charles Proxy Recording
#    Then verify Charles Proxy Logs for all attribute with tag "clipCategories"


#
#  Scenario: Verify Analytics tags on Deals Page_categories with fasttab
#
#    And click on categories tab
#    And Click on "Pet Care"
#    Then user clicks on clip coupon with fast tab
#    Then download Charles Logs in File "clipCategories"
#    Then stop Charles Proxy Recording
#    Then verify Charles Proxy Logs for all attribute with tag "clipCategories"


#  #---------home ios pending
#  Scenario: Verify Analytics tags on Home page Clip
#    And click on home tab
#    Then user clicks on clip coupon on home page
#    Then download Charles Logs in File "clipHome"
#    Then stop Charles Proxy Recording
#    Then verify Charles Proxy Logs for all attribute with tag "clipHome"

  Scenario: Verify Analytics tags on  Home page Clip with doubleTap

    And click on home tab
    Then user clicks on clip coupon with double tap
    Then download Charles Logs in File "clipHome"
    Then stop Charles Proxy Recording
    Then verify Charles Proxy Logs for all attribute with tag "clipHome"

#
#  Scenario: Verify Analytics tags on Home page Clip  with longPress
#
#    And click on home tab
#    Then user clicks on clip coupon with longPress
#    Then download Charles Logs in File "clipHome"
#    Then stop Charles Proxy Recording
#    Then verify Charles Proxy Logs for all attribute with tag "clipHome"


#
#  Scenario: Verify Analytics tags on Home page Clip with fasttab
#
#    And click on home tab
#    Then user clicks on clip coupon with fast tab
#    Then download Charles Logs in File "clipHome"
#    Then stop Charles Proxy Recording
#    Then verify Charles Proxy Logs for all attribute with tag "clipHome"
  #------browse----

#    Scenario: Verify Analytics tags on Browse page Clip
#    And  user click on Browse Tab
#    And user click on Go to Deals
#    And Click on "Pet Care"
#    Then user clicks on clip coupon
#    Then download Charles Logs in File "clipCategories"
#    Then stop Charles Proxy Recording
#    Then verify Charles Proxy Logs for all attribute with tag "clipCategories"
#
#        Scenario: Verify Analytics tags on Deals Page_ browse categories  with doubleTap
#
#      And  user click on Browse Tab
#      And user click on Go to Deals
#      And Click on "Pet Care"
#      Then user clicks on clip coupon with double tap
#      Then download Charles Logs in File "clipCategories"
#      Then stop Charles Proxy Recording
#      Then verify Charles Proxy Logs for all attribute with tag "clipCategories"

#
#  Scenario: Verify Analytics tags on Deals Page_ browse categories  with longPress
#
#
#    And  user click on Browse Tab
#    And user click on Go to Deals
#    And Click on "Pet Care"
#    Then user clicks on clip coupon with longPress
#    Then download Charles Logs in File "clipCategories"
#    Then stop Charles Proxy Recording
#    Then verify Charles Proxy Logs for all attribute with tag "clipCategories"


#
  Scenario: Verify Analytics tags on Deals Page_ browse categories with fasttab

    And  user click on Browse Tab
    And user click on Go to Deals
    And Click on "Pet Care"
    Then user clicks on clip coupon with fast tab
    Then download Charles Logs in File "clipCategories"
    Then stop Charles Proxy Recording
    Then verify Charles Proxy Logs for all attribute with tag "clipCategories"
