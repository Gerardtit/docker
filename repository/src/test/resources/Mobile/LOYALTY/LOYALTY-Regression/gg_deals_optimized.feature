Feature: Deals regression

  @miniRegression
#  MRR_936
  Scenario: user clicks on deals page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94566" in zipcode page
    Then select order type page is displayed
    And user click start shopping button on Sign In page
    Then complete tutorial flow
    And user click on member tab from Home page
    When user click on wallet at member tab
    When go to Deals tab
    When clicks ForU tab
#    When go to 'Promo' Tab
#    When go to 'BOGO' Tab
    And click on categories tab
    And go to 'All Deals' Tab
    And user types "Milk" on search bar and click search on deals page
    When user click cancel button

    Then verify the total deals count is displayed
    When user click on New Deals pill
#    When user clicks on Weekly Ad pill
    When user click on Expiring Soon pill
    When user click on Coupon Centre Deals Pill
    And click on categories tab
    Then verify that saving events is displayed
    Then verify that a saving event card is displayed
    And slide the saving event card from right to left and verify its position
    And slide the saving event card from left to right and verify its position
    And verify saving Event Label is displayed
    And verify that count of deals on a saving event card is displayed
    And verify that 'See all' button is displayed next to saving events
    When click on see All link of saving event
    And verify saving Event Title is displayed
    Then verify cross button is displayed in special event screen
    Then verify close button is displayed special in event screen
    And click close button on saving events drawer if displayed
    Then verify Your Categories is displayed in category tab
    And verify category list are scrollable
    And scroll up till top of the categories tab
    And user expands category "Beverages" on category list
    Then verify clip cta on deal card
    Then verify deals category details page is displayed
    And verify category card name in Category deals details page
    Then verify deal card components
    And clip a deal if not already clipped
    Then click on Added button
#    And clip a deal and verify the deal is clipped
#    And click on eligible products CTA on deal card
    Then verify Clipped label is displayed for the deal in deal details page
    Then user clicks on view list on deal card
    Then user validates clipped item is displayed at list on Mylist
    Then verify that 'My List' Page is displayed


  @miniRegression
  Scenario: user clicks on deals page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94566" in zipcode page
    Then select order type page is displayed
    And user click start shopping button on Sign In page
    Then complete tutorial flow
    When go to Deals tab
    When user clicks on Weekly Ad pill
    When user click on Expiring Soon pill
    When clip a deal on exprirng soon
    Then click on Added button
    Then verify clipped deals label is displayed
    And close deal details page
#   When clip a deal on all coupons page
#   Then click on Added button
#   Then verify clipped deals label is displayed
    When go to Deals tab
    When clicks ForU tab
    Then user click on item you may like see all
    And click close button on deals events drawer if displayed
    Then verify Deals By Category Navigation card is Displayed
    When click on Deals By Category navigation Card
    When clicks ForU tab
    And verify All Deals Navigation card is Displayed
    When click on All Deals navigation Card
    And user click on member tab from Home page
    When user click on wallet at member tab


  Scenario: As a user, I should see Image, Title , Description and CTA for a Promo Deal
    When sign in to the application
    Then verify home screen is displayed
    And go to Deals tab
    And go to 'Promo' Tab
    And Verify 'Promo card' is displayed
    And verify Promo card subject title
    And verify Promo card description
    And verify Promo card CTA button
    Then verify Image on promo deal
    When kill and relaunch the application without popup handling
    And handle tutorial if displayed
    And go to Deals tab
    And go to 'Promo' Tab
    And verify Promo card CTA button






#----------works in prod env: BOGO----test data dependent--------------
  Scenario: As a user, I should see Image, Title , Description and CTA for a Promo Deal
    When sign in to the application
    Then verify home screen is displayed
    When go to Deals tab
    And user click Dismiss
    Then verify deals screen is displayed
    When user navigate to 'BOGO' Tab
    And user clicks Bogo item on deals page
    And user scroll down for Buy One Get One Free offer
    And adds the first BOGO offer
    And user clicks shopping cart button on home page
    Then verify BOGO offer is added in cart
    And go to 'BOGO' Tab
    And expand first available category on BOGO page
    Then verify user is able to more than 50 counts of BOGO products successfully
    When go to 'BOGO' Tab
    And expand the product category with deals "more" than 20
    And swipe left on deal cards until 'See all' is displayed on BOGO page
    And click on 'See all' button under BOGO category


#;;;;;;;;;;;;;;;;;;;dont use---------------------
    #C20813
  @regression @module_deals @deals_alldeals
  Scenario: Search J4U Coupon
    When go to Home tab
    And scroll down to Save On Our Brands Module
    And click deal from Save on our brands module
    And click on offer terms and conditions
    Then verify offer type, details and disclaimer is displayed on offer details page
    And close deal details page