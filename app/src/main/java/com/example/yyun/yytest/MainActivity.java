package com.example.yyun.yytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter<String> mAdapter;
    private ArrayList<String> Options;

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


        Button btnspinner=(Button)findViewById(R.id.btn_changespinner);
        final Spinner spinner=(Spinner)findViewById(R.id.spinner);

        btnspinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Options = new ArrayList<String>();
                Options.add("");
                Options.add("1");
                Options.add("2");
                Options.add("3");
                Options.add("4");
                Options.add("5");
                mAdapter = new ArrayAdapter<String>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, Options);
                spinner.setAdapter(mAdapter);
            }
        });


    }
}
