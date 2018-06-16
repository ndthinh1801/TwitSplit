package com.thinhnd.twitsplit.message;


import android.support.annotation.NonNull;

import com.thinhnd.twitsplit.data.IRepository;

/**
 * Created by ThinhND on 6/14/2018.
 */
public class MessagePresenter implements IMessagePresenter {

    private IRepository mMessageRepository;
    private IMessageView mMessageView;

    public MessagePresenter(@NonNull IMessageView view, @NonNull IRepository messageRepository) {
        this.mMessageRepository = messageRepository;
        this.mMessageView = view;
        mMessageView.setPresenter(this);
    }

    @Override
    public void showAddMessage() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showMessage() {

    }

    @Override
    public void start() {

    }
}
