package github.yangllli.springboot_demos;

import github.yangllli.springboot_demos.spring.aop.AopDemo;
import github.yangllli.springboot_demos.spring.configuration.Category;
import github.yangllli.springboot_demos.spring.configuration.CategoryDao;
import github.yangllli.springboot_demos.spring.configuration.SpringDemo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.function.Consumer;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class SpringbootDemosApplicationTests {
	@Autowired
	private SpringDemo springDemo;
	@Autowired
	private AopDemo demo;

	@Test
	void springDemoTest() {
		CategoryDao categoryDao = springDemo.getCategoryController().getCategoryDao();
		Category c1 = categoryDao.getCategory(1, "c1");
		log.info(c1.toString());

	}

	@Test
	void springDemoAopTest() {
		demo.m1();
		demo.m2(4);
		Consumer<Integer> consumer = (Consumer<Integer>) demo;
		consumer.accept(5);

	}
	@Test
	void contextLoads() {
	}

}
