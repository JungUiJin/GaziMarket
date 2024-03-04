package com.dm.usercon;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.dm.gagiproject.UserDTO;


@WebServlet("/BoardList.do")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		BoardDAO ba = new BoardDAO();
		String category = request.getParameter("CATEGORY");
		ArrayList<BoardDTO> bList = ba.selectBoard(category);
		HttpSession session = request.getSession();
		session.setAttribute("bList", bList);
		session.setAttribute("get_categoty", category);
		if(category.equals("deal")) {
		//	RequestDispatcher dis = request.getRequestDispatcher("index.jsp?CONTENTPAGE=BoardList.jsp");
		//	dis.forward(request, response);
			response.sendRedirect("index.jsp?CONTENTPAGE=BoardList.jsp");
		}
		else {
		//	RequestDispatcher dis = request.getRequestDispatcher("index.jsp?CONTENTPAGE=inquiry.jsp");
		//	dis.forward(request, response);	
			response.sendRedirect("index.jsp?CONTENTPAGE=inquiry.jsp");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		BoardDAO ba = new BoardDAO();
		
		String category = request.getParameter("CATEGORY");
		System.out.println(category);
		String Btitle = request.getParameter("Board_Title");
		System.out.println(Btitle);
		String Do = request.getParameter("do");
		String Si = request.getParameter("si");
		String Gu = request.getParameter("gu");
		String Dong = request.getParameter("dong");
		String Baddress = Do+" "+Si+" "+Gu+" "+Dong;
		System.out.println(Baddress);
		ArrayList<BoardDTO> bList = ba.searchUser(category,Btitle,Baddress);
		if(bList==null) {
			response.setContentType("text/html; charset=UTF-8");		 
			PrintWriter out = response.getWriter();	 
			out.println("<script>alert('검색결과가 없습니다.'); location.href='BoardList.do?CATEGORY="+category+"';</script>"); 
			out.flush();
		}
		else {
		session.setAttribute("bList", bList);
		session.setAttribute("get_categoty", category);
		if(category.equals("deal")) {
			//	RequestDispatcher dis = request.getRequestDispatcher("index.jsp?CONTENTPAGE=BoardList.jsp");
			//	dis.forward(request, response);
				response.sendRedirect("index.jsp?CONTENTPAGE=BoardList.jsp");
			}
			else {
			//	RequestDispatcher dis = request.getRequestDispatcher("index.jsp?CONTENTPAGE=inquiry.jsp");
			//	dis.forward(request, response);	
				response.sendRedirect("index.jsp?CONTENTPAGE=inquiry.jsp");
			}
		}
	}

}
