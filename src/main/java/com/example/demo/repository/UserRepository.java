package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.User;

public interface UserRepository extends CrudRepository<User, String> {
    public User findByAadhar(String aadhar);

    public User findByEmail(String email);
}
