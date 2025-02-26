package com.owl.owlproject.impl.um_futures;

import com.owl.owlproject.enums.HttpMethod;
import com.owl.owlproject.impl.futures.Account;
import com.owl.owlproject.utils.ParameterChecker;
import com.owl.owlproject.utils.ProxyAuth;

import java.util.LinkedHashMap;

/**
 * <h2>USDⓈ-Margined Trade Endpoints</h2>
 * All endpoints under the
 * <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/account/rest-api/New-Future-Account-Transfer">Futures Account/Trade Endpoint</a>
 * section of the API documentation will be implemented in this class.
 * <br>
 * Response will be returned in <i>String format</i>.
 */
public class UMAccount extends Account {
    public UMAccount(String productUrl, String apiKey, String secretKey, boolean showLimitUsage, ProxyAuth proxy) {
        super(productUrl, apiKey, secretKey, showLimitUsage, proxy);
    }

    private final String MULTI_ASSETS_MARGIN = "/v1/multiAssetsMargin";
    /**
     * Change user's Multi-Assets mode (Multi-Assets Mode or Single-Asset Mode) on Every symbol
     * <br><br>
     * POST /v1/multiAssetsMargin
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * multiAssetsMargin -- mandatory/string <br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Change-Multi-Assets-Mode">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Change-Multi-Assets-Mode</a>
     */
    public String changeMultiAssetsMode(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkParameter(parameters, "dualSidePosition", String.class);
        return getRequestHandler().sendSignedRequest(getProductUrl(), MULTI_ASSETS_MARGIN, parameters, HttpMethod.POST, getShowLimitUsage());
    }

    /**
     * Get user's Multi-Assets mode (Multi-Assets Mode or Single-Asset Mode) on Every symbol
     * <br><br>
     * GET /v1/multiAssetsMargin
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/account/rest-api/Get-Current-Multi-Assets-Mode">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/account/rest-api/Get-Current-Multi-Assets-Mode</a>
     */
    public String getCurrentMultiAssetMode(LinkedHashMap<String, Object> parameters) {
        return getRequestHandler().sendSignedRequest(getProductUrl(), MULTI_ASSETS_MARGIN, parameters, HttpMethod.GET, getShowLimitUsage());
    }


    /**
     * Get all open orders on a symbol. Careful when accessing this with no symbol.
     * <br><br>
     * GET /v1/openOrders
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- optional/string <br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Current-All-Open-Orders">
     *    https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Current-All-Open-Orders</a>
     */
    public String currentAllOpenOrders(LinkedHashMap<String, Object> parameters) {
        return super.currentAllOpenOrders(parameters);
    }

    /**
     * Get all open orders on a symbol. Careful when accessing this with no symbol.
     * <br><br>
     * GET /v1/allOrders
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- mandatory/string <br>
     * orderId -- optional/long <br>
     * startTime -- optional/long <br>
     * endTime -- optional/long <br>
     * limit -- optional/integer <br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/All-Orders">
     *    https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/All-Orders</a>
     */
    public String allOrders(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkParameter(parameters, "symbol", String.class);
        return super.allOrders(parameters);
    }

    private final String BALANCE = "/v2/balance";
    /**
     * Get Futures Account Balance
     * <br><br>
     * GET /v2/balance
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/account/rest-api/Futures-Account-Balance-V2">
     *    https://developers.binance.com/docs/derivatives/usds-margined-futures/account/rest-api/Futures-Account-Balance-V2</a>
     */
    public String futuresAccountBalance(LinkedHashMap<String, Object> parameters) {
        return getRequestHandler().sendSignedRequest(getProductUrl(), BALANCE, parameters, HttpMethod.GET, getShowLimitUsage());
    }

    private final String ACCOUNT_INFORMATION = "/v2/account";
    /**
     * Get current account information. User in single-asset/ multi-assets mode will see different value, see comments in response section for detail.
     * <br><br>
     * GET /v2/account
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/account/rest-api/Account-Information-V2">
     *    https://developers.binance.com/docs/derivatives/usds-margined-futures/account/rest-api/Account-Information-V2</a>
     */
    public String accountInformation(LinkedHashMap<String, Object> parameters) {
        return getRequestHandler().sendSignedRequest(getProductUrl(), ACCOUNT_INFORMATION, parameters, HttpMethod.GET, getShowLimitUsage());
    }

