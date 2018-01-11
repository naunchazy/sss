package com.exercise.service;

import com.exercise.pojo.po.User;

public interface IUserService {

	User selectUser(String username,String password);
}
