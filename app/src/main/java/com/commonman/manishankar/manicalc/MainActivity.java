package com.commonman.manishankar.manicalc;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    ArrayList<String> arraylist = new ArrayList<String>();
    String string = "";
    String string1 = "";

    public void onClick1(View v) {

        TextView textview2 = (TextView) findViewById(R.id.textView2);
        Button button = (Button) v;
        string = (String) button.getText().toString();
        if (!string.contains("+") && !string.contains("-") && !string.contains("*") && !string.contains("/")) {
            string1 = string1 + string;
            if (arraylist.size() > 0) {
                arraylist.remove(arraylist.size() - 1);
            }
            arraylist.add(string1);
        } else {
            arraylist.add(string);
            arraylist.add(string);
            string1 = "";
        }
        textview2.setText(textview2.getText().toString() + string);
        //textview2.setText(arraylist.toString());
    }

    public void clear(View v) {
        TextView textview1 = (TextView) findViewById(R.id.textView);
        TextView textview2 = (TextView) findViewById(R.id.textView2);
        string = "";
        string1 = "";
        textview1.setText("0");
        textview2.setText("");
        arraylist.clear();
    }

    public void onClick2(View v) {
        TextView textview1 = (TextView) findViewById(R.id.textView);
     //   if(!(textview1.getText()=="ans")){
        int calc = Integer.parseInt(arraylist.get(0));
        int c = arraylist.size();
        while (c != 1) {calc=0;
            if (c > 3) {
                if (arraylist.get(3).contains("*") || arraylist.get(3).contains("/")) {
                    if (arraylist.get(3).contains("*")) {
                        calc = Integer.parseInt(arraylist.get(2)) * Integer.parseInt(arraylist.get(4));
                    }
                   /* if(arraylist.get(3).contains("/")) {
                        try {
                            calc = Integer.parseInt(arraylist.get(2)) / Integer.parseInt(arraylist.get(4));
                        } catch (Exception e) {textview1.setText("cannot divide");
                        }
                    }*/
                    if (arraylist.get(3).contains("/")) {
                        calc = Integer.parseInt(arraylist.get(2)) / Integer.parseInt(arraylist.get(4));
                    }
                    arraylist.remove(2);
                    arraylist.remove(2);
                    arraylist.remove(2);
                    arraylist.add(2, Integer.toString(calc));
                    c = arraylist.size();
                } else {
                    if (arraylist.get(1).contains("*")) {
                        calc = Integer.parseInt(arraylist.get(0)) * Integer.parseInt(arraylist.get(2));
                    }
                    if (arraylist.get(1).contains("+")) {
                        calc = Integer.parseInt(arraylist.get(0)) + Integer.parseInt(arraylist.get(2));
                    }
                    if (arraylist.get(1).contains("-")) {
                        calc = Integer.parseInt(arraylist.get(0)) - Integer.parseInt(arraylist.get(2));
                    }
                    /*if(arraylist.get(1).contains("*")){{
                        try {
                            calc = Integer.parseInt(arraylist.get(0)) / Integer.parseInt(arraylist.get(1));
                        } catch (Exception e) {textview1.setText("cannot divide");
                        }
                    }}*/
                    if (arraylist.get(1).contains("/")) {calc = Integer.parseInt(arraylist.get(0)) / Integer.parseInt(arraylist.get(2));}
                    arraylist.remove(0);
                    arraylist.remove(0);
                    arraylist.remove(0);
                    arraylist.add(0, Integer.toString(calc));
                    c = arraylist.size();
                }
            } else {
                if (arraylist.get(1).contains("*")) {
                    calc = Integer.parseInt(arraylist.get(0)) * Integer.parseInt(arraylist.get(2));
                }
                if (arraylist.get(1).contains("+")) {
                    calc = Integer.parseInt(arraylist.get(0)) + Integer.parseInt(arraylist.get(2));
                }
                if (arraylist.get(1).contains("-")) {
                    calc = Integer.parseInt(arraylist.get(0)) - Integer.parseInt(arraylist.get(2));
                }
                /*if (arraylist.get(1).contains("/")) {
                    {
                        try {
                            calc = Integer.parseInt(arraylist.get(0)) / Integer.parseInt(arraylist.get(1));
                        } catch (Exception e) {
                            textview1.setText("cannot divide");
                        }
                    }
                }*/if (arraylist.get(1).contains("/")) {calc = Integer.parseInt(arraylist.get(0)) / Integer.parseInt(arraylist.get(2));}
                arraylist.remove(0);
                arraylist.remove(0);
                arraylist.remove(0);
                arraylist.add(0, Integer.toString(calc));
                c=arraylist.size();
            }

        }

        textview1.setText(Integer.toString(calc));
    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.commonman.manishankar.manicalc/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.commonman.manishankar.manicalc/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
