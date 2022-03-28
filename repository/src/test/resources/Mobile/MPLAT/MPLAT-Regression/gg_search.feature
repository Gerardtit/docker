Feature: Search- MFA

  Background:
    When sign out if user is logged in to app
    When Launch the MFA app
    And sign in to the application
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    Then verify search bar "is" displayed

  @bvt_regression
  Scenario: Verify no search results are displayed for Invalid product search
    When user clicks search bar on home page
    And user types "grdiamfies" on search bar
    Then verify no search results are displayed
    Then user navigates back to Home Page

  @bvt_regression
  Scenario: Verify appropriate Search results are displayed for valid product search
    When user clicks search bar on home page
    And user types "Bread" on search bar
    Then user see option to select "Bread"
    Then user navigates back to Home Page

  @regression
  Scenario: Search for Valid item and cancel
    And search a product on home page
    Then verify products listing page displayed
    When user goes back to home page from search page
    Then verify home screen is displayed

  @regression
  Scenario: verify scan feature on search bar
    When user clicks search bar on home page
    And user types "grdiam" on search bar
    Then verify search bar changes view to typing state
    And verify scan icon is replaced by cancel icon
    When user goes back to home page from search page
    Then verify that barcode scan option is displayed
    When click on barcode scan option
    And click allow on camera permission popup
    And click get started on tutorials
    And click close icon on scan screen
    Then verify Deals option selected
    Then verify scan to clip drawer text

  @regression
  Scenario: Verify Keyboard is minimized while clicking on My Rewards, Clipped Deals and Weekly Ads link on Deals page
    When go to Deals tab
    And click on search field
    And user types "milk" on search bar and click search on home page
    When click on My Rewards on Deals page
    Then verify that my rewards page is displayed
    Then click back button from my rewards
    Then verify keyboard is not opened
    When user click on cancel button in search bar
    And click on search field
    And user types "milk" on search bar and click search on home page
    And click on Clipped deals on Deals page
    Then verify Clipped deals title
    Then click back button on Clipped deals page
    Then verify keyboard is not opened
    When user click on cancel button in search bar
    Then search for product "Milk" on deals page search bar
    And click on Weekly Ads on Deals page
    Then verify loading spinner is displayed until weekly ads page is fully loaded
    Then click back button on Weekly Ads page
    Then verify keyboard is not opened

  @regression
  Scenario: Verify Screen dismissal on cancel of different screens in Deals page
    When go to Deals tab
    When go to 'All Deals' Tab
    When user clicks search bar on home page
    And user types "milk" on search bar
    When user click on cancel button in search bar
    Then verify user navigates to All deals tab
    When go to 'Categories' Tab
    Then search for product "Milk" on deals page search bar
    When user click on cancel button in search bar
    Then verify user navigates to Categories tab
    When go to 'For you' Tab
    Then search for product "Milk" on deals page search bar
    When user click on cancel button in search bar
    Then verify that 'For you' Tab is displayed
