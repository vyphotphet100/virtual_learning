<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Virtual learning | Edit class</title>
    <link rel="stylesheet" type="text/css" href="../resources/styles/bootstrap4/bootstrap.min.css">
    <link href="../resources/plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="../resources/plugins/OwlCarousel2-2.2.1/owl.carousel.css">
    <link rel="stylesheet" type="text/css" href="../resources/plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
    <link rel="stylesheet" type="text/css" href="../resources/plugins/OwlCarousel2-2.2.1/animate.css">
    <link rel="stylesheet" type="text/css" href="../resources/styles/main_styles.css">
    <link rel="stylesheet" type="text/css" href="../resources/styles/responsive.css">

    <link rel="stylesheet" type="text/css" href="../resources/styles/main.css">
    <link rel="stylesheet" type="text/css" href="../resources/styles/util.css">
	<link rel="stylesheet" type="text/css" href="../resources/styles/main_1.css">
    <link rel="stylesheet" type="text/css" href="../resources/styles/style.min.css">
    <link rel="stylesheet" type="text/css" href="resources/styles-merged.css">
    
</head>

<body>
    <div class="super_container">

        <!-- Header -->
    
        <header class="header">
                
            <!-- Top Bar -->
            <div class="top_bar">
                <div class="top_bar_container">
                    <div class="container">
                        <div class="row">
                            <div class="col">
                                <div class="top_bar_content d-flex flex-row align-items-center justify-content-start">
                                    <ul class="top_bar_contact_list">
                                        <li><div class="question">Have any questions?</div></li>
                                        <li>
                                            <i class="fa fa-phone" aria-hidden="true"></i>
                                            <div>0964-088-473</div>
                                        </li>
                                        <li>
                                            <i class="fa fa-envelope-o" aria-hidden="true"></i>
                                            <div>19110065@student.hcmute.edu.vn</div>
                                        </li>
                                    </ul>
                                    <div class="top_bar_login ml-auto">
                                        <div class="login_button"><a href="#" class="Login">Login</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>				
            </div>

                <!-- Header Content -->
		    <div class="header_container">
			    <div class="container">
				    <div class="row">
				    	<div class="col">
					    	<div class="header_content d-flex flex-row align-items-center justify-content-start">
						    	<div class="logo_container">
							    	<a href="#">
							    		<div class="logo_text">Virtual<span>Learning</span></div>
							    	</a>
						    	</div>
						    	<nav class="main_nav_contaner ml-auto">
							    	<ul class="main_nav">
							    		<li><a href="#">Home</a></li>
								    	<li><a href="#">My classes</a></li>
									    <li><a href="#">Contact</a></li>
								    </ul>
								    <div class="search_button"><i class="fa fa-search" aria-hidden="true"></i></div>

							    	<!-- Hamburger -->

								    <div class="shopping_cart"><i><a href="#" class="fa fa-user-circle-o"></a></i></div>
								    <div class="hamburger menu_mm">
								    	<i class="fa fa-bars menu_mm" aria-hidden="true"></i>
								    </div>
						    	</nav>

						    </div>
				    	</div>
				    </div>
			    </div>
		    </div>

            <!-- Header Search Panel -->
		    <div class="header_search_container">
			    <div class="container">
				    <div class="row">
					    <div class="col">
					    	<div class="header_search_content d-flex flex-row align-items-center justify-content-end">
							    <form action="#" class="header_search_form">
							    	<input type="search" class="search_input" placeholder="Search" required="required">
							    	<button class="header_search_button d-flex flex-column align-items-center justify-content-center">
									    <i class="fa fa-search" aria-hidden="true"></i>
								    </button>
							    </form>
						    </div>
					    </div>
				    </div>
			    </div>			
	    	</div>			
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
				    <li class="menu_mm"><a href="#">Home</a></li>
				    <li class="menu_mm"><a href="#">My classes</a></li>
			     	<li class="menu_mm"><a href="#">Contact</a></li>
			    </ul>
		    </nav>
	    </div>   
    </div>

    <div class="courses">
        <!--Background-->
        <div class="section_background parallax-window" data-parallax="scroll" data-image-src="resources/images/courses_background.jpg" data-speed="0.8"></div>
        <div class="topic-of-page">
            <h3 class="h">Edit Class</h3>
        </div>

        <!--Form add class-->
        <form class="login100-form validate-form edit-form">
            <span class="login100-form-title p-b-43">
                <div class="text-center">
                    <h1>Editing class form</h1>
                    <p>This is the section for the initial setting up for your class</p>   
                </div>
            </span>
            
            
            <div class="wrap-input100 validate-input" data-validate = "Name of class is required">
                <input class="input100" type="text" name="name">
                <span class="focus-input100"></span>
                <span class="label-input100">Name of class</span>
            </div>
            
            <div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
                <input class="input100" type="text" name="text">
                <span class="focus-input100"></span>
                <span class="label-input100">Name of subject</span>
            </div>
            <div class="wrap-input100 validate-input" data-validate = "Full-name is required">
                <input class="input100" type="text" name="text">
                <span class="focus-input100"></span>
                <span class="label-input100">Description</span>
            </div>

            <div class="wrap-input100 validate-input" data-validate="Password is required">
                <input class="input100" id="password-field" type="text" name="pass">
                <span class="focus-input100"></span>
                <span class="label-input100">Password</span>
            </div>

            <div class="wrap-input100 validate-input" data-validate="Re-tye password is required">
                <input class="input100" id="password-field" type="text" name="pass">
                <span class="focus-input100"></span>
                <span class="label-input100">Re-type Password</span>
            </div>
        </form>

        <!--join button-->
        <div class="text-center">
            <a href="#" class="a-join-button">
                <button class="join-button">
                    <b>Apply</b>
                </button>
            </a>
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

</footer>
    
    <script src="../resources/js/jquery-3.2.1.min.js"></script>
    <script src="../resources/styles/bootstrap4/popper.js"></script>
    <script src="../resources/styles/bootstrap4/bootstrap.min.js"></script>
    <script src="../resources/plugins/greensock/TweenMax.min.js"></script>
    <script src="../resources/plugins/greensock/TimelineMax.min.js"></script>
    <script src="../resources/plugins/scrollmagic/ScrollMagic.min.js"></script>
    <script src="../resources/plugins/greensock/animation.gsap.min.js"></script>
    <script src="../resources/plugins/greensock/ScrollToPlugin.min.js"></script>
    <script src="../resources/plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
    <script src="../resources/plugins/easing/easing.js"></script>
    <script src="../resources/plugins/parallax-js-master/parallax.min.js"></script>

    <script src="../resources/js/custom.js"></script>
    <script src="../resources/js/main.js"></script>
    <script src="../resources/js/main.min.js"></script>
    <script src="../resources/js/scripts.min.js"></script>
</html>