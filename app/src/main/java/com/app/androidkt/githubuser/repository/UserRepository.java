package com.app.androidkt.githubuser.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.app.androidkt.githubuser.api.GitHubApi;
import com.app.androidkt.githubuser.api.GitHubService;
import com.app.androidkt.githubuser.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by brijesh on 25/5/17.
 */

public class UserRepository {
    GitHubService gitHubService;

    public UserRepository() {
        gitHubService = GitHubApi.getGitHubService();
    }

    public LiveData<List<User>> getUsers() {
        MutableLiveData<List<User>> data = new MutableLiveData<>();
        gitHubService.getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
        return data;
    }

    public LiveData<User> getUserDetail(String loginId) {
        MutableLiveData<User> data = new MutableLiveData<>();
        gitHubService.getUserDetail(loginId).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
        return data;
    }

}
