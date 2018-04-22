package com.mp.collegefaction.collegefaction.adapters;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mp.collegefaction.collegefaction.R;

/**
 * Created by pranjul on 17/4/18.
 * An adapter class for binding friend request data with view.
 */

public class FriendRequestAdapter extends RecyclerView.Adapter<FriendRequestAdapter.FriendRequestViewHolder>{


    private final Context mContext;


    public FriendRequestAdapter(Context mContext) {
        this.mContext = mContext;
    }


    @Override
    public FriendRequestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_request,parent,false);
        view.setFocusable(true);
        return new FriendRequestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FriendRequestViewHolder holder, int position) {
        holder.deleteRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Request will be dismissed.", Snackbar.LENGTH_SHORT).show();
            }
        });


        holder.acceptRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Request will be accepted.", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public class FriendRequestViewHolder extends RecyclerView.ViewHolder{

        public ImageView ivProfilePhoto;
        public TextView senderName;
        public Button acceptRequest, deleteRequest;
        public RelativeLayout parentLayout;
        public FriendRequestViewHolder(View itemView) {
            super(itemView);
            ivProfilePhoto = itemView.findViewById(R.id.iv_photo);
            senderName = itemView.findViewById(R.id.tv_name_sender);
            acceptRequest = itemView.findViewById(R.id.btn_accept);
            deleteRequest = itemView.findViewById(R.id.btn_delete);
            parentLayout = itemView.findViewById(R.id.parent_layout_request);

        }

    }
}
