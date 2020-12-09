package com.example.one;

import java.util.List;

public class OneBeanList {


    /**
     * code : 200
     * msg : success
     * newslist : [{"oneid":3025,"word":"我看到有人说，人生不会因为得到了什么而感到高兴，却会因为失去而真切地痛苦。说的真好呢，我也是这么想。只是那些拥有和失去，现如今已经离我而去，我只是在徒劳地追赶着大雪，期待洁白的平静降临。","wordfrom":"","imgurl":"http://image.wufazhuce.com/Fg1h1sdRBng-NK-BYFSI_yeLmdON","imgauthor":"","date":"2020-12-06"}]
     */

    private int code;
    private String msg;
    private List<OneBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<OneBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<OneBean> newslist) {
        this.newslist = newslist;
    }

}
