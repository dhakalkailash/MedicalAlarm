package com.example.medicinealarm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

public class alarmTime extends AppCompatActivity {

    EditText medicineName, totalMedicine, quantityTake;

    private TimePicker timePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_time);

        timePicker = findViewById(R.id.timepicker);

        // this are all extra added after making alaram confirm ***
        Spinner mySpinner = (Spinner)findViewById(R.id.spinner);
        medicineName    = findViewById(R.id.medicineName);
        totalMedicine   = findViewById(R.id.totalMedicine);
        quantityTake    = findViewById(R.id.quantityTake);

        ArrayAdapter<String >myAdapter = new ArrayAdapter<String>(alarmTime.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter((myAdapter));

        final Intent intent = new Intent(this,AlarmService.class);
        ServiceCaller(intent);

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                ServiceCaller(intent);
            }
        });

    }

    private void ServiceCaller(Intent intent){
        stopService(intent);

        Integer alarmHour   = timePicker.getCurrentHour();
        Integer alarmMinute = timePicker.getCurrentMinute();

        intent.putExtra("alarmHour",alarmHour);
        intent.putExtra("alarmMinute",alarmMinute);

        startService(intent);
    }
}