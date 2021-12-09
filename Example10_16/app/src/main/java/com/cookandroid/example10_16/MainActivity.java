package com.cookandroid.example10_16;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton btnAdd, btnSub, btnMul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = (RadioButton) findViewById(R.id.btnAdd);
        btnMul = (RadioButton) findViewById(R.id.btnMul);
        btnSub = (RadioButton) findViewById(R.id.btnSub);
        final RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
        Button btn1 = (Button) findViewById(R.id.btnNewActivity);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int checkRadio = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(checkRadio);
                String str = rb.getText().toString();
                EditText editNum1 = (EditText) findViewById(R.id.edtNum1);
                EditText editNum2 = (EditText) findViewById(R.id.edtNum2);
                if(str.equals("더하기")){
                    Intent txIntent = new Intent(MainActivity.this, AddActivity.class);
                    txIntent.putExtra("Num1", Integer.parseInt(editNum1.getText().toString()));
                    txIntent.putExtra("Num2", Integer.parseInt(editNum2.getText().toString()));
                    startActivityForResult(txIntent, 1000);
                }else if (str.equals("빼기")) {
                    Intent txIntent = new Intent(MainActivity.this, SubActivity.class);
                    txIntent.putExtra("Num1", Integer.parseInt(editNum1.getText().toString()));
                    txIntent.putExtra("Num2", Integer.parseInt(editNum2.getText().toString()));
                    startActivityForResult(txIntent, 2000);
                }else if (str.equals("곱하기")) {
                    Intent txIntent = new Intent(MainActivity.this, MulActivity.class);
                    txIntent.putExtra("Num1", Integer.parseInt(editNum1.getText().toString()));
                    txIntent.putExtra("Num2", Integer.parseInt(editNum2.getText().toString()));
                    startActivityForResult(txIntent, 3000);
                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        EditText edit1 = (EditText) findViewById(R.id.edText);
        switch (requestCode) {

            case 1000:
                if(resultCode == RESULT_OK && data != null){

                    int result = data.getExtras().getInt("AddResult");
                    //EditText edit1 = (EditText) findViewById(R.id.edText);

                    edit1.setText(String.valueOf(result));
                    //Toast.makeText(MainActivity.this, "더하기 결과값: " +result, Toast.LENGTH_SHORT).show();

                }
                break;
            case 2000 :
                if(resultCode == RESULT_OK && data != null){
                    int result = data.getExtras().getInt("SubResult");
                    //EditText edit1 = (EditText) findViewById(R.id.edText);
                    edit1.setText(String.valueOf(result));

                    //Toast.makeText(MainActivity.this, "빼기 결과값: " +result, Toast.LENGTH_SHORT).show();

                }
                break;
            case 3000 :
                if(resultCode == RESULT_OK && data != null){
                    int result = data.getExtras().getInt("MulResult");
                    //EditText edit1 = (EditText) findViewById(R.id.edText);
                    edit1.setText(String.valueOf(result));

                    //Toast.makeText(MainActivity.this, "곱하기 결과값: " +result, Toast.LENGTH_SHORT).show();

                }
                break;
        }
    }
}
