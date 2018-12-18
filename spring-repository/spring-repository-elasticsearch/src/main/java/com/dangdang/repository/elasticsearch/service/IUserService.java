package com.dangdang.repository.elasticsearch.service;

import com.dangdang.repository.elasticsearch.model.UserModel;

/**
 * Create by tianjiaqin 2018-12-18
 */
public interface IUserService {
    public void save(UserModel userModel);

    public Iterable<UserModel>  selectUser();
}
