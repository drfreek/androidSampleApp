package com.example.pmaslak.listaksiazek;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class AddBook extends ActionBarActivity {


    public final static String EXTRA_BOOK_TITLE         = "com.example.pmaslak.listaKsiazek.BOOK_TITLE";
    public final static String EXTRA_BOOK_SUBTITLE      = "com.example.pmaslak.listaKsiazek.BOOK_SUBTITLE";
    public final static String EXTRA_BOOK_DESCRIPTION   = "com.example.pmaslak.listaKsiazek.BOOK_DESCRIPTION";

    /**
     * add book view
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_add_book);
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

    public void AddBookAction(View view) {
        Intent intent = new Intent(this, AddBookAction.class);

        EditText editTitle          = (EditText) findViewById(R.id.add_title);
        EditText editSubtitle       = (EditText) findViewById(R.id.add_subtitle);
        EditText editDescription    = (EditText) findViewById(R.id.add_description);

        String title        = editTitle.getText().toString();
        String subtitle     = editSubtitle.getText().toString();
        String description  = editDescription.getText().toString();

        intent.putExtra(EXTRA_BOOK_TITLE, title);
        intent.putExtra(EXTRA_BOOK_SUBTITLE, subtitle);
        intent.putExtra(EXTRA_BOOK_DESCRIPTION, description);

        startActivity(intent);
    }
}
