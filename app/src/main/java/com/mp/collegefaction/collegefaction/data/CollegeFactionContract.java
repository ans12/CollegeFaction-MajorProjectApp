package com.mp.collegefaction.collegefaction.data;

import android.net.Uri;
import android.provider.BaseColumns;

class CollegeFactionContract {

    static final String CONTENT_AUTHORITY = "com.mp.collegefaction.collegefaction.data";

    private static final Uri BASE_CONTENT_URI = Uri.parse("content://"+CONTENT_AUTHORITY);

    public static final class BannerTypeEntry implements BaseColumns {
        public static final String TABLE_NAME = "banner_types";
        public static final String COL_TYPE_NAME = "type_name";
        public static final String COL_CREATED_AT = "created_at";
        public static final String COL_UPDATED_AT = "updated_at";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
    }

    public static final class BannerEntry implements BaseColumns {
        public static final String TABLE_NAME = "banners";
        public static final String COL_NAME = "name";
        public static final String COL_SOURCE = "src";
        public static final String COL_BANNER_TYPE_ID = "banner_type_id";
        public static final String COL_CREATED_AT = "created_at";
        public static final String COL_UPDATED_AT = "updated_at";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
    }

    public static final class InstitutionEntry implements BaseColumns {
        public static final String TABLE_NAME = "institutions";
        public static final String COL_INSTITUTION_NAME = "name";
        public static final String COL_ADDRESS = "address";
        public static final String COL_CREATED_AT = "created_at";
        public static final String COL_UPDATED_AT = "updated_at";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
    }

    public static final class CourseEntry implements BaseColumns {
        public static final String TABLE_NAME = "courses";
        public static final String COL_COURSE_NAME = "course_name";
        public static final String COL_CREATED_AT = "created_at";
        public static final String COL_UPDATED_AT = "updated_at";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
    }

    public static final class UserTypeEntry implements BaseColumns {
        public static final String TABLE_NAME = "user_types";
        public static final String COL_TYPE_NAME = "type_name";
        public static final String COL_CREATED_AT = "created_at";
        public static final String COL_UPDATED_AT = "updated_at";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
    }

    public static final class UserEntry implements BaseColumns {

        public static final String TABLE_NAME = "users";
        public static final String COL_NAME = "name";
        public static final String COL_EMAIL = "email";
        public static final String COL_PASSWORD = "password";
        public static final String COL_REMEMBER_TOKEN = "remember_token";
        public static final String COL_USER_NAME = "username";
        public static final String COL_BANNER_ID = "banner_id";
        public static final String COL_DOB = "dob";
        public static final String COL_ADDRESS = "address";
        public static final String COL_INSTITUTION_ID = "institution_id";
        public static final String COL_USER_TYPE_ID = "user_type_id";
        public static final String COL_STATUS = "status";
        public static final String COL_ALUMINI_STATUS = "alumini_status";
        public static final String COL_MOBILE = "mobile";
        public static final String COL_WORKING_STATUS = "working_status";
        public static final String COL_YEAR_OF_PASSING = "year_of_passing";
        public static final String COL_COURSE_ID = "course_id";
        public static final String COL_CREATED_AT = "created_at";
        public static final String COL_UPDATED_AT = "updated_at";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
    }

    public static final class UserCareerEntry implements BaseColumns {
        public static final String TABLE_NAME = "user_careers";
        public static final String COL_USER_ID = "user_id";
        public static final String COL_ORGANIZATION = "organization";
        public static final String COL_POSITION = "position";
        public static final String COL_LOCATION = "location";
        public static final String COL_STARTED_IN = "started_in";
        public static final String COL_WORKED_UPTO = "worked_upto";
        public static final String COL_REVIEW = "review";
        public static final String COL_CREATED_AT = "created_at";
        public static final String COL_UPDATED_AT = "updated_at";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
    }

    public static final class RequestTypeEntry implements BaseColumns {
        public static final String TABLE_NAME = "request_types";
        public static final String COL_TYPE_NAME = "type_name";
        public static final String COL_CREATED_AT = "created_at";
        public static final String COL_UPDATED_AT = "updated_at";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
    }

    public static final class FriendRequestEntry implements BaseColumns {
        public static final String TABLE_NAME = "friend_requests";
        public static final String COL_SENDER_ID = "sender_id";
        public static final String COL_RECEIVER_ID = "receiver_id";
        public static final String COL_REQUEST_TYPE_ID = "request_type_id";
        public static final String COL_CREATED_AT = "created_at";
        public static final String COL_UPDATED_AT = "updated_at";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
    }

    public static final class PostsEntry implements BaseColumns {
        public static final String TABLE_NAME = "posts";
        public static final String COL_SENDER_ID = "sender_id";
        public static final String COL_CONTENT = "content";
        public static final String COL_BANNER_ID = "banner_id";
        public static final String COL_CREATED_AT = "created_at";
        public static final String COL_UPDATED_AT = "updated_at";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
    }

    public static final class PostLikesEntry implements BaseColumns {
        public static final String TABLE_NAME = "post_likes";
        public static final String COL_USER_ID = "user_id";
        public static final String COL_POST_ID = "post_id";
        public static final String COL_CREATED_AT = "created_at";
        public static final String COL_UPDATED_AT = "updated_at";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
    }

    public static final class PostCommentTypeEntry implements BaseColumns {
        public static final String TABLE_NAME = "post_comments_types";
        public static final String COL_NAME = "name";
        public static final String COL_CREATED_AT = "created_at";
        public static final String COL_UPDATED_AT = "updated_at";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
    }

    public static final class PostCommentsEntry implements BaseColumns {
        public static final String TABLE_NAME = "post_comments";
        public static final String COL_POST_COMMENT_TYPE = "post_comment_type_id";
        public static final String COL_USER_ID = "user_id";
        public static final String COL_CONTENT = "content";
        public static final String COL_LIKE_COUNT = "like_count";
        public static final String COL_POST_ID = "post_id";
        public static final String COL_CREATED_AT = "created_at";
        public static final String COL_UPDATED_AT = "updated_at";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
    }

    public static final class PostShareEntry implements BaseColumns {
        public static final String TABLE_NAME = "post_shares";
        public static final String COL_USER_ID = "user_id";
        public static final String COL_POST_ID = "post_id";
        public static final String COL_CREATED_AT = "created_at";
        public static final String COL_UPDATED_AT = "updated_at";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
    }

    public static final class EventTypeEntry implements BaseColumns {
        public static final String TABLE_NAME = "event_types";
        public static final String COL_NAME = "name";
        public static final String COL_CREATED_AT = "created_at";
        public static final String COL_UPDATED_AT = "updated_at";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
    }

    public static final class EventsEntry implements BaseColumns {
        public static final String TABLE_NAME = "events";
        public static final String COL_INVITER_ID = "inviter_id";
        public static final String COL_EVENT_DATE = "event_date";
        public static final String COL_EVENT_TYPE_ID = "event_type_id";
        public static final String COL_DESCRIPTION = "description";
        public static final String COL_POSTER = "poster";
        public static final String COL_CREATED_AT = "created_at";
        public static final String COL_UPDATED_AT = "updated_at";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
    }



}