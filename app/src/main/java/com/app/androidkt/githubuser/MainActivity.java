package com.app.androidkt.githubuser;

import android.arch.lifecycle.LifecycleActivity;
import android.os.Bundle;

import com.app.androidkt.githubuser.ui.UserDetailFragment;
import com.app.androidkt.githubuser.ui.UserListFragment;

public class MainActivity extends LifecycleActivity {

    private UserListFragment userListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            userListFragment = new UserListFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.frame_container, userListFragment, UserListFragment.TAG).commit();
        }
    }

    public void showUserDetail() {
        UserDetailFragment userDetailFragment = new UserDetailFragment();
        getSupportFragmentManager().beginTransaction().
                replace(R.id.frame_container, userDetailFragment).addToBackStack(UserDetailFragment.TAG).commit();
    }
}
