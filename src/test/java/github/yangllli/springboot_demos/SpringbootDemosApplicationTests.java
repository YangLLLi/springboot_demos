package github.yangllli.springboot_demos;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import github.yangllli.springboot_demos.mybatis.xmlMapper.CityMapper;
import github.yangllli.springboot_demos.mybatis.xmlMapper.ProvinceMapper;
import github.yangllli.springboot_demos.mybatis.xmlPojo.City;
import github.yangllli.springboot_demos.mybatis.xmlPojo.CityExample;
import github.yangllli.springboot_demos.mybatis.xmlPojo.Province;
import github.yangllli.springboot_demos.mybatis.xmlPojo.ProvinceExample;
import github.yangllli.springboot_demos.spring.aop.AopDemo;
import github.yangllli.springboot_demos.spring.configuration.SpringDemo;
import github.yangllli.springboot_demos.springDataJpa.dao.CategoryRep;
import github.yangllli.springboot_demos.springDataJpa.dao.ProductRep;
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
	ProvinceMapper provinceMapper;

	@Test
	void provinceMapperTest() {
		Province province = new Province();
		province.setName("sichuan");
		provinceMapper.insert(province);
		log.info(province.toString());
		ProvinceExample provinceExample = new ProvinceExample();
		List<Province> list = provinceMapper.selectByExample(provinceExample);
		log.info(list.toString());
	}

	@Autowired
	CityMapper cityMapper;
	@Test
	void cityMapperTest() {
		Province province = provinceMapper.selectByPrimaryKey(1);
		City city = new City();
		city.setName("nanchong");
		cityMapper.insert(city);

		Integer pid = province.getId();
		CityExample cityExample = new CityExample();
		cityExample.createCriteria().andPidEqualTo(pid);
//		必须在mapper操作前
		Page page =PageHelper.startPage(1,2);
		List<City> cities = cityMapper.selectByExample(cityExample);
//		必须在mapper操作后
		log.info(String.valueOf(page.getTotal()));
		log.info(page.getResult().toString());
	}

	@Test
	void contextLoads() {
	}

}
