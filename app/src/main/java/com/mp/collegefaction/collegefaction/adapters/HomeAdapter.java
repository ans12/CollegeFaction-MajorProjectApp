package com.mp.collegefaction.collegefaction.adapters;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mp.collegefaction.collegefaction.PostDetailActivity;
import com.mp.collegefaction.collegefaction.R;
import com.mp.collegefaction.collegefaction.WritePostActivity;

/**
 * Created by pranjul on 17/4/18.
 * An adapter class for binding post data with view.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder>{

    private final Context mContext;
    private Cursor mCursor;
    private static final int VIEW_TYPE_WRITE_POST = 0;
    private static final int VIEW_TYPE_POSTS = 1;

    public HomeAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        int layoutId;
        switch (viewType){
            case VIEW_TYPE_WRITE_POST:{
                layoutId = R.layout.home_first_item;
                break;
            }
            case VIEW_TYPE_POSTS:{
                layoutId = R.layout.item_post_view;
                break;
            }
            default:
                throw new IllegalArgumentException("Invalid value for view type :"+viewType);
        }
        View view = LayoutInflater.from(mContext).inflate(layoutId, parent, false);
        view.setFocusable(true);
        return new HomeViewHolder(view);

    }

    void swapCursor(Cursor newCursor) {
        mCursor = newCursor;
        notifyDataSetChanged();
    }

    private void callIntent(){
        Intent intent = new Intent(mContext, WritePostActivity.class);
        mContext.startActivity(intent);
    }

    @Override
    public void onBindViewHolder(final HomeViewHolder holder, int position) {
        if (position == 0) {
            holder.tv_write.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    callIntent();
                }
            });

            holder.et_write.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    callIntent();
                }
            });

            holder.tv_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    callIntent();
                }
            });

        } else {

            holder.postPic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, PostDetailActivity.class);
                    mContext.startActivity(intent);
                }
            });

            holder.postContent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, PostDetailActivity.class);
                    mContext.startActivity(intent);
                }
            });

            holder.progressBar.setVisibility(View.INVISIBLE);
            holder.postComment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, PostDetailActivity.class);
                    mContext.startActivity(intent);
                }
            });

            holder.postShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view,"Post will be shared when connected to database server for sync.",Snackbar.LENGTH_SHORT).show();
                }
            });

            holder.postLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (holder.postLike.getCurrentTextColor() == mContext.getResources().getColor(R.color.colorPrimary)) {
                        holder.postLike.setTextColor(mContext.getResources().getColor(R.color.colorSecondaryText));
                        holder.postLike.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_like_gray, 0, 0, 0);
                    } else {
                        holder.postLike.setTextColor(mContext.getResources().getColor(R.color.colorPrimary));
                        holder.postLike.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_like_purple, 0, 0, 0);
                    }
                }
            });
        }

    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0)
            return VIEW_TYPE_WRITE_POST;
        else
            return VIEW_TYPE_POSTS;
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {

        public ProgressBar progressBar;
        public ImageView postPic, posterProfilePic;
        public TextView postContent, timeStamp, writerName;
        public TextView postLike, postComment, postShare;
        public EditText commentBox, et_write;
        public Button btnPostCommment;
        public TextView tv_add, tv_write;

        public HomeViewHolder(View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.progress_indicator_for_img);
            postPic = itemView.findViewById(R.id.post_content_img);
            posterProfilePic = itemView.findViewById(R.id.profile_pic);
            writerName = itemView.findViewById(R.id.post_publisher);
            postContent = itemView.findViewById(R.id.post_content);
            timeStamp = itemView.findViewById(R.id.post_timestamp);
            postLike = itemView.findViewById(R.id.like_post);
            postComment = itemView.findViewById(R.id.comment_post);
            postShare = itemView.findViewById(R.id.share_post);
            commentBox = itemView.findViewById(R.id.comment_box);
            btnPostCommment = itemView.findViewById(R.id.post_comment_btn);

            //for first item in recycler view
            et_write = (EditText) itemView.findViewById(R.id.et_write_post);
            tv_write = (TextView) itemView.findViewById(R.id.tv_write_post);
            tv_add = (TextView) itemView.findViewById(R.id.tv_add_photo);
        }
    }
}
