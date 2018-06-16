package com.thinhnd.twitsplit.utils.executors;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by ThinhND on 6/16/2018.
 */
public class AppExecutors {
    private final Executor diskIO;

    private final Executor mainThread;

    AppExecutors(Executor diskIO, Executor mainThread) {
        this.diskIO = diskIO;
        this.mainThread = mainThread;
    }

    public AppExecutors() {
        this(new DiskIOThreadExecutor(),
                new MainThreadExecutor());
    }

    public Executor diskIO() {
        return diskIO;
    }


    public Executor mainThread() {
        return mainThread;
    }
}
