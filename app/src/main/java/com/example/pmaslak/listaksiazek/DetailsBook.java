package com.example.pmaslak.listaksiazek;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class DetailsBook extends ActionBarActivity {

    private ArrayList<String> results = new ArrayList<String>();

    /**
     * add book view
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_book);
        Intent intent = getIntent();
        String title  = intent.getStringExtra(AddBook.EXTRA_BOOK_TITLE);

        sqliteDriver mDbHelper = new sqliteDriver(this);
        final Cursor c = mDbHelper.SelectByTitle(title);

        c.moveToFirst();
        String description = c.getString(c.getColumnIndex("description"));
        String subtitle = c.getString(c.getColumnIndex("subtitle"));
        String id = c.getString(c.getColumnIndex("_id"));

        TextView fieldId = (TextView) findViewById(R.id.book_id);

        EditText editTitle          = (EditText) findViewById(R.id.add_title);
        EditText editSubtitle       = (EditText) findViewById(R.id.add_subtitle);
        EditText editDescription    = (EditText) findViewById(R.id.add_description);

        fieldId.setText(id);
        editTitle.setText(title);
        editSubtitle.setText(subtitle);
        editDescription.setText(description);
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
     * delete book and go to book list
     * @param view
     */
    public void DeleteBookAction(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        TextView fieldId = (TextView) findViewById(R.id.book_id);
        String id = fieldId.getText().toString();

        Log.d("id do wyjebania", id);
        
        sqliteDriver mDbHelper = new sqliteDriver(this);
        mDbHelper.DeleteById(id);

        startActivity(intent);
    }

    public void UpdateBookAction(View view) {
        Intent intent = new Intent(this, MainActivity.class);

        TextView fieldId = (TextView) findViewById(R.id.book_id);
        String id = fieldId.getText().toString();


        EditText editTitle          = (EditText) findViewById(R.id.add_title);
        EditText editSubtitle       = (EditText) findViewById(R.id.add_subtitle);
        EditText editDescription    = (EditText) findViewById(R.id.add_description);

        String title        = editTitle.getText().toString();
        String subtitle     = editSubtitle.getText().toString();
        String description  = editDescription.getText().toString();

        sqliteDriver mDbHelper = new sqliteDriver(this);
        mDbHelper.UpdateByTitle(title, subtitle, description, id);

        startActivity(intent);
    }
}
