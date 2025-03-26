package com.yaroslavl.demo.store.repository;

import com.yaroslavl.demo.store.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}