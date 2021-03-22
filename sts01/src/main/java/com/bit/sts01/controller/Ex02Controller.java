package com.bit.sts01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/") // 이렇게 되면 이 컨트롤러 안에 있는 모든 url 앞에는 클래스에 준 어노테이션의 주소가 붙게 됨 // 선택사항
public class Ex02Controller {

	@RequestMapping("ex05.do")
	public void ex01() {
		// return "ex05";
	}
	
	@RequestMapping(value="ex06", method=RequestMethod.POST)
	public void ex02() {}
}
