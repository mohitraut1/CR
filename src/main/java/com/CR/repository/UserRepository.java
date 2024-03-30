package com.CR.repository;

import com.CR.model.User;

public interface UserRepository {
    void save(User user);
    User findByUsername(String username);
    void update(User user);
}