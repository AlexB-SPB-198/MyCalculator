package com.example.mycalculator;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
    private TextView tv_Result;
    private Integer first;
    private Integer second;
    private Boolean isOperationClick;
    private String operation;
    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_Result = findViewById(R.id.tv_result);
        send = findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                String text = tv_Result.getText().toString();
                intent.putExtra("key", text);
                startActivity(intent);
            }
        });
    }






    public void setNumber(String numbers) {
        if (tv_Result.getText().toString().equals("0")) {
            tv_Result.setText(numbers);
        } else if (isOperationClick) {
            tv_Result.setText(numbers);
        } else {
            tv_Result.append(numbers);
        }
        isOperationClick = false;
    }

    public void onNumberClick(View view) {
        switch (view.getId()) {
            case R.id.one:
                setNumber("1");
                break;
            case R.id.two:
                setNumber("2");
                break;
            case R.id.three:
                setNumber("3");
                break;
            case R.id.four:
                setNumber("4");
                break;
            case R.id.five:
                setNumber("5");
                break;
            case R.id.six:
                setNumber("6");
                break;
            case R.id.seven:
                setNumber("7");
                break;
            case R.id.eight:
                setNumber("8");
                break;
            case R.id.nine:
                setNumber("9");
                break;
            case R.id.btn_null:
                setNumber("0");
                break;
            case R.id.btn_ac:
                tv_Result.setText("0");
                first = 0;
                second = 0;
                break;
        }
        isOperationClick = false;
    }


    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.plus:
                first = Integer.parseInt(tv_Result.getText().toString());
                isOperationClick = true;
                operation = "+";
                break;
            case R.id.minus:
                first = Integer.parseInt(tv_Result.getText().toString());
                isOperationClick = true;
                operation = "-";
                break;
            case R.id.multiply:
                first = Integer.parseInt(tv_Result.getText().toString());
                isOperationClick = true;
                operation = "X";
                break;
            case R.id.division:
                first = Integer.parseInt(tv_Result.getText().toString());
                isOperationClick = true;
                operation = "/";
                break;
            case R.id.equal:
                second = Integer.parseInt(tv_Result.getText().toString());
                Integer result = 0;
                switch (operation) {
                    case "+":
                        result = first + second;
                        tv_Result.setText(result.toString());
                        break;
                    case "-":
                        result = first - second;
                        tv_Result.setText(result.toString());
                        break;
                    case "X":
                        result = first * second;
                        tv_Result.setText(result.toString());
                        break;
                    case "/":
                        result = first / second;
                        tv_Result.setText(result.toString());
                        break;
                }
                isOperationClick = true;
        }

    }
}
