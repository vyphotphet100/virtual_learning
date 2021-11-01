<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Virtual learning | Home page</title>
	<link rel="stylesheet" type="text/css" href="resources/styles/bootstrap4/bootstrap.min.css">
    <link href="resources/plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="resources/plugins/OwlCarousel2-2.2.1/owl.carousel.css">
    <link rel="stylesheet" type="text/css" href="resources/plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
    <link rel="stylesheet" type="text/css" href="resources/plugins/OwlCarousel2-2.2.1/animate.css">
    <link rel="stylesheet" type="text/css" href="resources/styles/main_styles.css">
    <link rel="stylesheet" type="text/css" href="resources/styles/responsive.css">

	<link rel="stylesheet" type="text/css" href="resources/styles/main.css">
    <link rel="stylesheet" type="text/css" href="resources/styles/util.css">
	<link rel="stylesheet" type="text/css" href="resources/styles/main_1.css">
    <link rel="stylesheet" type="text/css" href="resources/styles/style.min.css">
    <link rel="stylesheet" type="text/css" href="resources/styles/styles-merged.css">
</head>
<body>
    <div class="super_container">
<%--		Remember user if user requires --%>
		<c:if test="${param['rememberMe'] == 'yes'}">

		</c:if>

        <!-- Header -->
    
        <header class="header">
			<%@include file="/common/header.jsp"%>
            <!-- Top Bar -->
<%--            <div class="top_bar">--%>
<%--                <div class="top_bar_container">--%>
<%--                    <div class="container">--%>
<%--                        <div class="row">--%>
<%--                            <div class="col">--%>
<%--                                <div class="top_bar_content d-flex flex-row align-items-center justify-content-start">--%>
<%--                                    <ul class="top_bar_contact_list">--%>
<%--                                        <li><div class="question">Have any questions?</div></li>--%>
<%--                                        <li>--%>
<%--                                            <i class="fa fa-phone" aria-hidden="true"></i>--%>
<%--                                            <div>0964-088-473</div>--%>
<%--                                        </li>--%>
<%--                                        <li>--%>
<%--                                            <i class="fa fa-envelope-o" aria-hidden="true"></i>--%>
<%--                                            <div>19110065@student.hcmute.edu.vn</div>--%>
<%--                                        </li>--%>
<%--                                    </ul>--%>
<%--                                    <div class="top_bar_login ml-auto">--%>
<%--                                        <div class="login_button"><a href="login.html" class="Login">Login</a></div>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>				--%>
<%--            </div>--%>

                <!-- Header Content -->
<%--		    <div class="header_container">--%>
<%--			    <div class="container">--%>
<%--				    <div class="row">--%>
<%--				    	<div class="col">--%>
<%--					    	<div class="header_content d-flex flex-row align-items-center justify-content-start">--%>
<%--						    	<div class="logo_container">--%>
<%--							    	<a href="#">--%>
<%--							    		<div class="logo_text">Virtual<span>Learning</span></div>--%>
<%--							    	</a>--%>
<%--						    	</div>--%>
<%--						    	<nav class="main_nav_contaner ml-auto">--%>
<%--							    	<ul class="main_nav">--%>
<%--							    		<li class="active"><a href="index.html">Home</a></li>--%>
<%--								    	<li><a href="MyClass.html">My classes</a></li>--%>
<%--									    <li><a href="contact.html">Contact</a></li>--%>
<%--								    </ul>--%>
<%--								    <div class="search_button"><i class="fa fa-search" aria-hidden="true"></i></div>--%>

<%--							    	<!-- Hamburger -->--%>

<%--								    <div class="shopping_cart"><i><a href="profile.html" class="fa fa-user-circle-o"></a></i></div>--%>
<%--								    <div class="hamburger menu_mm">--%>
<%--								    	<i class="fa fa-bars menu_mm" aria-hidden="true"></i>--%>
<%--								    </div>--%>
<%--						    	</nav>--%>

<%--						    </div>--%>
<%--				    	</div>--%>
<%--				    </div>--%>
<%--			    </div>--%>
<%--		    </div>--%>

            <!-- Header Search Panel -->
