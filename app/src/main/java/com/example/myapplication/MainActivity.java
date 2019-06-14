package com.example.myapplication;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2;
    TextView tv;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode==RESULT_OK){
            if(requestCode==3000){
                String s=data.getStringExtra("result");
                tv.setText(s);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=findViewById(R.id.main_plus);
        btn2=findViewById(R.id.main_minus);
        tv=findViewById(R.id.main_result);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SubActivity.class);
                intent.putExtra("input", "+");
                startActivityForResult(intent, 3000);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SubActivity.class);
                intent.putExtra("input", "－");
                startActivityForResult(intent,3000);
            }
        });


    }
}
