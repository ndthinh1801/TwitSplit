package com.thinhnd.twitsplit.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by ThinhND on 6/16/2018.
 */

@Entity(tableName = "message_table")
public class Message {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "user")
    String mUserName;

    @NonNull
    @ColumnInfo(name = "screen_name")
    String mUserScreenName;

    @NonNull
    @ColumnInfo(name = "time_stamp")
    Long mTimestamp;

    @NonNull
    @ColumnInfo(name = "content")
    String mContent;

    public Message(){}

    @Ignore
    public Message(@NonNull String userName, @NonNull String userScreenName, @NonNull Long timestamp, @NonNull String content) {
        this.mUserName = userName;
        this.mUserScreenName = userScreenName;
        this.mTimestamp = timestamp;
        this.mContent = content;
    }

    @NonNull
    public String getUserName() {
        return mUserName;
    }

    @NonNull
    public Long getTimestamp() {
        return mTimestamp;
    }

    @NonNull
    public String getContent() {
        return mContent;
    }

    @NonNull
    public String getUserScreenName() {
        return mUserScreenName;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(@NonNull String mUserName) {
        this.mUserName = mUserName;
    }

    public void setUserScreenName(@NonNull String mUserScreenName) {
        this.mUserScreenName = mUserScreenName;
    }

    public void setTimestamp(@NonNull Long mTimestamp) {
        this.mTimestamp = mTimestamp;
    }

    public void setContent(@NonNull String mContent) {
        this.mContent = mContent;
    }
}
