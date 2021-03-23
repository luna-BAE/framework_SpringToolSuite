package com.bit.sts03.login.model;

import com.bit.sts03.login.model.entity.LoginVo;

public interface LoginDao {

	boolean selectOne(String ename, String dname);

}