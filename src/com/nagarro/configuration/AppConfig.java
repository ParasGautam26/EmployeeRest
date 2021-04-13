package com.nagarro.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import com.nagarro.dao.EmployeeDao;
import com.nagarro.dao.Dao;
import com.nagarro.dao.UserDao;
import com.nagarro.daoImpl.EmployeeDaoImpl;
import com.nagarro.daoImpl.DaoImpl;
import com.nagarro.daoImpl.UserDaoImpl;
import com.nagarro.services.EmployeeService;
import com.nagarro.services.EmployeeServiceImpl;
import com.nagarro.services.LoginService;


@Configuration
@EnableScheduling
public class AppConfig {

	@Bean
	public Dao getDao() {
		return new DaoImpl();
	}

	@Bean
	public UserDao getUserDao() {
		return new UserDaoImpl();
	}

	@Bean
	EmployeeDao getEmployeeDao() {
		return new EmployeeDaoImpl();
	}

	@Bean
	public LoginService getUserService() {
		return new LoginService();
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public EmployeeService getEmployeeService() {
		return new EmployeeServiceImpl();
	}

}