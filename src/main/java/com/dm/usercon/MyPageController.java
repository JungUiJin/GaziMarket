package com.dm.usercon;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dm.gagiproject.BoardDAO;
import com.dm.gagiproject.BoardDTO;
import com.dm.gagiproject.NoteDAO;
import com.dm.gagiproject.NoteDTO;
import com.dm.gagiproject.UserDTO;


@WebServlet("/MyPage.do")
public class MyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		BoardDAO ba = new BoardDAO();
		NoteDAO  na = new NoteDAO();
		HttpSession session = request.getSession();
		if(session.getAttribute("Logined_User")==null) {
			response.setContentType("text/html; charset=UTF-8");		 
			PrintWriter out = response.getWriter();	 
			out.println("<script>alert('로그인 후 이용 가능합니다.'); location.href='index.jsp?CONTENTPAGE=login.jsp';</script>"); 
			out.flush();
		}
		String loginUserId = request.getParameter("LOGIN_ID");
		
		ArrayList<BoardDTO> User_bList = ba.selectUserBoard(loginUserId);
		ArrayList<NoteDTO> User_nList = na.selectNote(loginUserId);
		
		session.setAttribute("User_bList", User_bList);
		session.setAttribute("User_nList", User_nList);
		
		response.sendRedirect("index.jsp?CONTENTPAGE=mypage.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
