Feature: Barcode Scan


  #C69258
  @regression @module_dashboard @barcodescanner @start_scenario
  Scenario: As a user, I should see two options i.e Deals and Product on the toggle button of  Scan screen, and deals is selected by default
    When sign in to the application
    Then verify home screen is displayed
    And go to Home tab
    When click on barcode scan option
    And click allow on camera permission popup
    And click get started on tutorials
    Then verify Deals option present on toggle button
    Then verify Product option present on toggle button
    And click close icon on scan screen

  #C69261
  @regression @module_dashboard @barcodescanner @functional
  Scenario: As a user, On scan screen I should be able to toggle between deals and products and flash light is shown for both the options
    When go to Home tab
    And click on barcode scan option
    And toggle deals to product
    Then verify product option selected
    And toggle product to deals
    Then verify Deals option selected
    And click close icon on scan screen

  #C69273
  @regression @module_dashboard @barcodescanner @functional
  Scenario:  As a User,  when i select  'Products' option from the toggle switch to scan any product, i should see the scan page as per the design
    When go to Home tab
    And select in-store run using zip code and store name
    And click on barcode scan option
    And click allow on camera permission popup
    And click get started on tutorials
    When toggle deals to product
    Then verify product option selected
    Then verify scan to shop drawer text when "InStore" mode is selected
    And click close icon on scan screen

  #C69290
  @regression @module_dashboard @barcodescanner
  Scenario: As a user , I should see header as Scan to clip , when user selects deals option
    When go to Home tab
    And click on barcode scan option
    And toggle product to deals
    Then verify Deals option selected
    And verify scan to clip title is displayed
    And click close icon on scan screen

    #C69333
  @regression @module_dashboard @barcodescanner
  Scenario: As a user I Should see the barcode scan option in the search bar
    When go to Home tab
    Then verify that barcode scan option is displayed

   #C69341
  @regression @module_dashboard @barcodescanner @functional
  Scenario: As a user I should be able to click on the 'Get Started' on the tutorial Screen.
    When go to Home tab
    And click on barcode scan option
    And click allow on camera permission popup
    And click get started on tutorials

  #C69354
  @regression @module_dashboard @barcodescanner @functional
  Scenario: As a user, I should able to see screen retains from running app in background and launching the app
    When install the application
    And launch the application
    When sign in to the application
    Then verify home screen is displayed
    And go to Home tab
    And click on barcode scan option
    Then click On deny Permission on pop up
    And click get started on tutorials
    Then verify Camera Please Pop Up is Displayed
    When keep app in background and relaunching the same
    Then verify Camera Please Pop Up is Displayed


   #C69349
  @regression @module_dashboard @barcodescanner @functional
  Scenario: As a user, I should see onboarding screen on deny the permission to share the camera access during barcode scan
    When install the application
    And launch the application
    And sign in to the application
    Then verify home screen is displayed
    And go to Home tab
    When click on barcode scan option
    Then click On deny Permission on pop up
    And verify Tutorial page is Displayed

    #C69351
  @regression @module_dashboard @barcodescanner @functional
  Scenario: As a user, I should navigate to the settings screen of the device on clicking "Open settings" CTA in "Camera please" popup
    When install the application
    And launch the application
    When sign in to the application
    Then verify home screen is displayed
    And go to Home tab
    And click on barcode scan option
    Then click On deny Permission on pop up
    And click get started on tutorials
    Then verify Camera Please Pop Up is Displayed
    When click On Open Setting CTA
    And verify Setting Page is Displayed

    #C69264
  @regression @module_dashboard @barcodescanner
  Scenario: As a user, I should see that the scan screen is displayed as per UX
    When install the application
    And launch the application
    When sign in to the application
    Then verify home screen is displayed
    And go to Home tab
    And click on barcode scan option
    When click allow on camera permission popup
    When click get started on tutorials
    Then verify Deals option present on toggle button
    And verify Product option present on toggle button
    Then verify flash option is displayed

    #C69267
  @regression @module_dashboard @barcodescanner @functional
  Scenario: As a user ,   I should retain scan screen  should persist if we run the app in background and goes back to dashboard on killing the app
    When install the application
    And launch the application
    When sign in to the application
    Then verify home screen is displayed
    And go to Home tab
    When click on barcode scan option
    And click allow on camera permission popup
    And click get started on tutorials
    Then verify Deals option selected
    And move app with barcode scan page to background and bring it back to foreground
    Then verify Deals option selected
    When kill the application
    And relaunch the application
    And handle zip code page if displayed
    And handle tutorial if displayed on home page
    Then verify home screen is displayed
    And go to Home tab
    When click on barcode scan option
    Then verify Deals option selected
    And click close icon on scan screen

      #C69287
  @regression @module_dashboard @barcodescanner @functional
  Scenario: As a User,  user should see 'Scan to Shop' screen, on keeping the app in background and relaunching the same and lands on dashboard on killing the the app and launching the app again
    When go to Home tab
    And click on barcode scan option
    And click allow on camera permission popup
    And click get started on tutorials
    When toggle deals to product
    Then move app with barcode scan page to background and bring it back to foreground
    And verify scan to shop title is displayed
    When kill the application
    And relaunch the application
    And handle zip code page if displayed
    And handle tutorial if displayed on home page
    Then verify home screen is displayed
    And go to Home tab
    And click on barcode scan option
    When toggle deals to product
    And verify scan to shop title is displayed
    And click close icon on scan screen

   #C69355
  @regression @module_dashboard @barcodescanner
  Scenario: As a User, I should not see Onboarding screen again for the same user
    When go to Home tab
    And click on barcode scan option
    And kill and relaunch the application without popup handling
    And go to Home tab
    And handle tutorial if displayed on home page
    When click on barcode scan option
    Then user is allow to scan

    #C69352
  @regression @module_dashboard @barcodescanner
  Scenario: As a user, I should see ''Camera Please" popup as per the respective themes and banners
    When install the application
    And launch the application
    When sign in to the application
    Then verify home screen is displayed
    And go to Home tab
    And click on barcode scan option
    Then click On deny Permission on pop up
    And click get started on tutorials
    Then verify Camera Please Pop Up is Displayed

       #C69336
  @regression @module_dashboard @barcodescanner @functional
  Scenario: Verify Camera Permission and Tutorial is shown only once per install
    When install the application
    And launch the application
    When sign in to the application
    Then verify home screen is displayed
    And go to Home tab
    When click on barcode scan option
    And click allow on camera permission popup
    And click get started on tutorials
    Then user is allow to scan
    And click close icon on scan screen
    When click on barcode scan option
    Then user is allow to scan

  #C69335
  @regression @module_dashboard @barcodescanner @functional @end_scenario
  Scenario: Verify Tutorial Screen is presented and Camera permission screen for the first time
    When install the application
    And launch the application
    When sign in to the application
    Then verify home screen is displayed
    And go to Home tab
    And click on barcode scan option
    And click allow on camera permission popup
    And click get started on tutorials
    Then user is allow to scan
    And click close icon on scan screen
    When click on barcode scan option
    Then user is allow to scan
    And click close icon on scan screen