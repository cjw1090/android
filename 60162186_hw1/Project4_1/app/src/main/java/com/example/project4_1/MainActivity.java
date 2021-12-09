package com.example.project4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText edit1,edit2;
    Button btnAdd, btnSub, btnMul, btnDiv, btnDiv2;
    TextView textResult;
    String num1, num2;
    Double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);
        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button)findViewById(R.id.BtnDiv);
        btnDiv2 = (Button) findViewById(R.id.BtnDiv2);
        textResult = (TextView)findViewById(R.id.TextResult);

        //더하기
        btnAdd.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: //위젯을 누르는 순간
                        num1 = edit1.getText().toString();
                        num2 = edit2.getText().toString();
                        if(num1.isEmpty() || num2.isEmpty()){
                            Toast.makeText(getApplicationContext(), "값을 입력하세요.", Toast.LENGTH_SHORT).show();
                        }else{
                            result = Double.parseDouble(num1) + Double.parseDouble(num2);
                            textResult.setText("계산값 = " + result.toString());
                        }
                        break;
                    case MotionEvent.ACTION_UP: //위젯으로부터 떼는 순간
                        //textResult.setText("UP");
                        Toast.makeText(getApplicationContext(), "Up", Toast.LENGTH_SHORT).show();
                        break;
                    case MotionEvent.ACTION_MOVE: //위젯을 드래그 하는 형태의 터치
                        //textResult.setText("Move");
                        Toast.makeText(getApplicationContext(), "Move", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });

        //빼기
        btnSub.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: //위젯을 누르는 순간
                        num1 = edit1.getText().toString();
                        num2 = edit2.getText().toString();
                        if(num1.isEmpty() || num2.isEmpty()){
                            Toast.makeText(getApplicationContext(), "값을 입력하세요.", Toast.LENGTH_SHORT).show();
                        }else{
                            result = Double.parseDouble(num1) - Double.parseDouble(num2);
                            textResult.setText("계산값 = " + result.toString());
                        }
                        break;
                    case MotionEvent.ACTION_UP: //위젯으로부터 떼는 순간
                        //textResult.setText("UP");
                        Toast.makeText(getApplicationContext(), "Up", Toast.LENGTH_SHORT).show();
                        break;
                    case MotionEvent.ACTION_MOVE: //위젯을 드래그 하는 형태의 터치
                        //textResult.setText("Move");
                        Toast.makeText(getApplicationContext(), "Move", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });

        //곱하기
        btnMul.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: //위젯을 누르는 순간
                        num1 = edit1.getText().toString();
                        num2 = edit2.getText().toString();
                        if(num1.isEmpty() || num2.isEmpty()){
                            Toast.makeText(getApplicationContext(), "값을 입력하세요.", Toast.LENGTH_SHORT).show();
                        }else{
                            result = Double.parseDouble(num1) * Double.parseDouble(num2);
                            textResult.setText("계산값 = " + result.toString());
                        }
                        break;
                    case MotionEvent.ACTION_UP: //위젯으로부터 떼는 순간
                        //textResult.setText("UP");
                        Toast.makeText(getApplicationContext(), "Up", Toast.LENGTH_SHORT).show();
                        break;
                    case MotionEvent.ACTION_MOVE: //위젯을 드래그 하는 형태의 터치
                        //textResult.setText("Move");
                        Toast.makeText(getApplicationContext(), "Move", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });

        //나누기
        btnDiv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: //위젯을 누르는 순간
                        num1 = edit1.getText().toString();
                        num2 = edit2.getText().toString();
                        if(num1.isEmpty() || num2.isEmpty()){
                            Toast.makeText(getApplicationContext(), "값을 입력하세요.", Toast.LENGTH_SHORT).show();
                        }else if (Integer.parseInt(num2)==0){
                            Toast.makeText(getApplicationContext(),"0으로 나눌 수 없습니다.", Toast.LENGTH_LONG).show();
                        }else{
                            result = Double.parseDouble(num1) / Double.parseDouble(num2);
                            textResult.setText("계산값 = " + result.toString());
                        }
                        break;
                    case MotionEvent.ACTION_UP: //위젯으로부터 떼는 순간
                        //textResult.setText("UP");
                        Toast.makeText(getApplicationContext(), "Up", Toast.LENGTH_SHORT).show();
                        break;
                    case MotionEvent.ACTION_MOVE: //위젯을 드래그 하는 형태의 터치
                        //textResult.setText("Move");
                        Toast.makeText(getApplicationContext(), "Move", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });

        //나머지값
        btnDiv2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: //위젯을 누르는 순간
                        num1 = edit1.getText().toString();
                        num2 = edit2.getText().toString();
                        if(num1.isEmpty() || num2.isEmpty()){
                            Toast.makeText(getApplicationContext(), "값을 입력하세요.", Toast.LENGTH_SHORT).show();
                        }else if (Integer.parseInt(num2)==0){
                            Toast.makeText(getApplicationContext(),"0으로 나눌 수 없습니다..", Toast.LENGTH_LONG).show();
                        }else{
                            result = Double.parseDouble(num1) % Double.parseDouble(num2);
                            textResult.setText("계산값 = " + result.toString());
                        }
                        break;
                    case MotionEvent.ACTION_UP: //위젯으로부터 떼는 순간
                        //textResult.setText("UP");
                        Toast.makeText(getApplicationContext(), "Up", Toast.LENGTH_SHORT).show();
                        break;
                    case MotionEvent.ACTION_MOVE: //위젯을 드래그 하는 형태의 터치
                        //textResult.setText("Move");
                        Toast.makeText(getApplicationContext(), "Move", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
    }
}
