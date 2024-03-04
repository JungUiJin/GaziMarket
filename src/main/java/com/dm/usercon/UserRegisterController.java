package com.dm.usercon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dm.gagiproject.UserDAO;
import com.dm.gagiproject.UserDTO;


@WebServlet("/Register.do")
public class UserRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("User_Id");
		String pw = request.getParameter("User_Password");
		String pw2 = request.getParameter("User_Password2");
		String name = request.getParameter("User_Name");
		String nickname = request.getParameter("User_Nickname");
		String address = request.getParameter("User_Address");
		String phone = request.getParameter("User_Phone");
		String email = request.getParameter("User_Email");
		System.out.println(name);
		System.out.println(address);
		
		if(pw.equals(pw2)) {
			UserDTO ut = new UserDTO();
			ut.setUser_Id(id);
			ut.setUser_Password(pw);
			ut.setUser_Address(address);
			ut.setUser_Name(name);
			ut.setUser_Nickname(nickname);
			ut.setUser_Phone(phone);
			ut.setUser_Email(email);
			
			UserDAO ua = new UserDAO();
			ua.insertMember(ut);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}else {
			response.setContentType("text/html; charset=UTF-8");		 
			PrintWriter out = response.getWriter();	 
			out.println("<script>alert('비밀번호가 맞지 않습니다. 다시 확인해주세요'); location.href='index.jsp?CONTENTPAGE=register.jsp';</script>"); 
			out.flush();
		}
	}

}
