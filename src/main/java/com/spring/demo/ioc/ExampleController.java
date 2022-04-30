package com.spring.demo.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

/**
 * *** IoC ***
 * ExampleController class 내부에서 ExampleRepository instance를 생성할 경우 (구현 클래스 까지 선언 경우)ExampleRepository instance의 생명주기는 ExampleController와 같다
 * ExampleController 내부에서 생성된 instance들은 ExampleController가 제어권을 갖는다.
 * private ExampleRepository exampleRepository; 이 코드와 같이 선언만 해두고 생성자 주입이든 필드 주입이든 클래스 외부에서 객체를 생성해 주입하는것이 DI 이다.
 * 즉 private ExampleRepository exampleRepository = new ExampleRepository(); 코드는 DI가 아니다
 * 이 class를 외부 클래스에서 실행시킨다면 ExampleController 생성자를 통해서만 접근이 가능하기 때문에 NPE가 터지지 않는다
 * 하지만 이 클래서에서 method() 함수를 실행시킨다면 NPE가 터진다.
 *
 *
 * *** IoC Container ***
 * IoC Container?: Bean을 만들고 엮어주며 제공해준다.
 * IoC Container는 BeanFactory 또는 ApplicationContext를 사용하게 된다 참고로 ApplicationContext에는 BeanFactory를 상속받는다.
 * IoC Container에 Bean을 등록하려면 여러가지 방법이 있는데 어노테이션을 이용한 방법이있다.
 * 지금 당장 이 class 내부의 ExampleController 생성자의 ExampleRepository의 객체 타입도 IoC Container가 넣어준다.
 *
 *
 */
@Controller
public class ExampleController {

    private ExampleRepository exampleRepository;
    private final ApplicationContext applicationContext;

    //생성자 주입
    public ExampleController(ApplicationContext applicationContext, ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
        this.applicationContext = applicationContext;
    }

    //Setter 주입 (생성자 주입을 제외하고는 객체를 선언할때 final 키워드를 사용하지 못함)
//    public void setExampleRepository(ExampleRepository exampleRepository) {
//        this.exampleRepository = exampleRepository;
//    }

    //필드 주입
//    @Autowired
//    private FieldExample fieldExample;
    
    public void findBean() {
        System.out.println("applicationContext.getBean() = " + applicationContext.getBean("exampleRepository", ExampleRepository.class));
        System.out.println("this.exampleRepository = " + this.exampleRepository);
    }

    public void method() {
        exampleRepository.save();
    }
}
