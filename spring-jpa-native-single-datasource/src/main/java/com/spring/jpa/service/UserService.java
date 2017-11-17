package com.spring.jpa.service;


import com.spring.jpa.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/9/15.
 */
public interface UserService {
    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    User findUserById(Long id);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据ID删除用户
     * @param id
     */
    void deleteUserById(Long id);

    public List<User> findByGivenQuery(String name);

    public  List<User> findByIdAndName(Long id, String name);

    public  List<User> findByName(String name);
}
