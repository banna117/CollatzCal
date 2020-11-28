package com.example.collatzcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    long collatNum = 0;
    int stages = 1;

    Button startBtn = null;
    EditText stageNum = null;
    EditText collatz = null;
    TextView numOfStages = null;
    TextView result = null;
    String res = "";
    String ziro = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = (Button) findViewById(R.id.startBtn);
        stageNum = (EditText) findViewById(R.id.stageNum);
        numOfStages = (TextView) findViewById(R.id.stage);
        collatz = (EditText) findViewById(R.id.collatzNum);
        result = (TextView) findViewById(R.id.result);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.startBtn : {
                try{
                    if(collatz.getText().toString().equals(ziro)){
                        Toast.makeText(getApplicationContext(), "숫자를 입력해주세요!", Toast.LENGTH_LONG).show();
                        result.setText("");
                        stageNum.setText("0");
                        break;
                    }
                    else if(collatz.getText().toString().equals("0")){
                        Toast.makeText(getApplicationContext(), "0보다 큰 수를 입력해주세요!", Toast.LENGTH_LONG).show();
                        result.setText("");
                        stageNum.setText("0");
                        break;
                    }
                    else {
                        result.setText("");
                        collatNum = Long.parseLong(collatz.getText().toString());
                        res += String.valueOf(collatNum);
                        while (collatNum != 1) {
                            if (collatNum % 2 == 1) {
                                collatNum = collatNum * 3 + 1;
                                res += " - ";
                                res += String.valueOf(collatNum);
                                stages+=1;
                            } else {
                                collatNum = collatNum / 2;
                                res += " - ";
                                res += String.valueOf(collatNum);
                                stages+=1;
                            }
                        }
                        result.setText(res);
                        stageNum.setText(String.valueOf(stages));
                        res="";
                        stages=1;
                        break;
                    }

                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

    }
}