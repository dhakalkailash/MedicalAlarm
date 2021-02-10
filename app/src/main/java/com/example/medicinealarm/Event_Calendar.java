package com.example.medicinealarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Event_Calendar extends AppCompatActivity {

    EditText title, location, description;
    Button addEvent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event__calendar);

        title     = findViewById(R.id.etTitle);
        location  = findViewById(R.id.etLocation);
        description     = findViewById(R.id.etDescription);
        addEvent    = findViewById(R.id.btnAdd);

        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!title.getText().toString().isEmpty()&& !location.getText().toString().isEmpty()
                && !description.getText().toString().isEmpty()){

                    Intent intent = new Intent(Intent.ACTION_INSERT);
                    intent.setData(CalendarContract.Events.CONTENT_URI);
                    intent.putExtra(CalendarContract.Events.TITLE,title.getText().toString());
                    intent.putExtra(CalendarContract.Events.EVENT_LOCATION,location.getText().toString());
                    intent.putExtra(CalendarContract.Events.DESCRIPTION,description.getText().toString());
                    intent.putExtra(CalendarContract.Events.ALL_DAY,"true");
                    intent.putExtra(Intent.EXTRA_EMAIL,"kailashdhakal@gmail.com,kailashtry0@gmail.com");

                    if (intent.resolveActivity(getPackageManager()) != null) {

                        startActivity(intent);
                    }else {
                        Toast.makeText(Event_Calendar.this,"App Can't suport your request",
                                Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(Event_Calendar.this,"One or many fields are empty",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}