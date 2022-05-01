package com.spring.demo.ioc.example;

import org.springframework.stereotype.Service;

//@Service
public class MemberServiceImpl implements MemberService {
    @Override
    public void signup() {
        System.out.println("회원가입");
    }

    @Override
    public void login() {
        System.out.println("로그인");
    }
}
