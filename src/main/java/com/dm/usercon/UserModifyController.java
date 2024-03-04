package com.dm.usercon;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dm.gagiproject.UserDAO;
import com.dm.gagiproject.UserDTO;


@WebServlet("/Modify.do")
public class UserModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String getId = (String) request.getParameter("ModifyId");
		String identify = request.getParameter("LoginBy");
		UserDAO ua = new UserDAO();
		UserDTO ud = new UserDTO();
		ud = ua.selectModifyUser(getId);
		
		String id = ud.getUser_Id();
		String pw = ud.getUser_Password();
		String name = ud.getUser_Name();
		String nickname = ud.getUser_Nickname();
		String address = ud.getUser_Address();
		String phone = ud.getUser_Phone();
		String email = ud.getUser_Email();
		HttpSession session = request.getSession();
		session.setAttribute("modifyId", id);
		session.setAttribute("modifyPw", pw);
		session.setAttribute("modifyName", name);
		session.setAttribute("modifyNickname", nickname);
		session.setAttribute("modifyAddress", address);
		session.setAttribute("modifyPhone", phone);
		session.setAttribute("modifyEmail", email);
		//RequestDispatcher dis = request.getRequestDispatcher("admin.jsp?CONTENTPAGE=modify.jsp&LoginBy="+identify);
		//dis.forward(request, response);
		if(identify.equals("User")) {
			response.sendRedirect("index.jsp?CONTENTPAGE=modify.jsp&LoginBy="+identify);
		}else {
		response.sendRedirect("admin.jsp?CONTENTPAGE=adminModify.jsp&LoginBy="+identify);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
