package com.ce.springboot.config;

import com.ce.springboot.pojo.Adminuser;
import com.ce.springboot.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.Resource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private MyUserService<Adminuser> userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**", "/js/**","/scss/**",
                         "/fonts/**", "/images/**").permitAll()
                .antMatchers("/good/**","/client/**").hasRole("base")
                .antMatchers("/order/**").hasRole("service")
                .antMatchers("/").permitAll();
        //没有权限，默认登陆
        http.formLogin();
//        注销
        http.logout().logoutSuccessUrl("/");
        http.rememberMe();

        //跨站脚本工具
        http.csrf().disable();


        //sec:authorize="hasrole("vip1);
        //菜单根据角色动态显示，写在前端

    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userService).passwordEncoder(new MyPasswordEncoder());
        auth
                .inMemoryAuthentication()
                .withUser("admin").password("123456").roles("base");
    }
    //认证
    //要加密 不能明文

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("admin").password("123456").roles("base");
//    }
}
