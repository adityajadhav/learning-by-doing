package com.sqlitepractice;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by neo on 12-03-2017.
 */

public class InformationReaderDbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "StudentReader.db";

    private static final String SQL_CREATE_STUDENT =
            "CREATE TABLE " + InformationReaderContract.StudentEntry.TABLE_NAME + " (" +
                    InformationReaderContract.StudentEntry._ID + " TEXT PRIMARY KEY," +
                    InformationReaderContract.StudentEntry.COLUMN_NAME_NAME + " TEXT," +
                    InformationReaderContract.StudentEntry.COLUMN_NAME_BELONG_TO_UNIV + " TEXT, " +
                    "FOREIGN KEY(" + InformationReaderContract.StudentEntry.COLUMN_NAME_BELONG_TO_UNIV + ") " +
                    "REFERENCES " + InformationReaderContract.UniversityEntry.TABLE_NAME + "(" + InformationReaderContract.UniversityEntry._ID + ") )";

    private static final String SQL_CREATE_UNIV =
            "CREATE TABLE " + InformationReaderContract.UniversityEntry.TABLE_NAME + " (" +
                    InformationReaderContract.UniversityEntry._ID + " TEXT PRIMARY KEY," +
                    InformationReaderContract.UniversityEntry.COLUMN_NAME_NAME + " TEXT )";


    private static final String SQL_DELETE_STUDENT =
            "DROP TABLE IF EXISTS " + InformationReaderContract.StudentEntry.TABLE_NAME;


    private static final String SQL_DELETE_UNIV =
            "DROP TABLE IF EXISTS " + InformationReaderContract.UniversityEntry.TABLE_NAME;

    public InformationReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_UNIV);
        db.execSQL(SQL_CREATE_STUDENT);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        Log.e("a","asdasad");
        db.execSQL(SQL_DELETE_STUDENT);
        db.execSQL(SQL_DELETE_UNIV);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
    }
}