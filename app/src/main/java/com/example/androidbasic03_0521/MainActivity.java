package com.example.androidbasic03_0521;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import com.example.androidbasic03_0521.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {

    ActivityMainBinding binding;

    final int REQ_FOR_PHONE_NUM = 1002;
    final int REQ_FOR_NICKNAME = 1001;
    final int REQ_FOR_EMAIL = 1003;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        binding.phoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myintent = new Intent(mContext,UserPhoneActivity.class);
                startActivityForResult(myintent,REQ_FOR_PHONE_NUM);

            }
        });

        binding.nickNameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(mContext,EditUserActivity.class);

//                결과를 달라
                startActivityForResult(myintent,REQ_FOR_NICKNAME);
            }
        });

        binding.emailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(mContext,EmailActivity.class);
                startActivity(myintent);
            }
        });

    }

    @Override
    public void setValues() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQ_FOR_NICKNAME){
            if(resultCode == RESULT_OK){

                String nick = data.getStringExtra("editNick");

                binding.userNickNameTxt.setText(nick);

            }
        }
        else if (requestCode == REQ_FOR_PHONE_NUM){
            if(resultCode == RESULT_OK){
                if(data != null){
                       String phoneNum = data.getStringExtra("phone");
                       binding.userPhoneTxt.setText(phoneNum);
                }
            }
            else{
                Toast.makeText(mContext, "전화번호 변경을 취소했습니다.", Toast.LENGTH_SHORT).show();
            }
        }
        else if(requestCode == REQ_FOR_EMAIL){
            if(resultCode == RESULT_OK){

                String mail = data.getStringExtra("email");

                binding.emailTxt.setText(mail);
            }
        }
    }
}
