package com.example.famou.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText displayfield;
    Boolean dotexist = false;
    float num1 = 0.0f;
    String operateruse = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayfield = (EditText) findViewById(R.id.display);

    }

    public void gridbutton(View v){
        Button b = (Button) v;
        displayfield.append(b.getText());
    }

    public void Resetbutton (View v){
        displayfield.getText().clear();
        dotexist = false;  // important, or you cannot use it after
        displayfield.setHint("00000.00");
        operateruse = "";
    }

    public void DotClick(View v){
        if(dotexist == false){
            if(displayfield.getText().length() == 0){
                displayfield.append("0");
            }
            displayfield.append(".");
            dotexist = true;
        }

    }

    public void Operator(View v){
        if(displayfield.getText().length() == 0){
            Toast.makeText(getApplicationContext(), "No value enter", Toast.LENGTH_SHORT).show();
            return;
        }
        num1 = Float.parseFloat(displayfield.getText().toString());
        displayfield.setHint(displayfield.getText().toString());
        displayfield.getText().clear();
        dotexist = false;
        operateruse = ((Button)v).getText().toString();
        Toast.makeText(getApplicationContext(), operateruse, Toast.LENGTH_SHORT).show();

    }

    public void equalclick(View v){
        if(displayfield.getText().length() == 0){
            Toast.makeText(getApplicationContext(), "No value enter", Toast.LENGTH_SHORT).show();
            return;
        }
        float num2 = Float.parseFloat(displayfield.getText().toString());
        float total = 0.0f;

        switch (operateruse){
            case "+":
                total = num1 + num2;
                break;
            case "-":
                total = num1 - num2;
                break;
            case "X":
                total = num1 * num2;
                break;
            case "%":
                total = num1 / num2;
                break;
            default:
                Toast.makeText(getApplicationContext(), "You need to select operator", Toast.LENGTH_SHORT).show();
        }
        displayfield.setText(String.valueOf(total));
        displayfield.setHint(String.valueOf(total));
        displayfield.getText().clear();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart", Toast.LENGTH_SHORT).show();
    }
}
