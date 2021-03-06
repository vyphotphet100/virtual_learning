<!DOCTYPE html>
<%@include file="common/taglib.jsp" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Virtual learning | Verifying Account</title>
    <link rel="stylesheet" type="text/css" href="resources/styles/bootstrap4/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="resources/plugins/font-awesome-4.7.0/css/font-awesome.min.css">
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
    <div id="background-1">
        <div id="background-2">
        <p class="text">VIRTUAL LEARNING</p>
        </div>
        <div id="content">
            <h1>Welcome!</h1>
            <p>We're excited to have you get started. First, you need to confirm your account.
                Just type the code which we sent your email <strong>${verificationUser.email}</strong> a few minutes ago.
            </p>
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
            <form class="input-container" method="post">
                <label>Enter code</label>
                <input id="input-code" type="text" name="verificationCode"><br>
                <button class="verify-btn">Confirm account</button>
            </form>

            <p style="margin-top: 2%;">If that doesn't work, please click the button below to sent the code again.</p>
            <form class="input-container" method="post">
                <input type="hidden" name="verificationCode" value="resend"><br>
                <button class="verify-btn">Resend code</button>
            </form>

            <p>If you have any questions, just contact us by email below:</p>
            <p style="text-align: center;"><a style="color:#2BC9B9;">${hostEmail}</a></p>
            <p style="margin-top: 2%;">Cheers,</p>
            <p>Virtual learning</p>
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