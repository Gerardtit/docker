@gg_AemZones_BrowsePage
Feature: Validate AEM Zones in Browse Page

  @unittest
  Scenario: User verifies UI of AEM Zone Carousel in Browse
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
    And scroll down for "Carousel Title" carousel
    Then verify Carousel title is displayed
    Then verify Carousel sub title is displayed
    Then verify Carousel ctaText is displayed
    When user clicks "1" item add button on carousel
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    Then shopping cart shows 1 as total number
#    When user empty shopping cart
    When user swipe left to remove all item in shopping cart
    And user click check mark on shopping cart page
    Then verify "1" item add button on first item
    When user navigate to pdp of first product
    Then product detail page is displayed
    When user clicks add button on the product detail page
    And user clicks shopping cart button on home page
    Then shopping cart shows 1 as total number

  @unittest
  Scenario:Verify sheet UI on browse page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then verify that 'For you' Tab is displayed
   # When go to Home tab
   # Then verify MFA home screen is displayed
    And go to browse tab
    And verify navigated to browse page title
    Then verify Carousel title is displayed
    Then verify Carousel sub title is displayed
    Then verify Carousel ctaText is displayed
    When user clicks on CTA button from Carousel zones
    Then verify Carousel sheet title is displayed
    Then verify Carousel sheet sub title is displayed
    Then verify Carousel sheet close CTA is displayed
   #   Then verify "X" close icon should appear in the top right hand corner of the sheet
    When user clicks "1" item add button on first item
    Then user scroll up and down to view products in Sheet UI
    And verify "X" should close the sheet reveal the behind screen
    Then verify Carousel title is displayed

  @unittest
  Scenario: Verify Medium banner with CTA Type=landing-page in browse page with AEM Parity flag-on
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
   # When scroll down for "Banner- Landing Page" medium banner
    When scroll down for "CTA Label" banner
    Then verify banner CTA Type LP is displayed in browse Page
    Then Verify takes user to the custom landing page from browse Page
    And Verify banner title as page name for landing page from browse Page
    When Verify Click back arrow takes the user to browse page and should retain position

  @unittest
  Scenario: Verify Medium banner with CTA Type=none in browse page with AEM Parity flag-on
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
   # When scroll down for "test banner" medium banner
    When scroll down for "CTA Link none" banner
    Then verify banner CTA Type None is displayed on browse page
    And Then verify no action on CTA click and user remains on the browse page

  @unittest
  Scenario:Verify AEM Zone carousel on Landing page from home
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then verify that 'For you' Tab is displayed
    And go to browse tab
    And verify navigated to browse page title
  #  When scroll down for "LP banner" carousel on home page
    When scroll down for "Banner Landing" carousel on browse page
    Then verify LPA Carousel title is displayed on browse page
    Then verify LPA Carousel sub title is displayed on browse page
    Then verify LPA Carousel CTA is displayed at browse page
 #   When user clicks on LPA CTA button from Carousel zones at home page
    When user clicks on Banner Landing Carousel zones at browse page
  #  Then verify LPA Carousel title is displayed
    Then verify LPA Carousel title is displayed on landing page
    And scroll down on the Landing page
    Then verify Carousel title is displayed
    Then verify Carousel sub title is displayed
    Then verify Carousel ctaText is displayed
    And scroll down on the Landing page
 #   When scroll down for "Banner Landing" carousel on browse page
    Then verify "Add" button is displayed on the Landing page
    When user clicks "1" item add button on first item
    Then user scroll left and right to view products in carousel
    And user navigate back to the previous screen
    Then verify LPA Carousel title is displayed on browse page


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
    When user click aisles tab on home page
    And scroll down for "Carousel CTALink - None" carousel
    Then verify "Carousel Title" title is displayed
    Then verify "Carousel CTALink - None" sub title is displayed
    Then verify "CTA Label" seeAll button title is displayed
    When user clicks on "CTA Label" seeAll button title
    Then verify user is not taken to sheetUI


  @unittest  #MMM-2588
  Scenario: Verify medium banner with CTA Type=search in browse page landing page with AEM Parity flag-on
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
    When user click aisles tab on home page
    When scroll down for "Banner- Landing Page" carousel
#    When scroll down for "Banner- Landing Page" medium banner
    And user clicks on "Banner- Landing Page" button
    And scroll down for "Banner CTA Search" carousel
#    And scroll down for "Banner CTA Search" carousel on Landing page
    And user clicks on "Banner CTA Search" button
    Then user see results found for searched item
    Then user navigates back to Home Page
    Then verify user is able to see "Banner- Landing Page"


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
    When user click aisles tab on home page
    When scroll down for "Banner- Landing Page" carousel
#    When scroll down for "Banner- Landing Page" medium banner
    And user clicks on "Banner- Landing Page" button
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
    When user click aisles tab on home page
    When scroll down for "Banner- Landing Page" carousel
