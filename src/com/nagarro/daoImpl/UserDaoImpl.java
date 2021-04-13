package com.nagarro.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.dao.Dao;
import com.nagarro.dao.UserDao;
import com.nagarro.dto.LoginUser;

public class UserDaoImpl implements UserDao {

	@Autowired
	private Dao Dao;

	@Override
	public void addUser(LoginUser user) {
		Dao.begin();
		Dao.getSession().save(user);
		Dao.commit();
		Dao.close();
	}


	@Override
	public LoginUser getUser(String userName) {
		Dao.begin();
		LoginUser user = (LoginUser) Dao.getSession().get(LoginUser.class, userName);
		Dao.commit();
		Dao.close();
		return user;
	}
}
