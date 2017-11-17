package com.spring.jpa.service;

import com.spring.jpa.entity.User;
import com.spring.jpa.repository.UserDao;
import com.spring.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/9/15.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    //注入UserRepository
    @Autowired
    private UserRepository userRepository;


    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;


    @Override
    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);

    }

    @Override
    @Transactional(readOnly=true)
    public User findUserById(Long id) {
        return userRepository.findOne(id);
    }


    @Override
    @Transactional
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        userRepository.delete(id);
    }

    @Override
    public List<User> findByGivenQuery(String name) {
       return userRepository.findByGivenQuery(name);
    }

    @Override
    public List<User> findByIdAndName(Long id, String name) {
        return userRepository.findByIdAndName(id, name);
    }

    @Override
    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }


}