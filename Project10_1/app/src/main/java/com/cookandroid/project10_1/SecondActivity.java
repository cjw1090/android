package com.cookandroid.project10_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class SecondActivity extends Activity {
    Button btnReturn;
    EditText edtReceived;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        btnReturn = (Button) findViewById(R.id.btnReturn);
        edtReceived = (EditText) findViewById(R.id.edt1);

        Intent rxIntent = getIntent();
        Bundle extras = rxIntent.getExtras(); //rxintent 에 포함된 값들의 꾸러미
        if(extras!=null){
            String  name = extras.getString("Name");
            Integer age = extras.getInt("Age");
            edtReceived.setText("Received name: "+name+", Received age : "+ age);
        }


        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
