<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="com.dm.gagiproject.*"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div class = "login">
    	<div class="main_product roomy-80">
    	<div class = "interprofile">
    		<div class = "profile">
    			<img class="img-circle" src="assets/images/test-img1.png" alt="" />
    		</div>
    		<div class = "profiletext">
    			<p>${selectMain.getUser_Nickname() }</p>
    			<p>${selectMain.getBoard_Address() }</p>
    			<p>${USERSUGGEST }</p>
    		</div>
    		<div class = "profiletext2">
    			<h1>${selectMain.getBoard_Title() }</h1>
    			<p>${selectMain.getBoard_Price() }</p>
    		</div>
    		<div class = "profilebutton">
    			<input type = "button" value = "신고" class = "probtn1">
    			<input type = "button" value = "추천" class = "probtn2" onclick="location.href='UserSuggest.do?SuggestUser=${selectMain.getUser_Id()}&BOARDNUMBER=${selectMain.getBoard_Number() }'">
    			<input type = "button" value = "쪽지" class = "probtn2" onclick="location.href='index.jsp?CONTENTPAGE=NoteUpload.jsp&ACCEPTUSER=${selectMain.getUser_Id()}'">
    		</div>
    	</div>
    	<hr style="border:solid 1px black;">
    		<form class = "tradalign">
    			<img src="imgfile/${selectMain.getBoard_Img() }" alt="" />
    			<div>
    				<h1>${selectMain.getBoard_Content() }</h1>
    			</div>
    		</form>
    		
    		
    <div class = "table">
        		<hr style="border:solid 1px black;">
    <table class="tablemodule">
    		<tr>
	            <th class = "inquiryth"><b>닉네임</b></th>
	            <th class = "inquiryth"><b>내용</b></th>
	        </tr> 
        <c:forEach items="${cList}" var="CommentList">        
	        <tr>
	            <td class = "inquirytd">${CommentList.getUser_Nickname() }</td>
	            <td class = "inquirytd">${CommentList.getComment_Content() }</td>
	        </tr>
		</c:forEach>
    </table>
    </div>
    		<form class ="comment" method="post" action="CommentUpload.do">
    			<input type="hidden" value = "${selectMain.getBoard_Number() }" name="Board_Number">
    			<div class = "commenttext">
    				<textarea name = "Comment_Content" placeholder = "내용을 입력해주세요." cols = "100" rows = "5" required></textarea>
    			</div>
    			<div class = "commentprofile">
    				<div>
    					<input type = "submit" value = "작성" class = "commentbtn">
    				</div>
    			</div>
    					
    		</form>    		
    	</div>
    </div>


