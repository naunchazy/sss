package com.exercise.dao;

import java.util.List;

import com.exercise.pojo.po.User;

public interface IUserDao {

	User selectUser(String username,String password);
}
