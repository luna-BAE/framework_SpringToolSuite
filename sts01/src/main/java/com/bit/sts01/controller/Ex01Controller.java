package com.bit.sts01.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex01Controller {

//	@RequestMapping("/ex01.do")
//	public ModelAndView ex01HandleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		return new ModelAndView("ex01");
//	}
	
	@RequestMapping("/ex01")
	public String ex01HandleRequest(HttpServletRequest req) throws Exception {
		
		req.setAttribute("msg", "luna"); // ���� �� �����ϰ� ��Ʈ����Ʈ�� �� ���� �� �ع���
		
		return "ex01"; // ���� ���� ����ó�� ModelAndView�� ������ �ʿ� ����, url�� �������� �� ������ ��
	}
	
	@RequestMapping("/ex02.do")
	public String ex02() {
		return "ex02";
	} 
	
	@RequestMapping("/ex03.do") // url�ּҿ� ���� ������
	public void ex03() {} // ���ϰ��� void�� �ϴ��� �������� ���

	@RequestMapping("/test/ex04") // �̷��� �ϸ� �翬�� �ȵ�
	public String ex04() {
		return "ex04";
	}
	
}
