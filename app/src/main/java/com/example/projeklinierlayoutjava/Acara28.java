package com.example.projeklinierlayoutjava;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class Acara28 extends AppCompatActivity {
    String[] daftar;
    ListView listView01;
    Menu menu;
    protected Cursor cursor;
    Acara28_2 dbcenter;
    public static Acara28 ma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acara28);

        Button btn =(Button) findViewById(R.id.Button2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(Acara28.this, Acara28_buatBiodata.class);
                startActivity(inte);
            }
        });

        ma = this;
        dbcenter = new Acara28_2(this);
        RefreshList();
    }

    public void RefreshList() {
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("Select * from biodata", null);
        daftar = new String [cursor.getCount()];
        for (int cc= 0; cc< cursor.getCount();cc++){
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(1).toString();
        }
        listView01 = (ListView) findViewById(R.id.Listview1);
        listView01.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1,daftar));
        listView01.setSelected(true);
        listView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final String selection = daftar[i];
                final CharSequence[] dialogitem = {"Lihat Biodata", "Update biodata", "Hapus Biodata"};
                AlertDialog.Builder builder = new AlertDialog.Builder(Acara28.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                    switch (item) {
                        case 0:
                            Intent i = new Intent(getApplicationContext(), Acara28_lihatBiodata.class);
                            i.putExtra("nama",selection);
                            startActivity(i);
                            break;
                        case 1:
                            Intent in = new Intent(getApplicationContext(), Acara28_updateBiodata.class);
                            in.putExtra("nama",selection);
                            startActivity(in);
                            break;
                        case 2:
                            SQLiteDatabase db = dbcenter.getWritableDatabase();
                            db.execSQL("delete from biodata where nama = '"+selection+"'");
                            RefreshList();
                            break;
                    }
                    }
                });
                builder.create().show();
            }
        });
        ((ArrayAdapter)listView01.getAdapter()).notifyDataSetInvalidated();
    }
}