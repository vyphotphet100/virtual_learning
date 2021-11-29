<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Virtual learning | My class</title>
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
    <c:forEach items="${classes}" var="clazz">
        <div class="container my-class">
            <!--Course-->
            <a class="class-topic-description">
                <div class="course edit-course" onclick="window.location.href='#'">
                    <div class="course_image"><img
                            class="course_img"
                            src="https://blog.commlabindia.com/wp-content/uploads/2018/06/elearning-to-achieve-business-goals-1.png"
                            alt=""></div>
                    <div class="course_body">
                        <h3 class="course_title"><a href="/teacher/lesson?id=${clazz.lessons[0].id}">${clazz.name}</a></h3>
                        <div class="course_teacher">${clazz.authorUser.fullName}</div>
                        <div class="course_text">
                            <p>${clazz.description}</p>
                        </div>
                    </div>
                    <div class="course_footer">
                        <div class="course_footer_content d-flex flex-row align-items-center justify-content-start">
                            <div class="course_info">
                                <i class="fa fa-graduation-cap" aria-hidden="true"></i>
                                <span>${clazz.joinedUser.size()} student(s)</span>
                            </div>
                        </div>
                    </div>
                </div>
            </a>

            <div class="edit-delete">
                <button class="join-button edit-button" onclick="window.location.href='/teacher/edit-class?id='+ ${clazz.id}">Edit</button>
                <button onclick="deleteClass(${clazz.id})" class="join-button edit-button">Delete</button>
            </div>
        </div>
    </c:forEach>


    <!--Add button-->
    <div class="text-center" style="margin-top: 15% !important;">
        <a href="/teacher/add-class" class="a-join-button">
            <button class="join-button">
                <b>Add</b>
            </button>
        </a>
    </div>

</div>


</body>

<!-- Footer-->
<footer class="footer">
    <%@include file="/common/footer.jsp" %>
</footer>

<script>
    function getRandomImage() {
        var randomNumber = 1;
        for (var i=0; i<document.getElementsByClassName('course_img').length; i++) {
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
<script src="../resources/js/my-class-teacher.js"></script>
<script src="../resources/js/main.min.js"></script>
<script src="../resources/js/scripts.min.js"></script>
</html>