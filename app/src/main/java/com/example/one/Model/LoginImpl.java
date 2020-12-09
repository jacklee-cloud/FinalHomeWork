package com.example.one.Model;


import org.litepal.LitePal;

import java.util.List;

import com.example.one.UserBean;

public class LoginImpl implements LoginInterface {
    @Override
    public boolean login(String count, String password){
        List<UserBean> users =LitePal.where("userCount like ? and  userPassWord like ?",count,password).find(UserBean.class);
        if (users.isEmpty())
            //没找到对应的用户数据
            return false;
        else
            //找到了count，password对应的用户
            return true;
    }

    @Override
    public boolean register(String count, String password) {
        List<UserBean> users=LitePal.findAll(UserBean.class);
          if (count.isEmpty()||password.isEmpty())
              return false;
          //对所有数据进行遍历，如果存在账号密码都相同的user，则证明已经注册，返回false
        for (UserBean user:users) {
            if(user.getUserCount().equals(count)&&user.getUserPassWord().equals(password))
                return false;
        }
        //保存用户账号密码
        UserBean userBean=new UserBean();
        userBean.setUserCount(count);
        userBean.setUserPassWord(password);
        userBean.save();
        return true;
    }

    @Override
    public boolean confirmPassword(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }
}
