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
		model.addAttribute("username", username);//Ϊ�˴���ǰ̨ҳ��
		model.addAttribute("password", username);
		if(us!=null){//���и��û�����ʾ��¼�ɹ�
			System.out.println(us.getUsername()+"-----"+us.getPassword());
			return "success";
		}else{//�������ڸ��û�������ʾ��¼ʧ�ܡ�����ʾ������û����������Ա���
			System.out.println(us.getUsername()+"+++++"+us.getPassword());
			return "failed";
		}
	}
}
