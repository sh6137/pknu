package com.pknu.prjlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("리스트 뷰 테스트");
        //data 준비
        final String [] mid = {"히어로즈","24시","로스트","로스트룸","스몰빌", "탐정몽크"
            ,"빅뱅이론" ,"프렌즈","덱스터","글리","가쉽걸","테이큰","슈퍼내추럴", "CSI"
        };

        this.listView1 = findViewById(R.id.listView1);
//단순 리스트
        /*ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mid);*/
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, mid);
        listView1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg1, View arg2, int arg3, long arg4) {
                Toast.makeText(
                        getApplicationContext(),
                        mid[arg3]+"을 선택하였습니다.",
                        Toast.LENGTH_LONG
                ).show();
            }
        });


    }
}
