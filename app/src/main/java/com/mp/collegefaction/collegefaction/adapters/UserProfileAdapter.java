package com.mp.collegefaction.collegefaction.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mp.collegefaction.collegefaction.MainActivity;
import com.mp.collegefaction.collegefaction.PostDetailActivity;
import com.mp.collegefaction.collegefaction.R;
import com.mp.collegefaction.collegefaction.UserProfilesActivity;

import org.w3c.dom.Text;

/**
 * Created by pranjul on 19/4/18.
 * An Adapter class for user profile view and its data binding.
 */

public class UserProfileAdapter extends RecyclerView.Adapter<UserProfileAdapter.UserProfileViewHolder>{

    private final Context context;
    private String TAG ;
    private final int VIEW_TYPE_USER_INFO = 0;
    private final int VIEW_TYPE_USER_POST = 1;
    public UserProfileAdapter(Context context) {
        this.context = context;
        this.TAG = null;
    }
    public UserProfileAdapter(Context context, String TAG) {
        this.context = context;
        this.TAG = TAG;
    }

    @Override
    public int getItemViewType(int position) {
        return ( position == 0 ) ? VIEW_TYPE_USER_INFO : VIEW_TYPE_USER_POST;
    }

    @Override
    public UserProfileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutId;
        switch (viewType){
            case VIEW_TYPE_USER_INFO:{
                layoutId = R.layout.single_item_profile;
                break;
            }
            case VIEW_TYPE_USER_POST:{
                layoutId = R.layout.item_post_view;
                break;
            }
            default: throw new IllegalArgumentException("Invalid value for viewtype "+viewType);
        }
        View view = LayoutInflater.from(context).inflate(layoutId, parent, false);
        view.setFocusable(true);
        return new UserProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final UserProfileViewHolder holder, int position) {
        if (position == 0){

            holder.editProfile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view,"Edit Profile Functionality is not available yet in app.",Snackbar.LENGTH_SHORT).show();
                }
            });
            if (context instanceof UserProfilesActivity || (TAG!= null && TAG.equals("Home Fragment")))
                holder.editProfile.setVisibility(View.GONE);
            holder.furtherDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view,"No further details available for now.",Snackbar.LENGTH_LONG).show();
                }
            });
        } else {

            holder.postShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view,"Post will be shared when connected to database server for sync.",Snackbar.LENGTH_SHORT).show();
                }
            });

            holder.postComment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, PostDetailActivity.class);
                    context.startActivity(intent);
                }
            });

            holder.postLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (holder.postLike.getCurrentTextColor() == context.getResources().getColor(R.color.colorPrimary)){
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

    @Override
    public int getItemCount() {
        return 5;
    }

    public class UserProfileViewHolder extends RecyclerView.ViewHolder{

        public TextView postLike, postComment, postShare;
        public TextView furtherDetails;
        public TextView editProfile;

        public UserProfileViewHolder(View itemView) {
            super(itemView);
            postLike = itemView.findViewById(R.id.like_post);
            postComment = itemView.findViewById(R.id.comment_post);
            postShare = itemView.findViewById(R.id.share_post);
            furtherDetails = itemView.findViewById(R.id.profile_see_more);
            editProfile = itemView.findViewById(R.id.tv_edit_profile);
        }
    }
}
