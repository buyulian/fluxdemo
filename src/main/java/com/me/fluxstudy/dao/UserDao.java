package com.me.fluxstudy.dao;

import com.me.fluxstudy.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {

    List<User> getUsers();

    User getUserById(Long id);
}
