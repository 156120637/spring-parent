//package com.dangdang.repository.elasticsearch.service;
//
//import com.dangdang.repository.elasticsearch.model.UserModel;
//import com.dangdang.repository.elasticsearch.repository.UserRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// * Create by tianjiaqin 2018-12-18
// */
//@Slf4j
//@Service
//public class UserServiceImpl implements IUserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//
//    public void save(UserModel userModel){
//        userRepository.save(userModel);
//    }
//
//
//    public Iterable<UserModel>  selectUser(){
//        Iterable<UserModel> all = userRepository.findAll();
//        return all;
//    }
//
//}
