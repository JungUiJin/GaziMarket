<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String id = (String)session.getAttribute("modifyId");
	String pw = (String)session.getAttribute("modifyPw");
	String name = (String)session.getAttribute("modifyName");
	String nickname = (String)session.getAttribute("modifyNickname");
	String phone = (String)session.getAttribute("modifyPhone");
	String email = (String)session.getAttribute("modifyEmail");
	String address = (String)session.getAttribute("modifyAdress");
%>
    <div class = "Join">
	    	<div class="main_product roomy-80">
	        	<img src="assets/images/logo2.png" class="Logo2" alt="">
	        		<hr style="border:solid 1px black;">
	        	<form method="post" action="Modify2.do?LoginBy=${param.LoginBy }">
		            <div class="Name">
		                 <a>이름 </a><input type="text" class="input" placeholder="이름" name="User_Name" value ="<%=name%>" maxlength="20">
		            </div>
		            <div class="Name">
		                <a>닉네임 </a><input type="text" class="input" placeholder="닉네임" name="User_Nickname" value ="<%=nickname%>" maxlength="20">
		            </div>
		            <div class="LoginID">
		                <a>아이디 </a><input type="text" class="input" placeholder="아이디" name="User_Id" value ="<%=id%>" maxlength="20">
		            </div>
		            <div class="loginPassword">
		                <a>비밀번호 </a><input type="password" class="input" placeholder="비밀번호" name="User_Password" value ="<%=pw%>" maxlength="20">
		            </div>
		            <div class="PasswordCheck">
		                <a>비밀번호확인 </a><input type="password" class="input" placeholder="비밀번호 확인" name="User_Password" value ="<%=pw%>" maxlength="20">
		            </div>
		            <div class="PhoneNumber">
		                <a>전화번호 </a><input type="text" class="input" placeholder="전화번호" name="User_Phone" value ="<%=phone%>" maxlength="20">
		            </div>
		            <div class="Email">
		                <a>이메일 </a><input type="text" class="input" placeholder="이메일" name="User_Email" value ="<%=email%>"maxlength="20">
		            </div>
		            <div class ="menu_join">
		            	<a>주소 </a><input type="text" class="input" placeholder="주소" name="User_Address" value ="<%=address%>" maxlength="20">
	            	</div>
	            	<input type="submit" class="bt_register" value="수정" style="width:300pt; height:40pt">
        	</form>
    	</div>
    </div>
