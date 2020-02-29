package github.yangllli.springboot_demos.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * AOP实现面向切片编程， @aspect @pointCut @before
 */
@Aspect
@Component
@Slf4j
public class AspectDemo {
//    切点
    @Pointcut("execution(public * github.yangllli.springboot_demos.spring.aop.AopDemo.m1() )")
    public void m1() {
    }
//    环绕
    @Around("m1()")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        log.info("ab");
        jp.proceed();
        log.info("aa");
    }
//    带参数的方法
    @Pointcut("execution(* github.yangllli.springboot_demos.spring.aop.AopDemo.m2(int)) "+
    "&& args(i)")
    public void m2(int i){}

    @Before("m2(j)")
    public void before(int j) {
        log.info(String.valueOf(j+1));
    }
//   增加方法
//    value内必须为完整包名
    @DeclareParents(value = "github.yangllli.springboot_demos.spring.aop.AopDemo",defaultImpl = ConsumerImp.class)
    public Consumer<Integer> consumer;

}

@Slf4j
class ConsumerImp implements Consumer<Integer> {

    @Override
    public void accept(Integer integer) {
        log.info(integer.toString());
    }
}
