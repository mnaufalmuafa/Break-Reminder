package com.example.breakreminder;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView keterangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        keterangan = findViewById(R.id.keterangan);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast;

        if (position == 0) {
            keterangan.setText("You will be reminded in 30 minutes");
            toast = Toast.makeText(context, "You will be reminded in 30 minutes", duration);
        }
        else if (position == 1) {
            keterangan.setText("You will be reminded in 1 hour");
            toast = Toast.makeText(context, "You will be reminded in 1 hour", duration);
        }
        else if (position == 2) {
            keterangan.setText("You will be reminded in 1 hour 30 minutes");
            toast = Toast.makeText(context, "You will be reminded in 1 hour 30 minutes", duration);
        }
        else {
            keterangan.setText("You will be reminded in 2 hour");
            toast = Toast.makeText(context, "You will be reminded in 2 hour", duration);
        }
        toast.show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}