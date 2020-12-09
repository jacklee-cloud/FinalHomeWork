package com.example.one.Model;

import com.example.one.OneBeanList;
import com.example.one.PoemList;
import com.google.gson.Gson;

import java.util.List;

public class ParseDataTool{
    //用来解析One数据
    public static OneBeanList parseData(String data) {
        Gson gson=new Gson();
        OneBeanList oneBeanList= gson.fromJson(data,OneBeanList.class);
        if(oneBeanList.getCode()==200)
            return oneBeanList;
        else
            return null;
    }
    //用来解析古诗的数据
    public static PoemList parseDataPoem(String data){
        Gson gson=new Gson();
        PoemList poemList=gson.fromJson(data,PoemList.class);
        if(poemList.getCode()==200)
            return poemList;
        else
            return null;
    }
}
