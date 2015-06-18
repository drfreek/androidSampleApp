package com.example.pmaslak.listaksiazek;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
;


public class AddBookAction extends ActionBarActivity {

    /**
     * add book view
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_add_book);
        Intent intent = getIntent();

        // DB connection on write stage
        sqliteDriver mDbHelper = new sqliteDriver(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        String title        = intent.getStringExtra(AddBook.EXTRA_BOOK_TITLE);
        String subtitle     = intent.getStringExtra(AddBook.EXTRA_BOOK_SUBTITLE);
        String description  = intent.getStringExtra(AddBook.EXTRA_BOOK_DESCRIPTION);

        values.put(databaseConfig.BookEntry.COLUMN_NAME_TITLE, title);
        values.put(databaseConfig.BookEntry.COLUMN_NAME_SUBTITLE, subtitle);
        values.put(databaseConfig.BookEntry.COLUMN_NAME_DESCRIPTION, description);

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                databaseConfig.BookEntry.TABLE_NAME,
                databaseConfig.BookEntry.COLUMN_NAME_SUBTITLE,
                values);

        //@TODO a moze przekierowanie na dodana ksiazke
        Intent intent2 = new Intent(this, MainActivity.class);
        startActivity(intent2);

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

}
