package github.yangllli.springboot_demos;

import github.yangllli.springboot_demos.spring.aop.AopDemo;
import github.yangllli.springboot_demos.spring.configuration.Category;
import github.yangllli.springboot_demos.spring.configuration.CategoryDao;
import github.yangllli.springboot_demos.spring.configuration.SpringDemo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.*;
import org.springframework.web.context.WebApplicationContext;

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
	void ControllerDemoTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/demo/1"))
				.andExpect(MockMvcResultMatchers.view().name("demo"));
	}
	@Test
	void contextLoads() {
	}

}
