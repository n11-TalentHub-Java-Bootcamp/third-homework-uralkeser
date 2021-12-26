package com.uralkeser.service;

import com.uralkeser.entity.User;
import com.uralkeser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){

        Optional<User> optional = userRepository.findById(id);

        User User = null;
        if (optional.isPresent()){
            User = optional.get();
        }

        return User;
    }

    public void deleteById(String id){
        userRepository.deleteById(id);
    }

    public User save(User User){
        return userRepository.save(User);
    }
}
