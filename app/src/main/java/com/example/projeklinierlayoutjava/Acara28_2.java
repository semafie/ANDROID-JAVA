package com.example.projeklinierlayoutjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Acara28_2 extends SQLiteOpenHelper {
    private static final String Database_NAME = "biodata_diri.db";
    private static  final int Database_VERSION = 1;
    public Acara28_2(Context context) {
        super(context, Database_NAME, null , Database_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        String sql =  "create table biodata (no integer primary key, nama text null, tgl text null, jk text null, alamat text null);";
        Log.d("Data", "onCreate: "+ sql);
        DB.execSQL(sql);
        sql = "insert into biodata(no, nama, tgl, jk, alamat) values ('1', 'Darmawan', '1996-07-12', 'Laki-Laki', 'Indramayu');";
        DB.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase kocak, int i, int i1) {

    }
}