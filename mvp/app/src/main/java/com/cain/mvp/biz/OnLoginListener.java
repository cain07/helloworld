package com.cain.mvp.biz;

import com.cain.mvp.bean.User;

/**
 * Created by cain on 16/5/31.
 */
public interface OnLoginListener {

    void loginSuccess(User user);

    void loginFailed();

}
