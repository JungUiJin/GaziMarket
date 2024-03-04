package com.dm.gagiproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AdminDAO {
	final String ADMIN_INSERT="insert into ADMIN  (`Admin_Id`, `Admin_Password`, `Admin_Name`,`Admin_Phone`) values(?,?,?,?)";
	final String ADMIN_CHECK="select Admin_Id from Admin where Admin_Id=? and Admin_Password=?";
	final String ADMIN_NAME="select Admin_Name from Admin where Admin_Id=?";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String loginCon = "0";
	
	public void insertAdmin(AdminDTO Admin){
		conn = DBUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(ADMIN_INSERT);
			pstmt.setString(1, Admin.getAdmin_Id());
			pstmt.setString(2, Admin.getAdmin_Password());
			pstmt.setString(3, Admin.getAdmin_Name());
			pstmt.setString(4, Admin.getAdmin_Phone());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(pstmt, conn);
		}
	}
	public String loginCheck(String id, String pw) {
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(ADMIN_CHECK);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				loginCon="0";
				return loginCon;
			}else {
				loginCon="1";
				return loginCon;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(pstmt, conn);
		}
		return loginCon;
	}
	public String loginName(String id) {
		String LoginName="Test1";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(ADMIN_NAME);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			LoginName="Test2";
			while(rs.next()) {
				LoginName = rs.getString("Admin_Name");
			}
			return LoginName;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return LoginName;
	}
}
