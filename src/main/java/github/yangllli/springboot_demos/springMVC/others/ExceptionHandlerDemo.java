package github.yangllli.springboot_demos.springMVC.others;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

/**
 * 统一处理controller的异常
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandlerDemo {
    @ExceptionHandler(IOException.class)
    public void handle() {
        log.warn("io exception");
    }
}
