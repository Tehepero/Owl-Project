package com.owl.owlproject.account;

// Binance Futures 클라이언트 예외처리 관련 클래스 import.

import com.owl.owlproject.exceptions.BinanceClientException;
import com.owl.owlproject.exceptions.BinanceConnectorException;
import com.owl.owlproject.impl.UMFuturesClientImpl;
import com.owl.owlproject.config.PrivateConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;

/**
 * CancelOrder 클래스는 Binance Universal Market Futures(UMF) API를 사용하여
 * 특정 주문을 취소하는 방법을 보여줍니다.
 * 이 코드는 학습용이며 실제 운영 환경에 바로 사용되도록 설계되지 않았습니다.
 */
public final class CancelOrder {
    // 객체 생성을 방지하기 위한 private 생성자.
    private CancelOrder() {
    }

    // 로깅을 위한 Logger 인스턴스 생성.
    private static final Logger logger = LoggerFactory.getLogger(CancelOrder.class);

    /**
     * Binance UMFuturesClientImpl를 이용해 특정 주문을 취소하는 메인 메서드.
     *
     * @param args 명령줄 인자(이 예제에서는 사용되지 않음).
     */
    public static void main(String[] args) {
        // API 요청에 필요한 파라미터를 저장할 LinkedHashMap 생성.
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();

        // PrivateConfig에 정의된 API 키와 테스트넷 URL을 사용해 Binance Futures 클라이언트 초기화.
        UMFuturesClientImpl client = new UMFuturesClientImpl(
                PrivateConfig.TESTNET_API_KEY, // 테스트넷 API 키.
                PrivateConfig.TESTNET_SECRET_KEY, // 테스트넷 시크릿 키.
                PrivateConfig.TESTNET_BASE_URL // 테스트넷 Base URL.
        );

        // 요청 파라미터 설정.
        parameters.put("symbol", "BTCUSDT"); // 거래 페어(BTC/USDT)를 설정.
        parameters.put("orderId", ""); // 취소할 주문 ID를 설정(빈 문자열은 테스트용).

        try {
            // Binance API의 cancelOrder 메서드를 호출해 특정 주문 취소.
            String result = client.account().cancelOrder(parameters);
            logger.info(result); // 성공적으로 처리된 경우 결과를 로그로 출력.
        } catch (BinanceConnectorException e) {
            // 네트워크 및 API 연결 관련 에러 처리.
            logger.error("fullErrMessage: {}", e.getMessage(), e);
        } catch (BinanceClientException e) {
            // 클라이언트 측 요청 에러 처리(잘못된 요청 파라미터 등).
            logger.error("fullErrMessage: {} \nerrMessage: {} \nerrCode: {} \nHTTPStatusCode: {}",
                    e.getMessage(), e.getErrMsg(), e.getErrorCode(), e.getHttpStatusCode(), e);
        }
    }
}