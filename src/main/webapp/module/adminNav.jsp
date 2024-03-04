<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%	
	request.setCharacterEncoding("UTF-8");
	String loginResult = (String)session.getAttribute("AloginResult");
	String loginNickname = (String)session.getAttribute("ALogin_Name");
	String loginId = (String)session.getAttribute("ALogin_Id");
%>
            <nav class="navbar navbar-default bootsnav navbar-fixed">
                <!-- Start Top Search -->
                <div class="top-search">
                    <div class="container">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-search"></i></span>
                            <input type="text" class="form-control" placeholder="Search">
                            <span class="input-group-addon close-search"><i class="fa fa-times"></i></span>
                        </div>
                    </div>
                </div>
                <!-- End Top Search -->


                <div class="container"> 
                    <div class="attr-nav">
                        <ul>
                            <li class="search"><a href="#"><i class="fa fa-search"></i></a></li>
                        </ul>
                    </div> 

                    <!-- Start Header Navigation -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-menu">
                            <i class="fa fa-bars"></i>
                        </button>
                        <a class="navbar-brand" href="admin.jsp">
                            <img src="assets/images/logo.png" class="logo" alt="">
                            <!--<img src="assets/images/footer-logo.png" class="logo logo-scrolled" alt="">-->
                        </a>

                    </div>
                    <!-- End Header Navigation -->

                    <!-- navbar menu -->
                    <div class="collapse navbar-collapse" id="navbar-menu">
                        <ul class="nav navbar-nav navbar-right">
                        <li><a href="#">관리자 페이지 || </a></li>
<%
	if(loginResult == null){
%>
                            <li><a href="admin.jsp?CONTENTPAGE=adminLogin.jsp">로그인</a></li>
                            <li><a href="admin.jsp?CONTENTPAGE=adminRegister.jsp">회원가입</a></li>     
<%
	}else{
%>             
							<li><a href="#"><%=loginNickname%>님 환영합니다!</a></li>
							<li><a href="module/adminLogout.jsp">로그아웃</a></li>
<%
	}
%>
                            <li><a href="UserList.do">회원관리</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div> 
            </nav>
    