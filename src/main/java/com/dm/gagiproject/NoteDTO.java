package com.dm.gagiproject;

public class NoteDTO {
	private int Note_Number;
	private String Send_Id;
	private String Accept_Id;
	private String Note_Title;
	private String Note_Content;
	private String Note_Date;
	public int getNote_Number() {
		return Note_Number;
	}
	public void setNote_Number(int note_Number) {
		Note_Number = note_Number;
	}
	public String getSend_Id() {
		return Send_Id;
	}
	public void setSend_Id(String send_Id) {
		Send_Id = send_Id;
	}
	public String getAccept_Id() {
		return Accept_Id;
	}
	public void setAccept_Id(String accept_Id) {
		Accept_Id = accept_Id;
	}
	public String getNote_Title() {
		return Note_Title;
	}
	public void setNote_Title(String note_Title) {
		Note_Title = note_Title;
	}
	public String getNote_Content() {
		return Note_Content;
	}
	public void setNote_Content(String note_Content) {
		Note_Content = note_Content;
	}
	public String getNote_Date() {
		return Note_Date;
	}
	public void setNote_Date(String note_Date) {
		Note_Date = note_Date;
	}
}
