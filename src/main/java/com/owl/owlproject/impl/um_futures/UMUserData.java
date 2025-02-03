package com.owl.owlproject.impl.um_futures;

import com.owl.owlproject.impl.futures.UserData;
import com.owl.owlproject.utils.ProxyAuth;

/**
 * <h2>USDⓈ-Margined User Data Streams Endpoints</h2>
 * All endpoints under the
 * <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/user-data-streams/Connect">User Data Streams</a>
 * section of the API documentation will be implemented in this class.
 * <br>
 * Response will be returned in <i>String format</i>.
 */
public class UMUserData extends UserData {
    public UMUserData(String productUrl, String apiKey, boolean showLimitUsage, ProxyAuth proxy) {
        super(productUrl, apiKey, showLimitUsage, proxy);
    }
}
