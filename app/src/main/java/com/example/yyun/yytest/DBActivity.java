package com.example.yyun.yytest;

import android.app.ListActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DBActivity extends ListActivity {

    SimpleCursorAdapter adapter;

    EditText inputdata;
    Button btnSave,btnRead;
    DBScheme db;
    SQLiteDatabase dbRead,dbWrite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        db=new DBScheme(this);

        dbRead= db.getReadableDatabase();
        dbWrite=db.getWritableDatabase();

        adapter=new SimpleCursorAdapter(this,R.layout.data_cell,null,new String[]{"_id","uid","contextdata","createtime","changetime","gps","status"},new int[]{R.id.tv_id,R.id.tv_uid,R.id.tv_context_data,R.id.tv_create_time,R.id.tv_change_time,R.id.tv_gps,R.id.tv_status});
        setListAdapter(adapter);

        refreshListView();

        inputdata=(EditText)findViewById(R.id.input_data);
        btnSave=(Button)findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cv=new ContentValues();
                cv.put("contextdata",inputdata.getText().toString());
                cv.put("createtime",getCurdate());
                dbWrite.insert("testtable",null,cv);
                refreshListView();
            }
        });

    }

    private void refreshListView(){
        Cursor c=dbRead.query("testtable",null,null,null,null,null,null);
        adapter.changeCursor(c);
    }
    private String getCurdate(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss ");
        Date curDate = new Date(System.currentTimeMillis());
        String str = formatter.format(curDate);
        return str;
    }

}
