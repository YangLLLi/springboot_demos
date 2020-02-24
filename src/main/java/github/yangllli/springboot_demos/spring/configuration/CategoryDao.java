package github.yangllli.springboot_demos.spring.configuration;

import org.springframework.stereotype.Component;

public class CategoryDao {
    public Category getCategory(int id, String name) {
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        return category;
    }
}
