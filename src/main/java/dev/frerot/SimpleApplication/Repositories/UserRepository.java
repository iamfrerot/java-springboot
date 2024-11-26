package dev.frerot.SimpleApplication.Repositories;

import dev.frerot.SimpleApplication.Modal.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    Optional<User> findUserByEmail(String email);
}