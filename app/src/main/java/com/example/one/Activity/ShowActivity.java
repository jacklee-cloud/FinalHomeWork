package com.example.one.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.example.one.Fragment.ContentFragment;
import com.example.one.Adapter.FragmentAdapter;
import com.example.one.Fragment.UserFragment;
import com.example.one.R;

import java.util.ArrayList;
import java.util.List;

public class ShowActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager myViewPager;
    private List<Fragment> fragmentList;
    private FragmentAdapter adapter;
    private ContentFragment contentFragment;
    private UserFragment userFragment;
    private TextView textViewCount;
    private TextView textViewUser;
    private String userName;
    private String userAutoGragph;
    private String userCount;
    private String userPassword;
    private Intent intent;
    public static final String USER_NAME="用户名";
    public static final String AUTO_GRAPGH="个性签名";
    public static final String USER_COUNT="账号";
    public static final String PASSWORD="密码";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        myViewPager=(ViewPager)findViewById(R.id.myViewPager);
        textViewCount=(TextView)findViewById(R.id.textView_content);
        textViewUser=(TextView)findViewById(R.id.textView_user);
        contentFragment=new ContentFragment();
        userFragment=new UserFragment();
        textViewCount.setOnClickListener(this);
        textViewUser.setOnClickListener(this);
        fragmentList=new ArrayList<>();
        fragmentList.add(contentFragment);
        fragmentList.add(userFragment);
        adapter=new FragmentAdapter(getSupportFragmentManager(),fragmentList);
        myViewPager.setAdapter(adapter);
        myViewPager.setCurrentItem(0);
        textViewCount.setTextColor(Color.WHITE);
        textViewUser.setTextColor(Color.BLACK);
        myViewPager.setOffscreenPageLimit(2);
        intent=getIntent();
        userName=intent.getStringExtra(USER_NAME);
        userAutoGragph=intent.getStringExtra(AUTO_GRAPGH);
        userCount=intent.getStringExtra(USER_COUNT);
        userPassword=intent.getStringExtra(PASSWORD);
        myViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        textViewCount.setTextColor(Color.WHITE);
                        textViewUser.setTextColor(Color.BLACK);
                        break;
                    case 1:
                        textViewCount.setTextColor(Color.BLACK);
                        textViewUser.setTextColor(Color.WHITE);
                        break;
                        default:break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.textView_content:
                myViewPager.setCurrentItem(0,false);
                break;
            case R.id.textView_user:
                myViewPager.setCurrentItem(1,false);
                break;


        }

    }
    @Override
    public boolean onKeyDown(int keydCode,KeyEvent keyEvent){
        if (keydCode==KeyEvent.KEYCODE_BACK){
            AlertDialog.Builder dialog=new AlertDialog.Builder(this);
            dialog.setTitle("退出登录");
            dialog.setMessage("是否要退出登录?");
            dialog.setPositiveButton("是", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            dialog.setNegativeButton("否", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            dialog.show();

        }
        return false;
    }


    //以下方法是为fragment提供，将activity中的数据传给fragment
    public String getUserName(){
        return userName;
    }
    public String getAutoGrapgh(){
        return userAutoGragph;
    }

    public String getUserCount() {
        return userCount;
    }

    public String getUserPassword() {
        return userPassword;
    }
}
