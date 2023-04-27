package com.example.empire.service;

import com.example.empire.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void save(User user);

    User getById(Long id);

    void deleteViaId(long id);
}



