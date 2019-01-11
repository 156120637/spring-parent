package com.dangdang.service.biz.service.impl;

import com.dangdang.repository.mysql.mapper.easyui.entity.User;
import com.dangdang.repository.mysql.mapper.easyui.entity.UserExample;
import com.dangdang.repository.mysql.mapper.easyui.mapper.UserMapper;
import com.dangdang.service.biz.service.UserService;
import com.dangdang.common.utils.easyui.util.SaltUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public User login(User user) {

        try {
            UserExample example = new UserExample();
            example.createCriteria().andUsnameEqualTo(user.getUsname());
            List<User> users = userMapper.selectByExample(example);

            for (User u : users) {
                if(DigestUtils.md5DigestAsHex((user.getUspassword()+u.getUssalt()).getBytes()).equals(u.getUspassword())){
                    return u;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("登录出错,请稍后重试");
        }
        return null;
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @Override
    public User register(User user) {
        try {
            user.setUsid(UUID.randomUUID().toString());/*UUID*/
            user.setUsstatus("0");/*0 启用 1 禁用*/
            String salt = SaltUtil.getSalt(4);/* 盐数据*/
            user.setUssalt(salt);
            String md5DigestAsHex = DigestUtils.md5DigestAsHex((user.getUspassword() + salt).getBytes());// 加密之后的密码
            user.setUspassword(md5DigestAsHex);
            user.setUsrole("0");
            user.setUscreate(new Date());
            userMapper.insertSelective(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("请输入正确数据");
        }
        return user;
    }

    /**
     * 查询所有不是管理员的用户
     * @return
     */
    @Override
    public Page<User> findAll(Integer page , Integer rows) {

        Page<User> pages = null;
        try {
            UserExample example = new UserExample();
            example.createCriteria().andUsroleNotEqualTo("2");
            PageHelper.startPage(page , rows);
            pages = (Page<User>) userMapper.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询出错");
        }
        return pages;
    }

    @Override
    public void removeUser(String usid) {
        try {
            userMapper.deleteByPrimaryKey(usid);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("操作失败,请稍后重试");
        }
    }

    @Override
    public void modifyUser(User user) {
        try {
            userMapper.updateByPrimaryKeySelective(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("操作失败.请稍后重试");
        }
    }

    @Override
    public User findById(String usid) {
        User user = null;
        try {
            user = userMapper.selectByPrimaryKey(usid);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("操作失败,请稍后重试");
        }
        return user;
    }

    @Override
    public Integer countUser() {
        Integer i = userMapper.countByExample(new UserExample());
        return i;
    }

}
