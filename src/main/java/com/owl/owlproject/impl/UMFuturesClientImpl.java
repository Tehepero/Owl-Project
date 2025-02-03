package com.owl.owlproject.impl;

import com.owl.owlproject.enums.DefaultUrls;
import com.owl.owlproject.impl.um_futures.UMAccount;
import com.owl.owlproject.impl.um_futures.UMMarket;
import com.owl.owlproject.impl.um_futures.UMUserData;

public class UMFuturesClientImpl extends FuturesClientImpl {
    private static String defaultBaseUrl = DefaultUrls.USDM_PROD_URL;
    private static String umProduct = "/fapi";

    public UMFuturesClientImpl() {
        super(defaultBaseUrl, umProduct);
    }

    public UMFuturesClientImpl(String baseUrl) {
        super(baseUrl, umProduct);
    }

    public UMFuturesClientImpl(String apiKey, String secretKey) {
        super(apiKey, secretKey, defaultBaseUrl, umProduct);
    }

    public UMFuturesClientImpl(String baseUrl, boolean showLimitUsage) {
        super(baseUrl, umProduct, showLimitUsage);
    }

    public UMFuturesClientImpl(String apiKey, String secretKey, boolean showLimitUsage) {
        super(apiKey, secretKey, defaultBaseUrl, umProduct, showLimitUsage);
    }

    public UMFuturesClientImpl(String apiKey, String secretKey, String baseUrl) {
        super(apiKey, secretKey, baseUrl, umProduct);
    }

    @Override
    public UMMarket market() {
        return new UMMarket(getProductUrl(), getBaseUrl(), getApiKey(), getShowLimitUsage(), getProxy());
    }

    @Override
    public UMAccount account() {
        return new UMAccount(getProductUrl(), getApiKey(), getSecretKey(), getShowLimitUsage(), getProxy());
    }

    @Override
    public UMUserData userData() {
        return new UMUserData(getProductUrl(), getApiKey(), getShowLimitUsage(), getProxy());
    }
}
