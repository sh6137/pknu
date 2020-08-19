package com.pknu.prjlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView1;
    EditText edtItem;
    private View btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("리스트 뷰 테스트");

        this.listView1 = findViewById(R.id.listView1);
        //data 준비
        ArrayList<String> midList = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, midList);
        this.listView1.setAdapter(adapter);

        this.btnAdd  = findViewById(R.id.btnAdd);
        this.edtItem = findViewById(R.id.edtItem);
        this.btnAdd.setOnClickListener((v)->{
            midList.add(this.edtItem.getText().toString());
            adapter.notifyDataSetChanged();
        });
        listView1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {


            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                midList.remove(i);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg1, View arg2, int arg3, long arg4) {
                Toast.makeText(
                        getApplicationContext(),
                        midList.get(arg3)+"을 선택하였습니다.",
                        Toast.LENGTH_LONG
                ).show();
            }
        });


    }
}
