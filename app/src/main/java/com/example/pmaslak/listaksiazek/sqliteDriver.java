package com.example.pmaslak.listaksiazek;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;


public class sqliteDriver  extends SQLiteOpenHelper {

    /**
     * DELETE statement
     */
    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + databaseConfig.BookEntry.TABLE_NAME;

    /**
     * unified text type
     */
    private static final String TEXT_TYPE = " TEXT ";

    /**
     * unified separator
     */
    private static final String COMMA_SEP = ", ";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + databaseConfig.BookEntry.TABLE_NAME
                    + " ( " +
                    databaseConfig.BookEntry.COLUMN_NAME_ENTRY_ID       + " INTEGER PRIMARY KEY AUTOINCREMENT " + COMMA_SEP +
                    databaseConfig.BookEntry.COLUMN_NAME_TITLE          + TEXT_TYPE + COMMA_SEP +
                    databaseConfig.BookEntry.COLUMN_NAME_SUBTITLE       + TEXT_TYPE + COMMA_SEP +
                    databaseConfig.BookEntry.COLUMN_NAME_DESCRIPTION    + TEXT_TYPE +
            " )";

    /**
     * for next upgrades DB version should be incremented
     */
    public static final int DATABASE_VERSION = 3;


    public static final String DATABASE_NAME = "bookList.db";

    /**
     * construct
     * @param context
     */
    public sqliteDriver(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public Cursor SelectAllData() {

        try {
            SQLiteDatabase db;
            db = this.getReadableDatabase(); // Read Data

            String strSQL = "SELECT * FROM " + databaseConfig.BookEntry.TABLE_NAME;

            Cursor cursor = db.rawQuery(strSQL, null);
            return cursor;

        } catch (Exception e) {
            return null;
        }
    }


    public Cursor SelectByTitle(String title) {

        try {
            SQLiteDatabase db;
            db = this.getWritableDatabase(); // Read Data

            String strSQL = "SELECT * FROM " + databaseConfig.BookEntry.TABLE_NAME + " WHERE title = '" + title + "' LIMIT 1" ;

            Cursor cursor = db.rawQuery(strSQL, null);
            return cursor;

        } catch (Exception e) {
            return null;
        }
    }

    public void UpdateByTitle(String title, String subtitle, String description, String id) {

        try {
            SQLiteDatabase db;
            db = this.getWritableDatabase(); // get connection with read permission

            db.execSQL("UPDATE " + databaseConfig.BookEntry.TABLE_NAME + " SET " +
                    databaseConfig.BookEntry.COLUMN_NAME_TITLE + " = '" + title + "', " +
                    databaseConfig.BookEntry.COLUMN_NAME_SUBTITLE + " = '" + subtitle + "', " +
                    databaseConfig.BookEntry.COLUMN_NAME_DESCRIPTION + " = '" + description + "' " +
                    " WHERE "
                    + databaseConfig.BookEntry.COLUMN_NAME_ENTRY_ID + "=" + id);




        } catch (Exception e) {
        }
    }

    public void DeleteById(String id) {

        try {
        SQLiteDatabase db;
             db = this.getWritableDatabase(); // get connection with read permission

        db.execSQL("DELETE FROM " + databaseConfig.BookEntry.TABLE_NAME + " where "+databaseConfig.BookEntry.COLUMN_NAME_ENTRY_ID+"=" + id);

//        Log.d("----SQL statement: ", "DELETE FROM " + databaseConfig.BookEntry.TABLE_NAME + " where _id=" + databaseConfig.BookEntry.COLUMN_NAME_ENTRY_ID);
        } catch (Exception e) {
        }
    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}