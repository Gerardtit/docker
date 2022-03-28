Feature: Cart(v2)

  #Author: Harish
  #C71006
  @regression @module_cartV2 @start_scenario 
  Scenario: As a User, I should be able to see text 'Cart' as Cart header
    When sign up to the application with popup handling and registering the user
    And go to Home tab
    And go to cart screen
    Then verify header on cart screen is "Cart"
    And close cart screen

  #Author: Harish
  #C71301
  #C71300
  @regression @module_cartV2
  Scenario: As a User, I should be able to see Non-SNAP eligible items sheet with following details as per figma design
  As a User, I should be able to navigate to review cart bottom sheet which displays non-SNAP eligible items on selecting SNAP as payment mode
    Given empty the cart using API service
    When click on home tab
    And user selects a pickup store that supports SNAP EBT payment
    And search product "chicken" on home page
    And add 1 number of products on product details page
    And click back button on product details page
    And click cancel button on product search page
    And search product "Beer" on home page
    And select the refine option for search
    And refine the results by "check" the "Wine, Beer & Spirits"
    And save the filter options in refine
    And add a product on product details page
    And click back button on product details page
    And click cancel button on product search page
    And search product "Vitamins" on home page
    And select the refine option for search
    And refine the results by "check" the "Personal Care & Health"
    And save the filter options in refine
    And add a product on product details page
    And click back button on product details page
    And click cancel button on product search page
    And go to cart screen
    And user clicks on product quantity in cart screen to open quantity stepper
    And user increments product quantity in quantity stepper until checkout button is enabled in cart screen
    And user clicks checkout button in cart screen
    And user closes slot selection sheet in checkout screen
    And user chooses "YES" when confirm changes dialog is displayed in checkout screen
    And user closes contact info sheet in checkout screen
    And user closes payment sheet in checkout screen
    And user selects "SNAP-EBT" as payment method in checkout screen
    And user clicks view cart when SNAP EBT purchase issue popup is displayed in cart screen
    Then verify non-snap eligible items sheet in checkout screen
    And verify the categories in non-snap eligible items sheet are sorted alphabetically
    And user closes non-snap eligible items sheet in checkout screen
    And user clicks back button in checkout screen to go back to cart screen
    And close cart screen

  #Author: Harish
  #C71362
  @regression @module_cartV2
  Scenario: As a User, I should be able to swipe to remove the card from the bottom sheet
    Given empty the cart using API service
    When click on home tab
    And user selects a pickup store that supports SNAP EBT payment
    And search product "chicken" on home page
    And add 1 number of products on product details page
    And click back button on product details page
    And click cancel button on product search page
    And search product "Beer" on home page
    And select the refine option for search
    And refine the results by "check" the "Wine, Beer & Spirits"
    And save the filter options in refine
    And add 1 number of products on product details page
    And click back button on product details page
    And click cancel button on product search page
    And search product "Vitamins" on home page
    And select the refine option for search
    And refine the results by "check" the "Personal Care & Health"
    And save the filter options in refine
    And add 1 number of products on product details page
    And click back button on product details page
    And click cancel button on product search page
    And go to cart screen
    And user clicks on product quantity in cart screen to open quantity stepper
    And user increments product quantity in quantity stepper until checkout button is enabled in cart screen
    And user clicks checkout button in cart screen
    And user closes slot selection sheet in checkout screen
    And user chooses "YES" when confirm changes dialog is displayed in checkout screen
    And user closes contact info sheet in checkout screen
    And user closes payment sheet in checkout screen
    And user selects "SNAP-EBT" as payment method in checkout screen
    And user clicks view cart when SNAP EBT purchase issue popup is displayed in cart screen
    Given get and store items count in non-snap eligible items sheet
    When user swipes partially across a product card in non-snap eligible items sheet
    And user clicks remove button on product card in non-snap eligible items sheet
    Then verify items count in non-snap eligible items sheet is "decreased" by 1
    When user clicks remove all items button in non-snap eligible items sheet
    Then verify non-snap eligible items sheet "is not" displayed
    And user clicks back button in checkout screen to go back to cart screen
    And close cart screen

  #Author: Harish
  #C71357
  @regression @module_cartV2
  Scenario: As a User, I should be able to see prop 65 and age restricted warning should show up for the appropriate products (but will not be clickable and not have an underline)
    Given empty the cart using API service
    When click on home tab
    And user selects a pick-up store in california location that supports SNAP EBT payment mode
    And search product "chicken" on home page
    And add 1 number of products on product details page
    And click back button on product details page
    And click cancel button on product search page
    And search product "Beer" on home page
    And select the refine option for search
    And refine the results by "check" the "Wine, Beer & Spirits"
    And save the filter options in refine
    And add a product on product details page
    And click back button on product details page
    And click cancel button on product search page
    And go to cart screen
    And user clicks on product quantity in cart screen to open quantity stepper
    And user increments product quantity in quantity stepper until checkout button is enabled in cart screen
    And user clicks checkout button in cart screen
    And user closes slot selection sheet in checkout screen
    And user chooses "YES" when confirm changes dialog is displayed in checkout screen
    And user closes contact info sheet in checkout screen
    And user closes payment sheet in checkout screen
    And user selects "SNAP-EBT" as payment method in checkout screen
    And user clicks view cart when SNAP EBT purchase issue popup is displayed in cart screen
    Then verify prop 65 warning label is displayed on a product card in non-snap eligible items sheet
    And verify age restricted warning label is displayed on a product card in cart screen
    When user clicks prop 65 warning label on a product card in cart screen
    Then verify prop 65 warning sheet "is not" displayed
    And user closes non-snap eligible items sheet in checkout screen
    And user clicks back button in checkout screen to go back to cart screen
    And close cart screen

  #Author: Harish
  #C71364
  @regression @module_cartV2 @ios_only
  Scenario: iOS_As a User, I should see that while scrolling - the category header should stay sticky
    Given empty the cart using API service
    When click on home tab
    And user selects a pick-up store in california location that supports SNAP EBT payment mode
    And search product "chicken" on home page
    And add 1 number of products on product details page
    And click back button on product details page
    And click cancel button on product search page
    And search product "Beer" on home page
    And select the refine option for search
    And refine the results by "uncheck" the "Out of Stock"
    And refine the results by "check" the "Wine, Beer & Spirits"
    And refine the results by "uncheck" the "Out of Stock"
    And save the filter options in refine
    And user adds 10 different products from search results
    And click back button on product details page
    And click cancel button on product search page
    And go to cart screen
    And user clicks checkout button in cart screen
    And user closes slot selection sheet in checkout screen
    And user chooses "YES" when confirm changes dialog is displayed in checkout screen
    And user closes contact info sheet in checkout screen
    And user closes payment sheet in checkout screen
    And user selects "SNAP-EBT" as payment method in checkout screen
    And user clicks view cart when SNAP EBT purchase issue popup is displayed in cart screen
    Then verify category header in non-snap eligible items sheet is sticky in iOS platform
    And user closes non-snap eligible items sheet in checkout screen
    And user clicks back button in checkout screen to go back to cart screen
    And close cart screen

  #Author: Harish
  #C71007
  @regression @module_cartV2
  Scenario: As a User, I should be able to see cart count beside 'Cart' text as per figma design
    When go to cart screen
    Then verify product count is displayed in header on cart screen
    And close cart screen

  #Author: Gerardo
  #C71209
  #C71210
  #C71211
  @regression @module_cartV2
  Scenario Outline: Verify Out Of Stock Products shown as "Not available for <shopping_mode>" by Changing the Shopping Method to <shopping_mode>
    Given empty the cart using API service
    When click on home tab
    And select store with no product out of stock forced
    Then verify home screen is displayed
    When search product "Carrot Cake Slice" on home page
    Then verify products listing page displayed
    When add a product on product details page
    And go back to Home Page from product details page
    And select store with product no stock
    Then verify home screen is displayed
    And click on shopping mode down arrow without wait
    And click on right arrow button on zipcode page
    And user selects "<shopping_mode>" shopping method
    And click on start Shopping Button
    Then verify home screen is displayed
    When go to cart screen
    Then verify not available for "<shopping_mode>" on cart screen
    And close cart screen
    Examples:
      | shopping_mode |
      | Pickup        |
      | Delivery      |
      | In-Store      |


  #Author: Harish
  #C71008
  @regression @module_cartV2
  Scenario: As a User, I should be able close the cart screen on tapping 'X' icon and land on screen from where user has navigated to Cart
    Given empty the cart using API service
    When click on home tab
    When search product "Milk" on home page
    Then verify products listing page displayed
    And go to cart screen
    And close cart screen
    Then verify products listing page displayed
    And click cancel button on product search page

  #Author: Harish
  #C71010
  @regression @module_cartV2
  Scenario: As a User, I should be able to navigate to new cart screen on navigating to cart from anywhere in the app
    Given empty the cart using API service
    When click on home tab
    And select the pick-up store
    Then verify home screen is displayed
    And search product "Milk" on home page
    Then verify products listing page displayed
    When go to cart screen
    Then verify header on cart screen is "Cart"
    And close cart screen
    When click product card on products listing page
    And go to cart screen
    Then verify header on cart screen is "Cart"
    And close cart screen
    And click back button on product details page
    And click cancel button on product search page
    When go to cart screen
    Then verify header on cart screen is "Cart"
    And close cart screen
    When click on deals tab
    And go to cart screen
    Then verify header on cart screen is "Cart"
    And close cart screen
    When go to browse tab
    And go to cart screen
    Then verify header on cart screen is "Cart"
    And close cart screen
    When go to MyList tab
    And go to List Tab
    And go to cart screen
    Then verify header on cart screen is "Cart"
    And close cart screen
    When navigate to Member tab
    And go to cart screen
    Then verify header on cart screen is "Cart"
    And close cart screen
    And click on home tab
    And select the delivery store
    Then verify home screen is displayed
    And go to cart screen
    Then verify header on cart screen is "Cart"
    And close cart screen
    And select in-store run using zip code and store name
    Then verify home screen is displayed
    And go to cart screen
    Then verify header on cart screen is "Cart"
    And close cart screen

  #Author: Rohith
  #C71050
  @regression @module_cartV2
  Scenario: Basic product card when an item is added to cart
    Given empty the cart using API service
    When click on home tab
    And select the pick-up store
    Then verify home screen is displayed
    And search product "Milk" on home page
    Then verify products listing page displayed
    When add a product on product details page
    And go to cart screen
    Then verify "Basic" product "is" displayed in cart
    When close cart screen
    And go back to Home Page from product details page

  #Author: Rohith
  #C71051
  @regression @module_cartV2
  Scenario Outline: Product Card with approx price in the cart
    Given empty the cart using API service
    When click on home tab
    And select the pick-up store
    Then verify home screen is displayed
    And search product "chicken" on home page
    Then verify products listing page displayed
    When add a product with "<product_type>" on product details page
    And go to cart screen
    Then verify "<product_type>" product "<product_presence>" displayed in cart
    And close cart screen
    And go back to Home Page from product details page
    Examples:
      | product_type | product_presence |
      | APPROX       | is               |

  #Author: Rohith
  #C71052
  @regression @module_cartV2
  Scenario Outline: Product Card with strikethrough price in the cart
    Given empty the cart using API service
    When click on home tab
    And select the pick-up store
    Then verify home screen is displayed
    When search product "beef" on home page
    Then verify products listing page displayed
    And select the refine option for search
    And refine the results by "check" the "Products with Deals"
    And refine the results by "uncheck" the "Out of Stock"
    And save the filter options in refine
    Then verify products listing page displayed
    And add a product with "<product_type>" on product details page
    And go to cart screen
    Then verify "<product_type>" product "<product_presence>" displayed in cart
    And close cart screen
    And go back to Home Page from product details page
    Examples:
      | product_type  | product_presence |
      | STRIKETHROUGH | is               |

  #Author: Rohith
  #C71053
  @regression @module_cartV2
  Scenario Outline: Product Card with approx and strikethrough price in the cart
    Given empty the cart using API service
    When click on home tab
    And select the pick-up store
    Then verify home screen is displayed
    When search product "beef" on home page
    Then verify products listing page displayed
    And select the refine option for search
    And refine the results by "check" the "Products with Deals"
    And refine the results by "uncheck" the "Out of Stock"
    And save the filter options in refine
    Then verify products listing page displayed
    And add a product with "<product_type>" on product details page
    And go back to Home Page from product details page
    And go to cart screen
    Then verify "<product_type>" product "<product_presence>" displayed in cart
    And close cart screen
    Examples:
      | product_type             | product_presence |
      | APPROX AND STRIKETHROUGH | is               |

  #Author: Rohith
  #C71064
  @regression @module_cartV2
  Scenario: Sorting order of categories in the cart
    When click on home tab
    And empty the cart using API service
    Then verify home screen is displayed
    And add multiple products to the cart with names as 'Milk,cookies,bread' from product details page using search
    And go to cart screen
    And verify the categories in cart are sorted alphabetically in "ascending"
    And close cart screen

  #Author: Harish
  #C71056
  @regression @module_cartV2
  Scenario:As a User, I should be able to see title & description in horizantal product card as per API response
    Given empty the cart using API service
    When click on home tab
    And search product "milk" on home page
    And add a product on product details page
    And click back button on product details page
    And click cancel button on product search page
    And go to cart screen
    Then verify name of the product is displayed as per API response in cart
    And close cart screen

  #Author: Harish
  #C71057
  @regression @module_cartV2
  Scenario:As a User, I should be able to see quantity details in horizantal product card as per API response
    Given empty the cart using API service
    When click on home tab
    And search product "milk" on home page
    And add a product on product details page
    And click back button on product details page
    And click cancel button on product search page
    And go to cart screen
    Then verify quantity of the product is displayed as per API response in cart
    And close cart screen

  #Author: Harish
  #C71058
  @regression @module_cartV2
  Scenario Outline:As a User, I should be able to see basic product card OR card with approx / strikethrough OR combination of approx & Strikethrough based on API response
    Given empty the cart using API service
    When click on home tab
    And select the pick-up store
    When enter text "<product_name>" in search bar on home page and press search icon on keyboard
    And select the refine option for search
    And refine the results by "<refine_choice_products_with_deals>" the "Products with Deals"
    And refine the results by "uncheck" the "Out of Stock"
    And save the filter options in refine
    And add a product with "<product_type>" on product details page
    And click back button on product details page
    And click cancel button on product search page
    And go to cart screen
    Then verify details of the product with "<product_price_type>" price is displayed as per API response in cart
    And close cart screen
    Examples:

      | product_name    | product_type             | product_price_type   | refine_choice_products_with_deals |
      | Eggs            | BASIC                    | BASIC                | uncheck                           |
      | organic banana  | APPROX                   | APPROX               | uncheck                           |
      | Fish            | STRIKETHROUGH            | STRIKETHROUGH        | check                             |
      | Beef            | APPROX AND STRIKETHROUGH | APPROX,STRIKETHROUGH | check                             |

  #Author: Harish
  #C71103
  @regression @module_cartV2
  Scenario: Product cart with age restricted items
    Given empty the cart using API service
    When click on home tab
    And select the pick-up store
    And search product "beer" on home page
    And add a product on product details page
    And click back button on product details page
    And click cancel button on product search page
    And go to cart screen
    Then verify age restricted item in UI and API
    And close cart screen

  #Author: Harish
  #C71168
  @regression @module_cartV2
  Scenario: User should be able to open the Quantity stepper
    Given empty the cart using API service
    When click on home tab
    And search a product on home page
    Then verify products listing page displayed
    When add 1 number of products on product details page
    And click back button on product details page
    And click cancel button on product search page
    And go to cart screen
    And user clicks on product quantity in cart screen to open quantity stepper
    Then verify quantity stepper "is" displayed
    And close cart screen

  #Author: Harish
  #C71169
  @regression @module_cartV2
  Scenario: Quantity stepper when item quantity is 1
    Given empty the cart using API service
    When click on home tab
    And select the pick-up store
    Then verify home screen is displayed
    And search a product on home page
    Then verify products listing page displayed
    When add 1 number of products on product details page
    And click back button on product details page
    And click cancel button on product search page
    And go to cart screen
    And user clicks on product quantity in cart screen to open quantity stepper
    And decrement product quantity 1 times in quantity stepper when quantity is "equal to" 1 and verify cart updates
    Then verify quantity stepper "is not" displayed
    And verify cart is empty
    And close cart screen

  #Author: Harish
  #C71170
  @regression @module_cartV2
  Scenario: Quantity stepper when item quantity more than 1 and less than 20
    Given empty the cart using API service
    When click on home tab
    And search a product on home page
    Then verify products listing page displayed
    When add 1 number of products on product details page
    And click back button on product details page
    And click cancel button on product search page
    And go to cart screen
    And user clicks on product quantity in cart screen to open quantity stepper
    And increment product quantity 1 times in quantity stepper and verify cart updates
    And decrement product quantity 1 times in quantity stepper when quantity is "more than" 1 and verify cart updates
    When user clicks on cart summary label in cart screen
    Then verify quantity stepper "is not" displayed
    When user clicks on product quantity in cart screen to open quantity stepper
    And decrement product quantity 1 times in quantity stepper when quantity is "equal to" 1 and verify cart updates
    Then verify quantity stepper "is not" displayed
    And verify cart is empty
    And close cart screen

  #Author: Harish
  #C71171
  @regression @module_cartV2
  Scenario: Quantity stepper when item quantity is 20
    Given empty the cart using API service
    When click on home tab
    And search a product on home page
    Then verify products listing page displayed
    When add 1 number of products on product details page
    And click back button on product details page
    And click cancel button on product search page
    And go to cart screen
    And user clicks on product quantity in cart screen to open quantity stepper
    And user increments the product quantity in quantity stepper on cart screen to maximum allowed value
    Then verify increment button is disabled when product quantity has reached maximum allowed value
    And decrement product quantity 1 times in quantity stepper when quantity is "more than" 1 and verify cart updates
    When user clicks on cart summary label in cart screen
    Then verify quantity stepper "is not" displayed
    And close cart screen

  #Author: Harish
  #C71172
  @regression @module_cartV2
  Scenario: Continuous increment/decrement Quantity
    Given empty the cart using API service
    When click on home tab
    And search a product on home page
    Then verify products listing page displayed
    When add 1 number of products on product details page
    And click back button on product details page
    And click cancel button on product search page
    And go to cart screen
    And user clicks on product quantity in cart screen to open quantity stepper
    And get and store total product count in cart screen
    When user increments product quantity 5 times in quantity stepper
    Then verify total product count in cart screen is "increased" by 5
    When get and store total product count in cart screen
    And user decrements product quantity 6 times in quantity stepper
    Then verify total product count in cart screen is "decreased" by 6
    And verify cart is empty
    And close cart screen

  #Author: Harish
  #C71173
  @regression @module_cartV2
  Scenario: Checks to make upon successfully update
    And empty the cart using API service
    When click on home tab
    And search a product on home page
    Then verify products listing page displayed
    When add 1 number of products on product details page
    And click back button on product details page
    And click cancel button on product search page
    And go to cart screen
    And user clicks on product quantity in cart screen to open quantity stepper
    Then increment product quantity 1 times in quantity stepper and verify cart updates
    And decrement product quantity 1 times in quantity stepper when quantity is "more than" 1 and verify cart updates
    And close cart screen

  #Author: Harish
  #C71175
  @regression @module_cartV2
  Scenario: Animation of stepper view, when stepper is expanded & user scrolls
    And empty the cart using API service
    When click on home tab
    And search a product on home page
    Then verify products listing page displayed
    When add 1 number of products on product details page
    And click back button on product details page
    And click cancel button on product search page
    And go to cart screen
    And user clicks on product quantity in cart screen to open quantity stepper
    Then verify quantity stepper "is" displayed
    When scroll down the screen
    Then verify quantity stepper "is not" displayed
    And close cart screen

  #Author: Harish
  #C71178
  @regression @module_cartV2
  Scenario: Animation of stepper view when stepper is expanded & user taps anywhere outside of the product cards
    And empty the cart using API service
    When click on home tab
    And search product "Milk" on home page
    And add a product on product details page
    And go back to Home Page from product details page
    And go to cart screen
    And user clicks on product quantity in cart screen to open quantity stepper
    Then verify quantity stepper "is" displayed
    When user clicks on cart summary label in cart screen
    Then verify quantity stepper "is not" displayed
    And close cart screen

  #Author: Harish
  #C71177
  @regression @module_cartV2
  Scenario: Animation of stepper view when stepper is expanded & user taps anywhere on another product item
    And empty the cart using API service
    When click on home tab
    And search product "Milk" on home page
    And add a product on product details page
    And click back button on product details page
    And click cancel button on product search page
    And search product "chicken" on home page
    And add a product on product details page
    And click back button on product details page
    And click cancel button on product search page
    And go to cart screen
    And user clicks on product quantity of product number 1 in cart screen
    Then verify quantity stepper "is" displayed
    When user clicks on product name of product number 2 in cart screen
    Then verify quantity stepper "is not" displayed
    And verify product details page is displayed
    And click back button on product details page
    And close cart screen

  #Author: Gerardo
  #C71033
  @regression @module_cartV2
  Scenario:Verify that user see empty cart screen When all the items in the cart are removed.
    Given empty the cart using API service
    When click on home tab
    And search product "Milk" on home page
    And add a product on product details page
    And go back to Home Page from product details page
    And go to cart screen
    And clear cartV2 items
    Then verify cart screen is in empty state having zero items in it
    When close cart screen

   #Author: Gerardo
  #C71111
  #This scenario is only for Android
  @regression @module_cartV2
  Scenario: [Android] Verify User can navigate from Cart to checkout screen and back
    Given empty the cart using API service
    When click on home tab
    And search product "Milk" on home page
    And add 10 number of products on product details page
    And click back button on product details page
    And click cancel button on product search page
    And go to cart screen
    Then verify title is displayed in cart page
    Then verify Checkout button is enabled in cart page
    When click on Checkout Button CTA in cart page
    And click on the back button for the device
    Then verify title is displayed in cart page
    And close cart screen

  #Author: Gerardo
  #C70995 #C71062
  @regression @module_cartV2
  Scenario:Verify that user sees empty cart when no item is added in the cart
    Given empty the cart using API service
    And click on home tab
    When go to cart screen
    Then verify cart screen is in empty state having zero items in it
    And close cart screen

  #Author: Gerardo
  #C70999
  @regression @module_cartV2
  Scenario:Verify when user clicks on Shop now CTA it navigates to homepage
    Given empty the cart using API service
    And click on home tab
    When go to cart screen
    And click on Shop Now CTA in cart screen
    Then verify user navigates to home page

  #Author: Gerardo
  #C71000
  #This scenario is only for Android
  @regression @module_cartV2
  Scenario: Verify when user clicks back button on homepage it should not navigate back to the cart(android only)
    Given empty the cart using API service
    And click on home tab
    And go to cart screen
    And click on Shop Now CTA in cart screen
    Then verify user navigates to home page
    When click on the back button for the device
    Then verify user is not navigated back to cart page

  #Author: Gerardo
  #C71109
  @regression @module_cartV2
  Scenario: Verify user sees empty cart when API returns 0 items
    Given empty the cart using API service
    When click on home tab
    Then verify cart icon shows 0 items
    And go to cart screen
    Then verify cart screen is in empty state having zero items in it
    And close cart screen

  #Author: Gerardo
  #C71060
  @regression @module_cartV2
  Scenario: As a user, I should see the subtotal of the cart and the amount as well at the bottom of cart screen
    Given empty the cart using API service
    When click on home tab
    And select store with no product out of stock
    Then verify home screen is displayed
    And search product "Milk" on home page
    And add a product on product details page
    And go back to Home Page from product details page
    And go to cart screen
    Then verify estimated subtotal and amount are shown on the cart screen
    And close cart screen

  #Author: Gerardo
  #C71110
  @regression @module_cartV2
  Scenario: As a user, I must see the cart summary breakdown with details when API returns successful response
    Given empty the cart using API service
    When click on home tab
    And search product "Milk" on home page
    Then verify products listing page displayed
    When user taps on the Refine button
    Then verify Sort & Filter page is opened
    When refine the results by "check" the "Products with Deals"
    And refine the results by "uncheck" the "Out of Stock"
    And user clicks on Best Match
    Then verify Sort By page is opened
    When user selects Club Card Specials from Sort By page
    And user clicks on back button
    And user taps on SAVE in Sort & Filter page
    When user adds the item to cart using the Add Icon on product details page
    And go to cart screen
    Then verify the cart summary is displayed on the cart screen
    And close cart screen
    Then verify products listing page displayed
    And click cancel button on product search page

  #Author: Gerardo
  #C71113
  @regression @module_cartV2
  Scenario: As a user, I should not see the estimated savings under cart summary when the value of the savings is not returned from API or is 0
    Given empty the cart using API service
    And click on home tab
    And search a product on home page
    Then verify products listing page displayed
    When user adds the item to cart using the Add Icon on product details page
    And go to cart screen
    Then verify Estimated savings is not displayed on the cart screen
    And close cart screen
    Then verify products listing page displayed
    And click cancel button on product search page

  #Author: Gerardo
  #C71115
  @regression @module_cartV2
  Scenario: As a user, I should not see the unavailable items(products) count in cart summary
    Given empty the cart using API service
    And click on home tab
    And search a product on home page
    Then verify products listing page displayed
    When user adds the item to cart using the Add Icon on product details page
    And go to cart screen
    Then verify item count is displayed 1 in the cart screen
    And close cart screen
    Then verify products listing page displayed
    And click cancel button on product search page
    And click on home tab
    And select store with product no stock
    And go to cart screen
    Then verify item count is displayed 0 in the cart screen
    Then verify not available for "Pickup" on cart screen
    And close cart screen
    And click on home tab
    And select store with no product out of stock

  #Author: Mohanad
  #C71119
  @regression @module_cartV2
  Scenario: Verify Cart Threshold Message and Checkout Button when Cart SubTotal < Threshold Value CartAPI Success
    Given empty the cart using API service
    And click on home tab
    And select store with no product out of stock
    Then verify home screen is displayed
    And search a product on home page
    Then verify products listing page displayed
    When user adds the item to cart using the Add Icon on product details page
    And click cancel button on product search page
    And click on home tab
    And go to cart screen
    Then verify the threshold message is shown
    Then verify if the estimated subtotal in the UI equals the estimated subtotal in the API response
    And verify from the threshold message in the UI and API response the minimum remaining amount value to order is less than the threshold value
    And close cart screen

  #Author: Mohanad
  #C71118
  @regression @module_cartV2
  Scenario: Verify Cart Threshold Message and Checkout Button when Cart SubTotal > Threshold Value with CartAPI Success
    Given empty the cart using API service
    And click on home tab
    And select store with no product out of stock
    Then verify home screen is displayed
    And search a product on home page
    Then verify products listing page displayed
    And add 10 number of products on product details page
    And go back to Home Page from product details page
    And go to cart screen
    And verify that the threshold message is not shown
    Then verify if the estimated subtotal in the UI equals the estimated subtotal in the API response
    And close cart screen

  #Author: Gerardo
  #C71114
  @regression @module_cartV2
  Scenario: As a user, I should see the savings sheet with static text upon clicking on info icon for estimated savings
    Given empty the cart using API service
    When click on home tab
    And search product "Milk" on home page
    Then verify products listing page displayed
    When user taps on the Refine button
    Then verify Sort & Filter page is opened
    When refine the results by "check" the "Products with Deals"
    And refine the results by "uncheck" the "Out of Stock"
    And user clicks on Best Match
    Then verify Sort By page is opened
    When user selects Club Card Specials from Sort By page
    And user clicks on back button
    And user taps on SAVE in Sort & Filter page
    When user adds the item to cart using the Add Icon on product details page
    And go to cart screen
    And click on info icon at the bottom for Estimated savings under cart summary
    Then verify Estimated savings sheet opens up with static text as per banner theme
    And click on X on the estimated savings sheet
    Then verify Estimated savings sheet closes and user navigates back to the cart screen and maintains the scroll state
    And close cart screen
    Then verify products listing page displayed
    And click cancel button on product search page
    And click cancel button on product search page

  #Author: Rohith
  #C71158
  @regression @module_cartV2
  Scenario: As a User, I should be able to remove product card by swiping and tapping on bin icon
    When click on home tab
    And empty the cart using API service
    When search product "beef" on home page
    Then verify products listing page displayed
    And add a product on product details page
    And go to cart screen
    And observe the number of products present in the cart
    And clear cartV2 items
    Then product must be "removed from" the cart
    And close cart screen
    And go back to Home Page from product details page

  #Author: Rohith
  #C71159
  @regression @module_cartV2
  Scenario: [iOS] As a User, I should be able to see 'remove' text moves from right to left and the product card is removed on swiping the product card to right
    When click on home tab
    And empty the cart using API service
    When search product "beef" on home page
    Then verify products listing page displayed
    And add a product on product details page
    And go to cart screen
    And observe the number of products present in the cart
    And swipe across a product card to delete it in cart
    Then verify cart is empty
    Then product must be "removed from" the cart
    And close cart screen
    And go back to Home Page from product details page

  #Author: Rohith
  #C71160
  @regression @module_cartV2
  Scenario: As a User, I should be able to see 'Remove' CTA UI as per design on swiping partially
    Given empty the cart using API service
    When click on home tab
    When search product "beef" on home page
    Then verify products listing page displayed
    And add a product on product details page
    And go to cart screen
    And swipe partially across a product card in cart
    Then verify option to remove product "is" displayed
    And close cart screen
    And go back to Home Page from product details page

  #Author: Rohith
  #C71167
  @regression @module_cartV2
  Scenario: [iOS] As a User, I should be able to remove product by swiping and tapping on remove button
    Given empty the cart using API service
    When click on home tab
    And search product "beef" on home page
    Then verify products listing page displayed
    And add a product on product details page
    And go to cart screen
    And observe the number of products present in the cart
    And swipe partially across a product card in cart
    And click on the Remove button
    Then verify cart is empty
    Then product must be "removed from" the cart
    And close cart screen
    And go back to Home Page from product details page

  #Author: Rohith
  #C71154
  @regression @module_cartV2
  Scenario: As a User, I should be able to see item count is updated in cart header on removing a product
    Given empty the cart using API service
    When click on home tab
    When search product "beef" on home page
    Then verify products listing page displayed
    And add a product on product details page
    And go to cart screen
    And observe the number of products present in the cart
    And swipe partially across a product card in cart
    And click on the Remove button
    Then verify cart is empty
    Then product must be "removed from" the cart
    And close cart screen
    And go back to Home Page from product details page

  #Author: Rohith
  #C71155
  @regression @module_cartV2
  Scenario: As a User, I should be able to see 'Est subtotal', 'cart summary' total and 'delivery minimum' ( if applicable) are updated on removing a product
    When click on home tab
    And select the pick-up store
    Then empty the cart using API service
    When search product "beef" on home page
    Then verify products listing page displayed
    And add a product with "APPROX" on product details page
    And go back to Home Page from product details page
    When search product "beef" on home page
    Then verify products listing page displayed
    And select the refine option for search
    And refine the results by "check" the "Products with Deals"
    And refine the results by "uncheck" the "Out of Stock"
    And save the filter options in refine
    Then verify products listing page displayed
    And add a product with "STRIKETHROUGH" on product details page
    And go back to Home Page from product details page
    And go to cart screen
    And swipe partially across a product card in cart
    And click on the Remove button
    Then verify cart details are displayed as per the API response for cart with 'Discounted' products

  #Author: Rohith
  #C71270
  @regression @module_cartV2
  Scenario: As a User, I should be able to navigate to product details page when the user clicks any product card in the cart.
    And empty the cart using API service
    When click on home tab
    And search a product on home page
    Then verify products listing page displayed
    And add 1 number of products on product details page
    And go back to Home Page from product details page
    And go to cart screen
    And click on a product in cart screen
    Then verify product details page is displayed
    And click On Back Button of Shopping Mode Page
    And close cart screen

  #Author: Rohith
  #C71271
  @regression @module_cartV2
  Scenario: As a User, I should see that Product detail page reflects the quantity of products added by the user to the cart
    And empty the cart using API service
    When click on home tab
    And search a product on home page
    Then verify products listing page displayed
    And add 1 number of products on product details page
    And go back to Home Page from product details page
    And go to cart screen
    And user clicks on product quantity in cart screen to open quantity stepper
    And user clicks on increment quantity button in quantity stepper
    And user exits the quantity stepper
    And view the product quantity on cart page
    And click on a product in cart screen
    Then verify product details page is displayed
    And view the product quantity on details page
    Then verify product quantity in cart is displayed same as in product details page
    And click On Back Button of Shopping Mode Page
    And close cart screen

  #Author: Rohith
  #C71272
  @regression @module_cartV2
  Scenario: As a User, I should see that any changes made in the Product detail page should reflect in the cart
    When click on home tab
    And select the delivery store
    Then verify home screen is displayed
    And empty the cart using API service
    And search a product on home page
    Then verify products listing page displayed
    And add 2 number of products on product details page
    And view the product quantity on details page
    And go back to Home Page from product details page
    And go to cart screen
    And view the product quantity on cart page
    Then verify product quantity in cart is displayed same as in product details page
    And click on a product in cart screen
    Then verify product details page is displayed
    And remove 2 number of products from product details page
    And click On Back Button of Shopping Mode Page
    Then verify cart is empty
    And close cart screen
    And search product "Milk" on home page
    Then verify products listing page displayed
    And add 1 number of products on product details page
    And view the product quantity on details page
    And go back to Home Page from product details page
    And go to cart screen
    And view the product quantity on cart page
    Then verify product quantity in cart is displayed same as in product details page
    And close cart screen

  #Author: Rohith
  #C71273
  # Getting svc error as this is a issue in Prod
  @regression @module_cartV2
  Scenario: As a User, I should be able to navigate to product details page when the user clicks any unavailable product card in the cart.
    When click on home tab
    And select the pick-up for Cart API
    Then verify home screen is displayed
    And empty the cart using API service
    When search product "beef" on home page
    Then verify products listing page displayed
    And add 1 number of products on product details page
    And go back to Home Page from product details page
    Then verify home screen is displayed
    And select store with product no stock
    Then verify home screen is displayed
    And go to cart screen
    Then verify cart shows unavailable item
    And click on a product in cart screen for unavailable products
    Then verify product details page is displayed
    And click On Back Button of Shopping Mode Page
    And close cart screen

  #Author: Rohith
  #C71274
  @regression @module_cartV2
  Scenario: As a User, I should see that Clicking on view similar CTA should navigate me to related products screen
    Given empty the cart using API service
    When click on home tab
    And select the pick-up for Cart API
    Then verify home screen is displayed
    And search a product on home page
    Then verify products listing page displayed
    And add 1 number of products on product details page
    And go back to Home Page from product details page
    Then verify home screen is displayed
    And select store with product no stock
    Then verify home screen is displayed
    And go to cart screen
    Then verify cart shows unavailable item
    And click on view similar items CTA on cart screen
    And verify Related Products screen 'is' displayed
    And click back button in related products page
    And close cart screen

  #Author: Rohith
  #C71212
  @regression @module_cartV2
  Scenario: [Android]As a User, I should be able to remove unavailable product card by swiping and tapping on bin icon
    When empty the cart using API service
    When click on home tab
    And select store with no product out of stock
    Then verify home screen is displayed
    When search product "Milk" on home page
    Then verify products listing page displayed
    And add 1 number of products on product details page
    And go back to Home Page from product details page
    Then verify home screen is displayed
    And select store with product no stock
    Then verify home screen is displayed
    And go to cart screen
    And verify cart shows unavailable item
    And swipe partially across a product card in cart for unavailable item
    And click on the Remove button
    Then verify cart is empty
    And close cart screen

  #Author: Rohith
  #C71215
  @regression @module_cartV2
  Scenario: [iOS] As a User, I should be able to remove unavailable product by swiping and tapping on remove button
    When empty the cart using API service
    When click on home tab
    And select store with no product out of stock
    Then verify home screen is displayed
    When search product "chicken" on home page
    Then verify products listing page displayed
    And add 1 number of products on product details page
    And go back to Home Page from product details page
    Then verify home screen is displayed
    And select store with product no stock
    Then verify home screen is displayed
    And go to cart screen
    And verify cart shows unavailable item
    And swipe partially across a product card in cart for unavailable item
    And click on the Remove button
    Then verify cart is empty
    And close cart screen

  #Author: Gerardo
  #C71202
  #C71208
  @regression @module_cartV2
  Scenario: Verify User is shown with Out Of Stock Message when Products are not available
    Given empty the cart using API service
    When click on home tab
    And select store with no product out of stock forced
    Then verify home screen is displayed
    When search product "birthday cake ice cream" on home page
    Then verify products listing page displayed
    And add a product on product details page
    And go back to Home Page from product details page
    And select store with product out of stock forced
    Then verify home screen is displayed
    When go to cart screen
    Then verify out of stock on cart screen
    And close cart screen

  #Author: Rohith
  #C71213
  @regression @module_cartV2
  Scenario: [iOS] As a User, I should be able to see 'remove' text moves from right to left and the unavailable product card is removed on swiping the product card to right
    When empty the cart using API service
    When click on home tab
    And select store with no product out of stock forced
    Then verify home screen is displayed
    When search product "birthday cake ice cream" on home page
    Then verify products listing page displayed
    When add a product on product details page
    And go back to Home Page from product details page
    Then verify home screen is displayed
    And select store with product out of stock forced
    Then verify home screen is displayed
    And go to cart screen
    And verify cart shows unavailable item
    And swipe partially across a product card in cart for unavailable item
    And verify remove button 'is' displayed in cart page
    And close cart screen

  #Author: Mohanad
  #C71132
  @regression @module_cartV2
  Scenario: As a user, I should be able to navigate to similar product page when clicked on the similar products on cart screen
    Given empty the cart using API service
    When click on home tab
    And select store with no product out of stock forced
    Then verify home screen is displayed
    When search product "birthday cake ice cream" on home page
    Then verify products listing page displayed
    When add a product on product details page
    And go back to Home Page from product details page
    Then verify home screen is displayed
    And select store with product out of stock forced
    Then verify home screen is displayed
    And go to cart screen
    Then verify view similar CTA in cart page
    And click view similar CTA in cart page
    Then verify similar products page
    And click back button in related products page
    And close cart screen

  #Author: Mohanad
  #C71133
  @regression @module_cartV2
  Scenario: As a user, I should navigate back to cart screen, upon clicking back button on similar product screen
    Given empty the cart using API service
    When click on home tab
    And select store with no product out of stock forced
    Then verify home screen is displayed
    When search product "birthday cake ice cream" on home page
    Then verify products listing page displayed
    When add a product on product details page
    And go back to Home Page from product details page
    And select store with product out of stock forced
    Then verify home screen is displayed
    And go to cart screen
    Then verify view similar CTA in cart page
    And click view similar CTA in cart page
    Then verify similar products page
    And click back button in related products page
    And close cart screen

  #Author: Mohanad
  #C71134
  @regression @module_cartV2
  Scenario: As a user, clicking on Add CTA for any product/Deals on similar product will add the product/deals to cart
    Given empty the cart using API service
    When click on home tab
    And select store with no product out of stock forced
    Then verify home screen is displayed
    When search product "birthday cake ice cream" on home page
    Then verify products listing page displayed
    When add a product on product details page
    And go back to Home Page from product details page
    Then verify home screen is displayed
    And select store with product out of stock forced
    Then verify home screen is displayed
    And go to cart screen
    Then verify view similar CTA in cart page
    And click view similar CTA in cart page
    Then verify similar products page
    And user adds the item to cart using the Add Icon on product details page
    Then verify add button in similar products page adds item to cart page
    And close cart screen

  #Author: Mohanad
  #C71163
  @regression @module_cartV2
  Scenario: View Similar Product is shown only for Out of Stock or Pick Only Product
    Given empty the cart using API service
    When click on home tab
    And select store with no product out of stock forced
    Then verify home screen is displayed
    When search product "birthday cake ice cream" on home page
    Then verify products listing page displayed
    When add a product on product details page
    And go back to Home Page from product details page
    And search product "Bakery Cake" on home page
    Then verify products listing page displayed
    When add a product on product details page
    And go back to Home Page from product details page
    Then verify home screen is displayed
    And select store with product out of stock forced
    Then verify home screen is displayed
    And go to cart screen
    Then verify view similar CTA in cart page
    Then verify view similar CTA is not located in the In-Stock Card in cart page
    And close cart screen

  #Author: Mohanad
  #C71124
  #C71125
  #C71126
  #C71127
  #C71136
  @regression @module_cartV2
  # This test case fails on iOS due bug: https://jira.safeway.com/browse/PGG-10427
  Scenario: As a user, verify the layout of the edit cart screen once user tries to edit the cart
  As a user, I should be able to edit the cart oder as per current logic and navigated to new edit window once clicked on it
  As a user, User can go back to edit Order from edit screen buy tapping on back caret
  As a user, I should see “Shop Past Purchases” CTA on top if user has past purchase history
  As a user, I should be able to search the items on edit screen and update the cart with new item
    Given empty the cart using API service
    When click on home tab
    And scroll up to profile icon on home page
    And select store with no product out of stock forced
    Then verify home screen is displayed
    And search product "Milk" on home page
    And add 10 number of products on product details page
    And click back button on product details page
    And click cancel button on product search page
    And go to cart screen
    Then verify title is displayed in cart page
    And click on Checkout Button CTA in cart page
    And user selects next day in pickup options screen
    And user clicks on Continue to payment CTA at the slot selection screen
    And user completes credit card form in checkout process
    And click continue to review order
    And click on place order button
    And click on edit order button in orders page
    Then verify Edit Order Page is shown
    And click on edit cart and preferences
    Then verify Past Purchases Button is displayed
    Then verify cart is increased after adding an item in edit cart screen
    And click on back button in edit cart screen
    Then verify Edit Order Page is shown
    And click on edit cart and preferences
    Then verify Past Purchases Button is displayed
    Then verify cart is increased after adding a searched item in edit cart screen
    And click on back button in edit cart screen
    Then verify Edit Order Page is shown
    And click on confirm changes in edit order screen
    Then verify order has been saved in edit cart screen
    When click on continue shopping in edit cart screen
    And click yes if you love Safeway app
    Then verify home screen is displayed


  #Author: Harish
  #C71227
  @regression @module_cartV2
  Scenario: Product cart with prop 65 items
    Given empty the cart using API service
    When click yes if you love Safeway app
    And click on home tab
    And user selects a store in california location
    Then verify home screen is displayed
    When search product "Beer" on home page
    And add a product on product details page
    And click back button on product details page
    And click cancel button on product search page
    And go to cart screen
    Then verify prop 65 warning in UI and API
    When close cart screen

  #Author: Harish
  #C71261
  @regression @module_cartV2
  Scenario: Prop 65 message sheet
    Given empty the cart using API service
    When click on home tab
    And user selects a store in california location
    Then verify home screen is displayed
    And search product "Beer" on home page
    And add a product on product details page
    And click back button on product details page
    And click cancel button on product search page
    And go to cart screen
    And user clicks prop 65 warning label on a product card in cart screen
    Then verify prop 65 message sheet in UI and API in cart screen
    And user clicks close button in prop 65 message sheet in cart screen
    And close cart screen

  #Author: Rohith
  #C71252
  @regression @module_cartV2
  Scenario: Product Card Add note - Delivery/Pickup mode
    Given empty the cart using API service
    When click on home tab
    And select the pick-up for Cart API
    Then verify home screen is displayed
    When search product "Beef" on home page
    Then verify products listing page displayed
    And add 1 number of products on product details page
    And go back to Home Page from product details page
    And search a product on home page
    Then verify products listing page displayed
    And add 1 number of products on product details page
    And go back to Home Page from product details page
    Then verify home screen is displayed
    And go to cart screen
    Then verify Add Note button 'is displayed' for all products in cart
    And close cart screen

  #Author: Rohith
  #C71253
  @regression @module_cartV2
  Scenario: Product Card Add note CTA
    Given empty the cart using API service
    When click on home tab
    And select the pick-up for Cart API
    Then verify home screen is displayed
    When search product "Milk" on home page
    Then verify products listing page displayed
    And add 1 number of products on product details page
    And go back to Home Page from product details page
    Then verify home screen is displayed
    And go to cart screen
    And click on Add Note button in cart
    Then verify Add Note title is displayed in cart
    Then verify Add Note close btn is displayed in cart
    Then verify Add Note save btn is displayed in cart
    Then verify Add Note placeholder text in cart
    And close the Add Note screen on cart page
    And close cart screen

  #Author: Rohith
  #C71254
  @regression @module_cartV2
  Scenario: Validation Text box inside Add note CTA
    Given empty the cart using API service
    When click on home tab
    And select the pick-up for Cart API
    Then verify home screen is displayed
    And search a product on home page
    Then verify products listing page displayed
    And add 1 number of products on product details page
    And go back to Home Page from product details page
    Then verify home screen is displayed
    And go to cart screen
    And click on Add Note button in cart
    And enter "Product Delivery Note" in add note textbox
    And close the Add Note screen on cart page
    And click on Add Note button in cart
    Then verify Add Note placeholder text in cart
    And close the Add Note screen on cart page
    And close cart screen

  #Author: Rohith
  #C71255
  @regression @module_cartV2
  Scenario: Character limit of Text box inside Add note CTA
    Given empty the cart using API service
    When click on home tab
    And select the pick-up for Cart API
    Then verify home screen is displayed
    And search a product on home page
    Then verify products listing page displayed
    And add 1 number of products on product details page
    And go back to Home Page from product details page
    Then verify home screen is displayed
    And go to cart screen
    And click on Add Note button in cart
    And enter Exceeded Character Sequence in add note textbox
    And save the Add Note changes in cart screen
    And click on Add Note button in cart
    Then verify the character limit for Add Note text box
    And close the Add Note screen on cart page

  #Author: Rohith
  #C71256
  @regression @module_cartV2
  Scenario: Save Button of Add note CTA
    Given empty the cart using API service
    When click on home tab
    And select the pick-up for Cart API
    Then verify home screen is displayed
    And search a product on home page
    Then verify products listing page displayed
    And add 1 number of products on product details page
    And go back to Home Page from product details page
    And go to cart screen
    And click on Add Note button in cart
    And enter "Product Delivery Note" in add note textbox
    And save the Add Note changes in cart screen
    And click on Add Note button in cart
    Then verify "Product Delivery Note" is saved in add note textbox
    And close the Add Note screen on cart page
    And close cart screen

  #Author: Rohith
  #C71257
  @regression @module_cartV2
  Scenario: Close Button of Add note CTA
    Given empty the cart using API service
    When click on home tab
    And select the pick-up for Cart API
    Then verify home screen is displayed
    And search a product on home page
    Then verify products listing page displayed
    And add 1 number of products on product details page
    And go back to Home Page from product details page
    Then verify home screen is displayed
    And go to cart screen
    And click on Add Note button in cart
    And enter "Product Delivery Note" in add note textbox
    And close the Add Note screen on cart page
    And click on Add Note button in cart
    Then verify Add Note placeholder text in cart
    And close the Add Note screen on cart page
    And close cart screen

  #Author: Rohith
  #C71259
  @regression @module_cartV2
  Scenario: Negative scenario - In-store mode
    Given empty the cart using API service
    When click on home tab
    And select the in-store run store for Cart Api
    Then verify home screen is displayed
    And go to cart screen
    Then verify Add Note button 'is not displayed' for all products in cart
    And close cart screen

  #Author: Rohith
  #C71265
  @regression @module_cartV2
  Scenario: As a User, I should be able to refresh the cart on pull down and change in item availability or price should be updated on pull to refresh
    Given empty the cart using API service
    When click on home tab
    And select the pick-up for Cart API
    Then verify home screen is displayed
    When click on home tab
    When search product "Beef" on home page
    Then verify products listing page displayed
    And add 1 number of products on product details page
    And go back to Home Page from product details page
    And search a product on home page
    Then verify products listing page displayed
    And add 1 number of products on product details page
    And go back to Home Page from product details page
    Then verify home screen is displayed
    And go to cart screen
    And remove some items from the cart using API service
    And scroll up the screen
    Then verify cart details are displayed as per the API response for cart with 'Discounted' products
    And close cart screen

  #Author: Gerardo
  #C71307
  @regression @module_cartV2
  Scenario: WYSIWYG - OFF / NA: Verify Product cards and Cart Summary and Sticky Footer by adding products which show (J4U, Employee, rewards, Clubcard) savings
    Given empty the cart using API service
    When click on home tab
    And select store with club card saving forced
    And search product "Water" on home page
    Then verify products listing page displayed
    When user taps on the Refine button
    Then verify Sort & Filter page is opened
    When refine the results by "check" the "Products with Deals"
    And refine the results by "uncheck" the "Out of Stock"
    And user clicks on Best Match
    Then verify Sort By page is opened
    When user selects Club Card Specials from Sort By page
    And user clicks on back button
    And user taps on SAVE in Sort & Filter page
    When user adds the item to cart using the Add Icon on product details page
    And click cancel button on product search page
    And go to cart screen
    Then verify in Cart if the qualifying threshold value in the UI equals the qualifying threshold value in the API response while Wysi is Off
    Then verify in Cart estimated club card savings in UI equals estimated club card savings in API while WYSIWYG is OFF
    Then verify in Cart estimated total while Wysiwyg is Off
    And close cart screen

  #Author: Gerardo
  #C71309
  @regression @module_cartV2
  Scenario: WYSIWYG - OFF / NA: Verify "Edit Cart" Product cards and Cart Summary and Sticky Footer by adding products which show (J4U, Employee, rewards, Clubcard) savings
    Given empty the cart using API service
    When click on home tab
    And select store with club card saving
    And search product "Nutella" on home page
    Then verify products listing page displayed
    When user taps on the Refine button
    Then verify Sort & Filter page is opened
    When refine the results by "check" the "Products with Deals"
    And refine the results by "uncheck" the "Out of Stock"
    And user clicks on Best Match
    Then verify Sort By page is opened
    When user selects Club Card Specials from Sort By page
    And user clicks on back button
    And user taps on SAVE in Sort & Filter page
    And add 10 number of products on product details page
    And go back to Home Page from product details page
    And go to cart screen
    Then verify title is displayed in cart page
    And click on Checkout Button CTA in cart page
    And user selects next day in pickup options screen
    And user clicks on Continue to payment CTA at the slot selection screen
    And user completes credit card form in checkout process
    And click continue to review order
    And click on place order button
    And click on view order button in orders page
    And click on first view details button in orders page
    And click on edit order button in orders details page
    Then verify Edit Order Page is shown
    And click on edit cart and preferences
    Then verify Past Purchases Button is displayed
    Then verify in Edit Cart estimated club card savings in UI equals estimated club card savings in API while WYSIWYG is OFF
    Then verify in Edit Cart estimated total while Wysiwyg is Off
    When click on back button in edit cart screen
    Then verify Edit Order Page is shown
    When click on cancel button in edit order screen
    And click on discard changes in edit order screen
    And click go back button in orders details page
    And click go back button in orders page
    And click on continue shopping in edit cart screen

  #Author: Gerardo
  #C71328
  @regression @module_cartV2
  Scenario: WYSIGYG - Verify the Banner - Branding Specific Verbiage on all banners for Savings Text
    Given empty the cart using API service
    When click on home tab
    And select store with club card saving
    And search product "Water" on home page
    Then verify products listing page displayed
    When user taps on the Refine button
    Then verify Sort & Filter page is opened
    When refine the results by "check" the "Products with Deals"
    And refine the results by "uncheck" the "Out of Stock"
    And user clicks on Best Match
    Then verify Sort By page is opened
    When user selects Club Card Specials from Sort By page
    And user clicks on back button
    And user taps on SAVE in Sort & Filter page
    When user adds the item to cart using the Add Icon on product details page
    And click cancel button on product search page
    And go to cart screen
    Then verify estimated club card savings
    And close cart screen

  #Author: Gerardo
  #C71306
  @regression @module_cartV2
  Scenario: WYSIWYG - ON : Verify Product cards and Cart Summary & Sticky Footer by adding products which show (J4U, Employee, rewards, Clubcard) savings
    Given empty the cart using API service
    When click on home tab
    And select store with no product out of stock forced
    And search product "Nutella" on home page
    Then verify products listing page displayed
    When user taps on the Refine button
    Then verify Sort & Filter page is opened
    When refine the results by "check" the "Products with Deals"
    And refine the results by "uncheck" the "Out of Stock"
    And user clicks on Best Match
    Then verify Sort By page is opened
    When user selects Club Card Specials from Sort By page
    And user clicks on back button
    And user taps on SAVE in Sort & Filter page
    When user adds the item to cart using the Add Icon on product details page
    And click cancel button on product search page
    And go to cart screen
    Then verify in Cart sales savings in UI equals sales savings in API while WYSIWYG is ON
    Then verify in Cart employees savings in UI equals employees savings in API while WYSIWYG is ON
    Then verify in Cart estimated subtotal while Wysiwyg is ON
    And close cart screen

  #Author: Gerardo
  #C71308
  @regression @module_cartV2
  Scenario: WYSIWYG - ON : Verify "Edit Cart" Product cards and Cart Summary and Sticky Footer by adding prodcuts which show (J4U, Employee, rewards, Clubcard) savings
    Given empty the cart using API service
    When click on home tab
    And select store with no product out of stock
    And search product "Nutella" on home page
    Then verify products listing page displayed
    When user taps on the Refine button
    Then verify Sort & Filter page is opened
    When refine the results by "check" the "Products with Deals"
    And refine the results by "uncheck" the "Out of Stock"
    And user clicks on Best Match
    Then verify Sort By page is opened
    When user selects Club Card Specials from Sort By page
    And user clicks on back button
    And user taps on SAVE in Sort & Filter page
    And add 10 number of products on product details page
    And go back to Home Page from product details page
    And go to cart screen
    Then verify title is displayed in cart page
    And click on Checkout Button CTA in cart page
    And user selects next day in pickup options screen
    And user clicks on Continue to payment CTA at the slot selection screen
    And user completes credit card form in checkout process
    And click continue to review order
    And click on place order button
    And click on edit order button in orders page
    Then verify Edit Order Page is shown
    And click on edit cart and preferences
    Then verify in Edit Cart sales savings in UI equals sales savings in API while WYSIWYG is ON
    Then verify in Edit Cart employees savings in UI equals employees savings in API while WYSIWYG is ON
    Then verify in Edit Cart estimated subtotal while Wysiwyg is ON
    When click on back button in edit cart screen
    Then verify Edit Order Page is shown
    When click on cancel button in edit order screen
    And click on discard changes in edit order screen
    And click go back button in orders page
    And click on continue shopping in edit cart screen

  #Author: Rohith
  #C71310
  @regression @module_cartV2
  Scenario: Non Empty in-Store Cart_disclaimer
    When click on home tab
    When empty the cart using API service
    And select the in-store run store for Cart Api
    When click on home tab
    And search a product on home page
    And add a product on product details page
    And go back to Home Page from product details page
    And go to cart screen
    Then verify cart disclaimer message 'is' displayed
    And close cart screen

  #Author: Rohith
  #C71317
  @regression @module_cartV2
  Scenario: Empty in-Store Cart_disclaimer
    When click on home tab
    When empty the cart using API service
    And select the in-store run store for Cart Api
    And go to cart screen
    Then verify cart disclaimer message 'is not' displayed
    And close cart screen

  #Author: Gerardo
  #C71669
  #Can fail on iOS due bug: https://jira.safeway.com/browse/PGG-10578
  @regression @module_cartV2
  Scenario: Verify Empty Edit Cart
    Given empty the cart using API service
    When click on home tab
    And select store with no product out of stock
    And search product "Milk" on home page
    And add 10 number of products on product details page
    And go back to Home Page from product details page
    And verify home screen is displayed
    And go to cart screen
    Then verify title is displayed in cart page
    And click on Checkout Button CTA in cart page
    And user selects next day in pickup options screen
    And user clicks on Continue to payment CTA at the slot selection screen
    And user completes credit card form in checkout process
    And click continue to review order
    And click on place order button
    And click on edit order button in orders page
    Then verify Edit Order Page is shown
    And click on edit cart and preferences
    Then verify Past Purchases Button is displayed
    When swipe across a product card to delete it in cart
    Then verify Past Purchases Button is displayed
    Then verify search bar is displayed in edit cart screen
    When click on back button in edit cart screen
    Then verify Edit Order Page is shown
    Then verify confirm changes button is disable in edit order screen
    When click on cancel button in edit order screen
    And click on discard changes in edit order screen
    And click go back button in orders page
    And click on continue shopping in edit cart screen

  #Author: Harish
  #C71228
  @regression @module_cartV2
  Scenario: Non Empty in-Store Cart View
    Given empty the cart using API service
    When click on home tab
    And select in-store run using zip code and store name
    Then verify home screen is displayed
    And search product "chicken" on home page
    And add a product on product details page
    And click back button on product details page
    And click cancel button on product search page
    And go to cart screen
    Then verify delivery or pickup CTA "is" displayed in cart screen
    And verify pay in-store CTA "is" displayed in cart screen
    And verify pay in-store CTA is "enabled" in cart screen
    And close cart screen

    #Author: Gerardo
  #C71162
  @regression @module_cartV2
  Scenario: Verify Substitutions option is not shown for In-Store Shopping method
    Given empty the cart using API service
    When select in-store run using zip code and store name
    When click on home tab
    And search product "Milk" on home page
    And add a product on product details page
    And go back to Home Page from product details page
    Then verify home screen is displayed
    And go to cart screen
    Then verify no substitution options on cart page
    When close cart screen

  #Author: Harish
  #C71229
  @regression @module_cartV2
  Scenario: Empty in-Store Cart View
    Given empty the cart using API service
    When click on home tab
    And select in-store run using zip code and store name
    Then verify home screen is displayed
    And go to cart screen
    Then verify delivery or pickup CTA "is" displayed in cart screen
    And verify pay in-store CTA "is" displayed in cart screen
    And verify pay in-store CTA is "disabled" in cart screen
    And close cart screen

  #Author: Harish
  #C71231
  @regression @module_cartV2
  Scenario: Delivery/Pickup CTA in In-Store View
    Given empty the cart using API service
    When click on home tab
    And select in-store run using zip code and store name
    Then verify home screen is displayed
    And search product "chicken" on home page
    And add a product on product details page
    And click back button on product details page
    And click cancel button on product search page
    And go to cart screen
    And user clicks delivery or pickup CTA in cart screen
    Then verify zip code screen is displayed
    And user clicks cancel button in zip code screen
    And close cart screen

  #Author: Harish
  #C71232
  @regression @module_cartV2
  Scenario: Pay In-Store CTA in In-Store View
    Given empty the cart using API service
    When click on home tab
    And select in-store run using zip code and store name
    Then verify home screen is displayed
    And search product "chicken" on home page
    And add a product on product details page
    And click back button on product details page
    And click cancel button on product search page
    And go to cart screen
    And user clicks pay in-store CTA in cart screen
    Then verify user is in wallet screen

  #Author: Harish
  #C71233
  @regression @module_cartV2
  Scenario: In-store view negative scenario- Different Shopping mode
    Given empty the cart using API service
    When click on home tab
    And select in-store run using zip code and store name
    Then verify home screen is displayed
    And search product "chicken" on home page
    And add a product on product details page
    And click back button on product details page
    And click cancel button on product search page
    And go to cart screen
    Then verify delivery or pickup CTA "is" displayed in cart screen
    And verify pay in-store CTA "is" displayed in cart screen
    And close cart screen
    And select the delivery store
    Then verify home screen is displayed
    And go to cart screen
    Then verify delivery or pickup CTA "is not" displayed in cart screen
    And verify pay in-store CTA "is not" displayed in cart screen
    And close cart screen
    And select the pick-up store
    Then verify home screen is displayed
    And go to cart screen
    Then verify delivery or pickup CTA "is not" displayed in cart screen
    And verify pay in-store CTA "is not" displayed in cart screen
    And close cart screen

  #Author: Rohith
  #C71266
  @regression @module_cartV2 @network_scenario
  Scenario: Error popus should be displayed in case of no network / API failure when pulltorefresh is done
    When empty the cart using API service
    When click on home tab
    When search product "Milk" on home page
    Then verify products listing page displayed
    And add 1 number of products on product details page
    And go back to Home Page from product details page
    Then verify home screen is displayed
    And go to cart screen
    And turn "OFF" internet and relaunch app
    And scroll up the screen
    And verify network error popup is displayed in cart screen
    And user clicks ok on network error popup
    And close cart screen
    And turn "ON" internet and relaunch app

  #Author: Harish
  #C71107
  @regression @module_cartV2 @network_scenario
  Scenario: Network failure scenario while on fetching and updating cart
    Given empty the cart using API service
    When click on home tab
    Then verify home screen is displayed
    And search a product on home page
    When add 1 number of products on product details page
    And go back to Home Page from product details page
    Then verify home screen is displayed
    And turn "OFF" internet and relaunch app
    And user clicks ok on network error popup
    And go to cart screen
    Then verify network error popup is displayed in cart screen
    And turn "ON" internet and relaunch app
    And user clicks ok on network error popup
    And close cart screen

  #Author: Harish
  #C71174
  @regression @module_cartV2 @network_scenario
  Scenario: API failure & Network failure scenario while incrementing or decrementing quantity
    Given empty the cart using API service
    When click on home tab
    And search a product on home page
    When add 1 number of products on product details page
    And go back to Home Page from product details page
    Then verify home screen is displayed
    And go to cart screen
    And user clicks on product quantity in cart screen to open quantity stepper
    And turn "OFF" internet and relaunch app
    And user clicks ok on network error popup
    And user clicks on increment quantity button in quantity stepper
    Then verify network error popup is displayed in cart screen
    And close cart screen
    And turn "ON" internet and relaunch app
    And user clicks ok on network error popup

  #Author: Rohith
  #C71157
  @regression @module_cartV2 @network_scenario @end_scenario
  Scenario: As a User, I should be able to see Internet connectivity error popup in case of Network failure
    Given empty the cart using API service
    When click on home tab
    And search product "Milk" on home page
    Then verify products listing page displayed
    And add a product on product details page
    And go back to Home Page from product details page
    Then verify home screen is displayed
    And go to cart screen
    When turn "OFF" internet and relaunch app
    And user clicks ok on network error popup
    And swipe partially across a product card in cart
    And click on the Remove button
    Then verify network error popup is displayed in cart screen
    And close cart screen
    When turn "ON" internet and relaunch app
    And user clicks ok on network error popup
