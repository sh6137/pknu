package com.pknu.myapplication;

import android.Manifest;
import android.app.Activity;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    Button btnPrev, btnNext;
    MyPictureView myPicture;
    TextView tvNumber;

    int curNum;
    File[] imageFiles;
    String imageFname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("이미지 뷰어");

        //권한과 관련된 추가코딩

        ActivityCompat.requestPermissions(this,
                new String[]{
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                },MODE_PRIVATE);
        btnPrev = findViewById(R.id.btnPrev);
        btnNext = findViewById(R.id.btnNext);
        tvNumber = findViewById(R.id.tvNumber);
        myPicture = findViewById(R.id.myPictureView);

        imageFiles = new File(Environment.getExternalStorageDirectory()
        .getAbsolutePath() + "/Pictures").listFiles();
        imageFname = imageFiles[0].toString();
        myPicture.imagePath = imageFname;
        tvNumber.setText("1"+"/" + imageFiles.length);

        //이전 버튼 클릭
        btnPrev.setOnClickListener((View v)->{
            if(curNum <= 0)
                curNum= imageFiles.length -1;
            //curNum =0; // 고정
            else
                curNum = curNum -1;
            imageFname = imageFiles[curNum].toString();
            myPicture.imagePath = imageFname;
            myPicture.invalidate(); // onDraw() 강제 호출
            tvNumber.setText((curNum+1) + "/"+ imageFiles.length);
        });

        //다음 버튼 클릭
        btnNext.setOnClickListener((View v)->{
            if(curNum >= imageFiles.length-1)
                curNum= 0;
                //curNum =imageFiles.length-1; // 고정
            else
                curNum = curNum +1;
            imageFname = imageFiles[curNum].toString();
            myPicture.imagePath = imageFname;
            myPicture.invalidate(); // onDraw() 강제 호출
            tvNumber.setText((curNum+1) + "/"+ imageFiles.length);
        });

    }
}
