package com.thinhnd.twitsplit.ui.addmessage;

import com.thinhnd.twitsplit.BaseView;

/**
 * Created by ThinhND on 6/18/2018.
 *
 * This specifies the contract between the view and the presenter.
 *
 */
public interface IAddMessageContract {
    interface IAddMessageView extends BaseView<IAddMessagePresenter> {
        void showNoUserNameError();

        void showNoScreenNameError();

        void showError();

        void showMessageList();
    }

    interface IAddMessagePresenter {
        void saveMessage(String userName, String screenName, String content);
    }
}
