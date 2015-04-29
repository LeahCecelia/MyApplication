package com.practice.lcn12.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.view.*;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ParallelizedAmdahlsActivity extends ActionBarActivity implements  AdapterView.OnItemSelectedListener{
    TextView tvResult;
    String valueType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parallelized_amdahls);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.values_array_P, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        tvResult = (TextView) findViewById(R.id.tvResultP);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_parallelized_amdahls, menu);
        return true;
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
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

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        //An item was selected. You can retrieve the selected item using
        Object itemAtPosition = parent.getItemAtPosition(pos);
        valueType = itemAtPosition.toString();
    }

    public void sendMessageP(View view){
        //Intent intent = new Intent(this, DisplayMessageActivity.class);
        if(valueType.equalsIgnoreCase("amount of parallelization")) {
            EditText fraction = (EditText) findViewById(R.id.fraction);
            EditText increase = (EditText) findViewById(R.id.overall);
            try {
                Float p = Float.parseFloat(fraction.getText().toString());
                Float os = Float.parseFloat(increase.getText().toString());
                if (p > 1) {
                    tvResult.setText("please enter a fraction value");
                }
                else {
                    if ((1 - os + (os * p)) <= 0) {
                        tvResult.setText("invalid values");
                    }
                    else {
                        float result = (p*os )/ (1 - os + (os * p));
                        tvResult.setText("the necessary partial parallelization is " + result);
                    }
                }
            }
            catch(NumberFormatException e) {
                tvResult.setText("missing value");
            }


        }
        if(valueType.equalsIgnoreCase("overall speedup")) {
            EditText fraction = (EditText) findViewById(R.id.fraction);
            EditText increase = (EditText) findViewById(R.id.increase);
            try {
                Float fraction_in = Float.parseFloat(fraction.getText().toString());
                int increase_i = Integer.parseInt(increase.getText().toString());
                if (fraction_in > 1) {
                    tvResult.setText("please enter a fraction value");
                } else {
                    if (((fraction_in / increase_i) + (1 - fraction_in)) <= 0) {
                        tvResult.setText("invalid values");
                    } else {
                        float result = 1 / ((fraction_in / increase_i) + (1 - fraction_in));
                        tvResult.setText("the overall speedup is " + result);
                    }
                }
            }
            catch (NumberFormatException e){
                tvResult.setText("missing value");
            }
        }
        if(valueType.equalsIgnoreCase("percent of program parallelized")){
            EditText overall = (EditText) findViewById(R.id.overall);
            EditText partial = (EditText) findViewById(R.id.increase);
            try {
                Float o = Float.parseFloat(overall.getText().toString());
                Float s = Float.parseFloat(partial.getText().toString());
                if (1 - s <= 0) {
                    tvResult.setText("invalid values");
                } else {
                    float result = ((s / o) - s) / (1 - s);
                    tvResult.setText("the fraction to be parallelized is " + result);
                }
            }
            catch (NumberFormatException e){
                tvResult.setText("missing value");
            }

        }

    }
}
