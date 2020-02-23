package github.yangllli.springboot_demos.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * AOP实现面向切片编程， @aspect @pointCut @before
 */
@Aspect
@Component
@Slf4j
public class AspectDemo {
    @Pointcut("execution(public * github.yangllli.springboot_demos.spring.aop.AopDemo.m1() )")
    public void m1(){}

    @Before("m1()")
    public void a1() {
        log.info("before");
    }



}
