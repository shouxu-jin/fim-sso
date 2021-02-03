package com.yytxdy.fim.sso.mapper;

import com.yytxdy.fim.sso.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    void save(User user);
}
