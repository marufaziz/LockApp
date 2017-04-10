package com.example.sami.lockscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonZero;
    private Button buttonOne;
    private Button buttonTwo;
    private Button buttonThree;
    private Button buttonFour;
    private Button buttonFive;
    private Button buttonSix;
    private Button buttonSeven;
    private Button buttonEight;
    private Button buttonNine;


    private TextView pin;
    private String pinId = "";

    private static final int MAX_PIN_SIZE = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialise();

        applyOnClick();

    }

    private void initialise () {
        buttonZero = (Button) findViewById(R.id.button0);
        buttonOne = (Button) findViewById(R.id.button1);
        buttonTwo = (Button) findViewById(R.id.button2);
        buttonThree = (Button) findViewById(R.id.button3);
        buttonFour = (Button) findViewById(R.id.button4);
        buttonFive = (Button) findViewById(R.id.button5);
        buttonSix = (Button) findViewById(R.id.button6);
        buttonSeven = (Button) findViewById(R.id.button7);
        buttonEight = (Button) findViewById(R.id.button8);
        buttonNine = (Button) findViewById(R.id.button9);
        pin = (TextView) findViewById(R.id.pin);
    }

    private void applyOnClick() {

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pinId.length() >= 4) return;

                String value = ((Button) view).getText().toString();
                pinId += value;
                pin.append("*  ");

                int pinSize = pin.getText().length();
                if (pinSize >= MAX_PIN_SIZE) {
                    if (!pinId.equals("1234")){
                        pinId ="";
                        pin.setText("");
                        return;
                    }
                    Intent i = new Intent(MainActivity.this, Unlocked.class);
                    startActivity(i);
                    finish();
                    return;
                }


            }
        };

        buttonZero.setOnClickListener(listener);
        buttonOne.setOnClickListener(listener);
        buttonTwo.setOnClickListener(listener);
        buttonThree.setOnClickListener(listener);
        buttonFour.setOnClickListener(listener);
        buttonFive.setOnClickListener(listener);
        buttonSix.setOnClickListener(listener);
        buttonSeven.setOnClickListener(listener);
        buttonEight.setOnClickListener(listener);
        buttonNine.setOnClickListener(listener);

    }
}
