package com.dm.usercon;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dm.gagiproject.NoteDAO;
import com.dm.gagiproject.NoteDTO;

/**
 * Servlet implementation class NoteUploadController
 */
@WebServlet("/NoteUpload.do")
public class NoteUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		NoteDTO nt = new NoteDTO();
		NoteDAO na = new NoteDAO();
		HttpSession session = request.getSession();
		int NoteNumber = na.Note_lastNumber();
		String SendId = (String) session.getAttribute("Login_Id");
		String AcceptId = request.getParameter("Accept_User");
		String Title = request.getParameter("Note_Title");
		String Content = request.getParameter("Note_Content");
		System.out.println(AcceptId);
		System.out.println(SendId);
		System.out.println(Title);
		System.out.println(Content);
		nt.setNote_Number(NoteNumber);
		nt.setSend_Id(SendId);
		nt.setAccept_Id(AcceptId);
		nt.setNote_Title(Title);
		nt.setNote_Content(Content);
		
		na.insertNote(nt);
		
		RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
		dis.forward(request, response);
	}

}
