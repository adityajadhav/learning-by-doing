package com.sqlitepractice;

import android.provider.BaseColumns;

/**
 * Created by neo on 12-03-2017.
 */

public class InformationReaderContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private InformationReaderContract() {
    }

    /* Inner class that defines the table contents */
    public static class StudentEntry implements BaseColumns {
        public static final String TABLE_NAME = "students";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_BELONG_TO_UNIV = "belongToUnivId";

    }

    /* Inner class that defines the table contents */
    public static class UniversityEntry implements BaseColumns {
        public static final String TABLE_NAME = "universities";
        public static final String COLUMN_NAME_NAME = "name";
    }
}
