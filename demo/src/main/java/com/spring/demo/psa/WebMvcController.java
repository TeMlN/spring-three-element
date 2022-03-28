package com.spring.demo.psa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebMvcController {

    /**
     * 우린 웹 백엔드 개발을 할때 서블릿 기반으로 개발을 한다 근데 왜 우리는 서블릿 개발을 하지 않을까?
     * 이유는 바로 Service Abstraction 이다 이렇게 추상 인터페이스들로 인해서 우리는 서블릿 개발을 하지 않아도 된다.
     * 그래서 우리는 서블릿 같은 low level에서 개발을 하지않아도 되고 Service Abstraction의 목적중 하나가 바로 개발자의 편의이다.
     * (가만 보면 spring은 참 개발자의 편의성을 극도로 추구하는거 같다)
     *
     * 그러면 Portable Service Abstraction이란 무엇일까?
     * Portable Service Abstraction은 Service Abstraction과 다르게 웹이 동작하는 스택을 기존의 코드를 최대한 건드리지 않고
     * 교체할 수 있게 해준다
     * 지금 이 프로젝트는 tomcat 기반으로 웹이 작동하고 있다 이 프로젝트를 netty 기반으로 작동하게 하려면 어떡해야 할까?
     * 방법은 간단하다 implementation 'org.springframework.boot:spring-boot-starter-web' 의존성을
     * 	implementation 'org.springframework.boot:spring-boot-starter-webflux' 로 갈아끼우면 된다
     * 	그러면 ModelAndView 같이 몇몇 기능들을 제외한 모든 코드는 재사용이 가능해 그대로 netty 기반으로 웹 서버를 구동할 수 있다
     */
    @GetMapping("/")
    public String home() {
        return "hi";
    }
}
