package com.spring.demo.aop;

public class Cash implements Payment {

    @Override
    public void pay(int amount) {
        System.out.println(amount +"현금결제");
    }
}
