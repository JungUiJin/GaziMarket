<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div class = "login">
    	<div class="main_product roomy-80">
    		<div class = "inquiryh">
    			<h1>문의페이지</h1>
    		</div>
    		<div class = "inquiryh1">
    			<input type = "button" value = "작성하기" class = "inquirybutton" onclick="location.href='index.jsp?CONTENTPAGE=BoardUpload.jsp'">
    		</div>
    		<hr style="border:solid 1px black;">
    		<form>
    			<table border="1" class = "tablemodule">
    				<tr>
    				<th class = "inquiryth">게시글 번호</th>
    				<th class = "inquiryth">제목</th>
    				<th class = "inquiryth">날짜</th>
    				</tr>
    				<c:forEach items="${bList}" var="BoardList">
    				<tr>
    					<td class = "inquirytd">${BoardList.getBoard_Number()}</td>
    					<td class = "inquirytd"><a href="BoardMain.do?BOARDNUMBER=${BoardList.getBoard_Number()}">${BoardList.getBoard_Title()}</a></td>
    					<td class = "inquirytd">${BoardList.getBoard_Date()}</td>
    				</tr>
    				</c:forEach>
    			</table>
    		</form>
    	</div>
    </div>


