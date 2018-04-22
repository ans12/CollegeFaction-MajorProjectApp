package com.mp.collegefaction.collegefaction.adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mp.collegefaction.collegefaction.R;

/**
 * Created by pranjul on 18/4/18.
 * an adapter for post details activity views.
 */

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentViewHolder> {

    private Cursor cursor;
    private final Context context;
    private final int VIEW_TYPE_POST = 0;
    private final int VIEW_TYPE_COMMENT = 1;

    public CommentsAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if ( position == 0 ) return VIEW_TYPE_POST;
        else return VIEW_TYPE_COMMENT;
    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutId;
        switch (viewType){
            case VIEW_TYPE_POST:{
                layoutId = R.layout.single_item_post;
                break;
            }
            case VIEW_TYPE_COMMENT:{
                layoutId = R.layout.single_comment_layout;
                break;
            }
            default: throw new IllegalArgumentException("View type is invalid "+viewType);
        }

        View view = LayoutInflater.from(context).inflate(layoutId, parent,false);
        view.setFocusable(true);
        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CommentViewHolder holder, int position) {
        if (position == 0){
            holder.postShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view,"Post will be shared when connected to database server for sync.",Snackbar.LENGTH_SHORT).show();
                }
            });

            holder.postLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (holder.postLike.getCurrentTextColor() == context.getResources().getColor(R.color.colorPrimary)) {
                        holder.postLike.setTextColor(context.getResources().getColor(R.color.colorSecondaryText));
                        holder.postLike.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_like_gray, 0, 0, 0);
                    } else {
                        holder.postLike.setTextColor(context.getResources().getColor(R.color.colorPrimary));
                        holder.postLike.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_like_purple, 0, 0, 0);
                    }
                }
            });
        }
    }

    public void swapCursor(Cursor newCursor){
        cursor = newCursor;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder{

        public TextView tv_name, tv_comment;
        public ImageView iv_profile;
        public TextView postLike, postComment, postShare;
        public CommentViewHolder(View itemView) {
            super(itemView);
            iv_profile = itemView.findViewById(R.id.image_comment_poster);
            tv_comment = itemView.findViewById(R.id.comment);
            tv_name = itemView.findViewById(R.id.name_comment_poster);
            postLike = itemView.findViewById(R.id.like_post);
            postComment = itemView.findViewById(R.id.comment_post);
            postShare = itemView.findViewById(R.id.share_post);
        }

    }
}
