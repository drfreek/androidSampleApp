package com.example.pmaslak.listaksiazek;
import android.provider.BaseColumns;


public final class databaseConfig {

    public databaseConfig() {}

    /**
     * table definition
     */
    public static abstract class BookEntry implements BaseColumns {
        public static final String COLUMN_NAME_ENTRY_ID     = "_id";
        public static final String TABLE_NAME               = "listaKsiazek";
        public static final String COLUMN_NAME_TITLE        = "title";
        public static final String COLUMN_NAME_SUBTITLE     = "subtitle";
        public static final String COLUMN_NAME_DESCRIPTION  = "description";
    }
}
