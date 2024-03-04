package com.dm.gagiproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NoteDAO {
	final String NOTE_INSERT="INSERT INTO `note` (`Note_Number`, `Send_Id`, `Accept_Id`, `Note_Content`, `Note_Title`) VALUES (?, ?, ?, ?, ?);";
	final String LAST_NOTE_NUMBER="select Note_Number from Note order by Note_Number desc";
	final String NOTE_USER_SELECT="select * from NOTE where Send_Id=? or Accept_Id=?";
	final String NOTE_MAIN_SELECT="select * from NOTE where Note_Number=?";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void insertNote(NoteDTO Note) {
		conn=DBUtil.getConnection();
		try {
			pstmt=conn.prepareStatement(NOTE_INSERT);
			pstmt.setInt(1, Note.getNote_Number());
			pstmt.setString(2, Note.getSend_Id());
			pstmt.setString(3, Note.getAccept_Id());
			pstmt.setString(4, Note.getNote_Content());
			pstmt.setString(5, Note.getNote_Title());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int Note_lastNumber() {
		int lastNote=0;
		conn=DBUtil.getConnection();
		try {
			pstmt=conn.prepareStatement(LAST_NOTE_NUMBER);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				lastNote=rs.getInt("Note_Number");
				return lastNote+1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lastNote+1;
	}
	public ArrayList<NoteDTO> selectNote(String UserId){
		conn=DBUtil.getConnection();
		ArrayList<NoteDTO> nList = new ArrayList<NoteDTO>();
		try {
			pstmt=conn.prepareStatement(NOTE_USER_SELECT);
			pstmt.setString(1, UserId);
			pstmt.setString(2, UserId);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				NoteDTO nt = new NoteDTO();
				nt.setNote_Number(rs.getInt("Note_Number"));
				nt.setSend_Id(rs.getString("Send_Id"));
				nt.setAccept_Id(rs.getString("Accept_Id"));
				nt.setNote_Title(rs.getString("Note_Title"));
				nt.setNote_Content(rs.getString("Note_Content"));
				nt.setNote_Date(rs.getString("Note_Date"));
				
				nList.add(nt);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return nList;
	}
	public NoteDTO seletMainNote(String NoteNumber) {
		conn=DBUtil.getConnection();
		NoteDTO nt = new NoteDTO();
		try {
			pstmt=conn.prepareStatement(NOTE_MAIN_SELECT);
			pstmt.setString(1, NoteNumber);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				nt.setNote_Number(rs.getInt("Note_Number"));
				nt.setSend_Id(rs.getString("Send_Id"));
				nt.setAccept_Id(rs.getString("Accept_Id"));
				nt.setNote_Title(rs.getString("Note_Title"));
				nt.setNote_Content(rs.getString("Note_Content"));
				nt.setNote_Date(rs.getString("Note_Date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nt;
	}
}
