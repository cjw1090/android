package com.cookandroid.project10_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class ThirdActivity extends Activity {
    Button btnReturn1;
    EditText edtReceived1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.third);
        btnReturn1 = (Button) findViewById(R.id.btnReturn2);
        edtReceived1 = (EditText) findViewById(R.id.edt2);

        Intent rxIntent = getIntent();
        Bundle extras = rxIntent.getExtras();
        if(extras!=null){
            String  name = extras.getString("Name");
            Integer age = extras.getInt("Age");
            edtReceived1.setText("Received name: "+name+", Received age : "+ age);
        }

        btnReturn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
