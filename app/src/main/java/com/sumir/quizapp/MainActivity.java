package com.sumir.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button trueButton = findViewById(R.id.trueButton);
        Button falseButton = findViewById(R.id.falseButton);
        TextView quesText = findViewById(R.id.my_ques_text);

        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.falseButton:
                Toast.makeText(MainActivity.this,"False", Toast.LENGTH_SHORT).show();
                break;
            case R.id.trueButton:
                Toast.makeText(MainActivity.this,"True", Toast.LENGTH_SHORT).show();
                break;

        }

    }
}
