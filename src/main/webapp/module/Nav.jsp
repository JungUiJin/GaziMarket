<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        <a class="navbar-brand" href="index.jsp">
                            <img src="assets/images/logo.png" class="logo" alt="">
                            <!--<img src="assets/images/footer-logo.png" class="logo logo-scrolled" alt="">-->
                        </a>

                    </div>
                    <!-- End Header Navigation -->

                    <!-- navbar menu -->
                    <div class="collapse navbar-collapse" id="navbar-menu">
                        <ul class="nav navbar-nav navbar-right">
					<c:if test="${Logined_User==null}">
                            <li><a href="index.jsp?CONTENTPAGE=login.jsp">로그인</a></li>
                            <li><a href="index.jsp?CONTENTPAGE=register.jsp">회원가입</a></li>     
          			</c:if>
          			<c:if test="${Logined_User!=null }">
							<li><a href="#">${Logined_User.getUser_Nickname() }님 환영합니다!</a></li>
							<li><a href="UserLogout.do">로그아웃</a></li>
					</c:if>
                            <li><a href="BoardList.do?CATEGORY=deal">중고거래</a></li>
                            <li><a href="BoardList.do?CATEGORY=inquiry">문의페이지</a></li>
                            <li><a href="MyPage.do?LOGIN_ID=${Logined_User.getUser_Id() }">마이페이지</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div> 
            </nav>
    