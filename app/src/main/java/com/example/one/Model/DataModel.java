package com.example.one.Model;

import com.example.one.UserBean;

public interface DataModel {
    //根据账号与密码获取当前用户
    UserBean getUser(String count,String password);
    //保存当前用户信息
    void saveUser(UserBean userBean,String name,String auto);
}
