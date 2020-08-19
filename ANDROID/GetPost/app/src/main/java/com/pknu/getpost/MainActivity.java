package com.pknu.getpost;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

// AsyncTask(Deprecte) -> ThreadTask

class GetDongListTask extends AsyncTask<String, Void, String> {

    MainActivity   mainActivity;

    // 생성자
    public GetDongListTask(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        Log.w("이벤트 발생", "생성자");
    }

    // onPreExecute() 이벤트 처리
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.w("이벤트 발생", "onPreExecute()");
    }

    // doInBackground 이벤트 처리 : 호출전
    @Override
    protected String doInBackground(String... strings) {
        Log.w("이벤트 발생", "doInBackground()");

        String result  = "";
        try {
            String  href="http://localhost:9090/getPost";  // 호출할 스프링의 주소
            URL  url       = new URL(href);
            String params   = "dong=" + strings[0];  // + ^&sido=" + strings[1];
            // href 주소에 data를 가져오기 위한 설정
            HttpURLConnection  conn = (HttpURLConnection) url.openConnection();
            //다운로드 받는다
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestMethod("POST");

            // 파라미터를 서버로 전송한다
            OutputStreamWriter osw  = new OutputStreamWriter(conn.getOutputStream());
            osw.write(params);
            osw.flush();

            // 서버로 부터 전송받은 데이터 저장
            // json data를 분자열로 받아들임
            String str = "";
            if(conn.getResponseCode() == conn.HTTP_OK) {   // 200
                InputStreamReader isr = new InputStreamReader(
                        conn.getInputStream(), "utf-8"  );
                BufferedReader reader  = new BufferedReader(isr);
                StringBuffer   buffer  = new StringBuffer();
                while((str=reader.readLine()) != null) {
                    buffer.append(str);
                }
                result = buffer.,toString();
            } else {
                result = "";
                Log.e("=오류=", conn.getResponseCode() + "오류");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.i("==결과==", result);
        Toast.makeText(mainActivity, "결과" + result,
                Toast.LENGTH_LONG).show();
        return result;
    }

    // onPostExecute() 이벤트 처리
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.w("이벤트 발생", "onPostExecute()");

        String result  = "";
        if(s == null) result = "결과 없음";
        else          result = s;
        Toast.makeText(mainActivity, "결과" + result,
                Toast.LENGTH_LONG).show();
    }
}
