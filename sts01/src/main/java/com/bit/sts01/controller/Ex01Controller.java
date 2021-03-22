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
		
		req.setAttribute("msg", "luna"); // 값도 막 셋팅하고 어트리뷰트도 막 보냄 막 해버림
		
		return "ex01"; // 따라서 굳이 위에처럼 ModelAndView를 리턴할 필요 없고, url만 리턴해줄 수 있으면 됨
	}
	
	@RequestMapping("/ex02.do")
	public String ex02() {
		return "ex02";
	} 
	
	@RequestMapping("/ex03.do") // url주소에 의해 결정됨
	public void ex03() {} // 리턴값이 void라 하더라도 페이지는 띄움

	@RequestMapping("/test/ex04") // 이렇게 하면 당연히 안됨
	public String ex04() {
		return "ex04";
	}
	
}
