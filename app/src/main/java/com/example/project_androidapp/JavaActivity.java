package com.example.project_androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class JavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);

        TextView tv_result = findViewById(R.id.tv_result);
        tv_result.setText(getIntent().getExtras().getString("이름") + "님 환영합니다");
    }
}