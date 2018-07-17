package com.example.jpapractice.domain;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    public List<User> findUserByUserId(String userId);

}
