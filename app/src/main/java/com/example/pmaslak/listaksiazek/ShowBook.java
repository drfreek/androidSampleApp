package com.example.pmaslak.listaksiazek;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;


public class ShowBook extends ActionBarActivity {

    /**
     * add book logic
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_view_add_book);
        setContentView(R.layout.activity_display_book);
//        Intent intent = getIntent();
//        String book_name = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

//        TextView textView = new TextView(this);
//        textView.setTextSize(40);
//        textView.setText(book_name);

//        String book_description = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_DESCRIPTION);
//        TextView txtViewDescription = (TextView) findViewById(R.id.someval_id);
//        txtViewDescription.setTextSize(40);
//        txtViewDescription.setText("ssssssssssss");

//        TextView myAwesomeTextView = (TextView)findViewById(R.id.soemval_id);

//in your OnCreate() method
//        myAwesomeTextView.setText("dziala kurrrrwa!");

//        setContentView(textView);
        //setContentView(txtViewDescription);
    }

    //zbedne
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_display_book, menu);
//        return true;
//    }

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
