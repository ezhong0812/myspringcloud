package com.example.demo;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Jason on 18/4/4.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
