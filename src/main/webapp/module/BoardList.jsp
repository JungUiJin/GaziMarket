<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.util.*,com.dm.gagiproject.*"
%>
<%
	request.setCharacterEncoding("UTF-8");
	ArrayList<BoardDTO> blist = (ArrayList<BoardDTO>)session.getAttribute("bList");
%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    <div class = "login">
    	<div class="main_product roomy-80">
    		<div class = "trad">
    			<form method="post" action="BoardList.do">
    			<c:if test="${get_categoty=='deal'}">
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
    			<input type="hidden" name="CATEGORY" value="deal">
    			</c:if>"
    			<br>
    			<input type = "text" placeholder = "검색어 입력" name="Board_Title" class = "searchmodule">
    			<input type = "submit" value = "검색" class = "searchbutton">
    			<input type = "button" value = "작성하기" class = "buttonmodule" onclick="location.href='index.jsp?CONTENTPAGE=BoardUpload.jsp'">
    			</form>
    		</div>
    		<br>

    			<table class = "tablemodule">
<%
	for(int i=0;i<blist.size();i++){
		BoardDTO bdto = blist.get(i);
		int boardNumber = bdto.getBoard_Number();
		String title = bdto.getBoard_Title();
		String address = bdto.getBoard_Address();
		String price = bdto.getBoard_Price();
		String img = bdto.getBoard_Img();
%>
    				<tr class = "tradtr">
    					<td width="20%"><img src="imgfile/<%=img %>" alt=""></td>
    					<td class = "tabledmodule">
    						<a href="BoardMain.do?BOARDNUMBER=<%=boardNumber%>"><%=title %></a><br>
    						<%=address %><br>
    						<p class = "tableprice"><%=price %>원</p>
    					</td>
    				</tr>
<%
	}
%>
    			</table>

    	</div>
    </div>


