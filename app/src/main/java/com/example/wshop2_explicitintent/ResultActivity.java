package com.example.wshop2_explicitintent;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //get information from calling activity
        Candidate candidate = (Candidate) getIntent().getSerializableExtra("candidate");

        Button btn = findViewById(R.id.button);
        btn.setText(candidate.name);
        btn.setBackgroundColor(Color.parseColor(candidate.color));
    }
}
