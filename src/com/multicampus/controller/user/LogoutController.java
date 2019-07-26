package com.multicampus.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.multicampus.controller.Controller;

public class LogoutController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그아웃 기능 처리");
		
		// 로그아웃 요청한 브라우저와 매핑된 세션을 강제 종료한다.
		HttpSession session = request.getSession();
		session.invalidate();

		// 메인 화면으로 이동한다.
		ModelAndView mav = ModelAndView();
		mav.setViewName("login.html");
		return mav;
		
	}

}
