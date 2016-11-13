package com.example.piotrek.firstapp;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SecondActivity  extends Activity implements View.OnClickListener {

    EditText number1;
    EditText number2;

    Button addButton;
    Button subButton;
    Button multButton;
    Button divButton;

    TextView resultView;

    String oper = "";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        // find the elements
        number1 = (EditText) findViewById(R.id.number1);
        number2 = (EditText) findViewById(R.id.number2);

        addButton = (Button) findViewById(R.id.btnAdd);
        subButton = (Button) findViewById(R.id.btnSub);
        multButton = (Button) findViewById(R.id.btnMult);
        divButton = (Button) findViewById(R.id.btnDiv);

        resultView = (TextView) findViewById(R.id.result);

        // set a listener
        addButton.setOnClickListener(this);
        subButton.setOnClickListener(this);
        multButton.setOnClickListener(this);
        divButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        // TODO Auto-generated method stub
        float num1 = 0;
        float num2 = 0;
        float result = 0;

        // check if the fields are empty
        if (TextUtils.isEmpty(number1.getText().toString())
                || TextUtils.isEmpty(number2.getText().toString())) {
            return;
        }

        // read EditText and fill variables with numbers
        num1 = Float.parseFloat(number1.getText().toString());
        num2 = Float.parseFloat(number2.getText().toString());

        // defines the button that has been clicked and performs the corresponding operation
        // write operation into oper, we will use it later for output
        switch (view.getId()) {
            case R.id.btnAdd:
                oper = "+";
                result = num1 + num2;
                break;
            case R.id.btnSub:
                oper = "-";
                result = num1 - num2;
                break;
            case R.id.btnMult:
                oper = "*";
                result = num1 * num2;
                break;
            case R.id.btnDiv:
                oper = "/";
                result = num1 / num2;
                break;
            default:
                break;
        }

        // form the output line
        resultView.setText(num1 + " " + oper + " " + num2 + " = " + result);
    }
}