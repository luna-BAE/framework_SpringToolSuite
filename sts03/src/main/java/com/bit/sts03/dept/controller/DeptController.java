package com.bit.sts03.dept.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.sts03.dept.model.entity.DeptVo;
import com.bit.sts03.dept.service.DeptService;

@Controller
public class DeptController {

	@Autowired
	DeptService deptService;
	
	@RequestMapping("/dept/")
	public String list(Model model) {
		try {
			deptService.setModelList(model);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "dept/list";
	}
	
	@RequestMapping(value = "/dept/add", method = RequestMethod.GET)
	public String addForm(HttpSession session) {
//		if(session.getAttribute("result")==null)
//			return "redirect:/login/";
		return "dept/add";
	}
	
	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public String add(@ModelAttribute DeptVo bean) {
		try {
			deptService.addBean(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:./";
	}
	
	@RequestMapping(value = "/dept/{deptno}", method = RequestMethod.GET)
	public String detail(@PathVariable("deptno") int deptno, Model model) {
		try {
			deptService.setModelBean(model, deptno);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "dept/dept";
	}
	
	@RequestMapping(value = "/dept/{deptno}", method = RequestMethod.POST)
	public String update(@PathVariable("deptno") int deptno, @ModelAttribute DeptVo bean) {
		try {
			deptService.updateBean(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "redirect:./"+deptno;
	}
	
	@RequestMapping(value = "/dept/{deptno}/del", method = RequestMethod.POST)
	public String delete(@PathVariable("deptno") int deptno) {
		try {
			deptService.delete(deptno);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:../";
	}
	
}
