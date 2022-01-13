package com.example.credit_record;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText et2 = findViewById(R.id.login_textapassword);
        et2.setTransformationMethod(PasswordTransformationMethod.getInstance());

        CheckBox checkBox = (CheckBox) findViewById(R.id.login_show);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if(isChecked){
                    //如果選中，顯示密碼
                    et2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    //否則隱藏密碼
                    et2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

            }
        });
    }

    public void onClickLoginBtn(View view) {
        EditText et1 = findViewById(R.id.login_textaccount);
        EditText et2 = findViewById(R.id.login_textapassword);
        switch (view.getId()) {
            case R.id.login_login:
                Toast.makeText(this,"登入中...",Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.login_clear:
                et1.setText("");
                et2.setText(null);
                Toast.makeText(this,"已清除",Toast.LENGTH_LONG).show();
                break;
            case R.id.login_revise:
                Toast.makeText(this,"請稍後...",Toast.LENGTH_LONG).show();
                break;
            case R.id.login_forget:
                Toast.makeText(this,"請稍後...",Toast.LENGTH_LONG).show();
                break;
            case R.id.login_register:
                Toast.makeText(this,"請稍後...",Toast.LENGTH_LONG).show();
                break;
        }
    }
}