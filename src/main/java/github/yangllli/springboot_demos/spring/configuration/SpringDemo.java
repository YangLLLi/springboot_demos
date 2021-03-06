package github.yangllli.springboot_demos.spring.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Getter
public class SpringDemo {
    private CategoryController categoryController;

    public SpringDemo(CategoryController categoryController) {
        this.categoryController = categoryController;
    }
}

