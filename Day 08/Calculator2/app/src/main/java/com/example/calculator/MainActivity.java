package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView inputTxt;
    private TextView outPuttxt;

    private String currentInput = "";
    private String previousInput = "";
    private String operator = "";
    private boolean operatorSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputTxt = findViewById(R.id.inputTxt);
        outPuttxt = findViewById(R.id.outPuttxt);

        initializeButtons();
    }

    private void initializeButtons() {
        int[] buttonIds = {
                R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3,
                R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7,
                R.id.btn_8, R.id.btn_9, R.id.btn_plus, R.id.btn_minus,
                R.id.btn_multiplication, R.id.btn_module, R.id.btn_dot,
                R.id.btn_ac, R.id.btn_equal
        };

        for (int id : buttonIds) {
            findViewById(id).setOnClickListener(this::onButtonClick);
        }
    }

    private void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.btn_0:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
                handleNumber(((Button)view).getText().toString());
                break;

            case R.id.btn_dot:
                handleDot();
                break;

            case R.id.btn_plus:
            case R.id.btn_minus:
            case R.id.btn_multiplication:
            case R.id.btn_module:
                handleOperator(((Button)view).getText().toString());
                break;

            case R.id.btn_equal:
                handleEqual();
                break;

            case R.id.btn_ac:
                handleClear();
                break;
        }
    }

    private void handleNumber(String number) {
        if (operatorSelected) {
            currentInput += number;
            outPuttxt.setText(currentInput);
        } else {
            previousInput += number;
            outPuttxt.setText(previousInput);
        }
    }

    private void handleDot() {
        if (operatorSelected) {
            if (!currentInput.contains(".")) {
                currentInput += ".";
                outPuttxt.setText(currentInput);
            }
        } else {
            if (!previousInput.contains(".")) {
                previousInput += ".";
                outPuttxt.setText(previousInput);
            }
        }
    }

    private void handleOperator(String op) {
        if (!previousInput.isEmpty()) {
            operator = op;
            operatorSelected = true;
            inputTxt.setText(previousInput + " " + operator);
            outPuttxt.setText("0");
        }
    }

    private void handleEqual() {
        if (!previousInput.isEmpty() && !currentInput.isEmpty() && !operator.isEmpty()) {
            double result = calculateResult();
            inputTxt.setText(previousInput + " " + operator + " " + currentInput);
            outPuttxt.setText(String.valueOf(result));

            // Reset for next calculation
            previousInput = String.valueOf(result);
            currentInput = "";
            operator = "";
            operatorSelected = false;
        }
    }

    private double calculateResult() {
        double num1 = Double.parseDouble(previousInput);
        double num2 = Double.parseDouble(currentInput);

        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "%":
                if (num2 != 0) return num1 / num2;
                else return 0; // Handle divide by zero
            default:
                return 0;
        }
    }

    private void handleClear() {
        previousInput = "";
        currentInput = "";
        operator = "";
        operatorSelected = false;
        inputTxt.setText("");
        outPuttxt.setText("0");
    }
}
