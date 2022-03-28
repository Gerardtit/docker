##### this wont be available till november #######
#Feature: Dashboard_Deals_Monopoly

  #  #C69450
  #  @regression @start_scenario
  #  Scenario: As a user, i should see the web view of monopoly as expected
  #    When sign in to the application using account with Monopoly
  #     Then verify home screen is displayed
  #     When go to Home tab
  #     And verify Monopoly Banner is displayed
  #     Then click on Monopoly Banner
  #     And verify Shop Play Win Page is displayed
  #     And verify Back Button On Shop Play Win is displayed
  #     And click on Back Button On Shop Play Win Page
  #     Then verify Monopoly Banner is displayed
  #
  #  #C69448
  #  @regression
  #  Scenario: As a User, i should see Monopoly banner in the dashboard as per the design
  #    And verify Monopoly Banner is displayed
  #
  #  #C46374
  #  @regression
  #  Scenario: As a user, I should see monopoly deals in clipped deals section
  #    And go to Deals tab
  #    When go to Wallet tab
  #    Then verify wallet header
  #    When click on Clipped deals tile
  #    And click on "Special Offers" category in deals
  #    Then verify monopoly deal is present under a category in clipped deals page
  #
  #  #C46375
  #  @regression @functional
  #  Scenario: As a user, I should see monopoly deals with usage type 'U' and value 1
  #    And go to Deals tab
  #    When go to Wallet tab
  #    Then verify wallet header
  #    And click on Clipped deals tile
  #    And click on "Special Offers" category in deals
  #    Then verify monopoly deal with use "1 use available" is displayed
  #    And close deal details page
  #
  #  #C46379
  #  @regression
  #  Scenario: As a user , I should see that monopoly deals should be displayed as per different banner themes and UX design
  #    When go to Wallet tab
  #    Then verify wallet header
  #    And click on Clipped deals tile
  #    And click on "Special Offers" category in deals
  #    And verify deal title in clipped deals section
  #    Then verify deal description in clipped deals section
  #    And verify deal expiry date in clipped deal section
  #    Then verify Eligible products button is displayed in clipped deals screen
  #
  #   #C46376
  #  @regression
  #  Scenario: As a user, I should see monopoly deals with usage type 'U' and value >1
  #    When go to Wallet tab
  #    Then verify wallet header
  #    When click on Clipped deals tile
  #    And click on "Special Offers" category in deals
  #    Then verify monopoly deal with use "2 uses available" is displayed
  #    And close deal details page
  #
  #  #C46377
  #  @regression
  #  Scenario: As a user , I should see the remaining offer details & disclaimer for the monopoly deal as returned from the API.
  #    When go to Wallet tab
  #    Then verify wallet header
  #    And click on Clipped deals tile
  #    And click on "Special Offers" category in deals
  #    And verify monopoly deal is present under a category in clipped deals page
  #    Then verify offer terms and condition in deal card
  #    And close deal details page
  #
  #  #C46381
  #  @regression
  #  Scenario: As a user , I should see monopoly deals with usage type 'U' and value=1, detailed screen as per Figma  an UX design for different banners
  #    When go to Wallet tab
  #    Then verify wallet header
  #    And click on Clipped deals tile
  #    And click on "Special Offers" category in deals
  #    Then verify monopoly deal with use "1 use available" is displayed
  #    And close deal details page
  #
  #  #C46383
  #  @regression
  #  Scenario: As a user , I want to see monopoly module behaviour, when I move app in background and bring it to foreground, kill and relaunch
  #    When go to Wallet tab
  #    Then verify wallet header
  #    When click on Clipped deals tile
  #    And click on "Special Offers" category in deals
  #    Then verify monopoly deal is present under a category in clipped deals page
  #    When keep app in background and relaunching the same
  #    Then verify offer terms and condition in deal card
  #    When kill the application
  #    And relaunch the application
  #    And handle zip code page if displayed
  #    And handle tutorial if displayed on home page
  #    Then verify home screen is displayed
  #
  #  #C46378
  #  @regression
  #  Scenario: As a user , I should  see qualifying products if available, otherwise, the app should show Qualifying products (0)
  #    When go to Wallet tab
  #    Then verify wallet header
  #    And click on Clipped deals tile
  #    And click on "Special Offers" category in deals
  #    Then verify monopoly deal is present under a category in clipped deals page
  #    And verify qualifying Products is displayed
  #    And close deal details page
  #
  #    #C46341
  #  @regression
  #  Scenario: As a user, I should  see monopoly deals under the clipped deals screen in the app
  #    Then go to Wallet tab
  #    Then verify wallet header
  #    And click on Clipped deals tile
  #    And click on "Special Offers" category in deals
  #    Then verify monopoly deal is present under a category in clipped deals page
  #
  #  #C46342
  #  @regression @functional @end_scenario
  #  Scenario: As a user, I should be navigated to deal detail page on clicking on view products button for a clipped monopoly deal
  #    Then go to Wallet tab
  #    Then verify wallet header
  #    And click on Clipped deals tile
  #    And click on "Special Offers" category in deals
  #    Then verify clipped monopoly deal card is present in Clipped Deals screen
  #    When click on Eligible product button on Clipped Deals screen
  #    And verify deal detail page is displayed
  #    And close deal details page