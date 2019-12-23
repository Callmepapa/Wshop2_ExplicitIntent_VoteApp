package com.example.wshop2_explicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;

public class VoteActivity extends AppCompatActivity
    implements View.OnClickListener {

    HashMap<Integer, Candidate> candidates = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);

        //获取intent的内容
        Intent callerIntent = getIntent();
        if (callerIntent != null) {
            candidates = (HashMap<Integer, Candidate>) callerIntent.getSerializableExtra("candidates");
        }

        //把信息显示在屏幕上
        initUI();
    }

    ////把信息显示在屏幕上的方法
    protected void initUI() {
        Button btn = null;
        int pos = 0;

        if (candidates == null)
            return;

        for (Map.Entry<Integer, Candidate> entry : candidates.entrySet()) {
            Integer voterId = entry.getKey();
            Candidate candidate = entry.getValue();

            btn = findViewById(getResources().getIdentifier(
                    "btn" + pos, "id", getPackageName()));
            if (btn != null) {
                btn.setText(candidate.name);
                btn.setTag(voterId);
                btn.setOnClickListener(this);
            }

            pos++;
        }
    }

    //（获取选择的信息id并保存，传回原来的activity中）
    public void onClick(View v) {
        Intent intent = new Intent();

        //把voteid保存再intent里
        int candidateId = (int) v.getTag();
        intent.putExtra("candidateId", candidateId);

        //将东西传回 calling activity
        setResult(RESULT_OK, intent);
        finish();
    }
}
