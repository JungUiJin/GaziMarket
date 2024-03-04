<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.util.*,com.dm.gagiproject.*"%>
<%
	request.setCharacterEncoding("UTF-8");
	ArrayList<UserDTO> ulist = (ArrayList<UserDTO>)session.getAttribute("uList");

%>
    <div class = "table">
    	<div class="main_product roomy-80">
        	<img src="assets/images/logo2.png" class="Logo2" alt="">
        		<hr style="border:solid 1px black;">
        	<p class="cls1"><a href="#">회원정보</a></p>
    <table>
        <tr>
            <th><b>아이디</b></th>
            <th><b>비밀번호</b></th>
            <th><b>이름</b></th>
            <th><b>이메일</b></th>
            <th><b>가입일</b></th>
            <th><b>수정</b></th>
        </tr>
<% 
	for(int i=0;i<ulist.size();i++){
		UserDTO udto = ulist.get(i);
		String id = udto.getUser_Id();
		String pw = udto.getUser_Password();
		String name = udto.getUser_Name();
		String email = udto.getUser_Email();
		String date = udto.getUser_Date();
%>          
        <tr>
                        <td><%=id %></td>
                        <td><%=pw %></td>
                        <td><%=name %></td>
                        <td><%=email %></td>
                        <td><%=date %></td>
                        <td><a href="Modify.do?ModifyId=<%=id %>&LoginBy=Admin">수정</a></td>
                        <td><a href="Delete.do?DeleteId=<%=id %>&LoginBy=Admin">삭제</a></td>
        </tr>
<%
	}
%>
    </table>
    	</div>
    </div>


