package com.example.finddoctorsinmirpurkhas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class DoctorProfile extends AppCompatActivity {

    ImageView imageView;
    TextView textView1, textView2, textView3;
    ImageButton btnMap;
    Button btnBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profile);
        getWindow().setStatusBarColor(ContextCompat.getColor(DoctorProfile.this, R.color.teal));

        imageView = findViewById(R.id.photo);
        textView1 = findViewById(R.id.Name);
        textView2 = findViewById(R.id.Specialization);
        textView3 = findViewById(R.id.City);
        btnMap = findViewById(R.id.mapButton);
        btnBooking = findViewById(R.id.btnRequestForAppointment);

        Intent intent = getIntent();
        int image = intent.getExtras().getInt("Profile");
        String name = intent.getExtras().getString("Name");
        String special = intent.getExtras().getString("Specialization");
        String city = intent.getExtras().getString("City");

        imageView.setImageResource(image);
        textView1.setText(name);
        textView2.setText(special);
        textView3.setText(city);

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://maps.app.goo.gl/qcfCP5gTZQZtVcd76"));
                startActivity(intent);
            }
        });

        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogueBox dialogueBox = new DialogueBox("Confirmation","Are You Sure You Want To Book An Appointment?");
                dialogueBox.show(getSupportFragmentManager(), "example Dialogue");

            }
        });

    }

    /*public void openDialogueBox(String title, String Message) {
        DialogueBox dialogueBox = new DialogueBox("Confirmation","Are You Sure You Want To Book An Appointment?");
        dialogueBox.show(getSupportFragmentManager(), "example Dialogue");
    }*/
}