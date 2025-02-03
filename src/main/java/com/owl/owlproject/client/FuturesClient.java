package com.owl.owlproject.client;

import com.owl.owlproject.impl.futures.Account;
import com.owl.owlproject.impl.futures.Market;
import com.owl.owlproject.impl.futures.PortfolioMargin;
import com.owl.owlproject.impl.futures.UserData;

public interface FuturesClient {
    Market market();
    Account account();
    UserData userData();
    // Default implementation to make the method optional
    default PortfolioMargin portfolioMargin() {
        throw new UnsupportedOperationException("Portfolio Margin is not supported by this implementation.");
    }
}
