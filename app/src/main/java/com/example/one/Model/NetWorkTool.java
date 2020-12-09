package com.example.one.Model;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class NetWorkTool {
    //用来发送网络请求
    public static void sendUrlRequest(String urlRequest,okhttp3.Callback callback){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(urlRequest).build();
        client.newCall(request).enqueue(callback);
    }

}
