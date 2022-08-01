package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private TextView tv_Result;
    private Double firstVar;
    private Double secondVar;
    private Boolean isOperationClick;
    private String operation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_Result = findViewById(R.id.tv_result);
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
                firstVar = 0.0;
                secondVar = 0.0;
                break;
        }
        isOperationClick = false;
    }


    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.plus:
                firstVar = Double.parseDouble(tv_Result.getText().toString());
                isOperationClick = true;
                operation = "+";
                break;
            case R.id.minus:
                firstVar = Double.parseDouble(tv_Result.getText().toString());
                isOperationClick = true;
                operation = "-";
                break;
            case R.id.multiply:
                firstVar = Double.parseDouble(tv_Result.getText().toString());
                isOperationClick = true;
                operation = "X";
                break;
            case R.id.division:
                firstVar = Double.parseDouble(tv_Result.getText().toString());
                isOperationClick = true;
                operation = "/";
                break;
            case R.id.equal:
                secondVar = Double.parseDouble(tv_Result.getText().toString());
                Double result = 0.0;
                switch (operation) {
                    case "+":
                        result = firstVar + secondVar;
                        tv_Result.setText(result.toString());
                        break;
                    case "-":
                        result = firstVar - secondVar;
                        tv_Result.setText(result.toString());
                        break;
                    case "X":
                        result = firstVar * secondVar;
                        tv_Result.setText(result.toString());
                        break;
                    case "/":
                        result = firstVar / secondVar;
                        tv_Result.setText(result.toString());
                        break;
                }
                isOperationClick = true;
        }

    }
}
