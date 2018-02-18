package com.avik.myplan.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.avik.myplan.beans.Role;
import com.avik.myplan.manager.AppDBConnectionMgr;

public class RoleDAO {
	
	private int idrole;
	private String role;
	
	public RoleDAO() {
		
		idrole = 0;
		role = "";
	}
	
	public Role getRoleById(int roleid) {
		
		Role role = new Role();
		String roleSQL = "select * from enrolmentapp.role where role.idrole="+roleid;
		System.out.println("Role SQL --> "+roleSQL);
		AppDBConnectionMgr mgr = AppDBConnectionMgr.getInstance();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			con = mgr.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(roleSQL);
			if(rs.next()) {
				role.setIdrole(rs.getInt("idrole"));
				role.setRole(rs.getString("role"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			mgr.closeConnection(con);
		}
		
		return role;
	}

	public Role getRoleByName(String rolename) {
		
		Role role = new Role();
		String roleSQL = "select * from enrolmentapp.role where role.role='"+rolename+"'";
		System.out.println("Role SQL --> "+roleSQL);
		AppDBConnectionMgr mgr = AppDBConnectionMgr.getInstance();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			con = mgr.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(roleSQL);
			if(rs.next()) {
				role.setIdrole(rs.getInt("idrole"));
				role.setRole(rs.getString("role"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			mgr.closeConnection(con);
		}
		
		return role;
	}

}
