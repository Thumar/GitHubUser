package com.app.androidkt.githubuser.viewmodel;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;

import com.app.androidkt.githubuser.api.GitHubApi;
import com.app.androidkt.githubuser.api.GitHubService;
import com.app.androidkt.githubuser.model.User;
import com.app.androidkt.githubuser.repository.UserRepository;

/**
 * Created by brijesh on 25/5/17.
 */

public class UserDetailViewModel extends ViewModel {

    private UserRepository userRepository;
    private GitHubService gitHubService;
    private LiveData<User> userLiveData;

    public UserDetailViewModel() {
        userRepository = new UserRepository();
        gitHubService = GitHubApi.getGitHubService();
    }

    public void init(SharedViewModel sharedViewModel) {
        if (userLiveData != null) {
            return;
        }
        userLiveData = Transformations.switchMap(sharedViewModel.getSelected(), new Function<User, LiveData<User>>() {
            @Override
            public LiveData<User> apply(User user) {
                 return userRepository.getUserDetail(user.getLoginName());
            }
        });
    }

    public LiveData<User> getUserLiveData() {
        return userLiveData;
    }
}
