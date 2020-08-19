package com.pknu.moviestatics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("명화 선호도 투표");

        int [] voteCount = new int[9];
        for (int i =0; i<9 ; i++)
            voteCount[i] = 0;

        // 9개의 이미지버튼 객체배열
        ImageView [] image = new ImageView[9];

        Integer [] ImageId = {
                R.id.iv1, R.id.iv2, R.id.iv3,
                R.id.iv4, R.id.iv5, R.id.iv6,
                R.id.iv7, R.id.iv8, R.id.iv9
        };

        String [] imgName = {
             "독서하는 소녀",      "꽃장식 모자 소녀",   "부채를 든 소녀",
             "이레느깡 단 베르양", "잠자는 소녀",        "테라스의 두 자매",
             "피아노 레슨",        "피아노 앞의 소녀들", "해변에서"
        };

        //------------------------------------------------------
        for (int i=0;i<9;i++) {
            final int index = i;
            image[index] = findViewById(ImageId[index]);
            image[index].setOnClickListener((v)->{
                  voteCount[index]++;
                  Toast.makeText(getApplicationContext(),
                          imgName[index] + ": 총 " + voteCount[index] + "표",
                          Toast.LENGTH_LONG).show();
            });
        }

        Button  btnResult = findViewById(R.id.btnResult);
        btnResult.setOnClickListener((v)->{
            // 새 activity 를 열러알
            Intent intent = new Intent( getApplicationContext(),
                   ResultActivity.class );
            intent.putExtra("VoteCount", voteCount);
            intent.putExtra("ImageName", imgName);
            startActivity(intent);
        });

    }
}
