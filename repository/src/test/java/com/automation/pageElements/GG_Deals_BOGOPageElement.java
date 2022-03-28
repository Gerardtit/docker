package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class GG_Deals_BOGOPageElement {

    @AndroidFindBy(accessibility = "BOGO")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='lblHorizontalTitleCVCellTitle' and contains(@label,'BOGO')]")
    public MobileElement bogo;

    @AndroidFindBy(accessibility = "close")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label == 'close'")
    public MobileElement closeToggleIt;

    @AndroidFindBy(accessibility = "Promo")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='lblHorizontalTitleCVCellTitle' and contains(@label,'Promo')]")
    public MobileElement promoTab;

    @AndroidFindBy(accessibility = "All coupons")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='lblHorizontalTitleCVCellTitle' and contains(@label,'All coupons')]")
    public MobileElement allCouponsTab;

    @AndroidFindBy(accessibility = "deals")
    @iOSXCUITFindBy(accessibility = "Deals")
    public MobileElement bogoDealPage;

    @AndroidFindBy(id = "tv_bogo_category_name")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='buttonBogoDealsHeaderView']")
    public MobileElement categoryTile;

    @AndroidFindBy(id = "tv_bogo_category_count")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'buttonBogoDealsHeaderView' AND visible==1")
    public MobileElement categoryDealCount;

    @AndroidFindBy(id = "tv_bogo_category_name")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'buttonBogoDealsHeaderView' AND visible==1")
    public List<MobileElement> categoryTiles;

    @AndroidFindBy(id = "itemParentLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='productCell']/XCUIElementTypeButton[@visible='true']")
    public List<MobileElement> productCards;

    @AndroidFindBy(id = "itemParentLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='productCell']/XCUIElementTypeButton[@visible='true']")
    public MobileElement firstProductCard;

    @AndroidFindBy(id = "tv_cart_count")
    @iOSXCUITFindBy(id = "btnCartWithBadge")
    public MobileElement myCartCount;

    @AndroidFindBy(accessibility = "View All Related Products")
    @iOSXCUITFindBy(id = "View all Related Products")
    public MobileElement viewAllRelatedProductsBOGO;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Related Products\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Related Products' AND type == 'XCUIElementTypeNavigationBar'")
    public MobileElement relatedProductsPageHeader;

    @AndroidFindBy(id = "carousel_title")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Related Products'")
    public MobileElement relatedProductsInProductCardDetailsPage;

    @AndroidFindBy(id = "deals_cardview")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'productCell'")
    public MobileElement productCard;

    @AndroidFindBy(id = "see_all_bogo_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeCell[not(contains(@name,'productCell'))]")
    public MobileElement seeAlldeals;

    @AndroidFindBy(className = "android.widget.ProgressBar")
    @iOSXCUITFindBy(accessibility = "Status Loading")
    public MobileElement loadingStatus;

    @AndroidFindBy(id = "headerMessage")
    @iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH 'Add multiples of 2 to your cart and get the equal or lesser value item free'")
    public MobileElement bogoDisclaimerCategoryDetails;

    @AndroidFindBy(id = "umaOfferTxt")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"buttonOfferTitle\"])[1]")
    public MobileElement bogoOfferLinkProductCard;

    @AndroidFindBy(id = "offer_qualifying_products")
    @iOSXCUITFindBy(iOSNsPredicate = "type== 'XCUIElementTypeStaticText' AND name BEGINSWITH 'Qualifying Products' and visible==1")
    public MobileElement qualifyingProductsOfferDetailsPage;

    @AndroidFindBy(id = "btnAdd")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Add to Cart']")
    public MobileElement addToCartButton;

    @AndroidFindBy(id = "btnPlus")
    @iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH 'Increment quantity'")
    public MobileElement incrementQuantity;

    @AndroidFindBy(id = "btnMinus")
    @iOSXCUITFindBy(id = "Decrement quantity")
    public MobileElement decrementQuantity;

    @AndroidFindBy(id = "tvQuantity")
    @iOSXCUITFindBy(id = "Quantity")
    public MobileElement currentAddedQuantity;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[1]/XCUIElementTypeButton[1]")
    @AndroidFindBy(accessibility = "Close")
    public MobileElement backButton;

    @AndroidFindBy(id = "isProductOutOfStock")
    @iOSXCUITFindBy(id = "This item is currently Out of Stock")
    public MobileElement outOfStockLabel;

    @AndroidFindBy(id = "tvTotalItemCount")
    @iOSXCUITFindBy(accessibility = "Cart")
    public MobileElement cartInBogoDetailPage;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[contains(@resource-id,'cv_bogo_deals')]/..//android.widget.ImageView[@content-desc='see all deals']")
    public MobileElement collapseDropDownBogoDealsBtn;

    @AndroidFindBy(id = "tvTitle")
    @iOSXCUITFindBy(id = "View all Related Products")
    public MobileElement dealTitleProductDetail;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"DISMISS\")")
    @iOSXCUITFindBy(id = "Dismiss")
    public MobileElement dismissCTA;
}
