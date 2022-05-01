package com.spring.demo.ioc;

import com.spring.demo.ioc.example.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IocTest {

    @Autowired
    MemberService newMemberServiceImpl;
    @Autowired
    MemberService memberService;

    @Test
    @DisplayName("만약 구현체가 2개라면?")
    void TwoImplements() {
        memberService.signup();
        memberService.login();
    }

    @Test
    @DisplayName("네이밍 규칙에 맞게 인스턴스를 생성시")
    void NamingPolicy() {
        newMemberServiceImpl.signup();
        newMemberServiceImpl.login();
    }
}
