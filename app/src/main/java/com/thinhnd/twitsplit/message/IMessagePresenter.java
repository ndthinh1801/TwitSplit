package com.thinhnd.twitsplit.message;

import com.thinhnd.twitsplit.BasePresenter;

/**
 * Created by ThinhND on 6/14/2018.
 */
public interface IMessagePresenter extends BasePresenter {

    void showAddMessage();
    void showError();
    void showMessage();
}
