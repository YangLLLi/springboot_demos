package github.yangllli.springboot_demos.spring;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * spring示例
 * spring主要包含IOC和AOP两大部分
 * IOC将类实例的管理交由spring容器统一管理 applicationContext
 * @ComponentScan @Component @Autowired
 * @profile @Qualifier @Scope
 * AOP实现面向切片编程， @aspect @pointCut @before
 * */
@Component
public class SpringDemo {
    private Category category;
    private Product product;

    public Product getProduct() {
        return product;
    }

    @Autowired
    public void setProduct(Product product) {
        this.product = product;
    }

    public Category getCategory() {
        return category;
    }

    @Autowired
    public void setCategory(Category category) {
        this.category = category;
    }
}

