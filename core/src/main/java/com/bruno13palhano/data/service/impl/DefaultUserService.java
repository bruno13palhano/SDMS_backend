package com.bruno13palhano.data.service.impl;

import com.bruno13palhano.data.repository.UserRepository;
import com.bruno13palhano.data.service.UserService;
import com.bruno13palhano.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserService implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void insert(User user) {
        userRepository.insert(user);
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }

    @Override
    public void delete(Long userId) {
        userRepository.delete(userId);
    }

    @Override
    public User getById(Long userId) {
        return userRepository.getById(userId);
    }
}
