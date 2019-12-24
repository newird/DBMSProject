package com.ce.springboot.service;

import org.springframework.security.crypto.password.PasswordEncoder;

public class MyPasswordEncoder implements PasswordEncoder {

//    @Override
//    public String encode(CharSequence rawPassword) {
//        return MD5Util.encode((String) rawPassword);
//    }
//
//    @Override
//    public boolean matches(CharSequence rawPassword, String encodedPassword) {
//        //user Details Service验证
//        return encodedPassword.equals(MD5Util.encode((String) rawPassword));
//    }

    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.equals(rawPassword);
    }
}
