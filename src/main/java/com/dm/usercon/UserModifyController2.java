package com.dm.usercon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dm.gagiproject.UserDAO;
import com.dm.gagiproject.UserDTO;

@WebServlet("/Modify2.do")
public class UserModifyController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String identify = request.getParameter("LoginBy");
		UserDTO ut = new UserDTO();
		UserDAO ua = new UserDAO();
		String id = (String) request.getParameter("User_Id");
		String pw = (String) request.getParameter("User_Password");
		String name = (String) request.getParameter("User_Name");
		String nickname = (String) request.getParameter("User_Nickname");
		String address = (String) request.getParameter("User_Address");
		String phone = (String) request.getParameter("User_Phone");
		String email = (String) request.getParameter("User_Email");
		
		ut.setUser_Id(id);
		ut.setUser_Password(pw);
		ut.setUser_Address(address);
		ut.setUser_Name(name);
		ut.setUser_Nickname(nickname);
		ut.setUser_Phone(phone);
		ut.setUser_Email(email);
		
		ua.updateUser(ut);
		if(identify.equals("Admin")) {
		RequestDispatcher dis = request.getRequestDispatcher("UserList.do");
		dis.forward(request, response);
		}else {
		response.setContentType("text/html; charset=UTF-8");		 
		PrintWriter out = response.getWriter();	 
		out.println("<script>alert('수정 성공! 다시 로그인하면 바뀐 정보가 보입니다.'); location.href='MyPage.do?LOGIN_ID="+id+"';</script>"); 
		out.flush();
		//response.sendRedirect("MyPage.do?LOGIN_ID="+id);
		}
	}

}
