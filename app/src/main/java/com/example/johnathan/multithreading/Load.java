package com.example.johnathan.multithreading;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Johnathan on 5/28/2016.
 */
public class Load extends AppCompatActivity implements Runnable {

    private List<String> numbers;
    private Context context;

    public Load(List<String> numb, Context con){
        numbers = numb;
        context = con;
    }

    public void run() {
        /*
        String ret = "";

        try {
            InputStream inputStream = openFileInput("Numbers.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
                numbers.add(ret);
            }
        }
        catch (Exception e) {
            numbers.add("Exeption thrown" + e.toString());
            //Log.e("login activity", "File not found: " + e.toString());
        } //catch (IOException e) {
            //Log.e("login activity", "Can not read file: " + e.toString());
        //}

    }*/

        String filename = "Numbers.txt";
        String string;
        //numbers.add("One");
        try {

            Thread.sleep(250);
            FileInputStream inputStream = context.openFileInput(filename);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            StringBuffer sBuffer = new StringBuffer();

            while((string = reader.readLine()) != null) {
                numbers.add(string);
            }

            inputStream.close();
        } catch (Exception e) {
            numbers.add("Exeption thrown" + e.toString());
            e.printStackTrace();
        }
    }
    //InputStream iS = resources.getAssets().open("bla.txt");
    //BufferedReader reader = new BufferedReader(new InputStreamReader(iS));


}
