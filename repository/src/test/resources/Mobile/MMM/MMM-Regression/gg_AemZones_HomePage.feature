@gg_AemZones_HomePage
Feature: Validate AEM Zones in Home Page

  @unittest
  Scenario: User verifies UI of AEM Zone Carousel in Home
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When scroll down for "Summer Grilling" carousel
    And scroll down the screen
    Then verify Carousel title is displayed
#    Then verify Carousel sub title is displayed
    Then verify Carousel ctaText is displayed
    When user click item add on carousel in HomePage
#    When user clicks "1" item add button on carousel
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    Then shopping cart shows 1 as total number
    When user swipe left to remove all item in shopping cart
    And user click check mark on shopping cart page
#    Then verify "1" item add button on first item
    When user navigate to pdp of first product
    Then product detail page is displayed
    When user clicks add button on the product detail page
    And user clicks shopping cart button on home page
    Then shopping cart shows 1 as total number

  @smoke
  Scenario: Verify Medium banner with CTA Type=landing-page with AEM Parity flag-on
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
      #When scroll down for "LP banner" medium banner
    When scroll down for "CTA LP" banner
    Then verify banner CTA Type LP is displayed
    Then Verify takes user to the custom landing page
    And Verify banner title as page name for landing page
    When Verify Click back arrow takes the user to home page and should retain position

  @unittest
  Scenario: Verify Medium banner with CTA Type=none in home page with AEM Parity flag-on
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    #When scroll down for "Banner- No CTA" medium banner
    When scroll down for "CTA None" banner
    Then verify banner CTA Type None is displayed
    And Then verify no action on CTA click and user remains on the home page


  @regression
  Scenario: Verify Medium banner CTAType=search with AEM Parity flag -on
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When scroll down for "CTA search" banner
    Then click "CTA search" banner
    And  verify search bar "is" displayed
    And user should see searched products
    When Verify Click back arrow takes the user to home page and should retain position


  @regression
  Scenario: Verify Medium banner CTAType=search with AEM Parity flag -on
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user click aisles tab on home page
    And scroll down for "CTA search" banner
    Then click "CTA search" banner
    And  verify search bar "is" displayed
    And user should see searched products
    When Verify Click back arrow takes the user to home page and should retain position


  @regression
  Scenario: Verify Medium banner CTAType=search with AEM Parity flag -on
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user click aisles tab on home page
    And scroll down for "CTA external" banner
    Then click "CTA external" banner
    When Verify Click back arrow takes the user to home page and should retain position


  @regression
  Scenario: Verify Medium banner CTAType=search with AEM Parity flag -on
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When scroll down for "CTA external" banner
    Then click "CTA external" banner
    When Verify Click back arrow takes the user to home page and should retain position


  @regression
  Scenario:Verify sheet UI on home page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When scroll down for "Summer Grilling" carousel on home page
    Then verify Carousel title is displayed on home page
   # Then verify Carousel sub title is displayed
    Then verify Carousel CTA is displayed at home page
    When user clicks on CTA button from Carousel zones at home page
    Then verify Carousel sheet title is displayed
    Then verify Carousel sheet sub title is displayed
    Then verify Carousel sheet close CTA is displayed
    When user clicks "1" item add button on first item
    Then user scroll up and down to view products in Sheet UI
    And verify "X" should close the sheet reveal the behind screen
    Then verify Carousel title is displayed on home page

  @regression
  Scenario:Verify AEM Zone carousel on Landing page from home
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When scroll down for "LP banner" lp carousel on home page
    Then verify LPA Carousel title is displayed on home page
    Then verify LPA Carousel sub title is displayed on home page
    Then verify LPA Carousel CTA is displayed at home page
  #  When user clicks on LPA CTA button from Carousel zones at home page
    When user clicks on LPA Carousel zones at home page
    Then verify LPA Carousel title is displayed
    Then verify Carousel title is displayed
    Then verify Carousel sub title is displayed
    Then verify Carousel ctaText is displayed
  #  When scroll down for "Landing Page banner" carousel
    When scroll down for "Landing Page banner" carousel on Landing page
