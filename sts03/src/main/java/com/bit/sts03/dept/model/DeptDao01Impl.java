package com.bit.sts03.dept.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.bit.sts03.dept.model.entity.DeptVo;

@Repository
public class DeptDao01Impl implements DeptDao<DeptVo> {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	RowMapper<DeptVo> rowMapper = new RowMapper<DeptVo>() {

		@Override
		public DeptVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new DeptVo(rs.getInt(1), rs.getString(2), rs.getString(3));
		}
	};
	
	@Override
	public List<DeptVo> selectAll() throws SQLException {
		String sql = "select * from dept order by deptno";
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public DeptVo selectOne(int key) throws SQLException {
		String sql = "select * from dept where deptno=?";
		// return jdbcTemplate.query(sql, rowMapper, key).get(0);
		return jdbcTemplate.queryForObject(sql, rowMapper, key);
	}

	@Override
	public void insertOne(DeptVo t) throws SQLException {
		String sql = "insert into dept values (?,?,?)";
		jdbcTemplate.update(sql, t.getDeptno(), t.getDname(), t.getLoc());
		
	}

	@Override
	public int updateOne(DeptVo t) throws SQLException {
		String sql = "update dept set dname=?, loc=? where deptno=?";
		return jdbcTemplate.update(sql, t.getDname(), t.getLoc(), t.getDeptno());
	}

	@Override
	public int deleteOne(int key) throws SQLException {
		String sql = "delete from dept where deptno=?";
		return jdbcTemplate.update(sql, key);
	}

}
