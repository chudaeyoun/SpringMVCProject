package com.multicampus.biz.board;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String[] args) {
		// 1. ������ �����̳ʸ� �����Ѵ�. 
		ClassPathXmlApplicationContext container = 
			new ClassPathXmlApplicationContext("business-layer.xml");
		
		// 2. �����̳ʷκ��� �׽�Ʈ�� ��ü��  Lookup�Ѵ�. 
		BoardService boardService = (BoardService) container.getBean("boardService");

		// 3. Lookup�� ��ü�� �޼ҵ带 �׽�Ʈ�Ѵ�. 
		BoardVO vo = new BoardVO();
		vo.setTitle("�׽�Ʈ ����");
		vo.setWriter("�׽���");
		vo.setContent("�׽�Ʈ ����..............");
		boardService.insertBoard(vo);
	}
}
