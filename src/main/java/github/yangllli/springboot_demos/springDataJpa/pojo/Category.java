package github.yangllli.springboot_demos.springDataJpa.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * pojo中的注解
 * @Entity @Table @Column
 * @Id @GeneratedValue
 * @transient
 *
 * @ManyToOne(cascade=  ,fetch=)  @JoinColumn
 * @OneToMany(mappedBy=   )
 * @ManyToMany  @JoinTable
 */


@Getter
@Setter
@ToString
@Entity
//@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @Column
    private String name;

    private LocalDate createDate;
}
