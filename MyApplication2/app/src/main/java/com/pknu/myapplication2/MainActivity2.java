package com.pknu.myapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    String snum1, snum2;
    double num1, num2;
    EditText edit1, edit2;
    TextView txtResult;
    Button btnAdd, btnSub, btnMul, btnDiv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setTitle("간단한 계산기");

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        txtResult = findViewById(R.id.txtResult);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);




        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                snum1 = edit1.getText().toString();
                snum2 = edit2.getText().toString();

                if(snum1.trim().equals("") || snum2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(),
                            "값을 입력해주세요",
                            Toast.LENGTH_LONG).show();
                    return;

                }

                num1 = Double.parseDouble(snum1);
                num2 = Double.parseDouble(snum2);

                double val = num1 + num2;



                txtResult.setText(String.valueOf(val));

            }

        });

        //빼기

        btnSub.setOnClickListener((View v) ->{
            
            calc("-");
            


        });

        btnMul.setOnClickListener((View v) ->{

            calc("*");
        });
        btnDiv.setOnClickListener((View v) ->{

            calc("/");
        });




}

    private void calc(String op) {

        snum1 = edit1.getText().toString();
        snum2 = edit2.getText().toString();

        num1 = Double.parseDouble(snum1);
        num2 = Double.parseDouble(snum2);

        double val =0.0;
        switch (op){
            case "-": val = num1 -num2 ; break;
            case "*": val = num1 *num2 ; break;
            case "/": val = num1 /num2 ; break;
        }

        txtResult.setText(String.valueOf(val));

    }
}