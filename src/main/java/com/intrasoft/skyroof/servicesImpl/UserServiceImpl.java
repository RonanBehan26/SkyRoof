package com.intrasoft.skyroof.servicesImpl;

import com.intrasoft.skyroof.entities.User;
import com.intrasoft.skyroof.repositories.UserRepository;
import com.intrasoft.skyroof.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    @Override
    public List<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public Long createUser(User user) {
        return userRepository.save(user).getId();
    }

    @Override
    public void updateUser(User user, Long id) {
        User userFromDb = userRepository.findById(id).get();
        //System.out.println(userFromDb.toString());
        userFromDb.setUserName(user.getUserName());
        userRepository.save(userFromDb);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
