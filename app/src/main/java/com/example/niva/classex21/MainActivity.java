package com.example.niva.classex21;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button cmdCounter, cmdChangeColor;
    private TextView lblCountRes;
    private int counter;
    private final String TAG = getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter = 0;
        cmdCounter = (Button)findViewById(R.id.button);
        cmdChangeColor = (Button)findViewById(R.id.button2);
        lblCountRes = (TextView)findViewById(R.id.textView);

        cmdCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                setLable();
            }
        });

        cmdCounter.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                counter = 0;
                setLable();
                return true;
            }
        });
        cmdChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cmdCounter.setBackgroundColor(randomColor());
                lblCountRes.setBackgroundColor(randomColor());
                cmdChangeColor.setBackgroundColor(randomColor());
            }
        });
    }

    private int randomColor(){
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    private void setLable(){
        lblCountRes.setText(counter + " Presses");
    }
}
