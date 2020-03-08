package github.yangllli.springboot_demos.springDataJpa.dao;

import github.yangllli.springboot_demos.springDataJpa.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository< , >
 */


public interface CategoryRep extends JpaRepository<Category,Integer> {
}
