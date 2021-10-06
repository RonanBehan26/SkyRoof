package com.intrasoft.skyroof.services;

import com.intrasoft.skyroof.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService  {


    List<User> findAll();

    User findById(Long id);

    List<User> findByUserName(String userName);

    Long createUser(User user);

    void updateUser(User user, Long id);

    void deleteUser(Long id);
}
