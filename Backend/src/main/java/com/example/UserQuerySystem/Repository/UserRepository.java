package com.example.UserQuerySystem.Repository;

import com.example.UserQuerySystem.Entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity, String> {
}
