package com.example.UserQuerySystem.Service;

import com.example.UserQuerySystem.Entity.UserEntity;
import com.example.UserQuerySystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public void saveOrUpdate(UserEntity user) {
        repo.save(user);
    }

    public Iterable<UserEntity> listAll() {
        return repo.findAll();
    }

    public void deleteUser(String id) {
        repo.deleteById(id);
    }

    public UserEntity getUserByID(String userId) {
        return repo.findById(userId).orElse(null);
    }
}
