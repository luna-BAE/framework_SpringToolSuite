package com.bit.sts03.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.sts03.login.model.LoginDao;

@Controller
public class LoginController {

	@Autowired
	LoginDao loginDao;
	
	@RequestMapping(value = "/login/", method = RequestMethod.GET)
	public String form() {
		return "login/form";
	}
	
	@RequestMapping(value = "/login/", method = RequestMethod.POST)
	public String login(HttpSession session, String ename, String dname) {
		if(loginDao.selectOne(ename, dname)) {
			session.setAttribute("result", true);
			session.setAttribute("loginName", ename);
		}
		return "redirect:/";
	}
	
	@RequestMapping("/logout/")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
