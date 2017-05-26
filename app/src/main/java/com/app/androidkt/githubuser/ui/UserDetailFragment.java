package com.app.androidkt.githubuser.ui;


import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.app.androidkt.githubuser.R;
import com.app.androidkt.githubuser.model.User;
import com.app.androidkt.githubuser.viewmodel.SharedViewModel;
import com.app.androidkt.githubuser.viewmodel.UserDetailViewModel;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserDetailFragment extends LifecycleFragment {

    public static final String TAG = "UserDetailFragment";

    @BindView(R.id.user_detail_container)
    ScrollView scrollView;
    @BindView(R.id.user_profile_image)
    ImageView imageView;
    @BindView(R.id.user_name)
    TextView name;
    @BindView(R.id.since)
    TextView since;
    @BindView(R.id.address)
    TextView address;
    @BindView(R.id.blog_url)
    TextView blogUrl;
    @BindView(R.id.progressBarUserDetail)
    ProgressBar progressBar;


    private UserDetailViewModel userDetailViewModel;
    private SharedViewModel sharedViewModel;

    public UserDetailFragment() {
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_detail, container, false);
        ButterKnife.bind(this, view);

        userDetailViewModel = ViewModelProviders.of(this).get(UserDetailViewModel.class);
        sharedViewModel=ViewModelProviders.of(getActivity()).get(SharedViewModel.class);

        userDetailViewModel.init(sharedViewModel);

        userDetailViewModel.getUserLiveData().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                scrollView.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
                blogUrl.setText(user.getBlogUrl());
                address.setText(user.getAddress());
                name.setText(user.getName());
                since.setText(user.getSince().toString());

                if (!TextUtils.isEmpty(user.getProfileImage())) {
                    Glide.with(getActivity())
                            .load(user.getProfileImage())
                            .into(imageView);
                }
            }
        });
        return view;
    }

}
