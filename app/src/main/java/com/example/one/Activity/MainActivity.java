package com.example.one.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.one.R;
import com.example.one.UserBean;

import com.example.one.Model.DataModel;
import com.example.one.Model.DataModelImpl;
import com.example.one.Model.LoginImpl;
import com.example.one.Model.LoginInterface;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edit_count;
    private EditText edit_password;
    private Button login;
    private Button register;
    private LoginInterface loginInterface=new LoginImpl();
    private DataModel dataModel=new DataModelImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_count=(EditText)findViewById(R.id.edit_count);
        edit_password=(EditText)findViewById(R.id.edit_password);
        login=(Button)findViewById(R.id.button_login);
        register=(Button)findViewById(R.id.button_register);
        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.button_register:
                Intent goToRegisterActivity=new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(goToRegisterActivity);
                break;
            case R.id.button_login:
                String count=edit_count.getText().toString();
                String password=edit_password.getText().toString();
                if (loginInterface.login(count,password)){
                    Toast.makeText(this,"登陆成功！",Toast.LENGTH_SHORT).show();
                    UserBean user=dataModel.getUser(count,password);
                    Intent goToShowActibity=new Intent(MainActivity.this, ShowActivity.class);
                    goToShowActibity.putExtra(ShowActivity.USER_NAME,user.getUserName());
                    goToShowActibity.putExtra(ShowActivity.AUTO_GRAPGH,user.getAutograph());
                    goToShowActibity.putExtra(ShowActivity.USER_COUNT,count);
                    goToShowActibity.putExtra(ShowActivity.PASSWORD,password);
                    startActivity(goToShowActibity);
                    break;
                }else {
                    Toast.makeText(this,"登陆失败！请检查用户名和密码是否正确！",Toast.LENGTH_SHORT).show();
                    break;
                }
                default:break;
        }
    }
}
