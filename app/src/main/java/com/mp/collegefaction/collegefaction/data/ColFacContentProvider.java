package com.mp.collegefaction.collegefaction.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
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
    private static final UriMatcher sUriMatcher = buildUriMatcher();

    private static final int USER = 100;
    private static final int USER_CAREER = 200;
    private static final int TYPE = 300;
    private static final int FREIND_REQUEST = 400;
    private static final int POST = 500;
    private static final int REQUEST_TYPE = 600;
    private static final int POST_COMMENT = 700;
    private static final int POST_COMMENT_TYPE = 800;
    private static final int POST_LIKES = 900;
    private static final int POST_SHARE = 1000;
    private static final int EVENT = 1100;
    private static final int EVENT_TYPE = 1200;
    private static final int INSTITUTION = 1300;
    private static final int BANNER = 1400;
    private static final int BANNER_TYPE = 1500;
    private static final int COURSE = 1600;

    @Override
    public boolean onCreate() {
        Context context = getContext();
        mColFacDbHelper = new ColFacDbHelper(context);
        return true;
    }

    public static UriMatcher buildUriMatcher() {

        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        uriMatcher.addURI(CollegeFactionContract.CONTENT_AUTHORITY, CollegeFactionContract.UserEntry.TABLE_NAME, USER);
        uriMatcher.addURI(CollegeFactionContract.CONTENT_AUTHORITY, CollegeFactionContract.UserCareerEntry.TABLE_NAME, USER_CAREER);
        uriMatcher.addURI(CollegeFactionContract.CONTENT_AUTHORITY, CollegeFactionContract.UserTypeEntry.TABLE_NAME, TYPE);
        uriMatcher.addURI(CollegeFactionContract.CONTENT_AUTHORITY, CollegeFactionContract.FriendRequestEntry.TABLE_NAME, FREIND_REQUEST);
        uriMatcher.addURI(CollegeFactionContract.CONTENT_AUTHORITY, CollegeFactionContract.PostsEntry.TABLE_NAME, POST);
        uriMatcher.addURI(CollegeFactionContract.CONTENT_AUTHORITY, CollegeFactionContract.RequestTypeEntry.TABLE_NAME, REQUEST_TYPE);
        uriMatcher.addURI(CollegeFactionContract.CONTENT_AUTHORITY, CollegeFactionContract.PostCommentsEntry.TABLE_NAME, POST_COMMENT);
        uriMatcher.addURI(CollegeFactionContract.CONTENT_AUTHORITY, CollegeFactionContract.PostCommentTypeEntry.TABLE_NAME, POST_COMMENT_TYPE);
        uriMatcher.addURI(CollegeFactionContract.CONTENT_AUTHORITY, CollegeFactionContract.PostLikesEntry.TABLE_NAME, POST_LIKES);
        uriMatcher.addURI(CollegeFactionContract.CONTENT_AUTHORITY, CollegeFactionContract.PostShareEntry.TABLE_NAME, POST_SHARE);
        uriMatcher.addURI(CollegeFactionContract.CONTENT_AUTHORITY, CollegeFactionContract.EventsEntry.TABLE_NAME, EVENT);
        uriMatcher.addURI(CollegeFactionContract.CONTENT_AUTHORITY, CollegeFactionContract.EventTypeEntry.TABLE_NAME, EVENT_TYPE);
        uriMatcher.addURI(CollegeFactionContract.CONTENT_AUTHORITY, CollegeFactionContract.InstitutionEntry.TABLE_NAME, INSTITUTION);
        uriMatcher.addURI(CollegeFactionContract.CONTENT_AUTHORITY, CollegeFactionContract.BannerEntry.TABLE_NAME, BANNER);
        uriMatcher.addURI(CollegeFactionContract.CONTENT_AUTHORITY, CollegeFactionContract.BannerTypeEntry.TABLE_NAME, BANNER_TYPE);
        uriMatcher.addURI(CollegeFactionContract.CONTENT_AUTHORITY, CollegeFactionContract.CourseEntry.TABLE_NAME, COURSE);

        return uriMatcher;
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
