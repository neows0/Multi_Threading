package com.example.johnathan.multithreading;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;


/**
 * Created by Johnathan on 5/28/2016.
 */
public class Create extends AppCompatActivity implements Runnable {
    private Context context;

    public Create (Context con){
        context = con;
    }

    public void run() {

        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("Numbers.txt", Context.MODE_PRIVATE));
            for (int i = 0; i < 10; i++) {
                outputStreamWriter.write(Integer.toString(i) + '\n');
                try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                    }
            }
            outputStreamWriter.close();
        }
        catch (Exception e) {
            //Log.e("Exception", "File write failed: " + e.toString());
        }

        /*
        String filename = "Numbers.txt";
        String string;
        FileOutputStream outputStream;

        try {

            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
                for (int i = 0; i < 10; i++) {
                    string = Integer.toString(i);
                    outputStream.write(string.getBytes());
                    //try {
                    //    Thread.sleep(250);
                    //} catch (InterruptedException e) {
                    //}
                }

            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
