package com.example.yyun.yytest;

import android.Manifest;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class FileActivity extends BaseActivity {

    File sdcard = Environment.getExternalStorageDirectory();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        Button btn_saveFile = (Button) findViewById(R.id.btn_savefile);
        Button btn_readFile = (Button) findViewById(R.id.btn_readfile);


        final EditText editText = (EditText) findViewById(R.id.editfile);
        final TextView showfile = (TextView) findViewById(R.id.showfile);


        btn_saveFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File myfile = new File(sdcard, "testFile.txt");
                if (!sdcard.exists()) {
                    Toast.makeText(FileActivity.this, "no sd card", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    requestPermission(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0x0001);
                    myfile.createNewFile();

                    FileOutputStream fos = new FileOutputStream(myfile);
                    OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
                    osw.write(editText.getText().toString());
                    osw.flush();
                    osw.close();
                    fos.close();
                    Toast.makeText(FileActivity.this, "success", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(FileActivity.this, "error card", Toast.LENGTH_SHORT).show();
                }


            }
        });

        btn_readFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File myfile = new File(sdcard, "testFile.txt");
                if (myfile.exists()) {
                    FileInputStream fis = null;
                    try {
                        fis = new FileInputStream(myfile);
                        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
                        char[] input = new char[fis.available()];
                        isr.read(input);
                        String inString = new String(input);
                        isr.close();
                        fis.close();

                        showfile.setText(inString);

                        Toast.makeText(FileActivity.this, "success", Toast.LENGTH_SHORT).show();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }


            }
        });

    }


    public class saveFileTask extends AsyncTask<String, Integer, String> {
        @Override
        protected String doInBackground(String... strings) {
            return null;
        }
    }
}