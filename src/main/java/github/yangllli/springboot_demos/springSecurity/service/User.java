package github.yangllli.springboot_demos.springSecurity.service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
@ToString
public class User {
    @Id
    private int id;
    private String name;
    private String password;

    @ManyToOne
    @JoinColumn(name = "rid")
    private Role role;
}
