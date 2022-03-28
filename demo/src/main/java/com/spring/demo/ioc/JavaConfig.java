package com.spring.demo.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Bean 직접 등록
@Configuration
public class JavaConfig {

//    @Bean
    public ExampleRepository exampleRepository() {
        return new ExampleRepository();
    }

    //이렇게 직접 등록을 해주면 ExampleRepository 에서 @Component 어노테이션이 없어도 IoC 컨테이너에 Bean으로 등록된 것이다
}
