package com.me.fluxstudy.dao;

import com.me.fluxstudy.model.Role;
import com.me.fluxstudy.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoleDao {
    List<Role> listByCondition();
}
