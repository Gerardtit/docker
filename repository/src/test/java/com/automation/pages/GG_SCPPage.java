package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.TapAction;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_CartPageElements;
import com.automation.pageElements.GG_SCPPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

public class GG_SCPPage extends BasePage {
    private GG_SCPPageElements gg_scpPageElements = new GG_SCPPageElements();
    private GG_CartPageElements gg_cartPageElements = new GG_CartPageElements();

    public GG_SCPPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), gg_scpPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), gg_cartPageElements);
    }


    public String netPromotionPrice() {
        return gg_scpPageElements.netPromotionPriceText.getText().split("[$]+")[1].split(",")[0];
    }

    public String estSubTotalPriceWithDiscount() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            return gg_scpPageElements.estSubTotalPrice.getText().split("[$]+")[1].split(",")[0];
        }
        return gg_scpPageElements.estSubTotalPrice.getAttribute("content-desc").split("[$]+")[1].split(",")[0];
    }

    public String strikethroughPriceWithPer() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            return gg_scpPageElements.strikethroughPriceText.getText().split("[$]+")[3].split(" ")[0];
        }
        return gg_scpPageElements.strikethroughPriceText.getText().split("[$]+")[1].split(" ")[0];
    }

    public String strikethroughPrice() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            return gg_scpPageElements.strikethroughPriceText.getText().split("[$]+")[2].split(" ")[0];
        }
        return gg_scpPageElements.strikethroughPriceText.getText().split("[$]+")[1].split(" ")[0];
    }

    public String netPromotionPerPrice() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            return gg_scpPageElements.strikethroughPriceText.getText().split("[$]+")[2].split(" ")[0];
        }
        return gg_scpPageElements.priceOfEachProductCount.getText().split("[$]+")[1].split(" ")[0];
    }

    public void clickQuantityIcon() {
        new CommonActions(driver).new ClickAction().clickElement(gg_scpPageElements.quantityIcon);
    }

    public void closeStepper() {
        isElementDisplayed(gg_scpPageElements.cartSummaryLabel, 4);
        new TapAction(driver).tapElement(gg_scpPageElements.cartSummaryLabel);
    }

    public boolean isQuantityStepperDisplayed() {
        return isElementDisplayed(gg_scpPageElements.quantityIcon);
    }

    public boolean promotionApplied() {
        return isElementDisplayed(gg_scpPageElements.promotionAppliedIcon);
    }

    public boolean promotionClipped() {
        return isElementDisplayed(gg_scpPageElements.promotionClippedIcon);
    }

    public void incrementProductQuantity() {
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                new TapAction(driver).tapCoordinate(gg_cartPageElements.stepperView.getCenter().getX() + gg_cartPageElements.stepperView.getSize().getWidth() / 3, gg_cartPageElements.stepperView.getCenter().getY());
                break;
            case "ANDROID":
                new CommonActions(driver).new ClickAction().clickElement(gg_scpPageElements.plusIconStepper);
                break;
        }
    }

    public String getTheDealDecriptionFromProductCard() {
        return getText(gg_scpPageElements.dealsDescriptionCartCard);
    }


    public Map<String, Map> getPresenceOfAllProductCards() {
        new WaitAction(driver).waitForDisplayed(gg_cartPageElements.productQuantity, 5);
        Map<String, Map> productCards = new HashMap<String, Map>();
        for (int cntVal = 0; cntVal < 10; cntVal++) {
            for (MobileElement indProduct : gg_cartPageElements.cartProducts) {
                productCards = getProductCardInfo(indProduct, productCards);
            }
            //Add break for cart summary as well
            if (productCards.size() >= new GG_CartPage(driver).getProductCountFromHeader() || isElementDisplayed(gg_cartPageElements.cartV2CartSummary))
                break;
            new CommonActions(driver).new ScrollGestures().scrollDownBySmallAmount();
        }
        return productCards;
    }

    private Map<String, Map> getProductCardInfo(MobileElement indProduct, Map<String, Map> productCards) {
        Map<String, Boolean> productCardElemPresence = new HashMap<String, Boolean>();
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            MobileElement productDescription = indProduct.findElementByXPath("XCUIElementTypeButton");
            String prodDesc = productDescription.getAttribute("label");
            // Based on presence of element add presence in map
            productCardElemPresence.put("Description", !prodDesc.isEmpty());
            productCardElemPresence.put("Price", new CommonActions(driver).new ElementActions().checkPresenceOfChildUsingParentElement(indProduct, "xpath", "//XCUIElementTypeOther[contains(@name,'Price')]"));
            productCardElemPresence.put("DiscountedPrice", new CommonActions(driver).new ElementActions().checkPresenceOfChildUsingParentElement(indProduct, "xpath", "//XCUIElementTypeOther[contains(@name,'Original Price')]"));
            productCardElemPresence.put("PricePerQuantity", new CommonActions(driver).new ElementActions().checkPresenceOfChildUsingParentElement(indProduct, "xpath", "//XCUIElementTypeOther[contains(@name,'Discounted Price')]"));
            productCardElemPresence.put("Quantity", new CommonActions(driver).new ElementActions().checkPresenceOfChildUsingParentElement(indProduct, "name", "btnRoundQuantity"));
            productCardElemPresence.put("DealAppliedStatus", new CommonActions(driver).new ElementActions().checkPresenceOfChildUsingParentElement(indProduct, "name", "btnAppliedOffer"));
            productCardElemPresence.put("DealClippedStatus", new CommonActions(driver).new ElementActions().checkPresenceOfChildUsingParentElement(indProduct, "name", "btnClippedOffer"));
            productCards.put(prodDesc, productCardElemPresence);
            // Add verification for approx validation
            // add logic for checking if the card is in view
        } else if (driver.getPlatformName().equalsIgnoreCase("android")) {
            //Check if the whole card is in view
            if (new CommonActions(driver).new ElementActions().checkPresenceOfChildUsingParentElement(indProduct, "id", "tv_cart_description")
                    && new CommonActions(driver).new ElementActions().checkPresenceOfChildUsingParentElement(indProduct, "id", "divider_line")) {
                //If element is already added then ignore
                MobileElement productDescription = indProduct.findElementById("tv_cart_description");
                String prodDesc = productDescription.getAttribute("text");
                if (!productCards.containsKey(prodDesc)) {
                    productCardElemPresence.put("Description", !prodDesc.isEmpty());
                    productCardElemPresence.put("Price", new CommonActions(driver).new ElementActions().checkPresenceOfChildUsingParentElement(indProduct, "id", "tv_cart_title_price"));
                    productCardElemPresence.put("DiscountedPrice", new CommonActions(driver).new ElementActions().checkPresenceOfChildUsingParentElement(indProduct, "id", "tv_strike_price"));
                    productCardElemPresence.put("PricePerQuantity", new CommonActions(driver).new ElementActions().checkPresenceOfChildUsingParentElement(indProduct, "id", "tv_each_price"));
                    productCardElemPresence.put("ApproxPrice", new CommonActions(driver).new ElementActions().checkPresenceOfChildUsingParentElement(indProduct, "id", "tv_approx_title"));
                    productCardElemPresence.put("Quantity", new CommonActions(driver).new ElementActions().checkPresenceOfChildUsingParentElement(indProduct, "id", "tv_stepper_quantity"));
                    productCardElemPresence.put("DealAppliedStatus", new CommonActions(driver).new ElementActions().checkPresenceOfChildUsingParentElement(indProduct, "id", "iv_checkMark"));
                    productCardElemPresence.put("DealClippedStatus", new CommonActions(driver).new ElementActions().checkPresenceOfChildUsingParentElement(indProduct, "id", "tv_offer"));
                    productCards.put(prodDesc, productCardElemPresence);
                }
            }
        }
        return productCards;
    }

    public double getTotalPriceOfProduct() {
        double totalPrice = 0.0;
        switch (driver.getPlatformName().toUpperCase()) {
            case "ANDROID":
                totalPrice = Double.parseDouble(gg_scpPageElements.totalPriceOfProduct.getText().split("\\$")[1].trim());
                break;
            case "IOS":
                totalPrice = Double.parseDouble(gg_scpPageElements.price.getText().split("Total Price is")[1].split(",")[0].split("\\$")[1].trim());
                break;
        }
        return totalPrice;
    }

    public double getPriceOfEachCountOfProduct() {
        double eachPrice = 0.0;
        switch (driver.getPlatformName().toUpperCase()) {
            case "ANDROID":
                eachPrice = Double.parseDouble(gg_scpPageElements.priceOfEachProductCount.getText().split("\\$")[1].trim());
                break;
            case "IOS":
                eachPrice = Double.parseDouble(gg_scpPageElements.price.getText().split("Discounted Price is")[1].split(",")[0].split("\\$")[1].trim());
                break;
        }
        return eachPrice;
    }

    // strikethrough price of product
    public double getOriginalPriceOfProduct() {
        double originalPrice = 0.0;
        switch (driver.getPlatformName().toUpperCase()) {
            case "ANDROID":
                originalPrice = Double.parseDouble(gg_scpPageElements.strikeThroughOriginalPrice.getText().split("\\$")[1].trim());
                break;
            case "IOS":
                originalPrice = Double.parseDouble(gg_scpPageElements.price.getText().split("Original Price is")[1].split(",")[0].split("\\$")[1].trim());
                break;
        }
        return originalPrice;
    }

    public boolean isOfferClipped() {
        boolean isClipped = false;
        switch (driver.getPlatformName().toUpperCase()) {
            case "ANDROID":
                isClipped = gg_scpPageElements.offerClippedAppliedAndroid.getAttribute("content-desc").toUpperCase().contains("CLIPPED");
                break;
            case "IOS":
                isClipped = isElementDisplayed(gg_scpPageElements.offerClippedIOS, 5);
                break;
        }
        return isClipped;
    }

    public boolean isOfferApplied() {
        boolean isApplied = false;
        switch (driver.getPlatformName().toUpperCase()) {
            case "ANDROID":
                isApplied = gg_scpPageElements.offerClippedAppliedAndroid.getAttribute("content-desc").toUpperCase().contains("APPLIED");
                break;
            case "IOS":
                isApplied = isElementDisplayed(gg_scpPageElements.offerAppliedIOS, 5);
                break;
        }
        return isApplied;
    }
}