    private final String POSITION_RISK = "/v2/positionRisk";
    /**
     * Get current position information.
     * <br><br>
     * GET /v2/positionRisk
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- optional/string <br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Position-Information-V2">
     *    https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Position-Information-V2</a>
     */
    public String positionInformation(LinkedHashMap<String, Object> parameters) {
        return getRequestHandler().sendSignedRequest(getProductUrl(), POSITION_RISK, parameters, HttpMethod.GET, getShowLimitUsage());
    }

    /**
     * Get trades for a specific account and symbol.
     * <br><br>
     * GET /v1/userTrades
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- mandatory/string <br>
     * startTime -- optional/long <br>
     * endTime -- optional/long <br>
     * fromId -- optional/long <br>
     * limit -- optional/integer <br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Account-Trade-List">
     *    https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Account-Trade-List</a>
     */
    public String accountTradeList(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkParameter(parameters, "symbol", String.class);
        return super.accountTradeList(parameters);
    }

    /**
     * Notional and Leverage Brackets
     * <br><br>
     * GET /v1/leverageBracket
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- optional/string <br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/account/rest-api/Notional-and-Leverage-Brackets">
     *    https://developers.binance.com/docs/derivatives/usds-margined-futures/account/rest-api/Notional-and-Leverage-Brackets</a>
     */
    public String getLeverageBracket(LinkedHashMap<String, Object> parameters) {
        return super.getLeverageBracket(parameters);
    }

    private final String API_TRADING_STATUS = "/v1/apiTradingStatus";
    /**
     * Futures Trading Quantitative Rules Indicators
     * For more information on this, please refer to the <a href="https://www.binance.com/en/support/faq/4f462ebe6ff445d4a170be7d9e897272">Futures Trading Quantitative Rules</a>
     * <br><br>
     * GET /v1/apiTradingStatus
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- optional/string <br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/account/rest-api/Futures-Trading-Quantitative-Rules-Indicators">
     *    https://developers.binance.com/docs/derivatives/usds-margined-futures/account/rest-api/Futures-Trading-Quantitative-Rules-Indicators</a>
     */
    public String getTradingRulesIndicators(LinkedHashMap<String, Object> parameters) {
        return getRequestHandler().sendSignedRequest(getProductUrl(), API_TRADING_STATUS, parameters, HttpMethod.GET, getShowLimitUsage());
    }

    private final String INCOME_ASYN = "/v1/income/asyn";
    /**
     * Get Download Id For Futures Transaction History
     * <br><br>
     * GET /v1/income/asyn
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * startTime -- optional/long <br>
     * endTime -- optional/long <br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/account/rest-api/Get-Download-Id-For-Futures-Transaction-History">
     *    https://developers.binance.com/docs/derivatives/usds-margined-futures/account/rest-api/Get-Download-Id-For-Futures-Transaction-History</a>
     */
    public String futuresDownloadId(LinkedHashMap<String, Object> parameters) {
        return getRequestHandler().sendSignedRequest(getProductUrl(), INCOME_ASYN, parameters, HttpMethod.GET, getShowLimitUsage());
    }

    private final String INCOME_ASYN_ID = "/v1/income/asyn/id";
    /**
     * Get Futures Transaction History Download Link by Id
     * <br><br>
     * GET /v1/income/asyn/id
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * downloadId -- mandatory/string <br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/account/rest-api/Get-Futures-Transaction-History-Download-Link-by-Id">
     *    https://developers.binance.com/docs/derivatives/usds-margined-futures/account/rest-api/Get-Futures-Transaction-History-Download-Link-by-Id</a>
     */
    public String futuresDownloadLink(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkParameter(parameters, "downloadId", String.class);
        return getRequestHandler().sendSignedRequest(getProductUrl(), INCOME_ASYN_ID, parameters, HttpMethod.GET, getShowLimitUsage());
    }
}
