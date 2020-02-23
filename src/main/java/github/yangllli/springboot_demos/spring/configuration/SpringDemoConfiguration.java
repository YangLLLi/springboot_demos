package github.yangllli.springboot_demos.spring.configuration;

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
    @Bean
    public Category getCategory() {
        return new Category();
    }

    @Bean
    public Product getProduct(Category category) {
        return new Product(category);
    }

    @Bean
    public SpringDemo getSpringDemo(Category category,Product product) {
        SpringDemo springDemo = new SpringDemo();
        springDemo.setCategory(category);
        springDemo.setProduct(product);
        return springDemo;
    }
}
