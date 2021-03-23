package com.bit.sts03.login.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bit.sts03.login.model.entity.LoginVo;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	RowMapper<Integer> rowMapper = new RowMapper<Integer>() {

		@Override
		public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
			return rs.getInt(1);
		}
	};
	
	@Override
	public boolean selectOne(String ename, String dname) {
		String sql = "select count(*) from emp A inner join dept B using (deptno) where ename=? and dname=?";
		return jdbcTemplate.queryForObject(sql, rowMapper, ename, dname)==1?true:false;
	}
	
	
}
