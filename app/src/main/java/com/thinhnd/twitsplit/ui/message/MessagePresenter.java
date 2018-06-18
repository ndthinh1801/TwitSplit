package com.thinhnd.twitsplit.ui.message;


import android.support.annotation.NonNull;

import com.thinhnd.twitsplit.data.IRepository;
import com.thinhnd.twitsplit.data.LoadMessageCallBack;
import com.thinhnd.twitsplit.data.Message;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by ThinhND on 6/14/2018.
 */
public class MessagePresenter implements IMessageContract.IMessagePresenter {

    private IRepository mMessageRepository;
    private WeakReference<IMessageContract.IMessageView> mMessageView;

    public MessagePresenter(@NonNull IMessageContract.IMessageView view, @NonNull IRepository messageRepository) {
        this.mMessageRepository = messageRepository;
        this.mMessageView = new WeakReference<>(view);
        mMessageView.get().setPresenter(this);
    }

    /**
     * Navigate to Adding Message screen
     */
    @Override
    public void showAddMessage() {
        mMessageView.get().showAddMessage();
    }


    /**
     * Show notification when messages are successfully saved
     */
    @Override
    public void showSuccessfullySavedMessage() {
        mMessageView.get().showSuccessfullySavedMessage();
    }

    /**
     * Start get all message from database when open activity
     */
    @Override
    public void start() {
        mMessageRepository.getAllMessages(new LoadMessageCallBack() {
            @Override
            public void onMessagesLoaded(List<Message> messages) {
                if (mMessageView.get() != null) {
                    mMessageView.get().loadMessage(messages);
                }
            }

            @Override
            public void onDataNotAvailable() {
                if (mMessageView.get() != null) {
                    mMessageView.get().showNoMessage();
                }
            }
        });
    }
}
