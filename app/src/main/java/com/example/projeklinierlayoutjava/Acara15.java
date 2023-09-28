package com.example.projeklinierlayoutjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;


import android.os.Bundle;

import java.util.ArrayList;

public class Acara15 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MahasiswaAdapter adapter;
    private ArrayList<Mahasiswa> mahasiswaArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acara15);
        addData();
        recyclerView =(RecyclerView) findViewById(R.id.recycle_view);
        adapter = new MahasiswaAdapter(mahasiswaArrayList);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Acara15.this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
    }
    void addData(){
        mahasiswaArrayList = new ArrayList<>();
        mahasiswaArrayList.add(new Mahasiswa("Dimas Maulana","1414370309","123456789"));
        mahasiswaArrayList.add(new Mahasiswa("Fadly Yonk","1214234560","987654321"));
        mahasiswaArrayList.add(new Mahasiswa("Ariyandi Nugraha","1214230345","987648765"));
        mahasiswaArrayList.add(new Mahasiswa("Aham Siswandi","1214378098","098758124"));
    }
}