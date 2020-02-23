package github.yangllli.springboot_demos.spring.configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private int id;
    private String name;
    private Category category;
    public Product(Category category) {
        this.category = category;
    }
}
