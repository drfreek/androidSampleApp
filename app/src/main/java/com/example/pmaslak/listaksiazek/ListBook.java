package com.example.pmaslak.listaksiazek;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;



public class ListBook extends ListActivity {

    public final static String EXTRA_BOOK_TITLE         = "com.example.pmaslak.listaKsiazek.BOOK_TITLE";
    private ArrayList<String> results = new ArrayList<String>();

    /**
     * add book logic
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_books);

        sqliteDriver mDbHelper = new sqliteDriver(this);
        final Cursor c = mDbHelper.SelectAllData();

        if (c != null ) {
            if  (c.moveToFirst()) {
                do {
                    String title = c.getString(c.getColumnIndex(databaseConfig.BookEntry.COLUMN_NAME_TITLE));

                    int age = c.getInt(c.getColumnIndex("_id"));
                    results.add( title );

                } while (c.moveToNext());
            }
        }

        TextView tView = new TextView(this);
        tView.setText("Twoje książki:");
        getListView().addHeaderView(tView);

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, results));

        ListView lv = getListView();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long arg3) {

                //get book title
                String value = (String) adapter.getItemAtPosition(position);

                //create intent
                Intent intent = new Intent(v.getContext(), DetailsBook.class);

                //pass book title
                intent.putExtra(EXTRA_BOOK_TITLE, value);

                //goto intent
                startActivity(intent);
            }
        });

        getListView().setTextFilterEnabled(true);
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
