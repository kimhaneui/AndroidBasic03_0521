package com.example.androidbasic03_0521;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.androidbasic03_0521.databinding.ActivityUserPhoneBinding;

public class UserPhoneActivity extends BaseActivity {

    ActivityUserPhoneBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_user_phone);
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        binding.okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputPhoneNum = binding.phoneNumEdt.getText().toString();
                Intent resultintent = new Intent();

                resultintent.putExtra("phone",inputPhoneNum);

                setResult(RESULT_OK,resultintent);
                finish();
            }
        });
    }


    @Override
    public void setValues() {

    }
}
