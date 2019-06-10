package com.moji.hks.service;

import com.moji.hks.mybaties.model.User;

import java.util.List;

/**
 * @Author: liyu.guan
 * @Date: 2019/6/10 上午9:34
 */
public interface UserService {

    public int addUser(User user);

    public User get(User user);
}
