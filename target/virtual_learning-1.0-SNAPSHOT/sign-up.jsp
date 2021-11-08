<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Virtual learning | Sign up</title>
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
<body style="background-color: #dacece;">

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <form class="login100-form validate-form" id="edit-form-position" method="post">
					<span class="login100-form-title p-b-43">
						Sign Up
                       		<p style="color:black ;">Virtual<span style="color:#14BDEE;">Learning</span></p>
					</span>
                <c:if test="${not empty responseEntity && responseEntity.httpStatus == 'ERROR'}">
                    <div class="alert alert-danger" role="alert">
                        <c:out value="${responseEntity.message}"/>
                    </div>
                </c:if>
                <c:if test="${not empty param['message']}">
                    <div class="alert alert-success" role="alert">
                        <c:out value="${param['message']}"/>
                    </div>
                </c:if>

                <div class="wrap-input100 validate-input" id="username" data-validate="Username is required">
                    <input class="input100" type="text" name="username">
                    <span class="focus-input100"></span>
                    <span class="label-input100">Username</span>
                </div>

                <div class="wrap-input100 validate-input" id="email"
                     data-validate="Valid email is required: ex@abc.xyz">
                    <input class="input100" type="email" name="email">
                    <span class="focus-input100"></span>
                    <span class="label-input100">Email</span>
                </div>
                <div class="wrap-input100 validate-input" id="fullName" data-validate="Full-name is required">
                    <input class="input100" type="text" name="fullName">
                    <span class="focus-input100"></span>
                    <span class="label-input100">Full-name</span>
                </div>

                <div class="wrap-input100 validate-input" id="birthday" data-validate="Valid birthday is required">
                    <input class="input100" type="date" name="birthday">
                    <span class="focus-input100"></span>
                    <span class="label-input100">Birthday</span>
                </div>

                <div class="wrap-input100 validate-input" id="phone" data-validate="Phone number is required">
                    <input class="input100" type="tel" name="phone">
                    <span class="focus-input100"></span>
                    <span class="label-input100">Phone number</span>
                </div>

                <div class="wrap-input100 validate-input" id="password" data-validate="Password is required">
                    <input class="input100" id="password-field" type="password" name="password">
                    <span class="focus-input100"></span>
                    <span class="label-input100">Password</span>
                </div>

                <div class="wrap-input100 validate-input" id="retype-password"
                     data-validate="Re-type password is required">
                    <input class="input100" id="retype-password-field" type="password" name="retypePassword">
                    <span class="focus-input100"></span>
                    <span class="label-input100">Re-type password</span>
                </div>

                <div class="flex-sb-m w-full p-t-3 p-b-32">
                    <h5 class="role-text">What do you want to be?</h5>
                    <input type="radio" id="ckb2" name="roleId" value="1">
                    <span><h5 class="role-text">Teacher</h5></span>
                    <input type="radio" id="ckb3" name="roleId" value="2">
                    <span><h5 class="role-text">Student</h5></span>
                </div>
                <div class="container-login100-form-btn">
                    <button class="login100-form-btn">
                        Create an account
                    </button>
                </div>
                <span><br></span>
                <div>
                    <p class="text-center">You have an account already? <a href="#">Login</a></p>
                    <p class="text-center"><a href="#">Back to homepage</a></p>
                </div>
            </form>
            <div class="login100-more" style="background-image: url('resources/images/background_login_signup.png');">
            </div>
        </div>
    </div>
</div>


</body>
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
