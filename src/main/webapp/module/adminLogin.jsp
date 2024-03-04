<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <div class = "login">
    	<div class="main_product roomy-80">
        	<img src="assets/images/logo2.png" class="Logo2" alt="">
        		<hr style="border:solid 1px black;">
        	<form action="Admin_Login.do" method="post">
            	<div class="loginID">
                	<input type="text" class="input" placeholder="아이디" name="Admin_Id" maxlength="20">
            	</div>
            	<div class="loginPassword">
                	<input type="password" class="input" placeholder="비밀번호" name="Admin_Password" maxlength="20">
            	</div>
            	<div class ="menu_join">
            		<a class="menu_title" href="register.jsp">회원가입</a>
            		<input type="checkbox" class ="loginCheck"> 아이디 저장
            	</div>
            	<input type="submit" class="bt_login" value="로그인" style="width:300pt; height:40pt">
        	</form>
    	</div>
    </div>


