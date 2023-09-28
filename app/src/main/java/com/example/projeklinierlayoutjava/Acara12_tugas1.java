package com.example.projeklinierlayoutjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Acara12_tugas1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acara12_tugas1);
        Button acara9 = findViewById(R.id.circularButton1);
        acara9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenta = new Intent(Acara12_tugas1.this, Acara9_1_Linearlayout.class);
                startActivity(intenta);

            }
        });
        Button acara9_2 = findViewById(R.id.circularButton2);
        acara9_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenta = new Intent(Acara12_tugas1.this, Acara9_2_RelativeLayout.class);
                startActivity(intenta);

            }
        });
        Button acara10_1 = findViewById(R.id.circularButton3);
        acara10_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenta = new Intent(Acara12_tugas1.this, Acara10_1.class);
                startActivity(intenta);

            }
        });
        Button acara10_2 = findViewById(R.id.circularButton4);
        acara10_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenta = new Intent(Acara12_tugas1.this, acara10_2_FrameLayout.class);
                startActivity(intenta);

            }
        });
        Button acara11_1 = findViewById(R.id.circularButton5);
        acara11_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenta = new Intent(Acara12_tugas1.this, Acara11_1_TableLayout.class);
                startActivity(intenta);

            }
        });
        Button acara11_2 = findViewById(R.id.circularButton6);
        acara11_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenta = new Intent(Acara12_tugas1.this, Acara11_2_materialdesign.class);
                startActivity(intenta);

            }
        });
        Button acara12_1 = findViewById(R.id.circularButton7);
        acara12_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenta = new Intent(Acara12_tugas1.this, Acara12_1_ScroolView.class);
                startActivity(intenta);

            }
        });
        Button acara12_2 = findViewById(R.id.circularButton8);
        acara12_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenta = new Intent(Acara12_tugas1.this, Acara12_2_Horizontal_scrollView.class);
                startActivity(intenta);

            }
        });

    }
}