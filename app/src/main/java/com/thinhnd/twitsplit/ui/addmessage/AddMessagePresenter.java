package com.thinhnd.twitsplit.ui.addmessage;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.thinhnd.twitsplit.data.IRepository;
import com.thinhnd.twitsplit.data.Message;
import com.thinhnd.twitsplit.utils.StringUtils;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by ThinhND on 6/17/2018.
 */
public class AddMessagePresenter implements IAddMessageContract.IAddMessagePresenter {

    private IRepository mMessageRepository;
    private WeakReference<IAddMessageContract.IAddMessageView> mAddMessageView;

    public AddMessagePresenter(@NonNull IAddMessageContract.IAddMessageView addMessageView, @NonNull IRepository messageRepository) {
        this.mMessageRepository = messageRepository;
        this.mAddMessageView = new WeakReference<>(addMessageView);
        mAddMessageView.get().setPresenter(this);
    }

    @Override
    public void saveMessage(String userName, String screenName, String content) {
        if (TextUtils.isEmpty(userName) || userName.trim().length() == 0) {
            mAddMessageView.get().showNoUserNameError();
            return;
        }

        if (TextUtils.isEmpty(screenName) || screenName.trim().length() == 0) {
            mAddMessageView.get().showNoScreenNameError();
            return;
        }
        List<String> results = StringUtils.splitMessage(content);
        if (results.size() == 0) {
            if (mAddMessageView.get() != null) {
                mAddMessageView.get().showError();
            }
        } else {
            for (String txt : results) {
                Message message = new Message(userName, screenName, System.currentTimeMillis(), txt);
                mMessageRepository.insert(message);
            }
            if (mAddMessageView.get() != null) {
                mAddMessageView.get().showMessageList();
            }
        }
    }

}
