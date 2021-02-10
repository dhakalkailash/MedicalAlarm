package com.example.medicinealarm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class New_Home extends AppCompatActivity {

    TextView profileView, bmiView, medicineView,eventView,emerContactView;
    ImageView  profileImage, bmiImage, medicineRecordImage, eventImage, emergencyImage ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_home);

        profileView     = findViewById(R.id.textView17);
        bmiView         = findViewById(R.id.textView15);
        medicineView    = findViewById(R.id.textView20);
        eventView       = findViewById(R.id.textView12);
        emerContactView = findViewById(R.id.textView13);

        // Trying to navigate when user click on images too
        profileImage         = findViewById(R.id.imageView);
        bmiImage             = findViewById(R.id.imageView2);
        medicineRecordImage  = findViewById(R.id.imageView3);
        eventImage           = findViewById(R.id.imageView4);
        emergencyImage       = findViewById(R.id.imageView5);

        // Now navigate from image click delete if don't work
        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),User_profile.class));
            }
        });
        bmiImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),bmi.class));
            }
        });
        medicineRecordImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Medicine.class));
            }
        });
        eventImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Event_Calendar.class)); //  This one must be redo
            }
        });
        emergencyImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),User_profile.class)); // this must be redo
            }
        });


        // ****************************************************************************************
        // to Navigate to the User profile
        profileView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),User_profile.class));
            }
        });
            // Navigates to the BMI class
        bmiView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),bmi.class));
            }
        });
        medicineView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Medicine.class));
            }
        });
        // To naviagte to the Event Calendar
        eventView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Event_Calendar.class));
            }
        });

    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }
}