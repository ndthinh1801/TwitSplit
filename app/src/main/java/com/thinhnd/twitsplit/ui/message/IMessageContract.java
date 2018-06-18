package com.thinhnd.twitsplit.ui.message;

import com.thinhnd.twitsplit.BaseView;
import com.thinhnd.twitsplit.data.Message;

import java.util.List;

/**
 * Created by ThinhND on 6/18/2018.
 *
 * This specifies the contract between the view and the presenter.
 *
 */
public interface IMessageContract {
    interface IMessageView extends BaseView<IMessagePresenter> {

        void showSuccessfullySavedMessage();

        void showNoMessage();

        void loadMessage(List<Message> messageList);

        void showAddMessage();
    }

    interface IMessagePresenter {

        void start();

        void showAddMessage();

        void showSuccessfullySavedMessage();
    }
}
