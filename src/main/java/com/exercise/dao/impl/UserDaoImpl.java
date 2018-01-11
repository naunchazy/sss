package com.exercise.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.exercise.dao.IUserDao;
import com.exercise.pojo.po.User;

@Repository
public class UserDaoImpl extends JdbcDaoSupport implements IUserDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public User selectUser(String username,String password) {
		String sql="select username,password from user where username=? and password=?";
//		User role = jdbcTemplate.queryForObject(sql, new Object[]{username,password}, User.class);
		User user=(User) jdbcTemplate.queryForObject(sql, new Object[]{username,password},new RowMapper<Object>(){
		
			@Override
			public Object mapRow(ResultSet resultSet, int arg1) throws SQLException {
				return mapRowHandler(resultSet);
			}
		});
		return user;
//		return role;
	}

	private User mapRowHandler(ResultSet resultSet) throws  SQLException{
        User user = new User();
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        return  user;
	}
	
}
