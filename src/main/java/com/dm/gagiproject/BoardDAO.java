package com.dm.gagiproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {
	final String BOARD_INSERT="INSERT INTO `board` (`Board_Number`, `User_Id`, `User_Nickname`, `Board_Address`, `Board_Price`, `Board_Title`, `Board_Category`, `Board_Img`, `Board_Content`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
	final String LAST_BOARD_NUMBER="select Board_Number from Board order by Board_Number desc";
	final String BOARD_SELECT="select * from BOARD where Board_Category=? order by Board_Number desc";
	final String BOARD_USER_SELECT="select * from BOARD where User_Id=?";
	final String BOARD_MAIN_SELECT="select * from BOARD where Board_Number=?";
	final String BOARD_SEARCH="select * from BOARD where Board_Category=? and Board_Title LIKE ? and Board_Address LIKE ? order by Board_Number desc";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void insertBoard(BoardDTO Board) {
		conn=DBUtil.getConnection();
		try {
			pstmt=conn.prepareStatement(BOARD_INSERT);
			pstmt.setInt(1, Board.getBoard_Number());
			pstmt.setString(2,Board.getUser_Id());
			pstmt.setString(3,Board.getUser_Nickname());
			pstmt.setString(4,Board.getBoard_Address());
			pstmt.setString(5,Board.getBoard_Price());
			pstmt.setString(6,Board.getBoard_Title());
			pstmt.setString(7,Board.getBoard_Category());
			pstmt.setString(8,Board.getBoard_Img());
			pstmt.setString(9,Board.getBoard_Content());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int Board_lastNumber() {
		int lastBoard=0;
		conn=DBUtil.getConnection();
		try {
			pstmt=conn.prepareStatement(LAST_BOARD_NUMBER);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				lastBoard=rs.getInt("Board_Number");
				return lastBoard+1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lastBoard+1;
	}
	public ArrayList<BoardDTO> selectBoard(String category){
		ArrayList<BoardDTO> bList = new ArrayList<BoardDTO>();
		conn=DBUtil.getConnection();
		try {
			pstmt=conn.prepareStatement(BOARD_SELECT);
			pstmt.setString(1, category);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO bt = new BoardDTO();
				bt.setBoard_Number(rs.getInt("Board_Number"));
				bt.setBoard_Title(rs.getString("Board_Title"));
				bt.setBoard_Content(rs.getString("Board_Content"));
				bt.setBoard_Category(rs.getString("Board_Category"));
				bt.setUser_Id(rs.getString("User_Id"));
				bt.setUser_Nickname(rs.getString("User_Nickname"));
				bt.setBoard_Img(rs.getString("Board_Img"));
				bt.setBoard_Price(rs.getString("Board_Price"));
				bt.setBoard_Address(rs.getString("Board_Address"));
				bt.setBoard_Date(rs.getString("Board_Date"));
				bList.add(bt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bList;
	}
	public ArrayList<BoardDTO> selectUserBoard(String UserId){
		ArrayList<BoardDTO> bList = new ArrayList<BoardDTO>();
		conn=DBUtil.getConnection();
		try {
			pstmt=conn.prepareStatement(BOARD_USER_SELECT);
			pstmt.setString(1, UserId);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO bt = new BoardDTO();
				bt.setBoard_Number(rs.getInt("Board_Number"));
				bt.setBoard_Title(rs.getString("Board_Title"));
				bt.setBoard_Content(rs.getString("Board_Content"));
				bt.setBoard_Category(rs.getString("Board_Category"));
				bt.setUser_Id(rs.getString("User_Id"));
				bt.setUser_Nickname(rs.getString("User_Nickname"));
				bt.setBoard_Img(rs.getString("Board_Img"));
				bt.setBoard_Price(rs.getString("Board_Price"));
				bt.setBoard_Address(rs.getString("Board_Address"));
				bt.setBoard_Date(rs.getString("Board_Date"));
				bList.add(bt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bList;
	}
	public BoardDTO selectBoardMain(int boardNum) {
		conn=DBUtil.getConnection();
		BoardDTO bt = new BoardDTO();
		try {
			pstmt=conn.prepareStatement(BOARD_MAIN_SELECT);
			pstmt.setInt(1, boardNum);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				bt.setBoard_Number(rs.getInt("Board_Number"));
				bt.setBoard_Title(rs.getString("Board_Title"));
				bt.setBoard_Content(rs.getString("Board_Content"));
				bt.setBoard_Category(rs.getString("Board_Category"));
				bt.setUser_Id(rs.getString("User_Id"));
				bt.setUser_Nickname(rs.getString("User_Nickname"));
				bt.setBoard_Img(rs.getString("Board_Img"));
				bt.setBoard_Price(rs.getString("Board_Price"));
				bt.setBoard_Address(rs.getString("Board_Address"));
				bt.setBoard_Date(rs.getString("Board_Date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bt;
	}
	public ArrayList<BoardDTO>searchUser(String category,String title,String address){
		conn=DBUtil.getConnection();
		ArrayList<BoardDTO> bList = new ArrayList<BoardDTO>();
		try {
			pstmt=conn.prepareStatement(BOARD_SEARCH);
			pstmt.setString(1, category);
			pstmt.setString(2,"%"+title+"%");
			pstmt.setString(3, "%"+address+"%");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO bt = new BoardDTO();
				bt.setBoard_Number(rs.getInt("Board_Number"));
				bt.setBoard_Title(rs.getString("Board_Title"));
				bt.setBoard_Content(rs.getString("Board_Content"));
				bt.setBoard_Category(rs.getString("Board_Category"));
				bt.setUser_Id(rs.getString("User_Id"));
				bt.setUser_Nickname(rs.getString("User_Nickname"));
				bt.setBoard_Img(rs.getString("Board_Img"));
				bt.setBoard_Price(rs.getString("Board_Price"));
				bt.setBoard_Address(rs.getString("Board_Address"));
				bt.setBoard_Date(rs.getString("Board_Date"));
				bList.add(bt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bList;
	}
}
