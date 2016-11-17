package com.vogella.sterlingryan.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // constant to determine which sub-activity returns
    private static final int REQUEST_CODE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        EditText text = (EditText) findViewById(R.id.inputforintent);
        String value = text.getText().toString();

        //TODO create new intent
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("thisKey", value);

        //TODO start second activity
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE){
            if(data.hasExtra("returnValue")){
                String result = data.getExtras().getString("returnValue");
                if(result != null && result.length() > 0){
                    Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void shareData(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "Hello World!");

        startActivity(intent);
    }
}
