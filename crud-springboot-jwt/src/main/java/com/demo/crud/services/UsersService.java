package com.demo.crud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.demo.crud.dao.UsersDao;
import com.demo.crud.models.ResponseInfo;
import com.demo.crud.models.Users;

/**
 * author: Naimul Hassan
 * 
 * date: 11/19/2024
 */

@Service
public class UsersService {

	@Autowired
	UsersDao usersDao;

	public ResponseInfo<Users> addUser(Users user) {
		ResponseInfo<Users> responseInfo = new ResponseInfo<>();

		try {
			Users response = usersDao.save(user);

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully added!");
			responseInfo.setData(response);

			return responseInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}

		responseInfo.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseInfo.setMessage("BAD REQUEST");
		responseInfo.setData(null);

		return null;
	}

}
