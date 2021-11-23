<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Virtual learning | My class - Students</title>
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
        <%@include file="/common/header.jsp" %>
    </header>
</div>

<div class="courses">
    <!--Background-->
    <div class="section_background parallax-window" data-parallax="scroll"
         data-image-src="../resources/images/courses_background.jpg" data-speed="0.8"></div>
    <div class=" probootstrap-search" id="probootstrap-search">
        <a href="#" class="probootstrap-close js-probootstrap-close"><i class="icon-cross"></i></a>
        <form action="#">
            <input type="search" name="s" id="search" placeholder="Search a keyword and hit enter...">
        </form>
    </div>

    <div id="lession2" class="probootstrap-page-wrapper">
        <!-- Fixed navbar -->
        <section class="probootstrap-section probootstrap-section-colored">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 text-left section-heading probootstrap-animate">
                        <h1>Courses</h1>
                    </div>
                </div>
            </div>
        </section>

        <section class="probootstrap-section">
            <div class="container">
                <div class="row">
                    <c:forEach items="${classes}" var="clazz">
                        <div class="col-md-6">
                            <div class="probootstrap-service-2 probootstrap-animate">
                                <div class="image">
                                    <div class="image-bg">
                                        <img class="course_img"
                                             src="../resources/images/img/img_sm_1.jpg"
                                             alt="Free Bootstrap Template by ProBootstrap.com">
                                    </div>
                                </div>
                                <div class="text">

                                    <h3>${clazz.name}</h3>
                                    <p>${clazz.description}</p>
                                    <p><a href="/student/lesson?id=${clazz.lessons[0].id}" class="btn btn-primary">Enroll
                                        now</a> <span class="enrolled-count">${clazz.joinedUser.size()} students enrolled</span>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </section>

        <section class="probootstrap-cta">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h2 class="probootstrap-animate" data-animate-effect="fadeInRight">Do you want to learn
                            more?</h2>
                        <a href="/home" role="button" class="btn btn-primary btn-lg btn-ghost probootstrap-animate"
                           data-animate-effect="fadeInLeft">Read more</a>
                    </div>
                </div>
            </div>
        </section>
    </div>
</div>


</body>

<!--footer-->
<footer class="footer">
    <%@include file="/common/footer.jsp" %>
</footer>

<script>
    function getRandomImage() {
        var randomNumber = 1;
        for (var i = 0; i < document.getElementsByClassName('course_img').length; i++) {
            var tmp = Math.floor(Math.random() * 10);
            while (tmp == 0 || tmp == randomNumber)
                tmp = Math.floor(Math.random() * 10);
            randomNumber = tmp;
            document.getElementsByClassName('course_img')[i].src = '/resources/images/course_' + randomNumber + '.jpg';
        }
    }

    getRandomImage();
</script>

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