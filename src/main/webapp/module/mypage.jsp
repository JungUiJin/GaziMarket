<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div class = "login">
    	<div class="main_product roomy-80">
    	<div class = "interprofile">
    		<div>
    			<h1>마이 페이지</h1>
    		</div>
    		<hr style="border:solid 1px black;">
    		<div class = "mppro">
    			<img class="img-circle" src="assets/images/test-img1.png" alt="" />
    		</div>
    		<div class = "mpprofile">
    			<p>이름  : ${Logined_User.getUser_Name() }</p>
    			<p>번호  : ${Logined_User.getUser_Phone() }</p>
    			<p>주소  : ${Logined_User.getUser_Address() }</p>
    			<p>이메일 : ${Logined_User.getUser_Email() }</p>
    		</div>
    		<div class = "mprofile2">
    			<h1>추천 수 : ${Logined_User.getUser_Suggest() }</h1>
    		</div>
    		<div class = "mpprofilebutton">
    			<input type = "button" value = "수정하기" class = "mpbtn" onclick="location.href='Modify.do?ModifyId=${Logined_User.getUser_Id()}&LoginBy=User'">
    		</div>
    	</div>
    	<hr style="border:solid 1px black;">
    		<form>
    			<div class = "mpinfo1">
    				<h1>쪽지</h1>
    				<table class = "mptable">
    					<tr>
    					<th class = "mptableth">쪽지 번호</th>
    					<th class = "mptableth">제목</th>
    					<th class = "mptableth">보낸이</th>
    					<th class = "mptableth">받은이</th>
    					</tr>
    					<c:forEach items="${User_nList }" var="nList">
    					<tr>
    						<td class = "mptabletd">${nList.getNote_Number() }</td>
    						<td class = "mptabletd"><a href="NoteMain.do?NOTENUMBER=${nList.getNote_Number()}">${nList.getNote_Title() }</a></td>
    						<td class = "mptabletd">${nList.getSend_Id() }</td>
    						<td class = "mptabletd">${nList.getAccept_Id() }</td>
    					</tr>
    					</c:forEach>
    				</table>
    			</div>
    			<div class = "v-line">
    			</div>
    			<div class = "mpinfo2">
    				<h1>게시글</h1>
    				<table class = "mptable2">
    					<tr>
    					<th class = "mptableth">게시글 번호</th>
    					<th class = "mptableth">제목</th>
    					<th class = "mptableth">날짜</th>
    					<th class = "mptableth">카테고리</th>
    					</tr>
    					<c:forEach items="${User_bList }" var="bList">
    					<tr>
    						<td class = "mptabletd">${bList.getBoard_Number() }</td>
    						<td class = "mptabletd"><a href="BoardMain.do?BOARDNUMBER=${bList.getBoard_Number()}">${bList.getBoard_Title() }</a></td>
    						<td class = "mptabletd">${bList.getBoard_Date() }</td>
    						<td class = "mptabletd">${bList.getBoard_Category() }</td>
    					</tr>
						</c:forEach>
    				</table>
    			</div>
    		</form>  		
    	</div>
    </div>


