package com.example.one.Model;

public interface LoginInterface {
    //用来判断是否登录成功
    boolean login(String count,String password);
    //用来判断是否注册成功
    boolean register(String count,String password);
    //用来确认注册时两次密码是否相同
    boolean confirmPassword(String password,String confirmPassword);
}
