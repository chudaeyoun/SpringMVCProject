package com.multicampus.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.multicampus.biz.user.UserDAO;
import com.multicampus.biz.user.UserVO;

public class LoginController implements Controller {
	public LoginController() {
		System.out.println("===> LoginController 생성");
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그인 기능 처리");
		
		// 1. 사용자 입력정보(id, password) 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB 연동 처리
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		 
		// 3. 화면 네비게이션
		ModelAndView mav = new ModelAndView();
		
		if(user != null) {
			// 로그인 성공했을 때 세션에 상태정보를 저장한다. 
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
