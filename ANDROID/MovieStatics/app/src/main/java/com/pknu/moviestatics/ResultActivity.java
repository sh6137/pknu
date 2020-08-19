package com.pknu.moviestatics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("두표결과");

        Log.i("결과확인 ", "1");

        // 이전 화면에서 보낸 투표 결과 값을 받는다
        Intent     intent     = getIntent();
        int []     voteResult = intent.getIntArrayExtra("VoteCount");
        String []  imageName  = intent.getStringArrayExtra("ImageName");

        Integer [] imageFileId = {
                 R.drawable.pic1, R.drawable.pic2,  R.drawable.pic3,
                 R.drawable.pic4, R.drawable.pic5,  R.drawable.pic6,
                 R.drawable.pic7, R.drawable.pic8,  R.drawable.pic9
        };

        Log.i("결과확인 2", voteResult.toString() );

        // 1등 그림이름과 그림파일을 보여준다
        TextView   tvTop = findViewById(R.id.tvTop);
        ImageView  ivTop = findViewById(R.id.ivTop);

        int maxVote = 0;

        for(int i = 0; i < voteResult.length;i++) {
            if( voteResult[i] > voteResult[maxVote]  )
                maxVote = i;
        }
        System.out.println( imageName[ maxVote ] );

        tvTop.setText( imageName[ maxVote ]);
        ivTop.setImageResource(  imageFileId[ maxVote ] );



        // 통계 결과 보여주기
        TextView[]  tv    = new TextView[9];
        RatingBar[] rbar  = new RatingBar[9];

        Integer []  tvID = {
                R.id.tv1, R.id.tv2, R.id.tv3,
                R.id.tv4, R.id.tv5, R.id.tv6,
                R.id.tv7, R.id.tv8, R.id.tv9
        };
        Integer [] rbarID = {
                R.id.rbar1, R.id.rbar2, R.id.rbar3,
                R.id.rbar4, R.id.rbar5, R.id.rbar6,
                R.id.rbar7, R.id.rbar8, R.id.rbar9
        };

        for(int i = 0; i < voteResult.length;i++) {
            tv[i]   = findViewById( tvID[i]);
            rbar[i] = findViewById( rbarID[i]  );
        }

        for(int i = 0; i < voteResult.length;i++) {
            tv[i].setText( imageName[i] );
            rbar[i].setRating( (float) voteResult[i] );
        }


        // 돌아가기 버튼 클릭
        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener((v)->{ finish(); });

    }

}
