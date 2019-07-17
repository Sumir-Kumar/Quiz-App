package com.sumir.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton nextButton;
    private TextView quesText;
    private int currentIndex=0;
    private int temp;
    private ImageButton previousButton;

    private Questions[] questionBank;

    {
        questionBank = new Questions[]{
                new Questions(R.string.question_amendments, false), //correct: 27
                new Questions(R.string.question_constitution, true),
                new Questions(R.string.question_declaration, true),
                new Questions(R.string.question_independence_rights, true),
                new Questions(R.string.question_religion, true),
                new Questions(R.string.question_government, false),
                new Questions(R.string.question_government_feds, false),
                new Questions(R.string.question_government_senators, true),
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button trueButton = findViewById(R.id.trueButton);
        Button falseButton = findViewById(R.id.falseButton);
        quesText = findViewById(R.id.my_ques_text);
        nextButton=findViewById(R.id.nextButton);
        previousButton=findViewById(R.id.previousButton);

        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        previousButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.falseButton:
                checkAnswer(false);
                //Toast.makeText(MainActivity.this,"False", Toast.LENGTH_SHORT).show();
                break;
            case R.id.trueButton:
                checkAnswer(true);
                //Toast.makeText(MainActivity.this,"True", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nextButton:
                updateQuestion();
                break;
            case R.id.previousButton:
                previousQuestion();
                break;


        }

    }

    private void previousQuestion() {

        currentIndex=((currentIndex-1)% questionBank.length);
        temp=Math.abs(currentIndex);
        Log.d("current" , "onClick:"+temp);
        quesText.setText(questionBank[temp].getAnsResId());

    }

    private void updateQuestion() {
        currentIndex=(Math.abs(currentIndex)+1)% questionBank.length;
        Log.d("current" , "onClick:"+currentIndex);
        quesText.setText(questionBank[currentIndex].getAnsResId());
    }


    private void checkAnswer(boolean answerIsTrue){
        if (answerIsTrue==questionBank[currentIndex].isTrueAns()){
            Toast.makeText(MainActivity.this,R.string.correct_answer, Toast.LENGTH_SHORT).show();
            updateQuestion();
        }
        else{
            Toast.makeText(MainActivity.this,R.string.wrong_answer, Toast.LENGTH_SHORT).show();
        }




    }
}