<%--		    <div class="header_search_container">--%>
<%--			    <div class="container">--%>
<%--				    <div class="row">--%>
<%--					    <div class="col">--%>
<%--					    	<div class="header_search_content d-flex flex-row align-items-center justify-content-end">--%>
<%--							    <form action="#" class="header_search_form">--%>
<%--							    	<input type="search" class="search_input" placeholder="Search" required="required">--%>
<%--							    	<button class="header_search_button d-flex flex-column align-items-center justify-content-center">--%>
<%--									    <i class="fa fa-search" aria-hidden="true"></i>--%>
<%--								    </button>--%>
<%--							    </form>--%>
<%--						    </div>--%>
<%--					    </div>--%>
<%--				    </div>--%>
<%--			    </div>			--%>
<%--	    	</div>			--%>
	    </header>

	    <!-- Menu -->
	    <div class="menu d-flex flex-column align-items-end justify-content-start text-right menu_mm trans_400">
		    <div class="menu_close_container"><div class="menu_close"><div></div><div></div></div></div>
		    <div class="search">
			    <form action="#" class="header_search_form menu_mm">
				    <input type="search" class="search_input menu_mm" placeholder="Search" required="required">
				    <button class="header_search_button d-flex flex-column align-items-center justify-content-center menu_mm">
					    <i class="fa fa-search menu_mm" aria-hidden="true"></i>
			    	</button>
		    	</form>
		    </div>
		    <nav class="menu_nav">
		    	<ul class="menu_mm">
				    <li class="menu_mm"><a href="index.html">Home</a></li>
				    <li class="menu_mm"><a href="#">My classes</a></li>
			     	<li class="menu_mm"><a href="contact.html">Contact</a></li>
			    </ul>
		    </nav>
	    </div>   
    </div>
    
    <!-- Popular Courses -->

	<div class="courses">
		<div class="section_background parallax-window" data-parallax="scroll" data-image-src="resources/images/courses_background.jpg" data-speed="0.8"></div>
		<div class="container" id="popular-courses">
			<div class="row">
				<div class="col">
					<div class="section_title_container text-center">
						<h2 class="section_title">Popular Online Courses</h2>
						<div class="section_subtitle"><p>Some courses which you should not miss it</p></div>
					</div>
				</div>
			</div>
			<div class="topic-more">
				<a href="#"><h4 class="topic">Information technology</h4></a>
				<a href="#"><h5 class="more">More</h5></a>
			</div>
			<div class="row courses_row">
				
				<!-- Course -->
				<div class="col-lg-4 course_col">
					<div class="course">
						<div class="course_image"><img src="https://blog.commlabindia.com/wp-content/uploads/2018/06/elearning-to-achieve-business-goals-1.png" alt=""></div>
						<div class="course_body">
							<h3 class="course_title"><a href="ClassDetail.html">Software Training</a></h3>
							<div class="course_teacher">Mr. Hung Pham</div>
							<div class="course_text">
								<p>A best course that will support you understand deeply about software technology</p>
							</div>
						</div>
						<div class="course_footer">
							<div class="course_footer_content d-flex flex-row align-items-center justify-content-start">
								<div class="course_info">
									<i class="fa fa-graduation-cap" aria-hidden="true"></i>
									<span>20 Student</span>
								</div>
								<div class="course_info">
									<i class="fa fa-star" aria-hidden="true"></i>
									<span>4.5 Ratings</span>
								</div>
								<div class="course_price ml-auto">$130</div>
							</div>
						</div>
					</div>
				</div>

				<!-- Course -->
				<div class="col-lg-4 course_col">
					<div class="course">
						<div class="course_image"><img src="https://miro.medium.com/max/7872/1*ecU3mH6ajULJpcVFvLGcaQ.png" alt=""></div>
						<div class="course_body">
							<h3 class="course_title"><a href="course.html">Developing Mobile Apps</a></h3>
							<div class="course_teacher">Mr. Tuong Le</div>
							<div class="course_text">
								<p>After this course, you will be able to design your mobile apps by yoursefl</p>
							</div>
						</div>
						<div class="course_footer">
							<div class="course_footer_content d-flex flex-row align-items-center justify-content-start">
								<div class="course_info">
									<i class="fa fa-graduation-cap" aria-hidden="true"></i>
									<span>35 Student</span>
								</div>
								<div class="course_info">
									<i class="fa fa-star" aria-hidden="true"></i>
									<span>4.8 Ratings</span>
								</div>
								<div class="course_price ml-auto">Free</div>
							</div>
						</div>
					</div>
				</div>

				<!-- Course -->
				<div class="col-lg-4 course_col">
					<div class="course">
						<div class="course_image"><img src="https://bizflyportal.mediacdn.vn/thumb_wm/1000,100/bizflyportal/techblog/xay16332585384068.jpg" alt=""></div>
						<div class="course_body">
							<h3 class="course_title"><a href="course.html">Essential Networking</a></h3>
							<div class="course_teacher">Mr. Cao Vy</div>
							<div class="course_text">
								<p>Learn elementary networking concepts in less than 60 minutes</p>
							</div>
						</div>
						<div class="course_footer">
							<div class="course_footer_content d-flex flex-row align-items-center justify-content-start">
								<div class="course_info">
									<i class="fa fa-graduation-cap" aria-hidden="true"></i>
									<span>20 Student</span>
								</div>
								<div class="course_info">
									<i class="fa fa-star" aria-hidden="true"></i>
									<span>5 Ratings</span>
								</div>
								<div class="course_price ml-auto"><span>$320</span>$220</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="topic-more">
				<a href="#"><h4 class="topic">Name of topic</h4></a>
				<a href="#"><h5 class="more">More</h5></a>
			</div>
            <div class="row courses_row">
                <!-- Course -->
				<div class="col-lg-4 course_col">
					<div class="course">
						<div class="course_image"><img src="resources/images/course_3.jpg" alt=""></div>
						<div class="course_body">
							<h3 class="course_title"><a href="course.html">Starting a Startup</a></h3>
							<div class="course_teacher">Mr. Charles</div>
							<div class="course_text">
								<p>Lorem ipsum dolor sit amet, consectetur adipi elitsed do eiusmod tempor</p>
							</div>
						</div>
						<div class="course_footer">
							<div class="course_footer_content d-flex flex-row align-items-center justify-content-start">
								<div class="course_info">
									<i class="fa fa-graduation-cap" aria-hidden="true"></i>
									<span>20 Student</span>
								</div>
								<div class="course_info">
									<i class="fa fa-star" aria-hidden="true"></i>
									<span>5 Ratings</span>
								</div>
								<div class="course_price ml-auto"><span>$320</span>$220</div>
							</div>
						</div>
					</div>
				</div>

                <!-- Course -->
				<div class="col-lg-4 course_col">
					<div class="course">
						<div class="course_image"><img src="resources/images/course_3.jpg" alt=""></div>
						<div class="course_body">
							<h3 class="course_title"><a href="course.html">Starting a Startup</a></h3>
							<div class="course_teacher">Mr. Charles</div>
							<div class="course_text">
								<p>Lorem ipsum dolor sit amet, consectetur adipi elitsed do eiusmod tempor</p>
							</div>
						</div>
						<div class="course_footer">
							<div class="course_footer_content d-flex flex-row align-items-center justify-content-start">
								<div class="course_info">
									<i class="fa fa-graduation-cap" aria-hidden="true"></i>
									<span>20 Student</span>
								</div>
								<div class="course_info">
									<i class="fa fa-star" aria-hidden="true"></i>
									<span>5 Ratings</span>
								</div>
								<div class="course_price ml-auto"><span>$320</span>$220</div>
							</div>
						</div>
					</div>
				</div>

                <!-- Course -->
				<div class="col-lg-4 course_col">
					<div class="course">
						<div class="course_image"><img src="resources/images/course_3.jpg" alt=""></div>
						<div class="course_body">
							<h3 class="course_title"><a href="course.html">Starting a Startup</a></h3>
							<div class="course_teacher">Mr. Charles</div>
							<div class="course_text">
								<p>Lorem ipsum dolor sit amet, consectetur adipi elitsed do eiusmod tempor</p>
							</div>
						</div>
						<div class="course_footer">
							<div class="course_footer_content d-flex flex-row align-items-center justify-content-start">
								<div class="course_info">
									<i class="fa fa-graduation-cap" aria-hidden="true"></i>
									<span>20 Student</span>
								</div>
								<div class="course_info">
									<i class="fa fa-star" aria-hidden="true"></i>
									<span>5 Ratings</span>
								</div>
								<div class="course_price ml-auto"><span>$320</span>$220</div>
							</div>
						</div>
					</div>
				</div>

            </div>

			<div class="row">
				<div class="col">
					<div class="courses_button trans_200"><a href="#">view all courses</a></div>
				</div>
			</div>
		</div>
	</div>
