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


        <c:if test="${empty param['viewAll'] || param['viewAll'] == '' || param['viewAll'] == 'all'}">
            <c:forEach items="${subjectEntities}" var="subjectEntity">
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
                                        src="https://blog.commlabindia.com/wp-content/uploads/2018/06/elearning-to-achieve-business-goals-1.png"
                                        alt=""></div>
                                <div class="course_body">
                                    <h3 class="course_title"><a href="#">${classEntityBySubjectId.name}</a></h3>
                                    <div class="course_teacher">
                                        Lecturer: ${classEntityBySubjectId.authorUser.fullName}</div>
                                    <div class="course_text">
                                        <p>${classDtoBySubjectId.description}</p>
                                    </div>
                                </div>
                                <div class="course_footer">
                                    <div class="course_footer_content d-flex flex-row align-items-center justify-content-start">
                                        <div class="course_info">
                                            <i class="fa fa-graduation-cap" aria-hidden="true"></i>
                                            <span>${classEntityBySubjectId.joinedUser.size()} student(s)</span>
                                        </div>
                                        <a class="course_price ml-auto" href="#">Join</a>
                                    </div>
                                </div>
                            </div>
                        </div>
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
                                    src="https://blog.commlabindia.com/wp-content/uploads/2018/06/elearning-to-achieve-business-goals-1.png"
                                    alt=""></div>
                            <div class="course_body">
                                <h3 class="course_title"><a href="#">${classEntityBySubjectId.name}</a></h3>
                                <div class="course_teacher">
                                    Lecturer: ${classEntityBySubjectId.authorUser.fullName}</div>
                                <div class="course_text">
                                    <p>${classDtoBySubjectId.description}</p>
                                </div>
                            </div>
                            <div class="course_footer">
                                <div class="course_footer_content d-flex flex-row align-items-center justify-content-start">
                                    <div class="course_info">
                                        <i class="fa fa-graduation-cap" aria-hidden="true"></i>
                                        <span>${classEntityBySubjectId.joinedUser.size()} student(s)</span>
                                    </div>
                                    <a class="course_price ml-auto" href="#">Join</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:if>

    </div>
</div>
</body>

<div class="newsletter">
    <div class="newsletter_background parallax-window" data-parallax="scroll"
         data-image-src="resources/images/newsletter.jpg" data-speed="0.8"></div>
    <div class="container">
        <div class="row">
            <div class="col">
                <div class="newsletter_container d-flex flex-lg-row flex-column align-items-center justify-content-start">

                    <!-- Newsletter Content -->
                    <div class="newsletter_content text-lg-left text-center">
                        <div class="newsletter_title">sign up for news and offers</div>
                        <div class="newsletter_subtitle">Subcribe to lastest smartphones news & great deals we offer
                        </div>
                    </div>

                    <!-- Newsletter Form -->
                    <div class="newsletter_form_container ml-lg-auto">
                        <form action="#" id="newsletter_form"
                              class="newsletter_form d-flex flex-row align-items-center justify-content-center">
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
    <%@include file="/common/footer.jsp" %>
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