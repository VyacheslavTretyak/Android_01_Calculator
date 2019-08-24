package com.homework.android_01_calculator;

import android.widget.Button;
import android.widget.TextView;

public class Calculator {

    public enum Operation{
        plus,
        minus,
        mult,
        div
    }

    private TextView tv;
    private boolean isOperation = false;
    private Operation lastOperation = null;
    private int firstNumber = 0;

    public Calculator(TextView tv){
        this.tv = tv;
    }

    public void addValue(Button btn){
        String str = tv.getText().toString();
        if(str.equals("0") || isOperation){
            str = "";
        }
        str+=btn.getText().toString();
        tv.setText(str);
        isOperation = false;
    }
    public void doOperation(Operation operation){
        if (isOperation) {
            lastOperation = operation;
            return;
        }
        if(lastOperation != null){
            switch (lastOperation){
                case plus:
                    firstNumber += getNumber();
                    break;
                case minus:
                    firstNumber -= getNumber();
                    break;
                case mult:
                    firstNumber *= getNumber();
                    break;
                case div:
                    firstNumber /= getNumber();
                    break;
            }
        }else{
            firstNumber = getNumber();
        }
        lastOperation = operation;
        isOperation = true;
        setText(firstNumber);

    }
    private void setText(int num){
        tv.setText(Integer.toString(num));
    }

    public void equal(){
        if(lastOperation == null){
            return;
        }
        switch (lastOperation){
            case plus:
                firstNumber += getNumber();
                break;
            case minus:
                firstNumber -= getNumber();
                break;
            case mult:
                firstNumber *= getNumber();
                break;
            case div:
                firstNumber /= getNumber();
                break;
        }
        lastOperation = null;
        isOperation = true;
        setText(firstNumber);
        firstNumber = 0;
    }
    private int getNumber(){
        return Integer.parseInt(tv.getText().toString());
    }
}
