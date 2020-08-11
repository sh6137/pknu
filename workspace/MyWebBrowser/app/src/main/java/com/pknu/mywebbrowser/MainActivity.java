package com.pknu.mywebbrowser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtUrl;
    Button btnGo, btnBack;
    WebView webView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.edtUrl = findViewById(R.id.edtUrl);
        this.btnGo =findViewById(R.id.btnGo);
        this.btnBack=findViewById(R.id.btnBack);
        this.webView1=findViewById(R.id.webView1);

        this.edtUrl.setText("https://m.naver.com");
        btnGo.setOnClickListener((v)->{
            webView1.setWebViewClient(new MyWebViewClient());
            webView1.loadUrl(String.valueOf(edtUrl.getText()));
        });
    }
}
