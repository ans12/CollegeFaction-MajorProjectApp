package com.mp.collegefaction.collegefaction.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mp.collegefaction.collegefaction.MessageActivity;
import com.mp.collegefaction.collegefaction.R;

/**
 * Created by pranjul on 17/4/18.
 * An adapter class for binding friend request data with view.
 */

public class FriendRequestAdapter extends RecyclerView.Adapter<FriendRequestAdapter.FriendRequestViewHolder>{


    private final Context mContext;

    public static final int VIEW_TYPE_FRIEND_REQUEST = 0;
    public static final int VIEW_TYPE_PEOPLE_KNOW = 1;

    public FriendRequestAdapter(Context mContext) {
        this.mContext = mContext;
    }


    @Override
    public int getItemViewType(int position) {
        if (position < 4)
            return VIEW_TYPE_FRIEND_REQUEST;
        else return VIEW_TYPE_PEOPLE_KNOW;
    }

    @Override
    public FriendRequestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutId;
        switch (viewType){
            case VIEW_TYPE_FRIEND_REQUEST:{
                layoutId = R.layout.list_item_request;
                break;
            }
            case VIEW_TYPE_PEOPLE_KNOW:{
                layoutId = R.layout.item_circle_people;
                break;
            }
            default:throw new IllegalArgumentException("Invalid value of viewType for Friend Request: "+viewType);
        }

        View view = LayoutInflater.from(mContext).inflate(layoutId,parent,false);
        view.setFocusable(true);
        return new FriendRequestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FriendRequestViewHolder holder, int position) {
        if (getItemViewType(position) == VIEW_TYPE_FRIEND_REQUEST) {
            holder.deleteRequest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Request will be dismissed.", Snackbar.LENGTH_SHORT).show();
                }
            });

            holder.acceptRequest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Request will be accepted.", Snackbar.LENGTH_SHORT).show();
                }
            });
        } else if (getItemViewType(position) == VIEW_TYPE_PEOPLE_KNOW){
            holder.messageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, MessageActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return 18;
    }

    public class FriendRequestViewHolder extends RecyclerView.ViewHolder{

        public ImageView ivProfilePhoto;
        public TextView senderName;
        public Button acceptRequest, deleteRequest, messageButton;
        public RelativeLayout parentLayout;
        public FriendRequestViewHolder(View itemView) {
            super(itemView);
            ivProfilePhoto = itemView.findViewById(R.id.iv_photo);
            senderName = itemView.findViewById(R.id.tv_name_sender);
            acceptRequest = itemView.findViewById(R.id.btn_accept);
            deleteRequest = itemView.findViewById(R.id.btn_delete);
            messageButton = itemView.findViewById(R.id.message_btn);
            parentLayout = itemView.findViewById(R.id.parent_layout_request);

        }

    }
}
