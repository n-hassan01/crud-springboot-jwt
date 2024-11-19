package com.demo.crud.security.auth;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.crud.dao.UsersDao;
import com.demo.crud.models.Users;

/**
 * author: Naimul Hassan
 * 
 * date: 11/18/2024
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsersDao usersDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = usersDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				Collections.singleton(new SimpleGrantedAuthority(user.getRole())));
	}
}
