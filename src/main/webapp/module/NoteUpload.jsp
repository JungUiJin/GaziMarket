<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div class = "login">
    	<div class="main_product roomy-80">
    	<form action="NoteUpload.do" method="post">
    		<div class = "trad">
    			<br>
    			<input type = "text" placeholder = "제목" class = "searchmodule2" name="Note_Title"><br>
    			보내는이 <input type="text" name="Send_User" value="${Logined_User.getUser_Id()}">
    			받는이 <input type="text" name="Accept_User" value="${param.ACCEPTUSER}">		
    		</div>
    		<br>		
    		<textarea name = "Note_Content" placeholder = "내용" cols = "130" rows = "30" required></textarea>
    		<br>
    		<input type = "submit" value = "게시하기" class = "boardclass">
    	</form>
    	</div>
    </div>


