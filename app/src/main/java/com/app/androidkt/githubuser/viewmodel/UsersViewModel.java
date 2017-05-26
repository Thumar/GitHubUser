package com.app.androidkt.githubuser.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.app.androidkt.githubuser.model.User;
import com.app.androidkt.githubuser.repository.UserRepository;

import java.util.List;

/**
 * Created by brijesh on 25/5/17.
 */

public class UsersViewModel extends ViewModel {

    private LiveData<List<User>> users;
    private UserRepository userRepository;


    public UsersViewModel() {
        this.userRepository = new UserRepository();
    }

    public void init()
    {
        if(users!=null){
            return;
        }
        users=userRepository.getUsers();
    }

    public LiveData<List<User>> getUsers()
    {
        return this.users;
    }
}
