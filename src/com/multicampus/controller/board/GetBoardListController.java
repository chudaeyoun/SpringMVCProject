package com.multicampus.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.multicampus.biz.board.BoardDAO;
import com.multicampus.biz.board.BoardVO;
import com.multicampus.biz.user.UserVO;
import com.multicampus.controller.Controller;

public class GetBoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�� ��� �˻� ��� ó��");
		
		// 0. ���� üũ
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("user");
		if(user == null) {
			return "login.html";
		} else {
			// 1. ����� �Է����� ����
			String searchCondition = request.getParameter("searchCondition");
			String searchKeyword = request.getParameter("searchKeyword");
			
			// Null Check
			if(searchCondition == null) searchCondition = "TITLE";
			if(searchKeyword == null) searchKeyword = "";
			
			// 2. DB ���� ó��
			BoardVO vo = new BoardVO();
			vo.setSearchCondition(searchCondition);
			vo.setSearchKeyword(searchKeyword);
			
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);
			
			// 3. �˻� ����� ���ǿ� ����ϰ� �� ��� ȭ��(getBoardList.jsp)���� �̵��Ѵ�.
			session.setAttribute("boardList", boardList);
			return "getBoardList.jsp";
		}
	}

}
