<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="com.dm.gagiproject.*"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div class = "login">
    	<div class="main_product roomy-80">
    	<div class = "interprofile">
    		<div class = "profiletext">
    			<h1>쪽지 :${SelectedNote.getNote_Title() }</h1>
    		</div>
    		<div class = "profiletext2">
				<p>보낸이 : ${SelectedNote.getSend_Id() }</p>
    			<p>받은이 : ${SelectedNote.getAccept_Id() }</p>
    		</div>
    	</div>
    	<hr style="border:solid 1px black;">
    	<div class = "commentprofile">
    	<h1>${SelectedNote.getNote_Content() }</h1>
    	
    	</div>
    		  		
    	</div>
    </div>


