<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Virtual learning | Edit lesson</title>
    <link rel="stylesheet" type="text/css" href="../resources/styles/bootstrap4/bootstrap.min.css">
    <link href="../resources/plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="../resources/plugins/OwlCarousel2-2.2.1/owl.carousel.css">
    <link rel="stylesheet" type="text/css" href="../resources/plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
    <link rel="stylesheet" type="text/css" href="../resources/plugins/OwlCarousel2-2.2.1/animate.css">
    <link rel="stylesheet" type="text/css" href="../resources/styles/main_styles.css">
    <link rel="stylesheet" type="text/css" href="../resources/styles/responsive.css">

    <link rel="stylesheet" type="text/css" href="../resources/styles/util.css">
    <link rel="stylesheet" type="text/css" href="../resources/styles/main_1.css">
    <link rel="stylesheet" type="text/css" href="../resources/styles/main.css">
</head>

<body>
<div class="super_container">

    <!-- Header -->
    <header class="header">
        <%@include file="/common/header.jsp" %>
    </header>

    <!-- Menu -->
    <div class="menu d-flex flex-column align-items-end justify-content-start text-right menu_mm trans_400">
        <div class="menu_close_container">
            <div class="menu_close">
                <div></div>
                <div></div>
            </div>
        </div>
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
    <div class="section_background parallax-window" data-parallax="scroll"
         data-image-src="../resources/images/courses_background.jpg" data-speed="0.8"></div>
    <div class="topic-of-page">
        <h3 class="h">Edit lesson</h3>
    </div>

    <!--Form add class-->
    <form class="login100-form validate-form edit-form">
            <span class="login100-form-title p-b-43">
                <div class="text-center">
                    <h1>Editing lesson form</h1>
                    <p>This is the section editings that you want to change</p>   
                </div>
            </span>


        <div class="wrap-input100 validate-input" data-validate="Name of class is required">
            <input class="input100 has-val" type="text" name="name" value="${lesson.title}">
            <span class="focus-input100"></span>
            <span class="label-input100">Title</span>
        </div>

        <div class="wrap-input100 validate-input description" data-validate="Description is required">
            <textarea class="input100 has-val" type="text" name="text">${lesson.description}</textarea>
            <span class="focus-input100"></span>
            <span class="label-input100">Description</span>
        </div>

        <div class="text-center">
            <b>Edit link video</b>
            <textarea id="editLink">${lesson.video}</textarea>
        </div>

        <h3 class="text-center" style="margin-bottom: 20px; margin-top: 50px;">Question?</h3>
        <div class="question-form-container">
            <c:forEach items="${lesson.questions}" var="question">
                <div class="text-center edit-question-form" id="question-overview-${question.id}">
                    <button type="button" class="join-button join-button-edit font-weight-bold" data-toggle="modal"
                            data-target="#question" style="width: 79% !important;"
                            onclick="getQuestionById(${question.id});">
                        Question
                    </button>
                    <button type="button" class="join-button join-button-edit font-weight-bold deleteButton"
                            data-toggle="modal" data-target="#delete" style="width: 20% !important;"
                            onclick="deleteQuestion('question-overview-${question.id}')">
                        Delete
                    </button>
                </div>
            </c:forEach>
        </div>

        <%--        <div class="question-form-container">--%>
        <%--            <div class="text-center edit-question-form">--%>
        <%--                <button type="button" class="join-button join-button-edit font-weight-bold" data-toggle="modal"--%>
        <%--                        data-target="#question" style="width: 79% !important;" onclick="getQuestionById(1);">--%>
        <%--                    Question--%>
        <%--                </button>--%>
        <%--                <button type="button" class="join-button join-button-edit font-weight-bold deleteButton"--%>
        <%--                        data-toggle="modal" data-target="#delete" style="width: 20% !important;">--%>
        <%--                    Delete--%>
        <%--                </button>--%>
        <%--            </div>--%>
        <%--        </div>--%>

        <div class="text-center">
            <button type="button" class="join-button join-button-edit font-weight-bold addQuestion"
                    data-toggle="modal"
                    data-target="#question"
                    onclick="getQuestionById();">
                Add question
            </button>
        </div>

        <!-- Modal - question-->
        <div class="modal fade" id="question" tabindex="-1" role="dialog" aria-labelledby="questionTitle"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="questionTitle"><b>Complete your question</b></h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="question-content">
                            <label>Type the question:</label>
                            <textarea class="question-input" id="question-input"></textarea>
                            <label class="answer-header">Type content for Answer <i>A</i></label>
                            <textarea class="answer-input" id="answer-input-a"></textarea>
                            <label class="answer-header">Type content for Answer <i>B</i></label>
                            <textarea class="answer-input" id="answer-input-b"></textarea>
                            <label class="answer-header">Type content for Answer <i>C</i></label>
                            <textarea class="answer-input" id="answer-input-c"></textarea>
                            <label class="answer-header">Type content for Answer <i>D</i></label>
                            <textarea class="answer-input" id="answer-input-d"></textarea>
                            <label class="answer-header">Please select the correct answer:</label>
                            <div class="correct-answer">
                                <input name="correct" type="radio"> <b>A</b>
                            </div>
                            <div class="correct-answer">
                                <input name="correct" type="radio"> <b>B</b>
                            </div>
                            <div class="correct-answer">
                                <input name="correct" type="radio"> <b>C</b>
                            </div>
                            <div class="correct-answer">
                                <input name="correct" type="radio"> <b>D</b>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="saveChangeAddQuestion();">Save changes</button>
                    </div>
                </div>
            </div>
        </div>
        <!--End modal-->
    </form>
</div>

<!--join button-->
<div class="text-center">
    <a href="#" class="a-join-button">
        <button class="join-button">
            <b>Apply</b>
        </button>
    </a>
</div>

</body>

<!-- Footer-->
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
<script src="../resources/js/edit-lesson-teacher.js"></script>
<script src="../resources/js/main.js"></script>

</html>