package com.spring.demo.ioc;

/**
 * ExampleController class 내부에서 ExampleRepository instance를 생성할 경우 ExampleRepository instance의 생명주기는 ExampleController와 같다
 * ExampleController 내부에서 생성된 instance들은 ExampleController가 제어권을 갖는다.
 * private ExampleRepository exampleRepository; 이 코드와 같이 선언만 해두고 생성자 주입이든 필드 주입이든 클래스 외부에서 객체를 생성해 주입하는것이 DI 이다.
 * 즉 private ExampleRepository exampleRepository = new ExampleRepository(); 코드는 DI가 아니다
 * 이 class를 외부 클래스에서 실행시킨다면 ExampleController 생성자를 통해서만 접근이 가능하기 때문에 NPE가 터지지 않는다
 * 하지만 이 클래서에서 method() 함수를 실행시킨다면 NPE가 터진다.
 */
public class ExampleController {

    private ExampleRepository exampleRepository;

    public ExampleController(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }

    public void method() {
        exampleRepository.save();
    }
}
