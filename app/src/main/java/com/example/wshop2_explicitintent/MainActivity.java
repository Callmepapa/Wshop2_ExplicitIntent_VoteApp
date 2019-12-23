package com.example.wshop2_explicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    HashMap<Integer, Candidate> candidates = new HashMap<>();
    final int ON_VOTE_RETURN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();//创建人物对象

        //获取投票按钮添加单击事件监听器
        Button btn = findViewById(R.id.voteNowBtn);
        if (btn != null) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(MainActivity.this, VoteActivity.class);
                    intent.putExtra("candidates", candidates);

                    //调用另一个activity并返回结果，请求码
                    startActivityForResult(intent, ON_VOTE_RETURN);
                }
            });
        }
    }



    protected void initData() {
        Candidate candidate;

        candidate = new Candidate(1, "James", "#e0a6bd");
        candidates.put(candidate.id, candidate);

        candidate = new Candidate(2, "Lisa", "#a6bde0");
        candidates.put(candidate.id, candidate);

        candidate = new Candidate(3, "Larry", "#cbe7b9");
        candidates.put(candidate.id, candidate);

        candidate = new Candidate(4, "Janet", "#d38980");
        candidates.put(candidate.id, candidate);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        //还需要返回到mainActivity中,对返回结果进行处理
        if (requestCode == ON_VOTE_RETURN) {
            if (resultCode == RESULT_OK) {
                int candidateId = intent.getIntExtra("candidateId", -1);

                //把信息传给resultActivity
                Intent newIntent = new Intent(this, ResultActivity.class);
                newIntent.putExtra("candidate", candidates.get(candidateId));

                startActivity(newIntent);
            }
        }
    }
}
