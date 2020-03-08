package github.yangllli.springboot_demos.springDataJpa.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * pojo中的注解
 * @Entity @Table @Column
 * @Id @GeneratedValue
 * @Transient
 *
 * @ManyToOne(cascade=  ,fetch=)  @JoinColumn
 * @OneToMany(mappedBy=   )
 * @ManyToMany  @JoinTable
 */

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cid", referencedColumnName = "id")
    private Category category;

    private LocalDateTime createDateTime;
}
