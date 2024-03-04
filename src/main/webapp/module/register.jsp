<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
    <div class = "Join">
	    	<div class="main_product roomy-80">
	        	<img src="assets/images/logo2.png" class="Logo2" alt="">
	        		<hr style="border:solid 1px black;">
	        	<form method="post" action="Register.do">
		            <div class="Name">
		                <input type="text" class="input" placeholder="이름" name="User_Name" maxlength="20">
		            </div>
		            <div class="Name">
		                <input type="text" class="input" placeholder="닉네임" name="User_Nickname" maxlength="20">
		            </div>
		            <div class="LoginID">
		                <input type="text" class="input" placeholder="아이디" name="User_Id" maxlength="20">
		            </div>
		            <div class="loginPassword">
		                <input type="password" class="input" placeholder="비밀번호" name="User_Password" maxlength="20">
		            </div>
		            <div class="PasswordCheck">
		                <input type="password" class="input" placeholder="비밀번호 확인" name="User_Password2" maxlength="20">
		            </div>
		            <div class="PhoneNumber">
		                <input type="text" class="input" placeholder="전화번호" name="User_Phone" maxlength="20">
		            </div>
		            <div class="Email">
		                <input type="text" class="input" placeholder="이메일" name="User_Email" maxlength="20">
		            </div>
		            <div class ="menu_join">
		            	<input type="test" class="input" placeholder="주소" name="User_Address" maxlength="20">
	            	</div>
	            	<input type="submit" class="bt_register" value="회원가입" style="width:300pt; height:40pt">
        	</form>
    	</div>
    </div>
