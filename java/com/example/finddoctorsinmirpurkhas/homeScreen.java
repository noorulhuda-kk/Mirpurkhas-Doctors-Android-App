package com.example.finddoctorsinmirpurkhas;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class homeScreen extends AppCompatActivity {
    ArrayList<Contect_model> arrcontect = new ArrayList<>();
    RecyclerContectAdapter adapter;
    SearchView searchView;
    String[] dropdown1values = {"Mirpurkhas","Digri","Jhuddo"};
    AutoCompleteTextView autoCompleteTextView1;
    ArrayAdapter<String> adapterItems;
    private ImageButton btnHelp, btnHistory, btnSetting;

    //for data retrieval in recycleview
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        getWindow().setStatusBarColor(ContextCompat.getColor(homeScreen.this, R.color.teal));
        btnHelp = findViewById(R.id.imageButtonHelp);
        btnHistory = findViewById(R.id.imageButtonHistory);
        btnSetting = findViewById(R.id.imageButtonSetting);
        db = FirebaseFirestore.getInstance();

        //for dropdown1
        autoCompleteTextView1 = findViewById(R.id.dropdown1);
        adapterItems = new ArrayAdapter<String>(this, R.layout.list_item);
        autoCompleteTextView1.setAdapter(adapterItems);
        autoCompleteTextView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String dropdown1values = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(homeScreen.this, "Item: "+ dropdown1values, Toast.LENGTH_SHORT).show();
            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(getApplicationContext(), Help.class);
                startActivity(i1);
            }
        });

        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(getApplicationContext(), History.class);
                startActivity(i1);
            }
        });

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(getApplicationContext(), Settings.class);
                startActivity(i1);
            }
        });


        RecyclerView recyclerView = findViewById(R.id.recy1);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        /*searchView = findViewById(R.id.searchview);
        //searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //filterList(newText);
                return true;
            }
        });*/

        //DocumentReference docRef;
        for (int i=1; i<=10; i++) {
            db.collection("DoctorsList").document(""+i)
            .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document.exists()) {



                            arrcontect.add(new Contect_model(R.drawable.doctor, document.getString("name"), document.getString("specialization"), document.getString("location")));



                        } else {
                            Log.d(TAG, "No such document");
                        }
                    } else {
                        Log.d(TAG, "get failed with ", task.getException());
                    }
                }
            });

        }




       arrcontect.add(new Contect_model(R.drawable.doctorf, "Dr. Bushra", "Mirpurkhas", "Dermatologists"));
        arrcontect.add(new Contect_model(R.drawable.doctor, "Dr. Hamza Ali", "Mirpurkhas", "General Physicians"));
        arrcontect.add(new Contect_model(R.drawable.doctorf, "Dr. Rabail", "Digri", "Ophthalmologists"));
        arrcontect.add(new Contect_model(R.drawable.doctor, "Dr. Muhammad", "Mirpurkhas", "Cardiologists"));
        arrcontect.add(new Contect_model(R.drawable.doctorf, "Dr. Farzana", "Hyderabad", "General Physicians"));
        arrcontect.add(new Contect_model(R.drawable.doctorf, "Dr. Rizwana", "Mirpurkhas", "Nephrologists"));
        arrcontect.add(new Contect_model(R.drawable.doctor, "Dr. Aftab", "Jhuddo", "Dermatologists"));
        arrcontect.add(new Contect_model(R.drawable.doctorf, "Dr. Mumtaz", "Mirpurkhas", "Neurologists"));
        arrcontect.add(new Contect_model(R.drawable.doctor, "Dr. Hassan", "Digri", "General Physicians"));
        arrcontect.add(new Contect_model(R.drawable.doctor, "Dr. Ahmed", "Mirpurkhas", "Ophthalmologists"));
        adapter = new RecyclerContectAdapter(this, arrcontect);
        recyclerView.setAdapter(adapter);
    }

    /*private void filterList(String text) {
        ArrayList<Contect_model> filteredList = new ArrayList<>();
        for (Contect_model item: arrcontect){
            if(item.getName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
        if(filteredList.isEmpty()){
            Toast.makeText(this, "no data found", Toast.LENGTH_SHORT).show();
        }
        else{
            adapter.setFilteredList(filteredList);
        }
    }*/

    }