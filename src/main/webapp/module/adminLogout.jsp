<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	session.removeAttribute("AloginResult");
	response.sendRedirect("../admin.jsp");
%>