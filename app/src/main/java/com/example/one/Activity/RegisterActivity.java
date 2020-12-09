package com.example.one.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.one.R;

import com.example.one.Model.LoginImpl;
import com.example.one.Model.LoginInterface;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edit_count_register;
    private EditText edit_password_register;
    private EditText confirm_password;
    private Button button_register;
    private LoginInterface login=new LoginImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        edit_count_register=(EditText)findViewById(R.id.edit_count_register);
        edit_password_register=(EditText)findViewById(R.id.edit_password_register);
        confirm_password=(EditText)findViewById(R.id.confirm_password);
        button_register=(Button)findViewById(R.id.button_register_in_register);
        button_register.setOnClickListener(this);

    }
    @Override
    public void onClick(View view){
        if (login.register(edit_count_register.getText().toString(),edit_password_register.getText().toString())
        &&login.confirmPassword(edit_password_register.getText().toString(),confirm_password.getText().toString())
        ){
            Toast.makeText(RegisterActivity.this,"注册成功!",Toast.LENGTH_SHORT).show();
                      finish();
        }
        else
            Toast.makeText(RegisterActivity.this,"注册失败！两次密码不同或该账号已被注册",Toast.LENGTH_SHORT).show();

    }
}
