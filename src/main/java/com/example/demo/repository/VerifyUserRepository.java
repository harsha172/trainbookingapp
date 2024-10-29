package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.VerifyUser;

public interface VerifyUserRepository
        extends CrudRepository<VerifyUser, String> {
    public VerifyUser findByEmail(String email);

    public void deleteByEmail(String email);
}
