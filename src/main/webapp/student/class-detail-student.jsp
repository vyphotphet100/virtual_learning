<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Virtual learning | Class detail</title>
    <link rel="stylesheet" type="text/css" href="../resources/styles/main.css">
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
    <link rel="stylesheet" type="text/css" href="../resources/styles/styles-merged.css">
</head>

<body>
    <div class="super_container">
        <!-- Header -->
        <header class="header">
			<%@include file="/common/header.jsp"%>
	    </header>
    </div>   

    <div class="courses">
         <!--Background-->
        <div class="section_background parallax-window" data-parallax="scroll" data-image-src="../resources/images/courses_background.jpg" data-speed="0.8"></div>
        <div class="topic-of-page">
            <h3 class="h">Class detail</h3>
        </div>
         <div class="text-center">
             <h1>${clazz.name}</h1></a>
             <p>${clazz.description}</p>
         </div>
         <div class="teacher-subject text-lg-right">
             <h4>Teacher:<a style="font-size: 18px;"> ${clazz.authorUser.fullName}</a></h4>
             <h4>Subject:<a style="font-size: 18px;" href="#"> ${clazz.subject.name}</a></h4>
         </div>
         <!--join button-->
         <div class="text-center">
             <a href="#" class="a-join-button">
                 <button class="join-button" onclick="window.location.href='#'">
                     <b>Join class</b>
                 </button>
             </a>
         </div>
    </div>
</body>

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