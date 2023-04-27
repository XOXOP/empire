package com.example.empire.service;

import java.util.List;
import java.util.Optional;
import com.example.empire.entity.User;
import com.example.empire.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    @Autowired
    public UserServiceImpl(UserRepository empRepo) {
        this.userRepo = empRepo;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public User getById(Long id) {
        Optional<User> optional = userRepo.findById(id);
        User user = null;
        if (optional.isPresent())
            user = optional.get();
        else
            throw new NullPointerException(
                    "Employee not found for id : " + id);
        return user;
    }

    @Override
    public void deleteViaId(long id) {
        userRepo.deleteById(id);
    }
}

