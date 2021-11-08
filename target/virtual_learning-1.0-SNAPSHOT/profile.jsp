<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Virtual learning | Profile</title>
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

<div class="courses">
    <!--Background-->
    <div class="section_background parallax-window" data-parallax="scroll"
         data-image-src="resources/images/courses_background.jpg" data-speed="0.8"></div>

    <div class="container rounded bg-white mt-5 mb-5">
        <div class="row">
            <div class="col-md-3 border-right">
                <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                    <img class="rounded-circle mt-5" src="resources/images/comment_2.jpg" width="90">
                    <span class="font-weight-bold">${sessionScope.USER_SESSION.fullName}</span>
                    <span class="text-black-50">${sessionScope.USER_SESSION.email}</span>
                    <span>${sessionScope.USER_SESSION.phone}</span>
                </div>
            </div>
            <form class="col-md-5 border-right" method="POST">
                <div class="p-3 py-5">
                    <div class="d-flex justify-content-between align-items-center mb-3">
                        <h5 class="text-right">Edit your profile</h5>
                    </div>
                    <div class="row mt-2">
                        <div class="col-md-12">
                            <label class="labels">Full name</label>
                            <input type="text" class="form-control" name="fullName" placeholder="Full name" value="${sessionScope.USER_SESSION.fullName}">
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-12">
                            <label class="labels">Email</label>
                            <input type="text" class="form-control" name="email" placeholder="Email" value="${sessionScope.USER_SESSION.email}">
                        </div>
                        <div class="col-md-12">
                            <label class="labels">Birthday</label>
                            <input type="date" class="form-control" name="birthday" placeholder="Birthday" value="${sessionScope.USER_SESSION.birthday}">
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-6">
                            <label class="labels">Phone</label>
                            <input type="text" class="form-control" name="phone" placeholder="Your phone" value="${sessionScope.USER_SESSION.phone}">
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-6">
                            <label for="username" class="form-label">Username</label>
                            <input type="text" class="form-control" id="username" name="username" placeholder="Username"
                                   value="${sessionScope.USER_SESSION.username}" readonly>
                        </div>
                        <div class="col-md-6">
                            <label for="password" class="form-label">Password</label>
                            <input type="password" class="form-control" id="password" placeholder="Password"
                                   name="password" value="${sessionScope.USER_SESSION.password}">
                        </div>
                    </div>
                    <br>
                    <c:if test="${not empty responseEntity}">
                        <c:if test="${responseEntity.httpStatus == 'OK'}">
                            <div class="alert alert-success" role="alert">
                                <c:out value="${responseEntity.message}"/>
                            </div>
                        </c:if>
                        <c:if test="${responseEntity.httpStatus != 'OK'}">
                            <div class="alert alert-danger" role="alert">
                                <c:out value="${responseEntity.message}"/>
                            </div>
                        </c:if>

                    </c:if>
                    <c:if test="${not empty param['message']}">
                        <div class="alert alert-success" role="alert">
                            <c:out value="${param['message']}"/>
                        </div>
                    </c:if>
                    <div class="mt-5 text-center">
                        <button class="btn btn-primary profile-button" type="submit">Save Profile</button>
                    </div>
                </div>
            </form>
            <div class="col-md-4">
                <div class="p-3 py-5">
                    <div class="d-flex justify-content-between align-items-center experience">
                        <span>Edit Experience</span><span class="border px-3 p-1 add-experience"><i
                            class="fa fa-plus"></i>&nbsp;Experience</span></div>
                    <div class="d-flex flex-row mt-3 exp-container"><img
                            src="https://eitrawmaterials.eu/wp-content/uploads/2016/07/twitter.png" width="45"
                            height="45">
                        <div class="work-experience ml-1"><span class="font-weight-bold d-block"></span><span
                                class="d-block text-black-50 labels">Twitter Inc.</span>
                        </div>
                    </div>
                    <hr>
                    <div class="d-flex flex-row mt-3 exp-container"><img
                            src="https://img.icons8.com/color/100/000000/facebook.png" width="45" height="45">
                        <div class="work-experience ml-1"><span class="font-weight-bold d-block"></span><span
                                class="d-block text-black-50 labels">Facebook Inc.</span></div>
                    </div>
                    <hr>
                    <div class="d-flex flex-row mt-3 exp-container"><img
                            src="https://img.icons8.com/color/50/000000/google-logo.png" width="45" height="45">
                        <div class="work-experience ml-1"><span class="font-weight-bold d-block"></span><span
                                class="d-block text-black-50 labels">Google Inc.</span></div>
                    </div>
                </div>
            </div>
        </div>
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


<!-- Footer -->
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

<script src="resources/js/custom.js"></script>
<script src="resources/js/main.js"></script>
<script src="resources/js/main.min.js"></script>
<script src="resources/js/scripts.min.js"></script>
</html>
