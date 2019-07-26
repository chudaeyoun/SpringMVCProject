package com.multicampus.controller.common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TimeCheckFilter implements Filter {
   
    public TimeCheckFilter() {
//        System.out.println("===> TimeCheckFilter ����");
    }   

	public void init(FilterConfig fConfig) throws ServletException {
//		System.out.println("===> init ����");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		System.out.println("===> doFilter ����");
		long start = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		long end = System.currentTimeMillis();
		System.out.println("���� ���࿡ �ɸ� �ð� : " + (end - start) + "(ms)��");
	}

	public void destroy() {
//		System.out.println("===> destroy ����");
	}
}
