<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    <div class = "Join">
	    	<div class="main_product roomy-80">
	        	<img src="assets/images/logo2.png" class="Logo2" alt="">
	        		<hr style="border:solid 1px black;">
	        	<form method="post" action="Admin_Register.do">
		            <div class="Name">
		                <input type="text" class="input" placeholder="이름" name="Admin_Name" maxlength="20">
		            </div>
		            <div class="LoginID">
		                <input type="text" class="input" placeholder="아이디" name="Admin_Id" maxlength="20">
		            </div>
		            <div class="loginPassword">
		                <input type="password" class="input" placeholder="비밀번호" name="Admin_Password" maxlength="20">
		            </div>
		            <div class="PasswordCheck">
		                <input type="password" class="input" placeholder="비밀번호 확인" name="Admin_Password" maxlength="20">
		            </div>
		            <div class="PhoneNumber">
		                <input type="text" class="input" placeholder="전화번호" name="Admin_Phone" maxlength="20">
		            </div>

	            	<input type="submit" class="bt_register" value="회원가입" style="width:300pt; height:40pt">
        	</form>
    	</div>
    </div>
