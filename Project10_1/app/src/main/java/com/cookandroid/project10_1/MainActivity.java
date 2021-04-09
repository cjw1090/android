package com.cookandroid.project10_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    Button btnNewActivity;
    RadioButton btn2,btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNewActivity = (Button) findViewById(R.id.btnNewActivity);
        btn2 = (RadioButton) findViewById(R.id.Btn2) ;
        btn3 = (RadioButton) findViewById(R.id.Btn3);
        final RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);

        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int checkRadio = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(checkRadio);
                String str = rb.getText().toString();
                if(str.equals("Second 액티비티")){
                    Intent mIntent = new Intent(getApplicationContext(), SecondActivity.class);

                    String name = "John";
                    Integer age = 25;

                    mIntent.putExtra("Name", name);
                    mIntent.putExtra("Age", age);
                    startActivity(mIntent);

                } else if(str.equals("Third 액티비티")){
                    Intent mIntent = new Intent(getApplicationContext(), ThirdActivity.class);
                    String name = "Alice";
                    Integer age = 33;
                    mIntent.putExtra("Name", name);
                    mIntent.putExtra("Age", age);
                    startActivity(mIntent);
                }

            }
        });
    }
}
