package com.rizik.training.counterapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // pembuatan objek komponen
    TextView tvCount;
    Button btnCount, btnReset;
    int count = 0;
    private final String STATE_COUNT = "state_count";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // bin activity main ke view
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // binding ke view
        tvCount = findViewById(R.id.tv_count);
        btnCount = findViewById(R.id.btn_count);
        btnReset = findViewById(R.id.btn_reset);

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // fitur
                count++;
                tvCount.setText(String.valueOf(count));
                if (count >= 100){
                    tvCount.setTextSize(2, 75);
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //fitur
                count=0;
                tvCount.setText("0");
            }
        });

        if (savedInstanceState != null){
            count = savedInstanceState.getInt(STATE_COUNT);
            tvCount.setText(String.valueOf(count));
            if (count >= 100){
                tvCount.setTextSize(2, 100);
            }
            if (count >= 33){
                count = 0;
            }
        }

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(STATE_COUNT,count);
    }

}