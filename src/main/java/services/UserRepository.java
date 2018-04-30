package services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}