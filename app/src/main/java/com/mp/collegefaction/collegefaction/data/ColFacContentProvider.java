package com.mp.collegefaction.collegefaction.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by pranjul on 12/4/18.
 *
 */

public class ColFacContentProvider extends ContentProvider {

    private ColFacDbHelper mColFacDbHelper;

    @Override
    public boolean onCreate() {
        Context context = getContext();
        mColFacDbHelper = new ColFacDbHelper(context);
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        final SQLiteDatabase db = mColFacDbHelper.getReadableDatabase();

        String tableName = uri.getPathSegments().get(0);
        Cursor cursor = db.query(tableName,
                                projection,
                                selection,
                                selectionArgs,
                            null,
                            null,
                            sortOrder);

        cursor.setNotificationUri(getContext().getContentResolver(),uri);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        final SQLiteDatabase db = mColFacDbHelper.getWritableDatabase();
        String tableName = uri.getPathSegments().get(0);
        Uri returnUri;

        long id = db.insert(tableName,null,contentValues);
        if (id > 0){
            returnUri = ContentUris.withAppendedId(uri, id);
        } else {
            throw new android.database.SQLException("Failed to insert row into " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return returnUri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
