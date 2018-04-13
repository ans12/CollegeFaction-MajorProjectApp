package com.mp.collegefaction.collegefaction.data;

import android.net.Uri;
import android.provider.BaseColumns;

public class CollegeFactionContract {

    private static final String CONTENT_AUTHORITY = "com.mp.collegefaction.collegefaction.data";

    private static final Uri BASE_CONTENT_URI = Uri.parse("content://"+CONTENT_AUTHORITY);

    public static final class UserEntry implements BaseColumns {

        public static final String TABLE_NAME = "user";
        public static final String COL_USER_NAME = "username";
        public static final String COL_FIRST_NAME = "firstname";
        public static final String COL_LAST_NAME = "lastname";
        public static final String COL_PROFILE_PIC = "profile_pic";
        public static final String COL_EMAIL = "email";
        public static final String COL_DOB = "dob";
        public static final String COL_PASSWORD = "password";
        public static final String COL_TYPE = "type";
        public static final String COL_STATUS = "status";
        public static final String COL_ALUMINI_STATUS = "alimuni_status";
        public static final String COL_MOBILE = "mobile";
        public static final String COL_CURRENT_STATUS = "current_status";
        public static final String COL_YEAR_OF_PASSING = "year_of_passing";
        public static final String COL_COURSE = "course";
        public static final String COL_QUOTE = "quote";
        public static final String COL_CREATED = "created";
        public static final String COL_MODIFIED = "modified";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
    }

    public static final class UserCareerEntry implements BaseColumns {
        public static final String TABLE_NAME = "user_career";
        public static final String COL_USER_ID = "user_id";
        public static final String COL_ORGANIZATION = "organization";
        public static final String COL_POSITION = "position";
        public static final String COL_LOCATION = "location";
        public static final String COL_START = "start";
        public static final String COL_UPTO = "upto";
        public static final String COL_REVIEW = "review";
        public static final String COL_CREATED = "created";
        public static final String COL_MODIFIED = "modified";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
    }

    public static final class TypeEntry implements BaseColumns {
        public static final String TABLE_NAME = "type";
        public static final String COL_TYPE_NAME = "type_name";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
    }

    public static final class FriendRequestEntry implements BaseColumns {
        public static final String TABLE_NAME = "friend_request";
        public static final String COL_SENDER_ID = "sender_id";
        public static final String COL_RECEIVER_ID = "receiver_id";
        public static final String COL_STATUS = "status";
        public static final String COL_CREATED = "created";
        public static final String COL_MODIFIED = "modified";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
    }

    public static final class PostsEntry implements BaseColumns {
        public static final String TABLE_NAME = "posts";
        public static final String COL_SENDER_ID = "sender_id";
        public static final String COL_CONTENT = "content";
        public static final String COL_BANNER = "banner";
        public static final String COL_CREATED = "created";
        public static final String COL_MODIFIED = "modified";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
    }

    public static final class RequestTypeEntry implements BaseColumns {
        public static final String TABLE_NAME = "request_type";
        public static final String COL_NAME = "name";
        public static final String COL_CREATED = "created";
        public static final String COL_MODIFIED = "modified";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
    }

    public static final class PostCommentsEntry implements BaseColumns {
        public static final String TABLE_NAME = "post_comments";
        public static final String COL_TYPE = "type";
        public static final String COL_USER_ID = "user_id";
        public static final String COL_CONTENT = "content";
        public static final String COL_LIKE_COUNT = "like_count";
        public static final String COL_POST_ID = "post_id";
        public static final String COL_CREATED = "created";
        public static final String COL_MODIFIED = "modified";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
    }

    public static final class PostCommentTypeEntry implements BaseColumns {
        public static final String TABLE_NAME = "post_comments_type";
        public static final String COL_NAME = "name";
        public static final String COL_CREATED = "created";
        public static final String COL_MODIFIED = "modified";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
    }

    public static final class PostLikesEntry implements BaseColumns {
        public static final String TABLE_NAME = "post_likes";
        public static final String COL_USER_ID = "user_id";
        public static final String COL_POST_ID = "post_id";
        public static final String COL_CREATED = "created";
        public static final String COL_MODIFIED = "modified";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
    }

    public static final class PostShareEntry implements BaseColumns {
        public static final String TABLE_NAME = "post_share";
        public static final String COL_USER_ID = "user_id";
        public static final String COL_POST_ID = "post_id";
        public static final String COL_CREATED = "created";
        public static final String COL_MODIFIED = "modified";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
    }

    public static final class EventsEntry implements BaseColumns {
        public static final String TABLE_NAME = "events";
        public static final String COL_INVITER = "inviter";
        public static final String COL_DATE = "date";
        public static final String COL_EVENT_TYPE = "event_type";
        public static final String COL_DESCRIPTION = "description";
        public static final String COL_POSTER = "poster";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
    }

    public static final class EventTypeEntry implements BaseColumns {
        public static final String TABLE_NAME = "event_type";
        public static final String COL_NAME = "name";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
    }

    public static final class InstitutionEntry implements BaseColumns {
        public static final String TABLE_NAME = "institution";
        public static final String COL_INSTITUTION_NAME = "institution_name";
        public static final String COL_ADDRESS = "address";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
    }

    public static final class BannerEntry implements BaseColumns {
        public static final String TABLE_NAME = "banner";
        public static final String COL_NAME = "name";
        public static final String COL_SOURCE = "src";
        public static final String COL_TYPE = "type";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
    }

    public static final class BannerTypeEntry implements BaseColumns {
        public static final String TABLE_NAME = "banner_type";
        public static final String COL_TYPE_NAME = "type_name";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
    }

    public static final class CourseEntry implements BaseColumns {
        public static final String TABLE_NAME = "course";
        public static final String COL_COURSE_NAME = "course_name";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
    }
}