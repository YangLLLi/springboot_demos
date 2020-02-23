package github.yangllli.springboot_demos.spring;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class Category {
    private int id;
    private String name;

}
