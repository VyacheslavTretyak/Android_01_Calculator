package com.homework.android_01_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private Calculator calculator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) this.findViewById(R.id.textView);
        calculator = new Calculator(tv);

    }

    public void btnClick(View view){
        int id = view.getId();
        switch (id){
            case R.id.n1:
            case R.id.n2:
            case R.id.n3:
            case R.id.n4:
            case R.id.n5:
            case R.id.n6:
            case R.id.n7:
            case R.id.n8:
            case R.id.n9:
            case R.id.n0:
                calculator.addValue((Button) this.findViewById(id));
                break;
            case R.id.btnPlus:
                calculator.doOperation(Calculator.Operation.plus);
                break;
            case R.id.btnMinus:
                calculator.doOperation(Calculator.Operation.minus);
                break;
            case R.id.btnMult:
                calculator.doOperation(Calculator.Operation.mult);
                break;
            case R.id.btnDiv:
                calculator.doOperation(Calculator.Operation.div);
                break;
            case R.id.btnEqual:
                calculator.equal();
                break;
            default:
                tv.setText("HELLO");
        }
    }
}
