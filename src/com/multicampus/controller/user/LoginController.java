package com.multicampus.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.multicampus.biz.user.UserDAO;
import com.multicampus.biz.user.UserVO;
import com.multicampus.controller.Controller;

public class LoginController {
	public LoginController() {
		System.out.println("===> LoginController ����");
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�α��� ��� ó��");
		
		// 1. ����� �Է�����(id, password) ����
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB ���� ó��
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		 
		// 3. ȭ�� �׺���̼�
		ModelAndView mav = ModelAndView();
		
		if(user != null) {
			// �α��� �������� �� ���ǿ� ���������� �����Ѵ�. 
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(60 * 60 * 1);
			session.setAttribute("user", user);
			mav.setViewName("getBoardList.do");
		} else {
			mav.setViewName("login.html");
		}
		
		return mav;
	}

}