package com.example.androidbasic03_0521;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.androidbasic03_0521.databinding.ActivityEditUserBinding;

public class EditUserActivity extends BaseActivity {

    ActivityEditUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_edit_user);
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        binding.okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nickName = binding.nickNameEdt.getText().toString();

                Intent myintent = new Intent();
                myintent.putExtra("editNick",nickName);

                setResult(RESULT_OK,myintent);

                finish();
            }
        });

    }

    @Override
    public void setValues() {

    }
}
