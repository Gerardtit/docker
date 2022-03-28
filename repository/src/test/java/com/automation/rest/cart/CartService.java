package com.automation.rest.cart;

import com.automation.mobile.handlers.HttpHandler;
import com.automation.mobile.models.HttpRequest;
import com.automation.mobile.models.HttpResponse;
import com.automation.rest.auth.AccessToken;
import com.automation.rest.cache.CommonCache;
import com.automation.rest.cart.model.GetCartItemsResponse;
import com.automation.rest.cart.model.GetOrdersResponse;
import com.automation.rest.config.RestApiConfig;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.awaitility.Awaitility;
import org.awaitility.core.ConditionTimeoutException;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class CartService {
    private static final int GET_MAX_RETRIES = 2;
    private static final String OCIP_APIM_SUBSCRIPTION_KEY = "26dfa6ab7afe4a88805ce9f5351b78b4";
    private static final String GET_CART = "/abs/acceptancepub/erums/cartservice/api/v1/cart/customer/%s";
    private static final String DELETE_CART = "/abs/acceptancepub/erums/cartservice/api/v1/cart/%s/items";

    private static final String GET_EDIT_CART = "/abs/acceptancepub/erums/orderservice/api/v2/orders/%s/%s?storeId=%s";
    private static final String GET_ORDERS = "/abs/acceptancepub/erums/orderservice/api/v2/orders/summary?storeId=%s";

    private static String HOST = "https://www-qa2.%s.com";
    Logger logger = LogManager.getLogger(getClass());


    public CartService(String banner) {
        HOST = String.format(HOST, resolveBannerNameForHost(banner));
    }

    public <T> T getCartItems(String userName, String password, String customerId, String storeId, String serviceType) {
        GetCartItemsResponse getCartItemsResponse = null;
        String url = HOST + String.format(GET_CART, customerId);
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        AccessToken accessToken = new AccessToken(userName, password);
        String accessTokenString = accessToken.getAccessToken();

        Map<String, String> headers = RestApiConfig.getJsonHeaders(accessTokenString);
        headers.put("Content-Type", "application/json");
        headers.put("Ocp-Apim-Subscription-Key", OCIP_APIM_SUBSCRIPTION_KEY);
        request.setUrl(url);
        request.setHeaders(headers);

        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("storeId", storeId);
        if (!serviceType.isEmpty() && serviceType != null) {
            queryParams.put("serviceType", serviceType);
        }
        request.setParams(queryParams);

        try {
            HttpResponse response = HttpHandler.get(request);
            if (response != null && response.getStatusCode() == 200) {
                getCartItemsResponse = new Gson().fromJson(response.getContent(), GetCartItemsResponse.class);
                CommonCache.cartItems.put("cartItems", getCartItemsResponse);
            } else {
                logger.info(String.format("Get cart items request: %s", request));
                logger.info(String.format("Get cart items response: %s", response));
                return (T) ("Get Cart API failed, response received: " + response);
            }
        } catch (Exception e) {
            throw new RuntimeException("Get cart items failed, exception message: " + e.getMessage());
        }
        return (T) getCartItemsResponse;
    }

    public <T> T getOrders(String userName, String password, String storeId) {
        GetOrdersResponse getOrdersResponse = null;
        String url = HOST + String.format(GET_ORDERS, storeId);
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        AccessToken accessToken = new AccessToken(userName, password);
        String accessTokenString = accessToken.getAccessToken();

        Map<String, String> headers = RestApiConfig.getJsonHeaders(accessTokenString);
        headers.put("Content-Type", "application/json");
        headers.put("Ocp-Apim-Subscription-Key", OCIP_APIM_SUBSCRIPTION_KEY);
        request.setUrl(url);
        request.setHeaders(headers);

        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("storeId", storeId);
        request.setParams(queryParams);

        try {
            HttpResponse response = HttpHandler.get(request);
            if (response != null && response.getStatusCode() == 200) {
                getOrdersResponse = new Gson().fromJson(response.getContent(), GetOrdersResponse.class);
                CommonCache.ordersAPI.put("orders", getOrdersResponse);
            } else {
                logger.info(String.format("Get orders request: %s", request));
                logger.info(String.format("Get orders response: %s", response));
                return (T) ("Get Cart API failed, response received: " + response);
            }
        } catch (Exception e) {
            throw new RuntimeException("Get cart items failed, exception message: " + e.getMessage());
        }
        return (T) getOrdersResponse;
    }

    public <T> T getEditCartItems(String userName, String password, String storeId) {
        GetCartItemsResponse getCartItemsResponse = null;
        GetOrdersResponse getOrdersResponse = getOrders(userName, password, storeId);
        String url = HOST + String.format(GET_EDIT_CART, storeId, getOrdersResponse.getCurrentOrders().get(0).getOrderId(), storeId);
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        AccessToken accessToken = new AccessToken(userName, password);
        String accessTokenString = accessToken.getAccessToken();

        Map<String, String> headers = RestApiConfig.getJsonHeaders(accessTokenString);
        headers.put("Content-Type", "application/json");
        headers.put("Ocp-Apim-Subscription-Key", OCIP_APIM_SUBSCRIPTION_KEY);
        request.setUrl(url);
        request.setHeaders(headers);

        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("storeId", storeId);
        queryParams.put("oderId", getOrdersResponse.getCurrentOrders().get(0).getOrderId());
        queryParams.put("storeId", storeId);
        request.setParams(queryParams);

        try {
            HttpResponse response = HttpHandler.get(request);
            if (response != null && response.getStatusCode() == 200) {
                getCartItemsResponse = new Gson().fromJson(response.getContent(), GetCartItemsResponse.class);
                CommonCache.cartItems.put("cartItems", getCartItemsResponse);
            } else {
                logger.info(String.format("Get edit cart items request: %s", request));
                logger.info(String.format("Get edit cart items response: %s", response));
                return (T) ("Get Edit Cart API failed, response received: " + response);
            }
        } catch (Exception e) {
            throw new RuntimeException("Get edit cart items failed, exception message: " + e.getMessage());
        }
        return (T) getCartItemsResponse;
    }


    public GetCartItemsResponse getCartDetails(String userName, String password, String customerId, String storeId, String serviceType) {
        HttpResponse response = fetchCartDetails(userName, password, customerId, storeId, serviceType);
        GetCartItemsResponse getCartItemsResponse = null;
        if (response.getStatusCode() == 200) {
            getCartItemsResponse = new Gson().fromJson(response.getContent(), GetCartItemsResponse.class);
        }
        return getCartItemsResponse;
    }


    private String resolveBannerNameForHost(String banner) {
        String resolvedBanner = banner;
        if (banner.contains("acme")) {
            resolvedBanner = "acmemarkets";
        } else if (banner.contains("carrs")) {
            resolvedBanner = "carrsqc";
        }
        return resolvedBanner;
    }

    private HttpResponse fetchCartDetails(String userName, String password, String customerId, String storeId, String serviceType) {
        String url = HOST + String.format(GET_CART, customerId);
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        AccessToken accessToken = new AccessToken(userName, password);
        String accessTokenString = accessToken.getAccessToken();

        Map<String, String> headers = RestApiConfig.getJsonHeaders(accessTokenString);
        headers.put("Content-Type", "application/json");
        headers.put("Ocp-Apim-Subscription-Key", OCIP_APIM_SUBSCRIPTION_KEY);
        request.setUrl(url);
        request.setHeaders(headers);

        Map<String, Object> queryParams = new HashMap<>();
        if (serviceType != null && !serviceType.isEmpty()) {
            queryParams.put("serviceType", serviceType);
        }
        if (storeId != null && !storeId.isEmpty()) {
            queryParams.put("storeId", storeId);
        }
        request.setParams(queryParams);
        HttpResponse response = HttpHandler.get(request);
        HttpResponse finalResponse = response;
        try {
            Awaitility.waitAtMost(42, TimeUnit.SECONDS).with().pollInterval(10, TimeUnit.SECONDS).until(() -> finalResponse.getStatusCode() == 200 || finalResponse.getStatusCode() == 201);
        } catch (ConditionTimeoutException ex) {
            logger.info("Get Cart Items request: " + request);
            logger.info("Get Cart Items response: " + response);
            throw new RuntimeException("Get Cart Items  failed, response: " + response);
        }
        return response;
    }


    public HttpResponse deleteAllItemsFromTheCart(String userName, String password, String storeId, String cartId, List<String> itemId) {
        String url = HOST + String.format(DELETE_CART, cartId);
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        //Access Token
        AccessToken accessToken = new AccessToken(userName, password);
        String accessTokenString = accessToken.getAccessToken();

        Map<String, String> headers = RestApiConfig.getJsonHeaders(accessTokenString);
        headers.put("Content-Type", "application/json");
        headers.put("Ocp-Apim-Subscription-Key", OCIP_APIM_SUBSCRIPTION_KEY);
        request.setUrl(url);
        request.setHeaders(headers);

        Map<String, Object> queryParams = new HashMap<>();
        if (storeId != null && !storeId.isEmpty()) {
            queryParams.put("storeId", storeId);
        }
        request.setParams(queryParams);

        Map<String, Object> requestBody = new LinkedHashMap<String, Object>();
        List<LinkedHashMap<String, Object>> itemIdValues = new ArrayList<LinkedHashMap<String, Object>>();
        itemId.forEach(indVal -> itemIdValues.add(new LinkedHashMap<String, Object>() {{
            put("itemId", indVal);
        }}));
        requestBody.put("cartItemsList", itemIdValues);
        request.setServiceBody(requestBody);
        HttpResponse response = deleteWithRetry("Delete cart items", request);
        if ((response == null) || (response.getStatusCode() != 200 && response.getStatusCode() != 201)) {
            logger.info(String.format("Delete cart items request: %s", request));
            logger.info(String.format("Delete cart items response: %s", response));
        }
        return response;
    }

    //Get request with retry in case of failure
    private HttpResponse getWithRetry(String resourceName, HttpRequest request) {
        HttpResponse response = null;
        for (int retryCounter = 1; retryCounter <= GET_MAX_RETRIES; retryCounter++) {
            response = HttpHandler.get(request);
            if (response.getStatusCode() == 200) {
                break;
            } else {
                Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
                logger.info(resourceName + " request failed, retrying...");
            }
        }
        return response;
    }

    //Delete request with retry in case of failure
    private HttpResponse deleteWithRetry(String resourceName, HttpRequest request) {
        HttpResponse response = null;
        for (int retryCounter = 1; retryCounter <= GET_MAX_RETRIES; retryCounter++) {
            response = HttpHandler.deleteWithPayload(request);
            if (response.getStatusCode() == 200) {
                break;
            } else {
                Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
                logger.info(resourceName + " request failed, retrying...");
            }
        }
        return response;
    }

}
