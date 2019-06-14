package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity {

    Button btn;
    TextView tv;
    EditText ed1, ed2;
    int fn, sn, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        btn=findViewById(R.id.sub_button);
        tv=findViewById(R.id.sub_tv1);
        ed1=findViewById(R.id.sub_fistnum);
        ed1=findViewById(R.id.sub_secondnum);

        Intent intent=getIntent();

        final String s=intent.getStringExtra("input");

        tv.setText(s);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fn=Integer.parseInt(ed1.getText().toString());
                sn=Integer.parseInt(ed2.getText().toString());
                switch (s){
                    case "+":
                        result=fn+sn;
                        break;
                    case "－":
                        result=fn-sn;
                        break;
                }

                Intent resultintent=new Intent();
                resultintent.putExtra("result", "연산결과는 "+result+"입니다..");
                setResult(RESULT_OK,resultintent);
                finish();

            }

        });

    }
}
