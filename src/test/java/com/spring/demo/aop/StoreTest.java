package com.spring.demo.aop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    @Test
    @DisplayName("CreditCard구현체 사용시 StopWatch가 터져야함")
    public void CreditCardTest() {

        Payment payment = new CreditCard(); //해당 인스턴스의 구현체만 갈아끼워도 이 메서드의 내용은 달라진다 이것이 바로 프록시 패턴을 이용한 AOP이다
        Store store = new Store(payment);

        store.pay(200);
    }

    // 이렇게 AOP를 구현할 수 있다 그러면 왜 AOP를 사용하는가?
    // 코드를 변경하지 않아도 다른 결과를 만들어내기 때문이다 구현체만 바꾸면 되니까!

    @Test
    @DisplayName("Cash구현체 사용시 StopWatch가 터지지 않음")
    public void CashTest() {

        Payment payment = new Cash();
        Store store = new Store(payment);

        store.pay(200);
    }
}