package com.dm.usercon;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dm.gagiproject.NoteDAO;
import com.dm.gagiproject.NoteDTO;

/**
 * Servlet implementation class NoteMainController
 */
@WebServlet("/NoteMain.do")
public class NoteMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		NoteDAO na = new NoteDAO();
		NoteDTO nt = new NoteDTO();
		HttpSession session = request.getSession();
		String boardnumber = request.getParameter("NOTENUMBER");
		nt = na.seletMainNote(boardnumber);
		session.setAttribute("SelectedNote", nt);
		response.sendRedirect("index.jsp?CONTENTPAGE=NoteMain.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
