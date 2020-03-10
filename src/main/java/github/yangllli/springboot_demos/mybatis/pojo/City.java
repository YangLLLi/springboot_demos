package github.yangllli.springboot_demos.mybatis.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class City {
    private int id;
    private String name;
    private Province province;
}
