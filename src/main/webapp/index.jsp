<%@include file="/common/taglib.jsp" %>
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
    <link rel="stylesheet" type="text/css" href="resources/styles/index.css">
    <link rel="stylesheet" type="text/css" href="resources/styles/main_1.css">
    <link rel="stylesheet" type="text/css" href="resources/styles/style.min.css">
    <link rel="stylesheet" type="text/css" href="resources/styles/styles-merged.css">
</head>
<body>
<div class="super_container">
    <!-- Header -->
    <header class="header">
        <%@include file="/common/header.jsp" %>
    </header>
</div>

<!-- Popular Courses -->

<div class="courses">
    <div class="section_background parallax-window" data-parallax="scroll"
         data-image-src="resources/images/courses_background.jpg" data-speed="0.8"></div>
    <div class="container" id="popular-courses">
        <div class="row">
            <div class="col">
                <div class="section_title_container text-center">
                    <h2 class="section_title">Popular Online Courses</h2>
                    <div class="section_subtitle"><p>Some courses which you should not miss it</p></div>
                </div>
            </div>
        </div>


        <c:if test="${empty param['viewAll'] || empty param['keyword'] || param['viewAll'] == '' || param['viewAll'] == 'all'}">
            <c:forEach items="${subjectEntities}" var="subjectEntity" varStatus="loop">
                <div class="topic-more">
                    <a href="${currentUrl}?viewAll=${subjectEntity.id}"><h4 class="topic">${subjectEntity.name}</h4></a>
                    <a href="${currentUrl}?viewAll=${subjectEntity.id}"><h5 class="more">More</h5></a>
                </div>
                <div class="row courses_row">

                    <c:forEach items="${subjectEntity.classes}" var="classEntityBySubjectId" varStatus="order">
                        <!-- Class -->
                        <div class="col-lg-4 course_col">
                            <div class="course">
                                <div class="course_image"><img
                                        class="course_img"
                                        src="https://blog.commlabindia.com/wp-content/uploads/2018/06/elearning-to-achieve-business-goals-1.png"
                                        alt=""></div>
                                <div class="course_body">
                                    <h3 class="course_title"><a href="##" onclick="classDetail(${subjectEntity.classes[subjectEntity.classes.size()-order.index-1].id});">${subjectEntity.classes[subjectEntity.classes.size()-order.index-1].name}</a></h3>
                                    <div class="course_teacher" id="class-teacher-${subjectEntity.classes[subjectEntity.classes.size()-order.index-1].id}">
                                        Lecturer: ${subjectEntity.classes[subjectEntity.classes.size()-order.index-1].authorUser.fullName}
                                    </div>
                                    <button type="button" class="button-readmore" onclick="classDetail(${subjectEntity.classes[subjectEntity.classes.size()-order.index-1].id});" style="">
                                        Readmore
                                    </button>
                                </div>
                                <div class="course_footer">
                                    <div class="course_footer_content d-flex flex-row align-items-center justify-content-start">
                                        <div class="course_info">
                                            <i class="fa fa-graduation-cap" aria-hidden="true"></i>
                                            <span>${subjectEntity.classes[subjectEntity.classes.size()-order.index-1].joinedUser.size()} student(s)</span>
                                        </div>
                                        <a class="course_price ml-auto" href="##" onclick="openModal(${subjectEntity.classes[subjectEntity.classes.size()-order.index-1].id});">Join</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <br>
                    </c:forEach>
                </div>
            </c:forEach>
            <c:if test="${param['viewAll'] != 'all'}">
                <div class="row">
                    <div class="col">
                        <div class="courses_button trans_200"><a href="${currentUrl}?viewAll=all">view all courses</a></div>
                    </div>
                </div>
            </c:if>

        </c:if>

        <c:if test="${not empty param['viewAll']}">
            <div class="topic-more">
                <a><h4 class="topic">${subjectEntity.name}</h4></a>
            </div>
            <div class="row courses_row">
                <c:forEach items="${subjectEntity.classes}" var="classEntityBySubjectId" varStatus="order">
                    <!-- Class -->
                    <div class="col-lg-4 course_col">
                        <div class="course">
                            <div class="course_image"><img
                                    class="course_img"
                                    src="https://blog.commlabindia.com/wp-content/uploads/2018/06/elearning-to-achieve-business-goals-1.png"
                                    alt=""></div>
                            <div class="course_body">
                                <h3 class="course_title"><a href="##" onclick="classDetail(${subjectEntity.classes[subjectEntity.classes.size()-order.index-1].id});">${subjectEntity.classes[subjectEntity.classes.size()-order.index-1].name}</a></h3>
                                <div class="course_teacher" id="class-teacher-${subjectEntity.classes[subjectEntity.classes.size()-order.index-1].id}">
                                    Lecturer: ${subjectEntity.classes[subjectEntity.classes.size()-order.index-1].authorUser.fullName}</div>
                                <button type="button" class="button-readmore" onclick="classDetail(${subjectEntity.classes[subjectEntity.classes.size()-order.index-1].id});" style="">
                                    Readmore
                                </button>
                            </div>
                            <div class="course_footer">
                                <div class="course_footer_content d-flex flex-row align-items-center justify-content-start">
                                    <div class="course_info">
                                        <i class="fa fa-graduation-cap" aria-hidden="true"></i>
                                        <span>${subjectEntity.classes[subjectEntity.classes.size()-order.index-1].joinedUser.size()} student(s)</span>
                                    </div>
                                    <a class="course_price ml-auto" href="##" onclick="openModal(${subjectEntity.classes[subjectEntity.classes.size()-order.index-1].id});">Join</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <br>
                </c:forEach>
            </div>
        </c:if>

        <c:if test="${not empty param['keyword']}">
            <div class="row courses_row">
                <c:forEach items="${classes}" var="clazz">
                    <!-- Class -->
                    <div class="col-lg-4 course_col">
                        <div class="course">
                            <div class="course_image"><img
                                    class="course_img"
                                    src="https://blog.commlabindia.com/wp-content/uploads/2018/06/elearning-to-achieve-business-goals-1.png"
                                    alt=""></div>
                            <div class="course_body">
                                <h3 class="course_title"><a href="##" onclick="classDetail(${clazz.id});">${clazz.name}</a></h3>
                                <div class="course_teacher" id="class-teacher-${clazz.id}">
                                    Lecturer: ${clazz.authorUser.fullName}</div>
                                <button type="button" class="button-readmore" onclick="classDetail(${clazz.id});" style="">
                                    Readmore
                                </button>
                            </div>
                            <div class="course_footer">
                                <div class="course_footer_content d-flex flex-row align-items-center justify-content-start">
                                    <div class="course_info">
                                        <i class="fa fa-graduation-cap" aria-hidden="true"></i>
                                        <span>${clazz.joinedUser.size()} student(s)</span>
                                    </div>
                                    <a class="course_price ml-auto" href="##" onclick="openModal(${clazz.id});">Join</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <br>
                </c:forEach>
            </div>
        </c:if>

    </div>
