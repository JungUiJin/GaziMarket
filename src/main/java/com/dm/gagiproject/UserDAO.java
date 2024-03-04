package com.dm.gagiproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UserDAO {
	final String USER_INSERT="insert into USER  (`User_Id`, `User_Password`, `User_Address`, `User_Name`, `User_Nickname`, `User_Phone`, `User_Email`) values(?,?,?,?,?,?,?)";
	final String USER_SELECT="select * from USER";
	final String USER_CHECK="select * from USER where User_Id=? and User_Password=?";
	final String USER_NICKNAME="select User_Nickname from User where User_Id=?";
	final String USER_MODIFY_SELECT="select * from User where User_Id=?";
	final String USER_UPDATE="update USER set User_id=?, User_Password=?, User_Address=?, User_Name=?, User_Nickname=?, User_Phone=?, User_Email=? where User_Id=?";
	final String USER_SUGGEST="update USER set User_Suggest=? where User_Id=?";
	final String USER_DELETE="delete from USER where User_Id=?";
	final String USER_SUGGEST_SELECT="select User_Suggest from USER where User_Id=?";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String loginCon = "0";
	
	public void insertMember(UserDTO User){
		conn = DBUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(USER_INSERT);
			pstmt.setString(1, User.getUser_Id());
			pstmt.setString(2, User.getUser_Password());
			pstmt.setString(3, User.getUser_Address());
			pstmt.setString(4, User.getUser_Name());
			pstmt.setString(5, User.getUser_Nickname());
			pstmt.setString(6, User.getUser_Phone());
			pstmt.setString(7, User.getUser_Email());
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
			pstmt = conn.prepareStatement(USER_CHECK);
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
	public String loginNickname(String id) {
		String LoginNickname="Test1";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(USER_NICKNAME);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			LoginNickname="Test2";
			while(rs.next()) {
				LoginNickname = rs.getString("User_Nickname");
			}
			return LoginNickname;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return LoginNickname;
	}
	public UserDTO selectModifyUser(String id) {
		conn = DBUtil.getConnection();
		UserDTO ud = new UserDTO();
		try {
			pstmt = conn.prepareStatement(USER_MODIFY_SELECT);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ud.setUser_Id(rs.getString("User_Id"));
				ud.setUser_Password(rs.getString("User_Password"));
				ud.setUser_Address(rs.getString("User_Address"));
				ud.setUser_Name(rs.getString("User_Name"));
				ud.setUser_Nickname(rs.getString("User_Nickname"));
				ud.setUser_Phone(rs.getString("User_Phone"));
				ud.setUser_Email(rs.getString("User_Email"));
				ud.setUser_Date(rs.getString("User_Date"));
				ud.setUser_Suggest(rs.getInt("User_Suggest"));
				ud.setUser_Report(rs.getInt("User_Report"));
			} 
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ud;
	}
	public void updateUser(UserDTO User) {
		conn = DBUtil.getConnection();
		try {
			pstmt=conn.prepareStatement(USER_UPDATE);
			pstmt.setString(1, User.getUser_Id());
			pstmt.setString(2, User.getUser_Password());
			pstmt.setString(3, User.getUser_Address());
			pstmt.setString(4, User.getUser_Name());
			pstmt.setString(5, User.getUser_Nickname());
			pstmt.setString(6, User.getUser_Phone());
			pstmt.setString(7, User.getUser_Email());
			pstmt.setString(8, User.getUser_Id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteUser(String id) {
		conn = DBUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(USER_DELETE);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<UserDTO> selctUser(){
		ArrayList<UserDTO> uList = new ArrayList<UserDTO>();
		try {
			conn= DBUtil.getConnection();
			pstmt = conn.prepareStatement(USER_SELECT);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UserDTO ud = new UserDTO();
				ud.setUser_Id(rs.getString("User_Id"));
				ud.setUser_Password(rs.getString("User_Password"));
				ud.setUser_Address(rs.getString("User_Address"));
				ud.setUser_Name(rs.getString("User_Name"));
				ud.setUser_Nickname(rs.getString("User_Nickname"));
				ud.setUser_Phone(rs.getString("User_Phone"));
				ud.setUser_Email(rs.getString("User_Email"));
				ud.setUser_Date(rs.getString("User_Date"));
				ud.setUser_Suggest(rs.getInt("User_Suggest"));
				ud.setUser_Report(rs.getInt("User_Report"));
				uList.add(ud);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return uList;
	}
	public void SuggestUser(String id, int suggest) {
		conn=DBUtil.getConnection();
		try {
			pstmt=conn.prepareStatement(USER_SUGGEST);
			pstmt.setInt(1, suggest+1);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int SelectSuggest(String id) {
		int suggest=0;
		conn=DBUtil.getConnection();
		try {
			pstmt=conn.prepareStatement(USER_SUGGEST_SELECT);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				suggest=rs.getInt("User_Suggest");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return suggest;
	}
}
