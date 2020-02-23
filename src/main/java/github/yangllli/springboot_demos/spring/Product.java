package github.yangllli.springboot_demos.spring;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
//@Profile("dev") @Qualifier("pro") @Scope("prototype")
public class Product {
    private int id;
    private String name;
    private Category category;

    @Autowired
    public Product(Category category) {
        this.category = category;
    }
}
