package com.spring.demo.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) //Method 에만 해당 Annotation을 추가 할 수 있게하는 설
@Retention(RetentionPolicy.RUNTIME )
public @interface LogExecutionTime  {

}
