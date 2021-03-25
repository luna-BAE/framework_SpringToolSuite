package com.bit.sts05.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeptVo {

	private int deptno;
	private String dname;
	private String loc;
	
}