package com.dm.usercon;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dm.gagiproject.CommentDAO;
import com.dm.gagiproject.CommentDTO;


@WebServlet("/CommentUpload.do")
public class CommentUploadComtroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CommentDTO cd = new CommentDTO();
		CommentDAO ca = new CommentDAO();
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		
		
		String id = (String) session.getAttribute("Login_Id");
		int commentnumber = ca.Comment_lastNumber();
		String nickname = (String) session.getAttribute("Login_Nickname");
		String boardn = request.getParameter("Board_Number").trim();
		int boardnumber = Integer.parseInt(boardn);
		String commentcontent = (String) request.getParameter("Comment_Content");
		cd.setBoard_Number(boardnumber);
		cd.setComment_Number(commentnumber);
		cd.setUser_Id(id);
		cd.setUser_Nickname(nickname);
		cd.setComment_Content(commentcontent);
		
		ca.insertComment(cd);
		
		RequestDispatcher dis = request.getRequestDispatcher("BoardMain.do?BOARDNUMBER="+boardn);
		dis.forward(request, response);
	}

}
