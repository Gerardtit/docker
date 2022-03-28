Feature: Deals - All Deals

   #C69808
  @regression @module_deals @deals_alldeals @functional @start_scenario
  Scenario:  As a user, I should see all the functionalities of All deals tab in deals section
    When sign up to the application with popup handling
    And go to Home tab
    And navigate to deals tab
    And go to 'All Deals' Tab
    And verify total deals count is displayed on all deals page
    And verify deal cards are displayed in All deals screen

  #C69233
  @regression @module_deals @deals_alldeals
  Scenario: As a user, I should be able to exit the search mode when click cancel/back button
    When navigate to deals tab
    And scroll up till deals top nav bar is visible
    And go to 'All Deals' Tab
    And scroll up till top of the All Deals tab
    And click search icon on deals page
    And click cancel button on search screen
    Then verify deals screen is displayed

  #C69231
  @regression @module_deals @deals_alldeals @smoke
  Scenario: As a user, i should be able to search and find my items on Deals Page
    When navigate to deals tab
    And scroll up till deals top nav bar is visible
    And go to 'All Deals' Tab
    And scroll up till top of the All Deals tab
    And click search icon on deals page
    And click cancel button on search screen
    Then verify deals screen is displayed
    When click search icon on deals page
    And enter text "Apple" in search field
    And select item from search result list
    Then verify products listing page displayed
    When click cancel button on search screen
    Then verify deals screen is displayed

  #C20813
  @regression @module_deals @deals_alldeals
  Scenario: Search J4U Coupon
    When go to Home tab
    And scroll down to Save On Our Brands Module
    And click deal from Save on our brands module
    And click on offer terms and conditions
    Then verify offer type, details and disclaimer is displayed on offer details page
    And close deal details page

   #C69677
  @regression @module_deals @deals_alldeals @functional
  Scenario: As a user ,I should be able to see Clipped label on deals card if the deal is clipped
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And go to 'All Deals' Tab
    And scroll up till top of the All Deals tab
    And clip a deal and verify the deal is clipped
    And click on eligible products CTA on deal card
    Then verify Clipped label is displayed for the deal in deal details page
    And close deal details page
    And scroll up the screen
    And navigate to deals tab
    And click on categories tab
    And user clicks category "Baby Care" under Categories in deals tab
    And clip a deal and verify the deal is clipped
    And click on eligible products CTA on deal card
    Then verify Clipped label is displayed for the deal in deal details page
    And verify View list CTA is displayed for the deal in deal details page
    And close deal details page
    And navigate back to previous page

   #C69014
  @regression @module_deals @deals_alldeals
  Scenario: As a user i should be able to see that the deal cards which are clipped will be having the button as View products
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And go to 'All Deals' Tab
    And scroll up till top of the All Deals tab
    And clip a deal and verify the deal is clipped
    And click on eligible products CTA on deal card
    Then verify Clipped label is displayed for the deal in deal details page
    And close deal details page
    And verify Eligible products button is displayed in clipped deals screen

   #C10970
  @regression @module_deals @deals_alldeals
  Scenario: As a user, I want to see, on click of ' Clip ' CTA  changes to  "View Products"
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And go to 'All Deals' Tab
    And scroll up till top of the All Deals tab
    When click on clip cta button
    Then verify Eligible products button is displayed in clipped deals screen

  #C70279
  @regression @module_deals @deals_alldeals @smoke
  Scenario: As a user, I should see navigate to Deals screen by tapping Deals icon from Browse screen
    When go to Home tab
    And scroll up to profile icon on home page
    And scroll down upto browse category
    Then verify see all button is displayed
    When click see all in browse category
    And verify Browse page is displayed
    When navigate to deals tab
    Then verify deals screen is displayed

   #C10971
  @regression @module_deals @deals_alldeals
  Scenario: As a user, I want to see Clip CTA button and 'View Products'  as per banner themes(Figma) and UX design
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And go to 'All Deals' Tab
    And scroll up till top of the All Deals tab
    Then verify clip cta on deal card
    And verify view products state on the deal card

  #C67158
  @regression @module_deals @deals_alldeals @functional @end_scenario
  Scenario: Kill  and Relaunch  - Deals(All Coupons)
    And navigate to deals tab
    And scroll up till deals top nav bar is visible
    And go to 'All Deals' Tab
    And scroll up till top of the All Deals tab
    And kill the application
    And relaunch the application
    And handle tutorial if displayed on home page
    Then go to Deals tab
    And go to 'All Deals' Tab
    Then verify total deals count is displayed on all deals page

  ## Search icon is removed from deals
