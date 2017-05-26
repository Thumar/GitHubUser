package com.app.androidkt.githubuser.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.app.androidkt.githubuser.model.User;

/**
 * Created by brijesh on 26/5/17.
 */

public class SharedViewModel extends ViewModel {

    MutableLiveData<User> selectedUser = new MutableLiveData<>();

    public void select(User user) {
        selectedUser.setValue(user);
    }

    public LiveData<User> getSelected() {
        return selectedUser;
    }
}
