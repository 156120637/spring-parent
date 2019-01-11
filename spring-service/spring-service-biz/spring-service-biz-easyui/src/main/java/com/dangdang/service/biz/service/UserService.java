package com.dangdang.service.biz.service;

import com.dangdang.repository.mysql.mapper.easyui.entity.User;
import com.github.pagehelper.Page;

/**
 * 用户相关的操作
 */
public interface UserService {

    /**
     * 用户登录
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 用户注册
     * @param user
     * @return
     */
    public User register(User user);

    /**
     * 查询所有不是管理员的用户查询所有非管理员用户
     * @param page 当前页
     * @param rows 每页的行数
     * @return
     */
    public Page<User> findAll(Integer page, Integer rows);

    /**
     * 删除用户信息
     * @param usid
     * @return
     */
    public void removeUser(String usid);

    /**
     * 修改用户信息
     * @param user
     */
    public void modifyUser(User user);

    /**
     * 查询单个用户信息
     * @param usid
     * @return
     */
    public User findById(String usid);

    /**
     * 统计个数
     * @return
     */
    public Integer countUser();

}
