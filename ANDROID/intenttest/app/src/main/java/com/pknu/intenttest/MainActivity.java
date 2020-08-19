package com.pknu.intenttest;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("암시적 인텐트 예제");

        Button btnDial = findViewById(R.id.btnDial);
        Button btnWeb = findViewById(R.id.btnWeb);
        Button btnGoogle = findViewById(R.id.btnGoogle);
        Button btnSearch = findViewById(R.id.btnSearch);
        Button btnSms = findViewById(R.id.btnSms);
        Button btnPhoto = findViewById(R.id.btnPhoto);

        btnDial.setOnClickListener((v)->{
            Uri uri = Uri.parse("tel:010-1234-1234");
            Intent intent = new Intent(Intent.ACTION_DIAL,uri);
            startActivity(intent);
        });

        btnWeb.setOnClickListener((v)->{
            Uri uri = Uri.parse("https://m.danawa.com");
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            startActivity(intent);
        });

        btnGoogle.setOnClickListener((v)->{
            Uri uri = Uri.parse("https://maps.google.com/maps?q="
                    +35.1796+"."+129.0756);
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            startActivity(intent);
        });

        btnSearch.setOnClickListener((v)->{
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY,"안드로이드");
            startActivity(intent);
        });

        btnSms.setOnClickListener((v)->{
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.putExtra("sms_body","안녕하세요");
            intent.setData(Uri.parse("smsto:"+Uri.encode("010-9368-4939")));
            startActivity(intent);
        });

        btnPhoto.setOnClickListener((v)->{
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            startActivity(intent);
        });
    }
}
