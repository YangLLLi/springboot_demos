package github.yangllli.springboot_demos.springMVC.others;

import org.omg.PortableInterceptor.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 拦截器的配置类
 */
public class InterceptorConfigure extends WebMvcConfigurationSupport {
    @Autowired
    HandlerInterceptor interceptor;
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor).addPathPatterns("/interceptor");
        super.addInterceptors(registry);
    }
}
