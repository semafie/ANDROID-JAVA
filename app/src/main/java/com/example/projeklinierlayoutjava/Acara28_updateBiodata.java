package com.example.projeklinierlayoutjava;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Acara28_updateBiodata extends AppCompatActivity {
    protected Cursor cursor;
    Acara28_2 dbthelper;
    Button ton1, ton2;
    EditText text1, text2, text3, text4, text5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acara28_update_biodata);
        dbthelper = new Acara28_2(this);
        text1 = (EditText) findViewById(R.id.editText1);
        text2 = (EditText) findViewById(R.id.editText2);
        text3 = (EditText) findViewById(R.id.editText3);
        text4 = (EditText) findViewById(R.id.editText4);
        text5 = (EditText) findViewById(R.id.editText5);
        SQLiteDatabase db = dbthelper.getReadableDatabase();
        cursor = db.rawQuery("select * from biodata where nama = '" +
                getIntent().getStringExtra("nama")+"'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0) {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
            text5.setText(cursor.getString(4).toString());
        }
        ton1 = (Button) findViewById(R.id.button1);
        ton2 = (Button) findViewById(R.id.button2);
        ton1.setOnClickListener((kocak)->{
            SQLiteDatabase dbe = dbthelper.getWritableDatabase();
            dbe.execSQL("update biodata set nama ='"+
                    text2.getText().toString()+"', tgl ='"+
                    text3.getText().toString()+"', jk ='"+
                    text4.getText().toString()+"', alamat ='"+
                    text5.getText().toString()+"'  where no ='"+
                    text1.getText().toString()+"';");
            Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
            Acara28.ma.RefreshList();
            finish();
        });
        ton2.setOnClickListener((kocak)->{
            finish();
        });
    }
}