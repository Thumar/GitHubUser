package com.app.androidkt.githubuser.api;

import com.app.androidkt.githubuser.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by brijesh on 25/5/17.
 */

public class GitHubApi {

    public static GitHubService getGitHubService(){
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.GITHUB_URL)
                .build().create(GitHubService.class);
    }
}
