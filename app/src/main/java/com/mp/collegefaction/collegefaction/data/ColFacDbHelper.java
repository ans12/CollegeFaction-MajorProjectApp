package com.mp.collegefaction.collegefaction.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pranjul on 12/4/18.
 */

public class ColFacDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "connect.db";
    private static final int VERSION_NUMBER = 1;

    public ColFacDbHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
