package com.spring.demo.ioc.example;

import org.springframework.stereotype.Service;

@Service
public class LegacyMemberServiceImpl implements MemberService {

    @Override
    public void signup() {
        System.out.println("구식 회원가입 방법이에요!");
    }

    @Override
    public void login() {
        System.out.println("구식 로그인 방법이에요!");
    }
}
