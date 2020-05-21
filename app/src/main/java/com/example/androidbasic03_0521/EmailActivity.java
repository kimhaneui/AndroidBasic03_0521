package com.example.androidbasic03_0521;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.androidbasic03_0521.databinding.ActivityEmailBinding;

public class EmailActivity extends BaseActivity {

    ActivityEmailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_email);
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        binding.emailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailTxt =  binding.emailTxt.getText().toString();

                Intent myintent = new Intent();
                myintent.putExtra("email",emailTxt);

                setResult(RESULT_OK,myintent);
                finish();
            }
        });


    }

    @Override
    public void setValues() {

    }
}
