package github.yangllli.springboot_demos.spring.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 如果没有开启@ComponentScan(@SpringBootApplication中含有)
 * 则需要此配置类，也可通过xml实现
 * @Configuration @Bean         @import
 * @profile @Qualifier @Scope
 */

@Configuration
public class SpringDemoConfiguration {
    @Bean("CDao")
    public CategoryDao getCategoryDao() {
        return new CategoryDao();
    }

    @Bean("CController")
    public CategoryController categoryController(CategoryDao categoryDao) {
        return new CategoryController(categoryDao);
    }

    @Bean("SDemo")
    public SpringDemo getSpringDemo(CategoryController categoryController) {
        return new SpringDemo(categoryController);
    }
}
