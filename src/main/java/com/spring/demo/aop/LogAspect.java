package com.spring.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component // Bean으로 등록되어야 하기 때문에 @Component
@Aspect // Annotation을 처리할 수 있게 @Aspect 어노테이션을 선언
public class LogAspect {

    Logger log = LoggerFactory.getLogger(LogAspect.class); // Slf4j Logger 생성

    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable { //Around 어노테이션을 사용하면 joinPoint 파라미터를 받을 수 있
        // joinPoint 는 @LogExecutionTime 이라는 어노테이션이 붙어있는 Method를 뜻함 (이전에 @Target 으로 ElementType을 Method로 잡았기 때문에 Method만 해당됨)
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object proceed = joinPoint.proceed(); //@LogExecutionTime 이 붙어있는 Method를 실행하겠다고 선언

        stopWatch.stop();
        System.out.println("stopWatch = " + stopWatch.prettyPrint());

        return proceed; //Method 실행결과가 있으면 해당 결과를 return 하겠다.
    }
}
