package com.dm.usercon;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dm.gagiproject.AdminDAO;



@WebServlet("/Admin_Login.do")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("Admin_Id");
		String pw = request.getParameter("Admin_Password");
		AdminDAO ud = new AdminDAO();
		String loginResult = ud.loginCheck(id, pw);
		String loginNickname = ud.loginName(id);
		if(loginResult == "0") {
			HttpSession session = request.getSession();
			session.setAttribute("AloginResult", loginResult);
			session.setAttribute("ALogin_Id", id);
			session.setAttribute("ALogin_Name", loginNickname);
			RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("AloginResult", loginResult);
			RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
			rd.forward(request, response);
		}
	}

}
