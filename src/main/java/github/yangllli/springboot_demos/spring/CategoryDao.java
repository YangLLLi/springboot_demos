package github.yangllli.springboot_demos.spring;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
//@Profile("dev") @Qualifier
public class CategoryDao {
    public Category getCategory(int id, String name) {
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        return category;
    }
}
