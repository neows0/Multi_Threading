package com.example.johnathan.multithreading;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public Button CreateBut;
    public Button LoadBut;
    public Button ClearBut;
    public Button UpdateBut;

    private List<String> numbers = new ArrayList<String>();

    public void init() {
        CreateBut = (Button) findViewById(R.id.CreateBut);
        LoadBut =  (Button) findViewById(R.id.LoadBut);
        ClearBut =  (Button) findViewById(R.id.ClearBut);
        UpdateBut =  (Button) findViewById(R.id.UpdateBut);

        CreateBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Create writeFile = new Create (getApplicationContext());
                //writeFile.run();
                Thread one = new Thread (writeFile);
                one.start();
            }
        });
        LoadBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Load loadFile = new Load (numbers, getApplicationContext());
                //loadFile.run();
                Thread two = new Thread (loadFile);
                two.start();
            }
        });
        ClearBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers.clear();
                //numbers.add("Clear");
                TextView refrence = (TextView) findViewById(R.id.FileName);
                refrence.setText(numbers.toString());
            }
        });
        UpdateBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //numbers.clear();
                //numbers.add("Clear");
                TextView refrence = (TextView) findViewById(R.id.FileName);
                refrence.setText(numbers.toString());
            }
        });
        //TextView refrence = (TextView) findViewById(R.id.FileName);
        //refrence.setText(numbers.toString());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        //Create writeFile = new Create (getApplicationContext());
       // writeFile.run();
        //Load loadFile = new Load (numbers, getApplicationContext());
        //loadFile.run();
        //TextView refrence = (TextView) findViewById(R.id.FileName);
        //refrence.setText(numbers.toString());

        Create writeFile = new Create (getApplicationContext());
        Thread one = new Thread (writeFile);
        one.start();
        Load loadFile = new Load (numbers, getApplicationContext());
        Thread two = new Thread (loadFile);
        two.start();
        try {
            one.join();
            two.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //TextView refrence = (TextView) findViewById(R.id.FileName);
        //refrence.setText(numbers.toString());
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
