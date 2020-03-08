package github.yangllli.springboot_demos.springDataJpa.dao;

import github.yangllli.springboot_demos.springDataJpa.pojo.Category;
import github.yangllli.springboot_demos.springDataJpa.pojo.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Sort.by
 * PageRequest.of
 *
 * find  findAll(page、sort)
 * delete deleteAll
 * save saveAll
 *
 * @Query
 */

public interface ProductRep extends JpaRepository<Product,Integer> {
    List<Product> findProductsByCategory(Category category, Pageable pageable);

    @Query(value = "select * from product where name like %?1%",nativeQuery = true)
    List<Product> findByNameLike(String name);
}
