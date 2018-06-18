package com.thinhnd.twitsplit.ui.message;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.thinhnd.twitsplit.MessageListAdapter;
import com.thinhnd.twitsplit.R;
import com.thinhnd.twitsplit.data.Message;
import com.thinhnd.twitsplit.data.MessageRepository;
import com.thinhnd.twitsplit.ui.addmessage.AddMessageActivity;
import com.thinhnd.twitsplit.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MessageActivity extends AppCompatActivity implements IMessageContract.IMessageView {

    @BindView(R.id.rv_message)
    RecyclerView mRvListMessage;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.fab)
    FloatingActionButton mFab;

    private MessageListAdapter mMessageAdapter;
    private MessagePresenter mMessagePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setTitle(getString(R.string.message_screen_title));
        setSupportActionBar(mToolbar);

        mMessagePresenter = new MessagePresenter(this, MessageRepository.getInstance(getApplicationContext()));
        mMessageAdapter = new MessageListAdapter(this, new ArrayList<Message>());
        mRvListMessage.setAdapter(mMessageAdapter);
        mRvListMessage.setLayoutManager(new LinearLayoutManager(this));


        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMessagePresenter.showAddMessage();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMessagePresenter.start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.NEW_ADD_MESSAGE_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            mMessagePresenter.showSuccessfullySavedMessage();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //noinspection SimplifiableIfStatement
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showSuccessfullySavedMessage() {
        showMessage(getString(R.string.saved_message_text));
    }

    @Override
    public void showNoMessage() {
        showMessage(getString(R.string.no_message_error));
    }

    @Override
    public void loadMessage(List<Message> messageList) {
        mMessageAdapter.replaceData(messageList);
    }

    private void showMessage(String message) {
        Snackbar.make(mRvListMessage, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showAddMessage() {
        Intent intent = new Intent(MessageActivity.this, AddMessageActivity.class);
        startActivityForResult(intent, Constants.NEW_ADD_MESSAGE_ACTIVITY_REQUEST_CODE);
    }

    @Override
    public void setPresenter(IMessageContract.IMessagePresenter presenter) {
        mMessagePresenter = (MessagePresenter) presenter;

    }
}
