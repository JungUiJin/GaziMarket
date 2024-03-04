package com.dm.usercon;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dm.gagiproject.AdminDAO;
import com.dm.gagiproject.AdminDTO;


@WebServlet("/Admin_Register.do")
public class AdminRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("Admin_Id");
		String pw = request.getParameter("Admin_Password");
		String name = request.getParameter("Admin_Name");
		String phone = request.getParameter("Admin_Phone");
		
		AdminDTO at = new AdminDTO();
		at.setAdmin_Id(id);
		at.setAdmin_Password(pw);
		at.setAdmin_Name(name);
		at.setAdmin_Phone(phone);
		
		AdminDAO aa = new AdminDAO();
		aa.insertAdmin(at);
		RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
		rd.forward(request, response);
	}

}
