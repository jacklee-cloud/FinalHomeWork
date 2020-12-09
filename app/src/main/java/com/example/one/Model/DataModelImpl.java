package com.example.one.Model;

import com.example.one.UserBean;

import org.litepal.LitePal;

import java.util.List;

public class DataModelImpl implements DataModel {
    @Override
    public UserBean getUser(String count, String password) {
        UserBean userBean=null;
        List<UserBean> userBeans= LitePal.where("userCount like ? and  userPassWord like ?",count,password).find(UserBean.class);
        for (UserBean user:userBeans) {
            if (user.getUserCount().equals(count)&&user.getUserPassWord().equals(password)){
                userBean=user;
               break;
            }
        }
        if (userBean!=null)
            return userBean;
        else
            return null;
    }

    @Override
    public void saveUser(UserBean userBean, String name, String auto) {
          userBean.setUserName(name);
          userBean.setAutograph(auto);
          userBean.save();
    }
}
