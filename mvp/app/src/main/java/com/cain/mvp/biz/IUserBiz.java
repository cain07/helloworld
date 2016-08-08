package com.cain.mvp.biz;

/**
 * Created by cain on 16/5/31.
 */
public interface IUserBiz {
    public void login(String username, String password, OnLoginListener loginListener);
}
