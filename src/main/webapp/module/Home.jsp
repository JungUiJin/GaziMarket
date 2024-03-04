<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<section id="home" class="home bg-black fix">
                <div class="overlay"></div>
                <div class="container">
                    <div class="row">
                        <div class="main_home text-center">
                            <div class="col-md-12">
                                <div class="hello_slid">
                                    <div class="slid_item">
                                        <div class="home_text ">
                                            <h2 class="text-white">������ �߰�ŷ� ����Ʈ</h2>
                                            <h1 class="text-white">��� ��ó�� ��������</h1>
                                            <h3 class="text-white">-�̿��� �Բ� ������ �ϻ�-</h3>
                                        </div>
                                        <div class="home_btns m-top-40">
                                        	<c:if test="${Logined_User==null}">
                                            <a href="index.jsp?CONTENTPAGE=login.jsp" class="btn btn-primary m-top-20">�α���</a>
                                            <a href="index.jsp?CONTENTPAGE=register.jsp" class="btn btn-default m-top-20">ȸ������</a>
                                            </c:if>
                                        </div>
                                    </div><!-- End off slid item -->
                                    <div class="slid_item">
                                        <div class="home_text ">
                                            <h2 class="text-white">�����ϰ� ���� <strong>�̿����� ����</strong></h2>
                                            <h1 class="text-white">�츮���� �߰� �ŷ� ����</h1>
                                            <h3 class="text-white">- �Խ����� ���� �̿��� �����ϼ���! -</h3>
                                        </div>

                                        <div class="home_btns m-top-40">
                                            <a href="BoardList.do?CATEGORY=deal" class="btn btn-default m-top-20">�Խ������� �̵�</a>
                                        </div>
                                    </div><!-- End off slid item -->
                                    <div class="slid_item">
                                        <div class="home_text ">
                                            <h2 class="text-white">������������ �ŷ�</h2>
                                            <h1 class="text-white">�����ϰ� ������ ��������</strong></h1>
                                            <h3 class="text-white">- ���Ե��� ��Ҹ��� �ͱ���̴� ��������! -</h3>
                                        </div>

                                        <div class="home_btns m-top-40">
                                            <a href="BoardList.do?CATEGORY=inquiry" class="btn btn-default m-top-20">���������� �̵�</a>
                                        </div>
                                    </div><!-- End off slid item -->
                                </div>
                            </div>

                        </div>


                    </div><!--End off row-->
                </div><!--End off container -->
            </section> <!--End off Home Sections-->

            <!--product section-->
            <section id="product" class="product">
                <div class="container">
                    <div class="main_product roomy-80">
                        <div class="head_title text-center fix">
                            <h2 class="text-uppercase">�ָ� �Ҹ��� �ŷ�</h2>
                            <h5>�α��ִ� �ŷ��� Ȯ���غ�����!</h5>
                        </div>

                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <!-- Indicators -->
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>

                            <!-- Wrapper for slides -->
                            <div class="carousel-inner" role="listbox">
                                <div class="item active">
                                    <div class="container">
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <div class="port_item xs-m-top-30">
                                                    <div class="port_img">
                                                        <img src="assets/images/work-img1.jpg" alt="" />
                                                        <div class="port_overlay text-center">
                                                            <a href="assets/images/work-img1.jpg" class="popup-img">+</a>
                                                        </div>
                                                    </div>
                                                    <div class="port_caption m-top-20">
                                                        <h5>������13(�̰���) �Ǹ��մϴ�</h5>
                                                        <h5><strong>800,000</strong></h4>
                                                        <h6>- ���ν� ���ﱸ ������</h6>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-3">
                                                <div class="port_item xs-m-top-30">
                                                    <div class="port_img">
                                                        <img src="assets/images/work-img2.jpg" alt="" />
                                                        <div class="port_overlay text-center">
                                                            <a href="assets/images/work-img2.jpg" class="popup-img">+</a>
                                                        </div>
                                                    </div>
                                                    <div class="port_caption m-top-20">
                                                        <h5>���������� �Ⱦƿ�</h5>
                                                        <h5><strong>100,000</strong></h4>
                                                        <h6>- �뱸 ���� �ɼ���</h6>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-3">
                                                <div class="port_item xs-m-top-30">
                                                    <div class="port_img">
                                                        <img src="assets/images/work-img3.jpg" alt="" />
                                                        <div class="port_overlay text-center">
                                                            <a href="assets/images/work-img3.jpg" class="popup-img">+</a>
                                                        </div>
                                                    </div>
                                                    <div class="port_caption m-top-20">
                                                        <h5>���̺�� ���� �Ǹ��մϴ�</h5>
                                                        <h5><strong>70,000</strong></h4>
                                                        <h6>- ���ν� ���ﱸ �Ű���</h6>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-3">
                                                <div class="port_item xs-m-top-30">
                                                    <div class="port_img">
                                                        <img src="assets/images/work-img4.jpg" alt="" />
                                                        <div class="port_overlay text-center">
                                                            <a href="assets/images/work-img4.jpg" class="popup-img">+</a>
                                                        </div>
                                                    </div>
                                                    <div class="port_caption m-top-20">
                                                        <h5>������13 ȭ��Ʈ 128GB</h5>
                                                        <h5><strong>640,000</strong></h4>
                                                        <h6>- ������ ���뱸 ���뵿</h6>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                
                                <div class="item">
                                    <div class="container">
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <div class="port_item xs-m-top-30">
                                                    <div class="port_img">
                                                        <img src="assets/images/work-img5.jpg" alt="" />
                                                        <div class="port_overlay text-center">
                                                            <a href="assets/images/work-img5.jpg" class="popup-img">+</a>
                                                        </div>
                                                    </div>
                                                    <div class="port_caption m-top-20">
                                                        <h5>�ý�4 �����մϴ�</h5>
                                                        <h5><strong>1</strong></h4>
                                                        <h6>- �λ� ������ ���ȵ�</h6>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-3">
                                                <div class="port_item xs-m-top-30">
                                                    <div class="port_img">
                                                        <img src="assets/images/work-img6.jpg" alt="" />
                                                        <div class="port_overlay text-center">
                                                            <a href="assets/images/work-img6.jpg" class="popup-img">+</a>
                                                        </div>
                                                    </div>
                                                    <div class="port_caption m-top-20">
                                                        <h5>�̻� �����ֽ� ��</h5>
                                                        <h5><strong>30,000</strong></h4>
                                                        <h6>- ���� ������ ��ȭ��</h6>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-3">
                                                <div class="port_item xs-m-top-30">
                                                    <div class="port_img">
                                                        <img src="assets/images/work-img7.jpg" alt="" />
                                                        <div class="port_overlay text-center">
                                                            <a href="assets/images/work-img7.jpg" class="popup-img">+</a>
                                                        </div>
                                                    </div>
                                                    <div class="port_caption m-top-20">
                                                        <h5>������Ϸ��� ��Ʈ</h5>
                                                        <h5><strong>120,000</strong></h4>
                                                        <h6>- ���� ��õ�� ��</h6>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-3">
                                                <div class="port_item xs-m-top-30">
                                                    <div class="port_img">
                                                        <img src="assets/images/work-img8.jpg" alt="" />
                                                        <div class="port_overlay text-center">
                                                            <a href="assets/images/work-img8.jpg" class="popup-img">+</a>
                                                        </div>
                                                    </div>
                                                    <div class="port_caption m-top-20">
                                                        <h5>��ä �ƴϰ� ��ä</h5>
                                                        <h5><strong>70,000</strong></h4>
                                                        <h6>- ���ν� ���ﱸ �󰥵�</h6>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>

                            <!-- Controls -->
                            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                                <i class="fa fa-angle-left" aria-hidden="true"></i>
                                <span class="sr-only">Previous</span>
                            </a>

                            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                                <i class="fa fa-angle-right" aria-hidden="true"></i>
                                <span class="sr-only">Next</span>
                            </a>
                        </div>
                    </div><!-- End off row -->
                </div><!-- End off container -->
            </section><!-- End off Product section -->



            <!--Test section-->
            <section id="test" class="test bg-grey roomy-60 fix">
                <div class="container">
                    <div class="row">                        
                        <div class="main_test fix">

                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="head_title text-center fix">
                                    <h2 class="text-uppercase">�̴��� �α� �̿���</h2>
                                    <h5>���� ��õ�� ���� ����</h5>
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="test_item fix">
                                    <div class="item_img">
                                        <img class="img-circle" src="assets/images/test-img1.png" alt="" />
                                        <i class="fa fa-quote-left"></i>
                                    </div>

                                    <div class="item_text">
                                        <h5>������</h5>
                                        <h6>���ν� ���ﱸ ������</h6>

                                        <p>���λ�� ���л��Դϴ�. ��������, ���ڱ�� �� �ַ� �ŷ��մϴ�.</p>
                                    </div>
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="test_item fix sm-m-top-30">
                                    <div class="item_img">
                                        <img class="img-circle" src="assets/images/test-img1.png" alt="" />
                                        <i class="fa fa-quote-left"></i>
                                    </div>

                                    <div class="item_text">
                                        <h5>���ȯ</h5>
                                        <h6>����Ư���� ������ �ֹ���</h6>

                                        <p>�ֹ��� ��� ���ػ��Դϴ�. �ڰ��� ����, ��ⱸ, ���ڱ�⸦ �ַ� �ŷ��մϴ�.</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section><!-- End off test section -->
