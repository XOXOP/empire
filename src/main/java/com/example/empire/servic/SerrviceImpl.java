package com.example.empire.servic;
import java.util.List;
import java.util.Optional;

import com.example.empire.entity.Users;
import com.example.empire.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SerrviceImpl implements ServiceInterfac{

    private final UserRepository empRepo;
    @Autowired
    public SerrviceImpl(UserRepository empRepo){
        this.empRepo = empRepo;
    }

    @Override public List<Users> getAllUsers()
    {
        return empRepo.findAll();
    }

    @Override public void save(Users users)
    {
        empRepo.save(users);
    }

    @Override public Users getById(Long id)
    {
        Optional<Users> optional = empRepo.findById(id);
        Users users = null;
        if (optional.isPresent())
            users = optional.get();
        else
            throw new RuntimeException(
                    "Employee not found for id : " + id);
        return users;
    }

    @Override
    public void deleteViaId(long id) {
        empRepo.deleteById(id);
    }
}

