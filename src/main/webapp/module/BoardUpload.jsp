<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div class = "login">
    	<div class="main_product roomy-80">
    	<form action="WriteBoard.do" method="post" enctype="multipart/form-data">
    		<div class = "trad">
    			<c:if test="${get_categoty=='deal' }">
    			<select name = "do" class = "selectmodule">
    				<option value="do">도</option>
    			</select>
    			<select name = "si" class = "selectmodule">
    				<option value="si">시</option>
    			</select>
    			<select name = "gu" class = "selectmodule">
    				<option value="gu">구/군</option>
    			</select>
    			<select name = "dong" class = "selectmodule">
    				<option value="dong">동/읍/면</option>
    			</select>
    			</c:if>
    			<select name = "Board_Category" class = "selectmodule">
    				<option value="deal">장터</option>
    				<option value="inquiry">문의</option>
    			</select>
    			<c:if test="${get_categoty=='deal' }">
    			<input type = "hidden" name="Board_Price" value=0>
    			<input type = "hidden" name="Board_Address" value="inquiry">
    			<input type = "hidden" name="Board_Img" value="inquiry">
    			<input type = "hidden" name="Board_Price" value="inquiry">
    			</c:if>
    			<br>
    			<input type = "text" placeholder = "제목" class = "searchmodule2" name="Board_Title">
    			
    			<c:if test="${get_categoty=='deal' }">
    			<input type = "text" placeholder = "가격" class = "searchmodule3" name="Board_Price">
    			</c:if>
    			
    			<input type="file" name="Board_Img" value=" ">
    		</div>
    		<br>
    		
    			<textarea name = "Board_Content" placeholder = "내용" cols = "130" rows = "30" required></textarea><br>
    		<input type = "submit" value = "게시하기" class = "boardclass">
    	</form>
    	</div>
    </div>


