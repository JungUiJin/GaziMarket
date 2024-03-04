package com.dm.usercon;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dm.gagiproject.UserDAO;
import com.dm.gagiproject.UserDTO;


@WebServlet("/UserSuggest.do")
public class UserSuggestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("SuggestUser");
		String bnum = request.getParameter("BOARDNUMBER");
		UserDAO ua = new UserDAO();
		UserDTO ut = ua.selectModifyUser(id);
		int sg = ut.getUser_Suggest();
		ua.SuggestUser(id,sg);
		
		response.sendRedirect("BoardMain.do?BOARDNUMBER="+bnum);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
