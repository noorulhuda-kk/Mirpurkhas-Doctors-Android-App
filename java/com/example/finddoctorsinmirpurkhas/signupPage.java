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

public class signupPage extends AppCompatActivity {
    private Button btnsubmitS;
    private EditText eN, eE, eP, eC;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);
        getWindow().setStatusBarColor(ContextCompat.getColor(signupPage.this, R.color.teal));
        eN = findViewById(R.id.editTextUsername);
        eE = findViewById(R.id.editTextemailSignUp);
        eP = findViewById(R.id.editTextPasswordSignUp);
        eC = findViewById(R.id.editTextContactNumber);
        btnsubmitS = findViewById(R.id.buttonSignUp);

        btnsubmitS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String  Demail,Dpassword,Dname,Dcontact;
                Dname = String.valueOf(eN.getText());
                Dpassword = String.valueOf(eP.getText());
                Demail = String.valueOf(eE.getText());
                Dcontact = String.valueOf(eC.getText());
                mAuth = FirebaseAuth.getInstance();

                if(TextUtils.isEmpty(Dname))
                {

                    Toast.makeText(signupPage.this,"Please enter Name",Toast.LENGTH_SHORT).show();
                }


                if(TextUtils.isEmpty(Demail))
                {

                    Toast.makeText(signupPage.this,"Please enter Email",Toast.LENGTH_SHORT).show();

                }

                if(TextUtils.isEmpty(Dpassword))
                {

                    Toast.makeText(signupPage.this,"Please enter password",Toast.LENGTH_SHORT).show();

                }

                if(TextUtils.isEmpty(Dcontact))
                {

                    Toast.makeText(signupPage.this,"Please enter contact number",Toast.LENGTH_SHORT).show();

                }

                mAuth.createUserWithEmailAndPassword(Demail, Dpassword)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(signupPage.this, "Authentication pass.",
                                            Toast.LENGTH_SHORT).show();
                                    Intent i1 = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(i1);

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(signupPage.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


            }
        });
    }
}