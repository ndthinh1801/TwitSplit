package com.thinhnd.twitsplit.data;

import android.support.annotation.NonNull;

/**
 * Created by ThinhND on 6/16/2018.
 */
public interface IRepository {
    public void insert(@NonNull final Message message);
    public void getAllMessages(@NonNull final LoadMessageCallBack callBack);
}
