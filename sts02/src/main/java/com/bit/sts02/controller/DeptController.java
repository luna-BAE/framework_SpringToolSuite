package com.bit.sts02.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.sts02.model.DeptDao;
import com.bit.sts02.model.entity.DeptVo;

@Controller
@RequestMapping("/dept/")
public class DeptController {

	@Autowired
	DeptDao deptDao; // �ʵ忡 ������̾ ���̸� �ڵ����� ���͸� ���� ��������
	
//	@Autowired
//	public void setDeptDao(DeptDao deptDao) {
//		this.deptDao = deptDao;
//	}
	
	@RequestMapping("list")
	public void list(Model model) {
		model.addAttribute("list", deptDao.selectAll());
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() {}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(@RequestParam int deptno, String dname, String loc) { // RequestParam�� ������̼� ���� ����
		
		deptDao.insertOne(new DeptVo(deptno, dname, loc));
		
		return "redirect:list";
	}
	
//	@RequestMapping(value = "add", method = RequestMethod.POST)
//	public String add(
//			@RequestParam("deptno") int deptno,
//			@RequestParam("dname") String dname, 
//			@RequestParam("loc") String loc) {
//		
//		deptDao.insertOne(new DeptVo(deptno, dname, loc));
//		
//		return "redirect:list";
//	} // �Ʒ�ó�� �ϸ� ������Ʈ�� �޾ƾ� �ϴϱ� �̰�ó�� �׳� ������̼� �Ķ����� ������ �˴ϴ�.
	
//	@RequestMapping(value = "add", method = RequestMethod.POST)
//	public String add(HttpServletRequest req) throws UnsupportedEncodingException {
//		
//		req.setCharacterEncoding("utf-8");
//		deptDao.insertOne(new DeptVo(
//				Integer.parseInt(req.getParameter("deptno"))
//				,req.getParameter("dname")
//				,req.getParameter("loc")
//				));
//		
//		return "redirect:list";
//	}
	
	@RequestMapping(value = "dept", method = RequestMethod.GET)
	public void one(@RequestParam("idx") int deptno, Model model) {
		
		model.addAttribute("bean", deptDao.selectOne(deptno));
		
	}
	
//	@RequestMapping(value = "dept", method = RequestMethod.GET)
//	public void one(HttpServletRequest req) {
//		
//		req.setAttribute("bean", deptDao.selectOne(Integer.parseInt(req.getParameter("idx"))));
//		
//	}

	@RequestMapping(value = "dept", method = RequestMethod.POST)
	public String edit(@ModelAttribute DeptVo bean) throws UnsupportedEncodingException { // 2�������� Ŀ�ǵ�� �޾Ҵ� ��ó�� �̰͵� �����մϴ�.
				
		deptDao.updateOne(bean);
		
		return "redirect:dept?idx="+bean.getDeptno();
		
	} // �Ʒ�ó�� �� ���� �����ݾƿ�? �׷��� �̷��� ���ϴ�
	
//	@RequestMapping(value = "dept", method = RequestMethod.POST)
//	public String edit(int deptno, String dname, String loc) throws UnsupportedEncodingException {
//		
//		// req.setCharacterEncoding("utf-8"); // ���⼭ ���Ķ���Ͱ� �� �Ǵϱ� ���ڵ��� �ҿ��� �����ϴ�.
//		
//		DeptVo bean = new DeptVo(deptno, dname, loc);
//		
//		deptDao.updateOne(bean);
//		
//		return "redirect:dept?idx="+bean.getDeptno();
//		
//	}
	
//	@RequestMapping(value = "dept", method = RequestMethod.POST)
//	public String edit(HttpServletRequest req) {
//		
//		try {
//			req.setCharacterEncoding("utf-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		
//		DeptVo bean = new DeptVo(
//				Integer.parseInt(req.getParameter("deptno"))
//				,req.getParameter("dname")
//				,req.getParameter("loc")
//				);
//		
//		deptDao.updateOne(bean);
//		
//		return "redirect:dept?idx="+bean.getDeptno();
//		
//	}
	
	@RequestMapping(value = "dept/{deptno}", method = RequestMethod.POST) // �Ķ���Ͱ� �ƴ϶� �н� �븮���� �Ѿ
	// �ٹ���� ��� ���� �ּ�â�� ��� �����Ƿ� ���ȼ��� ������ ������ ��������
	public String delete(@PathVariable("deptno") int deptno) { // �̸��� ������ ������̼� ���� ���� ���� 
		deptDao.deleteOne(deptno);
		return "redirect:../list";
	}
	
}
