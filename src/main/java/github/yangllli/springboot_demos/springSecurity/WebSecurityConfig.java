package github.yangllli.springboot_demos.springSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

/**
 * 认证、授权
 * springSecurity配置类
 * 通过继承 WebSecurityConfigurerAdapter，覆盖各configure方法可完成对web（controller）的安全的配置
 * 本质是实现filter或interceptor
 *
 * 核心概念 SecurityContext、SecurityContextHolder、
 * UserDetails、Authentication
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private DataSource dataSource;

    /**
     * 配置域
     * 内存、文件或数据库等
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService)
//                .passwordEncoder(NoOpPasswordEncoder.getInstance());

        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select name,password,true from user where name=?")
//                数据库中的role.name必须为ROLE_xxx
                .authoritiesByUsernameQuery("select user.name, role.name from user join role on user.rid=role.id where user.name=?")
                .passwordEncoder(NoOpPasswordEncoder.getInstance());


//                auth.inMemoryAuthentication()
//                .passwordEncoder(NoOpPasswordEncoder.getInstance())
//                .withUser("admin").password( "123")
//                .roles("admin")
//                .and()
//                .withUser("user").password("123")
//                .roles("user");
    }

    /**
     * 本质实现interceptor来完成
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/home").permitAll()
//                授权
                .antMatchers("/hello").hasRole("admin")
//                认证。   一般anyRequest放到最后
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .successForwardUrl("/home")
                .failureForwardUrl("/failure")
//                .loginPage("/login").permitAll()
                .and()
                .logout()
                .permitAll();

    }
}


