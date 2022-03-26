package com.spring.demo.aop;

public class Store {

    private final Payment payment;

    public Store(Payment payment) {
        this.payment = payment;
    }

    public void pay(int amount) {
        payment.pay(amount);
    }
}
