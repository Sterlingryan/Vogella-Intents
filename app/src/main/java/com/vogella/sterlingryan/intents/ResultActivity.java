package com.vogella.sterlingryan.intents;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by SterlingRyan on 17/11/2016.
 */

public class ResultActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Get data inside bundle
        Bundle bundle = getIntent().getExtras();
        String passedValue = bundle.getString("thisKey");

        // Set passed value to TextView
        TextView view = (TextView) findViewById(R.id.displayintentextra);
        view.setText(passedValue);
    }

    @Override
    public void finish() {

        //TODO create new intent
        Intent intent = new Intent(this, MainActivity.class);

        //TODO read data from EditText
        EditText editText = (EditText) findViewById(R.id.returnValue);
        String returnValue = editText.getText().toString();

        //TODO pass returnValue as extra to intent
        intent.putExtra("returnValue", returnValue);

        //TODO set result to Ok
        setResult(RESULT_OK, intent);
        super.finish();
    }
}
