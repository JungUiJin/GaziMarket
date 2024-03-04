package com.dm.usercon;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dm.gagiproject.BoardDAO;
import com.dm.gagiproject.BoardDTO;
import com.dm.gagiproject.CommentDAO;
import com.dm.gagiproject.CommentDTO;
import com.dm.gagiproject.UserDAO;

@WebServlet("/BoardMain.do")
public class BoardMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int getBoardNumber = Integer.parseInt(request.getParameter("BOARDNUMBER").trim());
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		session.setAttribute("getBoardNumber", getBoardNumber);
		UserDAO ua = new UserDAO();
		BoardDTO bt = new BoardDTO();
		BoardDAO ba = new BoardDAO();
		bt = ba.selectBoardMain(getBoardNumber);
		session.setAttribute("selectMain", bt);
		int usersuggest = ua.SelectSuggest(bt.getUser_Id());
		session.setAttribute("USERSUGGEST", usersuggest);
		CommentDAO ca = new CommentDAO();
		ArrayList<CommentDTO> cList = ca.selectComment(getBoardNumber);
		session.setAttribute("cList", cList);
		
		RequestDispatcher dis = request.getRequestDispatcher("index.jsp?CONTENTPAGE=BoardMain.jsp");
		dis.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
