package com.vogella.sterlingryan.browserfilter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class BrowserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Network access in the user interface
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        WebView text = (WebView) findViewById(R.id.textView);

        // To get the action of the intent use
        String action = intent.getAction();

        if (!action.equals(Intent.ACTION_VIEW)){
            throw new RuntimeException("Should Not Happen");
        }

        // To get the data use
        Uri data = intent.getData();
        URL url;
        try{
            url = new URL(data.getScheme(),data.getHost(),data.getPath());
            text.loadUrl(url.toString());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
