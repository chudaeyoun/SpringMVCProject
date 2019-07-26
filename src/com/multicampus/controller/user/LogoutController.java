package com.multicampus.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.multicampus.controller.Controller;

public class LogoutController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�α׾ƿ� ��� ó��");
		
		// �α׾ƿ� ��û�� �������� ���ε� ������ ���� �����Ѵ�.
		HttpSession session = request.getSession();
		session.invalidate();

		// ���� ȭ������ �̵��Ѵ�.
		ModelAndView mav = ModelAndView();
		mav.setViewName("login.html");
		return mav;
		
	}

}
