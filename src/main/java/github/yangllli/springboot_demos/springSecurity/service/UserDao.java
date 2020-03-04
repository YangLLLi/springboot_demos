package github.yangllli.springboot_demos.springSecurity.service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {

    public User findByName(String name);

}
