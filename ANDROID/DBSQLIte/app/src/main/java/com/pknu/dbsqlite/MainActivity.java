package com.pknu.dbsqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.SettingInjectorService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyDBHelper     myHelper;
    SQLiteDatabase sqlDB;

    EditText    edtName, edtNumber,  edtNameResult, edtNumberResult;
    Button      btnInit, btnInsert, btnUpdate, btnDelete, btnSelect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("가수 그룹 관리 DB");

        this.edtName           = findViewById(R.id.edtName);
        this.edtNumber         = findViewById(R.id.edtNumber);
        this.edtNameResult     = findViewById(R.id.edtNameResult);
        this.edtNumberResult   = findViewById(R.id.edtNumberResult);

        this.btnInit           = findViewById(R.id.btnInit);
;       this.btnInsert         = findViewById(R.id.btnInsert);
        this.btnUpdate        = findViewById(R.id.btnUpdate);
        this.btnDelete        = findViewById(R.id.btnDelete);
        this.btnSelect       = findViewById(R.id.btnSelect);

        myHelper = new MyDBHelper(this);

        // 초기화  db
        this.btnInit.setOnClickListener((v)->{
            sqlDB  = myHelper.getWritableDatabase();   // db open
            myHelper.onUpgrade(sqlDB, 1, 2); // table 지우고 새로 만듬
            sqlDB.close();
            textClear();
        });

        // data 추가 : insert
        this.btnInsert.setOnClickListener((v)->{
            sqlDB  = myHelper.getWritableDatabase();
            String  gName = edtName.getText().toString();
            String  gNum  = this.edtNumber.getText().toString();
            String  sql = "INSERT INTO groupTBL VALUES ('" + gName + "'," + gNum + ")";
            sqlDB.execSQL(sql);
            sqlDB.close();

            // 메세지 출력
            Toast.makeText(getApplicationContext(),
                      gName + "이(가) 저장됨",
                    Toast.LENGTH_LONG ).show();
            textClear();
            // 전체 조회 - 조회번튼 클릭
            btnSelect.callOnClick();
        });

        // 수정
        this.btnUpdate.setOnClickListener((v)->{
            sqlDB  = myHelper.getWritableDatabase();
            String  gName = edtName.getText().toString();
            String  gNum  = this.edtNumber.getText().toString();
            String  sql = "UPDATE groupTBL SET gNumber = " + gNum + " WHERE gName = '" + gName + "'";
            sqlDB.execSQL(sql);
            sqlDB.close();

            // 메세지 출력
            Toast.makeText(getApplicationContext(),
                    gName + "이(가) 수정됨",
                    Toast.LENGTH_LONG ).show();
            textClear();
            // 전체 조회 - 조회번튼 클릭
            btnSelect.callOnClick();
        });

        // 삭제
        this.btnDelete.setOnClickListener((v)-> {
            sqlDB  = myHelper.getWritableDatabase();
            String  gName = edtName.getText().toString();
            String  sql = "DELETE FROM groupTBL WHERE gName = '" + gName + "'";
            sqlDB.execSQL(sql);
            sqlDB.close();

            // 메세지 출력
            Toast.makeText(getApplicationContext(),
                    gName + "이(가) 삭제됨",
                    Toast.LENGTH_LONG ).show();
            // 전체 조회 - 조회번튼 클릭
            textClear();
            btnSelect.callOnClick();
        });

        // 조회
        //  String     query = "SELECT * FROM MEBERS WHERE NAME=? AND PASS=?";
        //  String []  args  = {"sky", "blue"};
        //  sqlDB.rawQuery(query, args);;
        this.btnSelect.setOnClickListener((v)->{
            sqlDB  = myHelper.getWritableDatabase();

            Cursor cursor;
            cursor = sqlDB.rawQuery("SELECT * FROM groupTBL", null);

            String  strNames    = "그룹이름\r\n-----------------------------\r\n";
            String  strNumbers  = "인원\r\n-----------------------------\r\n";

             while(  cursor.moveToNext()  ) {
                 strNames     +=   cursor.getString(0) + "\r\n";
                 strNumbers   +=   cursor.getString(1) + "\r\n";
             }

            this.edtNameResult.setText( strNames );
            this.edtNumberResult.setText( strNumbers );

            cursor.close();
            sqlDB.close();

        });

    }

    private void textClear() {
        this.edtName.setText("");
        this.edtNumber.setText("");
    }

}
