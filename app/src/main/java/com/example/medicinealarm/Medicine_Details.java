package com.example.medicinealarm;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Medicine_Details extends AppCompatActivity {

    EditText medicineName, medicineQuantity,timeDay,numberTake,timeHour,timeMinute ;
    Button setTime, setAlarm;
    TimePickerDialog timePickerDialog;
    Calendar calendar;
    int currentHour;
    int currentMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_details);

        timeHour   = findViewById(R.id.etHour);
        timeMinute = findViewById(R.id.etMinute);
        setTime    = findViewById(R.id.btnTime);
        setAlarm   = findViewById(R.id.btnAlarm);
        setTime.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              calendar = Calendar.getInstance();
              currentHour = calendar.get(Calendar.HOUR_OF_DAY);
              currentMinute = calendar.get(Calendar.MINUTE);

              timePickerDialog = new TimePickerDialog(Medicine_Details.this, new TimePickerDialog.OnTimeSetListener() {
                  @Override
                  public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                      timeHour.setText(String.format("%02d", hourOfDay));
                      timeMinute.setText(String.format("%02d", minute));

                  }
              },
                      currentHour, currentMinute, false);
              timePickerDialog.show();
          }

      });
      // set Alarm Button will come into the play

        setAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!timeHour.getText().toString().isEmpty() && !timeMinute.getText().toString().isEmpty()) {
                    Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                    intent.putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(timeHour.getText().toString()));
                    intent.putExtra(AlarmClock.EXTRA_MINUTES, Integer.parseInt(timeMinute.getText().toString()));
                    intent.putExtra(AlarmClock.EXTRA_MESSAGE, "set Alarm for the medicine ");
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    } else {
                        Toast.makeText(Medicine_Details.this, "App Cannot support this action !! ", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(Medicine_Details.this, " Pleaes choose a time !! ", Toast.LENGTH_SHORT).show();
                }
            }
      });

    }
}