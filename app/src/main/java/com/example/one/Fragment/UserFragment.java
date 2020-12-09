package com.example.one.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.one.Activity.SetUserActivity;
import com.example.one.Activity.ShowActivity;
import com.example.one.Model.DataModel;
import com.example.one.Model.DataModelImpl;
import com.example.one.R;

import com.example.one.Model.SetUserInterface;
import com.example.one.UserBean;

public class UserFragment extends Fragment implements View.OnClickListener {
    private TextView userName;
    private TextView userAutograph;
    private Button set;
    private String username;
    private String auto;
    private String count;
    private String password;
    private DataModel dataModel=new DataModelImpl();
    private static final String TAG="UserFragment";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view=inflater.inflate(R.layout.fragment_user,container,false);
        userName=(TextView)view.findViewById(R.id.user_name);
        userAutograph=(TextView)view.findViewById(R.id.autograph);
        set=(Button)view.findViewById(R.id.set_user);
        set.setOnClickListener(this);
        //强转成宿主Activity类型，并获取到数据
        username= ((ShowActivity)getActivity()).getUserName();
        auto=((ShowActivity)getActivity()).getAutoGrapgh();
        count=((ShowActivity)getActivity()).getUserCount();
        password=((ShowActivity)getActivity()).getUserPassword();
       userName.setText(username);
       userAutograph.setText(auto);
        return view;
    }
    @Override
    public void onClick(View view){
        Intent goToSetUserActivity=new Intent(getActivity(), SetUserActivity.class);
        goToSetUserActivity.putExtra(SetUserActivity.EDIT_USER_NAME,username);
        goToSetUserActivity.putExtra(SetUserActivity.EDIT_AUTOGRAPH,auto);
        goToSetUserActivity.putExtra(SetUserActivity.COUNT,count);
        goToSetUserActivity.putExtra(SetUserActivity.PASSWORD,password);
        startActivity(goToSetUserActivity);

    }
    @Override
    public void onResume(){
        super.onResume();
        UserBean userBean=dataModel.getUser(count,password);
        userName.setText(userBean.getUserName());
        userAutograph.setText(userBean.getAutograph());

    }


}
