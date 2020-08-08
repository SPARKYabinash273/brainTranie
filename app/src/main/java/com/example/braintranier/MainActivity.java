package com.example.braintranier;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button;
    Button button0; Button button1; Button button2; Button button3;
    int loc;
    TextView sumTextView;
    TextView res;
    int scor=0;
    int numOfQns=0;
    TextView scoreTextView;
    TextView timerr;
    Button play;
    ArrayList<Integer> answers= new ArrayList<Integer>();

public void playAgain(View view){
    scor=0;
    numOfQns=0;
    timerr.setText("30s");
    newQns();
    scoreTextView.setText(Integer.toString(scor)+"/"+Integer.toString(numOfQns));
    play.setVisibility(View.INVISIBLE);
    new CountDownTimer(30100,1000){

        @Override
        public void onTick(long millisUntilFinished) {
            timerr.setText(String.valueOf(millisUntilFinished/1000)+"s");
        }

        @Override
        public void onFinish() {
            res.setText("Done!");
            play.setVisibility(View.VISIBLE);

        }
    }.start();

}
    public void chooseAnswer(View view){

        if (Integer.toString(loc).equals(view.getTag().toString())){
          //  Log.i("correct!", "You got It ");
            res.setText("Correct!!");
            scor++;
        }else{
            res.setText("Wrong :/");
        }
        numOfQns++;
        scoreTextView.setText(Integer.toString(scor)+"/"+Integer.toString(numOfQns));
        newQns();
    }
    public void start(View view){
        button.setVisibility(View.INVISIBLE);
        playAgain(findViewById(R.id.timer));
    }
    public void newQns(){  Random rand=new Random();
        int a=rand.nextInt(21);
        int b=rand.nextInt(21);

        sumTextView.setText(Integer.toString(a) + " + " +Integer.toString(b));
        loc=rand.nextInt(4);
answers.clear();
        for(int i=0;i<4;i++){
            if (i==loc){
                answers.add(a+b);}
            else{
                int wrong=rand.nextInt(41);
                while(wrong==a+b){
                    wrong=rand.nextInt(41);}

                answers.add(wrong);
            }
        }
        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         button0=findViewById(R.id.button);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        res=findViewById(R.id.result);
        timerr=findViewById(R.id.timer);
        scoreTextView=findViewById(R.id.score);
        play=findViewById(R.id.button4);

        button=findViewById(R.id.go);
        sumTextView=findViewById(R.id.calculation);

button.setVisibility(View.VISIBLE);
    }
}