</body>

<div class="newsletter">
	<div class="newsletter_background parallax-window" data-parallax="scroll" data-image-src="resources/images/newsletter.jpg" data-speed="0.8"></div>
	<div class="container">
		<div class="row">
			<div class="col">
				<div class="newsletter_container d-flex flex-lg-row flex-column align-items-center justify-content-start">

					<!-- Newsletter Content -->
					<div class="newsletter_content text-lg-left text-center">
						<div class="newsletter_title">sign up for news and offers</div>
						<div class="newsletter_subtitle">Subcribe to lastest smartphones news & great deals we offer</div>
					</div>

					<!-- Newsletter Form -->
					<div class="newsletter_form_container ml-lg-auto">
						<form action="#" id="newsletter_form" class="newsletter_form d-flex flex-row align-items-center justify-content-center">
							<input type="email" class="newsletter_input" placeholder="Your Email" required="required">
							<button type="submit" class="newsletter_button">subscribe</button>
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>

<!-- Footer-->
<footer class="footer">
	<%@include file="/common/footer.jsp"%>
<%--    <div class="footer_background" style="background-image:url(resources/images/footer_background.png)"></div>--%>
<%--    <div class="container">--%>
<%--        <div class="row footer_row">--%>
<%--            <div class="col">--%>
<%--                <div class="footer_content">--%>
<%--                    <div class="row">--%>

