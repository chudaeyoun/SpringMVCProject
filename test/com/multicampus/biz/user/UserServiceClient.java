package com.multicampus.biz.user;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceClient {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext container = 
			new ClassPathXmlApplicationContext("business-layer.xml");
		
		UserService userService = (UserService) container.getBean("userService");
		
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test");
		UserVO user = userService.getUser(vo);
		
		if(user != null) {
			System.out.println(user.getName() + "�� ȯ��....");
		} else {
			System.out.println("�α��� ����!!!");
		}
	}
}
