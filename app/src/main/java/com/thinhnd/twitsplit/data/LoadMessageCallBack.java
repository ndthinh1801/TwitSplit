package com.thinhnd.twitsplit.data;

import java.util.List;

/**
 * Created by ThinhND on 6/16/2018.
 */
public interface LoadMessageCallBack {
    void onMessagesLoaded(List<Message> messages);

    void onDataNotAvailable();
}
