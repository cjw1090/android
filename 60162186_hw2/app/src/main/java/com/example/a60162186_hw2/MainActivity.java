package com.example.a60162186_hw2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

//import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
//import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    RadioButton rad1,rad2, rad3;
    //RadioGroup radG;
    View dialogView, toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //radG = (RadioGroup) findViewById(R.id.radioGroup);
        rad1 = (RadioButton) findViewById(R.id.dog);
        rad2 = (RadioButton) findViewById(R.id.cat);
        rad3 = (RadioButton) findViewById(R.id.rabbit);
        btn1 = (Button) findViewById(R.id.button1);
        final RadioGroup rg = (RadioGroup)findViewById(R.id.radioGroup);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                int checkRadio = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(checkRadio);
                String str = rb.getText().toString();
                //Toast.makeText(getApplicationContext(), str,Toast.LENGTH_SHORT).show();
                if(str.equals("강아지")){
                    dialogView = (View) View.inflate(MainActivity.this, R.layout.dog, null);
                }else if (str.equals("고양이")){
                    dialogView = (View) View.inflate(MainActivity.this, R.layout.cat, null);
                }else if (str.equals("토끼")){
                    dialogView = (View) View.inflate(MainActivity.this, R.layout.rabbit, null);
                }

                AlertDialog.Builder dia = new AlertDialog.Builder(MainActivity.this);
                dia.setTitle(str);
                dia.setIcon(R.drawable.ic_baseline_group_24);
                dia.setView(dialogView);
                dia.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast toast = new Toast(MainActivity.this);
                        toastView = (View) View.inflate(MainActivity.this, R.layout.toast1, null);
                        toast.setView(toastView);
                        toast.show();
                    }
                });
                dia.show();
            }

        });

    }
}
