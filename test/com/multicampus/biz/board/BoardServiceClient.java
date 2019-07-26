package com.multicampus.biz.board;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String[] args) {
		// 1. 스프링 컨테이너를 구동한다. 
		ClassPathXmlApplicationContext container = 
			new ClassPathXmlApplicationContext("business-layer.xml");
		
		// 2. 컨테이너로부터 테스트할 객체를  Lookup한다. 
		BoardService boardService = (BoardService) container.getBean("boardService");

		// 3. Lookup한 객체의 메소드를 테스트한다. 
		BoardVO vo = new BoardVO();
		vo.setTitle("테스트 제목");
		vo.setWriter("테스터");
		vo.setContent("테스트 내용..............");
		boardService.insertBoard(vo);
	}
}
