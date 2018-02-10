package com.example.ak.myapplication;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button b_new;
    Button button1, button2, button3,
            button4, button5, button6,
            button7, button8, button9,
            button10, button11, button12;
   // TextView cnttext= (TextView) findViewById(R.id.numbertext);
    List<Integer> buttons;
    int curLevel,curGuess,num=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_new = (Button) findViewById(R.id.b_new);
        button1 =  (Button) findViewById(R.id.button1);
        button2 =  (Button) findViewById(R.id.button2);
        button3 =  (Button) findViewById(R.id.button3);
        button4 =  (Button) findViewById(R.id.button4);
        button5 =  (Button) findViewById(R.id.button5);
        button6 =  (Button) findViewById(R.id.button6);
        button7 =  (Button) findViewById(R.id.button7);
        button8 =  (Button) findViewById(R.id.button8);
        button9 =  (Button) findViewById(R.id.button9);
        button10 =  (Button) findViewById(R.id.button10);
        button11 =  (Button) findViewById(R.id.button11);
        button12 =  (Button) findViewById(R.id.button12);

        button1.setTag(1);
        button2.setTag(2);
        button3.setTag(3);
        button4.setTag(4);
        button5.setTag(5);
        button6.setTag(6);
        button7.setTag(7);
        button8.setTag(8);
        button9.setTag(9);
        button10.setTag(10);
        button11.setTag(11);
        button12.setTag(12);

        disableButtons();

        buttons = new ArrayList<>();
        buttons.add(1);
        buttons.add(2);
        buttons.add(3);
        buttons.add(4);
        buttons.add(5);
        buttons.add(6);
        buttons.add(7);
        buttons.add(8);
        buttons.add(9);
        buttons.add(10);
        buttons.add(11);
        buttons.add(12);

        b_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b_new.setVisibility(View.INVISIBLE);
                curGuess = 0;
                curLevel=1;
                generateButtons(curLevel);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    buttonLogic(v);
         //            cnttext.setText(""+ num);
                ((Button) v).setBackgroundResource(R.drawable.doremon);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonLogic(v);
                ((Button) v).setBackgroundResource(R.drawable.doremon);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonLogic(v);
               // numbertext1.setText(""+ num;
                ((Button) v).setBackgroundResource(R.drawable.doremon);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonLogic(v);
              //  numbertext1.setText(""+ num;
                ((Button) v).setBackgroundResource(R.drawable.doremon);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonLogic(v);
              //  numbertext1.setText(""+ num;
                ((Button) v).setBackgroundResource(R.drawable.doremon);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonLogic(v);
              //  numbertext1.setText(""+ num;
                ((Button) v).setBackgroundResource(R.drawable.doremon);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonLogic(v);
             //   numbertext1.setText(""+ num;
                ((Button) v).setBackgroundResource(R.drawable.doremon);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonLogic(v);
              //  numbertext1.setText(""+ num;
                ((Button) v).setBackgroundResource(R.drawable.doremon);
            }
        });button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonLogic(v);
             //   numbertext1.setText(""+ num;
                ((Button) v).setBackgroundResource(R.drawable.doremon);
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonLogic(v);
               // numbertext1.setText(""+ num;
                ((Button) v).setBackgroundResource(R.drawable.doremon);
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonLogic(v);
             //   numbertext1.setText(""+ num;
                ((Button) v).setBackgroundResource(R.drawable.doremon);
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonLogic(v);
            //    numbertext1.setText(""+ num;
                ((Button) v).setBackgroundResource(R.drawable.doremon);
            }
        });

    }

    public void buttonLogic(View v){
        List<Integer> tempList = new ArrayList<>();
        for(int i=0; i<curLevel;i++){
            tempList.add(buttons.get(i));
        }
        if(tempList.contains(v.getTag())) {
            curGuess++;
            checkWin();
        }else{
            lostGame();
        }
    }

    private void checkWin(){
        if(curGuess==curLevel) {
            disableButtons();
            if (curLevel == 12) {
                Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show();
                b_new.setVisibility(View.VISIBLE);
            } else {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        curGuess = 0;
                        curLevel++;
                        num++;
                        generateButtons(curLevel);
                    }
                }, 1000);
            }
        }
    }

    private void lostGame(){
        Toast.makeText(this,"Fail", Toast.LENGTH_SHORT).show();
        disableButtons();
        b_new.setVisibility(View.VISIBLE);
    }

    private void  generateButtons(int number){
        button1.setBackgroundResource(R.drawable.blank);
        button2.setBackgroundResource(R.drawable.blank);
        button3.setBackgroundResource(R.drawable.blank);
        button4.setBackgroundResource(R.drawable.blank);
        button5.setBackgroundResource(R.drawable.blank);
        button6.setBackgroundResource(R.drawable.blank);
        button7.setBackgroundResource(R.drawable.blank);
        button8.setBackgroundResource(R.drawable.blank);
        button9.setBackgroundResource(R.drawable.blank);
        button10.setBackgroundResource(R.drawable.blank);
        button11.setBackgroundResource(R.drawable.blank);
        button12.setBackgroundResource(R.drawable.blank);

        Collections.shuffle(buttons);

        for(int i=0;i<number;i++){
            showButon(buttons.get(i));
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                button1.setBackgroundResource(R.drawable.blank);
                button2.setBackgroundResource(R.drawable.blank);
                button3.setBackgroundResource(R.drawable.blank);
                button4.setBackgroundResource(R.drawable.blank);
                button5.setBackgroundResource(R.drawable.blank);
                button6.setBackgroundResource(R.drawable.blank);
                button7.setBackgroundResource(R.drawable.blank);
                button8.setBackgroundResource(R.drawable.blank);
                button9.setBackgroundResource(R.drawable.blank);
                button10.setBackgroundResource(R.drawable.blank);
                button11.setBackgroundResource(R.drawable.blank);
                button12.setBackgroundResource(R.drawable.blank);

                enableButtons();
            }
        },3000);
    }
    private void showButon(int number){
        switch (number){
            case 1: button1.setBackgroundResource(R.drawable.doremon);
                    break;
            case 2: button2.setBackgroundResource(R.drawable.doremon);
                break;
            case 3: button3.setBackgroundResource(R.drawable.doremon);
                break;
            case 4: button4.setBackgroundResource(R.drawable.doremon);
                break;
            case 5: button5.setBackgroundResource(R.drawable.doremon);
                break;
            case 6: button6.setBackgroundResource(R.drawable.doremon);
                break;
            case 7: button7.setBackgroundResource(R.drawable.doremon);
                break;
            case 8: button8.setBackgroundResource(R.drawable.doremon);
                break;
            case 9: button9.setBackgroundResource(R.drawable.doremon);
                break;
            case 10: button10.setBackgroundResource(R.drawable.doremon);
                break;
            case 11: button11.setBackgroundResource(R.drawable.doremon);
                break;
            case 12: button12.setBackgroundResource(R.drawable.doremon);
                break;

        }
    }
    private void enableButtons(){
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
        button5.setEnabled(true);
        button6.setEnabled(true);
        button7.setEnabled(true);
        button8.setEnabled(true);
        button9.setEnabled(true);
        button10.setEnabled(true);
        button11.setEnabled(true);
        button12.setEnabled(true);
    }

    private void disableButtons(){
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
        button5.setEnabled(false);
        button6.setEnabled(false);
        button7.setEnabled(false);
        button8.setEnabled(false);
        button9.setEnabled(false);
        button10.setEnabled(false);
        button11.setEnabled(false);
        button12.setEnabled(false);
    }
}
