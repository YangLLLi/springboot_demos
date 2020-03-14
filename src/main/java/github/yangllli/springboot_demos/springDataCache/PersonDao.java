package github.yangllli.springboot_demos.springDataCache;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDao extends JpaRepository<Person,Integer> {

    Person findByName(String name);
}
