package github.yangllli.springboot_demos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy   //开启AOP
public class SpringbootDemosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemosApplication.class, args);
	}

}
