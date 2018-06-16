package com.thinhnd.twitsplit.data;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.thinhnd.twitsplit.utils.executors.AppExecutors;

import java.util.List;

/**
 * Created by ThinhND on 6/16/2018.
 */
public class MessageRepository implements IRepository {

    private static MessageRepository INSTANCE = null;
    private MessageDao mMessageDao;
    private AppExecutors mAppExecutors;

    private MessageRepository(Context context) {
        MessageRoomDatabase database = MessageRoomDatabase.getDatabase(context);

        this.mMessageDao = database.messageDao();
        this.mAppExecutors = new AppExecutors();
    }

    public static MessageRepository getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new MessageRepository(context);
        }
        return INSTANCE;
    }

    public void insert(@NonNull final Message message) {
        Runnable insertRunnable = new Runnable() {
            @Override
            public void run() {
                mMessageDao.insert(message);
            }
        };
        mAppExecutors.diskIO().execute(insertRunnable);
    }

    public void getAllMessages(@NonNull final LoadMessageCallBack callBack) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final List<Message> messages = mMessageDao.getAllMessages();
                mAppExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        if (messages.isEmpty()) {
                            // This will be called if the table is new or just empty.
                            callBack.onDataNotAvailable();
                        } else {
                            callBack.onMessagesLoaded(messages);
                        }
                    }
                });
            }
        };
        mAppExecutors.diskIO().execute(runnable);
    }

}
