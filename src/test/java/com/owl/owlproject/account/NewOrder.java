package com.owl.owlproject.account;

// Binance API의 예외 처리 클래스들을 임포트

import com.owl.owlproject.exceptions.BinanceClientException;
import com.owl.owlproject.exceptions.BinanceConnectorException;
import com.owl.owlproject.impl.UMFuturesClientImpl;
import com.owl.owlproject.config.PrivateConfig;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;

// NewOrder 클래스는 신규 주문을 생성하는 기능을 구현
public final class NewOrder {

    // 주문 수량과 가격을 설정 (여기서는 예시로 0.01 BTC, 가격은 50000 USDT)
    private static final double quantity = 0.01;
    private static final double price = 50000;

    // 로깅을 위한 로거 객체 생성
    private static final Logger logger = LoggerFactory.getLogger(NewOrder.class);

    @Test
    public void testNewOrder() {
        // LinkedHashMap을 사용하여 API 호출에 필요한 파라미터를 저장
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();

        // UMFuturesClientImpl 객체를 생성 (API 키, 비밀 키, 테스트넷 URL을 PrivateConfig에서 가져옴)
        UMFuturesClientImpl client = new UMFuturesClientImpl(PrivateConfig.TESTNET_API_KEY, PrivateConfig.TESTNET_SECRET_KEY, PrivateConfig.TESTNET_BASE_URL);

        // 주문에 필요한 파라미터 설정
        parameters.put("symbol", "BTCUSDT");  // 거래할 심볼 (BTC/USDT)
        parameters.put("side", "SELL");       // 주문 방향 (SELL)
        parameters.put("type", "LIMIT");      // 주문 유형 (LIMIT)
        parameters.put("timeInForce", "GTC"); // 주문 만료 방식 (Good Till Canceled)
        parameters.put("quantity", quantity); // 주문 수량 (0.01)
        parameters.put("price", price);       // 주문 가격 (50000)

        try {
            // newOrder 메서드를 호출하여 신규 주문을 생성하고 결과를 받음
            String result = client.account().newOrder(parameters);
            // 결과를 로깅 (주문 성공 시 반환된 결과 출력)
            logger.info(result);
        } catch (BinanceConnectorException e) {
            // BinanceConnectorException 예외가 발생하면 에러 메시지와 함께 로깅
            logger.error("fullErrMessage: {}", e.getMessage(), e);
        } catch (BinanceClientException e) {
            // BinanceClientException 예외가 발생하면 에러 메시지, 상세 메시지, 오류 코드, HTTP 상태 코드 등을 로깅
            logger.error("fullErrMessage: {} \nerrMessage: {} \nerrCode: {} \nHTTPStatusCode: {}",
                    e.getMessage(), e.getErrMsg(), e.getErrorCode(), e.getHttpStatusCode(), e);
        }
    }
}
