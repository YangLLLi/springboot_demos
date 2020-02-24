package github.yangllli.springboot_demos.spring;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
public class Category {
    private int id;
    private String name;
}
