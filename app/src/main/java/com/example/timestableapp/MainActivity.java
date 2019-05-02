package com.example.timestableapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    public void generateTimesTable ( int timesTableNumber){
        ArrayList<String> timesTableContent = new ArrayList<>();
        for (int index = 1; index <= 10; index++) {
            timesTableContent.add(String.valueOf(index * timesTableNumber));
        }
        ListView myListView = findViewById(R.id.myListView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, timesTableContent);
        myListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int initialValue = 10;
        final int maxValue = 20;
        final SeekBar timesTableSeekBar = findViewById(R.id.slider);
        timesTableSeekBar.setMax(maxValue);
        timesTableSeekBar.setProgress(initialValue);
        generateTimesTable(initialValue);

        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                final int min = 1;
                int timesTableNumber;
                if (progress < min) {
                    timesTableNumber = min;
                    timesTableSeekBar.setProgress(min);
                } else {
                    timesTableNumber = progress;
                }
                TextView numberTextViewInside = findViewById(R.id.numberTextView);
                numberTextViewInside.setText(String.valueOf(timesTableNumber));
                generateTimesTable(timesTableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }
}
