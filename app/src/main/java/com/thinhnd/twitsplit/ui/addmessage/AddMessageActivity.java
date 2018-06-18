package com.thinhnd.twitsplit.ui.addmessage;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.thinhnd.twitsplit.R;
import com.thinhnd.twitsplit.data.IRepository;
import com.thinhnd.twitsplit.data.MessageRepository;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddMessageActivity extends AppCompatActivity implements IAddMessageContract.IAddMessageView {

    private AddMessagePresenter mAddMessagePresenter;

    @BindView(R.id.add_message_username)
    EditText mEdtUser;
    @BindView(R.id.add_message_screenname)
    EditText mEdtScreenName;
    @BindView(R.id.add_message_content)
    EditText mEdtContent;
    @BindView(R.id.fab)
    FloatingActionButton mFab;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_message);
        setTitle(getString(R.string.add_message_screen_title));
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        mAddMessagePresenter = new AddMessagePresenter(this, MessageRepository.getInstance(getApplicationContext()));

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAddMessagePresenter.saveMessage(mEdtUser.getText().toString(), mEdtScreenName.getText().toString(), mEdtContent.getText().toString());
            }
        });
    }

    @Override
    public void showNoUserNameError() {
        showMessage(getString(R.string.user_name_blank_error));
    }

    @Override
    public void showNoScreenNameError() {
        showMessage(getString(R.string.screen_name_blank_error));
    }

    @Override
    public void showError() {
        showMessage(getString(R.string.message_not_valid_error));
    }

    /**
     * return to message list screen
     */
    @Override
    public void showMessageList() {
        setResult(RESULT_OK);
        finish();
    }

    @Override
    public void setPresenter(IAddMessageContract.IAddMessagePresenter presenter) {
        mAddMessagePresenter = (AddMessagePresenter) presenter;
    }

    private void showMessage(String message) {
        Snackbar.make(mEdtUser, message, Snackbar.LENGTH_LONG).show();
    }
}
