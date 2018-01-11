package com.exercise.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.dao.IUserDao;
import com.exercise.pojo.po.User;
import com.exercise.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao userDao;
	
	@Override
	public User selectUser(String username,String password) {
		User user = userDao.selectUser(username,password);
		return user;
	}

}
