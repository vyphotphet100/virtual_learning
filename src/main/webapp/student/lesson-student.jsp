<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Virtual learning | Class - student</title>
    <link rel="stylesheet" type="text/css" href="../resources/styles/bootstrap4/bootstrap.min.css">
    <link href="../resources/plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="../resources/plugins/OwlCarousel2-2.2.1/owl.carousel.css">
    <link rel="stylesheet" type="text/css" href="../resources/plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
    <link rel="stylesheet" type="text/css" href="../resources/plugins/OwlCarousel2-2.2.1/animate.css">
    <link rel="stylesheet" type="text/css" href="../resources/styles/main_styles.css">
    <link rel="stylesheet" type="text/css" href="../resources/styles/responsive.css">
    <link rel="stylesheet" type="text/css" href="../resources/styles/main.css">

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

<div class="probootstrap-page-wrapper" id="lession2">
    <!-- Fixed navbar -->
    <section class="probootstrap-section probootstrap-section-colored">
        <div class="container">
            <div class="row">
                <div class="col-md-12 text-left section-heading probootstrap-animate">
                    <h1>${clazz.name}</h1>
                </div>
            </div>
        </div>
    </section>

    <section class="probootstrap-section style">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="probootstrap-flex-block">
                        <div class="probootstrap-text probootstrap-animate">
                            <div class="text-uppercase probootstrap-uppercase">Featured Course</div>

                            <div class="vertical-menu">
                                <c:forEach items="${clazz.lessons}" var="subLesson">
                                    <c:if test="${subLesson.id == lesson.id}">
                                        <a href="/student/lesson?id=${subLesson.id}"
                                           class="active">${subLesson.title}</a>
                                    </c:if>
                                    <c:if test="${subLesson.id != lesson.id}">
                                        <a href="/student/lesson?id=${subLesson.id}">${subLesson.title}</a>
                                    </c:if>
                                </c:forEach>
                            </div>

                            <p><a href="#" class="btn btn-primary">Quizzes</a></p>
                        </div>

                        <div class="probootstrap-image probootstrap-animate"
                             style="background-image: url(../resources/images/img/slider_3.jpg)">
                            <a href="${lesson.video}" class="btn-video popup-vimeo"><i
                                    class="fa fa-play"></i></a>
                        </div>
                        <div class="description">
                            <h1 class=" tt">Description</h1>
                            <p class="des">${lesson.description}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
<!-- END wrapper -->
</body>
<br>
<!-- Footer -->
<footer class="footer">
    <%@include file="/common/footer.jsp" %>
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