package com.ce.springboot.service;

import com.ce.springboot.dao.AdminuserDao;
import com.ce.springboot.pojo.Adminuser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserService<T extends Adminuser> implements UserDetailsService {
    @Autowired
    private AdminuserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails result;
        try {
            Adminuser user = userDao.selectByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("用户名不存在");
            }
            //用户权限
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            if (StringUtils.isNotBlank(user.getPerm())) {
                String[] roles = user.getPerm().split(",");
                for (String role : roles) {
                    if (StringUtils.isNotBlank(role)) {
                        authorities.add(new SimpleGrantedAuthority(role.trim()));
                    }
                }
            }
            result = new org.springframework.security.core.userdetails.User(user.getAdminuser(), user.getPassword(), authorities);
        } catch (Exception e) {
            e.printStackTrace();
            result = null;
        }
        return result;
    }
}
 
