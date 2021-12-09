package com.cookandroid.example10_16;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MulActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mul);
        EditText txt1 = (EditText) findViewById(R.id.mulResult);

        Intent rxIntent = getIntent();
        int num1 = rxIntent.getExtras().getInt("Num1");
        int num2 = rxIntent.getExtras().getInt("Num2");
        //final int result = rxIntent.getExtras().getInt("Num1") + rxIntent.getExtras().getInt("Num2");
        final int result = num1 * num2;
        txt1.setText(num1 + " * " + num2 + " =" + result);
        Button btnReturn = (Button) findViewById(R.id.mulReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent respIntent = new Intent(MulActivity.this, MainActivity.class);
                respIntent.putExtra("MulResult", result);
                setResult(RESULT_OK, respIntent);
                finish();
            }
        });
    }
}
