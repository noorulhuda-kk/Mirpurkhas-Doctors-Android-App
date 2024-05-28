package com.example.finddoctorsinmirpurkhas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Help extends AppCompatActivity {
    Button eng, urdu, sindhi;
    TextView aboutTitle, aboutBody, faq0, faq1a, faq1b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        getWindow().setStatusBarColor(ContextCompat.getColor(Help.this, R.color.teal));
        eng = findViewById(R.id.btnLangEnglish);
        urdu = findViewById(R.id.btnLangUrdu);
        sindhi = findViewById(R.id.btnLangSindhi);
        aboutBody = findViewById(R.id.textAboutApp);
        aboutTitle = findViewById(R.id.textTitleAboutApp);
        faq0 = findViewById(R.id.textFAQtitle);
        faq1a = findViewById(R.id.textQ1);
        faq1b = findViewById(R.id.textA1);

        eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aboutBody.setText(" Text-based tutorial\n [link for video based tutorial]");
                aboutTitle.setText("How to Use the App");
                faq0.setText("Frequently Asked Questions");
                faq1a.setText("1. First Question");
                faq1b.setText("First Answer");
            }
        });

       urdu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aboutBody.setText(" تحریری ٹیوٹوریل\n [ویڈیو پر مبنی ٹیوٹوریل کا لنک]");
                aboutTitle.setText("ایپ کا استعمال کیسے کریں");
                faq0.setText("اکثر پوچھے گئے سوالات");
                faq1a.setText("1. پہلا سوال");
                faq1b.setText("پہلا جواب");
            }
        });

        sindhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aboutBody.setText(" لکيل سبق\n [ويڊيو تي ٻڌل سبق جو لنڪ]");
                aboutTitle.setText("ايپ ڪيئن استعمال ڪجي");
                faq0.setText("وچان وچان سوال ڪرڻ");
                faq1a.setText("1. پهريون سوال");
                faq1b.setText("پهريون جواب");
            }
        });

    }
}