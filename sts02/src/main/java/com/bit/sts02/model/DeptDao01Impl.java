package com.bit.sts02.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.bit.sts02.model.entity.DeptVo;

public class DeptDao01Impl implements DeptDao {

	DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public List<DeptVo> selectAll() {
		
		String sql = "select * from dept order by deptno desc";
		
		List<DeptVo> list = new ArrayList<DeptVo>();
		
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				){
			while(rs.next())
				list.add(new DeptVo(
						rs.getInt(1)
						,rs.getString(2)
						,rs.getString(3)
						));
		} catch (SQLException e) {
					e.printStackTrace();
				}
		
		return list;
	}

	@Override
	public DeptVo selectOne(int deptno) {
		String sql = "select * from dept where deptno=?";
		
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
				pstmt.setInt(1, deptno);
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next())
					return new DeptVo(
							rs.getInt(1), rs.getString(2),rs.getString(3)
							);
				
				rs.close();
			
		} catch (SQLException e) {
					e.printStackTrace();
				}
		
		return null;
	}

	@Override
	public void insertOne(DeptVo bean) {
		String sql = "insert into dept values (?,?,?)";
		
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
				pstmt.setInt(1, bean.getDeptno());
				pstmt.setString(2, bean.getDname());
				pstmt.setString(3, bean.getLoc());
				pstmt.executeUpdate();
				
		} catch (SQLException e) {
					e.printStackTrace();
				}

	}

	@Override
	public int updateOne(DeptVo bean) {
		String sql = "update dept set dname=?, loc=? where deptno=?";
		
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
				pstmt.setString(1, bean.getDname());
				pstmt.setString(2, bean.getLoc());
				pstmt.setInt(3, bean.getDeptno());
				return pstmt.executeUpdate();
			
		} catch (SQLException e) {
					e.printStackTrace();
				}
		
		return 0;
	}

	@Override
	public int deleteOne(int deptno) {
		
		String sql = "delete from dept where deptno=?";
		
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
				pstmt.setInt(1, deptno);
				return pstmt.executeUpdate();
		} catch (SQLException e) {
					e.printStackTrace();
				}
		
		return 0;
	}

}