#    When go to 'Expiring Soon' Tab
    When search for product "Milk" on deals page search bar
    When user click on cancel button in search bar
    Then verify user navigates to Expiring Soon tab
    When go to 'Promo' Tab
    When search for product "Milk" on deals page search bar
    When user click on cancel button in search bar
    Then verify user navigates to Promo tab
    When go to 'BOGO' Tab
    When search for product "Milk" on deals page search bar
    When user click on cancel button in search bar
    Then verify 'Bogo' tab is displayed

  @regression
  Scenario: Verify Screen dismissal on cancel of different screens in Home page
    And click on search field
    And user types "milk" on search bar
    When user click on cancel button in search bar
    Then verify MFA home screen is displayed
    When go to browse tab
    And click on search field
    And user types "milk" on search bar and click search on home page
    When user click on cancel button in search bar
    When go to Deals tab
    When user clicks search bar on home page
    And user types "milk" on search bar
    When user click on cancel button in search bar
    When go to Mylist tab
    When click on search field
    And user types "milk" on search bar
    When user click on cancel button in search bar
    When go to member tab
    When click on search field
    And user types "milk" on search bar
    When user click on cancel button in search bar

  @regression
  Scenario: For Omnisearch screen, As a user I should able to switch to Deals toggle and search for the product.
    When user clicks search bar on home page
    And user types "milk" on search bar
    Then toggle product to deals
    Then verify deals toggle is selected
    Then verify refine button is present
    Then verify results is displayed with the count
    Then verify Cancel CTA appears on the left of search bar
    When user click on cancel button in search bar
    Then verify MFA home screen is displayed
    When go to browse tab
    And click on search field
    And user types "milk" on search bar and click search on home page
    Then toggle product to deals
    Then verify deals toggle is selected
    Then verify refine button is present
    Then verify results is displayed with the count
    Then verify Cancel CTA appears on the left of search bar
    When user click on cancel button in search bar
    When go to Deals tab
    And click on search field
    And user types "milk" on search bar and click search on home page
    Then verify deals toggle is selected
    Then verify refine button is present
    Then verify results is displayed with the count
    Then verify Cancel CTA appears on the left of search bar
    When user click on cancel button in search bar
    When go to Mylist tab
    And click on search field
    And user types "milk" on search bar and click search on home page
    Then toggle product to deals
    Then verify deals toggle is selected
    Then verify refine button is present
    Then verify results is displayed with the count
    Then verify Cancel CTA appears on the left of search bar
    When user click on cancel button in search bar
    When go to member tab
    And click on search field
    And user types "milk" on search bar and click search on home page
    Then toggle product to deals
    Then verify deals toggle is selected
    Then verify refine button is present
    Then verify results is displayed with the count
    Then verify Cancel CTA appears on the left of search bar
    When user click on cancel button in search bar

  @regression
  Scenario: For Omnisearch screen, As a user I should able to switch to Products toggle and search for the product.
    When user clicks search bar on home page
    And user types "milk" on search bar
    Then verify products toggle selected by default
    Then verify refine button is present
    Then verify results is displayed with the count
    Then verify Cancel CTA appears on the left of search bar
    When user click on cancel button in search bar
    Then verify MFA home screen is displayed
    When go to browse tab
    And click on search field
    And user types "milk" on search bar and click search on home page
    Then verify products toggle selected by default
    Then verify refine button is present
    Then verify results is displayed with the count
    Then verify Cancel CTA appears on the left of search bar
    When user click on cancel button in search bar
    When go to Deals tab
    And click on search field
    And user types "milk" on search bar and click search on home page
    Then toggle deals to product
    Then verify refine button is present
    Then verify results is displayed with the count
    Then verify Cancel CTA appears on the left of search bar
    When user click on cancel button in search bar
    When go to Mylist tab
    And click on search field
    And user types "milk" on search bar and click search on home page
    Then verify products toggle selected by default
    Then verify refine button is present
    Then verify results is displayed with the count
    Then verify Cancel CTA appears on the left of search bar
    When user click on cancel button in search bar
    When go to member tab
    And click on search field
    And user types "milk" on search bar and click search on home page
    Then verify products toggle selected by default
    Then verify refine button is present
    Then verify results is displayed with the count
    Then verify Cancel CTA appears on the left of search bar
    When user click on cancel button in search bar

  @regression
  Scenario: In Omnisearch Screen, Search for invalid item and verify No results found Screen
    And click on search field
    And user types "qzx" on search bar
    Then verify products toggle selected by default
    Then verify "default message" for invalid product search
    Then verify "0 results" displayed below the search box
    Then toggle product to deals
    Then verify "default message" for invalid product search
    Then verify "0 results" displayed below the search box
    When user click on cancel button in search bar
    Then verify MFA home screen is displayed
    When go to browse tab
    And click on search field
    And user types "qzx" on search bar
    Then verify products toggle selected by default
    Then verify "default message" for invalid product search
    Then verify "0 results" displayed below the search box
    Then toggle product to deals
    Then verify "default message" for invalid product search
    Then verify "0 results" displayed below the search box
    When user click on cancel button in search bar
    When go to Deals tab
    And click on search field
    And user types "qzx" on search bar
    Then verify products toggle selected by default
    Then verify "default message" for invalid product search
    Then verify "0 results" displayed below the search box
    Then toggle product to deals
    Then verify "default message" for invalid product search
    Then verify "0 results" displayed below the search box
    When user click on cancel button in search bar
    When go to Mylist tab
    And click on search field
    And user types "qzx" on search bar
    Then verify products toggle selected by default
    Then verify "default message" for invalid product search
    Then verify "0 results" displayed below the search box
    Then toggle product to deals
    Then verify "default message" for invalid product search
    Then verify "0 results" displayed below the search box
    When user click on cancel button in search bar
    When go to member tab
    And click on search field
    And user types "qzx" on search bar
    Then verify products toggle selected by default
    Then verify "default message" for invalid product search
    Then verify "0 results" displayed below the search box
    Then toggle product to deals
    Then verify "default message" for invalid product search
    Then verify "0 results" displayed below the search box
    When user click on cancel button in search bar


  @regression
  Scenario: In Omnisearch Screen, validate Refine filters for search results page
    And click on search field
    And user types "milk" on search bar and click search on home page
    And user click on refine button in search page
    Then verify "Savings" header sub section in Refine menu
    And verify "Products with Deals" under Savings header
    And click on Product with deals
    Then verify Product with Deals is selected
    Then user click on save button
    Then verify results is displayed with the count
    When user click on cancel button in search bar
    When go to browse tab
    And click on search field
    And user types "milk" on search bar and click search on home page
    And user click on refine button in search page
    Then verify "Savings" header sub section in Refine menu
    And verify "Products with Deals" under Savings header
    And click on Product with deals
    Then verify Product with Deals is selected
    Then user click on save button
    Then verify results is displayed with the count
    When user click on cancel button in search bar
    When go to Deals tab
    And click on search field
    And user types "milk" on search bar and click search on home page
    Then toggle deals to product
    And user click on refine button in search page
    Then verify "Savings" header sub section in Refine menu
    And verify "Products with Deals" under Savings header
    And click on Product with deals
    Then verify Product with Deals is selected
    Then user click on save button
    Then verify results is displayed with the count
    When user click on cancel button in search bar
    When go to Mylist tab
    And click on search field
    And user types "milk" on search bar and click search on home page
    And user click on refine button in search page
    Then verify "Savings" header sub section in Refine menu
    And verify "Products with Deals" under Savings header
    And click on Product with deals
    Then verify Product with Deals is selected
    Then user click on save button
    Then verify results is displayed with the count
    When user click on cancel button in search bar
    When go to member tab
    And click on search field
    And user types "milk" on search bar and click search on home page
    And user click on refine button in search page
    Then verify "Savings" header sub section in Refine menu
    And verify "Products with Deals" under Savings header
    And click on Product with deals
    Then verify Product with Deals is selected
    Then user click on save button
    Then verify results is displayed with the count
    When user click on cancel button in search bar

  @regression
  Scenario: In Omnisearch Screen, validate different result count with and without deals
    And click on search field
    And user types "milk" on search bar and click search on home page
    Then verify products with and without deals is displayed
    And user click on refine button in search page
    And click on Product with deals
    Then verify Product with Deals is selected
    Then user click on save button
    Then verify products with deals is displayed
    When user click on cancel button in search bar
    When go to browse tab
    And click on search field
    And user types "milk" on search bar and click search on home page
    Then verify products with and without deals is displayed
    And user click on refine button in search page
    And click on Product with deals
    Then verify Product with Deals is selected
    Then user click on save button
    Then verify products with deals is displayed
    When user click on cancel button in search bar
    When go to Deals tab
    And user types "milk" on search bar and click search on home page
    Then toggle deals to product
    Then verify products with and without deals is displayed
    And user click on refine button in search page
    And click on Product with deals
    Then verify Product with Deals is selected
    Then user click on save button
    Then verify products with deals is displayed
    When user click on cancel button in search bar
    And user types "milk" on search bar
    When go to Mylist tab
    And user types "milk" on search bar and click search on home page
    Then verify products with and without deals is displayed
    And user click on refine button in search page
    And click on Product with deals
    Then verify Product with Deals is selected
    Then user click on save button
    Then verify products with deals is displayed
    When user click on cancel button in search bar
    When go to member tab
    And user types "milk" on search bar and click search on home page
    Then verify products with and without deals is displayed
    And user click on refine button in search page
    And click on Product with deals
    Then verify Product with Deals is selected
    Then user click on save button
    Then verify products with deals is displayed
    When user click on cancel button in search bar


  @regression
  Scenario: As a User, I should be able to search for the product from dashboard search bar
    When sign in to the application
    Then verify home screen is displayed
    When go to Home tab
    And click on shopping mode down arrow
    And select the pick-up store
    And click on search field
    And enter text "Milk" in search field
    And select item from search result list
    And close toggle info popup
    Then verify products are displayed on clicking search results item
    Then verify products listing page displayed
    And click cancel button on search screen
    Then verify dashboard page is displayed