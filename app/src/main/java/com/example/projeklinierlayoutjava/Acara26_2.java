package com.example.projeklinierlayoutjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;

public class Acara26_2 extends AppCompatActivity {
    TextView showtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acara262);
        showtext = (TextView) findViewById(R.id.getText);
    }

    public void Back(View  view){
        Intent intent = new Intent(Acara26_2.this, Acara26_SQLLITE.class);
        startActivity(intent);
    }

    public void getPublic(View view){
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File myFile = new File(folder, "myDataa.txt");
        String text = getData(myFile);
        if(text != null){
            showtext.setText(text);
        } else {
            showtext.setText("NO DATA");
        }
    }

    public void getPrivate(View view){
        File folder = getExternalFilesDir("arvita");
        File myFile = new File(folder, "myData2.txt");
        String text = getData(myFile);
        if(text != null){
            showtext.setText(text);
        } else {
            showtext.setText("NO DATA");
        }
    }

    private String getData(File myFile) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(myFile);
            int i = -1;
            StringBuffer buffer = new StringBuffer();
            while ((i = fileInputStream.read()) != -1) {
                buffer.append((char) i);
            }
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}