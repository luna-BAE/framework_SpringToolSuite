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
//	@PostMapping("/ex01") // 4������������ �߰��� ���� ���� requestmapping�� �̿� ���� �����ϰ� �� �� ����
	
	@ResponseBody // ������ ���������� �ٵ�
	public String ex01(DeptVo bean) {
		return "ex01";
	}
}
