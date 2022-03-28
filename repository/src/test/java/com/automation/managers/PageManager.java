package com.automation.managers;

import com.automation.pages.*;
import io.appium.java_client.AppiumDriver;

public class PageManager {

    AppiumDriver driver;
    private GG_DealsPage gg_dealsPage;
    private GG_DashboardPage gg_dashboardPage;
    private GG_ShoppingModePage gg_shoppingModePage;
    private GG_Deals_BOGOPage gg_deals_bogoPage;
    private GG_SignInPage gg_signInPage;
    private GG_Deals_AllDealsPage gg_deals_allDealsPage;
    private GG_Deals_CategoriesPage gg_deals_categoriesPage;
    private GG_Deals_ForYouPage gg_deals_forYouPage;
    private GG_Deals_PromoPage gg_deals_promoPage;


    public PageManager(AppiumDriver driver) {
        this.driver = driver;
    }

    public GG_DealsPage getGg_dealsPage() {
        return (gg_dealsPage == null) ? gg_dealsPage = new GG_DealsPage(driver) : gg_dealsPage;
    }

    public GG_DashboardPage getGg_dashboardPage() {
        return (gg_dashboardPage == null) ? gg_dashboardPage = new GG_DashboardPage(driver) : gg_dashboardPage;
    }

    public GG_ShoppingModePage getGg_shoppingModePage() {
        return (gg_shoppingModePage == null) ? gg_shoppingModePage = new GG_ShoppingModePage(driver) : gg_shoppingModePage;
    }

    public GG_Deals_BOGOPage getGg_deals_bogoPage() {
        return (gg_deals_bogoPage == null) ? gg_deals_bogoPage = new GG_Deals_BOGOPage(driver) : gg_deals_bogoPage;
    }

    public GG_SignInPage getGg_signInPage() {
        return (gg_signInPage == null) ? gg_signInPage = new GG_SignInPage(driver) : gg_signInPage;
    }

    public GG_Deals_AllDealsPage getGg_deals_allDealsPage() {
        return (gg_deals_allDealsPage == null) ? gg_deals_allDealsPage = new GG_Deals_AllDealsPage(driver) : gg_deals_allDealsPage;
    }

    public GG_Deals_CategoriesPage getGg_deals_categoriesPage() {
        return (gg_deals_categoriesPage == null) ? gg_deals_categoriesPage = new GG_Deals_CategoriesPage(driver) : gg_deals_categoriesPage;
    }

    public GG_Deals_ForYouPage getGg_deals_forYouPage() {
        return (gg_deals_forYouPage == null) ? gg_deals_forYouPage = new GG_Deals_ForYouPage(driver) : gg_deals_forYouPage;
    }

    public GG_Deals_PromoPage getGg_deals_promoPage() {
        return (gg_deals_promoPage == null) ? gg_deals_promoPage = new GG_Deals_PromoPage(driver) : gg_deals_promoPage;
    }
}