</div>
<!-- Modal - class detail-->
<div class="modal fade" id="readmore" tabindex="-1" role="dialog" aria-labelledby="questionTitle" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h1> Introduce</h1>
            </div>
            <div class="modal-body">

                <h3><p id="class-detail-modal-teacher-name">Teacher: Mr Tuong</p></h3>
                <h3 id="class-detail-modal-class-name">Class name: Sololearn</h3>
                <h3>Describe:</h3>
                <p id="class-detail-modal-description">Sololearn is a 6-part Java programming language training program with 65 lessons, covering topics such as loops and conditions, arrays, classes. objects, exceptions, lists, themes, and files.</p>
            </div>
            <div class="modal-footer">
                <button id="class-detail-modal-join" type="button" class="btn btn-secondary">
                    <strong> Join class</strong>
                </button>

            </div>


        </div>
    </div>
</div>
<!--End modal-->

<!-- The Modal -->
<div id="myModal" class="modal">
    <!-- Modal content -->
    <div class="modal-content" id="ModalfitHight" style="height: 400px">
        <span class="close">&times;</span>
        <h3>Enter password of this class to join</h3>
        <div class="wrap-input100 validate-input" data-validate="Pasword is required">
            <input class="input100" type="password" id="password" value="">
            <span class="focus-input100"></span>
            <span class="label-input100">Password</span>
        </div>
        <input type="hidden" id="class-to-join" value=""/>
        <div class="container-login100-form-btn">
            <input type="submit" class="login100-form-btn" onclick="joinClass();" value="Join"/>
        </div>
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
            document.getElementsByClassName('course_img')[i].src = 'resources/images/course_' + randomNumber + '.jpg';
        }
    }
    getRandomImage();
</script>

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
<script src="resources/js/index.js"></script>
</html>