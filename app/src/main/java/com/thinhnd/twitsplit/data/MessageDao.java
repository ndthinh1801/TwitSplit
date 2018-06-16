package com.thinhnd.twitsplit.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by ThinhND on 6/16/2018.
 */

@Dao
public interface MessageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Message message);

    @Query("DELETE FROM message_table")
    void deleteAll();

    @Query("SELECT * from message_table")
    List<Message> getAllMessages();
}
