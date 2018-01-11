package com.exercise.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exercise.pojo.po.User;
import com.exercise.service.IUserService;

@Controller
public class UserAction {

	@Autowired
	private IUserService userService;
	
	
	@RequestMapping("/")
	public String index(){
		return "login";
	}
	
	@RequestMapping(value="/validate",method=RequestMethod.POST)
//	public String validate(User user,Model model){
	public String validate(String username,String password,Model model){
		User us = userService.selectUser(username,password);
		model.addAttribute("username", username);//为了传到前台页面
		model.addAttribute("password", username);
		if(us!=null){//若有该用户则显示登录成功
			System.out.println(us.getUsername()+"-----"+us.getPassword());
			return "success";
		}else{//若不存在该用户，则显示登录失败。并显示填入的用户名和密码以便检查
			System.out.println(us.getUsername()+"+++++"+us.getPassword());
			return "failed";
		}
	}
}
