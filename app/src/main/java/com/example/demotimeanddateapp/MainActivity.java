package com.example.demotimeanddateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btnDisplayData;
    Button btnDisplayTime;
    Button resetBtn;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnDisplayData = findViewById(R.id.buttonDisplayDate);
        btnDisplayTime = findViewById(R.id.buttonDisplayTime);
        tvDisplay = findViewById(R.id.textViewDisplay);
        resetBtn = findViewById(R.id.reset);

        btnDisplayTime.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                int curHour = tp.getHour();
                int curMin =  tp.getMinute();
                String Min = String.format("%02d", curMin);
                tvDisplay.setText("Time is "+curHour +":"+ Min);

            }
        });

        btnDisplayData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int curYear = dp.getYear();
                int curMonth = dp.getMonth();
                int curDay = dp.getDayOfMonth();
                int month = curMonth + 1;

                tvDisplay.setText("Date is: "+curDay+"/"+month+"/"+curYear);

            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dp.updateDate(2020, 0, 01);
                tp.setHour(12);
                tp.setMinute(0);
            }
        });

    }
}