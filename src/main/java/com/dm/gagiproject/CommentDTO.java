package com.dm.gagiproject;

public class CommentDTO {
	private int Board_Number;
	private String User_Id;
	private String User_Nickname;
	private int Comment_Number;
	private String Comment_Content;
	private String Comment_Date;
	public int getBoard_Number() {
		return Board_Number;
	}
	public void setBoard_Number(int board_Number) {
		Board_Number = board_Number;
	}
	public String getUser_Id() {
		return User_Id;
	}
	public void setUser_Id(String user_Id) {
		User_Id = user_Id;
	}
	public String getUser_Nickname() {
		return User_Nickname;
	}
	public void setUser_Nickname(String user_Nickname) {
		User_Nickname = user_Nickname;
	}
	public String getComment_Content() {
		return Comment_Content;
	}
	public void setComment_Content(String comment_Content) {
		Comment_Content = comment_Content;
	}
	public String getComment_Date() {
		return Comment_Date;
	}
	public void setComment_Date(String comment_Date) {
		Comment_Date = comment_Date;
	}
	public int getComment_Number() {
		return Comment_Number;
	}
	public void setComment_Number(int comment_Number) {
		Comment_Number = comment_Number;
	}
}
