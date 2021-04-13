package com.nagarro.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.dao.UserDao;
import com.nagarro.dto.LoginUser;

public class LoginService {

	@Autowired
	private UserDao userDao;

	public boolean validateUser(String userName, String password) {
		LoginUser userModel = userDao.getUser(userName);
		if (userModel == null)
			return false;
		if (userModel.getPassword().equals(password))
			return true;
		return false;
	}

	public void addUser(String userName, String password) {
		LoginUser userModel = new LoginUser();
		userModel.setUsername(userName);
		userModel.setPassword(password);
		userDao.addUser(userModel);
	}
}