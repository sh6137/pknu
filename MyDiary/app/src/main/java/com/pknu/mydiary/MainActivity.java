package com.pknu.mydiary;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatePicker dp1;
    EditText edtDiary;
    Button    btnWrite;

    String filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("일기장");

    edtDiary = findViewById(R.id.edtDiary);
    dp1 = findViewById(R.id.datePicker1);
    btnWrite = findViewById(R.id.btnWrite);


    //해당 날짜의 일기를 읽어 온다.
    Calendar cal = Calendar.getInstance();
    int cYear = cal.get(Calendar.YEAR);
    int cMonth = cal.get(Calendar.MONTH);
    int cDay = cal.get(Calendar.DAY_OF_MONTH);
    String fmt = "%04d_%02d_%02d.txt";
    filename=String.format(fmt,cYear,(cMonth+1),cDay);
    String str = readDiary(filename); // 해당 날짜의 일기를 읽어 와서 문자열로
    edtDiary.setText(str);

    //datepicker 초기화 : 이벤트 연결 - 날짜변경
    dp1.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
        @Override
        public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
            String fmt ="%04d_%02d_%02d.txt";

            filename = String.format(fmt, year, (month+1),day);
            String str = readDiary(filename);
            edtDiary.setText(str);
        }
    });
    //저장하기 수정하기 버튼 기능 구현
        btnWrite.setOnClickListener((v)->{
            try {
                FileOutputStream outFs = openFileOutput(filename,Context.MODE_PRIVATE);
                String str2 = edtDiary.getText().toString();
                outFs.write(str2.getBytes());
                outFs.close();

                Toast.makeText(
                        getApplicationContext(),
                        filename + "이 저장됨",
                        Toast.LENGTH_LONG
                ).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private String readDiary(String fName) {
        String diaryStr = null;
        FileInputStream inFs;
        try {
            inFs = openFileInput(fName);
            byte[]txt = new byte[500];
            inFs.read(txt);
            inFs.close();

            diaryStr = (new String(txt)).trim();
            btnWrite.setText("수정하기");

        } catch (IOException e) {
            edtDiary.setText("해당 날짜의 일기없음");
            btnWrite.setText("저장하기");
        }
    return diaryStr;
    }
}
