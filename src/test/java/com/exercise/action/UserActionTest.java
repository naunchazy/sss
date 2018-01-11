/*package com.exercise.action;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.exercise.pojo.po.User;
import com.exercise.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springmvc-dao.xml")
public class UserActionTest {

	@Autowired
	private IUserService userService;
	
	@Test
	public void selectTest(User user){
		User us = userService.selectUser(user);
		System.out.println(us.getUsername()+"======"+us.getPassword());
	}
}
*/