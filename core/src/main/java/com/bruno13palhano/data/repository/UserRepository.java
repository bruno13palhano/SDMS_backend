package com.bruno13palhano.data.repository;

import com.bruno13palhano.data.UserData;
import com.bruno13palhano.model.User;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserRepository implements UserData<User> {

    @Override
    public void insert(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(Long userId) {

    }
}
