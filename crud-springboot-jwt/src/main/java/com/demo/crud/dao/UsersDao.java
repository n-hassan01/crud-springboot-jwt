package com.demo.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.crud.models.Users;

/**
 * author: Naimul Hassan
 * 
 * date: 11/18/2024
 */

@Repository
public interface UsersDao extends JpaRepository<Users, Integer> {

	Users findByUsername(String username);

}
