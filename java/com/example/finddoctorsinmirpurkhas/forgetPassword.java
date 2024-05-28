package com.example.finddoctorsinmirpurkhas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class forgetPassword extends AppCompatActivity {
    private Button btnsubmitF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        getWindow().setStatusBarColor(ContextCompat.getColor(forgetPassword.this, R.color.teal));
        btnsubmitF = findViewById(R.id.buttonSubmitForgetPassword);

        btnsubmitF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i1);
            }
        });

    }
}