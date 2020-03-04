package github.yangllli.springboot_demos.springSecurity.service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Setter
@Getter
@Entity
@ToString
public class Role {
    @Id
    private int id;
//    数据库中必须为ROLE_xxx
    private String name;
    private String authority;
}
