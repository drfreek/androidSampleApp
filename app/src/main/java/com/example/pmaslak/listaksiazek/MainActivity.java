package com.example.pmaslak.listaksiazek;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;


public class MainActivity extends ActionBarActivity {



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


    /**
     * Przechodzimy do listy ksiazek
     * @param view
     */
    public void ListBook(View view) {
        Intent intent = new Intent(this, ListBook.class);
        startActivity(intent);
    }

    /**
     * goto add book view
     * @param view
     */
    public void viewAddBook(View view) {
        Intent intent = new Intent(this, AddBook.class);
        startActivity(intent);
    }

    /**
     * goto about author data
     * @param view
     */
    public void ApplicationInfo(View view) {
        Intent intent = new Intent(this, ApplicationInfo.class);
        startActivity(intent);
    }
}
