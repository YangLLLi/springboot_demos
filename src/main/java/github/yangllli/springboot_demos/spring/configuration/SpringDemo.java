package github.yangllli.springboot_demos.spring.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Setter
@Getter
public class SpringDemo {
    private Category category;
    private Product product;
}

