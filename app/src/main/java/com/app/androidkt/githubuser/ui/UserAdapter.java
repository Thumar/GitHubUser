package com.app.androidkt.githubuser.ui;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.androidkt.githubuser.R;
import com.app.androidkt.githubuser.model.User;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by brijesh on 25/5/17.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<User> users;
    private Context context;
    UserClickCallBack userClickCallBack;

    public UserAdapter(List<User> users,UserClickCallBack userClickCallBack) {
        this.users = users;
        this.userClickCallBack=userClickCallBack;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        context=viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.user_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        User user = users.get(i);
        viewHolder.userName.setText(user.getLoginName());
        viewHolder.userId.setText(String.valueOf(user.getUserId()));

        viewHolder.cardView.setOnClickListener(v -> userClickCallBack.onItemClick(user));


        if (!TextUtils.isEmpty(user.getProfileImage())) {
            Glide.with(context)
                    .load(user.getProfileImage())
                    .into(viewHolder.avatarImage);
        }
    }

    public void setUsers(List<User> u) {
        int count = getItemCount();
        users.addAll(u);
        notifyItemRangeInserted(count, u.size());
    }

    @Override
    public int getItemCount() {
        return users == null ? 0 : users.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.avatar_image)
        ImageView avatarImage;

        @BindView(R.id.user_name)
        TextView userName;

        @BindView(R.id.user_id)
        TextView userId;

        @BindView(R.id.user_item_container)
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
