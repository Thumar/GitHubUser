package com.app.androidkt.githubuser.api;

import com.app.androidkt.githubuser.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by brijesh on 25/5/17.
 */

public interface GitHubService {


    @GET("users/{login}")
    Call<User> getUserDetail(@Path("login") String login);

    @GET("users")
    Call<List<User>> getUsers();

}
