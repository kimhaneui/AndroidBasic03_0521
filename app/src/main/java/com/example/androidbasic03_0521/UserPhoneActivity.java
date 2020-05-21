package com.example.androidbasic03_0521;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.androidbasic03_0521.databinding.ActivityUserPhone2Binding;

public class UserPhoneActivity extends BaseActivity {

    ActivityUserPhone2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_user_phone2);
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        binding.okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputPhoneNum = binding.phoneNumEdt.getText().toString();
            }
        });
    }


    @Override
    public void setValues() {

    }
}
