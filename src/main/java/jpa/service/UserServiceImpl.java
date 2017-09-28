package jpa.service;

import jpa.domain.User;
import jpa.repository.UserDao;
import jpa.repository.UserRepository;
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


    @Autowired
    private UserRepository userRepository;//注入UserRepository


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
    public User findUserById(Integer id) {
        return userRepository.findOne(id);
    }


    @Override
    @Transactional
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUserById(Integer id) {
        userRepository.delete(id);
    }

    @Override
    public List<User> findByGivenQuery(String name) {
       return userRepository.findByGivenQuery(name);
    }

    @Override
    public List<User> findByIdAndName(int id, String name) {
        return userRepository.findByIdAndName(id, name);
    }

    @Override
    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }


}