#    When scroll down for "Banner- Landing Page" medium banner
    And user clicks on "Banner- Landing Page" button
    And scroll down for "Landing Page Banner" carousel
#    And scroll down for "Banner CTA Search" carousel on Landing page
    And user buffers "Landing Page Banner" product name in landing page
    And user clicks on "Landing Page Banner" button
    Then user lands in landing page
#    Then user lands in external landing page
#    Then user see results found for searched item
    When user navigates back from External link to landing page
    Then verify user is able to see "Landing Page Banner"
    When Verify Click back arrow takes the user to browse page and should retain position


  @unittest  #MMM-2844
  Scenario: Verify medium banner with CTA Type=none in browse page landing page with AEM Parity flag-on
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
    When user click aisles tab on home page
    And scroll down for "Banner- Landing Page" carousel
    And user clicks on "Banner- Landing Page" button
    And scroll down for "Banner - CTA None" carousel
    And user buffers "Banner - CTA None" product name in landing page
    And user clicks on "Banner - CTA None" button
    Then verify user is able to see "Banner - CTA None"
    Then verify user is able to see "Banner- Landing Page"
    When Verify Click back arrow takes the user to browse page and should retain position


  @unittest  #MMM-3251
  Scenario: Verify AEM Zone carousel with CTA Type=sheetUI in browse page landing page with AEM Parity flag-on
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
    When user click aisles tab on home page
    And scroll down for "Banner- Landing Page" carousel
    And user clicks on "Banner- Landing Page" button
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


  @unittest  #MMM-2589
  Scenario: Verify AEM zone carousel with CTA Type=none in Browse page landing page with AEM Parity flag-on
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
    When user click aisles tab on home page
    And scroll down for "Banner- Landing Page" carousel
    And user clicks on "Banner- Landing Page" button
    And scroll down for "Carousel - CTA None" carousel
    And user buffers "Carousel - CTA None" product name in landing page
    And user clicks on "CTA None" ctaLabel button
    Then verify user is able to see "Carousel - CTA None"
    When Verify Click back arrow takes the user to home page and should retain position


  @unittest  #MMM-4450  #large carousel with light theme CTA Type = sheetUI
    #data setup in StarMarket banner : zipcode-02215
  Scenario: Verify large carousel with light Theme, CTA type sheetUI in BP
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
    When user click aisles tab on home page
    When scroll down for "Snacks®" banner
    Then verify "Snacks®" title is displayed
    Then verify "Must Try1" sub title is displayed
    Then verify "View All" seeAll button title is displayed
    When user clicks on "View All" ctaLabel button
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

  @unittest  #MMM-4450  #large carousel with dark theme CTA Type = sheetUI
    #data setup in StarMarket banner : zipcode-02215
  Scenario: Verify large carousel with Dark Theme, CTA type sheetUI in BP
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
    When user click aisles tab on home page
    When scroll down for "Brunch®" banner
    Then verify "Brunch®" title is displayed
    Then verify "Morning Hunger1" sub title is displayed
    Then verify "View All" seeAll button title is displayed
    When user clicks on "View All" ctaLabel button
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

  @SwathiTest4452UC3  #MMM-4452 #Verify Large banner CTA type search page on browse screen - Data in Tomthumb banner
  Scenario: Verify large carousel, CTA type with Search Page
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
    When user click aisles tab on home page
    When scroll down for "LB Search CTA" banner
    And user clicks on "LB Search CTA" button
    Then user see results found for searched item
    Then user navigates back to Home Page
    Then verify user is able to see "LB Search CTA"


  @unittestunfinished  #MMM-4735 #large carousel in LP with CTA Type = simple search CTA
    #data setup in StarMarket banner : zipcode-02215
    #unfinished iOS unit test pending
  Scenario: Verify large carousel in LP from Browse page with CTA Type Simple search CTA
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user click aisles tab on home page
    And scroll down for "LP Page CTA" banner
    Then verify "LP Page CTA" title is displayed
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
  Scenario: Verify large carousel in LP from Browse page with CTA Type Aisle with filter
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user click aisles tab on home page
    When scroll down for "LP Page CTA" banner
    Then verify "LP Page CTA" title is displayed
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

  @SwathiTest4720UC1  #MMM-4720 #On Browse page - zone1 — Medium Banner – CTA type- PDP
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
    When user click aisles tab on home page
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

  @SwathiTest4720UC2  #MMM-4720 #On Browse page - zone1 — Large Banner – CTA type- PDP
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
    When user click aisles tab on home page
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

  @SwathiTest4720UC3  #MMM-4720 #On browse page - zone1 — Simple Carousel – CTA type- PDP
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
    When user click aisles tab on home page
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

  @SwathiTest4720UC4  #MMM-4720 #On browse page - zone1 — Large Carousel – CTA type- PDP
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
    When user click aisles tab on home page
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
