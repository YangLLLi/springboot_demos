package github.yangllli.springboot_demos;

import github.yangllli.springboot_demos.spring.aop.AopDemo;
import github.yangllli.springboot_demos.spring.configuration.Category;
import github.yangllli.springboot_demos.spring.configuration.Product;
import github.yangllli.springboot_demos.spring.configuration.SpringDemo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
		Category category = springDemo.getCategory();
		category.setName("c1");
		Product product = springDemo.getProduct();
		log.info(product.getCategory().getName());

	}

	@Test
	void springDemoAopTest() {
		demo.m1();
	}
	@Test
	void contextLoads() {
	}

}
