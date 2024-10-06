package com.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.User;

public interface UserRepo extends JpaRepository<User,Integer> {

}
