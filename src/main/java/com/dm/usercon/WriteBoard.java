package com.dm.usercon;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dm.gagiproject.BoardDAO;
import com.dm.gagiproject.BoardDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/WriteBoard.do")
@MultipartConfig(
    fileSizeThreshold = 1024*1024,
    maxFileSize = 1024*1024*50, //50�ް�
    maxRequestSize = 1024*1024*50*5 // 50�ް� 5������
)
public class WriteBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ServletContext application = request.getServletContext();
		String path = application.getRealPath("/imgfile");
		int size = 1024 * 1024 * 100; // 100MB
		BoardDTO bt = new BoardDTO();
		BoardDAO ba = new BoardDAO();
		MultipartRequest multi = new MultipartRequest( request, // ������ request ��ü
				   path,	// ���ε� ��ġ
	 			   size,	// �ִ� ũ��
				   "UTF-8",	// ���ڵ� ����
		           new DefaultFileRenamePolicy()
		           );
		System.out.println("�������� ���� ���丮 :");
		System.out.println(path);
		
		
		HttpSession session = request.getSession();
		if(session.getAttribute("Logined_User")==null) {
			response.setContentType("text/html; charset=UTF-8");		 
			PrintWriter out = response.getWriter();	 
			out.println("<script>alert('�α��� �� �̿� �����մϴ�.'); location.href='index.jsp?CONTENTPAGE=login.jsp';</script>"); 
			out.flush();
		}
		
		String id = (String) session.getAttribute("Login_Id");
		int boardnumber = ba.Board_lastNumber();
		String nickname = (String) session.getAttribute("Login_Nickname");
		String Btitle = multi.getParameter("Board_Title");
		String Bcontent = multi.getParameter("Board_Content");
		String Do = multi.getParameter("do");
		String Si = multi.getParameter("si");
		String Gu = multi.getParameter("gu");
		String Dong = multi.getParameter("dong");
		String Baddress = Do+" "+Si+" "+Gu+" "+Dong;
		String Bprice = multi.getParameter("Board_Price");
		String Bimg = multi.getFilesystemName("Board_Img");
		String Bcategory = multi.getParameter("Board_Category");
		
		bt.setBoard_Number(boardnumber);
		bt.setUser_Id(id);
		bt.setUser_Nickname(nickname);
		bt.setBoard_Title(Btitle);
		bt.setBoard_Content(Bcontent);
		bt.setBoard_Address(Baddress);
		bt.setBoard_Category(Bcategory);
		bt.setBoard_Price(Bprice);
		bt.setBoard_Img(Bimg);		
		ba.insertBoard(bt);
		if(Bcategory.equals("deal")) {
			//RequestDispatcher dis = request.getRequestDispatcher("BoardList.do?CATEGORY=deal");
			//dis.forward(request, response);
			response.sendRedirect("BoardList.do?CATEGORY=deal");
		}else {
			//RequestDispatcher dis = request.getRequestDispatcher("BoardList.do?CATEGORY=inquiry");
			//dis.forward(request, response);
			response.sendRedirect("BoardList.do?CATEGORY=inquiry");
		}
	}

}
