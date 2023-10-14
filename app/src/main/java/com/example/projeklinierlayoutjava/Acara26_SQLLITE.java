package com.example.projeklinierlayoutjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Acara26_SQLLITE extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acara26_sqllite);
        editText = findViewById(R.id.editText2);

    }
    public void next(View view){
        Intent intent = new Intent(Acara26_SQLLITE.this, Acara26_2.class);
        startActivity(intent);
    }
    public void savePublic(View view) {
        String info = editText.getText().toString();

        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File myFile = new File(folder,"myDataa.txt");
        writeData(myFile, info);
        editText.setText("");
    }

    public void savePrivate(View view) {
        String info = editText.getText().toString();
        File folder = getExternalFilesDir("arvita");
        File myFile = new File(folder,"myData2.txt");
        writeData(myFile, info);
        editText.setText("");
    }

    private void writeData(File myFile, String data) {
        FileOutputStream fileOutputStream = null;
        try {
            System.out.println("TES");
            fileOutputStream= new FileOutputStream(myFile);
            fileOutputStream.write(data.getBytes());
            Toast.makeText(this,"Done" + myFile.getAbsolutePath(), Toast.LENGTH_SHORT).show();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch ( IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}