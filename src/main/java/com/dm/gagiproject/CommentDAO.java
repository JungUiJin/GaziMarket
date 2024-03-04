package com.dm.gagiproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommentDAO {
	final String COMMENT_INSERT="INSERT INTO `comment` (`User_Id`, `User_Nickname`, `Board_Number`, `Comment_Number`, `Comment_Content`) VALUES (?, ?, ?, ?, ?)";
	final String LAST_COMMENT_NUMBER="select comment_Number from comment order by Comment_Number desc";
	final String COMMENT_SELECT="select * from COMMENT where Board_Number=?";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void insertComment(CommentDTO Comment) {
		conn=DBUtil.getConnection();
		try {
			pstmt=conn.prepareStatement(COMMENT_INSERT);
			pstmt.setString(1, Comment.getUser_Id());
			pstmt.setString(2, Comment.getUser_Nickname());
			pstmt.setInt(3, Comment.getBoard_Number());
			pstmt.setInt(4, Comment.getComment_Number());
			pstmt.setString(5, Comment.getComment_Content());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int Comment_lastNumber() {
		int lastComment=0;
		conn=DBUtil.getConnection();
		try {
			pstmt=conn.prepareStatement(LAST_COMMENT_NUMBER);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				lastComment=rs.getInt("Comment_Number");
				return lastComment+1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lastComment+1;
	}
	public ArrayList<CommentDTO> selectComment(int boardNumber){
		ArrayList<CommentDTO> cList = new ArrayList<CommentDTO>();
		conn=DBUtil.getConnection();
		try {
			pstmt=conn.prepareStatement(COMMENT_SELECT);
			pstmt.setInt(1, boardNumber);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				CommentDTO bt = new CommentDTO();
				bt.setBoard_Number(rs.getInt("Board_Number"));
				bt.setComment_Number(rs.getInt("Comment_Number"));
				bt.setComment_Content(rs.getString("Comment_Content"));
				bt.setUser_Id(rs.getString("User_Id"));
				bt.setUser_Nickname(rs.getString("User_Nickname"));
				bt.setComment_Date(rs.getString("Comment_Date"));
				cList.add(bt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cList;
	}
}
