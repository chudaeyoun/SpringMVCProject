package com.multicampus.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.multicampus.biz.board.BoardDAO;
import com.multicampus.biz.board.BoardVO;
import com.multicampus.biz.user.UserVO;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 목록 검색 기능 처리");
		
		// 0. 세션 체크
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("user");
		
		ModelAndView mav = new ModelAndView();
		if(user == null) {
			mav.setViewName("login.html");
		} else {
			// 1. 사용자 입력정보 추출
			String searchCondition = request.getParameter("searchCondition");
			String searchKeyword = request.getParameter("searchKeyword");
			
			// Null Check
			if(searchCondition == null) searchCondition = "TITLE";
			if(searchKeyword == null) searchKeyword = "";
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSearchCondition(searchCondition);
			vo.setSearchKeyword(searchKeyword);
			
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);
			
			// 3. 검색 결과를 세션에 등록하고 글 목록 화면(getBoardList.jsp)으로 이동한다.
			session.setAttribute("boardList", boardList);
			mav.setViewName("getBoardList.jsp");
		}
		
		return mav;
	}

}
