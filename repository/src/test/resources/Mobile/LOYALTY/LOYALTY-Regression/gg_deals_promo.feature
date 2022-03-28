Feature: Deals - Promo

  #C69051
  @regression @module_deals @deals_promo @functional @smoke @start_scenario
  Scenario: As a user, I should see Image, Title , Description and CTA for a Promo Deal
    When sign up to the application with popup handling
    Then verify home screen is displayed
    And go to Deals tab
    And go to 'Promo' Tab
    And Verify 'Promo card' is displayed
    And verify Promo card subject title
    And verify Promo card description
    And verify Promo card CTA button
    Then verify Image on promo deal

  #C69047
  @regression @module_deals @deals_promo @functional
  Scenario: As a user, I should see the Promo deals tab in Deals section and I should navigate to the promo details page on tapping Promo deal card.
    And navigate to deals tab
    And go to 'Promo' Tab
    And verify Promo card subject title
    Then click on promo deal
    And verify promo deal details page is displayed
    And navigate back to previous page

   #C69143
  @regression @module_deals @deals_promo
  Scenario: As a user, I want to see all  colors & font must be customized as per themes and banners
    And navigate to deals tab
    And go to 'Promo' Tab
    And Verify 'Promo card' is displayed
    And verify Promo card subject title
    And verify Promo card description
    Then verify Image on promo deal

  #C69158
  @smoke @regression @module_deals @deals_promo
  Scenario: As a user, i should see that Tapping on the Promo Card CTA button copies the PromoCode to ClipBoard
    And navigate to deals tab
    And go to 'Promo' Tab
    Then click on promo deal CTA button and verify toast message 'Promo code copied to clipboard' displayed

  #C69159
  @smoke @regression @module_deals @deals_promo
  Scenario: As a user, i should see a toast message "Promo code copied to clipboard' for 3 seconds and it should display every time on Tapping on the Promo Card CTA
    And navigate to deals tab
    And go to 'Promo' Tab
    Then click on promo deal CTA button and verify toast message 'Promo code copied to clipboard' displayed
    And wait Three seconds
    Then verify toast message 'Promo code copied to clipboard' not displayed
    Then click on promo deal CTA button and verify toast message 'Promo code copied to clipboard' displayed

  #C69161
  @smoke @regression @module_deals @deals_promo
  Scenario: As a user, i should see that the toast message displayed in deals page is as per the Figma and UX design for different banners
    And navigate to deals tab
    And go to 'Promo' Tab
    Then click on promo deal CTA button and verify toast message 'Promo code copied to clipboard' displayed

  #C69054
  @regression @module_deals @deals_promo @functional
  Scenario: Promo Deal Details page->  Kill and Relaunch, Run the app in background and bring it to foreground
    And navigate to deals tab
    And go to 'Promo' Tab
    And click on promo deal
    And verify promo deal details page is displayed
    When keep app in background and relaunching the same
    Then verify promo deal details page is displayed
    When kill the application
    And relaunch the application
    And handle zip code page if displayed
    And handle tutorial if displayed
    And go to Deals tab
    And go to 'Promo' Tab
    And click on promo deal
    And verify promo deal details page is displayed
    And navigate back to previous page

  #C16429
  @smoke @regression @module_deals @deals_promo
  Scenario: Promocode Deals - Add/remove items/ Back arrow, Cart and Search should work
    And navigate to deals tab
    And go to 'Promo' Tab
    And click on promo deal
    Then verify promo deal details page is displayed
    When click on search icon on promo deal details page
    Then click cancel button on product search page
    When go to cart screen
    Then verify checkout button displayed in cart screen
    When close cart screen
    Then verify promo deal details page is displayed
    And navigate back to previous page

  #C69623
  @regression @module_deals @deals_promo @functional @end_scenario
  Scenario: Kill and relaunch - deals(Promo)
    And navigate to deals tab
    And go to 'Promo' Tab
    And verify Promo card CTA button
    When kill and relaunch the application without popup handling
    And click Continue on cache pop up for "android" platform
    And handle tutorial if displayed
    And go to Deals tab
    And go to 'Promo' Tab
    And verify Promo card CTA button