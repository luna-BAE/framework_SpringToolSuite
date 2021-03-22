package com.bit.sts02.model.entity;

import java.sql.Timestamp;

public class EmpVo {

	private int empno, pay, deptno;
	private String ename;
	private Timestamp nalja;
	
	public EmpVo() {
		// TODO Auto-generated constructor stub
	}

	public EmpVo(int empno, int pay, int deptno, String ename, Timestamp nalja) {
		super();
		this.empno = empno;
		this.pay = pay;
		this.deptno = deptno;
		this.ename = ename;
		this.nalja = nalja;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Timestamp getNalja() {
		return nalja;
	}

	public void setNalja(Timestamp nalja) {
		this.nalja = nalja;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deptno;
		result = prime * result + empno;
		result = prime * result + ((ename == null) ? 0 : ename.hashCode());
		result = prime * result + pay;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpVo other = (EmpVo) obj;
		if (deptno != other.deptno)
			return false;
		if (empno != other.empno)
			return false;
		if (ename == null) {
			if (other.ename != null)
				return false;
		} else if (!ename.equals(other.ename))
			return false;
		if (pay != other.pay)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmpVo [empno=" + empno + ", pay=" + pay + ", deptno=" + deptno + ", ename=" + ename + ", nalja=" + nalja
				+ "]";
	}
	
}
