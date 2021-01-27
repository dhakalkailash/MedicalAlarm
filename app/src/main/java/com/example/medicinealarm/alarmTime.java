package com.example.medicinealarm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

public class alarmTime extends AppCompatActivity {


    private TimePicker timePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_time);

        timePicker = findViewById(R.id.timepicker);

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