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
    private String timer = "0";
    private boolean first = true;
    private int k = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        keterangan = findViewById(R.id.keterangan);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

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
        if (k < 2) {
            k = 2;
        }
        else {
            k = 2;
            if (position == 0) {
                setTimer("30 minutes");
                toast = Toast.makeText(context, "You will be reminded in 30 minutes", duration);
            }
            else if (position == 1) {
                setTimer("1 hour");
                toast = Toast.makeText(context, "You will be reminded in 1 hour", duration);
            }
            else if (position == 2) {
                setTimer("1 hour 30 minutes");
                toast = Toast.makeText(context, "You will be reminded in 1 hour 30 minutes", duration);
            }
            else {
                setTimer("2 hour");
                toast = Toast.makeText(context, "You will be reminded in 2 hour", duration);
            }
            toast.show();
            first = true;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void setTimer(String time) {
        timer = time;
        Log.d("DEBUGTAG", time);
        if (time.equals("0") && first) {
            keterangan.setVisibility(View.INVISIBLE);
        }
        else {
            keterangan.setVisibility(View.VISIBLE);
            String placeholder = "You will be reminded in " + timer;
            keterangan.setText(placeholder);
        }
    }
}