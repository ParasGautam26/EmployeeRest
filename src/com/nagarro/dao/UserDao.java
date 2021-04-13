package com.nagarro.dao;

import com.nagarro.dto.LoginUser;

public interface UserDao {
	void addUser(LoginUser userModel);

	LoginUser getUser(String userName);
}
