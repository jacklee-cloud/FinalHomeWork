package com.example.one.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.example.one.Adapter.PoemAdapter;
import com.example.one.Model.NetWorkTool;
import com.example.one.Model.ParseDataTool;
import com.example.one.OneBean;
import com.example.one.OneBeanList;
import com.example.one.PoemBean;
import com.example.one.PoemList;
import com.example.one.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ContentFragment extends Fragment {
    private ImageView showImage;
    private TextView showContent;
    private List<PoemBean> poemBeanList=new ArrayList<>();
    private SwipeRefreshLayout refreshLayout;
    private RecyclerView myRecyclerView;
    private PoemAdapter adapter;
    private String imageUrl;
    private String content;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view=inflater.inflate(R.layout.fragment_content,container,false);
        showImage=(ImageView)view.findViewById(R.id.show_image);
        showContent=(TextView)view.findViewById(R.id.show_content);
        myRecyclerView=(RecyclerView) view.findViewById(R.id.recycler_view);
        refreshLayout=(SwipeRefreshLayout)view.findViewById(R.id.swipe_refresh);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshPoem();
            }
        });
        NetWorkTool.sendUrlRequest("http://api.tianapi.com/txapi/one/index?key=91d3f2a86fda060b05bf1fd38d5e513c", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseData=response.body().string();
              OneBeanList oneBeanList= ParseDataTool.parseData(responseData);
                List<OneBean> oneBean=oneBeanList.getNewslist();
                for (OneBean one : oneBean) {
                     imageUrl=one.getImgurl();
                     content=one.getWord();
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(getContext()).load(imageUrl).into(showImage);
                        showContent.setText(content);
                    }
                });
            }
        });
        initView();
        try {
            //保证主线程开始执行时，poemBeanList中已经拿到了数据
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        GridLayoutManager layoutManager=new GridLayoutManager(getActivity(),1);
        myRecyclerView.setLayoutManager(layoutManager);
        adapter=new PoemAdapter(poemBeanList);
        myRecyclerView.setAdapter(adapter);
        return view;
    }

    private void initView(){
        poemBeanList.clear();
         for(int i=0;i<12;i++){
             NetWorkTool.sendUrlRequest("http://api.tianapi.com/txapi/poetry/index?key=91d3f2a86fda060b05bf1fd38d5e513c", new Callback() {
                 @Override
                 public void onFailure(Call call, IOException e) {

                 }

                 @Override
                 public void onResponse(Call call, Response response) throws IOException {
                          String responseData=response.body().string();
                         PoemList poemList= ParseDataTool.parseDataPoem(responseData);
                         List<PoemBean> poemBeans=poemList.getNewslist();
                         poemBeanList.add(poemBeans.get(0));
                 }
             });
         }


    }


    private void refreshPoem() {
        initView();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        adapter.notifyDataSetChanged();
        refreshLayout.setRefreshing(false);

    }


}
