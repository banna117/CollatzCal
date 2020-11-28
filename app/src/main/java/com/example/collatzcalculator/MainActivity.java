package com.example.collatzcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int collatNum = 0;
    Button startBtn = null;
    EditText collatz = null;
    TextView result = null;
    String res = "";
    String ziro = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = (Button) findViewById(R.id.startBtn);
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
                        break;
                    }
                    else {
                        result.setText("");
                        collatNum = Integer.parseInt(collatz.getText().toString());
                        res += String.valueOf(collatNum);
                        while (collatNum != 1) {
                            if (collatNum % 2 == 1) {
                                collatNum = collatNum * 3 + 1;
                                res += " - ";
                                res += String.valueOf(collatNum);
                            } else {
                                collatNum = collatNum / 2;
                                res += " - ";
                                res += String.valueOf(collatNum);
                            }
                        }
                        result.setText(res);
                        res="";
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