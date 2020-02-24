package github.yangllli.springboot_demos.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AopDemo {
    public void m1() {
        log.info("m1");
    }

    public void m2(int i) {
        log.info(String.valueOf(i));
    }
}
