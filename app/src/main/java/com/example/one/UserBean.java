package com.example.one;

import org.litepal.crud.LitePalSupport;

public class UserBean extends LitePalSupport {
    private String userCount;//账号
    private String userPassWord;//密码
    private String userName="新用户";//用户名
    private String autograph="(编辑个性签名)";//个性签名

    public UserBean() {
    }

    public UserBean(String userCount, String userPassWord, String userName, String autograph) {
        this.userCount = userCount;
        this.userPassWord = userPassWord;
        this.userName = userName;
        this.autograph = autograph;
    }

    public String getUserCount() {
        return userCount;
    }

    public void setUserCount(String userCount) {
        this.userCount = userCount;
    }

    public String getUserPassWord() {
        return userPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }
}
