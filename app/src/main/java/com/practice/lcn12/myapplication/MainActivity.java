package com.practice.lcn12.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.*;
import android.content.Intent;
import android.widget.EditText;



public class MainActivity extends ActionBarActivity {
    public final static String EXTRA_MESSAGE = "com.practice.lcn12.EXTRA_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    //sends message when button is clicked
    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText fraction = (EditText) findViewById(R.id.fraction);
        EditText increase = (EditText) findViewById(R.id.increase);
        Float fraction_in = Float.parseFloat(fraction.getText().toString());
        int increase_i = Integer.parseInt(increase.getText().toString());
        float fraction_f = fraction_in/100;
        float result = 1/(fraction_f + (1/increase_i)*(1-fraction_f));
        intent.putExtra(EXTRA_MESSAGE, (new Float(result)).toString());
        startActivity(intent);

    }
}
