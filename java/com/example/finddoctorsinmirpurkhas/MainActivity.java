package com.example.finddoctorsinmirpurkhas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private Button btnlogin, btnsignup, btnforgetpassword;
    FirebaseAuth myAuth;
    EditText email, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.teal));
        email = findViewById(R.id.editTextemail);
        pass = findViewById(R.id.editTextPassword);
        btnlogin = findViewById(R.id.buttonLogin);
        btnforgetpassword = findViewById(R.id.buttonForgetPassword);
        btnsignup = findViewById(R.id.signupPassword);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Demail, Dpassword;
                Dpassword = String.valueOf(pass.getText());
                Demail = String.valueOf(email.getText());
                myAuth = FirebaseAuth.getInstance();


                if (TextUtils.isEmpty(Demail)) {

                    Toast.makeText(MainActivity.this, "Please enter Email", Toast.LENGTH_SHORT).show();

                }

                if (TextUtils.isEmpty(Dpassword)) {

                    Toast.makeText(MainActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();

                }


                myAuth.signInWithEmailAndPassword(Demail, Dpassword)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Intent i1 = new Intent(getApplicationContext(), homeScreen.class);
                                    startActivity(i1);

                                    Toast.makeText(MainActivity.this, "Sucess.",
                                            Toast.LENGTH_SHORT).show();

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(MainActivity.this, "failed.",
                                            Toast.LENGTH_SHORT).show();
                                }


            }
        });
            }
        });

        btnforgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(getApplicationContext(), forgetPassword.class);
                startActivity(i1);
            }
        });

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(getApplicationContext(), signupPage.class);
                startActivity(i1);
            }
        });

    }
}