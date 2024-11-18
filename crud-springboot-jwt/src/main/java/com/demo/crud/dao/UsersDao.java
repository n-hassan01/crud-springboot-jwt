package com.demo.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.crud.models.Users;

@Repository
public interface UsersDao extends JpaRepository<Users, Integer> {

	Users findByUsername(String username);

}
