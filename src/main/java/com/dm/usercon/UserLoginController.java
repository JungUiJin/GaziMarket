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



@WebServlet("/login.do")
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UserLoginController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("User_Id");
		String pw = request.getParameter("User_Password");
		UserDAO ud = new UserDAO();
		UserDTO ut = new UserDTO();
		ut=ud.selectModifyUser(id);
		String loginResult = ud.loginCheck(id, pw);
		String loginNickname = ud.loginNickname(id);
		if(loginResult == "0") {
			HttpSession session = request.getSession();
			session.setAttribute("loginResult", loginResult);
			session.setAttribute("Login_Id", id);
			session.setAttribute("Login_Nickname", loginNickname);
			session.setAttribute("Logined_User", ut);
			//RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			//rd.forward(request, response);
			response.sendRedirect("index.jsp");
		}else {
			request.setAttribute("loginResult", loginResult);
			//RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			//rd.forward(request, response);
			response.setContentType("text/html; charset=UTF-8");		 
			PrintWriter out = response.getWriter();	 
			out.println("<script>alert('로그인 실패!! 아이디/비밀번호를 확인하세요'); location.href='index.jsp?CONTENTPAGE=login.jsp';</script>"); 
			out.flush();
			//response.sendRedirect("index.jsp?CONTENTPAGE=login.jsp");
		}
	}

}
