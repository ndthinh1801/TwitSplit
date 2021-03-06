package com.thinhnd.twitsplit.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by ThinhND on 6/16/2018.
 */
@Database(entities = {Message.class}, version = 1)
public abstract class MessageRoomDatabase extends RoomDatabase {
    public abstract MessageDao messageDao();

    private static MessageRoomDatabase INSTANCE;


    static MessageRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MessageRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context,
                            MessageRoomDatabase.class, "message_database")
                            .build();

                }
            }
        }
        return INSTANCE;
    }
}
