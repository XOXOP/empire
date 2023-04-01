package com.example.empire.servic;
import com.example.empire.entity.Users;

import java.util.List;
public interface ServiceInterfac {
    List<Users> getAllUsers();void save(Users users);
     Users getById(Long id);
    void deleteViaId(long id);
}
