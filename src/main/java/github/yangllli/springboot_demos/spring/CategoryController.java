package github.yangllli.springboot_demos.spring;

import lombok.Getter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Getter
//若类中有非线程安全的变量，则需要使用@Scope
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) 多例模式
//@Scope(value = "session",proxyMode = ScopedProxyMode.INTERFACES)
//@Scope(value = "request",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CategoryController {

    private CategoryDao categoryDao;

    @Autowired
    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }


}