#    When scroll down for "LP banner" carousel on home page
    Then verify "Add" button is displayed on the Landing page
    When user clicks "1" item add button on first item
    Then user scroll left and right to view products in carousel
    And user navigate back to the previous screen
    Then verify LPA Carousel title is displayed on home page


  @unittest  #MMM-2586
  Scenario: Verify AEM zone carousel with CTA Type=none in home page with AEM Parity flag-on
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    Then user selects the In-store on the list
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When scroll down for "BPN Carousel" carousel
    Then verify "BPN Carousel" title is displayed
    Then verify "carousel - no cta" sub title is displayed
    Then verify "CTA None" seeAll button title is displayed
    When user clicks on "CTA None" seeAll button title
    Then verify user is not taken to sheetUI


  @unittest  #MMM-2588
  Scenario: Verify medium banner with CTA Type=search in Home page landing page with AEM Parity flag-on
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    Then user selects the In-store on the list
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When scroll down for "LP banner" carousel
#    When scroll down for "Banner- Landing Page" medium banner
    And user clicks on "LP banner" button
    And scroll down for "Banner CTA Search" carousel
#    And scroll down for "Banner CTA Search" carousel on Landing page
    And user clicks on "Banner CTA Search" button
    Then user see results found for searched item
    Then user navigates back to Home Page
    Then verify user is able to see "LP banner"

  @unittest  #MMM-2587
  Scenario: Verify medium banner with CTA Type=external in browse page landing page with AEM Parity flag-on
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    Then user selects the In-store on the list
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When scroll down for "LP banner" carousel
#    When scroll down for "Banner- Landing Page" medium banner
    And user clicks on "LP banner" button
    And scroll down for "Banner External Link" carousel
#    And scroll down for "Banner CTA Search" carousel on Landing page
    And user buffers "Banner External Link" product name in landing page
    And user clicks on "Banner External Link" button
    Then user lands in external landing page
#    Then user see results found for searched item
    When user navigates back from External link to landing page
    Then verify user is able to see "Banner External Link"


  @unittest  #MMM-2590
  Scenario: Verify medium banner with CTA Type=landing page in browse page landing page with AEM Parity flag-on
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    Then user selects the In-store on the list
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When scroll down for "LP banner" carousel
#    When scroll down for "Banner- Landing Page" medium banner
    And user clicks on "LP banner" button
    And scroll down for "Landing Page Banner" carousel
#    And scroll down for "Banner CTA Search" carousel on Landing page
    And user buffers "Landing Page Banner" product name in landing page
    And user clicks on "Landing Page Banner" button
    Then user lands in landing page
