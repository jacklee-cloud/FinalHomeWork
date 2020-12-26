package com.example.one.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.one.Model.DataModel;
import com.example.one.Model.DataModelImpl;
import com.example.one.R;
import com.example.one.UserBean;

public class SetUserActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EDIT_USER_NAME="待编辑的用户名";
    public static final String EDIT_AUTOGRAPH="待编辑的签名";
    public static final String COUNT="用户账号";
    public static final String PASSWORD="用户密码";
    private String count;
    private String password;
    private EditText editUserName;
    private EditText ediAutoGraph;
    private String userName;
    private String autoGraph;
    private Button saveUser;
    private Button cancel;
    private DataModel dataModel=new DataModelImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_user);
        editUserName=(EditText)findViewById(R.id.edit_username);
        ediAutoGraph=(EditText)findViewById(R.id.edit_autograph);
        saveUser=(Button)findViewById(R.id.save_edit);
        cancel=(Button)findViewById(R.id.cancel_edit);
        Intent intent=getIntent();
        userName=intent.getStringExtra(EDIT_USER_NAME);
        autoGraph=intent.getStringExtra(EDIT_AUTOGRAPH);
        count=intent.getStringExtra(COUNT);
        password=intent.getStringExtra(PASSWORD);
        editUserName.setText(userName);
        ediAutoGraph.setText(autoGraph);
        saveUser.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.save_edit:
                UserBean nowUser= dataModel.getUser(count,password);
                dataModel.saveUser(nowUser,editUserName.getText().toString(),ediAutoGraph.getText().toString());
                Toast.makeText(this,"保存成功！",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cancel_edit:
                AlertDialog.Builder dialog=new AlertDialog.Builder(this);
                dialog.setTitle("取消保存");
                dialog.setMessage("你确定要取消保存吗？");
                dialog.setCancelable(false);
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
                break;
                default:break;
        }
    }
}
