package com.app.androidkt.githubuser.ui;


import android.app.Fragment;
import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.androidkt.githubuser.MainActivity;
import com.app.androidkt.githubuser.R;
import com.app.androidkt.githubuser.model.User;
import com.app.androidkt.githubuser.viewmodel.SharedViewModel;
import com.app.androidkt.githubuser.viewmodel.UsersViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserListFragment extends LifecycleFragment {


    public static final String TAG = "UserListFragment";

    @BindView(R.id.user_list)
    RecyclerView userListView;
    @BindView(R.id.isLoadingUser)
    TextView loadingMessage;


   private SharedViewModel sharedViewModel;

    UserClickCallBack userClickCallBack = new UserClickCallBack() {
        @Override
        public void onItemClick(User user) {
            ((MainActivity) getActivity()).showUserDetail();
            sharedViewModel.select(user);
        }
    };
    private List<User> usersList;
    private UserAdapter mAdapter;

    public UserListFragment() {
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final UsersViewModel usersViewModel = ViewModelProviders.of(this).get(UsersViewModel.class);
        usersViewModel.init();
        subscribeUi(usersViewModel);
        sharedViewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
    }

    private void subscribeUi(UsersViewModel usersViewModel) {
        usersViewModel.getUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                mAdapter.setUsers(users);
                userListView.setVisibility(View.VISIBLE);
                loadingMessage.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user_list, container, false);
        ButterKnife.bind(this, rootView);

        userListView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this.getContext());
        userListView.setLayoutManager(mLayoutManager);

        usersList = new ArrayList<>();
        mAdapter = new UserAdapter(usersList, userClickCallBack);
        userListView.setAdapter(mAdapter);

        return rootView;
    }
}