#    Then user lands in external landing page
#    Then user see results found for searched item
    When user navigates back from External link to landing page
    Then verify user is able to see "Landing Page Banner"
    When Verify Click back arrow takes the user to home page and should retain position


  @unittest  #MMM-2844
  Scenario: Verify medium banner with CTA Type=none in home page landing page with AEM Parity flag-on
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    Then user selects the In-store on the list
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When scroll down for "LP banner" carousel
    And user clicks on "LP banner" button
    And scroll down for "Banner - CTA None" carousel
    And user buffers "Banner - CTA None" product name in landing page
    And user clicks on "Banner - CTA None" button
    Then verify user is able to see "Banner - CTA None"
    Then verify user is able to see "LP banner"
    When Verify Click back arrow takes the user to home page and should retain position


  @unittest  #MMM-3251
  Scenario: Verify AEM Zone carousel with CTA Type=sheetUI in home page landing page with AEM Parity flag-on
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    Then user selects the In-store on the list
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    And scroll down for "LP banner" carousel
    And user clicks on "LP banner" button
    And scroll down for "Carousel Title" carousel
    And user clicks on "CTA Label" ctaLabel button
    Then verify Carousel sheet title is displayed
    Then verify Carousel sheet sub title is displayed
    Then verify Carousel sheet close CTA is displayed
    Then user scroll up and down to view products in Sheet UI
    When user clicks "1" item add button on first item
    And click on the first product to go to pdp
    And user clicks increase button for 1 times on cart page
    And user click back button from pdp
    And click "X" should close sheet in iOS
    Then verify Carousel title is displayed on home page


  @unittest    #MMM-2589
  Scenario: Verify AEM Zone carousel with CTA Type=none in home page landing page with AEM Parity flag-on
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    Then user selects the In-store on the list
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When scroll down for "LP banner" carousel
    And user clicks on "LP banner" button
    And scroll down for "Carousel - CTA None" carousel
    And user buffers "Carousel - CTA None" product name in landing page
    And user clicks on "CTA None" ctaLabel button
    Then verify user is able to see "Carousel - CTA None"
    When Verify Click back arrow takes the user to home page and should retain position

  @MOLN-4333
  Scenario: Verify Meals AEM Banner and Halo Nav on Home Page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    Then user selects the In-store on the list
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When scroll down for "Meals made easy" carousel
    And user clicks on "Meals made easy" button
    Then verify meals homepage or onboarding flow is displayed

  @MOLN-4535
  Scenario: Verify Meals AEM Banner and Halo Nav on Home Page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    Then user selects the In-store on the list
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When scroll Down to weekly ad banner section in deals
    And click on weekly ad banner
    Then verify user is on the weekly ads page
    And user click on any first AD banner
    And user choose first item of banner
    When user has added this item to the list
    Then CTA on the card is changed to "Remove from list" from Add to List
    Then verify ad is added to List under My List page
    Then click on home tab
    When scroll up to weekly ads section
    And click on weekly ad banner
    Then verify user is on the weekly ads page
    And user click on any first AD banner
    And user choose first item of banner
    When user has removed this item from the list
    Then CTA on the card is changed to Add to list
    Then verify my list screen is empty having zero items and deals in the list


  @SwathiTest4451UC1  #MMM-4451 #simple carousel on home page
  Scenario: Verify Simple carousel  CTA type with sheetUI
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    Then click on Hamburger image, developer settings and scroll for "aemSimpleCarousel" feature
    When turn "ON" aemSimpleCarousel feature
    Then click on Hamburger image, developer settings and scroll for "multiCtaCarousals" feature
    When turn "ON" multiCtaCarousel feature
    Then kill the application
    And relaunch the application
    Then verify MFA home screen is displayed
    When scroll down for "Simple Carousel" banner
    Then verify Carousel title is displayed
    Then verify Carousel sub title is displayed
    Then verify Carousel ctaText is displayed
    Then Verify CTA link takes user to the custom sheet UI
    Then verify Carousel sheet close CTA is displayed
    And verify "X" should close the sheet reveal the behind screen
    Then verify Carousel title is displayed

  @SwathiTest4451UC2  #MMM-4451 #simple carousel with BG CTA type on home page
  Scenario: Verify simple carousel with BG, CTA type with Landing Page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    Then click on Hamburger image, developer settings and scroll for "aemSimpleCarousel" feature
    When turn "ON" aemSimpleCarousel feature
    Then click on Hamburger image, developer settings and scroll for "multiCtaCarousals" feature
    When turn "ON" multiCtaCarousel feature
    Then kill the application
    And relaunch the application
    Then verify MFA home screen is displayed
    When scroll down for "LP Page CTA1" banner
    Then verify Carousel title is displayed
    Then verify Carousel sub title is displayed
    Then verify Carousel ctaText is displayed
    Then Verify CTA link takes user to the Simple Carousel custom landing page
    When user clicks on back arrow in landing page
    Then verify Carousel title is displayed


  @SwathiTest4452UC1  #MMM-4452 #Verify Large banner CTA type External page on home screen - Data in Tomthumb banner
  Scenario: Verify large carousel, CTA type with External Page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    Then click on Hamburger image, developer settings and scroll for "aemLargeBanner" feature
    When turn "ON" aemLargeBanner feature
    Then click on Hamburger image, developer settings and scroll for "multiCtaCarousals" feature
    When turn "ON" multiCtaCarousel feature
    Then kill the application
    And relaunch the application
    Then verify MFA home screen is displayed
    And scroll down for "LB External CTA" carousel
    And user buffers "LB External CTA" product name in landing page
    And user clicks on "LB External CTA" button
    Then user lands in external landing page
    When user navigates back from External link to landing page
    Then verify user is able to see "LB External CTA"

  @SwathiTest4452UC2  #MMM-4452 #Verify Large banner CTA type landing page on home screen - Data in Tomthumb banner
  Scenario: Verify large carousel, CTA type with Landing Page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    Then click on Hamburger image, developer settings and scroll for "aemLargeBanner" feature
    When turn "ON" aemLargeBanner feature
    Then click on Hamburger image, developer settings and scroll for "multiCtaCarousals" feature
    When turn "ON" multiCtaCarousel feature
    Then kill the application
    And relaunch the application
    Then verify MFA home screen is displayed
    When scroll down for "LB LP CTA" banner
    Then Verify click on Large Banner takes user to custom landing page
    And Verify Large banner title as page name for landing page
    When user clicks on back arrow in landing page
    Then verify Large Banner with Landing Page CTA is displayed

  @unittest  #MMM-4450 #large carousel with light theme CTA Type = external
    #data setup in StarMarket banner : zipcode-02215
  Scenario: Verify large carousel with Light Theme, CTA type external
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    Then click on Hamburger image, developer settings and scroll for "aemLargeCarousel" feature
    When turn "ON" aemLargeCarousel feature
    Then click on Hamburger image, developer settings and scroll for "multiCtaCarousals" feature
    When turn "ON" multiCtaCarousel feature
    Then kill the application
    And relaunch the application
    Then verify MFA home screen is displayed
    When scroll down for "LC External CTA" banner
    Then verify "LC External CTA" title is displayed
    Then verify "External CTA" sub title is displayed
    Then verify "See All" seeAll button title is displayed
    When user clicks on "See All" ctaLabel button
