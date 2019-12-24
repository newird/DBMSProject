//package com.ce.springboot.config;
//
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.LinkedHashMap;
//
//@Configuration
//public class ShiroConfig {
//
//    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager defaultWebSecurityManager ){
//        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
//        bean.setSecurityManager(defaultWebSecurityManager);
//        LinkedHashMap<String, String> filterMap = new LinkedHashMap<>();
//        filterMap.put("/good/add","authc");
//        filterMap.put("/client/add","authc");
//        filterMap.put("/order/add","anno");
//        bean.setFilterChainDefinitionMap(filterMap);
//        bean.setLoginUrl("/mylogin");
//        return bean;
//    }
//    @Bean(name="securityManager")
//    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//
//        securityManager.setRealm(userRealm);
//        return securityManager;
//    }
//    @Bean(name="userRealm")
//    public UserRealm userRealm(){
//        return new UserRealm();
//    }
//}
