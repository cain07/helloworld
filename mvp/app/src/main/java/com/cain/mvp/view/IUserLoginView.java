package com.cain.mvp.view;

import com.cain.mvp.bean.User;

/**
 * Created by cain on 16/5/31.
 */
public interface IUserLoginView {
    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();
}
