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

import com.dm.gagiproject.UserDAO;
import com.dm.gagiproject.UserDTO;


@WebServlet("/UserList.do")
public class UserListController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		request.setCharacterEncoding("UTF-8");
		UserDAO udao = new UserDAO();
		ArrayList<UserDTO> uList = udao.selctUser();
		HttpSession session = request.getSession();
		session.setAttribute("uList",uList);
		//RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp?CONTENTPAGE=DBManage.jsp");
		//dispatcher.forward(request, response);
		response.sendRedirect("admin.jsp?CONTENTPAGE=DBManage.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