<%--                        <div class="col-lg-3 footer_col">--%>
<%--                --%>
<%--                            <!-- Footer About--> --%>
<%--                            <div class="footer_section footer_about">--%>
<%--                                <div class="footer_logo_container">--%>
<%--                                    <a href="#">--%>
<%--                                        <div class="footer_logo_text">Virtual<span>Learning</span></div>--%>
<%--                                    </a>--%>
<%--                                </div>--%>
<%--                                <div class="footer_about_text">--%>
<%--                                    <p>The place where you can put your trust</p>--%>
<%--                                </div>--%>
<%--                                <div class="footer_social">--%>
<%--                                    <ul>--%>
<%--                                        <li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>--%>
<%--                                        <li><a href="#"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>--%>
<%--                                        <li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>--%>
<%--                                        <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>--%>
<%--                                    </ul>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            --%>
<%--                        </div>--%>

<%--                        <div class="col-lg-3 footer_col">--%>
<%--                --%>
<%--                            <!-- Footer Contact--> --%>
<%--                            <div class="footer_section footer_contact">--%>
<%--                                <div class="footer_title">Contact Us</div>--%>
<%--                                <div class="footer_contact_info">--%>
<%--                                    <ul>--%>
<%--                                        <li>Email: Info.deercreative@gmail.com</li>--%>
<%--                                        <li>Phone:  +(88) 111 555 666</li>--%>
<%--                                        <li>Main base: 254 Dien Bien Phu, Binh Thanh District, Ho Chi Minh City, Viet Nam</li>--%>
<%--                                    </ul>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            --%>
<%--                        </div>--%>

<%--                        <div class="col-lg-3 footer_col">--%>
<%--                --%>
<%--                            <!-- Footer links--> --%>
<%--                            <div class="footer_section footer_links">--%>
<%--                                <div class="footer_title">Contact Us</div>--%>
<%--                                <div class="footer_links_container">--%>
<%--                                    <ul>--%>
<%--                                        <li><a href="index.html">Home</a></li>--%>
<%--                                        <li><a href="about.html">About</a></li>--%>
<%--                                        <li><a href="contact.html">Contact</a></li>--%>
<%--                                        <li><a href="#">Features</a></li>--%>
<%--                                        <li><a href="courses.html">Courses</a></li>--%>
<%--                                        <li><a href="#">Events</a></li>--%>
<%--                                        <li><a href="#">Gallery</a></li>--%>
<%--                                        <li><a href="#">FAQs</a></li>--%>
<%--                                    </ul>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            --%>
<%--                        </div>--%>

<%--                        <div class="col-lg-3 footer_col clearfix">--%>
<%--                --%>
<%--                            <!-- Footer links--> --%>
<%--                            <div class="footer_section footer_mobile">--%>
<%--                                <div class="footer_title">Mobile</div>--%>
<%--                                <div class="footer_mobile_content">--%>
<%--                                    <div class="footer_image"><a href="#"><img src="resources/images/mobile_1.png" alt=""></a></div>--%>
<%--                                    <div class="footer_image"><a href="#"><img src="resources/images/mobile_2.png" alt=""></a></div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            --%>
<%--                        </div>--%>

<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>

<%--        <div class="row copyright_row">--%>
<%--            <div class="col">--%>
<%--                <div class="copyright d-flex flex-lg-row flex-column align-items-center justify-content-start">--%>
<%--                    <div class="cr_text"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0.--> --%>
<%--Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | Virtual Learning</a>--%>
<%--<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0.--></div>--%>
<%--                    <div class="ml-lg-auto cr_links">--%>
<%--                        <ul class="cr_list">--%>
<%--                            <li><a href="#">Copyright notification</a></li>--%>
<%--                            <li><a href="#">Terms of Use</a></li>--%>
<%--                            <li><a href="#">Privacy Policy</a></li>--%>
<%--                        </ul>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
</footer>

<script src="resources/js/jquery-3.2.1.min.js"></script>
<script src="resources/styles/bootstrap4/popper.js"></script>
<script src="resources/styles/bootstrap4/bootstrap.min.js"></script>
<script src="resources/plugins/greensock/TweenMax.min.js"></script>
<script src="resources/plugins/greensock/TimelineMax.min.js"></script>
<script src="resources/plugins/scrollmagic/ScrollMagic.min.js"></script>
<script src="resources/plugins/greensock/animation.gsap.min.js"></script>
<script src="resources/plugins/greensock/ScrollToPlugin.min.js"></script>
<script src="resources/plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="resources/plugins/easing/easing.js"></script>
<script src="resources/plugins/parallax-js-master/parallax.min.js"></script>
<script src="common/app.js"></script>

<script src="resources/js/custom.js"></script>
<script src="resources/js/main.js"></script>
<script src="resources/js/main.min.js"></script>
<script src="resources/js/scripts.min.js"></script>
</html>