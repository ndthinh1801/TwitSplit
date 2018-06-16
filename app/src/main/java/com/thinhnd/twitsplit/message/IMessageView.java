package com.thinhnd.twitsplit.message;

import com.thinhnd.twitsplit.BaseView;

/**
 * Created by ThinhND on 6/14/2018.
 */
public interface IMessageView extends BaseView<MessagePresenter> {

    void showSuccessfullySavedMessage();

    void showNoMessage();

    void loadMessage();

    void showAddMessage();
}
