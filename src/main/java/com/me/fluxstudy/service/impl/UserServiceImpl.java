package com.me.fluxstudy.service.impl;

import com.me.fluxstudy.dao.UserDao;
import com.me.fluxstudy.model.User;
import com.me.fluxstudy.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }
}