#    When user clicks on "See All" seeAll button title
    And user buffers "LC External CTA" product name in landing page
    Then user lands in external landing page
    When user navigates back from External link to landing page
    Then verify user is able to see "LC External CTA"

  @unittest  #MMM-4450 #large carousel with dark theme CTA Type = search
    #data setup in StarMarket banner : zipcode-02215
  Scenario: Verify large carousel with Dark Theme, CTA type search in HP
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    Then click on Hamburger image, developer settings and scroll for "aemLargeCarousel" feature
    When turn "ON" aemLargeCarousel feature
    Then click on Hamburger image, developer settings and scroll for "multiCtaCarousals" feature
    When turn "ON" multiCtaCarousel feature
    Then kill the application
    And relaunch the application
    Then verify MFA home screen is displayed
    When scroll down for "LC Search CTA" banner
    Then verify "LC Search CTA" title is displayed
    Then verify "Search CTA" sub title is displayed
    Then verify "See All" seeAll button title is displayed
    When user clicks on "See All" ctaLabel button
    And  verify search bar "is" displayed
    And user should see searched products
    Then user navigates back to Home Page


  @SwathiTest4719UC1  #MMM-4719 #On home page - zone1 — Medium Banner – CTA type- PDP
    #data setup in Pavilions banner : zipcode-90069
  Scenario: Verify Medium banner with CTA type PDP
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When scroll down for "Medium Banner with Text Plate" banner
    Then verify "Medium Banner with Text Plate" title is displayed
    Then verify "PDP CTA" sub title is displayed
    Then verify "Shop Now" seeAll button title is displayed
    When user clicks on Shop Now ctaLabel button
    Then verify PDP screen
    When user clicks "+" button "2" number of times to add or remove item in pdp page
    Then verify the quantity of the product selected is "2"
    When user clicks "-" button "1" number of times to add or remove item in pdp page
    Then verify the quantity of the product selected is "1"
    When scroll down the screen
    Then Add Item from Related Products
    Then user clicks on View All for Related products
    And user click back button from pdp page
    When scroll down for "Ingredients" banner
    Then verify "Ingredients" title is displayed
    Then verify "Ingredients" tab is clickable
    When scroll down for "Details" banner
    Then verify "Details" title is displayed
    Then verify "Details" tab is clickable
    When scroll down for "More" banner
    Then verify "More" title is displayed
    Then verify "More" tab is clickable
    Then user click on search icon on pdp page
    Then "Currently Trending" text is displayed on the screen
    When click on My Cart Icon
    Then verify cart is Displayed
    And click on close button on my cart screen
    And click on Cancel in Search page
    Then verify "Medium Banner with Text Plate" title is displayed

  @SwathiTest4719UC2  #MMM-4719 #On home page - zone1 — Large Banner – CTA type- PDP
    #data setup in Pavilions banner : zipcode-90069
  Scenario: Verify large banner with CTA type PDP
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When scroll down for "Large Banner with Text Plate" banner
    Then verify "Large Banner with Text Plate" title is displayed
    Then verify "PDP CTA" sub title is displayed
    And click on Large Banner with Pdp Cta
    Then verify PDP screen
    When user clicks "+" button "2" number of times to add or remove item in pdp page
    Then verify the quantity of the product selected is "2"
    When user clicks "-" button "1" number of times to add or remove item in pdp page
    Then verify the quantity of the product selected is "1"
    When scroll down the screen
    Then Add Item from Related Products
    Then user clicks on View All for Related products
    And user click back button from pdp page
    When scroll down for "Ingredients" banner
    Then verify "Ingredients" title is displayed
    Then verify "Ingredients" tab is clickable
    When scroll down for "Details" banner
    Then verify "Details" title is displayed
    Then verify "Details" tab is clickable
    When scroll down for "More" banner
    Then verify "More" title is displayed
    Then verify "More" tab is clickable
    Then user click on search icon on pdp page
    Then "Currently Trending" text is displayed on the screen
    When click on My Cart Icon
    Then verify cart is Displayed
    And click on close button on my cart screen
    And click on Cancel in Search page
    Then verify "Large Banner with Text Plate" title is displayed

  @SwathiTest4719UC3  #MMM-4719 #On home page - zone1 — Simple Carousel – CTA type- PDP
    #data setup in Pavilions banner : zipcode-90069
  Scenario: Verify Simple Carousel with CTA type PDP
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When scroll down for "Simple Carousel" banner
    Then verify "Simple Carousel" title is displayed
    Then verify "PDP CTA" sub title is displayed
    Then verify "Shop Now" seeAll button title is displayed
    When user clicks on Shop Now ctaLabel button
    Then verify PDP screen
    When user clicks "+" button "2" number of times to add or remove item in pdp page
    Then verify the quantity of the product selected is "2"
    When user clicks "-" button "1" number of times to add or remove item in pdp page
    Then verify the quantity of the product selected is "1"
    When scroll down the screen
    Then Add Item from Related Products
    Then user clicks on View All for Related products
    And user click back button from pdp page
    When scroll down for "Ingredients" banner
    Then verify "Ingredients" title is displayed
    Then verify "Ingredients" tab is clickable
    When scroll down for "Details" banner
    Then verify "Details" title is displayed
    Then verify "Details" tab is clickable
    When scroll down for "More" banner
    Then verify "More" title is displayed
    Then verify "More" tab is clickable
    Then user click on search icon on pdp page
    Then "Currently Trending" text is displayed on the screen
    When click on My Cart Icon
    Then verify cart is Displayed
    And click on close button on my cart screen
    And click on Cancel in Search page
    Then verify "Simple Carousel" title is displayed

  @SwathiTest4719UC4  #MMM-4719 #On home page - zone1 — Large Carousel – CTA type- PDP
    #data setup in Pavilions banner : zipcode-90069
  Scenario: Verify Simple Carousel with CTA type PDP
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When scroll down for "Large Carousel" banner
    Then verify "Large Carousel" title is displayed
    Then verify "PDP CTA" sub title is displayed
    Then verify "Shop Now" seeAll button title is displayed
    When user clicks on Shop Now ctaLabel button
    Then verify PDP screen
    When user clicks "+" button "2" number of times to add or remove item in pdp page
    Then verify the quantity of the product selected is "2"
    When user clicks "-" button "1" number of times to add or remove item in pdp page
    Then verify the quantity of the product selected is "1"
    When scroll down the screen
    Then Add Item from Related Products
    Then user clicks on View All for Related products
    And user click back button from pdp page
    When scroll down for "Ingredients" banner
    Then verify "Ingredients" title is displayed
    Then verify "Ingredients" tab is clickable
    When scroll down for "Details" banner
    Then verify "Details" title is displayed
    Then verify "Details" tab is clickable
    When scroll down for "More" banner
    Then verify "More" title is displayed
    Then verify "More" tab is clickable
    Then user click on search icon on pdp page
    Then "Currently Trending" text is displayed on the screen
    When click on My Cart Icon
    Then verify cart is Displayed
    And click on close button on my cart screen
    And click on Cancel in Search page
    Then verify "Large Carousel" title is displayed

  @unittestunfinished  #MMM-4735 #large carousel in LP with CTA Type = search
    #data setup in StarMarket banner : zipcode-02215
    #unfinished iOS unit test pending
  Scenario: Verify large carousel in LP from Home page with CTA Type Search
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When scroll down for "LC LP CTA" banner
    Then verify "LC LP CTA" title is displayed
    Then verify "Simple1" sub title is displayed
    Then verify "View All" seeAll button title is displayed
    When user clicks on "View All" ctaLabel button
    Then verify Carousel title is displayed
    When scroll down for "Simple Search CTA" banner
    Then verify "Simple Search CTA" title is displayed
    Then verify "Carousel Dark Theme" sub title is displayed
    Then verify "See All" seeAll button title is displayed
    When user clicks on "See All" ctaLabel button
    And  verify search bar "is" displayed
    And user should see searched products
    And user navigates back to Home Page
    When user navigates back from External link to landing page
    Then verify user is able to see "LC LP CTA"


  @unittestunfinished  #MMM-4735 #large carousel in LP with CTA Type = aisle with filter
    #data setup in StarMarket banner : zipcode-02215
    #unfinished iOS unit test pending
  Scenario: Verify large carousel in LP from Home page with CTA Type Search
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When scroll down for "LC LP CTA" banner
    Then verify "LC LP CTA" title is displayed
    Then verify "Simple1" sub title is displayed
    Then verify "View All" seeAll button title is displayed
    When user clicks on "View All" ctaLabel button
    Then verify Carousel title is displayed
    When scroll down for "Aisles CTA" banner
    Then verify "Aisles CTA" title is displayed
    Then verify "Carousel Ligh" sub title is displayed
    Then verify "See All" seeAll button title is displayed
    When user clicks on "See All" ctaLabel button
    When user clicks "1" item add button on first item
    When click on Deals toggle in search page
    Then verify Deals toggle setting is ON state
    When click on Deals toggle in search page
    Then verify Deals toggle setting is OFF state
    When user click sort or filters from item list window
    Then user select "Alphabetical" from Sort & Filter By window
    When user clicks search icon on Aisles page
    When click on search Products Or Deals field
    And user types "cookies" on search bar
    Then user click on cancel button in search bar
    And user navigates to landing page for ios

  @SwathiTest4808  #MMM-4808 #UMA-Automation -Remove Weekly Ad small banner on home screen
  Scenario: Remove Weekly Ad small banner on home screen
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    Then click on Hamburger image, developer settings and scroll for "removeWeeklyAdBanner" feature
    When turn "OFF" removeWeeklyAdBanner feature
    Then kill the application
    And relaunch the application
    Then verify MFA home screen is displayed
    When scroll up to profile icon on home page
    And scroll down upto weekly ads section
    Then verify weekly ad banner module
    And verify weekly ad banner image
    When user click on weekly ad banner image
    Then verify weekly ad iframe title
    And user clicks on back button on page
    When scroll up to profile icon on home page
    Then click on Hamburger image, developer settings and scroll for "removeWeeklyAdBanner" feature
    When turn "ON" removeWeeklyAdBanner feature
    Then kill the application
    And relaunch the application
    Then verify MFA home screen is displayed
    When scroll down for Browse categories
    And verify weekly ad banner image is not visible
