package com.example.time_date;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;


public class MainActivity extends AppCompatActivity {
    String[] Colors={"20 grams(appx.)","30 grams(appx.)","40 grams(appx.)"};
    String colorSelected;
    TextView textDateandTime;
    Button btnDateandTime;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textDateandTime = findViewById(R.id.textDateandTime);
        btnDateandTime = findViewById(R.id.btnDateandTime);

        btnDateandTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
                TextView tdate = (TextView) findViewById(R.id.textDateandTime);
                long date = System.currentTimeMillis();
                SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy, hh:mm:ss a");
                String dateString = sdf.format(date);
                tdate.setText(dateString);
            }

            private void showDialog() {
                colorSelected = Colors[0];
                androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Choose Amount");
                builder.setSingleChoiceItems(Colors, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        colorSelected = Colors[i];
                    }
                });
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "selected: " + colorSelected, Toast.LENGTH_LONG).show();

                    }
                });
                builder.setNegativeButton("Cancel",null);
                builder.show();
            }
        });

    }
}