package com.intrasoft.skyroof.repositories;

import com.intrasoft.skyroof.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUserName(String userName);

}
