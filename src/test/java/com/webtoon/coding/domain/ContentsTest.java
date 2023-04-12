package com.webtoon.coding.domain;

import com.webtoon.coding.exception.DomainException;
import com.webtoon.coding.domain.contents.Policy;
import com.webtoon.coding.domain.contents.Contents;
import com.webtoon.coding.mock.ContentsMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContentsTest {

//    @Test
//    @DisplayName("free 타입으로 변경")
//    void changedFreeType() {
//
//        Contents mock = ContentsMock.createdMock();
//
//        mock.changeDetail(Policy.FREE, null);
//
//        assertEquals(Policy.FREE, mock.getType());
//    }
//
//    @Test
//    @DisplayName("유로 타입으로 변경")
//    void changedPagar() {
//
//        final Integer coin = 1000;
//
//        Contents mock = ContentsMock.createdMock();
//
//        mock.changeDetail(Policy.PAGAR, coin.toString());
//
//        assertEquals(Policy.PAGAR, mock.getType());
//        assertEquals(coin.toString(), mock.getCoin());
//    }
//
//    @Test
//    @DisplayName("free 타입 테스트 케이스")
//    void checkedTypeAndCoin_freeType() {
//
//        Contents mock = ContentsMock.createdMock();
//
//        mock.checkedTypeAndCoin();
//
//        assertEquals("0", mock.getCoin());
//    }
//
//    @Test
//    @DisplayName("유료 타입 테스트 케이스")
//    void checkedTypeAndCoin_pagarType() {
//
//        Contents mock =
//                Contents.builder()
//                        .id(1L)
//                        .name("test1")
//                        .author("test1")
//                        .type(Policy.PAGAR)
//                        .coin("100")
//                        .build();
//
//        mock.checkedTypeAndCoin();
//
//        assertEquals("100", mock.getCoin());
//    }
//
//    @Test
//    @DisplayName("유료 타입 이하 테스트 케이스")
//    void checkedTypeAndCoin_이하() {
//
//        Contents mock =
//                Contents.builder()
//                        .id(1L)
//                        .name("test1")
//                        .author("test1")
//                        .type(Policy.PAGAR)
//                        .coin("99")
//                        .build();
//
//        Assertions.assertThrows(DomainException.class, () -> mock.checkedTypeAndCoin());
//    }
//
//    @Test
//    @DisplayName("유료 타입 초과 테스트 케이스")
//    void checkedTypeAndCoin_초과() {
//
//        Contents mock =
//                Contents.builder()
//                        .id(1L)
//                        .name("test1")
//                        .author("test1")
//                        .type(Policy.PAGAR)
//                        .coin("501")
//                        .build();
//
//        Assertions.assertThrows(DomainException.class, () -> mock.checkedTypeAndCoin());
//    }
}
