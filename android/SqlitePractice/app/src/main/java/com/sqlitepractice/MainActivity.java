package com.sqlitepractice;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InformationReaderDbHelper mDbHelper = new InformationReaderDbHelper(this.getApplicationContext());
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        insertQuery(db);

    }

    private void insertQuery(SQLiteDatabase db) {
        ContentValues universityContentValues = new ContentValues();
        String uniId = UUID.randomUUID().toString();
        universityContentValues.put(InformationReaderContract.UniversityEntry._ID, uniId);
        universityContentValues.put(InformationReaderContract.UniversityEntry.COLUMN_NAME_NAME, "UIUC");
        db.insert(InformationReaderContract.UniversityEntry.TABLE_NAME, null, universityContentValues);

        ContentValues values = new ContentValues();
        values.put(InformationReaderContract.StudentEntry.COLUMN_NAME_NAME, "Aditya");
        values.put(InformationReaderContract.StudentEntry._ID, UUID.randomUUID().toString());
        values.put(InformationReaderContract.StudentEntry.COLUMN_NAME_BELONG_TO_UNIV, uniId);
        db.insert(InformationReaderContract.StudentEntry.TABLE_NAME, null, values);
    }
}
