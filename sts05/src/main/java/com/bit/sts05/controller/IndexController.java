package com.bit.sts05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.sts05.model.entity.DeptVo;

@Controller
public class IndexController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@GetMapping("/ex01")
//	@PostMapping("/ex01") // 4버전에서부터 추가된 문법 위에 requestmapping을 이와 같이 간단하게 쓸 수 있음
	
	@ResponseBody // 리턴이 리스폰스의 바디
	public String ex01(DeptVo bean) {
		return "ex01";
	}
}
