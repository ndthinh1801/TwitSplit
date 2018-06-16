package com.thinhnd.twitsplit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.thinhnd.twitsplit.data.Message;

import java.util.List;

/**
 * Created by ThinhND on 6/15/2018.
 */
public class MessageListAdapter extends RecyclerView.Adapter<MessageListAdapter.MessageViewHolder> {

    private Context mContext;
    private List<Message> mMessageList;

    class MessageViewHolder extends RecyclerView.ViewHolder {
        private ImageView mIvAvatar;
        private TextView mTvName;
        private TextView mTvScreenName;
        private TextView mTvDuration;
        private TextView mTvText;

        private MessageViewHolder(View itemView) {
            super(itemView);
            mIvAvatar = itemView.findViewById(R.id.iv_avatar);
            mTvName = itemView.findViewById(R.id.tv_name);
            mTvScreenName = itemView.findViewById(R.id.tv_screenName);
            mTvDuration = itemView.findViewById(R.id.tv_duration);
            mTvText = itemView.findViewById(R.id.tv_text);
        }
    }


    public MessageListAdapter(Context context, List<Message> messages) {
        this.mContext = context;
        setList(messages);
    }

    public void replaceData(List<Message> messages) {
        setList(messages);
        notifyDataSetChanged();
    }

    private void setList(List<Message> messages) {
        if (messages != null) {
            mMessageList = messages;
        }
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_message, parent, false);
        return new MessageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        Message message = mMessageList.get(position);
        holder.mTvName.setText(message.getUserName());
        holder.mTvScreenName.setText(message.getUserScreenName());
        holder.mTvDuration.setText(message.getTimestamp().toString());
        holder.mTvText.setText(message.getContent());
    }

    @Override
    public int getItemCount() {
        return mMessageList.size();
    }
}
