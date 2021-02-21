package com.example.guessingnumbergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int num1, num2, points;
    private Button buttonLeft, buttonRight;
    private TextView pointsTxt;

    private void check(int a, int b) {
        if (a > b) {
            points++;
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            points--;
            Toast.makeText(this, "You are stupid...", Toast.LENGTH_SHORT).show();
        }

        pointsTxt.setText("Points: " + points);
        roll();
    }

    private void roll() {
        //picking 2 random numbers
        Random r = new Random();
        num1 = r.nextInt(9);
        num2 = r.nextInt(9);

        while (num2 == num1) {
            num2 = r.nextInt(9);
        }

        //set the buttons to display random numbers

        buttonLeft.setText(String.valueOf(num1));
        buttonRight.setText(String.valueOf(num2));
    }

    //This method is called by Android when our activity is first created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pointsTxt = findViewById(R.id.pointsTextView);

        buttonLeft = findViewById(R.id.buttonLeft);
        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(num1, num2);
            }
        });

        buttonRight = findViewById(R.id.buttonRight);
        buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(num2, num1);
            }
        });
        roll();
    }
}