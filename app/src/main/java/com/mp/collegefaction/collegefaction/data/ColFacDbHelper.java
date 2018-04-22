package com.mp.collegefaction.collegefaction.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by pranjul on 12/4/18.
 * Helper class for creating all necessary tables to store data into phone so that it can
 * be shown to user currently logged in.
 */

public class ColFacDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "connect.db";
    private static final int VERSION_NUMBER = 1;

    public ColFacDbHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.v("DB","queries writing");
        final String CREATE_TABLE_BANNER_TYPES_QUERY = "CREATE TABLE "+ CollegeFactionContract.BannerTypeEntry.TABLE_NAME +" ( " +
                CollegeFactionContract.BannerTypeEntry._ID             + " INTEGER PRIMARY KEY NOT NULL, " +
                CollegeFactionContract.BannerTypeEntry.COL_TYPE_NAME   + " VARCHAR(255) NOT NULL, " +
                CollegeFactionContract.BannerTypeEntry.COL_CREATED_AT  + " DATETIME NULL DEFAULT NULL, " +
                CollegeFactionContract.BannerTypeEntry.COL_UPDATED_AT  + " DATETIME NULL DEFAULT NULL " +
                ")";

        final String CREATE_TABLE_BANNERS_QUERY = "CREATE TABLE "+ CollegeFactionContract.BannerEntry.TABLE_NAME +" ( " +
                CollegeFactionContract.BannerEntry._ID                 + " INTEGER PRIMARY KEY NOT NULL, " +
                CollegeFactionContract.BannerEntry.COL_NAME            + " VARCHAR(255) NOT NULL, " +
                CollegeFactionContract.BannerEntry.COL_SOURCE          + " LONGTEXT NOT NULL, " +
                CollegeFactionContract.BannerEntry.COL_BANNER_TYPE_ID  + " INTEGER NOT NULL, " +
                CollegeFactionContract.BannerEntry.COL_CREATED_AT      + " DATETIME NULL DEFAULT NULL, " +
                CollegeFactionContract.BannerEntry.COL_UPDATED_AT      + " DATETIME NULL DEFAULT NULL, " +
                " FOREIGN KEY ("+ CollegeFactionContract.BannerEntry.COL_BANNER_TYPE_ID +") REFERENCES "+ CollegeFactionContract.BannerTypeEntry.TABLE_NAME + " (" + CollegeFactionContract.BannerTypeEntry._ID + ") ON DELETE CASCADE " +
                ")";

        final String CREATE_TABLE_INSTITUTIONS_QUERY = "CREATE TABLE "+ CollegeFactionContract.InstitutionEntry.TABLE_NAME +" ( "+
                CollegeFactionContract.InstitutionEntry._ID                  + " INTEGER PRIMARY KEY NOT NULL, " +
                CollegeFactionContract.InstitutionEntry.COL_INSTITUTION_NAME + " VARCHAR(255) NOT NULL, " +
                CollegeFactionContract.InstitutionEntry.COL_ADDRESS          + " LONGTEXT NOT NULL, " +
                CollegeFactionContract.InstitutionEntry.COL_CREATED_AT       + " DATETIME NULL DEFAULT NULL, " +
                CollegeFactionContract.InstitutionEntry.COL_UPDATED_AT       + " DATETIME NULL DEFAULT NULL " +
                ")";

        final String CREATE_TABLE_COURSES_QUERY = "CREATE TABLE "+ CollegeFactionContract.CourseEntry.TABLE_NAME+ " ( " +
                CollegeFactionContract.CourseEntry._ID                 + " INTEGER PRIMARY KEY NOT NULL, " +
                CollegeFactionContract.CourseEntry.COL_COURSE_NAME     + " VARCHAR(255) NOT NULL, " +
                CollegeFactionContract.CourseEntry.COL_CREATED_AT      + " DATETIME NULL DEFAULT NULL, " +
                CollegeFactionContract.CourseEntry.COL_UPDATED_AT      + " DATETIME NULL DEFAULT NULL " +
                ")";

        final String CREATE_TABLE_USER_TYPES_QUERY = "CREATE TABLE " + CollegeFactionContract.UserTypeEntry.TABLE_NAME + " ( " +
                CollegeFactionContract.UserTypeEntry._ID               + " INTEGER PRIMARY KEY NOT NULL, " +
                CollegeFactionContract.UserTypeEntry.COL_TYPE_NAME     + " VARCHAR(255) NOT NULL, " +
                CollegeFactionContract.UserTypeEntry.COL_CREATED_AT    + " DATETIME NULL DEFAULT NULL, " +
                CollegeFactionContract.UserTypeEntry.COL_UPDATED_AT    + " DATETIME NULL DEFAULT NULL " +
                ") ";

        final String CREATE_TABLE_USERS_QUERY = "CREATE TABLE " + CollegeFactionContract.UserEntry.TABLE_NAME +" ( " +
                CollegeFactionContract.UserEntry._ID                   + " INTEGER PRIMARY KEY NOT NULL, " +
                CollegeFactionContract.UserEntry.COL_NAME              + " VARCHAR(255) NOT NULL, " +
                CollegeFactionContract.UserEntry.COL_EMAIL             + " VARCHAR(255) NOT NULL UNIQUE, " +
                CollegeFactionContract.UserEntry.COL_PASSWORD          + " VARCHAR(255) NOT NULL, " +
                CollegeFactionContract.UserEntry.COL_REMEMBER_TOKEN    + " VARCHAR(100) DEFAULT NULL, " +
                CollegeFactionContract.UserEntry.COL_USER_NAME         + " VARCHAR(255) NOT NULL UNIQUE, " +
                CollegeFactionContract.UserEntry.COL_BANNER_ID         + " INTEGER NOT NULL, " +
                CollegeFactionContract.UserEntry.COL_DOB               + " DATE NOT NULL, " +
                CollegeFactionContract.UserEntry.COL_ADDRESS           + " TEXT NOT NULL, " +
                CollegeFactionContract.UserEntry.COL_INSTITUTION_ID    + " INTEGER NOT NULL, " +
                CollegeFactionContract.UserEntry.COL_USER_TYPE_ID      + " INTEGER NOT NULL, " +
                CollegeFactionContract.UserEntry.COL_STATUS            + " TINYINT(1) NOT NULL, " +
                CollegeFactionContract.UserEntry.COL_ALUMINI_STATUS    + " TINYINT(1) NOT NULL, " +
                CollegeFactionContract.UserEntry.COL_MOBILE            + " INT(11) NOT NULL, " +
                CollegeFactionContract.UserEntry.COL_WORKING_STATUS    + " TINYINT(1) NOT NULL, " +
                CollegeFactionContract.UserEntry.COL_YEAR_OF_PASSING   + " INT(4) NOT NULL, " +
                CollegeFactionContract.UserEntry.COL_COURSE_ID         + " INTEGER NOT NULL, " +
                CollegeFactionContract.UserEntry.COL_CREATED_AT        + " DATETIME NULL DEFAULT NULL, " +
                CollegeFactionContract.UserEntry.COL_UPDATED_AT        + " DATETIME NULL DEFAULT NULL, " +
                " FOREIGN KEY ( " + CollegeFactionContract.UserEntry.COL_BANNER_ID  + " ) REFERENCES "+ CollegeFactionContract.BannerEntry.TABLE_NAME+"( " + CollegeFactionContract.BannerEntry._ID +") ON DELETE CASCADE, " +
                " FOREIGN KEY (" + CollegeFactionContract.UserEntry.COL_COURSE_ID  + ") REFERENCES "+ CollegeFactionContract.CourseEntry.TABLE_NAME+"( " + CollegeFactionContract.CourseEntry._ID +") ON DELETE CASCADE, " +
                " FOREIGN KEY (" + CollegeFactionContract.UserEntry.COL_INSTITUTION_ID + ") REFERENCES "+ CollegeFactionContract.InstitutionEntry.TABLE_NAME+"( " + CollegeFactionContract.InstitutionEntry._ID +") ON DELETE CASCADE, " +
                " FOREIGN KEY (" + CollegeFactionContract.UserEntry.COL_USER_TYPE_ID  + ") REFERENCES "+ CollegeFactionContract.UserTypeEntry.TABLE_NAME+"( " + CollegeFactionContract.UserTypeEntry._ID +") ON DELETE CASCADE" +
                " ) ";

        final String CREATE_TABLE_USER_CAREERS_QUERY = "CREATE TABLE " + CollegeFactionContract.UserCareerEntry.TABLE_NAME + " ( " +
                CollegeFactionContract.UserCareerEntry._ID                   + " INTEGER PRIMARY KEY NOT NULL, " +
                CollegeFactionContract.UserCareerEntry.COL_USER_ID           + " INTEGER NOT NULL, " +
                CollegeFactionContract.UserCareerEntry.COL_ORGANIZATION      + " TEXT NOT NULL, " +
                CollegeFactionContract.UserCareerEntry.COL_POSITION          + " VARCHAR(255) NOT NULL, " +
                CollegeFactionContract.UserCareerEntry.COL_LOCATION          + " VARCHAR(255) NOT NULL, " +
                CollegeFactionContract.UserCareerEntry.COL_STARTED_IN        + " DATE NOT NULL, " +
                CollegeFactionContract.UserCareerEntry.COL_WORKED_UPTO       + " DATE NOT NULL, " +
                CollegeFactionContract.UserCareerEntry.COL_REVIEW            + " LONGTEXT NOT NULL, " +
                CollegeFactionContract.UserCareerEntry.COL_CREATED_AT        + " DATETIME NULL DEFAULT NULL, " +
                CollegeFactionContract.UserCareerEntry.COL_UPDATED_AT        + " DATETIME NULL DEFAULT NULL, " +
                " FOREIGN KEY (" + CollegeFactionContract.UserCareerEntry.COL_USER_ID + ") REFERENCES "+ CollegeFactionContract.UserEntry.TABLE_NAME+"( " + CollegeFactionContract.UserEntry._ID +") ON DELETE CASCADE " +
                " )";

        final String CREATE_TABLE_REQUEST_TYPES_QUERY = "CREATE TABLE " + CollegeFactionContract.RequestTypeEntry.TABLE_NAME + " ( " +
                CollegeFactionContract.RequestTypeEntry._ID                   + " INTEGER PRIMARY KEY NOT NULL, " +
                CollegeFactionContract.RequestTypeEntry.COL_TYPE_NAME         + " VARCHAR(255) NOT NULL, " +
                CollegeFactionContract.RequestTypeEntry.COL_CREATED_AT        + " DATETIME NULL DEFAULT NULL, " +
                CollegeFactionContract.RequestTypeEntry.COL_UPDATED_AT        + " DATETIME NULL DEFAULT NULL " +
                " ) ";

        final String CREATE_TABLE_FRIEND_REQUESTS_QUERY = "CREATE TABLE " + CollegeFactionContract.FriendRequestEntry.TABLE_NAME + " ( " +
                CollegeFactionContract.FriendRequestEntry._ID                   + " INTEGER PRIMARY KEY NOT NULL, " +
                CollegeFactionContract.FriendRequestEntry.COL_SENDER_ID         + " INTEGER NOT NULL, " +
                CollegeFactionContract.FriendRequestEntry.COL_RECEIVER_ID       + " INTEGER NOT NULL, " +
                CollegeFactionContract.FriendRequestEntry.COL_REQUEST_TYPE_ID   + " INTEGER NOT NULL, " +
                CollegeFactionContract.FriendRequestEntry.COL_CREATED_AT        + " DATETIME NULL DEFAULT NULL, " +
                CollegeFactionContract.FriendRequestEntry.COL_UPDATED_AT        + " DATETIME NULL DEFAULT NULL, " +
                " FOREIGN KEY ( " + CollegeFactionContract.FriendRequestEntry.COL_RECEIVER_ID  + " ) REFERENCES "+ CollegeFactionContract.UserEntry.TABLE_NAME+"( " + CollegeFactionContract.UserEntry._ID +") ON DELETE CASCADE, " +
                " FOREIGN KEY ( " + CollegeFactionContract.FriendRequestEntry.COL_REQUEST_TYPE_ID  + " ) REFERENCES "+ CollegeFactionContract.RequestTypeEntry.TABLE_NAME+"( " + CollegeFactionContract.RequestTypeEntry._ID +") ON DELETE CASCADE, " +
                " FOREIGN KEY ( " + CollegeFactionContract.FriendRequestEntry.COL_SENDER_ID  + " ) REFERENCES "+ CollegeFactionContract.UserEntry.TABLE_NAME+"( " + CollegeFactionContract.UserEntry._ID +") ON DELETE CASCADE " +
                " ) ";

        final String CREATE_TABLE_POSTS_QUERY = "CREATE TABLE " + CollegeFactionContract.PostsEntry.TABLE_NAME + " ( " +
                CollegeFactionContract.PostsEntry._ID                   + " INTEGER PRIMARY KEY NOT NULL, " +
                CollegeFactionContract.PostsEntry.COL_SENDER_ID         + " INTEGER NOT NULL, " +
                CollegeFactionContract.PostsEntry.COL_CONTENT           + " LONGTEXT NOT NULL, " +
                CollegeFactionContract.PostsEntry.COL_BANNER_ID         + " INTEGER NOT NULL, " +
                CollegeFactionContract.PostsEntry.COL_CREATED_AT        + " DATETIME NULL DEFAULT NULL, " +
                CollegeFactionContract.PostsEntry.COL_UPDATED_AT        + " DATETIME NULL DEFAULT NULL, " +
                " FOREIGN KEY ( " + CollegeFactionContract.PostsEntry.COL_BANNER_ID  + " ) REFERENCES "+ CollegeFactionContract.BannerEntry.TABLE_NAME+"( " + CollegeFactionContract.BannerEntry._ID +") ON DELETE CASCADE, " +
                " FOREIGN KEY ( " + CollegeFactionContract.PostsEntry.COL_SENDER_ID  + " ) REFERENCES "+ CollegeFactionContract.UserEntry.TABLE_NAME+"( " + CollegeFactionContract.UserEntry._ID +") ON DELETE CASCADE " +
                " )";

        final String CREATE_TABLE_POST_LIKES_QUERY = "CREATE TABLE " + CollegeFactionContract.PostLikesEntry.TABLE_NAME + " ( " +
                CollegeFactionContract.PostLikesEntry._ID                 + " INTEGER PRIMARY KEY NOT NULL, " +
                CollegeFactionContract.PostLikesEntry.COL_USER_ID         + " INTEGER NOT NULL, " +
                CollegeFactionContract.PostLikesEntry.COL_POST_ID         + " INTEGER NOT NULL, " +
                CollegeFactionContract.PostLikesEntry.COL_CREATED_AT      + " DATETIME NULL DEFAULT NULL, " +
                CollegeFactionContract.PostLikesEntry.COL_UPDATED_AT      + " DATETIME NULL DEFAULT NULL, " +
                " FOREIGN KEY ( " + CollegeFactionContract.PostLikesEntry.COL_POST_ID  + " ) REFERENCES "+ CollegeFactionContract.PostsEntry.TABLE_NAME+"( " + CollegeFactionContract.PostsEntry._ID +") ON DELETE CASCADE, " +
                " FOREIGN KEY ( " + CollegeFactionContract.PostLikesEntry.COL_USER_ID  + " ) REFERENCES "+ CollegeFactionContract.UserEntry.TABLE_NAME+"( " + CollegeFactionContract.UserEntry._ID +") ON DELETE CASCADE " +
                " )";

        final String CREATE_TABLE_POST_COMMENT_TYPES_QUERY = "CREATE TABLE " + CollegeFactionContract.PostCommentTypeEntry.TABLE_NAME + " ( " +
                CollegeFactionContract.PostCommentTypeEntry._ID                   + " INTEGER PRIMARY KEY NOT NULL, " +
                CollegeFactionContract.PostCommentTypeEntry.COL_NAME              + " VARCHAR(255) NOT NULL, " +
                CollegeFactionContract.PostCommentTypeEntry.COL_CREATED_AT        + " DATETIME NULL DEFAULT NULL, " +
                CollegeFactionContract.PostCommentTypeEntry.COL_UPDATED_AT        + " DATETIME NULL DEFAULT NULL " +
                " ) ";

        final String CREATE_TABLE_POST_COMMENTS_QUERY = "CREATE TABLE " + CollegeFactionContract.PostCommentsEntry.TABLE_NAME + " ( " +
                CollegeFactionContract.PostCommentsEntry._ID                           + " INTEGER PRIMARY KEY NOT NULL, " +
                CollegeFactionContract.PostCommentsEntry.COL_POST_COMMENT_TYPE         + " INTEGER NOT NULL, " +
                CollegeFactionContract.PostCommentsEntry.COL_USER_ID                   + " INTEGER NOT NULL, " +
                CollegeFactionContract.PostCommentsEntry.COL_CONTENT                   + " LONGTEXT NOT NULL, " +
                CollegeFactionContract.PostCommentsEntry.COL_POST_ID                   + " INTEGER NOT NULL, " +
                CollegeFactionContract.PostCommentsEntry.COL_LIKE_COUNT                + " BIGINT(20) NOT NULL, " +
                CollegeFactionContract.PostCommentsEntry.COL_CREATED_AT                + " DATETIME NULL DEFAULT NULL, " +
                CollegeFactionContract.PostCommentsEntry.COL_UPDATED_AT                + " DATETIME NULL DEFAULT NULL, " +
                " FOREIGN KEY (" + CollegeFactionContract.PostCommentsEntry.COL_POST_COMMENT_TYPE  + ") REFERENCES "+ CollegeFactionContract.PostCommentTypeEntry.TABLE_NAME+"( " + CollegeFactionContract.PostCommentTypeEntry._ID +") ON DELETE CASCADE, " +
                " FOREIGN KEY ( " + CollegeFactionContract.PostCommentsEntry.COL_POST_ID  + " ) REFERENCES "+ CollegeFactionContract.PostsEntry.TABLE_NAME+"( " + CollegeFactionContract.PostsEntry._ID +") ON DELETE CASCADE, " +
                " FOREIGN KEY ( " + CollegeFactionContract.PostCommentsEntry.COL_USER_ID  + " ) REFERENCES "+ CollegeFactionContract.UserEntry.TABLE_NAME+"( " + CollegeFactionContract.UserEntry._ID +") ON DELETE CASCADE " +
                " ) ";

        final String CREATE_TABLE_POST_SHARES_QUERY = "CREATE TABLE " + CollegeFactionContract.PostShareEntry.TABLE_NAME + " ( " +
                CollegeFactionContract.PostShareEntry._ID                 + " INTEGER PRIMARY KEY NOT NULL, " +
                CollegeFactionContract.PostShareEntry.COL_USER_ID         + " INTEGER NOT NULL, " +
                CollegeFactionContract.PostShareEntry.COL_POST_ID         + " INTEGER NOT NULL, " +
                CollegeFactionContract.PostShareEntry.COL_CREATED_AT      + " DATETIME NULL DEFAULT NULL, " +
                CollegeFactionContract.PostShareEntry.COL_UPDATED_AT      + " DATETIME NULL DEFAULT NULL, " +
                " FOREIGN KEY ( " + CollegeFactionContract.PostShareEntry.COL_POST_ID  + " ) REFERENCES "+ CollegeFactionContract.PostsEntry.TABLE_NAME+"( " + CollegeFactionContract.PostsEntry._ID +") ON DELETE CASCADE, " +
                " FOREIGN KEY ( " + CollegeFactionContract.PostShareEntry.COL_USER_ID  + " ) REFERENCES "+ CollegeFactionContract.UserEntry.TABLE_NAME+"( " + CollegeFactionContract.UserEntry._ID +") ON DELETE CASCADE " +
                " )";

        final String CREATE_TABLE_EVENT_TYPES_QUERY = "CREATE TABLE "+ CollegeFactionContract.EventTypeEntry.TABLE_NAME +" ( " +
                CollegeFactionContract.EventTypeEntry._ID             + " INTEGER PRIMARY KEY NOT NULL, " +
                CollegeFactionContract.EventTypeEntry.COL_NAME        + " VARCHAR(255) NOT NULL, " +
                CollegeFactionContract.EventTypeEntry.COL_CREATED_AT  + " DATETIME NULL DEFAULT NULL, " +
                CollegeFactionContract.EventTypeEntry.COL_UPDATED_AT  + " DATETIME NULL DEFAULT NULL " +
                ")";

        final String CREATE_TABLE_EVENTS_QUERY = "CREATE TABLE "+ CollegeFactionContract.EventsEntry.TABLE_NAME +" ( " +
                CollegeFactionContract.EventsEntry._ID                    + " INTEGER PRIMARY KEY NOT NULL, " +
                CollegeFactionContract.EventsEntry.COL_INVITER_ID         + " INTEGER NOT NULL, " +
                CollegeFactionContract.EventsEntry.COL_EVENT_DATE         + " DATE NOT NULL, " +
                CollegeFactionContract.EventsEntry.COL_EVENT_TYPE_ID      + " INTEGER NOT NULL, " +
                CollegeFactionContract.EventsEntry.COL_DESCRIPTION        + " LONGTEXT NOT NULL, " +
                CollegeFactionContract.EventsEntry.COL_POSTER             + " INTEGER NOT NULL, " +
                CollegeFactionContract.EventsEntry.COL_CREATED_AT         + " DATETIME NULL DEFAULT NULL, " +
                CollegeFactionContract.EventsEntry.COL_UPDATED_AT         + " DATETIME NULL DEFAULT NULL, " +
                " FOREIGN KEY ( " + CollegeFactionContract.EventsEntry.COL_EVENT_TYPE_ID  + " ) REFERENCES "+ CollegeFactionContract.EventTypeEntry.TABLE_NAME+"( " + CollegeFactionContract.EventTypeEntry._ID +") ON DELETE CASCADE, " +
                " FOREIGN KEY ( " + CollegeFactionContract.EventsEntry.COL_INVITER_ID  + " ) REFERENCES "+ CollegeFactionContract.UserEntry.TABLE_NAME+"( " + CollegeFactionContract.UserEntry._ID +") ON DELETE CASCADE, " +
                " FOREIGN KEY ( " + CollegeFactionContract.EventsEntry.COL_POSTER  + " ) REFERENCES "+ CollegeFactionContract.BannerEntry.TABLE_NAME+"( " + CollegeFactionContract.BannerEntry._ID +") ON DELETE CASCADE " +
                " ) ";

        Log.v("DB","Starting executing Db queries");
        sqLiteDatabase.execSQL(CREATE_TABLE_BANNER_TYPES_QUERY);
        sqLiteDatabase.execSQL(CREATE_TABLE_BANNERS_QUERY);
        sqLiteDatabase.execSQL(CREATE_TABLE_INSTITUTIONS_QUERY);
        sqLiteDatabase.execSQL(CREATE_TABLE_COURSES_QUERY);
        sqLiteDatabase.execSQL(CREATE_TABLE_USER_TYPES_QUERY);
        sqLiteDatabase.execSQL(CREATE_TABLE_USERS_QUERY);
        sqLiteDatabase.execSQL(CREATE_TABLE_USER_CAREERS_QUERY);
        sqLiteDatabase.execSQL(CREATE_TABLE_REQUEST_TYPES_QUERY);
        sqLiteDatabase.execSQL(CREATE_TABLE_FRIEND_REQUESTS_QUERY);
        sqLiteDatabase.execSQL(CREATE_TABLE_POSTS_QUERY);
        sqLiteDatabase.execSQL(CREATE_TABLE_POST_LIKES_QUERY);
        sqLiteDatabase.execSQL(CREATE_TABLE_POST_COMMENT_TYPES_QUERY);
        sqLiteDatabase.execSQL(CREATE_TABLE_POST_COMMENTS_QUERY);
        sqLiteDatabase.execSQL(CREATE_TABLE_POST_SHARES_QUERY);
        sqLiteDatabase.execSQL(CREATE_TABLE_EVENT_TYPES_QUERY);
        sqLiteDatabase.execSQL(CREATE_TABLE_EVENTS_QUERY);
        Log.v("DB","queries executed on Db");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ CollegeFactionContract.EventsEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ CollegeFactionContract.EventTypeEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ CollegeFactionContract.PostShareEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ CollegeFactionContract.PostCommentsEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ CollegeFactionContract.PostCommentTypeEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ CollegeFactionContract.PostLikesEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ CollegeFactionContract.PostsEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ CollegeFactionContract.FriendRequestEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ CollegeFactionContract.RequestTypeEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ CollegeFactionContract.UserCareerEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ CollegeFactionContract.UserEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ CollegeFactionContract.UserTypeEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ CollegeFactionContract.CourseEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ CollegeFactionContract.InstitutionEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ CollegeFactionContract.BannerEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ CollegeFactionContract.BannerTypeEntry.TABLE_NAME);

        onCreate(sqLiteDatabase);
    }
}
