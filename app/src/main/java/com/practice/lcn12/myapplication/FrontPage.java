package com.practice.lcn12.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class FrontPage extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_front_page, menu);
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

    public void goToAmdahl(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        startActivity(intent);
    }

    public void goToMipsRef(View view){
        Intent intent = new Intent(this, MIPSRefActivity.class); //insert name of your activity instead of "MainActivity"
        startActivity(intent);
    }
    public void goToCToMips(View view){
        Intent intent = new Intent(this, CToMIPSActivity.class); //insert name of your activity instead of "MainActivity"
        startActivity(intent);
    }

    public void goToPipeline(View view){
        Intent intent = new Intent(this, PipeliningActivity.class); //insert name of your activity instead of "MainActivity"
        startActivity(intent);
    }

    public void goToARM(View view){
        Intent intent = new Intent(this, ARMActivity.class); //insert name of your activity instead of "MainActivity"
        startActivity(intent);
    }


}