#  #C69232
#  @regression @module_deals @deals_alldeals
#  Scenario: As a user, I should be able to pick any product from my searched list and keypad shows up when tapped on search icon
#    And go to Deals tab
 #   And click on for you tab
#    And scroll up till top of the ForYou tab
#    And click search icon on deals page
#    And enter text "Apple" in search field
#    And select first item from search result
#    And close toggle info popup
#    Then verify products listing page displayed
#    And click cancel button on search screen

  ## Search icon is removed from deals
  #  #C69572
#  @regression @module_deals @deals_alldeals
#  Scenario: As a user, I want to see Deals toggle is customised as per Figma and UX design for different banners
#    And go to Deals tab
#    And click on for you tab
#    And scroll up till top of the ForYou tab
#    And click search icon on deals page
#    And enter text "Apple" in search field
#    And select item from search result list
#    And close toggle info popup
#    And verify deals toggle is displayed in search result page
#    And click cancel button on product search page

#  ## Refine button is removed from all deals
#  #C66858
#  @regression @module_deals @deals_alldeals
#  Scenario: As a user, I should see the deals count with a Show Results CTA based on the deals type filter selection.
#    When click on refine button on All deals tab
#    And verify count is displayed with Show Result CTA
#    And select option "Expiring Soon" under Sort By
#    And select option "All deals" under Coupons Type
#    And verify count is displayed with Show Result CTA
#    And select option "Expiring Soon" under Sort By
#    And select option "Personalized offers" under Coupons Type
#    And verify count is displayed with Show Result CTA
#    And select option "Expiring Soon" under Sort By
#    And select option "Coupon center" under Coupons Type
#    And verify count is displayed with Show Result CTA
#    And close refine drawer
#
#    ## Refine button is removed from all deals
#  #C66854
#  @regression @module_deals @deals_alldeals
#  Scenario: As a user , I should see Refine drawer screen with all the components as per the design(Refine drawer screen)
#    When click on refine button on All deals tab
#    Then verify option "Newest" under Sort By
#    And verify option "Expiring Soon" under Sort By
#    And verify option "All deals" under Coupons Type
#    And verify option "Personalized offers" under Coupons Type
#    And verify option "Coupon center" under Coupons Type
#    And verify option "Newest" is selected
#    And verify option "All deals" is selected
#    And verify 'Reset' button is displayed in refine Screen
#    And close refine drawer
#
#    ## Refine button is removed from all deals
#  #C66859
#  @regression @module_deals @deals_alldeals @functional
#  Scenario: As a user, I should be navigated back to all coupons screen on clicking the Show Results CTA button on the Refine drawer screen
#    When click on refine button on All deals tab
#    And click on Show Result Button
#    Then verify All deals tab is displayed
#    And verify deal cards are displayed in All deals screen
#
#    ## Refine button is removed from all deals
#    #C66868
#  @regression @module_deals @deals_alldeals
#  Scenario: As a user , I should see that the  Refine drawer screen is displayed  as per UX
#    When click on refine button on All deals tab
#    Then verify option "Newest" under Sort By
#    And verify option "Expiring Soon" under Sort By
#    And verify option "All deals" under Coupons Type
#    And verify option "Personalized offers" under Coupons Type
#    And verify option "Coupon center" under Coupons Type
#    And verify 'Reset' button is displayed in refine Screen
#    And close refine drawer
#
#    ## Refine button is removed from all deals
#   #C66841
#  @regression @module_deals @deals_alldeals @functional
#  Scenario:  As a user , I should see that all the deals are displayed in All deals screen should be as per the design
#    Then verify that 'Refine' button is displayed
#    And verify that total deals count is displayed
#    And verify deal cards are displayed in All deals screen
#
#  ## Refine button is removed from all deals
#  #C66843
#  @regression @module_deals @deals_alldeals @functional
#  Scenario:  As a user , I should see All coupons screen per the design(All deals)
#    Then verify that 'Refine' button is displayed
#    And verify that total deals count is displayed
#    And verify deal cards are displayed in All deals screen
#
#    ## Refine button is removed from all deals
#   #C66860
#  @regression @module_deals @deals_alldeals @functional
#  Scenario: As a user, On clicking the Show Results CTA button on the Refine drawer screen i should see the result on the all coupons screen based on the selected combinations under sort by label and default type filter.
#    When click on refine button on All deals tab
#    And select option "Newest" under Sort By
#    And select option "All deals" under Coupons Type
#    When click on Show Result Button
#    Then verify deals are displayed after applying filter
#
#    ## Refine button is removed from all deals
#  #C66861
#  @regression @module_deals @deals_alldeals @functional
#  Scenario: As a user, I should see result based on the selected combinations(Expiring Soon, Coupon center) upon clicking on Show Results CTA button.
#    When click on refine button on All deals tab
#    And select option "Expiring Soon" under Sort By
#    And select option "Coupon center" under Coupons Type
#    When click on Show Result Button
#    Then verify deals are displayed after applying filter
#
#    ## Refine button is removed from all deals
#  #C66862
#  @regression @module_deals @deals_alldeals @functional
#  Scenario: As a user, I should see result based on the selected combinations(Expiring Soon, All deals ) upon clicking on Show Results CTA button.
#    When click on refine button on All deals tab
#    And select option "Expiring Soon" under Sort By
#    And select option "All deals" under Coupons Type
#    When click on Show Result Button
#    Then verify deals are displayed after applying filter
#
#    ## Refine button is removed from all deals
#  #C66863
#  @regression @module_deals @deals_alldeals @functional
#  Scenario: As a user, I should see result based on the selected combinations(Newest, Coupon center) upon clicking on Show Results CTA button.
#    When click on refine button on All deals tab
#    And select option "Newest" under Sort By
#    And select option "Coupon center" under Coupons Type
#    When click on Show Result Button
#    Then verify deals are displayed after applying filter
#
#    ## Refine button is removed from all deals
#  #C66864
#  @regression @module_deals @deals_alldeals @functional
#  Scenario: As a user, I should see result based on the selected combinations(Newest,Personalized offers ) upon clicking on Show Results CTA button.
#    When click on refine button on All deals tab
#    And select option "Newest" under Sort By
#    And select option "Personalized offers" under Coupons Type
#    When click on Show Result Button
#    Then verify deals are displayed after applying filter
#
#    ## Refine button is removed from all deals
#  #C66865
#  @regression @module_deals @deals_alldeals @functional
#  Scenario: As a user, I should see result based on the selected combinations(Newest, All deals) upon clicking on Show Results CTA button.
#    When click on refine button on All deals tab
#    And select option "Newest" under Sort By
#    And select option "All deals" under Coupons Type
#    When click on Show Result Button
#    Then verify deals are displayed after applying filter
#
#    ## Refine button is removed from all deals
#  #C66866
#  @regression @module_deals @deals_alldeals @functional
#  Scenario: AS a user, I should be able to reset the selected filter on Refine drawer screen
#    When click on refine button on All deals tab
#    And select option "Expiring Soon" under Sort By
#    Then verify option "Expiring Soon" is selected
#    When select option "Coupon center" under Coupons Type
#    Then verify option "Coupon center" is selected
#    When rest filters on Refine drawer in All deals screen
#    Then verify option "Newest" is selected
#    And verify option "All deals" is selected
#    And close refine drawer
#
#    ## Refine button is removed from all deals
#   #C66867
#  @regression @module_deals @deals_alldeals @functional
#  Scenario: AS a user, I should be able  to close the refine drawer screen on by clicking the cross button
#    When click on refine button on All deals tab
#    And close refine drawer
#    Then verify All deals tab is displayed
#    And verify deal cards are displayed in All deals screen