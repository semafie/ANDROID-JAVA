package com.example.projeklinierlayoutjava;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Button;
import android.widget.EditText;

import com.example.projeklinierlayoutjava.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Acara9_1_Linearlayout extends AppCompatActivity {
    private EditText editTextDate;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    EditText to, subject, message;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acara9_1_linearlayout);

        to = findViewById(R.id.to);
        subject = findViewById(R.id.subject);
        message = findViewById(R.id.message);
        send = findViewById(R.id.send);

        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker();
            }
        });
    }
    private void showDatePicker() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, monthOfYear);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        String selectedDate = dateFormat.format(calendar.getTime());
                        editTextDate.setText(selectedDate);
                    }
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }
        private void openCalendar() {
            Intent calendarIntent = new Intent(Intent.ACTION_VIEW);
            calendarIntent.setType("vnd.android.cursor.item/event");
            startActivity(calendarIntent);
        }

}