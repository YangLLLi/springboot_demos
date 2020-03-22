package github.yangllli.springboot_demos;

import github.yangllli.springboot_demos.spring.aop.AopDemo;
import github.yangllli.springboot_demos.spring.configuration.SpringDemo;
import github.yangllli.springboot_demos.springDataCache.CacheDemo;
import github.yangllli.springboot_demos.springDataCache.Person;
import github.yangllli.springboot_demos.springDataJpa.dao.CategoryRep;
import github.yangllli.springboot_demos.springDataJpa.pojo.Category;
import github.yangllli.springboot_demos.springDataJpa.pojo.Product;
import github.yangllli.springboot_demos.springDataJpa.service.ProductService;
import github.yangllli.springboot_demos.springSecurity.service.User;
import github.yangllli.springboot_demos.springSecurity.service.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
class SpringbootDemosApplicationTests {
    @Autowired
    private SpringDemo springDemo;
    @Autowired
    private AopDemo demo;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserDao userDao;


//	@Test
//	void springDemoTest() {
//		CategoryDao categoryDao = springDemo.getCategoryController().getCategoryDao();
//		Category c1 = categoryDao.getCategory(1, "c1");
//		log.info(c1.toString());
//
//	}

    @Test
    void springDemoAopTest() {
        demo.m1();
        demo.m2(4);
        Consumer<Integer> consumer = (Consumer<Integer>) demo;
        consumer.accept(5);

    }

    @Test
    void ControllerDemoTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/demo/1"))
                .andExpect(MockMvcResultMatchers.view().name("demo"));
    }

    @Test
    void UserDaoTest() {
        User user1 = userDao.findByName("user1");
        log.info(user1.toString());
    }

    @Autowired
    DataSource dataSource;

    @Test
    void dataSourceTest() {
        log.info(dataSource.toString());
    }

    @Autowired
    ProductService productService;
    @Autowired
    CategoryRep categoryRep;

    @Test
    void productDaoTest() {
        Category c1 = categoryRep.getOne(1);
        List<Product> list = productService.list(c1, 1, 5);
        log.info(list.toString());
        List<Product> search = productService.search("2");
        log.info(search.toString());
    }

    @Test
    void categoryDaoTest() {
        Category category = new Category();
        category.setName("c2");
        category.setCreateDate(LocalDate.now());
        categoryRep.save(category);
    }

    @Autowired
    CacheDemo cacheDemo;

    @Test
    void cacheDemoTest() {
        Person person = new Person();
        person.setName("Yang");
        person.setAge(1);
        person.setHiding("hide");
        cacheDemo.addPerson(person);
    }

    @Test
    void contextLoads() {
    }

}
