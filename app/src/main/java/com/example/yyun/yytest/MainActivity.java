package com.example.yyun.yytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btntext=(Button)findViewById(R.id.btn_changetextview);
        final TextView textView=(TextView)findViewById(R.id.textView);

        btntext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Hello! Hello! Hello!");
            }
        });


        Button btnspinner=(Button)findViewById(R.id.btn_changetextview);
        final Spinner spinner=(Spinner)findViewById(R.id.spinner);

        btnspinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
