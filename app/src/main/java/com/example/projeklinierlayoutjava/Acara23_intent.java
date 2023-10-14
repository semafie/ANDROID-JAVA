package com.example.projeklinierlayoutjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.Key;

public class Acara23_intent extends AppCompatActivity {
    EditText name;
    Button btnsend;
    private String KEY_Name = "NAMA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acara23_intent);
        name = (EditText) findViewById(R.id.edt_nama);
        btnsend = (Button) findViewById(R.id.btn_send);
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String nama = name.getText().toString();
                    if (!nama.isEmpty()) {
                        Intent i = new Intent(Acara23_intent.this, Acara23_2.class);
                        i.putExtra(KEY_Name, nama);
                        startActivity(i);

                    }else {
                        Toast.makeText(getApplication(),"KAMU HARUS MENULISKAN NAMAMU",Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplication(), "ERROR, TRY AGAIN", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}