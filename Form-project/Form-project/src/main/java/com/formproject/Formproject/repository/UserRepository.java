package com.formproject.Formproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formproject.Formproject.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
