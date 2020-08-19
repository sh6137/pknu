package com.pknu.activitylifecycle;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("액티비티 생명주기");
        android.util.Log.i("액티비티 테스트","Oncreate()");


        Button btnDial = findViewById(R.id.btnDial);
        Button btnFinish = findViewById(R.id.btnFinish);

        btnDial.setOnClickListener((v)->{
            Uri uri = Uri.parse("tel:010-3333-4444");
            Intent intent = new Intent(Intent.ACTION_DIAL, uri);
            startActivity(intent);

        });

        btnFinish.setOnClickListener((v)->{
            finish();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("액티비티 테스트", "onStart");
    }

    @Override
    protected void onPause() {
        Log.i("액티비티 테스트", "onPause");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        Log.i("액티비티 테스트", "onRestart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.i("액티비티 테스트", "onResume");
        super.onResume();
    }

    @Override
    protected void onStop() {
        Log.i("액티비티 테스트", "onStop");
        super.onStop();
    }
}
